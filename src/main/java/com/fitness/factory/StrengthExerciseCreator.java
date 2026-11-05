package com.fitness.factory;

public class StrengthExerciseCreator extends ExerciseCreator {
    @Override
    public Exercise createExercise() {
        return new StrengthExercise();
    }
}
