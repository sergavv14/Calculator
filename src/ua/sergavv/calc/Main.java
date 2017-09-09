package ua.sergavv.calc;

import ua.sergavv.calc.operations.Operation;

import java.util.*;

public class Main {
    public static void main(String args[]){
        double  arg1, arg2, rez;
        try {
            arg1 = Double.parseDouble(args[0]);
            arg2 = Double.parseDouble(args[2]);
        } catch (IllegalArgumentException e){
            System.err.println("Caught IOException: " + e.getMessage());
            System.out.println("Ошибка! Укажите правильно все аргументы! Результат = 0");
            return;
        }

        MyOpFactory Factory = new MyOpFactory();
        Operation Oper = Factory.getOplnstance(args[1]);
        if (Oper!=null){
            rez = Oper.exec(arg1, arg2);
            System.out.println("Результат = "+ rez);
        } else {
            rez = 0;
            System.out.println("Ошибка! Укажите правильно все аргументы! Результат = "+ rez);
        }
    }
}
