package com.dragonshiftystudios.app;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CSVConverter {
    private String descriptionsCSV = "descriptions with gender.csv";
    private String vocalQuestionsFullCSV = "VocalQuestionsFull.csv";
    private String vocalQuestionsFullWithGender = "VocalQuestionsFullWithGender.csv";

    public LinkedList<Participant> populateParticipants(){
        LinkedList<Participant> participants = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(descriptionsCSV))){
            String[] nextLine;
            int lineNumber = 0;
    
            while ((nextLine = reader.readNext()) != null){
                lineNumber++;

                if (lineNumber <= 3) continue;

                String columnDW = nextLine[0];
                String columnR = nextLine[1];
                String columnT = nextLine[2];

                Participant participant = new Participant(columnDW, columnR, columnT);
                participants.add(participant);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return participants;
    }

    public void insertGenderCodeAndRebuildCSV(LinkedList<Participant> amendedList){
        String descriptionWithGender = "DescriptionsWithGenderWithParticipant.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(descriptionWithGender))){
            csvWriter.writeNext(new String[] {"Dream Wistfully", "DW Gender", "Rising", "Rising Gender", "Triggered", "Triggered Gender"});

            for (Participant participant : amendedList){
                csvWriter.writeNext(new String[]{
                    participant.getDreamWistfullyDescription(),
                    participant.getSuggestedGenderDW(),
                    participant.getRisingDescription(),
                    participant.getSuggestedGenderR(),
                    participant.getTriggeredDescription(),
                    participant.getSuggestedGenderT(),
                });
            }
            System.out.println("CSV Created");
        } catch (IOException es){
            es.printStackTrace();
        }
    }

    public LinkedList<VocalQuestions> populateVocalQuestions(){
        LinkedList<VocalQuestions> vocalQuestionsList = new LinkedList<>();
        

        try (CSVReader reader = new CSVReader(new FileReader(vocalQuestionsFullWithGender))){
            String[] nextLine;
            int lineNumber = 0;
    
            while ((nextLine = reader.readNext()) != null){
                lineNumber++;

                if (lineNumber <= 2) continue;

                if (nextLine[0] == null || nextLine[0].trim().isEmpty()){
                    String gender = "Female";
                    String shinePref = nextLine[24];
                    String shineSim = nextLine[25];
                    String shineSuits = nextLine[26];
                    String shineMark = nextLine[27];

                    String clearlyPref = nextLine[28];
                    String clearlySim = nextLine[29];
                    String clearlySuits = nextLine[30];
                    String clearlyMark = nextLine[31];

                    String finePref = nextLine[32];
                    String fineSim = nextLine[33];
                    String fineSuits = nextLine[34];
                    String fineMark = nextLine[35];

                    String mOEPref = nextLine[36];
                    String mOESim = nextLine[37];
                    String mOESuits = nextLine[38];
                    String mOEMark = nextLine[39];

                    String myOnePref = nextLine[40];
                    String myOneSim = nextLine[41];
                    String myOneSuits = nextLine[42];
                    String myOneMark = nextLine[43];

                    String flyOnPref = nextLine[44];
                    String flyOnSim = nextLine[45];
                    String flyOnSuits = nextLine[46];
                    String flyOnMark = nextLine[47];

                    String particpantGender = nextLine[48];

                    VocalQuestions vocalQuestions = new VocalQuestions(gender, shinePref, clearlyPref, finePref, mOEPref, myOnePref, flyOnPref, shineSim, clearlySim, fineSim, mOESim, myOneSim, flyOnSim, shineSuits, clearlySuits, fineSuits, mOESuits, myOneSuits, flyOnSuits, shineMark, clearlyMark, fineMark, mOEMark, myOneMark, flyOnMark, particpantGender);

                    vocalQuestionsList.add(vocalQuestions);
                } else {
                    String gender = "Male";

                    String shinePref = nextLine[0];
                    String shineSim = nextLine[1];
                    String shineSuits = nextLine[2];
                    String shineMark = nextLine[3];

                    String clearlyPref = nextLine[4];
                    String clearlySim = nextLine[5];
                    String clearlySuits = nextLine[6];
                    String clearlyMark = nextLine[7];

                    String finePref = nextLine[8];
                    String fineSim = nextLine[9];
                    String fineSuits = nextLine[10];
                    String fineMark = nextLine[11];

                    String mOEPref = nextLine[12];
                    String mOESim = nextLine[13];
                    String mOESuits = nextLine[14];
                    String mOEMark = nextLine[15];

                    String myOnePref = nextLine[16];
                    String myOneSim = nextLine[17];
                    String myOneSuits = nextLine[18];
                    String myOneMark = nextLine[19];

                    String flyOnPref = nextLine[20];
                    String flyOnSim = nextLine[21];
                    String flyOnSuits = nextLine[22];
                    String flyOnMark = nextLine[23];

                    String particpantGender = nextLine[48];

                    VocalQuestions vocalQuestions = new VocalQuestions(gender, shinePref, clearlyPref, finePref, mOEPref, myOnePref, flyOnPref, shineSim, clearlySim, fineSim, mOESim, myOneSim, flyOnSim, shineSuits, clearlySuits, fineSuits, mOESuits, myOneSuits, flyOnSuits, shineMark, clearlyMark, fineMark, mOEMark, myOneMark, flyOnMark, particpantGender);
                    
                    vocalQuestionsList.add(vocalQuestions);
                }
            }       
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return vocalQuestionsList;
    }
}
