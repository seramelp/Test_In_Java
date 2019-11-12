package com.melpo.test;

import melpo.StatisticUtilsTemplates;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class StatisticUtilsTemplatesTest {


    private static ArrayList<Double> values1 = new ArrayList<Double>();
    private static ArrayList<Double> values2= new ArrayList<Double>();


    @BeforeClass
    public static void SetUp() {

        values1 = new ArrayList<>(List.of( -3.0,5.0,6.0,7.0));
        values2 = new ArrayList<>(List.of(5.0,6.0,7.0,8.0,5.0));
        //values2.add(null);
    }

    @Test
    public void testListTemplates(){

        StatisticUtilsTemplates demo = new StatisticUtilsTemplates();


        assertEquals(8,demo.getMaxValue(values1),3);
        assertEquals(1,demo.getMinValue(values1),3);
        assertEquals(4.33,demo.getMeanValue(values1),3);
        assertEquals(4.5,demo.getMedianValue(values1),3);
        assertEquals(1,demo.getStdDevValue(values1),3);


        // assertEquals(8,demo.getMaxValue(values2),3);
        assertEquals(1,demo.getMinValue(values2),3);
        assertEquals(8,demo.getMaxValue(values2),3);
        assertEquals(1,demo.getMinValue(values2),3);
        assertEquals(4.33,demo.getMeanValue(values2),3);
        assertEquals(4.5,demo.getMedianValue(values2),3);
        assertEquals(1,demo.getStdDevValue(values2),3);
    }


}
