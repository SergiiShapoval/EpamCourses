package ua.epam.sergiishapoval.homework.hw5.bst;

/**
 * Created by Сергей on 02.11.2014.
 *
 *
 * Important points
 * when put should remember previous
 * and create new node at begin
 * and in while in if should check next and put
 *
 * traverse by recursion - go to left - print -go to right;
 *
 * when delete - use buffer on left if right goes up
 * check at the end no iteration and any
 *
 * for delete check is child nulls
 * take in an account left or right was parent
 * if both are not nulls - take left far child of right child
 * when taking and no turn left = nothing to change in replacement;
 *
 *
 *
 *
 */
public class BinarySearchTree {

    Node root;
    int size;

    class Node {
        Node left;
        Node right;
        Integer key;
        Integer value;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return   key.toString()+ " = " + value.toString();
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert (Integer key, Integer value){

        if (value == null) return false;

        if (isEmpty()) {
            root =  new Node(key, value);
        } else {

            Node currentNode = root;
            Node previousNode = root;
            int comparison = 0 ;
            while (currentNode != null) {
                previousNode = currentNode;
                if ( (comparison = key.compareTo(currentNode.key)) > 0) {
                    currentNode = currentNode.right;
                } else {
                    if (comparison < 0){
                        currentNode = currentNode.left;
                    } else {
                        currentNode.value = value;
                        return true;
                    }
                }
            }


            if ( comparison  > 0) {
                previousNode.right = new Node(key, value);
            } else {
                previousNode.left = new Node(key, value);
            }
        }
        size++;

        return true;
    }

    public void traverse(){
        traverse(root);
    }


    public void traverse(Node node){
        if (node != null) {
            traverse(node.left);
            System.out.println(node);
            traverse(node.right);
        }
    }


    public Integer remove (Integer key) {
        if (root == null) {
            return null;
        }

        Node parent = root;
        Node currentNode = root;
        boolean isLeftChild = false;
        int comparison = 0;
        Integer result = null;


        while ((comparison = key.compareTo(currentNode.key)) != 0) {
            parent = currentNode;
            if (comparison < 0) {
                currentNode = currentNode.left;
                isLeftChild = true;
            } else {
                currentNode = currentNode.right;
                isLeftChild = false;
            }

            if (currentNode == null)
                return result;
        }

        result = currentNode.value;


        if (currentNode.right == null && currentNode.left == null) {
            if (currentNode == root){
                root = null;
            } else {
                if (isLeftChild)
                    parent.left = null;
                else parent.right = null;
            }
        } else {
            if (currentNode.right == null) {
                if (currentNode == root) {
                    root = currentNode.left;
                } else {
                    if (isLeftChild){
                        parent.left = currentNode.left;
                    } else {
                        parent.right = currentNode.right;
                    }
                }
            } else {
                if (currentNode.left == null) {
                    if (currentNode == root) {
                        root = currentNode.right;
                    } else {
                        if (isLeftChild){
                            parent.left = currentNode.right;
                        } else {
                            parent.right = currentNode.right;
                        }
                    }
                } else {
                    Node replacement = getReplacementNode(currentNode);

                    if (currentNode == root) {
                        root = replacement;
                    } else {
                        if (isLeftChild){
                            parent.left = replacement;
                        } else {
                            parent.right = replacement;
                        }
                    }

                    replacement.left = currentNode.left;
                }
            }

        }

        return result;


    }

    public Node getReplacementNode(Node nodeToReplace){

        Node parent = nodeToReplace;
        Node replacement = nodeToReplace;
        Node currentNode = nodeToReplace.right;

        while (currentNode != null) {
            parent = replacement;
            replacement = currentNode;
            currentNode = currentNode.left;
        }

        if (replacement != nodeToReplace.right) {
            parent.left = replacement.right;
            replacement.right = nodeToReplace.right;
        }

        return replacement;

    }

}
