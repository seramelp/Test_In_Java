/*
        This class calculates the statistics values of max,min,mean,median,variance and standard devision.
        INPUT Array of doubles.
        Use of JAVA STREAMS for calculate the values



 */


package melpo;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class StatisticUtilsArrayStream {

    public  double getMinValue(double[] array){

        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }


        return Arrays.stream(array).min().getAsDouble();
    }

    public  double getMaxValue(double[] array){
        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }


         return Arrays.stream(array).max().getAsDouble();
    }

    //Returns the average value in the specified array.
    public double getMeanValue(double[] array) {
        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        return  Arrays.stream(array).average().orElse(Double.NaN);
    }

    public  double getMedianValue(double[] array){

        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        Arrays.sort(array);
        if (array.length%2 == 1)
            return DoubleStream.of(array).sorted().toArray()[array.length/2];
        else
            return  (DoubleStream.of(array).sorted().toArray()[array.length/2-1]+DoubleStream.of(array).sorted().toArray()[array.length/2]+1)/2;

    }



    public  double getVariance(double[] array){

        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        double mean = getMeanValue(array);
        double temp = 0;


        for(int i=0;i<array.length;i++)
            Math.pow(DoubleStream.of(array).toArray()[i]-mean,2);
        return  temp;//Loose of precision

    }

    public  double getStdDev(double[] array) {

        return Math.sqrt(getVariance(array)/(array.length-1));
    }





}
