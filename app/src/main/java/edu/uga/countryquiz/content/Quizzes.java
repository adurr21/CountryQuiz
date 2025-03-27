package edu.uga.countryquiz.content;

import java.util.List;

import edu.uga.countryquiz.MainActivity;

public class Quizzes {

    private static List<Quiz> quizzes;


    public static List<Quiz> getQuizzes() {
        quizzes = MainActivity.dbHelper.getPastQuizzes();
        return quizzes;
    }
}
