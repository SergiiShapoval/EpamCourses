package ua.epam.sergiishapoval.homework.hw3.doublinklist;

/**
 * Created by Сергей on 23.10.2014.
 * 2.	Реализовать двухсвязанный список.
 * Реализация должна предусматривать наличие элемента header,
 * в котором есть ссылка на первй и последний элемент
 * списка(LinkedList).
 */
public class DoubleLinkedList {
    private Node header = new Node();

    private class Node{
        Node next;
        Node previous;
        String item;
    }

    public DoubleLinkedList() {
    }

    public void enQueueEnd (String item){
        Node oldLast = header.next;
        header.next = new Node();
        header.next.item = item;
        header.next.next = null;
        header.next.previous = oldLast;

        if (isEmpty()) {
            header.previous=header.next;
        } else {
            oldLast.next=header.next;
        }
    }
    public void enQueueBegin (String item){
        Node oldFirst = header.previous;
        header.previous = new Node();
        header.previous.item = item;
        header.previous.next = oldFirst;
        header.previous.previous = null;

        if (isEmptyBegin()) {
            header.next=header.previous;
        } else {
            oldFirst.previous=header.previous;
        }
    }
    
    
    public  String deQueueBegin (){

        String item = header.previous.item;
        header.previous = header.previous.next;
        if (isEmpty()) {
            header.next=null;
        }
        return item;
    }
    public  String deQueueEnd (){
        String item = header.next.item;
        header.next = header.next.previous;
        if (isEmpty()) {
            header.previous=null;
        }
        return item;
    }


    public  boolean isEmpty(){
        return header.previous==null;
    }
    public  boolean isEmptyBegin(){
        return header.next==null;
    }


}
