package com.dragonshiftystudios.app;
import java.util.LinkedList;

public class AnalyseQuestions {
    CSVConverter csvConverter = new CSVConverter();
    OutputToText outputToText = new OutputToText();

    private LinkedList<VocalQuestions> vocalQuestionsList;

    public void getVocalQuestionsList(){
        vocalQuestionsList = csvConverter.populateVocalQuestions();
    }

    public void openFileWriter(){
        outputToText.openTextFile();
    }

    public void closeFileWriter(){
        outputToText.closeTextFile();
    }

    public void getPreferencesTotal(){
        double listTotal = vocalQuestionsList.size();

        int shineMale = 0;
        int shineFemale = 0;
        int clearlyMale = 0;
        int clearlyFemale = 0;
        int fineMale = 0;
        int fineFemale = 0;
        int mOEMale = 0;
        int mOEFemale= 0;
        int myOneMale = 0;
        int myOneFemale = 0;
        int flyOnMale = 0;
        int flyOnFemale = 0;
        

        for (VocalQuestions vocalQuestions : vocalQuestionsList){            
            shineMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
            shineFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;

            clearlyMale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;
            clearlyFemale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;

            fineMale += vocalQuestions.getFinePref().equals("6") ? 1 : 0;
            fineFemale += vocalQuestions.getFinePref().equals("7") ? 1 : 0;

            mOEMale += vocalQuestions.getmOEPref().equals("6") ? 1 : 0;
            mOEFemale += vocalQuestions.getmOEPref().equals("7") ? 1: 0;

            myOneMale += vocalQuestions.getMyOnePref().equals(("6")) ? 1 : 0;
            myOneFemale += vocalQuestions.getMyOnePref().equals("7") ? 1 : 0;

            flyOnMale += vocalQuestions.getFlyOnPref().equals("6") ? 1 : 0;
            flyOnFemale += vocalQuestions.getFlyOnPref().equals("7") ? 1 : 0;
        }

        outputToText.writeToText("Gender preference for all participants:");
        outputToText.writeToText("");

        double shineMaleMean = (shineMale / listTotal) * 100;
        double shineFemaleMean = (shineFemale / listTotal) * 100;
        displayPreferenceResults("Shine", shineMale, shineMaleMean, shineFemale, shineFemaleMean);

        double clearlyMaleMean = (clearlyMale / listTotal) * 100;
        double clearlyfemaleMean = (clearlyFemale / listTotal) * 100;
        displayPreferenceResults("Clearly", clearlyMale, clearlyMaleMean, clearlyFemale, clearlyfemaleMean);

        double fineMaleMean = (fineMale / listTotal) * 100;
        double fineFemaleMean = (fineFemale / listTotal) * 100;
        displayPreferenceResults("Fine", fineMale, fineMaleMean, fineFemale, fineFemaleMean);

        double mOEMaleMean = (mOEMale / listTotal) * 100;
        double mOEFemaleMean = (mOEFemale / listTotal) * 100;
        displayPreferenceResults("My Own Expectations", mOEMale, mOEMaleMean, mOEFemale, mOEFemaleMean);

        double myOneMaleMean = (myOneMale / listTotal) * 100;
        double myOneFemaleMean = (myOneFemale / listTotal) * 100;
        displayPreferenceResults("My One", myOneMale, myOneMaleMean, myOneFemale, myOneFemaleMean);

        double flyOnMaleMean = (flyOnMale / listTotal) * 100;
        double flyOnFemaleMean = (flyOnFemale / listTotal) * 100;
        displayPreferenceResults("Fly On", flyOnMale, flyOnMaleMean, flyOnFemale, flyOnFemaleMean);

        outputToText.writeToText("");
        outputToText.writeToText("");
    }

    private void displayPreferenceResults(String track, int male, double maleMean, int female, double femaleMean ){
        // System.out.println(String.format("%s - Male: %d (%.2f%%), Female: %d (%.2f%%)", track, male, maleMean, female, femaleMean));
        outputToText.writeToText(String.format("%s - Male: %d (%.2f%%), Female: %d (%.2f%%)", track, male, maleMean, female, femaleMean));
    }


