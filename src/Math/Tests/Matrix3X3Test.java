package Math.Tests;

import Math.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Matrix3X3Test {
    @Test
    void testConstructorDoubleArray() {
        double[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix3X3 matrix = new Matrix3X3(m);
        assertArrayEquals(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, matrix.getData());
    }

    @Test
    void testConstructorDoubleArrayIncorrectSize() {
        assertThrows(IllegalArgumentException.class, () -> new Matrix3X3(new double[][]{{1, 2}, {3, 4}, {5, 6}}));
    }

    @Test
    void testGetAt() {
        double[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix3X3 matrix = new Matrix3X3(m);
        assertEquals(1, matrix.getAt(0, 0));
        assertEquals(5, matrix.getAt(1, 1));
        assertEquals(9, matrix.getAt(2, 2));
    }


    @Test
    void testSetAt() {
        Matrix3X3 matrix = Matrix3X3.zero();
        matrix.setAt(1, 1, 5);
        assertEquals(5, matrix.getAt(1, 1));
    }

    @Test
    void testZero() {
        Matrix3X3 zeroMatrix = Matrix3X3.zero();
        assertArrayEquals(new double[9], zeroMatrix.getData());
    }

    @Test
    void testOne() {
        Matrix3X3 oneMatrix = Matrix3X3.one();
        assertArrayEquals(new double[]{1, 0, 0, 0, 1, 0, 0, 0, 1}, oneMatrix.getData(), 0.001);
    }

    @Test
    void testMulDouble() {
        double[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix3X3 matrix = new Matrix3X3(m);
        Matrix3X3 result = matrix.mul(2);
        assertArrayEquals(new double[]{2, 4, 6, 8, 10, 12, 14, 16, 18}, result.getData(), 0.001);
    }

    @Test
    void testMulVector3f() {
        double[][] m = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Matrix3X3 matrix = new Matrix3X3(m);
        Vector3f v = new Vector3f(1, 2, 3);
        Vector3f result = matrix.mul(v);
        assertArrayEquals(new double[]{1, 2, 3}, result.getValues(), 0.001f);
    }


    @Test
    void testMulMatrix3X3() {
        double[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] m2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix3X3 matrix1 = new Matrix3X3(m1);
        Matrix3X3 matrix2 = new Matrix3X3(m2);
        Matrix3X3 result = matrix1.mul(matrix2);
        assertArrayEquals(new double[]{30, 24, 18, 84, 69, 54, 138, 114, 90}, result.getData(), 0.001);
    }

    @Test
    void testTranspose() {
        double[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix3X3 matrix = new Matrix3X3(m);
        matrix.transpose();
        assertArrayEquals(new double[]{1, 4, 7, 2, 5, 8, 3, 6, 9}, matrix.getData(), 0.001);
    }

    @Test
    void testTransposed() {
        double[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix3X3 matrix = new Matrix3X3(m);
        Matrix3X3 transposed = matrix.transposed();
        assertArrayEquals(new double[]{1, 4, 7, 2, 5, 8, 3, 6, 9}, transposed.getData(), 0.001);
        assertNotSame(matrix, transposed); //Проверяем, что возвращается новая матрица

    }

    @Test
    void testAdd() {
        double[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] m2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix3X3 matrix1 = new Matrix3X3(m1);
        Matrix3X3 matrix2 = new Matrix3X3(m2);
        Matrix3X3 result = matrix1.add(matrix2);
        assertArrayEquals(new double[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, result.getData(), 0.001);
    }

    @Test
    void testSub() {
        double[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] m2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Matrix3X3 matrix1 = new Matrix3X3(m1);
        Matrix3X3 matrix2 = new Matrix3X3(m2);
        Matrix3X3 result = matrix1.sub(matrix2);
        assertArrayEquals(new double[]{-8, -6, -4, -2, 0, 2, 4, 6, 8}, result.getData(), 0.001);
    }

    @Test
    void testDeterminant3x3() {
        double[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3X3 matrix = new Matrix3X3(m);
        assertEquals(0, matrix.determinant(), 0.001);
    }

    @Test
    void testInverse3x3() {
        double[][] m = {
                {2, 1, -1},
                {0, 2, 3},
                {3, 1, 1}
        };
        Matrix3X3 matrix = new Matrix3X3(m);
        Matrix3X3 inverse = matrix.inverse();
        Matrix3X3 identity = matrix.mul(inverse); // Проверка, что произведение равно единичной матрице
        assertArrayEquals(new double[]{1,0,0,0,1,0,0,0,1}, identity.getData(), 0.001);
    }

    @Test
    void testInverse3x3Singular() {
        double[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3X3 matrix = new Matrix3X3(m);
        assertThrows(ArithmeticException.class, () -> matrix.inverse());
    }
}
