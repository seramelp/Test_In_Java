/*
        This class calculates the statistics values of max,min,mean,median,variance and standard devision.
        INPUT Array of doubles.
        Use of StatUtils class for calculate the values

 */


package melpo;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.util.FastMath;



public class StatisticUtilsArray {


    public double getMinValue(double[] array){

        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }


        return StatUtils.min(array);
    }

    public double getMaxValue(double[] array){
        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        return StatUtils.max(array);
    }

    //Returns the average value in the specified array.
    public double getMeanValue(double[] array) {
        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

       return StatUtils.mean(array);
    }

    public  double getMedianValue(double[] array){

        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        return StatUtils.percentile(array,50);
    }

    /*
    public static double getVariance(double[] array){

        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        double mean=getMeanValue(array);
        double temp = 0;
        for(int i=0;i<array.length;i++)
            temp += Math.pow(array[i]=mean,2);
        return temp;

    }
     */

    public  double getStdDev(double[] array) {

        return FastMath.sqrt(StatUtils.variance(array));
    }

}
