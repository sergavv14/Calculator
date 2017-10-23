package calc.reader;

import java.util.Scanner;


public class ReadFromConsole extends DataReader {
    Scanner scanner = new Scanner(System.in);

    public void readFirstNumber() {
        while (true) {
            System.out.print("Введите аргумент №1 (0.00):");
            try {
                readFirstNumber(scanner.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                continue;
            }

        }
    }

    public void readSecondNumber() {
        while (true) {
            System.out.print("Введите аргумент №2 (0.00):");
            try {
                readSecondNumber(scanner.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }

    public void readOperation() {
        while (true) {
            System.out.print("Введите операцию (+), (-), (*), (/), (nod), (NOD):");
            try {
                readOperation(scanner.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }

    @Override
    public void run() {
        readFirstNumber();
        readOperation();
        readSecondNumber();

        getResult();
        printResult();


    }
}

