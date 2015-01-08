package ua.epam.sergiishapoval.homework.hw6.checkedlist2;

/**
 * Created by Сергей on 05.11.2014.
 */
public class TestSecurListContinue {
    public static void main(String[] args) {
        SecureArrayListContinue secureArrayList = new SecureArrayListContinue(4);
        secureArrayList.add(56);
        secureArrayList.add(57);
        secureArrayList.add(56);
        secureArrayList.add(59);
        secureArrayList.add(180);

        System.out.println(secureArrayList.get(59));
        System.out.println(secureArrayList.remove(Integer.valueOf(59)));
        System.out.println(secureArrayList.remove(1));
        System.out.println(secureArrayList.remove(Integer.valueOf(4)));



    }
}
