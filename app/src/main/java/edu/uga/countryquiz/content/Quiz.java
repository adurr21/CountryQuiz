package edu.uga.countryquiz.content;

import static java.lang.Double.parseDouble;

import android.icu.number.NumberFormatter;

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

    public Quiz() {
        HashSet<String> set = new HashSet<>();
        quizQuestions = new QuizQuestion[6];
        for (int i = 0; i < 6; i++) {
            quizQuestions[i] = new QuizQuestion();
            if (set.add(quizQuestions[i].id) == false) {
                i--;
            }
        }
        score = 0.00;
        date = new Date();
        questionsAnswered = 0;
    }

    // This constructor should only be used when loading past quizzes from the database
    // to use inside of the RecyclerViewAdapter.
    public Quiz(String date, String score) {
        quizQuestions = null;
        questionsAnswered = -1;

        DecimalFormat formatter = new DecimalFormat("##");
        this.score = Double.parseDouble(formatter.format(parseDouble(score) * 100));
        this.stringDate = date;
    }
}
