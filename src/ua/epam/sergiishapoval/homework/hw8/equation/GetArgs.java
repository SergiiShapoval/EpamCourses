package ua.epam.sergiishapoval.homework.hw8.equation;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Сергей on 11.11.2014.
 */
public class GetArgs {
    BufferedReader reader;

    public GetArgs(BufferedReader reader) {
        this.reader = reader;
    }

    public double getArgument() throws IOException {
        double argument = 0.0;
        try{

            System.out.println("Please enter double as an argument");
            while (true){
                try {
                    argument = Double.parseDouble(reader.readLine());
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Value should be a decimal. Please, try again");
                }
            }
        }catch (IOException e) {
            throw e;
        }
        return argument;
    }




}
