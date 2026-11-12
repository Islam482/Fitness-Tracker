package com.fitness.facade;

import com.fitness.builder.Workout;
import com.fitness.builder.WorkoutBuilder;
import com.fitness.factory.CardioExerciseCreator;
import com.fitness.factory.StrengthExerciseCreator;
import com.fitness.factory.StretchingExerciseCreator;
import com.fitness.strategy.EasyWorkoutStrategy;
import com.fitness.strategy.IntensiveWorkoutStrategy;

public class FacadeDemo {
    public static void main(String[] args) {
        WorkoutFacade facade = new WorkoutFacade();

        Workout morning = new WorkoutBuilder()
                .setName("Morning workout")
                .addExercise(new StrengthExerciseCreator().createExercise())
                .addExercise(new StretchingExerciseCreator().createExercise())
                .setSets(3)
                .setReps(12)
                .build();

        Workout evening = new WorkoutBuilder()
                .setName("Evening workout")
                .addExercise(new CardioExerciseCreator().createExercise())
                .setSets(2)
                .setReps(10)
                .build();

        facade.startWorkout(morning, new EasyWorkoutStrategy());
        facade.finishWorkout();

        facade.startWorkout(evening, new IntensiveWorkoutStrategy());
        facade.finishWorkout();

        facade.showStatistics();
    }
}