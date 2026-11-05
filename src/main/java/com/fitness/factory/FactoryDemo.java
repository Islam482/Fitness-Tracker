package com.fitness.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        ExerciseCreator strength = new StrengthExerciseCreator();
        ExerciseCreator cardio = new CardioExerciseCreator();

        strength.showExercise();
        cardio.showExercise();
    }
}
