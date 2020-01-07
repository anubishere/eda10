import java.awt.Color;

public class Generator {


	public Generator() {
		
		
		
		
		

	}
	public void render(MandelbrotGUI gui) {
		
		/* variablar för att förkorta den "riktiga" koden */
		double minRe = gui.getMinimumReal(), maxRe = gui.getMaximumReal();
		double minIm = gui.getMinimumImag(), maxIm = gui.getMaximumImag();
		int height = gui.getHeight(), width = gui.getWidth();
		int reso = gui.getResolution();
		boolean colormode = false;
		
		gui.disableInput();
		
		
		int pixels = 1;
		if      (reso == MandelbrotGUI.RESOLUTION_VERY_HIGH) pixels=1;
        else if (reso == MandelbrotGUI.RESOLUTION_HIGH)      pixels=3;
        else if (reso == MandelbrotGUI.RESOLUTION_MEDIUM)    pixels=5;
        else if (reso == MandelbrotGUI.RESOLUTION_LOW)       pixels=7;
        else if (reso == MandelbrotGUI.RESOLUTION_VERY_LOW)  pixels=9;
		
		//komplexa talplanet
		Complex complex[][] = mesh(gui.getMinimumReal(), gui.getMaximumReal(), gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(), gui.getHeight());
		
		
		
		for(int i = 0; i < 100; i++) {
		Complex z = new Complex (0,0);
		Complex c = new Complex (-0.4, 0.4);
		
		z.mul(z);
		z.add(c);
		double mandel = z.getAbs2();
		}
		
		
	
		boolean withColor;
		switch(gui.getMode()) {
		case MandelbrotGUI.MODE_BW:
			withColor = false;
			break;
			
		case MandelbrotGUI.MODE_COLOR:
			withColor = true;
			break;
		
		default:
			withColor = false;
		}
			//skapar färgmatrisen
		Color[][] picture = new Color[height][width];
		
		//iterera genom bildmatrisen
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				if(complex[row][col].getIm() > 0 && complex[row][col].getRe() > 0) {
					picture[row][col] = Color.BLUE;
					
				} else if(complex[row][col].getIm() > 0 && complex[row][col].getRe() < 0) {
					picture[row][col] = Color.ORANGE;
					
				} else if(complex[row][col].getIm() < 0 && complex[row][col].getRe() < 0) {
					picture[row][col] = Color.GREEN;
					
				} else if(complex[row][col].getIm() < 0 && complex[row][col].getRe() > 0) {
					picture [row][col] = Color.PINK;
				}
				
			}
			
			
			
			
		}
		gui.putData(picture, reso, reso);
		
		gui.enableInput();
	}
private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm, int width, int height){
	
	Complex[][] pixelArr = new Complex [height][width];
	pixelArr[0][0] = new Complex(minRe, maxIm);
	pixelArr[height - 1][width - 1] = new Complex(maxRe, minIm);
	
	for(int i = 0; i < height; i++) {
		for(int j = 0; j < width; j++) {
			//avstånd i procent till vänster hörn för pixeln
			double widthPercent = j / (double) width;
			double re = minRe + widthPercent * (maxRe - minRe);
			double heightPercent = j / (double) height;
			double im = maxIm - heightPercent *(maxIm - minIm);
			pixelArr[i][j] = new Complex(re, im);
			
			
		}
	}
	return pixelArr;
}
}
