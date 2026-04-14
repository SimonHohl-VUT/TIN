package TIN.cv10.example;

import java.io.IOException;
import TIN.cv10.src.Chromozome;
import TIN.cv10.src.ShowChromozome;

public class Priklad3 {
	public static void main(String[] args) throws IOException {
		// Priklad 1
		Chromozome ch1 = new Chromozome();
		ch1.mutateAll();

		// vytvoreni kopie
		Chromozome ch2 = ch1.cloneChromozome();
		// Chromozome ch2 = ch1; // nevytvori kopii
		
		ShowChromozome.show(ch1, "Chromozom ch1");
		ShowChromozome.show(ch2, "Chromozom ch2");
	}
}
