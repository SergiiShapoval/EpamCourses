package ua.epam.sergiishapoval.homework.hw7.huffman.inside_entities;

import ua.epam.sergiishapoval.homework.hw7.huffman.inside_entities.HuffManSymbol;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Сергей on 07.11.2014.
 */
public class HuffManTree {

    String fileAddress;
    String text;
    Map<Character, Integer> charFrequency;

    private Node root;
    LinkedList<Node> treeTops = new LinkedList<>();

    String textCode;

// begin of internal class to save information
    private  class Node{
        Node right;
        Node left;
        HuffManSymbol symbol;

        private Node(HuffManSymbol symbol) {
            this.symbol = symbol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (!symbol.equals(node.symbol)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return symbol.hashCode();
        }

        @Override
        public String toString() {
            return symbol.toString();
        }
    }
// end of internal class to save information




    public HuffManTree(String fileAddress){
        this.fileAddress = fileAddress;
    }

    public String getText() {
        return text;
    }

    public String getTextCode() {
        return textCode;
    }

    private void getCodesOfChars() {
        for (Character character : charFrequency.keySet()){
            System.out.println(String.format("%s frequency - %d, character code: %s ", character, charFrequency.get(character), getHuffManCode(character) ));
        }
        System.out.println();
    }

    public void createTree() throws IOException {
        SymbolCalculator symbolCalculator = new SymbolCalculator(fileAddress);

        charFrequency = symbolCalculator.getCharFrequency();

        if (charFrequency.size() > 1) {

            int totalFrequency = 0;

            PriorityQueue<HuffManSymbol> symbolPriorityQueue = new PriorityQueue<>(charFrequency.size());

            for (Character character : charFrequency.keySet()) {
                String characterToString = character.toString();
                int bufferFrequency = charFrequency.get(character);

                totalFrequency += bufferFrequency;
                symbolPriorityQueue.add(new HuffManSymbol(characterToString, bufferFrequency));
            }

            while (symbolPriorityQueue.peek().getValue() != totalFrequency) {
                HuffManSymbol bufferHuffManSymbol = addSymbols(symbolPriorityQueue.poll(), symbolPriorityQueue.poll());
                symbolPriorityQueue.add(bufferHuffManSymbol);
            }



        } else {
            if (charFrequency.size() == 1) {
                for (Map.Entry<Character, Integer> pair : charFrequency.entrySet()) {
                    root = new Node(new HuffManSymbol(pair.getKey().toString(), pair.getValue()));
                }
            }
        }

        text = symbolCalculator.getReceivedText();
        textCode = getHuffManCode(text);
    }


    private HuffManSymbol addSymbols(HuffManSymbol symbol1, HuffManSymbol symbol2){

        Node node1 = null;
        Node node2 = null;

        boolean isSymbol1Found = false;
        boolean isSymbol2Found = false;

        for (Node node : treeTops){
            if (node.symbol.equals(symbol1)){
                node1 = node;
                isSymbol1Found = true;
            }
            if (node.symbol.equals(symbol2)){
                node2 = node;
                isSymbol2Found = true;
            }
            if (isSymbol1Found && isSymbol2Found) break;
        }

        if (node1 == null) {
            node1 = new Node(symbol1);
        } else treeTops.remove(node1);
        if (node2 == null) {
            node2 = new Node(symbol2);
        } else treeTops.remove(node2);

        HuffManSymbol buffer = new HuffManSymbol(symbol1.getKey() + symbol2.getKey(), symbol1.getValue() + symbol2.getValue());

        Node bufferTopNode = new Node(buffer);
        if (symbol1.compareTo(symbol2) > 0) {
            bufferTopNode.left = node1;
            bufferTopNode.right = node2;
        } else {
            bufferTopNode.left = node2;
            bufferTopNode.right = node1;
        }

        treeTops.add(bufferTopNode);

        if (treeTops.size() == 1)
        root = treeTops.getFirst();

        return buffer;

    }

    public String getHuffManCode(Character character){

        Node currentNode = root;

        StringBuilder charCode = new StringBuilder();

        while (currentNode != null && currentNode.symbol.getKey().length() != 1) {
            if (currentNode.left != null && currentNode.left.symbol.getKey().contains(character.toString())){
                currentNode = currentNode.left;
                charCode.append(1);
            } else {
                currentNode = currentNode.right;
                charCode.append(0);
            }
        }

        return charCode.toString();
    }

    public String getHuffManCode(String string){
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < string.length() ; i++) {
            buffer.append(getHuffManCode(string.charAt(i)));
        }
        return buffer.toString();
    }

    public String decode(String string){
        StringBuilder resultString = new StringBuilder();
        Node currentNode = root;
        for (int i = 0; i < string.length() ; i++) {

            if (string.charAt(i) == '0'){
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }

            String key = currentNode.symbol.getKey();
            if (key.length() == 1){
                resultString.append(key);
                currentNode = root;
            }
        }

        return resultString.toString();
    }
}
