package Math.Tests;

import Math.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Vector4fTest {
    @Test
    void testConstructor() {
        Vector4f v = new Vector4f(1.0, 2.0, 3.0, 4.0);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, v.getValues());
    }

    @Test
    void testGetX() {
        Vector4f v = new Vector4f(3.0, 4.0, 5.0, 6.0);
        assertEquals(3.0, v.getX());
    }

    @Test
    void testGetY() {
        Vector4f v = new Vector4f(3.0, 4.0, 5.0, 6.0);
        assertEquals(4.0, v.getY());
    }

    @Test
    void testGetZ() {
        Vector4f v = new Vector4f(3.0, 4.0, 5.0, 6.0);
        assertEquals(5.0, v.getZ());
    }

    @Test
    void testGetW() {
        Vector4f v = new Vector4f(3.0, 4.0, 5.0, 6.0);
        assertEquals(6.0, v.getW());
    }

    @Test
    void testAt() {
        Vector4f v = new Vector4f(5.0, 6.0, 7.0, 8.0);
        assertEquals(5.0, v.at(0));
        assertEquals(6.0, v.at(1));
        assertEquals(7.0, v.at(2));
        assertEquals(8.0, v.at(3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> v.at(4));
    }

    @Test
    void testLength() {
        Vector4f v = new Vector4f(1.0, 1.0, 1.0, 1.0);
        assertEquals(2.0, v.length(), 0.001);
        Vector4f zeroVector = new Vector4f(0, 0, 0, 0);
        assertEquals(0, zeroVector.length(), 0.001);
    }

    @Test
    void testAdd() {
        Vector4f v1 = new Vector4f(1.0, 2.0, 3.0, 4.0);
        Vector4f v2 = new Vector4f(5.0, 6.0, 7.0, 8.0);
        Vector4f result = v1.add(v2);
        assertArrayEquals(new double[]{6.0, 8.0, 10.0, 12.0}, result.getValues());
    }

    @Test
    void testSub() {
        Vector4f v1 = new Vector4f(10.0, 9.0, 8.0, 7.0);
        Vector4f v2 = new Vector4f(5.0, 4.0, 3.0, 2.0);
        Vector4f result = v1.sub(v2);
        assertArrayEquals(new double[]{5.0, 5.0, 5.0, 5.0}, result.getValues());
    }

    @Test
    void testMultiply() {
        Vector4f v = new Vector4f(2.0, 3.0, 4.0, 5.0);
        Vector4f result = v.multiply(2.0);
        assertArrayEquals(new double[]{4.0, 6.0, 8.0, 10.0}, result.getValues());
    }

    @Test
    void testDiv() {
        Vector4f v = new Vector4f(10.0, 20.0, 30.0, 40.0);
        Vector4f result = v.div(10.0);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, result.getValues());
        assertThrows(ArithmeticException.class, () -> v.div(0));
    }


    @Test
    void testNormalize() {
        Vector4f v = new Vector4f(1.0, 1.0, 1.0, 1.0);
        Vector4f normalized = v.normalize();
        assertEquals(1.0, normalized.length(), 0.001);
        Vector4f zeroVector = new Vector4f(0, 0, 0, 0);
        Vector4f normalizedZero = zeroVector.normalize();
        assertArrayEquals(new double[]{0, 0, 0, 0}, normalizedZero.getValues());
    }

    @Test
    void testDotProduct() {
        Vector4f v1 = new Vector4f(1.0, 2.0, 3.0, 4.0);
        Vector4f v2 = new Vector4f(5.0, 6.0, 7.0, 8.0);
        assertEquals(70.0, v1.dotProduct(v2));
    }
}