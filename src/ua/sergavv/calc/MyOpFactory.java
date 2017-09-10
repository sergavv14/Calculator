package ua.sergavv.calc;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import ua.sergavv.calc.operations.*;
import ua.sergavv.calc.operations.impl.*;

import java.util.HashMap;
import java.util.Map;


public class MyOpFactory implements OperationFactory {
    @Override
    public Operation getOplnstance(String op) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("+", "ADD");
        map.put("-", "SUB");
        map.put("x", "MUL");
        map.put("/", "DIV");
        map.put("nod", "NOD");
        map.put("NOD", "NOD_MAP");

        EnumOperation enumOp;
        try{
            enumOp = EnumOperation.valueOf(map.get(op));
        } catch (IllegalArgumentException e){
            System.err.println("Caught IOException: " + e.getMessage());
            return null;
        } catch (NullPointerException e){
            System.err.println("Caught IOException: " + e.getMessage());
            System.err.println("ОШИБКА!!! Невозможно выполнить операцию! Неизвестная операция : " + op);
            return null;
        };


        switch (enumOp){
            case ADD:
                Operation oper = new OpPlus();
                return oper;
                //break;
            case SUB:
                Operation oper1 = new OpMinus();
                return oper1;
                //break;
            case MUL:
                Operation oper2 = new OpMul();
                return oper2;
                //break;
            case DIV:
                Operation oper3 = new OpDiv();
                return oper3;
                //
            case NOD:
                Operation oper4 = new OpNod();
                return oper4;
            //break;
            case NOD_MAP:
                Operation oper5 = new OpNod_ToMap();
                return oper5;
            //break;

            default:
                return null;
        }
    }
}
