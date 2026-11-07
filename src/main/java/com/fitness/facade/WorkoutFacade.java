package com.fitness.facade;

import com.fitness.adapter.FitnessBand;
import com.fitness.adapter.FitnessBandAdapter;
import com.fitness.adapter.FitnessTrackerApp;
import com.fitness.factory.Exercise;
import com.fitness.factory.ExerciseCreator;
import com.fitness.observer.ConsoleNotifier;
import com.fitness.observer.ProgressTracker;
import com.fitness.observer.WorkoutSession;
import com.fitness.strategy.NormalWorkoutStrategy;
import com.fitness.strategy.WorkoutContext;
import com.fitness.strategy.WorkoutStrategy;

public class WorkoutFacade {
    private final FitnessTrackerApp tracker;
    private final ProgressTracker progress = new ProgressTracker();
    private final WorkoutContext context =
            new WorkoutContext(new NormalWorkoutStrategy());
    private WorkoutSession session;

    public WorkoutFacade() {
        this(new FitnessBandAdapter(new FitnessBand()));
    }

    public WorkoutFacade(FitnessTrackerApp tracker) {
        this.tracker = tracker;
    }

    public void startWorkout(String name,
                             ExerciseCreator creator,
                             WorkoutStrategy strategy) {
        Exercise exercise = creator.createExercise();
        context.setStrategy(strategy);

        session = new WorkoutSession(name, tracker);
        session.subscribe(new ConsoleNotifier());
        session.subscribe(progress);

        System.out.println("Started: " + name);
        System.out.println(
                exercise.getName() + ": "
                        + context.calculateAmount(exercise) + " "
                        + exercise.getUnit()
        );
    }

    public void finishWorkout() {
        if (session == null) {
            System.out.println("No active workout");
            return;
        }
        session.complete();
        session = null;
    }

    public void showStatistics() {
        progress.showProgress();
    }
}