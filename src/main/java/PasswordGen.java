import java.io.*;
import java.nio.charset.StandardCharsets;


class PasswordGenResult {

    /*
     * Complete the 'newPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static String newPassword(String a, String b) throws Exception {
        if (a.isEmpty() || a.length() > 25000 || b.isEmpty() || b.length() > 25000)
            throw new Exception("One of the strings are out of boundaries, both strings should be within 1 to 25000 character.");

//        if (a.matches("[A-Za-z0-9]*") || a.matches(".*\\d+.*")
//                || b.matches("[A-Za-z0-9]*") || b.matches(".*\\d+.*"))
//            throw new Exception("One of the strings contains number or an uppercase letter");

        boolean appendToB = true;
        int minLength = a.length();
        if (b.length() < a.length()) {
            minLength = b.length();
            appendToB = false;
        }

        StringBuilder passwordBuilder = new StringBuilder();

        byte[] aChars = a.getBytes(StandardCharsets.UTF_8);
        byte[] bChars = b.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < minLength; i++) {
            passwordBuilder.append((char) aChars[i]);
            passwordBuilder.append((char) bChars[i]);
        }
        if (appendToB) {
            passwordBuilder.append(b.substring(minLength));
        } else {
            passwordBuilder.append(a.substring(minLength));
        }
        return passwordBuilder.toString();
    }

}

public class PasswordGen {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        String result = null;
        try {
            result = PasswordGenResult.newPassword(a, b);
            bufferedWriter.write(result);
        } catch (Exception e) {
            bufferedWriter.write(e.getMessage());
        }
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
