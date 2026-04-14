package TIN.cv10.example;

import java.io.IOException;
import TIN.cv10.src.Chromozome;
import TIN.cv10.src.Fitness;

/**
 * Tento priklad zobrazuje miru podobnosti vuci predloze.
 */
public class Priklad2 {
	public static void main(String[] args) throws IOException {
		// Priklad 1
		Chromozome ch1 = new Chromozome();
		ch1.mutateAll();

		// Porovnavaci trida vuci obrazku orloj.jpg
		Fitness eval = new Fitness("orloj.jpg");

		// poorvnej
		int error = eval.getFitness(ch1);

		System.out.println("Mira chyby vuci predloze: " + error);
	}
}
