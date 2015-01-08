package ua.epam.sergiishapoval.homework.hw8.matmult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 08.11.2014.
 */
public class MatrixMultiplyInThreads {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<MultiplyThread> threads;

        System.out.println("What matrix dimension should be?");

        int matrixDimension = getUserNumber(reader);

        MatrixStorage storage = new MatrixStorage(matrixDimension);

        System.out.println("How many threads should work on multiply should be?");

        int threadNumber = getUserNumber(reader);
        threads = new ArrayList<>(threadNumber);
        for (int i = 0; i < threadNumber; i++) {
            threads.add(new MultiplyThread(storage));
        }

        int threadCounter = 0;
        for (int m = 0; m < matrixDimension ; m++) {
            for (int k = 0; k < matrixDimension; k++) {
                threads.get(threadCounter).addTask(m, k);
                if (++threadCounter >= threadNumber)
                    threadCounter = 0;
            }
        }

        int [][] firstMatrix = storage.getFirstMatrix();
        int [][] secondMatrix = storage.getSecondMatrix();

/*
        System.out.println("First Matrix");
        printMatrix(firstMatrix);
        System.out.println("Second Matrix");
        printMatrix(secondMatrix);
*/

        long startTime = System.currentTimeMillis();

        for (Thread thread : threads){
            thread.start();
        }

        for (Thread thread : threads){
            thread.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Total time needed: " + (endTime - startTime));

/*
        int [][] resultMatrix = storage.getResultMatrix();
        System.out.println("Result Matrix");
        printMatrix(resultMatrix);
*/

    }

    private static void printMatrix(int[][] firstMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length ; j++) {
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getUserNumber(BufferedReader reader) throws IOException {
        int matrixDimension;
        while (true){
            try {
                matrixDimension = Integer.parseInt(reader.readLine());
                if (matrixDimension <= 0) throw new NumberFormatException();
                break;
            }catch (NumberFormatException e){
                System.out.println("Number should be a positive integer");
            }
        }
        return matrixDimension;
    }
}
