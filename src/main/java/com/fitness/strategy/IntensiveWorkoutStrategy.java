package com.fitness.strategy;

public class IntensiveWorkoutStrategy implements WorkoutStrategy {
    @Override
    public int calculateAmount (int baseAmount) {
        return baseAmount * 2;
    }
}
