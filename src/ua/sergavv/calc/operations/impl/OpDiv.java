package ua.sergavv.calc.operations.impl;

import ua.sergavv.calc.operations.Operation;

public class OpDiv implements Operation {
    @Override
    public double exec(double a, double b) {
        if (b == 0){
            System.out.println("Деление на 0 запрещено !!! Введите другой делитель.");
            return 0;
        }
        return a/b;
    }
}
