package com.fitness.adapter;

public class FitnessBandAdapter implements FitnessTrackerApp {
    private final FitnessBand fitnessBand;

    public FitnessBandAdapter(FitnessBand fitnessBand) {
        this.fitnessBand = fitnessBand;
    }

    @Override
    public int getSteps() {
        return Integer.parseInt(readField(0));
    }

    @Override
    public double getCalories() {
        return Double.parseDouble(readField(1));
    }

    private String readField(int index) {
        return fitnessBand.getBandData().split(",")[index].split(":")[1].trim();
    }
}