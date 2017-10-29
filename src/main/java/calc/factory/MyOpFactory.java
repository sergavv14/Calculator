package calc.factory;
import calc.operations.EnumOperation;
import calc.operations.*;
import calc.operations.impl.*;



public class MyOpFactory implements OperationFactory {

    @Override
    public Operation getOplnstance(EnumOperation enumOp) throws IllegalArgumentException {

        switch (enumOp){
            case ADD:
                Operation oper = new OpPlus();
                return oper;
            case SUB:
                Operation oper1 = new OpMinus();
                return oper1;
            case MUL:
                Operation oper2 = new OpMul();
                return oper2;
            case DIV:
                Operation oper3 = new OpDiv();
                return oper3;
            case NOD:
                Operation oper4 = new OpNod();
                return oper4;
            case NOD_MAP:
                Operation oper5 = new OpNod_ToMap();
                return oper5;
            default:
                throw new IllegalArgumentException();
        }
    }
}
