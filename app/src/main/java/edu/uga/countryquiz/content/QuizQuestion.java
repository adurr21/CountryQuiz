package edu.uga.countryquiz.content;

import java.io.Serializable;
import java.util.Random;

import edu.uga.countryquiz.MainActivity;

/**
 * Represents a single quiz question about a country and its continent.
 * Each question includes a country name, its correct continent, and two
 * incorrect continent options.
 */
public class QuizQuestion implements Serializable{

    // Unique identifier for the question
    public String id;
    // Name of the country for the quiz question
    public String countryName;
    // Correct continent for the country
    public String correctContinent;
    // First incorrect continent option, initially null
    public String wrongContinentOne = null;
    // Second incorrect continent option, initially null
    public String wrongContinentTwo = null;

    /**
     * Constructs a new QuizQuestion by retrieving country data from the database
     * and generating two unique incorrect continent options.
     */
    QuizQuestion() {
        // Array of all possible continents
        String[] continents = {
                "North America",
                "South America",
                "Europe",
                "Oceania",
                "Africa",
                "Asia"
        };

        // Get country data from database: [id, countryName, correctContinent]
        String[] result = MainActivity.dbHelper.getQuizQuestion();
        this.id = result[0];
        this.countryName = result[1];
        this.correctContinent = result[2];

        // Random number generator for selecting wrong answers
        Random rand = new Random();

        // Select first wrong continent, ensuring it's different from correct answer
        while (wrongContinentOne == null) {
            int num = rand.nextInt(6);
            if (continents[num].equals(this.correctContinent)) {
                continue;
            } else {
                wrongContinentOne = continents[num];
            }
        }

        // Select second wrong continent, ensuring it's different from both
        // correct answer and first wrong answer
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