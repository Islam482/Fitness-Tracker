package com.fitness.strategy;

import com.fitness.factory.Exercise;
import com.fitness.factory.StrengthExercise;
import com.fitness.factory.StrengthExerciseCreator;

public class StrategyDemo {
    public static void main(String[] args) {
        Exercise exercise =
                new StrengthExerciseCreator().createExercise();

        WorkoutContext context =
                new WorkoutContext(new EasyWorkoutStrategy());

        System.out.println("Easy: " + context.calculateAmount(exercise));

        context.setStrategy(new NormalWorkoutStrategy());
        System.out.println("Normal: " + context.calculateAmount(exercise));

        context.setStrategy(new IntensiveWorkoutStrategy());
        System.out.println("Intensive: " + context.calculateAmount(exercise));
    }
}
