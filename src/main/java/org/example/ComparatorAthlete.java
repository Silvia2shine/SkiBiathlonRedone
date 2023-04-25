package org.example;

import java.util.Comparator;

/**
 * This is a class that implements the Comparator class.
 */
public class ComparatorAthlete implements Comparator<Athlete> {
    /**
     * This is a method that override the compare method.
     *
     * @param o1 – the first object to be compared;
     * @param o2 – the second object to be compared;
     */
    @Override
    public int compare(Athlete o1, Athlete o2) {

            if (o1.finalResultInSeconds < o2.finalResultInSeconds) {
                return -1;
            } else if (o1.finalResultInSeconds > o2.finalResultInSeconds) {
                return 1;
            } else {
                return 0;
            }
        }
    }

