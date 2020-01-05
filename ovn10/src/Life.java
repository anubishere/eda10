import java.util.Random;

public class Life {
	private LifeBoard board;
	private LifeBoard temporaryBoard;
	

	public Life(LifeBoard board) {
		this.board = board;
		temporaryBoard = new LifeBoard(board.getRows(), board.getCols());
	}

	public void newGeneration() {
		
		/* tempor�r spelplan som lagrar den nya spelplanen */
		boolean [][] tempMatrix = new boolean[board.getRows()][board.getCols()];

		/* vanlig matrisloop */
		for (int rows = 0; rows < board.getRows(); rows++) {
			for(int cols = 0; cols < board.getCols(); cols++)
				
				
			/* om den �r vid liv */
			if(board.get(rows, cols)) {
				
				if(amountOfNeighbours(rows, cols) >=4 || amountOfNeighbours(rows, cols) <= 1) {
					temporaryBoard.put(rows, cols, false);
					System.out.println("d�d");
					
				} else {
					
					temporaryBoard.put(rows, cols, true);
					
				}
				
				} else {
					
					if(amountOfNeighbours(rows, cols) == 3) {
						temporaryBoard.put(rows, cols, true);
						System.out.println("ny f�delse");
					}
				}
				
			} 
		/*placerar in de nya f�delserna */
		for (int i = 0; i<board.getRows(); i++) {
			for(int k = 0; k<board.getCols(); k++)
				board.put(i, k, temporaryBoard.get(i, k));
		}
			
		} 

	public void flip(int row, int col) {
		if (board.get(row, col) == true) {
			board.put(row, col, false);
		} else
			
			board.put(row, col, true);
		

	}

	public int amountOfNeighbours(int row, int col) {
		int neighbours = 0;

		/* denna del loopar genom 3 * 3 matris med den aktuella cellen i mitten */
		for (int rowLoop = row - 1; rowLoop <= row + 1; rowLoop++) {
			for (int colLoop = col - 1; colLoop <= col + 1; colLoop++) {

				/*
				 * Hoppa �ver cellen i mitten som d� r�knas som 0 samtidigt som rowloop g�r det
				 */
				if (rowLoop == row && colLoop == col) {
					continue;
				}
				/* om metoden ger true s� finns en granne d�r, +1 p� r�knaren */
				if (board.get(rowLoop, colLoop) == true) {
					neighbours++;
				}

			}
		}
		return neighbours;
	}
}