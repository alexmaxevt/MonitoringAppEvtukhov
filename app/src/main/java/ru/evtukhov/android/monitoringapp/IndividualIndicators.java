package ru.evtukhov.android.monitoringapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class IndividualIndicators {
    private int topPressure;
    private int bottomPressure;
    private int pulse;
    private boolean tachycardia;
    private LocalDateTime date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    IndividualIndicators(int topPressure, int bottomPressure, int pulse, boolean tachycardia) {
        this.topPressure = topPressure;
        this.bottomPressure = bottomPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = LocalDateTime.now();
    }

    public int getTopPressure() {
        return topPressure;
    }

    public int getBottomPressure() {
        return bottomPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
