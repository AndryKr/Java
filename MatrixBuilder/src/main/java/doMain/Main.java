package doMain;

import services.MatrixCreator;

public class Main {

    private static int m = 7;
    private static int n = 5;
    private static int value = 1;
    private static int[][] matrix = new int[m][n];

    public static void main(String[] args) {

        MatrixCreator matrixCreator = MatrixCreator.getInstance();

        matrixCreator.print(matrixCreator.build(value, matrix, m, n), m, n);
    }
}
