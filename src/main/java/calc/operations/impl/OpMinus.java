package calc.operations.impl;

import calc.operations.EnumOperation;
import calc.operations.Operation;

public class OpMinus implements Operation {
    public final EnumOperation enumOperation = EnumOperation.SUB;

    @Override
    public double exec(double a, double b) {
        return a-b;
    }

    @Override
    public EnumOperation getEnumOperation() {
        return enumOperation;
    }
}
