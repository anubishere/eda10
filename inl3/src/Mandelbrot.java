
public class Mandelbrot {

	public static void main(String[] args) {
			MandelbrotGUI gui = new MandelbrotGUI(500);
			Generator g = new Generator();
			Complex z = new Complex(1, 2);
			Complex c = new Complex (0, 0);
			
			//mandelbrot h�r nedan
			z.mul(z);
			z.add(c);
		
		while(true) {
			switch(gui.getCommand()) {
			
			case MandelbrotGUI.RENDER:
			g.render(gui);
			break;
			
			case MandelbrotGUI.RESET:
				
				gui.resetPlane();
				gui.clearPlane();
				System.out.println("Du �terst�llde nu");
				break;
				
			case MandelbrotGUI.QUIT:
				System.exit(0);
				break;

				
			case MandelbrotGUI.ZOOM:
				
			}
		}

	}

}
