package ua.epam.sergiishapoval.homework.hw12.skipmap;

/**
 * Created by Сергей on 22.11.2014.
 */
public class MySkipListTest {
    public static void main(String[] args) {
        MySkipList skipList = new MySkipList();
        skipList.put(5, 5);
        skipList.put(6, 6);
        skipList.put(3, 6);
        skipList.put(4, 6);
        skipList.put(20, 6);
        skipList.put(25, 6);
        skipList.put(25, 7);
        skipList.put(12, 6);

        System.out.println(skipList);
        skipList.remove(25);
        System.out.println(skipList);
        skipList.remove(5);
        System.out.println(skipList);

        skipList.remove(1);
        skipList.get(1);


        System.out.println(skipList.get(1));
        System.out.println(skipList.remove(1));





    }
}
