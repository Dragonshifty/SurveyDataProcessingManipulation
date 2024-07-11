package com.dragonshiftystudios.app;


public class App 
{
    public static void main( String[] args )
    {
        AnalyseText analyseText = new AnalyseText();
        AnalyseQuestions analyseQuestions = new AnalyseQuestions();
        AnalyseByParticipantGender analyseByParticipantGender = new AnalyseByParticipantGender();

        // Run whatever is required

        analyseText.getSuggestedGenderByGender();
        
        // analyseByParticipantGender.outPutPreferenceByGender();
        // analyseByParticipantGender.outPutFamiliarityByGender()
        // analyseByParticipantGender.outPutRankingsByGender();

        // analyseByParticipantGender.debugShineTrackPreferences();
        
        // analyseText.startDescriptionAnalysis();
        // analyseText.showSuggestedGenderScores();

        // analyseQuestions.getVocalQuestionsList();
        // analyseQuestions.openFileWriter();
        // analyseQuestions.getPreferencesTotal();
        // analyseQuestions.getGenderedPreferences("Male");
        // analyseQuestions.getGenderedPreferences("Female");
        
        // analyseQuestions.getSimilarity("Total");
        // analyseQuestions.getSimilarity("Male");
        // analyseQuestions.getSimilarity("Female");

        // analyseQuestions.closeFileWriter();
    }
}
