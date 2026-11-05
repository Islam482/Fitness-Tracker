package com.fitness.strategy;

import com.fitness.factory.Exercise;

public class WorkoutContext {
    private WorkoutStrategy strategy;

    public WorkoutContext(WorkoutStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(WorkoutStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateAmount(Exercise exercise) {
        return strategy.calculateAmount(exercise.getBaseAmount());
    }
}

