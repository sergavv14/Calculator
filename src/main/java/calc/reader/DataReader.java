package calc.reader;

import calc.factory.MyOpFactory;
import calc.operations.Operation;



public abstract class DataReader {
    protected double arg1 = 0;
    protected double arg2 = 0;
    protected Operation oper = null;
    protected double resultOperation = 0;


    public abstract void run();

    public void readFirstNumber(String strArg1) throws IllegalArgumentException {
        try {
            arg1 = Double.parseDouble(strArg1);
        } catch (IllegalArgumentException e) {
            arg1 = 0;
            throw new IllegalArgumentException("ОШИБКА! Неверно указан аргумент №1! (0.00)");
        }

    };

    public void readSecondNumber(String strArg2) throws IllegalArgumentException {
        try {
            arg2 = Double.parseDouble(strArg2);
        } catch (IllegalArgumentException e) {
            arg2 = 0;
            throw new IllegalArgumentException("ОШИБКА! Неверно указан аргумент №2! (0.00)");
        }


    };

    public void readOperation(String strOperation) throws NullPointerException {
        try {
            MyOpFactory Factory = new MyOpFactory();
            oper = Factory.getOplnstance(strOperation);
        }catch (IllegalArgumentException | NullPointerException e){
            oper = null;
            throw new NullPointerException("ОШИБКА! Операция указана неверно! Доступны такие значения: (+), (-), (x), (/), (nod), (NOD)");
        }
    };


    public double getFirstNumber(){
        return arg1;
    };

    public double getSecondNumber(){
        return arg2;
    };

   public Operation getOperation(){
       return oper;
    };

    public double getResult() throws IllegalArgumentException, NullPointerException{
        try {
            resultOperation = oper.exec(this.arg1, this.arg2);
            return resultOperation;
        } catch (NullPointerException e){
            throw new NullPointerException("ОШИБКА! Неопределно значение операции! oper == null");
        } catch (IllegalArgumentException e){
            throw new NullPointerException("ОШИБКА! Неверно указан аргументы!");
        }
    };

    public String printResult() throws IllegalArgumentException, NullPointerException{
        try {
            String out = "РЕЗУЛЬТАТ: " + arg1 + " " + oper.getEnumOperation().getOperStr() + " " + arg2 + " = "+resultOperation;
            System.out.println(out);
            return out;
        } catch (NullPointerException e){
            throw new NullPointerException("ОШИБКА! Неопределно значение операции! oper == null");
        } catch (IllegalArgumentException e){
            throw new NullPointerException("ОШИБКА! Неверно указан аргументы!");
        }

    };


}
