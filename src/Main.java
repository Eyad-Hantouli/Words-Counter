// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int chars, statements;
        chars = 0;
        statements = 0;

        String filePath = "your\\file\\path\\here.txt";

        List<String> lines = new ArrayList<>();
        int wordCount = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Printing the lines
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);
                chars++;
                if (character == '.') {
                    statements++;
                }
            }
        }

        System.out.println("Characters: " + chars);
        System.out.println("Words: " + wordCount);
        System.out.println("Statements: " + statements);
    }
}