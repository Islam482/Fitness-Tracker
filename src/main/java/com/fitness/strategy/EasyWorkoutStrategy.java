package com.fitness.strategy;

public class EasyWorkoutStrategy implements WorkoutStrategy{
    @Override
    public int calculateAmount (int baseAmount) {
        return Math.max(1, baseAmount / 2);
    }
}
