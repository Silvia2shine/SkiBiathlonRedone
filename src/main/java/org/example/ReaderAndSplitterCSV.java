package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A  class that read and save  the CSV file.;
 *
 * @param - file path;
 * @param - path;
 */
public class ReaderAndSplitterCSV {

    public String readerCSV() {
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
    public String[] splitterIntoLines(String line) {
        String[] tokensSentences = line.split("\n");
        return tokensSentences;
    }

    public String[] splitterIntoWords(String line) {


        String[] tokensWord = line.split(",");
        return tokensWord;
    }
}
