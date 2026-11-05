package com.fitness.observer;

import com.fitness.adapter.FitnessBand;
import com.fitness.adapter.FitnessBandAdapter;
import com.fitness.adapter.FitnessTrackerApp;

public class ObserverDemo {
    public static void main(String[] args) {
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
