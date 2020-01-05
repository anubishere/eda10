import java.util.Random;

public class CardDeck {

	private Card[] cards = new Card[52];
	private int current;
	private static Random rand = new Random();

	public CardDeck() {
		cards = new Card[52]; // skapar nytt kort p� vektorns platser
		current = 0; // variabel som r�knar
		for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) { // g�r genom f�rgerna, de �r numrerade i Card-klassen 1-4
			for (int rank = 1; rank < 14; rank++) { // g�r genom v�rderna, 1-13 (0-12)
				cards[current] = new Card(suit, rank); // varje g�ng g�r vi ett steg i vektorn och tilldelar d�r ett kort
				current++;
			}
		}

	}

	public void shuffle() {
		for (int i = 51; i > 0; i--) { // g�r genom alla kort
			int randNbr = rand.nextInt(i); // v�ljer ett random tal mellan 1-52
			Card cardigan = cards[randNbr]; // stoppar in ett kort i den slumpm�ssiga platsen i vektorn
			cards[randNbr] = cards[i]; // slumpm�ssiga platsen och den plats i loopen man befinner sig i byter plats
			cards[i] = cardigan; // stoppar dit kortet c p� den platsen
			System.out.println(randNbr);
			
			
		}
		current = 52;
	}

	public boolean moreCards() {
		return (current > 0);
		
	}

	public Card getCard() {
		current--;
		return cards[current];
		
	}
	
}