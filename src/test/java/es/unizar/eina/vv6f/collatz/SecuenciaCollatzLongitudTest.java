package es.unizar.eina.vv6f.collatz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static es.unizar.eina.vv6f.collatz.SecuenciaCollatzTest.SECUENCIA_EJEMPLO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SecuenciaCollatzLongitudTest {

    @ParameterizedTest(name = "longitud iniciando en {0} es de {1} elementos")
    @CsvSource({
            "13, 10",
            "40,  9",
            "20,  8",
            "10,  7",
             "5,  6",
            "16,  5",
             "8,  4",
             "4,  3",
             "2,  2",
             "1,  1",
    })
    public void secuenciasCollatzLongitudCsvParameterizedTest(int inicio, int longitudEsperada) {
        assertEquals(longitudEsperada, new SecuenciaCollatz(inicio).longitud());
    }

    @ParameterizedTest(name = "longitud iniciando en {0} es de {1} elementos")
    @CsvFileSource(resources = "/longitud.csv", numLinesToSkip = 1)
    public void secuenciasCollatzLongitudCsvFileParameterizedTest(int inicio, int longitudEsperada) {
        assertEquals(longitudEsperada, new SecuenciaCollatz(inicio).longitud());
    }

    private static final int[] INPUTS =  {1, 2, 3, 4, 5, 6,  7, 8,  9, 10, 13, 16, 20, 40};
    private static final int[] OUTPUTS = {1, 2, 8, 3, 6, 9, 17, 4, 20,  7, 10,  5,  8,  9};

    @TestFactory
    Collection<DynamicTest> secuenciasCollatzLongitudDynamicTests() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i = 0; i < INPUTS.length; i++) {
            String nombreTest = String.format("longitud iniciando en %d es de %d elementos", INPUTS[i], OUTPUTS[i]);
            final int numTest = i;
            tests.add(dynamicTest(nombreTest,
                    () -> assertEquals(OUTPUTS[numTest],
                            new SecuenciaCollatz(INPUTS[numTest]).longitud())));
        }
        return tests;
    }

    @TestFactory
    Collection<DynamicTest> testsSecuenciasCollatzLongitud_soloSecuenciaEjemplo() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i = 0; i < SECUENCIA_EJEMPLO.length; i++) {
            final int inicio = SECUENCIA_EJEMPLO[i];
            final int longitud = SECUENCIA_EJEMPLO.length - i;
            String nombreTest = String.format("longitud iniciando en %d es de %d elementos", inicio, longitud);
            tests.add(dynamicTest(nombreTest,
                    () -> assertEquals(longitud,
                            new SecuenciaCollatz(inicio).longitud())));
        }
        return tests;
    }


    @Test
    @DisplayName("assert new SecuenciaCollatz(0) lanza IllegalArgumentException")
    public void testSiguienteCollatz_0() {
        assertThrows(IllegalArgumentException.class,
                () -> new SecuenciaCollatz(0));
    }

    @Test
    @DisplayName("assert new SecuenciaCollatz(-1) lanza IllegalArgumentException")
    public void testSiguienteCollatz_negativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new SecuenciaCollatz(0));
    }
}
