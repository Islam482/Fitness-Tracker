package com.fitness.observer;

public class ProgressTracker implements WorkoutObserver {
    private int completedWorkouts;
    private int totalSteps;
    private int totalCalories;

    @Override
    public void update(String workoutName, int steps, double calories) {
        completedWorkouts++;
        totalSteps += steps;
        totalCalories += calories;
    }
    public void showProgress() {
        System.out.println("Workouts: " + completedWorkouts);
        System.out.println("Total steps: " + totalSteps);
        System.out.println("Total calories: " + totalCalories);
    }
}
