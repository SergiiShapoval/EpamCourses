package ua.epam.sergiishapoval.homework.hw8.integral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Сергей on 11.11.2014.
 */
public class GetTask {
    BufferedReader reader;

    public GetTask(BufferedReader reader) {
        this.reader = reader;
    }

    public double getArgument() throws IOException{
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
    public int getThreadQty() throws IOException{
        int argument = 0;
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter number for threads qty");
            while (true){
                try {
                    argument = Integer.parseInt(reader.readLine());
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Value should be an integer. Please, try again");
                }
            }
        }catch (IOException e) {
            throw e;
        }
        return argument;
    }




}
