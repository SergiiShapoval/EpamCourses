package ua.epam.sergiishapoval.homework.hw7.huffman.inside_entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Сергей on 07.11.2014.
 */
public class SymbolCalculator {

    private String fileAddress;
    private String receivedText;

    public SymbolCalculator(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getReceivedText() {
        return receivedText;
    }

    public Map<Character, Integer> getCharFrequency() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
        StringBuilder textBuffer = new StringBuilder();

        while (reader.ready()){
            textBuffer.append(reader.readLine());
            if (reader.ready()) {
                textBuffer.append("\r\n");
            }
        }

        receivedText = textBuffer.toString();

        Map<Character, Integer> charFrequency = new HashMap<>();


        for (int i = 0; i < receivedText.length(); i++) {
            char currentChar = receivedText.charAt(i);

            if (!charFrequency.containsKey(currentChar)){
                charFrequency.put(currentChar, 1);
            } else {
                charFrequency.put(currentChar, charFrequency.get(currentChar) + 1);
            }
        }

        return charFrequency;

    }
}
