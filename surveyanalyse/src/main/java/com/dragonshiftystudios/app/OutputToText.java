package com.dragonshiftystudios.app;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputToText {

    BufferedWriter writer;

    public void openTextFile(){
        try {
            writer = new BufferedWriter(new FileWriter("output.txt", true));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeToText(String line){
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeTextFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
