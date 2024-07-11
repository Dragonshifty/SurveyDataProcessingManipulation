package com.dragonshiftystudios.app;
import java.util.LinkedList;
import java.util.Arrays;

public class AnalyseText {
    CSVConverter csvConverter = new CSVConverter();
    OutputToText outputToText = new OutputToText();
    String genderByGenderFileName = "suggestedgenderbygender.txt";
    
    private LinkedList<Participant> participants = new LinkedList<>();

    public void startDescriptionAnalysis(){
        getParticpantsList();
        analyseForGender();
        csvConverter.insertGenderCodeAndRebuildCSV(participants);
    }

    public void getSuggestedGenderByGender(){
        getParticpantsList();
        analyseForGender();
        outputToText.setFileName(genderByGenderFileName);
        outputToText.openTextFile();
        showSuggestedGenderScoresByParticipantGender();
        outputToText.closeTextFile();
    }
    
    public void getParticpantsList()
    {
        participants = csvConverter.populateParticipants();      
    }

    private void analyseForGender(){
        String[] maleNames = {"male", "males", "man", "men", "bloke", 
                            "chap", "boy", "guy", "guys", "beard"};
        String[] femaleNames = {"female", "females", "woman", "women", 
                            "girl", "cowgirl", "lady"};
        String[] nonBinaryNames = {"non binary", "non-binary", "nonbinary", "androgynous"};

        for (int i  = 0; i < participants.size(); i++){
            String descriptionDW = participants.get(i).getDreamWistfullyDescription().toLowerCase();
            String descriptionR = participants.get(i).getRisingDescription().toLowerCase();
            String descriptionT = participants.get(i).getTriggeredDescription().toLowerCase();

            boolean containsMaleDW = detectGender(maleNames, descriptionDW);
            boolean containsMaleR = detectGender(maleNames, descriptionR);
            boolean containsMaleT = detectGender(maleNames, descriptionT);

            boolean containsFemaleDW = detectGender(femaleNames, descriptionDW);
            boolean containsFemaleR = detectGender(femaleNames, descriptionR);
            boolean containsFemaleT = detectGender(femaleNames, descriptionT);

            boolean containsNonBinaryDW = detectGender(nonBinaryNames, descriptionDW);
            boolean containsNonBinaryR = detectGender(nonBinaryNames, descriptionR);
            boolean containsNonBinaryT = detectGender(nonBinaryNames, descriptionT);

            setGenderCode(i, "DW", containsMaleDW, containsFemaleDW, containsNonBinaryDW);
            setGenderCode(i, "R", containsMaleR, containsFemaleR, containsNonBinaryR);
            setGenderCode(i, "T", containsMaleT, containsFemaleT, containsNonBinaryT);
        }
    }

    private boolean detectGender(String[] names, String description){
        return Arrays.stream(names).anyMatch(word -> description.matches(".*\\b" + word + "\\b.*"));
    }

    private void setGenderCode(int index, String song, boolean male, boolean female, boolean nonBinary){        
      if ((male && female) || (male && nonBinary) || (female && nonBinary)){
            switch (song){
                case "DW":
                    participants.get(index).setSuggestedGenderDW("");
                    break;
                case "R":
                    participants.get(index).setSuggestedGenderR("");
                    break;
                case "T":
                    participants.get(index).setSuggestedGenderT("");
                    break;
                default:
                    System.out.println("Error set gender code");
            }
        } else if (male){
            switch (song){
                case "DW":
                    participants.get(index).setSuggestedGenderDW("1");
                    break;
                case "R":
                    participants.get(index).setSuggestedGenderR("1");
                    break;
                case "T":
                    participants.get(index).setSuggestedGenderT("1");
                    break;
                default:
                    System.out.print("Error set gender code");
            }
        } else if (female){
            switch(song){
                case "DW":
                    participants.get(index).setSuggestedGenderDW("2");
                    break;
                case "R":
                    participants.get(index).setSuggestedGenderR("2");
                    break;
                case "T":
                    participants.get(index).setSuggestedGenderT("2");
                    break;
                default:
                    System.out.print("Error set gender code");
            }
        } else if (nonBinary){
            switch(song){
                case "DW":
                    participants.get(index).setSuggestedGenderDW("3");
                    break;
                case "R":
                    participants.get(index).setSuggestedGenderR("3");
                    break;
                case "T":
                    participants.get(index).setSuggestedGenderT("3");
                    break;
                default:
                    System.out.print("Error set gender code");
            }
        }
    }

