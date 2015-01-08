package ua.epam.sergiishapoval.homework.hw8.matmult;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 08.11.2014.
 */
public class MultiplyThread extends Thread{

    List<Integer> rowNumberList = new LinkedList<>();
    List<Integer> columnNumberList = new LinkedList<>();

    MatrixStorage storage;

    public MultiplyThread(MatrixStorage storage) {
        this.storage = storage;
    }

    public void addTask(Integer k, Integer m){
        rowNumberList.add(k);
        columnNumberList.add(m);
    }

    @Override
    public void run() {
        int [][] firstMatrix = storage.getFirstMatrix();
        int [][] secondMatrix = storage.getSecondMatrix();
        int [][] resultMatrix = storage.getResultMatrix();

        for (int z = 0; z <rowNumberList.size() ; z++) {
            int rowNumber = rowNumberList.get(z);
            int columnNumber = columnNumberList.get(z);
            int sum = 0;
            for (int i = 0; i < firstMatrix.length; i++) {
                sum += firstMatrix[rowNumber][i] * secondMatrix[i][columnNumber];
            }
            resultMatrix[rowNumber][columnNumber] = sum;
        }
    }
}
