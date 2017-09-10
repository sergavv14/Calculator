package ua.sergavv.calc;
import ua.sergavv.calc.operations.*;
import ua.sergavv.calc.operations.impl.*;


public class MyOpFactory implements OperationFactory {
    //AFSDFFSDFSDF
    @Override
    public Operation getOplnstance(String op) {
        switch (op){
            case "+":
                Operation oper = new OpPlus();
                return oper;
                //break;
            case "-":
                Operation oper1 = new OpMinus();
                return oper1;
                //break;
            case "x":
                Operation oper2 = new OpMul();
                return oper2;
                //break;
            case "/":

                Operation oper3 = new OpDiv();
                return oper3;
                //
            case "nod":

                Operation oper4 = new OpNod();
                return oper4;
            //break;

            default:
                return null;
        }
    }
}
