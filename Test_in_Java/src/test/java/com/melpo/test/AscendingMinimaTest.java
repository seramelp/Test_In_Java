package com.melpo.test;

import melpo.AscendingMinima;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AscendingMinimaTest {

    private static Map<double[], Integer> map = new HashMap<>();

    @BeforeClass
    public static void setUp(){

        double[] array1={5,1,3,2,6,8,4,6};
        int window1=3;
        map.put(array1,window1);
        double[] array2={10,8,5};
        int window2=2;
        map.put(array2,window2);

    }

    @Test
    public void testAscendingMinima(){
        AscendingMinima demo = new AscendingMinima();

        for (double[] key : map.keySet()) {

            int window = map.get(key);

            double[] result = demo.CalcAscendMin(key, window);
            for (int i = 0; i < result.length; i++)
                System.out.println(result[i]);
        }


    }
}


