package es.unizar.eina.vv6f.collatz;

/*
 * Clase para representar una secuencia de Collatz a partir del entero positivo
 * que la inicia.
 */
public class SecuenciaCollatz {

	/**
	 * Devuelve el término que sigue a «n» en una secuencia de Collatz.
	 *
	 * @param n
	 *            el valor positivo del que se quiere determinar su sucesor.
	 * @return el término que sigue a «n» en una secuencia de Collatz.
	 */
	static long siguienteCollatz(long n) {
		if (n % 2 == 0) {
			return n / 2;
		}
		else {
			return 3 * n + 1;
		}
	}

	private final long inicio;

	/*
	 * @param inicio
	 *            el valor inicio, positivo, del que se quiere determinar
	 *            la longitud de su secuencia de Collatz.
	 */
	public SecuenciaCollatz(long inicio) {
		if (inicio <= 0) {
			throw new IllegalArgumentException();
		}
		else {
			this.inicio = inicio;
		}
	}

	/**
	 * Calcula y devuelve la longitud de la secuencia de Collatz asociada a este
	 * objeto.
	 *
	 * @return la longitud de la secuencia de Collatz asociada a este objeto.
	 */
	public int longitud() {
		long n = inicio;
		int count = 1;
		while (n != 1) {
			n = siguienteCollatz(n);
			count++;
		}
		return count;
	}

}


