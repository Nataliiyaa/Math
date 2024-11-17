package Math;

public class Vector4f{
    private double[] values;

    public Vector4f(double x, double y, double z, double w) {
        values = new double[]{x, y, z, w};
    }

    public double[] getValues() {
        return values;
    }

    public double getX() {
        return values[0];
    }

    public double getY() {
        return values[1];
    }

    public double getZ() {
        return values[2];
    }

    public double getW() {
        return values[3];
    }

    public double at(int idx) {
        return values[idx];
    }

    private static final float EPSILON = 1e-10f;

    public double length() {
        double lenSqr = values[0] * values[0] + values[1] * values[1] + values[2] * values[2] + values[3] * values[3];
        if (lenSqr < EPSILON)
            return 0;
        return (float)Math.sqrt(lenSqr);
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < values.length - 1; i++) {
            System.out.printf("%s, \n", values[i]);

        }
        System.out.print(values[values.length - 1] + "]\n");
    }

    public Vector4f add(Vector4f other) {
        double[] resultData = new double[4];
        for (int i = 0; i < 4; i++) {
            resultData[i] = values[i] + other.values[i];
        }
        return new Vector4f(resultData[0], resultData[1], resultData[2], resultData[3]);
    }

    public Vector4f sub(Vector4f other) {
        double[] resultData = new double[4];
        for (int i = 0; i < 4; i++) {
            resultData[i] = values[i] - other.values[i];
        }
        return new Vector4f(resultData[0], resultData[1], resultData[2], resultData[3]);
    }

    public Vector4f multiply(double scalar) {
        double[] resultData = new double[4];
        for (int i = 0; i < 4; i++) {
            resultData[i] = values[i] * scalar;
        }
        return new Vector4f(resultData[0], resultData[1], resultData[2], resultData[3]);
    }

    public Vector4f div(double scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return multiply(1.0 / scalar);
    }

    public Vector4f normalize() {
        double magnitude = Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ() + getW() * getW());
        if (magnitude == 0) {
            return new Vector4f(0, 0, 0, 0);
        }
        return new Vector4f(getX() / magnitude, getY() / magnitude, getZ() / magnitude, getW() / magnitude);
    }

    // Скалярное произведение
    public double dotProduct(Vector4f other) {
        return this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ() + this.getW() * other.getW();
    }
}
