package es.unizar.eina.vv6f.collatz;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static es.unizar.eina.vv6f.collatz.SecuenciaCollatzTest.SECUENCIA_EJEMPLO;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static es.unizar.eina.vv6f.collatz.SecuenciaCollatz.siguienteCollatz;

public class SecuenciaCollatzSiguienteTest {

    @ParameterizedTest(name="siguienteCollatz({0}) es {1}")
    @CsvSource({
            "40, 20",
            "13, 40",
            "20, 10",
            "10,  5",
             "5, 16",
            "16, 8",
             "8, 4",
             "4, 2",
             "2, 1",
    })
    public void siguienteCollatzCsvTest(long input, long expected) {
        assertEquals(expected, siguienteCollatz(input));
    }

    @ParameterizedTest(name="siguienteCollatz({0}) es {1}")
    @CsvFileSource(resources = "/siguiente.csv", numLinesToSkip = 1)
    public void siguienteCollatzCsvFileTest(long input, long expected) {
        assertEquals(expected, siguienteCollatz(input));
    }

    @TestFactory
    Collection<DynamicTest> siguienteCollatzDynamicTest() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i = 0; i < SECUENCIA_EJEMPLO.length - 1; i++) {
            final int numTest = i;
            String nombreTest = String.format("siguienteCollatz(%d) es %d",
                    SECUENCIA_EJEMPLO[numTest], SECUENCIA_EJEMPLO[numTest + 1]);
            tests.add(dynamicTest(nombreTest,
                    () -> assertEquals(SECUENCIA_EJEMPLO[numTest + 1],
                            siguienteCollatz(SECUENCIA_EJEMPLO[numTest]))));
        }
        return tests;
    }
}
