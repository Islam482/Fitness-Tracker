package com.fitness.adapter;

public class FitnessBandAdapter implements FitnessTrackerApp {
    private FitnessBand fitnessBand;

    public FitnessBandAdapter(FitnessBand fitnessBand) {
        this.fitnessBand = fitnessBand;
    }

    @Override
    public int getSteps() {
        String rawData = fitnessBand.getBandData();
        String stepsString = rawData.split(",")[0].split(":")[1].trim();
        return Integer.parseInt(stepsString);
    }

    @Override
    public double getCalories() {
        String rawData = fitnessBand.getBandData();
        String caloriesString = rawData.split(",")[1].split(":")[1].trim();
        return Double.parseDouble(caloriesString);
    }
}