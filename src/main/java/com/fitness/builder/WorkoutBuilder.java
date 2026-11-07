package com.fitness.builder;

import com.fitness.factory.Exercise;

import java.util.ArrayList;
import java.util.List;

public class WorkoutBuilder {
    private String name;
    private final List<Exercise> exercises = new ArrayList<>();
    private int sets = 1;
    private int reps = 1;

    public WorkoutBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WorkoutBuilder addExercise(Exercise exercise) {
        exercises.add(exercise);
        return this;
    }

    public WorkoutBuilder setSets(int sets) {
        this.sets = sets;
        return this;
    }

    public WorkoutBuilder setReps(int reps) {
        this.reps = reps;
        return this;
    }

    public Workout build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Workout name is required");
        }
        if (exercises.isEmpty()) {
            throw new IllegalStateException("Workout needs at least one exercise");
        }
        if (sets < 1 || reps < 1) {
            throw new IllegalStateException("Sets and reps must be positive");
        }
        return new Workout(name, exercises, sets, reps);
    }
}