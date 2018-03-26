package utils;

import logic.processors.Processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

    public InputReader(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                Processor processor = ProcessorFactory.getProcessor(currentLine);
                processor.process();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
