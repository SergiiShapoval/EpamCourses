package ua.epam.sergiishapoval.homework.hw6.checkedlist;

/**
 * Created by Сергей on 05.11.2014.
 */
public class TestSecurList {
    public static void main(String[] args) {
        SecureArrayList secureArrayList = new SecureArrayList(4);
        secureArrayList.add(56);
        secureArrayList.add(57);
        secureArrayList.add(56);
        secureArrayList.add(59);
//        secureArrayList.put(180);

//        System.out.println(secureArrayList.get(59));
        System.out.println(secureArrayList.remove(Integer.valueOf(59)));
        System.out.println(secureArrayList.remove(1));
        System.out.println(secureArrayList.remove(Integer.valueOf(4)));



    }
}
