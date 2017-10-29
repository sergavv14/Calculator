package calc.factory;

import calc.operations.EnumOperation;
import calc.operations.Operation;

public interface OperationFactory {
    Operation getOplnstance(EnumOperation enumOp);
}
