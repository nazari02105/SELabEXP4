public class MyOwnAlgorithmBad {
    public static void main(String[] args) {
        int size = 2000;
        double[][] matrixA = generateMatrix(size);
        double[][] matrixB = generateMatrix(size);
        double[][] result = multiplyMatricesInefficient(matrixA, matrixB);

        System.out.println("Matrix multiplication completed.");
    }

    public static double[][] generateMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.random();
            }
        }
        return matrix;
    }

    public static double[][] multiplyMatricesInefficient(double[][] matrixA, double[][] matrixB) {
        int size = matrixA.length;
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
}
