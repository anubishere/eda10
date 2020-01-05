package inl1;
import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr7.*;
import se.lth.cs.p.inl1.TextView;
public class Inl1 {


	public static void main(String[] args) {
		Cryptographer kryptograf = new Cryptographer(new Key());
		
		TextWindow textWindow = new TextWindow("Chiffrering");
		
		TestCase testCiph = new TestCase();
		
		TextView klarTexten = new TextView("Klartext: ", 3, 222);
		TextView myCiphertext = new TextView("Min chiffrering: ", 3, 222);
		TextView correctCipher = new TextView("Korrekt chiffrering: ", 3, 222);
		
		textWindow.addView(klarTexten);
		textWindow.addView(myCiphertext);
		textWindow.addView(correctCipher);
		
		for(int i = 0; i < 5; i++) {
			klarTexten.displayText(testCiph.getClearText(i));
			myCiphertext.displayText(kryptograf.encrypt(testCiph.getClearText(i)));
			correctCipher.displayText(testCiph.getCryptoText(i));
			
			textWindow.waitForMouseClick();
			
		}

	}

}
