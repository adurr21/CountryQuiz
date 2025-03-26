package edu.uga.countryquiz.content;

import java.util.Date;
import java.util.HashSet;

public class Quiz {

    public QuizQuestion[] quizQuestions;
    public double score;
    public Date date;
    public int questionsAnswered;


    Quiz() {
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
}
