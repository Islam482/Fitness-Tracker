package com.fitness.factory;

public class StretchingExercise implements Exercise {
    @Override
    public String getName() {
        return "Hamstring stretch";
    }

    @Override
    public String getUnit() {
        return "seconds";
    }

    @Override
    public int getBaseAmount() {
        return 30;
    }
}