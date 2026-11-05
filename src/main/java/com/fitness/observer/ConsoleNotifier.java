package com.fitness.observer;

public class ConsoleNotifier implements WorkoutObserver {
    @Override
    public void update(String workoutName, int steps, double calories) {
        System.out.println("Completed: " + workoutName);
        System.out.println("Steps: " + steps);
        System.out.println("Calories: " + calories);
    }
}
