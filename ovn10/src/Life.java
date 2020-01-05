import java.util.Random;

public class Life {
	private LifeBoard board;
	private LifeBoard temporaryBoard;
	

	public Life(LifeBoard board) {
		this.board = board;
		temporaryBoard = new LifeBoard(board.getRows(), board.getCols());
	}

	public void newGeneration() {
		
		/* temporär spelplan som lagrar den nya spelplanen */
		boolean [][] tempMatrix = new boolean[board.getRows()][board.getCols()];

		/* vanlig matrisloop */
		for (int rows = 0; rows < board.getRows(); rows++) {
			for(int cols = 0; cols < board.getCols(); cols++)
				
				
			/* om den är vid liv */
			if(board.get(rows, cols)) {
				
				if(amountOfNeighbours(rows, cols) >=4 || amountOfNeighbours(rows, cols) <= 1) {
					temporaryBoard.put(rows, cols, false);
					System.out.println("död");
					
				} else {
					
					temporaryBoard.put(rows, cols, true);
					
				}
				
				} else {
					
					if(amountOfNeighbours(rows, cols) == 3) {
						temporaryBoard.put(rows, cols, true);
						System.out.println("ny födelse");
					}
				}
				
			} 
		/*placerar in de nya födelserna */
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
				 * Hoppa över cellen i mitten som då räknas som 0 samtidigt som rowloop gör det
				 */
				if (rowLoop == row && colLoop == col) {
					continue;
				}
				/* om metoden ger true så finns en granne där, +1 på räknaren */
				if (board.get(rowLoop, colLoop) == true) {
					neighbours++;
				}

			}
		}
		return neighbours;
	}
}