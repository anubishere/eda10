
public class test {

	public static void main(String[] args) {
		MandelbrotGUI gui = new MandelbrotGUI();
		
		while(true) {
			switch(gui.getCommand()) {
			case MandelbrotGUI.RENDER: 
			break;
			case MandelbrotGUI.RESET:
				gui.resetPlane();
				gui.clearPlane();
				System.out.println("Du återställde nu");
				break;
			case MandelbrotGUI.QUIT:
				System.exit(0);

				
			case MandelbrotGUI.ZOOM:
				
			}
		}

	
	}

}
