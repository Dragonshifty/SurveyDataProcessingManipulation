package com.dragonshiftystudios.app;

public class Participant {

    private String dreamWistfullyDescription;
    private String risingDescription;
    private String triggeredDescription;
    private String suggestedGenderDW;
    private String suggestedGenderR;
    private String suggestedGenderT;

    public Participant(String dreamWistfullyDescription, String risingDescription, String triggeredDescription){
        this.dreamWistfullyDescription = dreamWistfullyDescription;
        this.risingDescription = risingDescription;
        this.triggeredDescription = triggeredDescription;
    }

    public String getDreamWistfullyDescription(){
        return dreamWistfullyDescription;
    }

    public String getRisingDescription(){
        return risingDescription;
    }

    public String getTriggeredDescription(){
        return triggeredDescription;
    }

    public void setSuggestedGenderDW(String genderCode){
        suggestedGenderDW = genderCode;
    }

    public String getSuggestedGenderDW() {
        return suggestedGenderDW;
    }

    public void setSuggestedGenderR(String genderCode) {
        this.suggestedGenderR = genderCode;
    }

    public String getSuggestedGenderR() {
        return suggestedGenderR;
    }

    public void setSuggestedGenderT(String genderCode) {
        this.suggestedGenderT = genderCode;
    }

    public String getSuggestedGenderT() {
        return suggestedGenderT;
    }
}
