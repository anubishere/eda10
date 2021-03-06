

import java.util.Arrays;

public class SudokuGrid {
    private int[][] grid;
    
    public SudokuGrid () {
    	grid = new int[9][9];
    }
              
    public void put(int row, int col, int value) {
    	grid[row][col] = value;
    }
        
    public static void main(String[] args) {
    	SudokuGrid sg = new SudokuGrid();
    	int [] nbrs = {2, 5, 7, 1, 9, 8, 3, 5, 6};
    	for (int k = 1; k <= 9; k++) {
    	   sg.put(5, k, nbrs[k - 1]);
    	}
    	System.out.println(Arrays.toString(sg.grid[5]));
    	boolean x = sg.checkRow(5);
    	System.out.println(x);
    	
	}
    
    public boolean checkRow(int row) {
    	
    	boolean[] foundNumbers = new boolean[9];
    	for (int col = 0; col < 9; col++) {
    		int number = grid[row - 1][col];
    		
    		if (foundNumbers[number] && number != 0 ) {System.out.println(foundNumbers[number]);
    			return false;
    			
    		}
    		foundNumbers[number] = true;
    	}
    	return true;
    }
    
}