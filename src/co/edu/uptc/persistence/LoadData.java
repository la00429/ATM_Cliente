package co.edu.uptc.persistence;

import java.io.*;
import java.util.ArrayList;

public class LoadData {
    public ArrayList<String> readTxt(String path) {
        ArrayList<String> fileAll = new ArrayList<String>();
        File file = new File(path);
        String line;
        try (FileReader fileReader = new FileReader(file); BufferedReader process = new BufferedReader(fileReader)) {

            while ((line = process.readLine()) != null) {
                if (!line.isEmpty()) {
                    fileAll.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileAll;
    }
}
