public class MyOwnAlgorithmGood {
    public static void main(String[] args) {
        int size = 2000;
        double[][] matrixA = generateMatrix(size);
        double[][] matrixB = generateMatrix(size);
        double[][] result = multiplyMatricesOptimized(matrixA, matrixB);

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

    public static double[][] multiplyMatricesOptimized(double[][] matrixA, double[][] matrixB) {
        int size = matrixA.length;
        double[][] result = new double[size][size];

        int blockSize = 50;

        for (int ii = 0; ii < size; ii += blockSize) {
            for (int jj = 0; jj < size; jj += blockSize) {
                for (int kk = 0; kk < size; kk += blockSize) {
                    for (int i = ii; i < Math.min(ii + blockSize, size); i++) {
                        for (int j = jj; j < Math.min(jj + blockSize, size); j++) {
                            double sum = 0.0;
                            for (int k = kk; k < Math.min(kk + blockSize, size); k++) {
                                sum += matrixA[i][k] * matrixB[k][j];
                            }
                            result[i][j] += sum;
                        }
                    }
                }
            }
        }
        return result;
    }
}
