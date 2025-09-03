package org.example;

public class Main {

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        double c = 25;
        double f = celsiusToFahrenheit(c);
        System.out.printf("%.1f°C = %.1f°F%n", c, f);

        double f2 = 77;
        double c2 = fahrenheitToCelsius(f2);
        System.out.printf("%.1f°F = %.1f°C%n", f2, c2);
    }
}