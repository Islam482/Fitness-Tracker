package com.fitness.builder;

import com.fitness.factory.Exercise;

import java.util.List;

public class Workout {
    private final String name;
    private final List<Exercise> exercises;
    private final int sets;
    private final int reps;

    Workout(String name, List<Exercise> exercises, int sets, int reps) {
        this.name = name;
        this.exercises = List.copyOf(exercises);
        this.sets = sets;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public void show() {
        System.out.println("Workout: " + name);
        for (Exercise exercise : exercises) {
            System.out.println(
                    "- " + exercise.getName() + ": "
                            + sets + " sets x " + reps + " reps"
            );
        }
    }
}