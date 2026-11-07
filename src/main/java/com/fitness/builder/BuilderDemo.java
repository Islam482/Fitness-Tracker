package com.fitness.builder;

import com.fitness.factory.CardioExerciseCreator;
import com.fitness.factory.StrengthExerciseCreator;

public class BuilderDemo {
    public static void main(String[] args) {
        Workout workout = new WorkoutBuilder()
                .setName("Morning workout")
                .addExercise(new StrengthExerciseCreator().createExercise())
                .addExercise(new CardioExerciseCreator().createExercise())
                .setSets(3)
                .setReps(12)
                .build();

        workout.show();
    }
}