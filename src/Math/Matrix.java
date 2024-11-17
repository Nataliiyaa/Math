package Math;

public class Matrix {
    private int rows;
    private int cols;
    private double[] data;

    public Matrix(int rows, int cols, double[] data) {

        if (data.length != (rows * cols)) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        }
        this.rows = rows;
        this.cols = cols;
        this.data = data.clone();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[] getData() {
        return data.clone();
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    private void setBase(double[] base) {
        this.data = base;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < data.length - 1; i++) {
            System.out.printf("%s, ", data[i]);
            if ((i + 1) % cols == 0 && i != data.length - 1) {
                System.out.println();
                System.out.print(" ");
            }
        }
        System.out.print(data[data.length - 1] + "]\n");
        //System.out.printf("row - %S, col - %S \n", rows, cols);
    }

    public void transpose() {
        double[] transposed = new double[cols * rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j * rows + i] = data[i * cols + j];
            }
        }
        data = transposed;
        int curr = rows;
        rows = cols;
        cols = curr;
    }

    public Matrix transposed() {
        double[] transposed = new double[cols * rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j * rows + i] = data[i * cols + j];
            }
        }
        return new Matrix(cols, rows, transposed);
    }

    public static Matrix multiplication(Matrix... m) {
        Matrix start = m[0];
        for (int i = 1; i < m.length; i++) {
            start = start.multiply(m[i]);
        }
        return start;
    }

    public Matrix multiply(Matrix matrix) {
        if (cols != matrix.getRows()) {
            throw new IllegalArgumentException("The number of rows and columns is incorrect for matrix multiplication");
        }
        double[] result = new double[rows * matrix.getCols()];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i * cols + k] * matrix.getData()[k * matrix.getCols() + j];
                }
                result[i * matrix.getCols() + j] = sum;
            }
        }

        return new Matrix(rows, matrix.getCols(), result);
    }

    public Matrix multiply(double n) {
        double[] newMatrix = new double[rows * cols];
        for (int i = 0; i < data.length; i++) {
            newMatrix[i] = data[i] * n;
        }
        return new Matrix(rows, cols, newMatrix);
    }

    public static Matrix addition(Matrix... m) {
        Matrix start = m[0];
        for (int i = 1; i < m.length; i++) {
            start = start.add(m[i]);
        }
        return start;
    }

    public Matrix add(Matrix matrix) {
        if (rows != matrix.getRows() || cols != matrix.getCols()) {
            throw new IllegalArgumentException("The number of rows and columns is incorrect for matrix addition");
        }
        double[] result = new double[rows * cols];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] + matrix.getData()[i];
        }
        return new Matrix(rows, cols, result);
    }
}
