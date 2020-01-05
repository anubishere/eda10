public class LifeController {

	public static void main(String[] args) {

		LifeBoard board = new LifeBoard(9, 9);
		LifeView window = new LifeView(board);

		window.drawBoard();

		// kommer best�mma vad som h�nder vid musklick
		

		Life life = new Life(board);

		while (true) {
			
			int mouseClick = window.getCommand();
			
			//individer d�r/b�rjar leva vid klick
			
			if (mouseClick == 1) {
				life.flip(window.getRow(), window.getCol());
				window.update();
			}
			//n�sta generation vid klick
			else if (mouseClick == 2) {
				life.newGeneration();
				board.increaseGeneration();
				window.update();
			} // st�nger rutan
			else if (mouseClick == 3) {
				System.exit(0);
			}
			
		}
		

	}

}