
class SentenceCropping {

    public static String solution(String message, int K) {
        // write your code in Java SE 8

        if (message.length() <= K) {
            if (message.endsWith(" ")) {
                return message.substring(0, message.length() - 1);
            } else
                return message;
        }

        String[] words = message.split(" ");

        int currentStableCharCount = 0;
        int testingCharCount = 0;

        for (String word : words) {
            if (testingCharCount <= K) {
                testingCharCount += word.length();

                if (testingCharCount == K) {
                    currentStableCharCount = testingCharCount;
                    break;
                } else if (testingCharCount > K) {
                    break;
                } else {
                    currentStableCharCount = testingCharCount;
                }

                testingCharCount++;
            } else {
                break;
            }
        }

        return message.substring(0, currentStableCharCount);
    }
}
