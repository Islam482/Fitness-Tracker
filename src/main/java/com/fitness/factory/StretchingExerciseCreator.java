package com.fitness.factory;

public class StretchingExerciseCreator extends ExerciseCreator {
    @Override
    public Exercise createExercise() {
        return new StretchingExercise();
    }
}