package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    //Testes positivos
    @Test public void testCelsiusToFahrenheitZero() { assertEquals(32.0, Main.celsiusToFahrenheit(0)); }
    @Test public void testCelsiusToFahrenheit100() { assertEquals(212.0, Main.celsiusToFahrenheit(100)); }
    @Test public void testCelsiusToFahrenheitNegative40() { assertEquals(-40.0, Main.celsiusToFahrenheit(-40)); }
    @Test public void testCelsiusToFahrenheit37() { assertEquals(98.6, Main.celsiusToFahrenheit(37), 0.1); }
    @Test public void testFahrenheitToCelsius32() { assertEquals(0.0, Main.fahrenheitToCelsius(32)); }
    @Test public void testFahrenheitToCelsius212() { assertEquals(100.0, Main.fahrenheitToCelsius(212)); }
    @Test public void testFahrenheitToCelsiusNegative40() { assertEquals(-40.0, Main.fahrenheitToCelsius(-40)); }
    @Test public void testFahrenheitToCelsius98_6() { assertEquals(37.0, Main.fahrenheitToCelsius(98.6), 0.1); }
    @Test public void testCelsiusToFahrenheitBoilingPoint() { assertEquals(212.0, Main.celsiusToFahrenheit(100)); }
    @Test public void testFahrenheitToCelsiusFreezingPoint() { assertEquals(0.0, Main.fahrenheitToCelsius(32)); }

    //Testes negativos
    @Test public void testCelsiusToFahrenheitNaN() { assertTrue(Double.isNaN(Main.celsiusToFahrenheit(Double.NaN))); }
    @Test public void testFahrenheitToCelsiusNaN() { assertTrue(Double.isNaN(Main.fahrenheitToCelsius(Double.NaN))); }
    @Test public void testCelsiusToFahrenheitInfinity() { assertEquals(Double.POSITIVE_INFINITY, Main.celsiusToFahrenheit(Double.POSITIVE_INFINITY)); }
    @Test public void testFahrenheitToCelsiusInfinity() { assertEquals(Double.POSITIVE_INFINITY, Main.fahrenheitToCelsius(Double.POSITIVE_INFINITY)); }
    @Test public void testCelsiusToFahrenheitNegativeInfinity() { assertEquals(Double.NEGATIVE_INFINITY, Main.celsiusToFahrenheit(Double.NEGATIVE_INFINITY)); }
    @Test public void testFahrenheitToCelsiusNegativeInfinity() { assertEquals(Double.NEGATIVE_INFINITY, Main.fahrenheitToCelsius(Double.NEGATIVE_INFINITY)); }
    @Test public void testCelsiusToFahrenheitLargeValue() { assertEquals(1800032.0, Main.celsiusToFahrenheit(1000000)); }
    @Test public void testFahrenheitToCelsiusLargeValue() { assertEquals(555537.78, Main.fahrenheitToCelsius(1000000), 0.01); }
    @Test public void testCelsiusToFahrenheitPrecision() { assertEquals(33.8, Main.celsiusToFahrenheit(1), 0.01); }
    @Test public void testFahrenheitToCelsiusPrecision() { assertEquals(1.0, Main.fahrenheitToCelsius(33.8), 0.01); }
}