package edu.uga.countryquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import edu.uga.countryquiz.content.Quiz;

/**
 * Manages the SQLite database for the Country Quiz application. Creates and initializes
 * tables for countries and quizzes, and provides methods for database operations.
 * Extends {@link SQLiteOpenHelper} for database creation and version management.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Singleton instance of DatabaseHelper
    private static DatabaseHelper instance;
    private static final String DATABASE_NAME = "CountryQuiz.db";
    private static final int DATABASE_VERSION = 1;

    // Countries table constants
    public static final String COUNTRY_TABLE_NAME = "countries_continents";
    public static final String COUNTRY_COLUMN_ID = "_id";
    public static final String COUNTRY_COLUMN_NAME = "country_name";
    public static final String COUNTRY_COLUMN_CONTINENT = "country_continent";

    // Quizzes table constants
    public static final String QUIZZES_TABLE_NAME = "quizzes";
    public static final String QUIZZES_DATE = "date";
    public static final String QUIZZES_SCORE = "score";

    // SQL statement to create the countries table
    private static final String CREATE_COUNTRY_TABLE = "CREATE TABLE " + COUNTRY_TABLE_NAME + "(" +
            COUNTRY_COLUMN_ID + " INTEGER," +
            COUNTRY_COLUMN_NAME + " TEXT PRIMARY KEY," +
            COUNTRY_COLUMN_CONTINENT + " TEXT)";

    // SQL statement to create the quizzes table
    private static final String CREATE_QUIZZES_TABLE = "CREATE TABLE " + QUIZZES_TABLE_NAME + "(" +
            QUIZZES_DATE + " TEXT," +
            QUIZZES_SCORE + " TEXT)";

    /**
     * Private constructor for singleton pattern.
     *
     * @param context the context used to create the database
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Returns the singleton instance of DatabaseHelper.
     *
     * @param context the context used to create the instance if it doesn't exist
     * @return the singleton DatabaseHelper instance
     */
    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    /**
     * Called when the database is created for the first time. Executes database initialization
     * asynchronously.
     *
     * @param db the database being created
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper: onCreate() called");
        new CreateDBAsync().execute(db);
    }

    /**
     * Initializes the database by creating tables and populating the countries table
     * with data from a CSV file.
     *
     * @param db the database to initialize
     */
    private void initializeDatabase(SQLiteDatabase db) {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper: initializeDatabase() called");
        db.execSQL(CREATE_COUNTRY_TABLE);
        db.execSQL(CREATE_QUIZZES_TABLE);
        try {
            InputStreamReader isr = new InputStreamReader(MainActivity.assetManager.open("country_continent.csv"));
            CSVReader csvReader = new CSVReader(isr);

            String[] row;
            int count = 0;
            while ((row = csvReader.readNext()) != null) {
                ContentValues values = new ContentValues();
                values.put(COUNTRY_COLUMN_ID, count++);
                values.put(COUNTRY_COLUMN_NAME, row[0]);
                values.put(COUNTRY_COLUMN_CONTINENT, row[1]);
                db.insert(COUNTRY_TABLE_NAME, null, values);
            }
            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Asynchronous task to create and initialize the database in the background.
     */
    private class CreateDBAsync extends AsyncTask<SQLiteDatabase, Void> {
        @Override
        protected Void doInBackground(SQLiteDatabase... arguments) {
            initializeDatabase(arguments[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Log.d(MainActivity.LOG_TAG, "DatabaseHelper: CreateDBAsync() - onPostExecute() called");
        }
    }

    /**
     * Called when the database needs to be upgraded. Drops existing tables and recreates them.
     *
     * @param db         the database to upgrade
     * @param oldVersion the old database version
     * @param newVersion the new database version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QUIZZES_TABLE_NAME);
        onCreate(db);
    }

    /**
     * Retrieves a random country entry from the countries table.
     *
     * @return a String array with [0] = ID, [1] = country name, [2] = continent
     */
    public String[] getQuizQuestion() {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper.class - getQuizQuestion() called");
        SQLiteDatabase db = this.getReadableDatabase();
        String[] randomResult = null;

        String query = "SELECT * FROM " + COUNTRY_TABLE_NAME + " ORDER BY RANDOM() LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        try {
            if (cursor.moveToFirst()) {
                randomResult = new String[3];
                randomResult[0] = cursor.getString(cursor.getColumnIndexOrThrow(COUNTRY_COLUMN_ID));
                randomResult[1] = cursor.getString(cursor.getColumnIndexOrThrow(COUNTRY_COLUMN_NAME));
                randomResult[2] = cursor.getString(cursor.getColumnIndexOrThrow(COUNTRY_COLUMN_CONTINENT));
                Log.d(MainActivity.LOG_TAG, "getQuizQuestion(), Random ID: " + randomResult[0]);
                Log.d(MainActivity.LOG_TAG, "getQuizQuestion(), Random Country: " + randomResult[1]);
                Log.d(MainActivity.LOG_TAG, "getQuizQuestion(), Random Continent: " + randomResult[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return randomResult;
    }

    /**
     * Stores the results of a quiz in the quizzes table.
     *
     * @param q the Quiz object containing the results to store
     */
    public void storeQuizResults(Quiz q) {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper.class - storeQuizResult() called");
        SQLiteDatabase db = this.getWritableDatabase();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault());
        String dateString = dateFormat.format(q.date);

        ContentValues content = new ContentValues();
        content.put(QUIZZES_DATE, dateString);
        content.put(QUIZZES_SCORE, q.score);

        long id = -1;
        try {
            id = db.insertOrThrow(QUIZZES_TABLE_NAME, null, content);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log.d(MainActivity.LOG_TAG, "storeQuizResult() - Date: " + dateString +
                " | Score: " + q.score + " | saved to table with id: " + id);
    }

    /**
     * Retrieves all past quizzes from the quizzes table.
     *
     * @return an ArrayList of Quiz objects representing past quizzes
     */
    public ArrayList<Quiz> getPastQuizzes() {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper - getPastQuizzes() called");
        ArrayList<Quiz> quizzes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + QUIZZES_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        try {
            if (cursor.moveToFirst()) {
                do {
                    String stringDate = cursor.getString(cursor.getColumnIndexOrThrow(QUIZZES_DATE));
                    String score = cursor.getString(cursor.getColumnIndexOrThrow(QUIZZES_SCORE));
                    Log.d(MainActivity.LOG_TAG, "stringDate: " + stringDate);
                    Log.d(MainActivity.LOG_TAG, "score: " + score);
                    quizzes.add(new Quiz(stringDate, score));
                } while (cursor.moveToNext());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return quizzes;
    }

    /**
     * Asynchronous task to store quiz results in the background.
     */
    private class StoreQuizAsync extends AsyncTask<Quiz, Void> {
        @Override
        protected Void doInBackground(Quiz... arguments) {
            storeQuizResults(arguments[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Log.d(MainActivity.LOG_TAG, "onPostExecute - StoreQuizAsync");
        }
    }

    /**
     * Asynchronously stores quiz results using StoreQuizAsync.
     *
     * @param q the Quiz object to store
     */
    public void storeQuizResult(Quiz q) {
        new StoreQuizAsync().execute(q);
    }
}