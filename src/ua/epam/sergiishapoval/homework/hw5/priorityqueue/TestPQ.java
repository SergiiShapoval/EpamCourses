package ua.epam.sergiishapoval.homework.hw5.priorityqueue;

/**
 * Created by Сергей on 01.11.2014.
 */
public class TestPQ {

    public static void main(String[] args) {
        MyPriorityQueue priorityQueue = new MyPriorityQueue();
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
