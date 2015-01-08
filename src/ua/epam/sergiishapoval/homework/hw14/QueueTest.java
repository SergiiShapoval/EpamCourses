package ua.epam.sergiishapoval.homework.hw14;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Сергей on 02.12.2014.
 */
public class QueueTest {
    public static void main(String[] args) {
        MyNonBlockingQueue queue = new MyNonBlockingQueue();
        queue.offer(12);
        queue.offer(13);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.offer(2);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

    }
}
