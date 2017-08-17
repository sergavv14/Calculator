package ua.sergavv.calc.operations.impl;

import ua.sergavv.calc.operations.Operation;

public class OpMul implements Operation {
    @Override
    public double exec(double a, double b) {
        return a*b;
    }
}
