package ua.epam.sergiishapoval.homework.hw4REDO.priolinklist;

/**
 * Created by Сергей on 30.10.2014.
 */
public class PLLTest {
    public static void main(String[] args) {
        PriorityLinkedList<Integer> priorityLinkedList =  new PriorityLinkedList<Integer>();


        priorityLinkedList.add(10);
        priorityLinkedList.add(12);
        priorityLinkedList.add(10);
        priorityLinkedList.add(10);
        priorityLinkedList.add(133);
        priorityLinkedList.add(25);
        priorityLinkedList.add(25);
        priorityLinkedList.add(34);
        priorityLinkedList.add(46);
        priorityLinkedList.add(46);
        priorityLinkedList.add(46);
        priorityLinkedList.add(46);

        System.out.println(priorityLinkedList);

        priorityLinkedList.get();
        System.out.println(priorityLinkedList);

        System.out.println(priorityLinkedList.remove());
        System.out.println(priorityLinkedList.remove());
        System.out.println(priorityLinkedList.remove());
        System.out.println(priorityLinkedList.remove());
        System.out.println(priorityLinkedList.remove());
        System.out.println(priorityLinkedList.remove());
        System.out.println(priorityLinkedList.remove());

        System.out.println(priorityLinkedList);

        priorityLinkedList.add(10);
        priorityLinkedList.add(133);
        System.out.println(priorityLinkedList);
        priorityLinkedList.add(178);
        priorityLinkedList.add(10);
        priorityLinkedList.add(133);
        priorityLinkedList.add(25);
        priorityLinkedList.add(25);
        priorityLinkedList.add(314);
        priorityLinkedList.add(465);

        System.out.println(priorityLinkedList);

        for (Integer i : priorityLinkedList ){
            System.out.println(i);
        }
    }
}
