package es.unizar.eina.vv6f.collatz;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class IniciadorSecuenciaMasLargaTest {
    @ParameterizedTest(name = "iniciadorSecuenciaMasLarga({0}) devuelve {1}")
    @CsvSource({
             "2, 1",
             "3, 2",
             "4, 3",
             "5, 3",
             "6, 3",
             "7, 6",
             "8, 7",
             "9, 7",
            "10, 9",
            "11, 9",
    })
    public void iniciadorSecuenciaMasLargaCsvSourceTest(int limite, int iniciadorEsperado) {
        assertEquals(iniciadorEsperado, Main.iniciadorSecuenciaMasLarga(limite));
    }


    @ParameterizedTest(name = "iniciadorSecuenciaMasLarga({0}) devuelve {1}")
    @CsvFileSource(resources = "/iniciador.csv", numLinesToSkip = 1)
    public void iniciadorSecuenciaMasLargaCsvFileSourceTest(int limite, int iniciadorEsperado) {
        assertEquals(iniciadorEsperado, Main.iniciadorSecuenciaMasLarga(limite));
    }


    /**
     * Vector con los resultados esperados para cada valor límite.
     */
    private static final int[] INICIADORES_MAS_LARGOS_ESPERADOS = {
            /* Límite: 2 --> iniciador más largo: */   1,
            /* Límite: 3 --> iniciador más largo: */   2,
            /* Límite: 4 --> iniciador más largo: */   3,
            /* Límite: 5 --> iniciador más largo: */   3,
            /* Límite: 6 --> iniciador más largo: */   3,
            /* Límite: 7 --> iniciador más largo: */   6,
            /* Límite: 8 --> iniciador más largo: */   7,
            /* Límite: 9 --> iniciador más largo: */   7,
            /* Límite: 10 --> iniciador más largo: */  9,
            /* Límite: 11 --> iniciador más largo: */  9,
    };


    @TestFactory
    Collection<DynamicTest> iniciadorSecuenciaMasLargaDynamicTest() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i = 0; i < INICIADORES_MAS_LARGOS_ESPERADOS.length; i++) {
            final int indice = i;
            final int limite = i + 2;
            String nombreTest = String.format("iniciadorSecuenciaMasLarga(%d) devuelve %d", limite, INICIADORES_MAS_LARGOS_ESPERADOS[indice]);
            tests.add(dynamicTest(nombreTest,
                    () -> assertEquals(INICIADORES_MAS_LARGOS_ESPERADOS[indice],
                            Main.iniciadorSecuenciaMasLarga(limite))
            ));
        }
        return tests;
    }
}
