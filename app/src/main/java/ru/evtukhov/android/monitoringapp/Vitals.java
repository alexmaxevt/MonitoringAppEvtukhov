package ru.evtukhov.android.monitoringapp;

public class Vitals {
    private double weight;
    private int steps;

    public Vitals (double weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public double getWeight() {
        return weight;
    }

    public int getSteps() {
        return steps;
    }
}
