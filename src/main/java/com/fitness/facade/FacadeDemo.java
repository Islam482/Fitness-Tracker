package com.fitness.facade;

import com.fitness.factory.CardioExerciseCreator;
import com.fitness.factory.StrengthExerciseCreator;
import com.fitness.strategy.EasyWorkoutStrategy;
import com.fitness.strategy.IntensiveWorkoutStrategy;

public class FacadeDemo {
    public static void main(String[] args) {
        WorkoutFacade facade = new WorkoutFacade();

        facade.startWorkout(
                "Morning workout",
                new StrengthExerciseCreator(),
                new EasyWorkoutStrategy()
        );
        facade.finishWorkout();

        facade.startWorkout(
                "Evening workout",
                new CardioExerciseCreator(),
                new IntensiveWorkoutStrategy()
        );
        facade.finishWorkout();

        facade.showStatistics();
    }
}