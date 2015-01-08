package ua.epam.sergiishapoval.homework.hw13.polnote;

import ua.epam.sergiishapoval.homework.hw13.polnote.elements.Operation;

import java.io.*;

/**
 * Created by Сергей on 24.11.2014.
 */
public class PolishNoteTest {
    public static void main(String[] args) throws IOException {
        Operation operation = Operation.DIVIDE;
        Operation operation1 = Operation.MULTIPLY;

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Dropbox\\epam\\EpamCoursesCode\\src\\ua\\epam\\sergiishapoval\\homework\\hw13\\polnote\\expression"));
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()){
            stringBuilder.append(reader.readLine());
        }
        String expression = stringBuilder.toString();
        System.out.println(expression);
        expression = expression.replaceAll("\\s","");

        System.out.println(expression);

        PolishNotation polishNotation = new PolishNotation(expression);

        System.out.println(polishNotation.calculate());


    }
}
