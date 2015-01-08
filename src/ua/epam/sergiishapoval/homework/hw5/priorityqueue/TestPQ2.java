package ua.epam.sergiishapoval.homework.hw5.priorityqueue;

import java.util.PriorityQueue;

/**
 * Created by Сергей on 01.11.2014.
 */
public class TestPQ2 {
    public static void main(String[] args) {
        MyPriorityQueue2 priorityQueue = new MyPriorityQueue2();
        priorityQueue.offer((int) (Math.random()*255));
        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue);
        priorityQueue.offer((int) (Math.random()*255));

        System.out.println(priorityQueue);
        priorityQueue.offer((int) (Math.random()*255));

        System.out.println(priorityQueue);
        priorityQueue.offer((int) (Math.random()*255));

        System.out.println(priorityQueue);
        priorityQueue.offer((int) (Math.random() * 255));

        System.out.println(priorityQueue);
        priorityQueue.offer((int) (Math.random()*255));

        System.out.println(priorityQueue);

        System.out.println(priorityQueue.peek());




        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);

        priorityQueue.offer((int) (Math.random()*255));

        System.out.println(priorityQueue);

    }

}
