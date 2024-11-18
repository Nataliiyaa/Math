package Math.Tests;

import Math.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector3fTest {
    @Test
    void testConstructor() {
        Vector3f v = new Vector3f(1.0, 2.0, 3.0);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, v.getValues());
    }

    @Test
    void testGetX() {
        Vector3f v = new Vector3f(3.0, 4.0, 5.0);
        assertEquals(3.0, v.getX());
    }

    @Test
    void testGetY() {
        Vector3f v = new Vector3f(3.0, 4.0, 5.0);
        assertEquals(4.0, v.getY());
    }

    @Test
    void testGetZ() {
        Vector3f v = new Vector3f(3.0, 4.0, 5.0);
        assertEquals(5.0, v.getZ());
    }

    @Test
    void testAt() {
        Vector3f v = new Vector3f(5.0, 6.0, 7.0);
        assertEquals(5.0, v.at(0));
        assertEquals(6.0, v.at(1));
        assertEquals(7.0, v.at(2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> v.at(3));
    }

    @Test
    void testLength() {
        Vector3f v = new Vector3f(3.0, 4.0, 0.0);
        assertEquals(5.0, v.length(), 0.001);
        Vector3f zeroVector = new Vector3f(0, 0, 0);
        assertEquals(0, zeroVector.length(), 0.001);
    }

    @Test
    void testAdd() {
        Vector3f v1 = new Vector3f(1.0, 2.0, 3.0);
        Vector3f v2 = new Vector3f(4.0, 5.0, 6.0);
        Vector3f result = v1.add(v2);
        assertArrayEquals(new double[]{5.0, 7.0, 9.0}, result.getValues());
    }

    @Test
    void testSub() {
        Vector3f v1 = new Vector3f(5.0, 6.0, 7.0);
        Vector3f v2 = new Vector3f(2.0, 3.0, 4.0);
        Vector3f result = v1.sub(v2);
        assertArrayEquals(new double[]{3.0, 3.0, 3.0}, result.getValues());
    }

    @Test
    void testMultiply() {
        Vector3f v = new Vector3f(2.0, 3.0, 4.0);
        Vector3f result = v.multiply(5.0);
        assertArrayEquals(new double[]{10.0, 15.0, 20.0}, result.getValues());
    }

    @Test
    void testDiv() {
        Vector3f v = new Vector3f(10.0, 15.0, 20.0);
        Vector3f result = v.div(5.0);
        assertArrayEquals(new double[]{2.0, 3.0, 4.0}, result.getValues());
        assertThrows(ArithmeticException.class, () -> v.div(0));
    }

    @Test
    void testNormalize() {
        Vector3f v = new Vector3f(3.0, 4.0, 0.0);
        Vector3f normalized = v.normalize();
        assertEquals(1.0, normalized.length(), 0.001);
        Vector3f zeroVector = new Vector3f(0,0,0);
        Vector3f normalizedZero = zeroVector.normalize();
        assertArrayEquals(new double[]{0,0,0}, normalizedZero.getValues());
    }

    @Test
    void testDotProduct() {
        Vector3f v1 = new Vector3f(1.0, 2.0, 3.0);
        Vector3f v2 = new Vector3f(4.0, 5.0, 6.0);
        assertEquals(32.0, v1.dotProduct(v2));
    }

    @Test
    void testCrossProduct() {
        Vector3f v1 = new Vector3f(1.0, 0.0, 0.0);
        Vector3f v2 = new Vector3f(0.0, 1.0, 0.0);
        Vector3f result = v1.crossProduct(v2);
        assertArrayEquals(new double[]{0.0, 0.0, 1.0}, result.getValues(), 0.001);
    }
}
