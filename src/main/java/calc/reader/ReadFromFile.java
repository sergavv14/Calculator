package calc.reader;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class ReadFromFile extends DataReader {
    protected LinkedList<String> linkedListIn;
    protected LinkedList<String> linkedListOut;

    @Override
    public void run(){
        String nameFile = "C:\\GitHub\\Calculator\\src\\main\\java\\calc\\myfile.txt";
        linkedListIn  = readFileInLinkedList(nameFile);

        linkedListOut = new LinkedList<String>();
        for (String strLine: linkedListIn) {
            String [] argsStr = strLine.split(" ");
            String strOut = "";
            if (argsStr.length==3){
                try {
                    readFirstNumber(argsStr[0]);
                    readOperation(argsStr[1]);
                    readSecondNumber(argsStr[2]);

                    getResult();
                    strOut = printResult();
                } catch (IllegalArgumentException | NullPointerException e){
                    strOut = strLine.concat(" " + e.toString());
                    System.out.println(strOut);
                } catch (Exception e){
                    System.out.println(e.toString());
                }

            }
            else{
                strOut = strLine.concat(" ОШИБКА! Укажите правильно все аргументы! Пример: 17.2 + 4.3");
                System.out.println(strOut);
            }

            linkedListOut.add(strOut);
        }

        writeFileFromLinketList(nameFile, linkedListOut);

    }

    public LinkedList<String> readFileInLinkedList(String nameFile){
        LinkedList<String> newListFile = new LinkedList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {

            String contentLine = br.readLine();
            while (contentLine != null) {
                newListFile.add(contentLine);
                contentLine = br.readLine();
            }

        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return newListFile;
    }

    public void  writeFileFromLinketList(String nameFile, List<String> linketList) {

        BufferedWriter bw = null;
        try{
            File file = new File(nameFile);
            if (!file.exists()) {
                file.createNewFile();
            }

            bw = new BufferedWriter(new FileWriter(file));
            for (String strLine: linketList){
                bw.write(strLine);
                bw.newLine();
            }

            bw.flush();
            System.out.println("File written Successfully");

        }catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }
}
