package ua.epam.sergiishapoval.homework.hw8.matmult;

/**
 * Created by Сергей on 08.11.2014.
 */
public class MatrixStorage {

    public int matrixDimension;
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private int[][] resultMatrix;

    public MatrixStorage(int matrixDimension) {
        this.matrixDimension = matrixDimension;
        firstMatrix = fillRandom(matrixDimension);
        secondMatrix = fillRandom(matrixDimension);
        resultMatrix = new int[matrixDimension][matrixDimension];
    }

    public int[][] getFirstMatrix() {
        return firstMatrix;
    }

    public int[][] getSecondMatrix() {
        return secondMatrix;
    }

    public int[][] getResultMatrix() {
        return resultMatrix;
    }

    private int[][] fillRandom(int matrixDimension){
        int [][] matrix = new int[matrixDimension][matrixDimension];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random()*1000) - 500;
            }
        }
        
        return matrix;
    }
    
}
