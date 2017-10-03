package calc.operations.impl;

import calc.operations.Operation;

public class OpMinus implements Operation {
    @Override
    public double exec(double a, double b) {
        return a-b;
    }
}
