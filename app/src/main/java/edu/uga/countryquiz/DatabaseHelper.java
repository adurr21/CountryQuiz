package edu.uga.countryquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
    DatabaseHelper creates the database with the needed tables if one does not exist, and
    controls all needed operations with the sqlite database.

    Extends: https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper
 */
public class DatabaseHelper extends SQLiteOpenHelper {
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
    public static final String QUIZZES_COLUMN_ID = "_id";
    public static final String QUIZZES_Q1_QUESTION = "q1_q";
    public static final String QUIZZES_Q2_QUESTION = "q2_q";
    public static final String QUIZZES_Q3_QUESTION = "q3_q";
    public static final String QUIZZES_Q4_QUESTION = "q4_q";
    public static final String QUIZZES_Q5_QUESTION = "q5_q";
    public static final String QUIZZES_Q6_QUESTION = "q6_q";
    public static final String QUIZZES_Q1_ANSWERS = "q1_a";
    public static final String QUIZZES_Q2_ANSWERS = "q2_a";
    public static final String QUIZZES_Q3_ANSWERS = "q3_a";
    public static final String QUIZZES_Q4_ANSWERS = "q4_a";
    public static final String QUIZZES_Q5_ANSWERS = "q5_a";
    public static final String QUIZZES_Q6_ANSWERS = "q6_a";
    public static final String QUIZZES_Q1_CORRECT_ANSWERS = "q1_ca";
    public static final String QUIZZES_Q2_CORRECT_ANSWERS = "q2_ca";
    public static final String QUIZZES_Q3_CORRECT_ANSWERS = "q3_ca";
    public static final String QUIZZES_Q4_CORRECT_ANSWERS = "q4_ca";
    public static final String QUIZZES_Q5_CORRECT_ANSWERS = "q5_ca";
    public static final String QUIZZES_Q6_CORRECT_ANSWERS = "q6_ca";


    private static final String CREATE_COUNTRY_TABLE = "CREATE TABLE " + COUNTRY_TABLE_NAME + "(" +
            COUNTRY_COLUMN_ID + " INTEGER PRIMARY KEY," +
            COUNTRY_COLUMN_NAME + " TEXT," +
            COUNTRY_COLUMN_CONTINENT + " TEXT)";

    private static final String CREATE_QUIZZES_TABLE = "CREATE TABLE " + QUIZZES_TABLE_NAME + "(" +
            QUIZZES_COLUMN_ID + " INTEGER PRIMARY KEY," +
            QUIZZES_Q1_QUESTION + " TEXT," +
            QUIZZES_Q1_ANSWERS + " TEXT," +
            QUIZZES_Q1_CORRECT_ANSWERS + " TEXT," +
            QUIZZES_Q2_QUESTION + " TEXT," +
            QUIZZES_Q2_ANSWERS + " TEXT," +
            QUIZZES_Q2_CORRECT_ANSWERS + " TEXT," +
            QUIZZES_Q3_QUESTION + " TEXT," +
            QUIZZES_Q3_ANSWERS + " TEXT," +
            QUIZZES_Q3_CORRECT_ANSWERS + " TEXT," +
            QUIZZES_Q4_QUESTION + " TEXT," +
            QUIZZES_Q4_ANSWERS + " TEXT," +
            QUIZZES_Q4_CORRECT_ANSWERS + " TEXT," +
            QUIZZES_Q5_QUESTION + " TEXT," +
            QUIZZES_Q5_ANSWERS + " TEXT," +
            QUIZZES_Q5_CORRECT_ANSWERS + " TEXT," +
            QUIZZES_Q6_QUESTION + " TEXT," +
            QUIZZES_Q6_ANSWERS + " TEXT," +
            QUIZZES_Q6_CORRECT_ANSWERS + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COUNTRY_TABLE);
        db.execSQL(CREATE_QUIZZES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QUIZZES_TABLE_NAME);
        onCreate(db);
    }
}
