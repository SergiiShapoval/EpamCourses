package ua.epam.sergiishapoval.homework.hw4REDO.redblack;

/**
 * Created by Сергей on 31.10.2014.
 */
public class RedBlackTree {

    Node root;

    private class Node {
        Integer key;
        Integer value;
        Node left;
        Node right;
        LeafColor color;

        private Node(Integer key, Integer value, LeafColor color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    Node rotateLeft(Node node){
        Node buffer = node.right;
        node.right = buffer.left;
        buffer.left = node;
        buffer.color = LeafColor.BLACK;
        node.color = LeafColor.RED;
        return buffer;
    }

    Node rotateRight(Node node){
        Node buffer = node.left;
        node.left = buffer.right;
        buffer.right = node;
        buffer.color = LeafColor.BLACK;
        node.color = LeafColor.RED;
        return buffer;
    }

    void rePaint(Node node){
        node.left.color = LeafColor.BLACK;
        node.right.color = LeafColor.BLACK;
        node.color = LeafColor.RED;
    }

    boolean isRed(Node node){
        return node!=null && node.color == LeafColor.RED;

/*
        if (node == null) return false;
        else return node.color == LeafColor.RED;
*/
    }

    enum LeafColor{
        RED, BLACK
    }

    void put(Integer key, Integer value){
        root = put(root, key, value);
    }

    private Node put(Node head, Integer key, Integer value){

        if (head == null) {
            head = new Node(key, value, LeafColor.RED );
            return head;
        }

        int compare =  key.compareTo(head.key);

        if (compare > 0) {head.right = put(head.right, key, value);}
        else if (compare < 0) {head.left = put(head.left, key, value);}
        else head.value = value;

        if (isRed(head.right) && !isRed(head.left)) {head = rotateLeft(head);}
        if (isRed(head.left) && isRed(head.left.left)) {head = rotateRight(head);}
        if (isRed(head.left) && isRed(head.right)) {rePaint(head);}

        return head;
    }

    Integer get (Integer key){
        return get(root, key);
    }

    private Integer get (Node node, Integer key){
        if (node == null ) return null;
        int comparison = node.key.compareTo(key);
        if (comparison < 0) { return get(node.right, key);}
        else {
            if (comparison > 0) {
                return get(node.left, key);
            } else return node.value;
        }
    }

    public boolean contains(Integer key) {
        return (get(key) != null);
    }

    public boolean isEmpty() {
        return root == null;
    }
/*

    public void delete(Integer key) {
        if (!contains(key)) {
            System.err.println("There is no such key: " + key);
            return;
        }

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = LeafColor.RED ;

        root = delete(root, key);
        if (!isEmpty()) root.color = LeafColor.BLACK;
    }

    private node delete(node h, Integer key) {

        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                node x = min(h.right);
                h.key = x.key;
                h.value = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }
*/




}
