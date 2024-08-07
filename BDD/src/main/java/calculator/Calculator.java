package calculator;

import java.lang.Math;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        return (double) a / b;
    }

    public double sqrt(Number a){
        return Math.sqrt(a.doubleValue());
    }

    public double sqrt_division(int a, int b) {
        double division_result = this.divide(a, b);
        return this.sqrt(division_result);
    }
}
