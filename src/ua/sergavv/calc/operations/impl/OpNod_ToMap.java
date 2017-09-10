package ua.sergavv.calc.operations.impl;

import ua.sergavv.calc.operations.Operation;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class OpNod_ToMap implements Operation {

    @Override
    public double exec(double a1, double b1) {
        ClassNod obj = new ClassNod();
        obj.a = (long) a1;
        obj.b = (long) b1;
        obj.calculateNod();
        return obj.nod;
    }

    public class ClassNod{
        long nod = 1;
        long a, b = 1L;

        public void calculateNod(){
            Map<Long, Long> map1 = generateMap(a);
            Map<Long, Long> map2 = generateMap(b);

            for (Map.Entry entry : map1.entrySet()) {
                long val = (long) entry.getValue();
                long key = (long) entry.getKey();

                while (map2.containsKey(key) && val > 0) {
                    long count = map2.get(key);
                    if (count>0){
                        map1.put(key, count-1L);
                        nod *= key;
                    }else {
                        break;
                    }
                    val = val - 1;
                }
            }
        }

        public Map<Long, Long> generateMap(long a){
            Map<Long, Long> map = new HashMap<Long, Long>();

            while (a > 1L ) {
                for (long i = 2; i <= a; i++) {
                    if (a % i == 0) {
                        if (map.containsKey(i)){
                            long count = map.get(i);
                            map.put(i, count+1L);
                        }else{
                            map.put(i, 1L);
                        }

                        a /= i; // a=a/i;
                        break;
                    }
                    if (a % i == 0) {
                        a /= i;
                        break;
                    }
                }
            }

            return map;
        }

    }
}
