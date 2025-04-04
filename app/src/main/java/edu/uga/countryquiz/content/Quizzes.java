package edu.uga.countryquiz.content;

import java.util.List;
import edu.uga.countryquiz.MainActivity;

/**
 * Manages a collection of Quiz objects, providing access to past quizzes stored
 * in the application's database. This class serves as a utility for retrieving
 * quiz data.
 */
public class Quizzes {

    // Static list to hold quiz objects retrieved from database
    private static List<Quiz> quizzes;

    /**
     * Retrieves the list of past quizzes from the database via MainActivity's
     * database helper. Updates the internal quizzes list and returns it.
     *
     * @return List of Quiz objects representing past quizzes
     */
    public static List<Quiz> getQuizzes() {
        // Fetch past quizzes from database using MainActivity's dbHelper
        quizzes = MainActivity.dbHelper.getPastQuizzes();
        // Return the updated list of quizzes
        return quizzes;
    }
}