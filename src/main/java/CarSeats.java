import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


class CarSeats {

    public static int solution(int[] P, int[] S) {
        // write your code in Java SE 8
        int personsCount = 0;
        for (int i : P) {
            personsCount += i;
        }

        Integer[] s = new Integer[S.length];
        Arrays.parallelSetAll(s, i -> S[i]);
        Arrays.sort(s, Collections.reverseOrder());

        int index = 0;
        while (personsCount > 0) {
            personsCount -= s[index];
            index++;
        }
        return index;
    }
}
