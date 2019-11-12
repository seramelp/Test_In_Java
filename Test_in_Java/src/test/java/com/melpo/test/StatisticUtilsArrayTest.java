package com.melpo.test;

import melpo.StatisticUtilsArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StatisticUtilsArrayTest {

    private double[] array;

    public StatisticUtilsArrayTest(double[] array) {
        this.array = array;
    }


    @Parameterized.Parameters
    public static Collection parameters(){

        return Arrays.asList(new double[][] {
                {1, 2, 3, 7, 8, 5},
                null,
                {},
        });
    }


    @Test
    public void TestArray() {

        StatisticUtilsArray demo = new StatisticUtilsArray();

        assertEquals(8,demo.getMaxValue(array),3);
        assertEquals(1,demo.getMinValue(array),3);
        assertEquals(4.33,demo.getMeanValue(array),3);
        assertEquals(4.5,demo.getMedianValue(array),3);
        assertEquals(1,demo.getStdDev(array),3);

        // assertEquals(8,demo.getMaxValue(array),3);
        assertEquals(1,demo.getMinValue(array),3);
    }

}
