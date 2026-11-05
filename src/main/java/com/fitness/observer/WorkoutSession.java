package com.fitness.observer;

import com.fitness.adapter.FitnessTrackerApp;
import  java.util.ArrayList;
import  java.util.List;

public class WorkoutSession {
    private final List<WorkoutObserver> observers = new ArrayList<>();
    private final FitnessTrackerApp tracker;
    private final String workoutName;
    private boolean completed;

    public WorkoutSession(String workoutName, FitnessTrackerApp tracker) {
        this.workoutName = workoutName;
        this.tracker = tracker;
    }

    public void subscribe(WorkoutObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    public void unsubscribe(WorkoutObserver observer) {
        observers.remove(observer);
    }

    public void complete() {
        if (completed) {
            return;
        }

        int steps = tracker.getSteps();
        double calories = tracker.getCalories();
        completed = true;

        for (WorkoutObserver observer : List.copyOf(observers)) {
            observer.update(workoutName, steps, calories);
        }
    }
}
