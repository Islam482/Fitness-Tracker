package com.fitness.factory;

public abstract class ExerciseCreator{
    public abstract Exercise createExercise();

    public void showExercise(){
        Exercise exercise = createExercise();

        System.out.println(
                exercise.getName() + ": "
                + exercise.getBaseAmount() + " "
                + exercise.getUnit()
        );
    }

}
