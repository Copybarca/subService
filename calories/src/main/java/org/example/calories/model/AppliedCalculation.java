package org.example.calories.model;

public class AppliedCalculation {
    public static double BenedictHarrisCalculation(int weight, int height, int age){
        return 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
    }
}
