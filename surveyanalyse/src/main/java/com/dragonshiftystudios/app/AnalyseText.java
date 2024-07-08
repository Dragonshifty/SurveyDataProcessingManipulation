package com.dragonshiftystudios.app;
import java.util.LinkedList;
import java.util.Arrays;

public class AnalyseText {
    CSVConverter csvConverter = new CSVConverter();
    
    private LinkedList<Participant> participants = new LinkedList<>();

    public void startDescriptionAnalysis(){
        getParticpantsList();
        analyseForGender();
        csvConverter.insertGenderCodeAndRebuildCSV(participants);
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
}
