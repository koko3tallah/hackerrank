import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

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
    void testSol1() {
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


}
