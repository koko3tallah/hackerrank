import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MinMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min = arr.get(0), max = arr.get(0);
        long totalSum = 0;

        for (Integer integer : arr) {
            if (integer > max)
                max = integer;

            if (integer < min)
                min = integer;

            totalSum += integer;
        }
        System.out.println((totalSum - max) + " " + (totalSum - min));
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MinMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
//
//    public static int sum(int i){
//        return 0;
//    }
//
//    public static int sum(double v) {
//        return 0;
//    }
}
