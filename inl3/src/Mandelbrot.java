

public class Mandelbrot {

	public static void main(String[] args) {
			MandelbrotGUI gui = new MandelbrotGUI();
			Generator g = new Generator();
			

			
			boolean pictureIsRendered = false;
	

		while(true) {
			switch(gui.getCommand()) {
			
			case MandelbrotGUI.RENDER:
				pictureIsRendered = true;
				g.render(gui);
				
			
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
