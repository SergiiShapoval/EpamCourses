package ua.epam.sergiishapoval.homework.hw17.leapyear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Сергей on 25.12.2014.
 */
public class LeapYear {
    
    public static final String LEAP_YEAR = "Entered year is a leap-year";
    public static final String REGULAR_YEAR = "Entered year is not a leap-year";
    public static final String NAN = "String you have entered in a not Number";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter a year to check");
        String yearToCheck = reader.readLine();
        if (yearToCheck.matches("\\d+")){
            Pattern pattern = Pattern.compile("(\\d+)00$");
            Matcher matcher = pattern.matcher(yearToCheck);
            if (matcher.matches()){
                int century = Integer.parseInt(matcher.group(1));
                if (century % 4 == 0) System.out.println(LEAP_YEAR);
                else System.out.println(REGULAR_YEAR);
            }else {
                int year = Integer.parseInt(yearToCheck);
                if (year % 4 == 0) System.out.println(LEAP_YEAR);
                else System.out.println(REGULAR_YEAR);
            }
        }else System.out.println(NAN);
    }
}
