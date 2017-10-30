package calc.reader;

import calc.MyError.My_IllegalArgumentException;
import calc.StatisticsKeeper;
import calc.factory.MyOpFactory;
import calc.operations.EnumOperation;
import calc.operations.Operation;



public abstract class DataReader {
    protected double arg1 = 0;
    protected double arg2 = 0;
    protected Operation oper = null;
    protected double resultOperation = 0;
    protected StatisticsKeeper statisticsKeeper = StatisticsKeeper.getInstance();

    public abstract void run();

    public void readFirstNumber(String strArg1) throws My_IllegalArgumentException {
        try {
            arg1 = Double.parseDouble(strArg1);
        } catch (IllegalArgumentException e) {
            arg1 = 0;
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("ОШИБКА! Неверно указан аргумент №1! (0.00)");
        }

    }

    public void readSecondNumber(String strArg2) throws My_IllegalArgumentException {
        try {
            arg2 = Double.parseDouble(strArg2);
        } catch (IllegalArgumentException e) {
            arg2 = 0;
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("ОШИБКА! Неверно указан аргумент №2! (0.00)");
        }


    }

    public void readOperation(String strOperation) throws My_IllegalArgumentException {
        try {
            EnumOperation enumOp = EnumOperation.getEnumOperation(strOperation);
            if (enumOp==null) throw new NullPointerException();

            MyOpFactory Factory = new MyOpFactory();
            oper = Factory.getOplnstance(enumOp);

        }catch (IllegalArgumentException | NullPointerException e){
            oper = null;
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("ОШИБКА! Операция указана неверно! Доступны такие значения: (+), (-), (x), (/), (nod), (NOD)");
        }
    }


    public double getFirstNumber(){
        return arg1;
    }

    public double getSecondNumber(){
        return arg2;
    }

   public Operation getOperation(){
       return oper;
    }

    public double getResult() throws My_IllegalArgumentException{
        try {
            resultOperation = oper.exec(this.arg1, this.arg2);
            return resultOperation;
        } catch (NullPointerException e){
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("printResult().NullPointerException ОШИБКА! Неопределно значение операции! oper == null");
        } catch (IllegalArgumentException e){
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("printResult().IllegalArgumentException ОШИБКА! Неверно указан аргументы!");
        }
    }

    public String printResult() throws My_IllegalArgumentException{
        try {
            String out = "РЕЗУЛЬТАТ: " + arg1 + " " + oper.getEnumOperation().getOperStr() + " " + arg2 + " = "+resultOperation;
            System.out.println(out);
            statisticsKeeper.putStatus(out);
            return out;
        } catch (NullPointerException e){
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("printResult().NullPointerException ОШИБКА! Неопределно значение операции! oper == null");
        } catch (IllegalArgumentException e){
            statisticsKeeper.putStatus("!!! ОШИБКА !!!");
            throw new My_IllegalArgumentException("printResult().IllegalArgumentException ОШИБКА! Неверно указан аргументы!");
        }

    }


}
