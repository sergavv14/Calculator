package ua.sergavv.calc;

import ua.sergavv.calc.operations.Operation;

public interface OperationFactory {
    Operation getOplnstance(String op);
}
