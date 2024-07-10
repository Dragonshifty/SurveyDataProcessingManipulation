package com.dragonshiftystudios.app;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AnalyseByParticipantGender {

    private LinkedList<VocalQuestions> vocalQuestionsList;

    CSVConverter csvConverter = new CSVConverter();
    OutputToText outputToText = new OutputToText();

    String participantGenderFileName = "preferenceByParticipantGender2.txt";
    String familiarityByMale = "familiaritybymale.txt";
    String familiarityByFemale = "familiaritybyfemale.txt";

    public void getVocalQuestionsList(){
        vocalQuestionsList = csvConverter.populateVocalQuestions();
    }

    public void outPutPreferenceByGender(){
        getVocalQuestionsList();
        outputToText.setFileName(participantGenderFileName);
        outputToText.openTextFile();
        getTrackPreferenceByParticipantGender();
        outputToText.closeTextFile();
        System.out.println("Output to file complete");
    }

    public void outPutFamiliarityByGender(){
        getVocalQuestionsList();
        
        outputToText.setFileName(familiarityByMale);
        outputToText.openTextFile();
        getParticipantFamiliarity("Male", true);
        outputToText.closeTextFile();
        System.out.println("Output to file complete");

        outputToText.setFileName(familiarityByFemale);
        outputToText.openTextFile();
        getParticipantFamiliarity("Female", true);
        outputToText.closeTextFile();
        System.out.println("Output to file complete");
    }

    public void outPutRankingsByGender(){
        getVocalQuestionsList();

        outputToText.setFileName("Male" + " rankings.txt");
        outputToText.openTextFile();

        getParticipantFamiliarity("Male", false);
        outputToText.closeTextFile();

        outputToText.setFileName("Female" + " rankings.txt");
        outputToText.openTextFile();

        getParticipantFamiliarity("Female", false);
        outputToText.closeTextFile();
    }

    public void debugShineTrackPreferences() {
        getVocalQuestionsList();
        int maleTotal = 0;
        int femaleTotal = 0;
    
        int shineMalePrefMale = 0;
        int shineMalePrefFemale = 0;
        int shineFemalePrefMale = 0;
        int shineFemalePrefFemale = 0;
    
        for (VocalQuestions vocalQuestions : vocalQuestionsList) {
            if (vocalQuestions.getParticipantGender().equals("1")) {
                maleTotal++;
    
                shineMalePrefMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
                shineMalePrefFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;
            } else {
                femaleTotal++;
    
                shineFemalePrefMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
                shineFemalePrefFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;
            }
        }
    
        int shineTotal = shineMalePrefMale + shineMalePrefFemale + shineFemalePrefMale + shineFemalePrefFemale;
        int participantTotal = maleTotal + femaleTotal;
    
        System.out.println("Shine Track Preferences Debugging:");
        System.out.println("Male Total: " + maleTotal);
        System.out.println("Female Total: " + femaleTotal);
        System.out.println("Shine Male Prefers Male: " + shineMalePrefMale);
        System.out.println("Shine Male Prefers Female: " + shineMalePrefFemale);
        System.out.println("Shine Female Prefers Male: " + shineFemalePrefMale);
        System.out.println("Shine Female Prefers Female: " + shineFemalePrefFemale);
        System.out.println("Total Shine Preferences: " + shineTotal);
        System.out.println("Total Participants: " + participantTotal);
        System.out.println("Shine Male Preferences Percentage: " + ((double) (shineMalePrefMale + shineMalePrefFemale) / maleTotal) * 100);
        System.out.println("Shine Female Preferences Percentage: " + ((double) (shineFemalePrefMale + shineFemalePrefFemale) / femaleTotal) * 100);
    }
    

    private void getTrackPreferenceByParticipantGender(){
        int maleTotal = 0;
        int femaleTotal = 0;

        int shineMalePrefMale = 0;
        int shineMalePrefFemale = 0;
        int clearlyMalePrefMale = 0;
        int clearlyMalePrefFemale = 0;
        int fineMalePrefMale = 0;
        int fineMalePrefFemale = 0;
        int mOEMalePrefMale = 0;
        int mOEMalePrefFemale = 0;
        int myOneMalePrefMale = 0;
        int myOneMalePrefFemale = 0;
        int flyOnMalePrefMale = 0;
        int flyOnMalePrefFemale = 0;

        int shineFemalePrefMale = 0;
        int shineFemalePrefFemale = 0;
        int clearlyFemalePrefMale = 0;
        int clearlyFemalePrefFemale = 0;
        int fineFemalePrefMale = 0;
        int fineFemalePrefFemale = 0;
        int mOEFemalePrefMale = 0;
        int mOEFemalePrefFemale = 0;
        int myOneFemalePrefMale = 0;
        int myOneFemalePrefFemale = 0;
        int flyOnFemalePrefMale = 0;
        int flyOnFemalePrefFemale = 0;
   

        for (VocalQuestions vocalQuestions : vocalQuestionsList){
            if (vocalQuestions.getParticipantGender().equals("1")){
                maleTotal++;

                shineMalePrefMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
                shineMalePrefFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;

                clearlyMalePrefMale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;
                clearlyMalePrefFemale += vocalQuestions.getClearlyPref().equals("7") ? 1 : 0;

                fineMalePrefMale += vocalQuestions.getFinePref().equals("6") ? 1 : 0;
                fineMalePrefFemale += vocalQuestions.getFinePref().equals("7") ? 1 : 0;

                mOEMalePrefMale += vocalQuestions.getmOEPref().equals("6") ? 1 : 0;
                mOEMalePrefFemale += vocalQuestions.getmOEPref().equals("7") ? 1: 0;

                myOneMalePrefMale += vocalQuestions.getMyOnePref().equals(("6")) ? 1 : 0;
                myOneMalePrefFemale += vocalQuestions.getMyOnePref().equals("7") ? 1 : 0;

                flyOnMalePrefMale += vocalQuestions.getFlyOnPref().equals("6") ? 1 : 0;
                flyOnMalePrefFemale += vocalQuestions.getFlyOnPref().equals("7") ? 1 : 0;
            } else {
                femaleTotal++;

                shineFemalePrefMale += vocalQuestions.getShinePref().equals("6") ? 1 : 0;
                shineFemalePrefFemale += vocalQuestions.getShinePref().equals("7") ? 1 : 0;

                clearlyFemalePrefMale += vocalQuestions.getClearlyPref().equals("6") ? 1 : 0;
                clearlyFemalePrefFemale += vocalQuestions.getClearlyPref().equals("7") ? 1 : 0;

                fineFemalePrefMale += vocalQuestions.getFinePref().equals("6") ? 1 : 0;
                fineFemalePrefFemale += vocalQuestions.getFinePref().equals("7") ? 1 : 0;

                mOEFemalePrefMale += vocalQuestions.getmOEPref().equals("6") ? 1 : 0;
                mOEFemalePrefFemale += vocalQuestions.getmOEPref().equals("7") ? 1: 0;

                myOneFemalePrefMale += vocalQuestions.getMyOnePref().equals(("6")) ? 1 : 0;
                myOneFemalePrefFemale += vocalQuestions.getMyOnePref().equals("7") ? 1 : 0;

                flyOnFemalePrefMale += vocalQuestions.getFlyOnPref().equals("6") ? 1 : 0;
                flyOnFemalePrefFemale += vocalQuestions.getFlyOnPref().equals("7") ? 1 : 0;
            }
        }

        double shineMaleMalePerc = ((double) shineMalePrefMale / maleTotal) * 100;
        double shineMaleFemalePerc = ((double) shineMalePrefFemale / maleTotal) * 100;
        double clearlyMaleMalePerc = ((double) clearlyMalePrefMale / maleTotal) * 100;
        double clearlyMaleFemalePerc = ((double) clearlyMalePrefFemale / maleTotal) * 100;
        double fineMaleMalePerc = ((double) fineMalePrefMale / maleTotal) * 100;
        double fineMaleFemalePerc = ((double) fineMalePrefFemale / maleTotal) * 100;
        double mOEMaleMalePerc = ((double) mOEMalePrefMale / maleTotal) * 100;
        double mOEMaleFemalePerc = ((double) mOEMalePrefFemale / maleTotal) * 100;
        double myOneMaleMalePerc = ((double) myOneMalePrefMale / maleTotal) * 100;
        double myOneMaleFemalePerc = ((double) myOneMalePrefFemale / maleTotal) * 100;
        double flyOnMaleMalePerc = ((double) flyOnMalePrefMale / maleTotal) * 100;
        double flyOnMaleFemalePerc = ((double) flyOnMalePrefFemale / maleTotal) * 100;

        double shineFemaleMalePerc = ((double) shineFemalePrefMale / femaleTotal) * 100;
        double shineFemaleFemalePerc = ((double) shineFemalePrefFemale / femaleTotal) * 100;
        double clearlyFemaleMalePerc = ((double) clearlyFemalePrefMale / femaleTotal) * 100;
        double clearlyFemaleFemalePerc = ((double) clearlyFemalePrefFemale / femaleTotal) * 100;
        double fineFemaleMalePerc = ((double) fineFemalePrefMale / femaleTotal) * 100;
        double fineFemaleFemalePerc = ((double) fineFemalePrefFemale / femaleTotal) * 100;
        double mOEFemaleMalePerc = ((double) mOEFemalePrefMale / femaleTotal) * 100;
        double mOEFemaleFemalePerc = ((double) mOEFemalePrefFemale / femaleTotal) * 100;
        double myOneFemaleMalePerc = ((double) myOneFemalePrefMale / femaleTotal) * 100;
        double myOneFemaleFemalePerc = ((double) myOneFemalePrefFemale / femaleTotal) * 100;
        double flyOnFemaleMalePerc = ((double) flyOnFemalePrefMale / femaleTotal) * 100;
        double flyOnFemaleFemalePerc = ((double) flyOnFemalePrefFemale / femaleTotal) * 100;


        displayPreferenceResults("Shine", "Male", shineMalePrefMale, shineMaleMalePerc, shineMalePrefFemale, shineMaleFemalePerc);
        displayPreferenceResults("Shine", "Female", shineFemalePrefMale, shineFemaleMalePerc, shineFemalePrefFemale, shineFemaleFemalePerc);

        outputToText.writeToText("");

        displayPreferenceResults("Clearly", "Male", clearlyMalePrefMale, clearlyMaleMalePerc, clearlyMalePrefFemale, clearlyMaleFemalePerc);
        displayPreferenceResults("Clearly", "Female", clearlyFemalePrefMale, clearlyFemaleMalePerc, clearlyFemalePrefFemale, clearlyFemaleFemalePerc);

        outputToText.writeToText("");

        displayPreferenceResults("Fine", "Male", fineMalePrefMale, fineMaleMalePerc, fineMalePrefFemale, fineMaleFemalePerc);
        displayPreferenceResults("Fine", "Female", fineFemalePrefMale, fineFemaleMalePerc, fineFemalePrefFemale, fineFemaleFemalePerc);

        outputToText.writeToText("");

        displayPreferenceResults("MOE", "Male", mOEMalePrefMale, mOEMaleMalePerc, mOEMalePrefFemale, mOEMaleFemalePerc);
        displayPreferenceResults("MOE", "Female", mOEFemalePrefMale, mOEFemaleMalePerc, mOEFemalePrefFemale, mOEFemaleFemalePerc);

        outputToText.writeToText("");

        displayPreferenceResults("My One", "Male", myOneMalePrefMale, myOneMaleMalePerc, myOneMalePrefFemale, myOneMaleFemalePerc);
        displayPreferenceResults("My One", "Female", myOneFemalePrefMale, myOneFemaleMalePerc, myOneFemalePrefFemale, myOneFemaleFemalePerc);

        outputToText.writeToText("");

        displayPreferenceResults("Fly On", "Male", flyOnMalePrefMale, flyOnMaleMalePerc, flyOnMalePrefFemale, flyOnMaleFemalePerc);
        displayPreferenceResults("Fly On", "Female", flyOnFemalePrefMale, flyOnFemaleMalePerc, flyOnFemalePrefFemale, flyOnFemaleFemalePerc);

    }

    private void displayPreferenceResults(String track, String gender, int prefMale, double prefMalePerc, int prefFemale, double prefFemalePerc) {
        String formattedOutput = String.format(
            "Track: %s Gender: %s Prefers Male: %d (%.2f%%) Prefers Female: %d (%.2f%%)",
            track, gender, prefMale, prefMalePerc, prefFemale, prefFemalePerc
        );
        outputToText.writeToText(formattedOutput);
    }

    private void getParticipantFamiliarity(String gender, boolean outPutStats){
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
            if (gender.equals("Male") && vocalQuestions.getParticipantGender().equals("1")){
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
            } else if (gender.equals("Female") && vocalQuestions.getParticipantGender().equals("0")){
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

        switch (gender){
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

        if (outPutStats){
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
        } else {
            double shineMeanTotal = totalMean(shineSimMean, shineSuitsMean, shineMarkMean);
            double clearlyMeanTotal = totalMean(clearlySimMean, clearlySuitsMean, clearlyMarkMean);
            double fineMeanTotal = totalMean(fineSimMean, fineSuitsMean, fineMarkMean);
            double mOEMeanTotal = totalMean(mOESimMean, mOESuitsMean, mOEMarkMean);
            double myOneMeanTotal = totalMean(myOneSimMean, myOneSuitsMean, myOneMarkMean);
            double flyOnMeanTotal = totalMean(flyOnSimMean, flyOnSuitsMean, flyOnMarkMean);

            getRankings(gender, shineMeanTotal, clearlyMeanTotal, fineMeanTotal, mOEMeanTotal, myOneMeanTotal, flyOnMeanTotal);
        }
        
    }

    private void displayPreferenceResults(String track, double result){
        outputToText.writeToText(String.format("%s - %.2f", track, result));
    }

    private double totalMean(double sim, double suits, double mark){
        return sim + suits + mark;
    }

    private void getRankings(String gender, double shineMean, double clearlyMean, double fineMean, double mOEMean, double myOneMean, double flyOnMean){
        LinkedList<TotalMean> totalMeans = new LinkedList<>();

        totalMeans.add(new TotalMean("Shine", shineMean));
        totalMeans.add(new TotalMean("Clearly", clearlyMean));
        totalMeans.add(new TotalMean("Fine", fineMean));
        totalMeans.add(new TotalMean("MOE", mOEMean));
        totalMeans.add(new TotalMean("My One", myOneMean));
        totalMeans.add(new TotalMean("Fly On", flyOnMean));

        Collections.sort(totalMeans, new Comparator<TotalMean>() {
            public int compare(TotalMean t1, TotalMean t2) {
                return Double.compare(t2.getTotalMeanScore(), t1.getTotalMeanScore());
            }
        });

        displayRankings(gender, totalMeans);
    }

    private void displayRankings(String gender, LinkedList<TotalMean> totalMeans){
        

        outputToText.writeToText(gender + "Rankings");

        for (TotalMean totalMean : totalMeans){
            String track = totalMean.getTrackName();
            String score = String.format("%.2f", totalMean.getTotalMeanScore());
            outputToText.writeToText(track + ": " + score);
        }
        System.out.println("Created file");
    }
}
