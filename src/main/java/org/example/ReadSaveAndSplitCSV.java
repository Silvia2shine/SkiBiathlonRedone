package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.*;

/**
 * A  class that read and save  the CSV file.;
 *
 * @param - file path;
 * @param - path;
 */
public class ReadSaveAndSplitCSV {

    public String readAndSaveCSV() {
        String filePath = "results.csv";
        Path path = Paths.get(filePath);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        String fileContent = new String(bytes, StandardCharsets.UTF_8);
        return fileContent;
    }
    public String[] splitIntoLines(String line) {
        String[] tokensSentences = line.split("\n");
        return tokensSentences;
    }

    public String[] splitIntoWords(String line) {


        String[] tokensWord = line.split(",");
        return tokensWord;
    }
}
