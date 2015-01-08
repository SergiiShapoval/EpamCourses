package ua.epam.sergiishapoval.homework.hw17;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Сергей on 25.12.2014.
 */
public class PatternException {

    public static void main(String[] args) {

        try {
            String emailRegEx = "(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*";
            //  String emailRegEx = "(?s).*";
            Pattern pattern = Pattern.compile(emailRegEx);

            String target= "You can email me at g_andy@example.com or andy@example.net to get more info";
            String target2="You can email";
            java.util.regex.Matcher matcher; {

                matcher = pattern.matcher(target);

                while(matcher.find()) {
                    System.out.println("Found a Match" + matcher.group());
                    System.out.println("Start position: " + matcher.start());
                    System.out.println("End position: " + matcher.end());
                }}} catch (StackOverflowError e) {
            System.out.println("Stackoverflow");
            //JOptionPane.showMessageDialog(null, "Stackoverflow");
        }
    }

}
