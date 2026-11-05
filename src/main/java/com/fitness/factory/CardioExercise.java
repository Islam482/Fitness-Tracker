package com.fitness.factory;

public class CardioExercise implements Exercise{
    @Override
    public String getName(){
        return "Running";
    }
    @Override
    public String getUnit(){
        return "minutes";
    }
    @Override
    public int getBaseAmount(){
            return 15;
    }
}
