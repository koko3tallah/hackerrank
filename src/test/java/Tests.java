import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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
        Result.plusMinus(Arrays.asList(arr));

        String expectedMessage = "0.500000" + System.lineSeparator()
                + "0.333333" + System.lineSeparator()
                + "0.166667" + System.lineSeparator();
        String actualMassage = systemOutContent.toString();

        assertEquals(expectedMessage, actualMassage);
    }
}
