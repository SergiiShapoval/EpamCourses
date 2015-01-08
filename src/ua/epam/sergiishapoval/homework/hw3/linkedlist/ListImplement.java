package ua.epam.sergiishapoval.homework.hw3.linkedlist;

/**
 * Created by Сергей on 23.10.2014.
 */
public class ListImplement {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i <5 ; i++) {
            list.enQueue(i+"");
        }

        for (int i = 0; i <5 ; i++) {
            System.out.println(list.deQueue());
        }
    }
}
