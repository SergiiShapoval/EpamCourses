package ua.epam.sergiishapoval.homework.hw5.avltree;

/**
 * Created by Сергей on 31.10.2014.
 Important points
 function for height, fixHeight,
 balance should fixHeight first
 big attention to balance method (null
 4 cases of turning for dif 2;
 insert return node that = to previous version;
 exit on node == null;
 when delete - first check on null
 in last if on equal check right on null
 method to return changeNode child with balance
 )

 */
public class AVLTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    private class Node{
        int height;
        Integer key;
        Integer value;
        Node left;
        Node right;

        private Node(int height, Integer key, Integer value) {
            this.height = height;
            this.key = key;
            this.value = value;
        }
    }

    private Node rotateLeft(Node node){
        Node buffer = node.right;
        node.right = buffer.left;
        buffer.left = node;

        fixHeight(node);
        fixHeight(buffer);

        return buffer;
    }

    private Node rotateRight(Node node){
        Node buffer = node.left;
        node.left = buffer.right;
        buffer.right = node;

        fixHeight(node);
        fixHeight(buffer);

        return buffer;
    }

    private int height(Node node){
        return (node == null ? 0 : node.height);
    }


    private void fixHeight(Node node){
        int leftHeight = height(node.left);
        int rigthHeight = height(node.right);

        node.height = (leftHeight > rigthHeight ? leftHeight : rigthHeight)  + 1;
    }

    private Node balance(Node node){

        fixHeight(node);
        if (height(node.left) - height(node.right) == 2) {
            if (height(node.left.left) < height(node.left.right))
                node.left = rotateLeft(node.left);

            return rotateRight(node);

        }

        if (height(node.right) - height(node.left) == 2) {
            if (height(node.right.right) < height(node.right.left))
                node.right = rotateRight(node.right);

            return rotateLeft(node);

        }

        return node;
    }

    public void insert(Integer key, Integer value){
        if (key == null) return;
        root = insert(root, key, value);
    }

    private Node insert(Node node, Integer key, Integer value) {
        if (node == null) return new Node(1, key, value);

        if (key.compareTo(node.key) > 0){
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }
        return balance(node);
    }

    public void delete(Integer key){
        if (key == null) return;
        root = delete(root, key);
    }

    private Node findNextMin(Node node){
        return node.left == null ? node : findNextMin(node.left);
    }

    private Node removeMin(Node node){
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        return balance(node);
    }

    private Node delete(Node node, Integer key) {
        int comparison;

        if (node ==null )
            return null;

        if ( (comparison = key.compareTo(node.key)) < 0) {
            node.left = delete(node.left, key);
        } else {
            if (comparison > 0) {
                node.right = delete(node.right, key);
            } else {
                Node rightChild = node.right;
                Node leftChild = node.left;

                if (rightChild == null) return leftChild;

                Node changeNode = findNextMin(rightChild);
                changeNode.right = removeMin(rightChild);
                changeNode.left = leftChild;

                return balance(changeNode);
            }
        }
        return balance(node);
    }
}
