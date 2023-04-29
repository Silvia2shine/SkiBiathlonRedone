package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
    void transformerForSkiTimeResultInSec() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        int time = athlete1.transformerForSkiTimeResultInSec(athlete1.skiTimeResult);

        assertEquals(1827,time );
    }

    @org.junit.jupiter.api.Test
    void calculatorForTheFinalResultInSeconds() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        int result = athlete1.calculatorTheFinalResultInSeconds();

        assertEquals(1857,result );
    }

    @org.junit.jupiter.api.Test
    void transformerForFinalResultMInAndSec() {
        Athlete athlete1 = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        String transform = athlete1.transformerFinalResultMInAndSec(1800);

        assertEquals("30:00",transform );
    }

    @org.junit.jupiter.api.Test
    void createrAndOrdererFORAthlete() throws ValidationException {
        Map<Integer, String> athleteMap = new TreeMap<>();
        Athlete athlete = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");

        String line1 = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        String[] tokensWord1 = line1.split(",");
        athlete.createrForAthlete(tokensWord1);

        athleteMap.put(athlete.finalResultInSeconds,athlete.athleteName);


        String line2 = "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo";
        String[] tokensWord2 = line2.split(",");
        athlete.createrForAthlete(tokensWord2);

        athleteMap.put(athlete.finalResultInSeconds,athlete.athleteName);

        String line3 = "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        String[] tokensWord3 = line3.split(",");
        athlete.createrForAthlete(tokensWord3);

        athleteMap.put(athlete.finalResultInSeconds,athlete.athleteName);

        Map<Integer, String> expectedMap = new HashMap<>();
        expectedMap.put(1810, "Piotr Smitzer");
        expectedMap.put(1815, "Jimmy Smiles");
        expectedMap.put(1857, "Umar Jorgson");
        assertEquals(expectedMap,athleteMap );
    }
}