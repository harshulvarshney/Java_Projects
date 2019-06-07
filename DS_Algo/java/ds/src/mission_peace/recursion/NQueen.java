package mission_peace.recursion;

/**
 * Place N queens on a chess board of dimension N s.t. no queen attack other queen.
 * A queen can attack horizontally, vertically or diagonally.
 * 
 * @author harshul
 * 
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 *
 */
public class NQueen {
	
	public static void main(String[] args) {
		NQueen obj = new NQueen();
		Position[] result = obj.placeQueens(4);
		for(Position p : result) {
			System.out.println(p.row + " " + p.col);
		}
	}
	
	class Position {
		int row, col;
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public Position[] placeQueens(int n) {
		Position[] positions = new Position[n];
		if(solve(positions, n, 0)) {
			return positions;
		}
		return new Position[0];
	}
	
	private boolean solve(Position[] positions, int n, int row) {
		if(n == row)
			return true;
		
		for(int col = 0; col < n; col++) {
			boolean foundSafe = true;
			
			for(int queen = 0; queen < row; queen++) {
				  if(positions[queen].col == col || positions[queen].row - positions[queen].col == row-col
						  || positions[queen].row + positions[queen].col == row+col) {
					  foundSafe = false;
					  break;
				  }
			}
			if(foundSafe) {
				positions[row] = new Position(row, col);
				if(solve(positions, n, row+1)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
