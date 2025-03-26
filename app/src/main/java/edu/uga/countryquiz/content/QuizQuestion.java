package edu.uga.countryquiz.content;

import java.util.Random;

import edu.uga.countryquiz.MainActivity;

public class QuizQuestion {

    public String id;
    public String countryName;
    public String correctContinent;
    public String wrongContinentOne = null;
    public String wrongContinentTwo = null;

    QuizQuestion() {
        String[] continents = {
                "North America",
                "South America",
                "Europe",
                "Oceania",
                "Africa",
                "Asia"
        };
        String[] result = MainActivity.dbHelper.getQuizQuestion();
        this.id = result[0];
        this.countryName = result[1];
        this.correctContinent = result[2];
        Random rand = new Random();
        while (wrongContinentOne == null) {
            int num = rand.nextInt(6);
            if (continents[num].equals(this.correctContinent)) {
                continue;
            } else {
                wrongContinentOne = continents[num];
            }
        }

        while (wrongContinentTwo == null) {
            int num = rand.nextInt(6);
            if (continents[num].equals(this.correctContinent) || continents[num].equals(this.wrongContinentOne)) {
                continue;
            } else {
                wrongContinentTwo = continents[num];
            }
        }

    }
}
