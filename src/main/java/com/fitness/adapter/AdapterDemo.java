package com.fitness.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        FitnessBand band = new FitnessBand();
        FitnessTrackerApp app = new FitnessBandAdapter(band);

        System.out.println("Converted Steps: " + app.getSteps());
        System.out.println("Converted Calories: " + app.getCalories());
    }
}