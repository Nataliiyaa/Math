package Math;

public class Main {
    public static void main(String[] args) {
        Matrix3X3 m1 = new Matrix3X3(new double[]{1,2,3,4,5,6,7,8,9});
        Matrix3X3 m2 = new Matrix3X3(new double[]{1,2,3,4,5,6,7,8,9});

        Matrix m = Matrix.multiplication(m1,m2, m1.multiply(2));
        m.print();
    }
}