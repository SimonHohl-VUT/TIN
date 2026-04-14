package TIN.cv10.example;

import java.io.IOException;
import TIN.cv10.src.Chromozome;
import TIN.cv10.src.ShowChromozome;


public class Priklad1 {
	public static void main(String[] args) throws IOException {
		// Vytvor chromozom
		Chromozome ch1 = new Chromozome();

		// znahodni jeho obsah
		ch1.mutateAll();

		// zobraz
		ShowChromozome.show(ch1, "Ch 1");
	}
}
