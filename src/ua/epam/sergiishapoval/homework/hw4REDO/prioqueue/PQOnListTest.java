package ua.epam.sergiishapoval.homework.hw4REDO.prioqueue;

/**
 * Created by Сергей on 30.10.2014.
 */
public class PQOnListTest {

    public static void main(String[] args) {
        MyPriorityQueueOnList<Integer> priorityQueue =  new MyPriorityQueueOnList<Integer>();


        priorityQueue.offer(10);
        priorityQueue.offer(12);
        priorityQueue.offer(10);
        priorityQueue.offer(10);
        priorityQueue.offer(133);
        priorityQueue.offer(25);
        priorityQueue.offer(25);
        priorityQueue.offer(34);
        priorityQueue.offer(46);
        priorityQueue.offer(46);
        priorityQueue.offer(46);
        priorityQueue.offer(46);

        System.out.println(priorityQueue);

        priorityQueue.peek();
        System.out.println(priorityQueue);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

        System.out.println(priorityQueue);

        priorityQueue.offer(10);
        priorityQueue.offer(133);
        System.out.println(priorityQueue);
        priorityQueue.offer(178);
        priorityQueue.offer(10);
        priorityQueue.offer(133);
        priorityQueue.offer(25);
        priorityQueue.offer(25);
        priorityQueue.offer(314);
        priorityQueue.offer(465);

        System.out.println(priorityQueue);

    }
}
