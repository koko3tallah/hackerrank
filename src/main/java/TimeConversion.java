import java.io.*;

class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        boolean isPm = s.toLowerCase().contains("pm");

        int hours = Integer.parseInt(s.substring(0, 2));

        if (isPm) {
            if (hours != 12)
                hours += 12;
        } else {
            if (hours == 12)
                hours -= 12;
        }

        String hoursString = Integer.toString(hours);

        if (hoursString.length() == 1)
            hoursString = "0".concat(hoursString);

        return hoursString.concat(s.substring(2, 8));
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
