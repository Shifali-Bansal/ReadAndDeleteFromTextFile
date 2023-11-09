package com.newgen.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    public static void main(String[] args) {
        // Replace "path/to/your/input/file.txt" with the actual path of your text file
        String filePath = "path/to/your/input/file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
