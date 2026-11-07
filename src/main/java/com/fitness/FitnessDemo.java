package com.fitness;

import com.fitness.facade.WorkoutFacade;
import com.fitness.factory.StrengthExerciseCreator;
import com.fitness.strategy.EasyWorkoutStrategy;

public class FitnessDemo {
    public static void main(String[] args) {
        WorkoutFacade facade = new WorkoutFacade();

        facade.startWorkout(
                "Morning workout",
                new StrengthExerciseCreator(),
                new EasyWorkoutStrategy()
        );
        facade.finishWorkout();
        facade.showStatistics();
    }
}