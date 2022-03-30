import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class CountSentencesResult {

    /*
     * Complete the 'countSentences' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY wordSet
     *  2. STRING_ARRAY sentences
     */

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        List<Long> result = new ArrayList<>();
        Map<String, Integer> anagramCountMap = new HashMap<>();

        for (int i = 0; i < wordSet.size(); i++) {
            for (int j = 0; j < wordSet.size(); j++) {
                if (i != j  && isAnagram(wordSet.get(i), wordSet.get(j))) {
                    if (anagramCountMap.containsKey(wordSet.get(i))) {
                        anagramCountMap.put(wordSet.get(i), anagramCountMap.get(wordSet.get(i)) + 2);
                    } else {
                        anagramCountMap.put(wordSet.get(i), 2);
                    }
                }
            }
        }

        for (String sentence : sentences) {
            String[] sentenceWords = sentence.split(" ");
            int noOfAnagrams = 0;
            for (String sentenceWord : sentenceWords) {
                if (anagramCountMap.containsKey(sentenceWord)) {
                    noOfAnagrams += anagramCountMap.get(sentenceWord);
                }
            }
            result.add((long) noOfAnagrams);
        }

        return result;
    }


    private static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        return status;
    }

}

public class CountSentences {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordSetCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> wordSet = IntStream.range(0, wordSetCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int sentencesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> sentences = IntStream.range(0, sentencesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Long> result = CountSentencesResult.countSentences(wordSet, sentences);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
