package ua.epam.sergiishapoval.homework.hw14;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Сергей on 01.12.2014.
 * Реализовать неблокирующую очередь используя Atomic переменные.
 * Queues — неблокирующие и блокирующие очереди с поддержкой многопоточности.
 * Неблокирующие очереди заточены на скорость и работу без блокирования потоков.
 * Блокирующие очереди используются, когда нужно «притормозить» потоки «Producer»
 * или «Consumer», если не выполнены какие-либо условия, например,
 * очередь пуста или перепонена, или же нет свободного «Consumer»'a.
 *
 * AtomicReference — Класс для атомарных операцией с ссылкой на объект.
 * AtomicMarkableReference — Класс для атомарных операцией со следующей парой полей:
 * ссылка на объект и битовый флаг (true/false).
 * AtomicStampedReference — Класс для атомарных операцией со следующей парой полей:
 * ссылка на объект и int значение.AtomicReferenceArray — Массив ссылок на объекты,
 * который может атомарно обновляться. AtomicIntegerFieldUpdater, AtomicLongFieldUpdater,
 * AtomicReferenceFieldUpdater — Классы для атомарного обновления полей по их именам через reflection.
 *
 * important points:
 * atomic everywhere
 * work on 0 and >0 cases
 * compareAndSet in offer with inf while, size inc in end
 * add node on poll to finish changes
 */
public class MyNonBlockingQueue {

    private class Node{
        AtomicReference<Node> next = new AtomicReference<>();
        AtomicReference<Node> previous = new AtomicReference<>();
        AtomicReference<Integer> value = new AtomicReference<>();

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private AtomicReference<Node> first = new AtomicReference<>();
    private AtomicReference<Node> last = new AtomicReference<>();
    private AtomicInteger size = new AtomicInteger();

    public boolean offer(Integer value) {
        while (true){
            if (isEmpty()){
                Node nextNode = new Node();
                nextNode.value.set(value);
                    if (first.compareAndSet(null, nextNode)) { //if not - delete or insert operation is not finished
                        last.set(first.get());// others operations can't start due to isEmpty
                        size.incrementAndGet();
                    } else continue;
            } else {
                Node nextNode = new Node();
                nextNode.value.set(value);
                Node lastCopy = last.get();
                nextNode.previous.set(lastCopy);
                    if (last.compareAndSet(lastCopy, nextNode) ) continue;
                    lastCopy.next.set(nextNode);// work only with last copy
                    size.incrementAndGet();
            }
            break;
        }
        return true;
    }

    public Integer poll() {
        if (size() == 0) return null;
        else {
                if (size.decrementAndGet() == 0){
                    Node resultNode = last.getAndSet(null);//work with last to avoid insert problem
                    first.set(null);
                    return resultNode.value.get();
                } else{
                    Node resultNode = first.getAndSet(first.get().next.get());
                    resultNode.next.get().previous.set(null);
                    return resultNode.value.get();
                }
        }
    }

    public Integer peek() {
        return first.get().value.get();
    }

    public int size() {
        return size.get();
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        boolean isFirst = true;
        Node currentNode = first.get();
        while (currentNode != null){
            if (isFirst){
                isFirst = false;
            } else {
                builder.append(", ");
            }
            builder.append(currentNode.value.get().toString());
            currentNode = currentNode.next.get();
        }

        builder.append("}");

        return builder.toString();
    }
}
