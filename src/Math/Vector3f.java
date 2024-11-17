package Math;

public class Vector3f{
    private double[] values;

    public Vector3f(double x, double y, double z) {
        values = new double[]{x, y, z};
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

    public double at(int idx) {
        return values[idx];
    }

    private static final float EPSILON = 1e-10f;

    public double length() {
        double lenSqr = values[0] * values[0] + values[1] * values[1] + values[2] * values[2];
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

    public Vector3f add(Vector3f other) {
        double[] resultData = new double[3];
        for (int i = 0; i < 3; i++) {
            resultData[i] = values[i] + other.values[i];
        }
        return new Vector3f(resultData[0], resultData[1], resultData[2]);
    }

    public Vector3f sub(Vector3f other) {
        double[] resultData = new double[3];
        for (int i = 0; i < 3; i++) {
            resultData[i] = values[i] - other.values[i];
        }
        return new Vector3f(resultData[0], resultData[1], resultData[2]);
    }

    public Vector3f multiply(double scalar) {
        double[] resultData = new double[3];
        for (int i = 0; i < 3; i++) {
            resultData[i] = values[i] * scalar;
        }
        return new Vector3f(resultData[0], resultData[1], resultData[2]);
    }

    public Vector3f div(double scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return multiply(1.0 / scalar);
    }

    public Vector3f normalize() {
        double magnitude = Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
        if (magnitude == 0) {
            return new Vector3f(0, 0, 0);
        }
        return new Vector3f(getX() / magnitude, getY() / magnitude, getZ() / magnitude);
    }

    // Скалярное произведение
    public double dotProduct(Vector3f other) {
        return this.getX() * other.getX() + this.getY() * other.getY() + this.getZ() * other.getZ();
    }

    // Векторное произведение
    public Vector3f crossProduct(Vector3f other) {
        return new Vector3f(
                this.getY() * other.getZ() - this.getZ() * other.getY(),
                this.getZ() * other.getX() - this.getX() * other.getZ(),
                this.getX() * other.getY() - this.getY() * other.getX()
        );
    }

}
