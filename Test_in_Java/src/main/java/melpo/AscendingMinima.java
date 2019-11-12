/*
        This method calculate the result array of Ascending Minima algoritm.
        INPUT an double[] array and an integer window
        The algorithm for this "slides" a "window" of size K over the array computing at each step the current minimum.
        The trick to this is to store the numbers in a deque [1] and whenever inserting a number x we remove all numbers
        at the back of the deque which are greater than equal to x.
        Notice that if the deque was sorted before inserting, it will still be sorted after inserting x.
        Since the deque starts off sorted, it remains sorted throughout the sliding window algorithm.
        So the front of the deque will always be the smallest value

 */


package melpo;

import java.util.ArrayDeque;
import java.util.Deque;

public class AscendingMinima {


    public double[] CalcAscendMin(double[] array, int window_k) {

        if (window_k <= 0)
            throw new IllegalArgumentException("Window size must be positive");
        if (array.length < window_k)
            throw new IllegalArgumentException("Window bigger than array length");

        double[] result = new double[array.length - window_k + 1];
        Deque<Double> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {  // Range end index (inclusive)
            double val = array[i];
            while (!deque.isEmpty() && val <= deque.getLast())
                deque.removeLast();
            deque.addLast(val);

            int j = i + 1 - window_k;  // Range start index, does not overflow
            if (j >= 0) {
                result[j] = deque.getFirst();
                if (array[j] == result[j])
                    deque.removeFirst();
            }
        }

        return result;


    }

}

