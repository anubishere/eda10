import java.util.Random;
public class LifeBoard {
	private int rows;
	private int cols;
	private int generation = 1;
	public boolean [][] matrix;
	
	/** Skapar en spelplan med rows rader och cols kolonner. Spelplanen är från
	    början tom, dvs alla rutorna är tomma och generationsnumret är 1. */	
	public LifeBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		matrix = new boolean[rows][cols];
		
			
		
		generation = 1;
	}

	/** Ger true om det finns en individ i rutan med index row, col, false annars. 
	    Om index row, col är utanför spelplanen returneras false */
	
	/* om instoppat värde är utanför spelplan ge false*/
	public boolean get(int row, int col) {
		if (row >= rows || col >= cols || col < 0 || row < 0) {
			return false;
		}
		if(matrix[row][col] == true) {
			return true;
		} else {
			return false;
		}
		
		
		
		
	}

	/** Lagrar värdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {
		matrix[row][col] = val;
	}

	/** Tar reda på antalet rader */
	public int getRows() {
		return rows;
	}

 	/** Tar reda på antalet kolonner */
	public int getCols() {
		return cols;
	}

	/** Tar reda på aktuellt generationsnummer */
	public int getGeneration() {
		return generation;
	}

	/** Ökar generationsnumret med ett */
	public void increaseGeneration() {
		generation++;
	}
	
}