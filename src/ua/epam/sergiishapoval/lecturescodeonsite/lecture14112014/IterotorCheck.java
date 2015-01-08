package ua.epam.sergiishapoval.lecturescodeonsite.lecture14112014;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Сергей on 14.11.2014.
 */
public class IterotorCheck {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        Iterator<String> iterator = list.iterator();
        for (; iterator.hasNext();  ){
            String currentString =  iterator.next();
            System.out.println(currentString);
        }
    }
}
