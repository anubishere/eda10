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
		for(int charPos = 0; charPos < text.length(); charPos++) { // loop som körs lika många gånger som det finns karaktärer
			letterPlace = text.charAt(charPos); // variabel som får karaktärens position, start på 0, dvs R som är 82
			index = letterPlace - 'A'; /**  vi sätter sedan att den bokstav i ordningsföljden istället har 
			samma plats som i alfabetet, vid första fallet sker exempelvis 82 - 65, dvs 17, A blir således 0 */
			//System.out.println(index); // skriver ut numret för den bokstav som körs i loopen
			
			if(letterPlace != ' ') { // om nästa steg inte är ett mellanrum
			keyLetter = kkey.getLetter(charPos); //tar reda på  bokstaven i nyckeln
			keyLetterNbr = keyLetter - 'A'; // sätter A som 0
			cryptoNbr = index + keyLetterNbr; // värdet för klartext(char) adderas med värdet för nyckelns char-värde. detta skapar den krypterade int
			strb.append(kkey.getLetter(cryptoNbr));
			
			System.out.println(keyLetter);
			} else {
				strb.append(' ');
			}
			
		}
		
		return strb.toString();
	}
}