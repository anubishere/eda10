
public class Mandelbrot {

	public static void main(String[] args) {
			MandelbrotGUI gui = new MandelbrotGUI(500);
			Generator g = new Generator();
			Complex z = new Complex(0, 0);
			Complex c = new Complex (-0.4, 0.4);
			
			//mandelbrot h�r nedan
			for(int i = 0; i < 100; i++) {
			z.mul(z);
			z.add(c);
			if (z.getAbs2() > 2) break;
			System.out.println(z.getAbs2());
			}
			
		while(true) {
			switch(gui.getCommand()) {
			
			case MandelbrotGUI.RENDER:
			g.render(gui);
			break;
			
			case MandelbrotGUI.RESET:
				
				gui.resetPlane();
				gui.clearPlane();
				System.out.println("Mandelbrot �terst�lldes");
				break;
				
			case MandelbrotGUI.QUIT:
				System.exit(0);
				System.out.println("Du avslutade programmet");
				break;

				
			case MandelbrotGUI.ZOOM:
				
			}
		}

	}

}
