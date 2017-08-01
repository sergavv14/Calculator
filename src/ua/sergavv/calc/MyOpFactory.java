package ua.sergavv.calc;

public class MyOpFactory implements OperationFactory {
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
                //break;

            default:
                return null;
        }
    }
}
