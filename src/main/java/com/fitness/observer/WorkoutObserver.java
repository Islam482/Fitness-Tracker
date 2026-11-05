package com.fitness.observer;

public interface WorkoutObserver {
    void update(String workoutName, int steps, double calories);
}
