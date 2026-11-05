package com.fitness.factory;

public class StrengthExercise implements Exercise {
    @Override
    public String getName(){
        return "Squats";
    }
    @Override
    public String getUnit(){
        return "repetitions";
    }
    @Override
    public int getBaseAmount(){
        return 20;
    }
}
