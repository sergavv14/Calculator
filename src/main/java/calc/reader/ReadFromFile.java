package calc.reader;

import calc.MyError.My_IllegalArgumentException;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ReadFromFile extends DataReader {

    private String path;
    private RandomAccessFile file;

    public ReadFromFile(String path) {
        this.path = path;
    }


    // этот метод читает файл и выводит его содержимое
    public String read() throws IOException {
        file = new RandomAccessFile(path, "r");
        String res = "";
        int b = file.read();
        // побитово читаем символы и плюсуем их в строку
        while (b != -1) {
            res = res + (char) b;
            b = file.read();
        }
        file.close();

        return res;
    }

    // запись в файл
    public void write(String st) throws IOException {
        // открываем файл для записи
        // для этого указываем модификатор rw (read & write)
        // что позволит открыть файл и записать его
        file = new RandomAccessFile(path, "rw");

        // записываем строку переведенную в биты
        file.write(st.getBytes());

        // закрываем файл, после чего данные записываемые данные попадут в файл
        file.close();
    }

    @Override
    public String printResult() throws My_IllegalArgumentException {
        super.printResult();
        return " "+String.valueOf(resultOperation) + ";";
    }

    @Override
    public void run() {

        String allText = "";
        try {
            allText = read();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        StringBuilder stringBuilder = new StringBuilder(allText);

        int indexStart = 0;
        int indexEnd = stringBuilder.indexOf("=");
        while (indexEnd!=-1){
            String strResult = "";

            String strLine = stringBuilder.substring(indexStart, indexEnd);
            int indexLine = strLine.indexOf('\n');
            if (indexLine!=-1) strLine = strLine.substring(indexLine);
            strLine = strLine.replace('\r',' ');
            strLine = strLine.replace('\n',' ');
            strLine = strLine.trim();

            String [] argsStr = strLine.split(" ");
            if (argsStr.length==3){
                try {
                    readFirstNumber(argsStr[0]);
                    readOperation(argsStr[1]);
                    readSecondNumber(argsStr[2]);

                    getResult();
                    strResult = printResult();
                } catch (My_IllegalArgumentException e){
                    strResult = e.toString();
                    System.out.println(e.toString());
                }

            }
            else{
                strResult = " ОШИБКА! Укажите правильно все аргументы! Пример:(17.2 + 4.3 =)";
                System.out.println(strResult);
            }

            stringBuilder.insert(indexEnd+1, strResult);
            indexStart = indexEnd+1+strResult.length();
            indexEnd = stringBuilder.indexOf("=", indexStart);
        }

        try {
            write(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
