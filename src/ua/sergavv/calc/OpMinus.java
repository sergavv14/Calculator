package ua.sergavv.calc;

public class OpMinus implements Operation{
    @Override
    public double exec(double a, double b) {
        return a-b;
    }
}
