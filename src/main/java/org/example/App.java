package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map<Integer, String> athleteMap = new TreeMap<>();

        Athlete athlete = new Athlete(99,
                "Umar Jorgson", "SK", "30:27", ",xxxox",
                "xxxxx", "xxoxo");
        Biathlon biathlon = new Biathlon();

        ReadSaveAndSplitCSV reader = new ReadSaveAndSplitCSV();
        System.out.println(reader.readAndSaveCSV());
        System.out.println();

        String[] line = reader.splitIntoLines(reader.readAndSaveCSV());
        for (int i = 0; i < line.length; i++) {
            String[] words = reader.splitIntoWords(line[i]);
            try {
                athlete.createAthleteFromCSV(words);
                athleteMap.put(athlete.finalResultInSeconds, athlete.athleteName);
//                biathlon.addAthlete(athlete);
            } catch (ValidationException e) {
                System.out.println("The athlete read is not valid");
            }

        }
//biathlon.listAthletesByFinalStandingOrder(biathlon.athleteList);
        System.out.println("The map is: " + athleteMap);


        Integer[] keysArray = new Integer[athleteMap.size()];

        int index = 0;
        for (Integer key : athleteMap.keySet()) {
            keysArray[index] = key;
            index++;
        }
        System.out.println(Arrays.toString(keysArray));
        index = 0;
        for (Ranking ranking : Ranking.values()) {
            System.out.println(ranking + " - " + athleteMap.get(keysArray[index]) +
                    " " + athlete.transformFinalResultMInAndSec(keysArray[index]));
            index++;
        }

    }
}



