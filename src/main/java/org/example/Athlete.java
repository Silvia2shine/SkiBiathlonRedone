package org.example;

public class Athlete {
    int athleteNumber;
    String athleteName;
    String countryCode;
    String skiTimeResult;  //(Minutes:Seconds)
    String firstShooting;
    String secondShooting;
    String thirdShooting;
    int finalResultInSeconds = 0;

    public Athlete(int athleteNumber, String athleteName,
                   String countryCode, String skiTimeResult,
                   String firstShooting, String secondShooting,
                   String thirdShooting) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    @Override
    public String toString() {
        return  athleteNumber + " , " + athleteName + " , " + countryCode + " , " +
                skiTimeResult + " , " + firstShooting + " , " + secondShooting + " , " +
                thirdShooting;
    }
    /**
     * A  method that counts the shoots ;
     *
     * @param - count;
     * @param - shoot;
     */
    public int calculatorPenalties(String initial)  {
        int count = 0;

        char[] shoot = initial.toCharArray();
        for(
                int i = 0;
                i<shoot.length;i++)

        {
            if (shoot[i] == 'o') {
                count += 10;
            }
        }
        return count;
    }
    /**
     * A  method that transform the score read from the file, in seconds;
     *
     * @param - minSec;
     * @param - minInSec;
     * @param - sec;
     * @param - resultInSec;
     */
    public int transformSkiTimeResultInSec(String resultRead)  {

        int resultInSec = 0;

        String[] minSec = resultRead.split(":");
        int minInSec = Integer.parseInt(minSec[0]) * 60;
        int sec = Integer.parseInt(minSec[1]);
        resultInSec = (minInSec + sec);

        return resultInSec;
    }
    public int calculateTheFinalResultInSeconds()  {

        finalResultInSeconds = transformSkiTimeResultInSec(skiTimeResult) +
                calculatorPenalties(firstShooting) +
                calculatorPenalties(secondShooting) +
                calculatorPenalties(thirdShooting);

        return finalResultInSeconds;
    }
    public String transformFinalResultMInAndSec(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        if (seconds >= 60) {
            seconds = totalSeconds - 60;
            minutes = minutes + 1;
        }
        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        return formattedTime;
    }

    public int getFinalResultInSeconds() {
        return finalResultInSeconds;
    }
    public Athlete createAthleteFromCSV(String[] tokensWord) throws ValidationException {

        for (int i = 0; i < tokensWord.length; i++) {

            if (tokensWord == null)  {
                throw new ValidationException("The filed is null");
            }
            if (tokensWord[0] == null || tokensWord[0].equalsIgnoreCase("")) {
                throw new ValidationException("The athlete number can't be smaller than 1.");
            }
            if (tokensWord[1] == null || tokensWord[1].equalsIgnoreCase("")) {
                throw new ValidationException("The athlete name can't null.");
            }
            if (tokensWord[2] == null || tokensWord[2].equalsIgnoreCase("")) {
                throw new ValidationException("The country code can't be null.");
            }
            if (tokensWord[3] == null || tokensWord[3].equalsIgnoreCase("")) {
                throw new ValidationException("The time result can't be null.");
            }
            if (tokensWord[4] == null || tokensWord[4].equalsIgnoreCase("")) {
                throw new ValidationException("The first shooting can't be null.");
            }
            if (tokensWord[5] == null || tokensWord[5].equalsIgnoreCase("")) {
                throw new ValidationException("The second shooting can't be null.");
            }
            if (tokensWord[6] == null || tokensWord[6].equalsIgnoreCase("")) {
                throw new ValidationException("The third shooting can't be null.");
            }
            if (tokensWord.length != 7) {
                throw new IndexOutOfBoundsException("The fields are not completed.");
            }

            athleteNumber = Integer.parseInt(tokensWord[0]);
            athleteName = tokensWord[1];
            countryCode = tokensWord[2];
            skiTimeResult = tokensWord[3];
            firstShooting = tokensWord[4];
            secondShooting = tokensWord[5];
            thirdShooting = tokensWord[6];
        }
        System.out.println("Athlete: " + athleteName);
        System.out.println("First penalty: " + calculatorPenalties(tokensWord[4]));
        System.out.println("Second penalty: " + calculatorPenalties(tokensWord[5]));
        System.out.println("Third penalty: " + calculatorPenalties(tokensWord[6]));
        finalResultInSeconds = calculateTheFinalResultInSeconds();
        System.out.println("Final result in seconds: "
                + finalResultInSeconds);
        System.out.println("Final result in min/sec: "
                + transformFinalResultMInAndSec(finalResultInSeconds));
        System.out.println();
        Athlete athlete = new Athlete(athleteNumber,athleteName,countryCode,
                skiTimeResult,firstShooting, secondShooting,thirdShooting);
        return athlete;
    }
}
