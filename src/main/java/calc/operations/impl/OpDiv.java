package calc.operations.impl;

import calc.operations.EnumOperation;
import calc.operations.Operation;

public class OpDiv implements Operation {
    public final EnumOperation enumOperation = EnumOperation.DIV;

    @Override
    public double exec(double a, double b) {
        if (b == 0){
            System.out.println("Деление на 0 запрещено !!! Введите другой делитель.");
            return 0;
        }
        return a/b;
    }

    @Override
    public EnumOperation getEnumOperation() {
        return enumOperation;
    }
}
