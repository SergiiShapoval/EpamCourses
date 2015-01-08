package ua.epam.sergiishapoval.homework.hw3.linkedlist;

/**
 * Created by Сергей on 23.10.2014.
 * 1.	Используя вложенные классы реализовать односвязанный список.
 */
public class LinkedList {
    private Node first = null;
    private Node last = null;



    private class Node{


        Node next;
        String item;

        private Node() {
        }
    }


    public LinkedList() {
    }

    public void enQueue (String item){
        Node oldLast = last;
        last=new Node();
        last.item=item;
        last.next=null;

        if (isEmpty())first=last;
        else oldLast.next=last;
    }
    public  String deQueue (){
        String item = first.item;
        first = first.next;
        if (isEmpty()) last=null;
        return item;
    }
    public  boolean isEmpty(){
        return first==null;
    }


}
