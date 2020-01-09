import java.awt.Color;

import org.w3c.dom.css.RGBColor;

public class Generator {
	Color[] neuances = new Color[255];
	Color currentCol;
	
	public Generator() {
		
		



	}
	public void render(MandelbrotGUI gui) {
		int height = gui.getHeight();
		int width = gui.getWidth();
		
		//denna variabel utnyttjas för att få fram rätt förhållande i matriserna beroende på upplösning
		int resolution = resCalc(gui.getResolution());
		
		
		
		
		/* tex medium, dvs rendering av var 5e pixel i iterationen. Eftersom första index (1) ska renderas
		   så behöver loopen börja 4 steg bak. För medium: - 3 och börja rendera på index 1

		   MEDIUM
		   [-3][-2][-1][0][X][][][][][X][][]
		
		 */
		int indexStartResolution = -((resolution / 2) +1);




		gui.disableInput();
		
		boolean colored = false;
		switch(gui.getMode()) {
		case MandelbrotGUI.MODE_BW:
			colored = false;
			break;
		case MandelbrotGUI.MODE_COLOR:
			colored = true;
			break;
		}

		Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(), gui.getMinimumImag(),
				gui.getMaximumImag(), width, height);

		Color[][] picture = new Color[height / resolution][width / resolution];
		// itererar hela längden, inklusive sista
		for (int i = 1; i <= picture.length; i++) {
			for (int j = 1; j <= picture[0].length; j++) {
				Complex z = complex[indexStartResolution + i * resolution][indexStartResolution + j * resolution];
				if(mandelbrot(z)) {
					picture[i - 1][j - 1] = Color.black;
				} else {
					picture[i - 1][j - 1] = Color.white;
				}
			}
		}

		gui.putData(picture, resolution, resolution);
		gui.enableInput();

	}




	private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm, int width, int height){

		Complex[][] matrix = new Complex[height][width];


		// re-axels längd(abs) / fönstrets bredd ger
		double reStepSize = Math.abs(maxRe - minRe) / width;

		// samma här fast im
		double imStepSize = Math.abs(maxIm - minIm) / height;

		//fyller matrisen med alla koordinater av komplexa tal med hänseende på stepsize och antal rader/kolumner
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				matrix[i][j] = new Complex(minRe + (reStepSize * j), maxIm - (i * imStepSize));
			}

		}
		return matrix;

	}
	/* metod för att räkna ut mandelbrot för komplext tal */
	private boolean mandelbrot(Complex c) {
		Complex z = new Complex(0.0 , 0.0);
		int iterations = 0;


		/* Sålänge iterationerna < 200 och kompleca talets absbelopp också, beräkna mandelbrotföljden. Returnera true om iterations = 200 */
		while(iterations < 200 && z.getAbs2() <= 200) {
			z.mul(z);
			z.add(c);
			iterations++;
		}
		return iterations == 200;

	}

	private int resCalc(int res) {
		switch(res) {

		/* i sjunkande ordning; high - very low. Default är very high = 1 */
		case 1024:
			return 3;

		case 512:
			return 5;

		case 256:
			return 7;

		case 128:
			return 9;

		default:
			return 1;
		}
	}


}
