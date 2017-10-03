package calc.factory;

import calc.operations.Operation;

public interface OperationFactory {
    Operation getOplnstance(String op);
}
