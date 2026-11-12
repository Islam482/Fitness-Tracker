package com.fitness.ui;

import com.fitness.builder.Workout;
import com.fitness.builder.WorkoutBuilder;
import com.fitness.facade.WorkoutFacade;
import com.fitness.factory.CardioExerciseCreator;
import com.fitness.factory.ExerciseCreator;
import com.fitness.factory.StrengthExerciseCreator;
import com.fitness.factory.StretchingExerciseCreator;
import com.fitness.strategy.EasyWorkoutStrategy;
import com.fitness.strategy.IntensiveWorkoutStrategy;
import com.fitness.strategy.NormalWorkoutStrategy;
import com.fitness.strategy.WorkoutStrategy;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class FitnessApp extends JFrame {
    private final WorkoutFacade facade = new WorkoutFacade();

    private final JTextField nameField = new JTextField("Morning workout");
    private final JCheckBox strengthBox = new JCheckBox("Strength", true);
    private final JCheckBox cardioBox = new JCheckBox("Cardio");
    private final JCheckBox stretchingBox = new JCheckBox("Stretching");
    private final JComboBox<String> intensityBox =
            new JComboBox<>(new String[]{"Easy", "Normal", "Intensive"});
    private final JSpinner setsSpinner =
            new JSpinner(new SpinnerNumberModel(3, 1, 20, 1));
    private final JSpinner repsSpinner =
            new JSpinner(new SpinnerNumberModel(12, 1, 100, 1));

    private final JButton startButton = new JButton("Start workout");
    private final JButton finishButton = new JButton("Finish workout");
    private final JButton statsButton = new JButton("Show statistics");
    private final JButton clearButton = new JButton("Clear log");

    private final JTextArea logArea = new JTextArea();

    public FitnessApp() {
        super("Fitness Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        logArea.setEditable(false);
        logArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        System.setOut(new PrintStream(
                new TextAreaOutputStream(logArea), true, StandardCharsets.UTF_8));

        add(createFormPanel(), BorderLayout.NORTH);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        finishButton.setEnabled(false);
        startButton.addActionListener(e -> startWorkout());
        finishButton.addActionListener(e -> finishWorkout());
        statsButton.addActionListener(e -> facade.showStatistics());
        clearButton.addActionListener(e -> logArea.setText(""));

        setSize(560, 580);
        setLocationRelativeTo(null);
    }

    private JPanel createFormPanel() {
        JPanel exercises = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        exercises.add(strengthBox);
        exercises.add(cardioBox);
        exercises.add(stretchingBox);

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        form.add(new JLabel("Workout name"));
        form.add(nameField);
        form.add(new JLabel("Exercises"));
        form.add(exercises);
        form.add(new JLabel("Intensity"));
        form.add(intensityBox);
        form.add(new JLabel("Sets"));
        form.add(setsSpinner);
        form.add(new JLabel("Reps"));
        form.add(repsSpinner);
        form.add(startButton);
        form.add(finishButton);
        form.add(statsButton);
        form.add(clearButton);
        return form;
    }

    private WorkoutStrategy selectedStrategy() {
        return switch ((String) intensityBox.getSelectedItem()) {
            case "Easy" -> new EasyWorkoutStrategy();
            case "Intensive" -> new IntensiveWorkoutStrategy();
            default -> new NormalWorkoutStrategy();
        };
    }

    private void addSelected(WorkoutBuilder builder, JCheckBox box,
                             ExerciseCreator creator) {
        if (box.isSelected()) {
            builder.addExercise(creator.createExercise());
        }
    }

    private Workout buildWorkout() {
        WorkoutBuilder builder = new WorkoutBuilder()
                .setName(nameField.getText().trim())
                .setSets((Integer) setsSpinner.getValue())
                .setReps((Integer) repsSpinner.getValue());

        addSelected(builder, strengthBox, new StrengthExerciseCreator());
        addSelected(builder, cardioBox, new CardioExerciseCreator());
        addSelected(builder, stretchingBox, new StretchingExerciseCreator());
        return builder.build();
    }

    private void startWorkout() {
        try {
            facade.startWorkout(buildWorkout(), selectedStrategy());
            setWorkoutActive(true);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void finishWorkout() {
        facade.finishWorkout();
        setWorkoutActive(false);
    }

    private void setWorkoutActive(boolean active) {
        startButton.setEnabled(!active);
        finishButton.setEnabled(active);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        SwingUtilities.invokeLater(() -> new FitnessApp().setVisible(true));
    }
}