    public void getGenderedPreferences(String gender){
        double listTotal = 0;

        int shineMale = 0;
        int shineFemale = 0;
        int clearlyMale = 0;
        int clearlyFemale = 0;
        int fineMale = 0;
        int fineFemale = 0;
        int mOEMale = 0;
        int mOEFemale= 0;
        int myOneMale = 0;
        int myOneFemale = 0;
        int flyOnMale = 0;
        int flyOnFemale = 0;

        for (VocalQuestions vocalQuestions : vocalQuestionsList){         
            
            if (vocalQuestions.getGender().equals(gender)){
                listTotal++;

                shineMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
                shineFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;

                clearlyMale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;
                clearlyFemale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;

                fineMale += vocalQuestions.getFinePref().equals("6") ? 1 : 0;
                fineFemale += vocalQuestions.getFinePref().equals("7") ? 1 : 0;

                mOEMale += vocalQuestions.getmOEPref().equals("6") ? 1 : 0;
                mOEFemale += vocalQuestions.getmOEPref().equals("7") ? 1: 0;

                myOneMale += vocalQuestions.getMyOnePref().equals(("6")) ? 1 : 0;
                myOneFemale += vocalQuestions.getMyOnePref().equals("7") ? 1 : 0;

                flyOnMale += vocalQuestions.getFlyOnPref().equals("6") ? 1 : 0;
                flyOnFemale += vocalQuestions.getFlyOnPref().equals("7") ? 1 : 0;
            }   
        }

        outputToText.writeToText("Gender preference with " + gender + " leading questions:");
        outputToText.writeToText("");

        double shineMaleMean = (shineMale / listTotal) * 100;
        double shineFemaleMean = (shineFemale / listTotal) * 100;
        displayPreferenceResults("Shine", shineMale, shineMaleMean, shineFemale, shineFemaleMean);

        double clearlyMaleMean = (clearlyMale / listTotal) * 100;
        double clearlyfemaleMean = (clearlyFemale / listTotal) * 100;
        displayPreferenceResults("Clearly", clearlyMale, clearlyMaleMean, clearlyFemale, clearlyfemaleMean);

        double fineMaleMean = (fineMale / listTotal) * 100;
        double fineFemaleMean = (fineFemale / listTotal) * 100;
        displayPreferenceResults("Fine", fineMale, fineMaleMean, fineFemale, fineFemaleMean);

        double mOEMaleMean = (mOEMale / listTotal) * 100;
        double mOEFemaleMean = (mOEFemale / listTotal) * 100;
        displayPreferenceResults("My Own Expectations", mOEMale, mOEMaleMean, mOEFemale, mOEFemaleMean);

        double myOneMaleMean = (myOneMale / listTotal) * 100;
        double myOneFemaleMean = (myOneFemale / listTotal) * 100;
        displayPreferenceResults("My One", myOneMale, myOneMaleMean, myOneFemale, myOneFemaleMean);

        double flyOnMaleMean = (flyOnMale / listTotal) * 100;
        double flyOnFemaleMean = (flyOnFemale / listTotal) * 100;
        displayPreferenceResults("Fly On", flyOnMale, flyOnMaleMean, flyOnFemale, flyOnFemaleMean);

        outputToText.writeToText("");
        outputToText.writeToText("");
    }

