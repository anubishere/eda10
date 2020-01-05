
public class Ostron {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
boolean[] found = new boolean[9];
    	
    	for (int i = 0; i < 9; i++) {
    		int numb = grid[row - 1][i];
    		
    		if (numb > 9 || numb < 0) {
    			return false;
    		}
    		
    		if (numb != 0) {
    			if (found[numb - 1] ) {
        			return false;
        		} else {
        			found[numb - 1] = true;
        		}	
    		}
    	}
    	return true;












	}
}
