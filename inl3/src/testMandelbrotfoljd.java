
public class testMandelbrotfoljd {

	public static void main(String[] args) {
		Complex z = new Complex(0.0 , 0.0);
		Complex c = new Complex (0.4 , 0.4);
		int iterations = 0;
		
		
		/* S�l�nge iterationerna < 200 och kompleca talets absbelopp ocks�, ber�kna mandelbrotf�ljden. Returnera true om iterations = 200 */
		while(iterations < 200 && z.getAbs2() <= 200) {
			z.mul(z);
			z.add(c);
			iterations++;
			System.out.println(z);
		}
	}

}
