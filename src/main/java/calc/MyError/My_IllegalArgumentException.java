package calc.MyError;


import calc.StatisticsKeeper;

public class My_IllegalArgumentException extends IllegalArgumentException {
    StatisticsKeeper statisticsKeeper = StatisticsKeeper.getInstance();

    public My_IllegalArgumentException(String message){
        super(message);
        statisticsKeeper.putStatus(message);
    }
}
