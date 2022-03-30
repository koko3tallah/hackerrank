import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class PlusMinusResult {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double positives = 0, negatives = 0, zeros = 0;
        for (Integer element : arr) {
            if (element > 0)
                positives++;
            else if (element < 0)
                negatives++;
            else
                zeros++;
        }
        System.out.printf("%.6f", positives / arr.size());
        System.out.println();
        System.out.printf("%.6f", negatives / arr.size());
        System.out.println();
        System.out.printf("%.6f", zeros / arr.size());
        System.out.println();

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusResult.plusMinus(arr);

        bufferedReader.close();
    }
}
