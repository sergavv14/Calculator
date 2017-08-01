package ua.sergavv.calc;

import javax.xml.bind.DatatypeConverter;

public class Main {
    public static void main(String args[]){
        double  arg1, arg2, rez;
        arg1 = Double.parseDouble(args[0]);
        arg2 = Double.parseDouble(args[2]);

        MyOpFactory Factory = new MyOpFactory();
        Operation Oper = Factory.getOplnstance(args[1]);
        if (Oper!=null){
            rez = Oper.exec(arg1, arg2);
            System.out.println("Результат = "+ rez);
        } else {
            rez = 0;
            System.out.println("Ошибка! Укажите правильне символы! Результат = "+ rez);
        }

    }
}
