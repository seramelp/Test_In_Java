/*
        This class calculates the statistics values of max,min,mean,median,variance and standard devision.
        INPUT Arraylist of doubles.
        Use of Collections and ArrayList class




 */

package melpo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticUtilsArrayList {



    public double getMaxValue(ArrayList <Double> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return Collections.max(values);

    }


    public double getMinValue(ArrayList <Double> values){
        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        return Collections.min(values);
    }

    public double getMeanValue(List <Double> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }


        double meanValue= values.stream().mapToDouble(Double::doubleValue).sum();
        return meanValue/(double) values.size();
    }

    public double getMedianValue(ArrayList <Double> values){

        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        Collections.sort(values);
        int middle = values.size()/2;
        if(values.size() % 2 == 0){
            return 0.5 * (values.get(middle) + values.get(middle-1));
        } else {
            return values.get(middle);
        }
    }

    public double getVarianceValue(ArrayList<Double> values){
        // Validates input
        if (values== null) {
            throw new IllegalArgumentException("The List must not be null");
        } else if (values.size() == 0) {
            throw new IllegalArgumentException("List cannot be empty.");
        }

        double meanValue= getMeanValue(values);
        double temp =0;
        for(int i=0;i<values.size();i++)
            temp += Math.pow(values.get(i)-meanValue,2);

        return  temp;
    }

    public double getStdDevValue(ArrayList <Double> values){
        return Math.sqrt(getVarianceValue(values)/(double) (values.size()-1));
    }

}
