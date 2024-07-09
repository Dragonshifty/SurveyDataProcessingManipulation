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
}
