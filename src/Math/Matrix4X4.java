package Math;

public class Matrix4X4 {
    private double[] data;

    public Matrix4X4(double[][] m) {
        data = new double[16];
        if (m.length != (16)) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        }
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                data[i * 4 + j] = m[i][j];
    }

    public Matrix4X4(double[] arr) {
        data = arr;
    }

    public double getAt(int row, int col) {
        return data[row * 4 + col];
    }

    public void setAt(int row, int col, float value) {
        data[row * 4 + col] = value;
    }

    public double[] getData() {
        return data;
    }

    public static Matrix4X4 zero() {
        return new Matrix4X4(new double[16]);
    }

    public static Matrix4X4 one() {
        Matrix4X4 m = zero();
        for (int i = 0; i < 4; i++)
            m.setAt(i, i, 1);
        return m;
    }

    public Matrix4X4 mul(double number) {
        double[] arr = new double[16];
        for (int i = 0; i < arr.length; i++)
            arr[i] = this.data[i] * number;
        return new Matrix4X4(arr);
    }

    public Vector4f mul(Vector4f v) {
        double[] data = v.getValues();
        float[] arr = new float[4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                arr[i] += (float) (this.getAt(i, j) * data[j]);
        return new Vector4f(arr[0], arr[1], arr[2], arr[3]);
    }

    public Matrix4X4 mul(Matrix4X4 m) {
        double[] result = new double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                double sum = 0;
                for (int k = 0; k < 4; k++) {
                    sum += data[i * 4 + k] * m.getAt(k, j);
                }
                result[i * 4 + j] = sum;
            }
        }

        return new Matrix4X4(result);
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < data.length - 1; i++) {
            System.out.printf("%s, ", data[i]);
            if ((i + 1) % 4 == 0 && i != data.length - 1) {
                System.out.println();
                System.out.print(" ");
            }
        }
        System.out.print(data[data.length - 1] + "]\n");
    }

    public void transpose() {
        double[] transposed = new double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposed[j * 4 + i] = data[i * 4 + j];
            }
        }
        data = transposed;
    }

    public Matrix4X4 transposed() {
        double[] transposed = new double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                transposed[j * 4 + i] = data[i * 4 + j];
            }
        }
        return new Matrix4X4(transposed);
    }

    public Matrix4X4 add(Matrix4X4 matrix) {

        double[] result = new double[16];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] + matrix.getData()[i];
        }
        return new Matrix4X4(result);
    }

    public Matrix4X4 sub(Matrix4X4 matrix) {

        double[] result = new double[16];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] - matrix.getData()[i];
        }
        return new Matrix4X4(result);
    }
}
