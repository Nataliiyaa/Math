package Math.Tests;

import Math.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2fTest {
    @Test
    void testConstructor() {
        Vector2f v = new Vector2f(1.0, 2.0);
        assertArrayEquals(new double[]{1.0, 2.0}, v.getValues());
    }

    @Test
    void testGetX() {
        Vector2f v = new Vector2f(3.0, 4.0);
        assertEquals(3.0, v.getX());
    }

    @Test
    void testGetY() {
        Vector2f v = new Vector2f(3.0, 4.0);
        assertEquals(4.0, v.getY());
    }

    @Test
    void testAt() {
        Vector2f v = new Vector2f(5.0, 6.0);
        assertEquals(5.0, v.at(0));
        assertEquals(6.0, v.at(1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> v.at(2)); //Проверяем обработку исключения
    }

    @Test
    void testLength() {
        Vector2f v = new Vector2f(3.0, 4.0);
        assertEquals(5.0, v.length(), 0.001); // Используем delta для сравнения вещественных чисел
        Vector2f zeroVector = new Vector2f(0,0);
        assertEquals(0, zeroVector.length(),0.001);
    }

    @Test
    void testAdd() {
        Vector2f v1 = new Vector2f(1.0, 2.0);
        Vector2f v2 = new Vector2f(3.0, 4.0);
        Vector2f result = v1.add(v2);
        assertArrayEquals(new double[]{4.0, 6.0}, result.getValues());
    }

    @Test
    void testSub() {
        Vector2f v1 = new Vector2f(5.0, 6.0);
        Vector2f v2 = new Vector2f(3.0, 4.0);
        Vector2f result = v1.sub(v2);
        assertArrayEquals(new double[]{2.0, 2.0}, result.getValues());
    }

    @Test
    void testMultiply() {
        Vector2f v = new Vector2f(2.0, 3.0);
        Vector2f result = v.multiply(4.0);
        assertArrayEquals(new double[]{8.0, 12.0}, result.getValues());
    }

    @Test
    void testDiv() {
        Vector2f v = new Vector2f(10.0, 15.0);
        Vector2f result = v.div(5.0);
        assertArrayEquals(new double[]{2.0, 3.0}, result.getValues());
        assertThrows(ArithmeticException.class, () -> v.div(0));
    }

    @Test
    void testNormalize() {
        Vector2f v = new Vector2f(3.0, 4.0);
        Vector2f normalized = v.normalize();
        assertEquals(1.0, normalized.length(), 0.001); // Длина нормированного вектора равна 1
        Vector2f zeroVector = new Vector2f(0,0);
        Vector2f normalizedZero = zeroVector.normalize();
        assertArrayEquals(new double[]{0,0}, normalizedZero.getValues());
    }

    @Test
    void testDotProduct() {
        Vector2f v1 = new Vector2f(1.0, 2.0);
        Vector2f v2 = new Vector2f(3.0, 4.0);
        assertEquals(11.0, v1.dotProduct(v2));
    }
}
