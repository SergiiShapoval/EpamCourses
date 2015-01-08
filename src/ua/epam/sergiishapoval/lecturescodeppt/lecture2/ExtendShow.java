package ua.epam.sergiishapoval.lecturescodeppt.lecture2 ;

/**
 * Created by Сергей on 20.10.2014.
 */
public class ExtendShow extends SuperShow  {
    public String str = "ExtendStr";
    public void show() {
        System.out.println("Extend.show: " + str); }

    public static void main(String[] args) {
        ExtendShow ext = new ExtendShow();
        SuperShow sup = ext;
        sup.show(); // вызывается show из класса ExtendShow
        ext.show(); // вызывается show из класса ExtendShow
        System.out.println("sup.str = " + sup.str);//печатается SuperStr
        System.out.println("ext.str = " + ext.str); // печатается ExtendStr
    }
}