    public void showSuggestedGenderScores()
    {
        int dwMale = 0;
        int dwFemale = 0;
        int dwNonBinary = 0;
        int dwUndeclared = 0;

        int rMale = 0;
        int rFemale = 0;
        int rNonBinary = 0;
        int rUndeclared = 0;

        int tMale = 0;
        int tFemale = 0;
        int tNonBinary = 0;
        int tUndeclared = 0;

        for (Participant participant : participants){
            String dwGender = participant.getSuggestedGenderDW();
            String rGender = participant.getSuggestedGenderR();
            String tGender = participant.getSuggestedGenderT();
            
            if (dwGender == null){
                dwUndeclared++;
            } else {
                switch (dwGender) {
                    case "1":
                        dwMale++;
                        break;
                    case "2":
                        dwFemale++;
                        break;
                    case "3":
                        dwNonBinary++;
                        break;
                    default:
                        dwUndeclared++;
                        break;
                }
            }
            
            if (rGender == null){
                rUndeclared++;
            } else {
                switch (rGender) {
                    case "1":
                        rMale++;
                        break;
                    case "2":
                        rFemale++;
                        break;
                    case "3":
                        rNonBinary++;
                        break;
                    default:
                        rUndeclared++;
                        break;
                }
            }
            
            if (tGender == null){
                tUndeclared++;
            } else {
                switch (tGender) {
                    case "1":
                        tMale++;
                        break;
                    case "2":
                        tFemale++;
                        break;
                    case "3":
                        tNonBinary++;
                        break;
                    default:
                        tUndeclared++;
                        break;
                }
            }  
        }


        System.out.println("DW Male " + dwMale);
        System.out.println("DW Female " + dwFemale);
        System.out.println("DW Undelcared " + dwUndeclared);
        System.out.println("DW Non Binary " + dwNonBinary);

        System.out.println("R Male " + rMale);
        System.out.println("R Female " + rFemale);
        System.out.println("R Undelcared " + rUndeclared);
        System.out.println("RNon Binary " + rNonBinary);

        System.out.println("T Male " + tMale);
        System.out.println("T Female " + tFemale);
        System.out.println("T Undelcared " + tUndeclared);
        System.out.println("T Non Binary " + tNonBinary);
    }

