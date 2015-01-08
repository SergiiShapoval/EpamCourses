package ua.epam.sergiishapoval.homework.hw4REDO.redblack;

/**
 * Created by Сергей on 31.10.2014.
 */
public class TestRBTree {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.put(5, 5);
        redBlackTree.put(6, 6);
        redBlackTree.put(7, 7);
        redBlackTree.put(8, 8);
        redBlackTree.put(9, 9);
        redBlackTree.put(10, 10);

        System.out.println(redBlackTree.get(10));
        System.out.println(redBlackTree.get(9));
        System.out.println(redBlackTree.get(7));
        System.out.println(redBlackTree.get(11));
    }
}
