package com.fitness.factory;

public class CardioExerciseCreator extends ExerciseCreator {
    @Override
    public Exercise createExercise() {
        return new CardioExercise();
    }
}
