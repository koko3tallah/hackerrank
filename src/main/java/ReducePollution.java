import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ReducePollution {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        float totalPollution = 0;
        for (int i : A) {
            totalPollution += i;
        }
        float halfPollution = totalPollution / 2;
        long distinct = Arrays.stream(A).distinct().count();

        if (distinct == 1L)
            return A.length;

        PriorityQueue<Float> orderedFactories = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : A)
            orderedFactories.add(((float) i));

        int count = 0;
        while (totalPollution > halfPollution) {
            if (orderedFactories.peek() != null) {
                float currentPollution = orderedFactories.poll();
                float newHalfPollution = currentPollution / 2;
                totalPollution -= newHalfPollution;
                count++;
                orderedFactories.add(newHalfPollution);
            }
        }
        return count;
    }

}
