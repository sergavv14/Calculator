package ua.sergavv.calc;

public class OpMul implements Operation {
    @Override
    public double exec(double a, double b) {
        return a*b;
    }
}
