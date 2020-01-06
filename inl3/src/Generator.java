import java.awt.Color;

public class Generator {
	private Color[] colorScale;
	Boolean Colors = true;
	Boolean bw = false;
	
	
	public Generator() {
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
		boolean colorMode = gui.getMode() == MandelbrotGUI.MODE_COLOR;
		gui.disableInput();
		
		
		// matrisen med komplexa tal
		Complex complex[][] = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
									gui.getMinimumImag(), gui.getMaximumImag(),
									gui.getWidth(), gui.getHeight());
		//matrisen som renderar bilden
		Color[][] picture = new Color[gui.getHeight()][gui.getWidth()];
		
		
		// går genom matrisen
		for(int i = 0; i<gui.getHeight(); i++) {
			for(int j = 0; j < gui.getWidth(); j++) {
				Complex complexNbr = complex[i][j];
				
				/* om absolutbeloppet av det komplexa numret
					gör färgen på picture[i][j] till vit, annars
					välj en färg för varje kvadrant.
				 */
				
				if(complexNbr.getAbs2() > 1) {
					picture[i][j] = Color.WHITE;
				} else if(complexNbr.getAbs2() < 1) {
					picture[i][j] = Color.BLUE;
				}
				gui.putData(picture, gui.getWidth(), gui.getHeight());
		
				gui.enableInput();		
					
				
			}
		}
		
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
}
