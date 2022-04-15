import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class FlippingTheMatrixResult {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int size = matrix.size();
        int h = size / 2;

        long sum = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                long localMax = 0;
                if (localMax < matrix.get(i).get(j))
                    localMax = matrix.get(i).get(j);

                if (localMax < matrix.get(i).get(size - 1 - j))
                    localMax = matrix.get(i).get(size - 1 - j);

                if (localMax < matrix.get(size - 1 - i).get(j))
                    localMax = matrix.get(size - 1 - i).get(j);

                if (localMax < matrix.get(size - 1 - i).get(size - 1 - j))
                    localMax = matrix.get(size - 1 - i).get(size - 1 - j);

                sum += localMax;
            }
        }
        return ((int) sum);
    }
}

public class FlippingTheMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = FlippingTheMatrixResult.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
