package ua.epam.sergiishapoval.homework.hw7.huffman;

import ua.epam.sergiishapoval.homework.hw7.huffman.inside_entities.HuffManTree;
import ua.epam.sergiishapoval.homework.hw7.huffman.inside_entities.SymbolCalculator;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Сергей on 06.11.2014.
 * Написать программу, осуществляющую сжатие английского текста.
 * Построить для каждого слова в тексте оптимальный префиксный код по
 * алгоритму Хаффмена. Использовать класс PriorityQueue.
 * https://www.youtube.com/watch?v=apcCVfXfcqE
 * https://www.youtube.com/watch?v=ZdooBTdW5bM
 */
public class HuffManTextCompression {

    public static void main(String[] args) {


        HuffManTree huffManTree = new HuffManTree("C:\\Dropbox\\epam\\EpamCoursesCode\\src\\ua\\epam\\sergiishapoval\\homework\\hw7\\huffman\\resources\\textSmall.txt");

        try {
            huffManTree.createTree();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Huffman code: %s",  huffManTree.getTextCode()));
        System.out.println();
        System.out.println(String.format("Huffman decode: %s", huffManTree.decode(huffManTree.getTextCode())));

    }
}
