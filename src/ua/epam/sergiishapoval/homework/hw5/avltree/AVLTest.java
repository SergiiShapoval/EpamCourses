package ua.epam.sergiishapoval.homework.hw5.avltree;


/**
 * Created by Сергей on 04.11.2014.
 */
public class AVLTest {
    public static void main(String[] args) {
        AVLTree redBlackTree = new AVLTree();
        redBlackTree.insert(40, 40);
        redBlackTree.insert(50, 40);
        redBlackTree.insert(30, 40);
        redBlackTree.insert(10, 40);
        redBlackTree.insert(5, 40);
        redBlackTree.insert(45, 40);
        redBlackTree.insert(60, 40);
        redBlackTree.insert(70, 40);
        redBlackTree.insert(20, 40);

        redBlackTree.delete(40);
        redBlackTree.delete(5);








    }
}
