package edu.uga.countryquiz.content;

import static java.lang.Double.parseDouble;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashSet;
import java.io.Serializable;

public class Quiz implements Serializable {

    public QuizQuestion[] quizQuestions;
    public double score;
    public Date date;
    public int questionsAnswered;

    public String stringDate;


    /**
     * Constructs a new Quiz object with 6 unique quiz questions.
     * Initializes an array of QuizQuestion objects, ensuring no duplicate question IDs
     * using a HashSet. Sets initial score to 0.00 and records the creation date.
     */
    public Quiz() {
        // HashSet to track unique question IDs
        HashSet<String> set = new HashSet<>();

        // Initialize array to hold 6 quiz questions
        quizQuestions = new QuizQuestion[6];

        // Populate array with unique quiz questions
        for (int i = 0; i < 6; i++) {
            quizQuestions[i] = new QuizQuestion();
            // If question ID is not unique (add returns false), decrement i to retry
            if (set.add(quizQuestions[i].id) == false) {
                i--;
            }
        }

        // Initialize score to zero
        score = 0.00;

        // Set creation date to current date/time
        date = new Date();

        // Initialize counter for answered questions
        questionsAnswered = 0;
    }

    /**
     * Constructs a Quiz object for loading past quizzes from the database,
     * specifically for use within a RecyclerViewAdapter. This constructor
     * initializes minimal quiz data without quiz questions.
     *
     * @param date  the date of the quiz as a String
     * @param score the score of the quiz as a String, to be converted to a percentage
     */
    // This constructor should only be used when loading past quizzes from the database
    // to use inside of the RecyclerViewAdapter.
    public Quiz(String date, String score) {
        // Set quizQuestions to null as questions aren't loaded
        quizQuestions = null;

        // Set questionsAnswered to invalid value as no questions are present
        questionsAnswered = -1;

        // Create formatter to ensure two decimal places
        DecimalFormat formatter = new DecimalFormat("##");

        // Convert score to double, multiply by 100 for percentage, format, and store
        this.score = Double.parseDouble(formatter.format(parseDouble(score) * 100));

        // Store the date as a string
        this.stringDate = date;
    }
}