    public void getSimilarity(String genderOrTotal){
        double listTotal = vocalQuestionsList.size();
        double maleTotal = 0;
        double femaleTotal = 0;

        double shineSim = 0;
        double clearlySim = 0;
        double fineSim = 0;
        double mOESim = 0;
        double myOneSim = 0;
        double flyOnSim = 0;

        double shineSuits = 0;
        double clearlySuits = 0;
        double fineSuits = 0;
        double mOESuits = 0;
        double myOneSuits = 0;
        double flyOnSuits = 0;

        double shineMark = 0;
        double clearlyMark = 0;
        double fineMark = 0;
        double mOEMark = 0;
        double myOneMark = 0;
        double flyOnMark = 0;


        for (VocalQuestions vocalQuestions : vocalQuestionsList){
            if (genderOrTotal.equals("Total")){
                shineSim += Integer.parseInt(vocalQuestions.getShineSim());
                clearlySim += Integer.parseInt(vocalQuestions.getClearlySim());
                fineSim += Integer.parseInt(vocalQuestions.getFineSim());
                mOESim += Integer.parseInt(vocalQuestions.getmOESim());
                myOneSim += Integer.parseInt(vocalQuestions.getMyOneSim());
                flyOnSim += Integer.parseInt(vocalQuestions.getFlyOnSim());

                shineSuits += Integer.parseInt(vocalQuestions.getShineSuits());
                clearlySuits += Integer.parseInt(vocalQuestions.getClearlySuits());
                fineSuits += Integer.parseInt(vocalQuestions.getFineSuits());
                mOESuits += Integer.parseInt(vocalQuestions.getmOESuits());
                myOneSuits += Integer.parseInt(vocalQuestions.getMyOneSuits());
                flyOnSuits += Integer.parseInt(vocalQuestions.getFlyOnSuits());

                shineMark += Integer.parseInt(vocalQuestions.getShineMark());
                clearlyMark += Integer.parseInt(vocalQuestions.getClearlyMark());
                fineMark += Integer.parseInt(vocalQuestions.getFineMark());
                mOEMark += Integer.parseInt(vocalQuestions.getmOEMark());
                myOneMark += Integer.parseInt(vocalQuestions.getMyOneMark());
                flyOnMark += Integer.parseInt(vocalQuestions.getFlyOnMark());
            } else if (genderOrTotal.equals("Male")){
                maleTotal++;

                shineSim += Integer.parseInt(vocalQuestions.getShineSim());
                clearlySim += Integer.parseInt(vocalQuestions.getClearlySim());
                fineSim += Integer.parseInt(vocalQuestions.getFineSim());
                mOESim += Integer.parseInt(vocalQuestions.getmOESim());
                myOneSim += Integer.parseInt(vocalQuestions.getMyOneSim());
                flyOnSim += Integer.parseInt(vocalQuestions.getFlyOnSim());

                shineSuits += Integer.parseInt(vocalQuestions.getShineSuits());
                clearlySuits += Integer.parseInt(vocalQuestions.getClearlySuits());
                fineSuits += Integer.parseInt(vocalQuestions.getFineSuits());
                mOESuits += Integer.parseInt(vocalQuestions.getmOESuits());
                myOneSuits += Integer.parseInt(vocalQuestions.getMyOneSuits());
                flyOnSuits += Integer.parseInt(vocalQuestions.getFlyOnSuits());

                shineMark += Integer.parseInt(vocalQuestions.getShineMark());
                clearlyMark += Integer.parseInt(vocalQuestions.getClearlyMark());
                fineMark += Integer.parseInt(vocalQuestions.getFineMark());
                mOEMark += Integer.parseInt(vocalQuestions.getmOEMark());
                myOneMark += Integer.parseInt(vocalQuestions.getMyOneMark());
                flyOnMark += Integer.parseInt(vocalQuestions.getFlyOnMark());
            } else if (genderOrTotal.equals("Female")){
                femaleTotal++;

                shineSim += Integer.parseInt(vocalQuestions.getShineSim());
                clearlySim += Integer.parseInt(vocalQuestions.getClearlySim());
                fineSim += Integer.parseInt(vocalQuestions.getFineSim());
                mOESim += Integer.parseInt(vocalQuestions.getmOESim());
                myOneSim += Integer.parseInt(vocalQuestions.getMyOneSim());
                flyOnSim += Integer.parseInt(vocalQuestions.getFlyOnSim());

                shineSuits += Integer.parseInt(vocalQuestions.getShineSuits());
                clearlySuits += Integer.parseInt(vocalQuestions.getClearlySuits());
                fineSuits += Integer.parseInt(vocalQuestions.getFineSuits());
                mOESuits += Integer.parseInt(vocalQuestions.getmOESuits());
                myOneSuits += Integer.parseInt(vocalQuestions.getMyOneSuits());
                flyOnSuits += Integer.parseInt(vocalQuestions.getFlyOnSuits());

                shineMark += Integer.parseInt(vocalQuestions.getShineMark());
                clearlyMark += Integer.parseInt(vocalQuestions.getClearlyMark());
                fineMark += Integer.parseInt(vocalQuestions.getFineMark());
                mOEMark += Integer.parseInt(vocalQuestions.getmOEMark());
                myOneMark += Integer.parseInt(vocalQuestions.getMyOneMark());
                flyOnMark += Integer.parseInt(vocalQuestions.getFlyOnMark());
            }
            
        }

        double totalParticipants = 0;

        switch (genderOrTotal){
            case "Total":
                totalParticipants = listTotal;
                outputToText.writeToText("All particpants similarities:");
                outputToText.writeToText("");
                break;
            case "Male":
                totalParticipants = maleTotal;
                outputToText.writeToText("Male leading questions similarities:");
                outputToText.writeToText("");
                break;
            case "Female":
                totalParticipants = femaleTotal;
                outputToText.writeToText("Female Leading questions similarities:");
                outputToText.writeToText("");
                break;
        }

        double shineSimMean = shineSim / totalParticipants;
        double clearlySimMean = clearlySim / totalParticipants;
        double fineSimMean = fineSim / totalParticipants;
        double mOESimMean = mOESim / totalParticipants;
        double myOneSimMean = myOneSim / totalParticipants;
        double flyOnSimMean = flyOnSim / totalParticipants;

        double shineSuitsMean = shineSuits / totalParticipants;
        double clearlySuitsMean = clearlySuits / totalParticipants;
        double fineSuitsMean = fineSuits / totalParticipants;
        double mOESuitsMean = mOESuits / totalParticipants;
        double myOneSuitsMean = myOneSuits / totalParticipants;
        double flyOnSuitsMean = flyOnSuits / totalParticipants;

        double shineMarkMean = shineMark / totalParticipants;
        double clearlyMarkMean = clearlyMark / totalParticipants;
        double fineMarkMean = fineMark / totalParticipants;
        double mOEMarkMean = mOEMark / totalParticipants;
        double myOneMarkMean = myOneMark / totalParticipants;
        double flyOnMarkMean = flyOnMark / totalParticipants;

        outputToText.writeToText("Similar vocal quality mean:");
        outputToText.writeToText("");

        displayPreferenceResults("Shine", shineSimMean);
        displayPreferenceResults("Clearly", clearlySimMean);
        displayPreferenceResults("Fine", fineSimMean);
        displayPreferenceResults("My Own Expectations", mOESimMean);
        displayPreferenceResults("My One", myOneSimMean);
        displayPreferenceResults("Fly On", flyOnSimMean);

        outputToText.writeToText("");
        outputToText.writeToText("Vocals suit the music mean:");
        outputToText.writeToText("");

        displayPreferenceResults("Shine", shineSuitsMean);
        displayPreferenceResults("Clearly", clearlySuitsMean);
        displayPreferenceResults("Fine", fineSuitsMean);
        displayPreferenceResults("My Own Expectations", mOESuitsMean);
        displayPreferenceResults("My One", myOneSuitsMean);
        displayPreferenceResults("Fly On", flyOnSuitsMean);

        outputToText.writeToText("");
        outputToText.writeToText("Vocals are similarly marketable mean:");
        outputToText.writeToText("");

        displayPreferenceResults("Shine", shineMarkMean);
        displayPreferenceResults("Clearly", clearlyMarkMean);
        displayPreferenceResults("Fine", fineMarkMean);
        displayPreferenceResults("My Own Expectations", mOEMarkMean);
        displayPreferenceResults("My One", myOneMarkMean);
        displayPreferenceResults("Fly On", flyOnMarkMean);

        outputToText.writeToText("");
        outputToText.writeToText("");
    }

    private void displayPreferenceResults(String track, double result){
        outputToText.writeToText(String.format("%s - %.2f", track, result));
    }
}
