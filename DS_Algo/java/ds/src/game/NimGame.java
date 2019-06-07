package game;

/**
 * ref: 
 * Rules:
 * 	Given a number of piles in which each pile contains some numbers of stones/coins. 
 * 	In each turn, a player can choose only one pile and remove any number of stones (at least one) from that pile. 
 * 	The player who cannot move is considered to lose the game (i.e., one who take the last stone is the winner).
 * 
 *  http://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/
 *  
 * @author harshul.varshney
 *
 */
public class NimGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private void play(int piles, int[] gems) {
		
	}
	
	private void calculate(int [] gems) {
		int i = gems[0];
		for(int j = 1; j < gems.length; j++) {
			i = i ^ gems[j];
		}
		if(i > 0) {
			System.out.println("Player 1 will win");
		}
		else {
			System.out.println("Player 2 will win");
		}
	}
	

}
