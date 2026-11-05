package com.fitness;

import com.fitness.adapter.*;
import com.fitness.factory.*;
import com.fitness.observer.*;
import com.fitness.strategy.*;

public class FitnessDemo {
    public static void main(String[] args) {
        ExerciseCreator creator = new StrengthExerciseCreator();
        Exercise exercise = creator.createExercise();

        WorkoutContext context =
                new WorkoutContext(new EasyWorkoutStrategy());

        System.out.println("Exercise " + exercise.getName());
        System.out.println(
                "Amount: " + context.calculateAmount(exercise)
                + " " + exercise.getUnit()
        );

        FitnessTrackerApp tracker =
                new FitnessBandAdapter(new FitnessBand());

        WorkoutSession session =
                new WorkoutSession("Morning workout", tracker);

        ProgressTracker progress = new ProgressTracker();

        session.subscribe(new ConsoleNotifier());
        session.subscribe(progress);

        session.complete();
        progress.showProgress();
    }
}
