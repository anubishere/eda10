package inl1;

import se.lth.cs.p.inl1.nbr7.Key;

public class Cryptographer {
	private Key kkey;

	
	public Cryptographer(Key key) {
		this.kkey = key;
	}
	public String encrypt(String text) {
		StringBuilder strb = new StringBuilder("");
		char letterPlace;
		int index;
		char keyLetter;
		int keyLetterNbr;
		int cryptoNbr;
		char letter;
		int step = 0;
		//String k;
		for(int charPos = 0; charPos < text.length(); charPos++) { // loop som k�rs lika m�nga g�nger som det finns karakt�rer
			letterPlace = text.charAt(charPos); // variabel som f�r karakt�rens position, start p� 0, dvs R som �r 82
			index = letterPlace - 'A'; /**  vi s�tter sedan att den bokstav i ordningsf�ljden ist�llet har 
			samma plats som i alfabetet, vid f�rsta fallet sker exempelvis 82 - 65, dvs 17, A blir s�ledes 0 */
			//System.out.println(index); // skriver ut numret f�r den bokstav som k�rs i loopen
			
			if(letterPlace != ' ') { // om n�sta steg inte �r ett mellanrum
			keyLetter = kkey.getLetter(charPos); //tar reda p�  bokstaven i nyckeln
			keyLetterNbr = keyLetter - 'A'; // s�tter A som 0
			cryptoNbr = index + keyLetterNbr; // v�rdet f�r klartext(char) adderas med v�rdet f�r nyckelns char-v�rde. detta skapar den krypterade int
			strb.append(kkey.getLetter(cryptoNbr));
			
			System.out.println(keyLetter);
			} else {
				strb.append(' ');
			}
			
		}
		
		return strb.toString();
	}
}