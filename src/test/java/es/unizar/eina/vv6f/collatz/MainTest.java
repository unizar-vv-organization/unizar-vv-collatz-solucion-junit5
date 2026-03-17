package es.unizar.eina.vv6f.collatz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private static final int SOLUTION = 837_799;
    private PrintStream oldOut;
    private ByteArrayOutputStream fakeOut;
    private Scanner fakeOutScanner;

    @BeforeEach
    public void setUp() {
        oldOut = System.out;
        fakeOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOut));
    }

    @Test
    public void testMain() {
        Main.main(null);
        fakeOutScanner = new Scanner(fakeOut.toString());
        assertEquals(SOLUTION, fakeOutScanner.nextInt());
    }

    @AfterEach
    public void tearDown() throws IOException {
        System.setOut(oldOut);
        fakeOut.close();
        fakeOutScanner.close();
    }

}