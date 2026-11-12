package com.fitness;

import com.fitness.builder.Workout;
import com.fitness.builder.WorkoutBuilder;
import com.fitness.facade.WorkoutFacade;
import com.fitness.factory.StrengthExerciseCreator;
import com.fitness.strategy.EasyWorkoutStrategy;

public class FitnessDemo {
    public static void main(String[] args) {
        Workout workout = new WorkoutBuilder()
                .setName("Morning workout")
                .addExercise(new StrengthExerciseCreator().createExercise())
                .setSets(3)
                .setReps(12)
                .build();

        WorkoutFacade facade = new WorkoutFacade();
        facade.startWorkout(workout, new EasyWorkoutStrategy());
        facade.finishWorkout();
        facade.showStatistics();
    }
}