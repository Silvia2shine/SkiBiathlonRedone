package org.example;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @org.junit.jupiter.api.Test
    void calculatorPenalties() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        int penalty = athlete1.calculatorPenalties(athlete1.firstShooting);

        assertEquals(10,penalty );
    }

    @org.junit.jupiter.api.Test
    void transformSkiTimeResultInSec() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        int time = athlete1.transformSkiTimeResultInSec(athlete1.skiTimeResult);

        assertEquals(1827,time );
    }

    @org.junit.jupiter.api.Test
    void calculateTheFinalResultInSeconds() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        int calculate = athlete1.calculateTheFinalResultInSeconds();

        assertEquals(1857,calculate );
    }

    @org.junit.jupiter.api.Test
    void transformFinalResultMInAndSec() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        String transform = athlete1.transformFinalResultMInAndSec(1800);

        assertEquals("30:00",transform );
    }

    @org.junit.jupiter.api.Test
    void createAthleteFromCSV() throws ValidationException {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");

        String line = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String[] tokensWord = line.split(",");

        assertEquals(new Athlete(11,"Umar Jorgson","SK",
                "30:27",",xxxox","xxxxx", "xxoxo"),
                athlete1.createAthleteFromCSV(tokensWord));
    }
}