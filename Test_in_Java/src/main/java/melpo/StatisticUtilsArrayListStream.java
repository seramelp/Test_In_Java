/*
        This class calculates the statistics values of max,min,mean,median,variance and standard devision.
        INPUT Arraylist of doubles.
        Use of JAVA STREAM

 */


package melpo;

import java.util.ArrayList;
import java.util.List;

public class StatisticUtilsArrayListStream {



    public double getMaxValue(List<Double> values){

        // Validates input
        if (values.isEmpty()) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }


        return values.stream().max(Double::compareTo).get();
    }


    public double getMinValue(ArrayList<Double> values){
        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return  values.stream().min(Double::compareTo).get();
    }

    public double getMeanValue(ArrayList <Double> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return  values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

    }

    public double getMedianValue(ArrayList <Double> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        int size= values.size();
        return values.stream().mapToDouble(Double::doubleValue).sorted().skip((size-1)/2).limit(2-size%2).average().orElse(Double.NaN);
        //median = list.stream().sorted().skip(Math.max(0, ((list.size() + 1) / 2) - 1))
        //       .limit(1 + (1 + list.size()) % 2).mapToInt(Integer::intValue).average().getAsDouble();
    }


    public double getVarianceValue(ArrayList<Double> values){
        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        double meanValue= getMeanValue(values);
        return values.stream().map(i->i-meanValue).map(i->i*i).mapToDouble(i->i).average().getAsDouble();

    }

    public double getStdDevValue(ArrayList <Double> values){

        return Math.sqrt(getVarianceValue(values));
    }

}

