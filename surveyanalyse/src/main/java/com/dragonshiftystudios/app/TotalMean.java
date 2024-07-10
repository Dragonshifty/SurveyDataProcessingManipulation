package com.dragonshiftystudios.app;

public class TotalMean {
    private String trackName;
    private double totalMeanScore;

    public TotalMean(String trackName, double totalMeanScore){
        this.trackName = trackName;
        this.totalMeanScore = totalMeanScore;
    }

    public String getTrackName() {
        return trackName;
    }

    public double getTotalMeanScore() {
        return totalMeanScore;
    }
}
