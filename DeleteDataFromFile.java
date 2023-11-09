package com.newgen.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DeleteDataFromFile {

    public static void main(String[] args) {
        // Replace "path/to/your/input/file.txt" with the actual path of your text file
        String filePath = "path/to/your/input/file.txt";

        // Replace "DataToRemove" with the data you want to remove
        String dataToRemove = "DataToRemove";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("path/to/your/output/temp.txt"))) {

            String line;

            // Read each line from the file and write to a temporary file, excluding lines with the specified data
            while ((line = reader.readLine()) != null) {
                if (!line.contains(dataToRemove)) {
                    writer.write(line);
                    writer.newLine(); // Add a new line for clarity or to separate entries
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename the temporary file to the original file
        try {
            Files.move(Paths.get("path/to/your/output/temp.txt"), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Data removed from the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
