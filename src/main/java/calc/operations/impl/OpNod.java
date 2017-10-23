package calc.operations.impl;

import calc.operations.EnumOperation;
import calc.operations.Operation;

public class OpNod implements Operation {
    public final EnumOperation enumOperation = EnumOperation.NOD;

    @Override
    public double exec(double a1, double b1) {
        long nod = 1L;
        ClassNod.a = (long) a1;
        ClassNod.b = (long) b1;
        ClassNod.calculateNod();
        return ClassNod.nod;
    }

    @Override
    public EnumOperation getEnumOperation() {
        return enumOperation;
    }

    public static class ClassNod{
        static long nod = 1L;
        static long a;
        static long b;

        public static void calculateNod(){
            if (a > b) {
                long tmp = a;
                a = b;
                b = tmp;
            }

            while (a > 1L && b > 1L) {
                for (long i = 2; i <= a; i++) {
                    if (a % i == 0 && b % i == 0) {
                        nod *= i;
                        a /= i;
                        b /= i;
                        break;
                    }
                    if (a % i == 0) {
                        a /= i;
                        break;
                    }
                    if (b % i == 0) {
                        b /= i;
                        break;
                    }
                }
            }
        }

    }


}
