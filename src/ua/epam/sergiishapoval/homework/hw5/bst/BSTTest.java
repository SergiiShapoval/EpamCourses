package ua.epam.sergiishapoval.homework.hw5.bst;

import java.util.TreeMap;

/**
 * Created by Сергей on 02.11.2014.
 */
public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(12, 12);
        binarySearchTree.insert(16, 16);
        binarySearchTree.insert(13, 20);
        binarySearchTree.insert(20, 25);
        binarySearchTree.insert(20, 129);
        binarySearchTree.insert(19, 19);
        binarySearchTree.insert(18, 18);
        binarySearchTree.insert(120, 48);
        binarySearchTree.insert(88, 48);


        binarySearchTree.remove(16);


    }
}
