

public class Mandelbrot {

	public static void main(String[] args) {
			MandelbrotGUI gui = new MandelbrotGUI();
			Generator g = new Generator();
			

			
			boolean pictureIsRendered = false;
	

		while(true) {
			switch(gui.getCommand()) {
			
			case MandelbrotGUI.RENDER:
				g.render(gui);
				pictureIsRendered = true;
				if(gui.getMode() == gui.MODE_BW) {
					System.out.println("Renderar svart & vitt");
				} else {
					System.out.println("Renderar i f�rg");
				}
			
			break;
			
			case MandelbrotGUI.RESET:
				pictureIsRendered = false;
				gui.resetPlane();
				gui.clearPlane();
				break;
				
			case MandelbrotGUI.QUIT:
				System.exit(0);
				break;

				
			case MandelbrotGUI.ZOOM:
				if(pictureIsRendered) g.render(gui);
				break;
				
				
				
			}
			
			System.out.println(pictureIsRendered);
			
		}

	}

}
