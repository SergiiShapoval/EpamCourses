package ua.epam.sergiishapoval.homework.hw3.doublinklist;

/**
 * Created by Сергей on 23.10.2014.
 */
public class DoubleListImplementation {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        for (int i = 0; i <7 ; i++) {
            list.enQueueEnd(i+"");
        }

        for (int i = 0; i <7 ; i++) {
            System.out.println(list.deQueueBegin());
        }
    }
}
