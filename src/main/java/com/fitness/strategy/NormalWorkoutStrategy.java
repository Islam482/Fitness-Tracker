package com.fitness.strategy;

public class NormalWorkoutStrategy implements WorkoutStrategy {
    @Override
    public int calculateAmount (int baseAmount) {
        return baseAmount;
    }
}
