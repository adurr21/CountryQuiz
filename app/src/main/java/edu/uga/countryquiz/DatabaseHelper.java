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
import java.util.List;
import java.util.Locale;

import edu.uga.countryquiz.content.Quiz;

/*
    DatabaseHelper creates the database with the needed tables if one does not exist, and
    controls all needed operations with the sqlite database.

    Extends: https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance;
    private static final String DATABASE_NAME = "CountryQuiz.db";
    private static final int DATABASE_VERSION = 1;

    // Countries table
    public static final String COUNTRY_TABLE_NAME = "countries_continents";
    public static final String COUNTRY_COLUMN_ID = "_id";
    public static final String COUNTRY_COLUMN_NAME = "country_name";
    public static final String COUNTRY_COLUMN_CONTINENT = "country_continent";

    // Quizzes table
    // Stores each quiz question, a list of answer choices that were given,
    // and then the correct answer value, a comma, and then true or false
    // on if the user answered the question correctly or not.
    // Ex: america,true
    public static final String QUIZZES_TABLE_NAME = "quizzes";
    public static final String QUIZZES_DATE = "date";
    public static final String QUIZZES_SCORE = "score";


    private static final String CREATE_COUNTRY_TABLE = "CREATE TABLE " + COUNTRY_TABLE_NAME + "(" +
            COUNTRY_COLUMN_ID + " INTEGER," +
            COUNTRY_COLUMN_NAME + " TEXT PRIMARY KEY," +
            COUNTRY_COLUMN_CONTINENT + " TEXT)";

    private static final String CREATE_QUIZZES_TABLE = "CREATE TABLE " + QUIZZES_TABLE_NAME + "(" +
            QUIZZES_DATE + " TEXT," +
            QUIZZES_SCORE + " TEXT)";

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper: onCreate() called");
        new CreateDBAsync().execute(db);
    }

    private void initializeDatabase(SQLiteDatabase db) {
        Log.d(MainActivity.LOG_TAG, "DatabaseHelper: initializeDatabase() called");
        db.execSQL(CREATE_COUNTRY_TABLE);
        db.execSQL(CREATE_QUIZZES_TABLE);
        try {
            InputStreamReader isr = new InputStreamReader(MainActivity.assetManager.open("country_continent.csv"));
            CSVReader csvReader = new CSVReader(isr);

            //String[] headers = csvReader.readNext(); // Skip header row if it exists

            String[] row;
            int count = 0;
            while ((row = csvReader.readNext()) != null) {
                ContentValues values = new ContentValues();

                // All values stored as Strings
                values.put(DatabaseHelper.COUNTRY_COLUMN_ID, count++);
                values.put(DatabaseHelper.COUNTRY_COLUMN_NAME, row[0]);
                values.put(DatabaseHelper.COUNTRY_COLUMN_CONTINENT, row[1]);

                db.insert(DatabaseHelper.COUNTRY_TABLE_NAME, null, values);
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } finally {
            //db.close();
        }
    }

    private class CreateDBAsync extends AsyncTask<SQLiteDatabase, Void> {

        @Override
        protected Void doInBackground(SQLiteDatabase... arguments) {
            initializeDatabase(arguments[0]);
            Void voidVar = null;
            return voidVar;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Log.d(MainActivity.LOG_TAG, "DatabaseHelper: CreateDBAsync() - onPostExecute() called");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QUIZZES_TABLE_NAME);
        onCreate(db);
    }


    /**
     * Gets a random entry from the countries database table and returns the result.
     * @return String[3] The database row. String[0] is the unique ID, [1] is the country name, [2] is the continent.
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
            id = db.insertOrThrow(QUIZZES_TABLE_NAME,
                    null,
                    content);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Log.d(MainActivity.LOG_TAG, "storeQuizResult() - Date: " + dateString +
                " | Score: " + q.score + " | saved to table with id: " + id);
    }

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
                    quizzes.add(new Quiz(stringDate,score));
                } while (cursor.moveToNext());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
            //db.close();
        }
        return quizzes;
    }

    private class StoreQuizAsync extends AsyncTask<Quiz,Void> {

        @Override
        protected Void doInBackground(Quiz... arguments) {
            storeQuizResults(arguments[0]);
            Void voidVar = null;
            return voidVar;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Log.d(MainActivity.LOG_TAG, "onPostExecute - StoreQuizAsync");
        }
    }

    public void storeQuizResult(Quiz q) {
        new StoreQuizAsync().execute(q);
    }

}
