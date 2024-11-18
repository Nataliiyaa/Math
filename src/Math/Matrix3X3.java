package Math;

public class Matrix3X3 {
    private double[] data;

    public Matrix3X3(double[][] m) {
        data = new double[9];
        if (m.length != 3 || m[0].length != 3) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                data[i * 3 + j] = m[i][j];
    }

    public Matrix3X3(double[] arr) {
        if (arr.length != (9)) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        }
        data = arr;
    }

    public double getAt(int row, int col) {
        return data[row * 3 + col];
    }

    public void setAt(int row, int col, float value) {
        data[row * 3 + col] = value;
    }

    public double[] getData() {
        return data;
    }

    public static Matrix3X3 zero() {
        return new Matrix3X3(new double[9]);
    }

    public static Matrix3X3 one() {
        Matrix3X3 m = zero();
        for (int i = 0; i < 3; i++)
            m.setAt(i, i, 1);
        return m;
    }

    public Matrix3X3 mul(double number) {
        double[] arr = new double[9];
        for (int i = 0; i < arr.length; i++)
            arr[i] = this.data[i] * number;
        return new Matrix3X3(arr);
    }

    public Vector3f mul(Vector3f v) {
        double[] data = v.getValues();
        float[] arr = new float[3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                arr[i] += (float) (this.getAt(i, j) * data[j]);
        return new Vector3f(arr[0], arr[1], arr[2]);
    }

    public Matrix3X3 mul(Matrix3X3 m) {
        double[] result = new double[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += data[i * 3 + k] * m.getAt(k, j);
                }
                result[i * 3 + j] = sum;
            }
        }

        return new Matrix3X3(result);
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < data.length - 1; i++) {
            System.out.printf("%s, ", data[i]);
            if ((i + 1) % 3 == 0 && i != data.length - 1) {
                System.out.println();
                System.out.print(" ");
            }
        }
        System.out.print(data[data.length - 1] + "]\n");
    }

    public void transpose() {
        double[] transposed = new double[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposed[j * 3 + i] = data[i * 3 + j];
            }
        }
        data = transposed;
    }

    public Matrix3X3 transposed() {
        double[] transposed = new double[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposed[j * 3 + i] = data[i * 3 + j];
            }
        }
        return new Matrix3X3(transposed);
    }

    public Matrix3X3 add(Matrix3X3 matrix) {

        double[] result = new double[9];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] + matrix.getData()[i];
        }
        return new Matrix3X3(result);
    }

    public Matrix3X3 sub(Matrix3X3 matrix) {

        double[] result = new double[9];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] - matrix.getData()[i];
        }
        return new Matrix3X3(result);
    }
}
