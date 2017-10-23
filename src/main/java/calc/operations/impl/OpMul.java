package calc.operations.impl;

import calc.operations.EnumOperation;
import calc.operations.Operation;

public class OpMul implements Operation {
    public final EnumOperation enumOperation = EnumOperation.MUL;

    @Override
    public double exec(double a, double b) {
        return a*b;
    }

    @Override
    public EnumOperation getEnumOperation() {
        return enumOperation;
    }
}
