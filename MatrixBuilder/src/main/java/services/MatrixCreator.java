package services;

public class MatrixCreator {

    private static MatrixCreator matrixCreator;

    private MatrixCreator() {
    }

    public static MatrixCreator getInstance() {
        if (matrixCreator == null)
            matrixCreator = new MatrixCreator();
        return matrixCreator;
    }

    public int[][] build(int value, int[][] matrix, int m, int n) {
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = m - 1;

        while (startX <= endX && startY <= endY) {

            for (int i = startX; i <= endX; i++) {
                matrix[startY][i] = value;
                value++;
            }
            startY++;

            for (int i = startY; i <= endY; i++) {
                matrix[i][endX] = value;
                value++;
            }
            endX--;

            for (int i = endX; i >= startX; i--) {
                matrix[endY][i] = value;
                value++;
            }
            endY--;

            for (int i = endY; i >= startY; i--) {
                matrix[i][startX] = value;
                value++;
            }
            startX++;
        }
        return matrix;
    }

    public void print(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
