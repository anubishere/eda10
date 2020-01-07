/*import java.awt.Color;

public class TestGui {

	public static void main(String[] args) {
		this.colorScale = new Color[256];
		int r = 0;
		int g = 0;
		int b = 255;
		int i = 0;
		while(r < 255) {
			this.colorScale[i] = new Color(r, g, b);
			r+=3;
			i++;
		}
		while (b > 0) {
			this.colorScale[i] = new Color(r, g, b);
			b -= 3;
			i++;
		}
		while(g < 81) {
			this.colorScale[i] = new Color(r, g, b);
			g += 1;
			i++;
		}

	}
	public void render(MandelbrotGUI gui) {
		
		gui.disableInput();
		
		int res = 1;
		
		switch(gui.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			res = 1;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH:
			res = 3;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM:
			res = 5;
			break;
		case MandelbrotGUI.RESOLUTION_LOW:
			res = 7;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_LOW:
			res = 9;
			break;
		}
		boolean blackAndWhite = true;
		switch(gui.getMode()) {
		case MandelbrotGUI.MODE_BW:
			blackAndWhite = true;
			break;
		case MandelbrotGUI.MODE_COLOR:
			blackAndWhite = false;
			break;
		}


		// matrisen med komplexa tal
		Complex complex[][] = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(),
				gui.getWidth(), gui.getHeight());
		//matrisen som renderar bilden
		Color[][] picture = new Color[getMaxArrayIndex(gui.getHeight(), res)][gui.getResolution()];


		// går genom matrisen
		for(int i = 0; i<gui.getHeight(); i++) {
			for(int j = 0; j < gui.getWidth(); j++) {
				Complex complexNbr = complex[i][j];


				for(int k = 0; k < picture.length; k++) {
					for(int m = 0; m < picture.length; m++) {

						if (complexNbr.getAbs2() > 1) {
							picture[k][m] = Color.WHITE;
							if(complexNbr.getRe() > 0 && complexNbr.getIm() > 0) {
								picture[k][m] = Color.BLUE;
								if(complexNbr.getRe() > 0 && complexNbr.getIm() < 0) {
									picture[k][m] = Color.GREEN;
									if(complexNbr.getRe() < 0 && complexNbr.getIm() > 0) {
										picture[k][m] = Color.ORANGE;
										if(complexNbr.getRe() < 0 && complexNbr.getIm() < 0) {
											picture[k][m] = Color.RED;
										}
									}
								}
								
							}

						}
						
						
					}	
				}
			}
			
		}
		gui.putData(picture, res, res);
		gui.enableInput();
	}
	
	private Complex[][] mesh(double minRe, double maxRe,
			double minIm, double maxIm,
			int width, int heigth){
		
		Complex[][] complex = new Complex[heigth][width];
		
		for(int i = 0; i < heigth; i++) {
			for(int j = 0; j < width; j++) {
				complex[0][0] = new Complex(minRe, maxIm);
				complex[heigth -1][width - 1] = new Complex(maxRe, minIm);


			}
		}
		return complex;
	}

}*/




