package ua.epam.sergiishapoval.lecturescodeonsite.lecture20102014.longfloat;

/**
 * Created by Сергей on 20.10.2014.
 */
public class Long{
    public static void main(String[] args) {
        long l=111111111111L;
        float f = l;
        System.out.println(f);
        l = (long) f;
        System.out.print(l);
    }
}
