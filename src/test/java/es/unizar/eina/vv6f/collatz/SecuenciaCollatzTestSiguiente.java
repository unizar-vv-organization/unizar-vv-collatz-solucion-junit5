package es.unizar.eina.vv6f.collatz;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static es.unizar.eina.vv6f.collatz.SecuenciaCollatzTest.SECUENCIA_EJEMPLO;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static es.unizar.eina.vv6f.collatz.SecuenciaCollatz.siguienteCollatz;

public class SecuenciaCollatzTestSiguiente {

    @TestFactory
    Collection<DynamicTest> testsSecuenciasCollatzSiguiente() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i = 0; i < SECUENCIA_EJEMPLO.length - 1; i++) {
            final int numTest = i;
            String nombreTest = String.format("siguienteCollatz(%d) es %d",
                    SECUENCIA_EJEMPLO[numTest], SECUENCIA_EJEMPLO[numTest + 1]);
            tests.add(dynamicTest(nombreTest,
                    () -> Assertions.assertEquals(SECUENCIA_EJEMPLO[numTest + 1],
                            siguienteCollatz(SECUENCIA_EJEMPLO[numTest]))));
        }
        return tests;
    }
}
