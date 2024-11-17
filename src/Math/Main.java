package Math;

public class Main {
    public static void main(String[] args) {
        Matrix3X3 m1 = new Matrix3X3(new double[]{1,2,3,4,5,6,7,8,9});
        Matrix3X3 m2 = new Matrix3X3(new double[]{1,2,3,4,5,6,7,8,9});
        Matrix4X4 m3 = new Matrix4X4(new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
        m3.print();
        m3.transposed().print();
        m3.mul(2).print();

        Matrix3X3 m = m1.mul(m2);
        m.print();

        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector4f v2 = new Vector4f(1, 2, 3, 4);
        m3.mul(v2).print();
        m2.mul(v1).print();
        v2.print();
        System.out.println(v2.length());

        Matrix4X4 z = Matrix4X4.one();
        z.print();

        v1.normalize().print();
    }
}