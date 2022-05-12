import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    private PrintStream originalSystemOut;
    private ByteArrayOutputStream systemOutContent;

    @BeforeEach
    void redirectSystemOutStream() {
        originalSystemOut = System.out;

        // given
        systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalSystemOut);
    }

    @Test
    void testPlusMinusTest() {

        Integer[] arr = {-4, 3, -9, 0, 4, 1};
        PlusMinusResult.plusMinus(Arrays.asList(arr));

        String expectedMessage = "0.500000" + System.lineSeparator()
                + "0.333333" + System.lineSeparator()
                + "0.166667" + System.lineSeparator();
        String actualMassage = systemOutContent.toString();

        assertEquals(expectedMessage, actualMassage);
    }

    @Test
    void testCountSentences() {
        String[] wordSets = {"the", "bats", "tabs", "in", "cat", "act", "war", "raw"};
        List<String> wordSet = Arrays.asList(wordSets);
//        List<String> wordSet = new ArrayList<>();
//
//        wordSet.add("listen");
//        wordSet.add("silent");
//        wordSet.add("it");
//        wordSet.add("is");

        String[] sentencess = {"cat bats war", "cat the bats", "in the act", "act tabs in", "cat in act tabs"};
        List<String> sentences = Arrays.asList(sentencess);
//        List<String> sentences = new ArrayList<>();

//        sentences.add("listen it is silent");

        CountSentencesResult.countSentences(wordSet, sentences);
    }

    @Test
    void testMinMaxSum() {
        Integer[] arr = {8, 3};
        MinMaxSumResult.miniMaxSum(Arrays.asList(arr));
    }

    @Test
    void testTimeConversion() {
        assertEquals("04:59:59", TimeConversionResult.timeConversion("04:59:59AM"));
        assertEquals("00:00:00", TimeConversionResult.timeConversion("12:00:00AM"));
        assertEquals("12:00:00", TimeConversionResult.timeConversion("12:00:00PM"));
        assertEquals("12:01:00", TimeConversionResult.timeConversion("12:01:00PM"));
        assertEquals("00:01:00", TimeConversionResult.timeConversion("12:01:00AM"));
        assertEquals("00:01:00", TimeConversionResult.timeConversion("00:01:00AM"));
        assertEquals("19:05:45", TimeConversionResult.timeConversion("07:05:45PM"));
        assertEquals("23:59:59", TimeConversionResult.timeConversion("11:59:59PM"));
        assertEquals("00:00:01", TimeConversionResult.timeConversion("12:00:01AM"));
    }

    @Test
    void testMedian() {
        Integer[] arr = {0, 1, 2, 4, 6, 5, 3};

        int res = MedianResult.findMedian(Arrays.asList(arr));
        assertEquals(3, res);
    }

    @Test
    void tesFlippingTheMatrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2));
        matrix.add(Arrays.asList(3, 4));

        List<List<Integer>> matrixII = new ArrayList<>();
        matrixII.add(Arrays.asList(112, 42, 83, 119));
        matrixII.add(Arrays.asList(56, 125, 56, 49));
        matrixII.add(Arrays.asList(15, 78, 101, 43));
        matrixII.add(Arrays.asList(62, 98, 114, 108));


        List<List<Integer>> matrixIII = new ArrayList<>();
        matrixIII.add(Arrays.asList(112, 42, 83, 119, 132, 59));
        matrixIII.add(Arrays.asList(56, 125, 56, 49, 15, 120));
        matrixIII.add(Arrays.asList(15, 78, 101, 43, 96, 75));
        matrixIII.add(Arrays.asList(62, 98, 114, 108, 238, 59));
        matrixIII.add(Arrays.asList(12, 45, 86, 72, 89, 58));
        matrixIII.add(Arrays.asList(120, 160, 25, 187, 47, 59));

        assertEquals(4, FlippingTheMatrixResult.flippingMatrix(matrix));
        assertEquals(414, FlippingTheMatrixResult.flippingMatrix(matrixII));
        assertEquals(1225, FlippingTheMatrixResult.flippingMatrix(matrixIII));
    }


    @Test
    void testBraces() {
        String test1 = "{}()";
        String test2 = "{()}";
        String test3 = "({()})";
        String test4 = "{}(";
        String test5 = "}{";

        assertEquals("true", Parser.isBalanced(test1));
        assertEquals("true", Parser.isBalanced(test2));
        assertEquals("true", Parser.isBalanced(test3));
        assertEquals("false", Parser.isBalanced(test4));
        assertEquals("false", Parser.isBalanced(test5));
    }


    @Test
    void testInterviewI() {
        assertEquals("Codility We", SentenceCropping.solution("Codility We test coders", 14));
        assertEquals("Codility We test code", SentenceCropping.solution("Codility We test code ", 88));
        assertEquals("Codility We test code", SentenceCropping.solution("Codility We test code ", 23));
        assertEquals("Codility We", SentenceCropping.solution("Codility We test code ", 11));
        assertEquals("Codility", SentenceCropping.solution("Codility We test code ", 10));
        assertEquals("", SentenceCropping.solution("Codility We test code ", 3));
        assertEquals("The quick brown fox jumps over the lazy", SentenceCropping.solution("The quick brown fox jumps over the lazy dog ", 39));
        assertEquals("To crop or not to", SentenceCropping.solution("To crop or not to crop ", 21));
    }

    @Test
    void testInterviewII() {
        assertEquals(2, CarSeats.solution(new int[]{1, 4, 1}, new int[]{1, 5, 1}));
        assertEquals(3, CarSeats.solution(new int[]{4, 2, 2, 4}, new int[]{5, 5, 2, 5}));
        assertEquals(2, CarSeats.solution(new int[]{2, 3, 4, 2}, new int[]{2, 5, 7, 2}));
    }

    @Test
    void testInterviewIII() {
        assertEquals(3, ReducePollution.solution(new int[]{5, 19, 8, 1}));
        assertEquals(2, ReducePollution.solution(new int[]{10, 10}));
        assertEquals(2, ReducePollution.solution(new int[]{3, 0, 5}));
    }

    @Test
    void testRemaining() {
        int[] expected = {1, 0, 0, 0, 0, 4};
        int[] actual = ChangeCalculator.getChange(5, 0.99f);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testStringOccurrences() {
        String[] inputStrings = {"aba", "baba", "aba", "xzxb"};
        String[] inputQueries = {"aba", "xzxb", "ab"};

        Integer[] expected = {2, 1, 0};
        assertArrayEquals(expected, StringOccurrencesResult.matchingStrings(Arrays.asList(inputStrings), Arrays.asList(inputQueries)).toArray());
    }

    @Test
    void testLonelyInteger() {
        Integer[] input = {1, 2, 3, 4, 3, 2, 1};

        assertEquals(4, UniqueElementResult.lonelyInteger(Arrays.asList(input)));
    }
}
