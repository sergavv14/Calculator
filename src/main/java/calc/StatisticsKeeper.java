package calc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class StatisticsKeeper  {
    public Connection Connection = null;
    public Statement StatementConnection = null;

    private static StatisticsKeeper instance = null;

    private StatisticsKeeper() {
        try {
            Class.forName("org.h2.Driver").newInstance();
            Connection = DriverManager.getConnection("jdbc:h2:~/test","sa", "");

            StatementConnection = Connection.createStatement();

            dropTable("OPERATIONS_STATISTICS");
            createTable_Operations_Statistics();

         } catch (Exception e){
            e.printStackTrace();
            closeConnection();
        }

    }

    public static synchronized StatisticsKeeper getInstance(){
        if (instance == null) {
            instance = new StatisticsKeeper();
        }
        return instance;
    }

    private void createTable_Operations_Statistics() throws  Exception{
        String createTable = "CREATE TABLE OPERATIONS_STATISTICS " +
                                "(DATE DATETIME, " +
                                " STATUS VARCHAR(255))";

        StatementConnection.executeUpdate(createTable);
    }

    private void dropTable(String nameTable){
        try {
            String drop = "DROP TABLE " + nameTable;
            StatementConnection.executeUpdate(drop);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void putStatus(String status){
        try {
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String text = date.format(formatter);


            String putData = "INSERT INTO OPERATIONS_STATISTICS (DATE, STATUS)" +
                    " VALUES ('"+ text +"', '" + status + "')";
            StatementConnection.executeUpdate(putData);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            Connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
