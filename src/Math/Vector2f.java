package Math;

public class Vector2f{
    private double[] values;

    public Vector2f(double x, double y) {
        values = new double[]{x, y};
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


    public double at(int idx) {
        return values[idx];
    }

    private static final float EPSILON = 1e-10f;

    public double length() {
        double lenSqr = values[0] * values[0] + values[1] * values[1];
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

    public Vector2f add(Vector2f other) {
        double[] resultData = new double[2];
        for (int i = 0; i < 2; i++) {
            resultData[i] = values[i] + other.values[i];
        }
        return new Vector2f(resultData[0], resultData[1]);
    }

    public Vector2f sub(Vector2f other) {
        double[] resultData = new double[2];
        for (int i = 0; i < 2; i++) {
            resultData[i] = values[i] - other.values[i];
        }
        return new Vector2f(resultData[0], resultData[1]);
    }

    public Vector2f multiply(double scalar) {
        double[] resultData = new double[2];
        for (int i = 0; i < 2; i++) {
            resultData[i] = values[i] * scalar;
        }
        return new Vector2f(resultData[0], resultData[1]);
    }

    public Vector2f div(double scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return multiply(1.0 / scalar);
    }

    public Vector2f normalize() {
        double magnitude = Math.sqrt(getX() * getX() + getY() * getY());
        if (magnitude == 0) {
            return new Vector2f(0, 0);
        }
        return new Vector2f(getX() / magnitude, getY() / magnitude);
    }

    // Скалярное произведение
    public double dotProduct(Vector2f other) {
        return this.getX() * other.getX() + this.getY() * other.getY();
    }
}
