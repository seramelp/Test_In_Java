package melpo;

import java.util.ArrayList;
import java.util.List;

public class StatisticUtilsTemplates {


    public static  <T extends Number> double getMaxValue(List <T> values){

        // Validates input
        if (values.isEmpty()) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return values.stream().mapToDouble(v -> (double) v).max().orElse(Double.MAX_VALUE);
    }


    public <T extends Number> double getMinValue(ArrayList<T> values){
        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return (double) values.stream().mapToDouble(v -> (double) v).min().orElse(Double.MIN_VALUE);
    }


    public <T extends Number> double getMeanValue(ArrayList <T> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return values.stream().mapToDouble(v ->(double) v).average().orElse(0.0);
    }

    public <T extends Number> double getMedianValue(List <T> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        int size= values.size();
        return values.stream().mapToDouble(v -> (double) v).sorted().skip((size-1)/2).limit(2-size%2).average().orElse(Double.NaN);
        }



    public <T extends Number> double getVarianceValue(ArrayList<T> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }


        double mean =getMeanValue(values);
        return (double) values.stream().map(i -> (double) i-mean).map(i ->i*i).mapToDouble(i ->i).average().getAsDouble();


    }

    public <T extends Number> double getStdDevValue(ArrayList <T> values){
        return Math.sqrt(getVarianceValue(values));
    }



}