    public void showSuggestedGenderScoresByParticipantGender()
    {
        // Track, suggested gender, participant gender
        int dwMaleMale = 0;
        int dwFemaleMale = 0;
        int dwNonBinaryMale = 0;
        int dwUndeclaredMale = 0;

        int rMaleMale = 0;
        int rFemaleMale = 0;
        int rNonBinaryMale = 0;
        int rUndeclaredMale = 0;

        int tMaleMale = 0;
        int tFemaleMale = 0;
        int tNonBinaryMale = 0;
        int tUndeclaredMale = 0;

        int dwMaleFemale = 0;
        int dwFemaleFemale = 0;
        int dwNonBinaryFemale = 0;
        int dwUndeclaredFemale = 0;

        int rMaleFemale = 0;
        int rFemaleFemale = 0;
        int rNonBinaryFemale = 0;
        int rUndeclaredFemale = 0;

        int tMaleFemale = 0;
        int tFemaleFemale = 0;
        int tNonBinaryFemale = 0;
        int tUndeclaredFemale = 0;

        int femaleParticipant = 0;
        int maleParticipant = 0;

        for (Participant participant : participants){
            String dwGender = participant.getSuggestedGenderDW();
            String rGender = participant.getSuggestedGenderR();
            String tGender = participant.getSuggestedGenderT();
            String participantGender = participant.getParticipantGender();
            if (participantGender.equals("0")) femaleParticipant++;
            if (participantGender.equals("1")) maleParticipant++;
            
            if (dwGender == null){
                if (participantGender.equals("0")) dwUndeclaredFemale++;
                if (participantGender.equals("1")) dwUndeclaredMale++;
            } else {
                switch (dwGender) {
                    case "1":
                        if (participantGender.equals("0")) dwMaleFemale++;
                        if (participantGender.equals("1")) dwMaleMale++;
                        break;
                    case "2":
                        if (participantGender.equals("0")) dwFemaleFemale++;
                        if (participantGender.equals("1")) dwFemaleMale++;
                        break;
                    case "3":
                        if (participantGender.equals("0")) dwNonBinaryFemale++;
                        if (participantGender.equals("1")) dwNonBinaryMale++;
                        break;
                    default:
                        if (participantGender.equals("0")) dwUndeclaredFemale++;
                        if (participantGender.equals("1")) dwUndeclaredMale++;
                        break;
                }
            }
            
            if (rGender == null){
                if (participantGender.equals("0")) rUndeclaredFemale++;
                if (participantGender.equals("1")) rUndeclaredMale++;
            } else {
                switch (rGender) {
                    case "1":
                        if (participantGender.equals("0")) rMaleFemale++;
                        if (participantGender.equals("1")) rMaleMale++;
                        break;
                    case "2":
                        if (participantGender.equals("0")) rFemaleFemale++;
                        if (participantGender.equals("1")) rFemaleMale++;
                        break;
                    case "3":
                        if (participantGender.equals("0")) rNonBinaryFemale++;
                        if (participantGender.equals("1")) rNonBinaryMale++;
                        break;
                    default:
                        if (participantGender.equals("0")) rUndeclaredFemale++;
                        if (participantGender.equals("1")) rUndeclaredMale++;
                        break;
                }
            }
            
            if (tGender == null){
                if (participantGender.equals("0")) tUndeclaredFemale++;
                if (participantGender.equals("1")) tUndeclaredMale++;
            } else {
                switch (tGender) {
                    case "1":
                        if (participantGender.equals("0")) tMaleFemale++;
                        if (participantGender.equals("1")) tMaleMale++;
                        break;
                    case "2":
                        if (participantGender.equals("0")) tFemaleFemale++;
                        if (participantGender.equals("1")) tFemaleMale++;
                        break;
                    case "3":
                        if (participantGender.equals("0")) tNonBinaryFemale++;
                        if (participantGender.equals("1")) tNonBinaryMale++;
                        break;
                    default:
                        if (participantGender.equals("0")) tUndeclaredFemale++;
                        if (participantGender.equals("1")) tUndeclaredMale++;
                        break;
                }
            }  
        }

        int[] gendArray = {
            dwMaleMale,
            dwFemaleMale,
            dwNonBinaryMale,
            dwUndeclaredMale,

            rMaleMale,
            rFemaleMale,
            rNonBinaryMale,
            rUndeclaredMale,

            tMaleMale,
            tFemaleMale,
            tNonBinaryMale,
            tUndeclaredMale,

            dwMaleFemale,
            dwFemaleFemale,
            dwNonBinaryFemale,
            dwUndeclaredFemale,

            rMaleFemale,
            rFemaleFemale,
            rNonBinaryFemale,
            rUndeclaredFemale,

            tMaleFemale,
            tFemaleFemale,
            tNonBinaryFemale,
            tUndeclaredFemale
        };

        for (int i = 0; i < gendArray.length; i++){
            String participantGend = i < 12 ? "Male" : "Female";

            String suggestedGend = "";
            if (i % 4 == 0) {
                suggestedGend = "Male";
            } else if (i % 4 == 1) {
                suggestedGend = "Female";
            } else if (i % 4 == 2) {
                suggestedGend = "Non-Binary";
            } else if (i % 4 == 3) {
                suggestedGend = "Undeclared";
            }

            String trackName = "";
            if ((i >= 0 && i < 4) || (i >= 12 && i < 16)) {
                trackName = "DW";
            } else if ((i >= 4 && i < 8) || (i >= 16 && i < 20)) {
                trackName = "Rising";
            } else if ((i >= 8 && i < 12) || (i >= 20 && i < 24)) {
                trackName = "Triggered";
            }

            int counter = gendArray[i];
            int participantCounter = i < 12 ? maleParticipant : femaleParticipant;

            outputGenderByGender(participantGend, suggestedGend, trackName, counter, participantCounter);
        }
        
        // outputGenderByGender("Male", "Male", "DW", dwMaleMale, maleParticipant);
        // outputGenderByGender("Male", "Female", "DW", dwFemaleMale, maleParticipant);
        // outputGenderByGender("Male", "NB", "DW", dwNonBinaryMale, maleParticipant); 
        // outputGenderByGender("Male", "Undeclared", "DW", dwUndeclaredMale, maleParticipant);
    }

    private void outputGenderByGender(String participantGender, String suggestedGender, String track, int count, int genderCount) {
        double percentage = ((double) count / genderCount) * 100;
        outputToText.writeToText(String.format("Participant: %s Suggested Gender: %s Track: %s - %d (%.2f%%)", participantGender, suggestedGender, track, count, percentage));
    }
}
