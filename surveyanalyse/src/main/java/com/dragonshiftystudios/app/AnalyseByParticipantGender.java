package com.dragonshiftystudios.app;
import java.util.LinkedList;

public class AnalyseByParticipantGender {

    private LinkedList<VocalQuestions> vocalQuestionsList;

    CSVConverter csvConverter = new CSVConverter();

    public void getVocalQuestionsList(){
        vocalQuestionsList = csvConverter.populateVocalQuestions();
    }

    public void getTrackPreferenceByParticipantGender(){
        int shineMalePrefMale = 0;
        int shineMalePrefFemale = 0;
        int clearlyMalePrefMale = 0;
        int clearlyMalePrefFemale = 0;
   

        for (VocalQuestions vocalQuestions : vocalQuestionsList){
            if (vocalQuestions.getParticipantGender().equals("0")){
                // shineMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
                // shineFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;

                // clearlyMale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;
                // clearlyFemale += vocalQuestions.getClearlyPref().equals("7") ? 1 : 0;

                // fineMale += vocalQuestions.getFinePref().equals("6") ? 1 : 0;
                // fineFemale += vocalQuestions.getFinePref().equals("7") ? 1 : 0;

                // mOEMale += vocalQuestions.getmOEPref().equals("6") ? 1 : 0;
                // mOEFemale += vocalQuestions.getmOEPref().equals("7") ? 1: 0;

                // myOneMale += vocalQuestions.getMyOnePref().equals(("6")) ? 1 : 0;
                // myOneFemale += vocalQuestions.getMyOnePref().equals("7") ? 1 : 0;

                // flyOnMale += vocalQuestions.getFlyOnPref().equals("6") ? 1 : 0;
                // flyOnFemale += vocalQuestions.getFlyOnPref().equals("7") ? 1 : 0;
            } else {

            }
        }
    }
}
