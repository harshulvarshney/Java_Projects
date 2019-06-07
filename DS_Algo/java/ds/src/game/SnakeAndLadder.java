package game;

import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
	private final int lastPosition = 30;
	int [] pos = new int[lastPosition];
	
	public SnakeAndLadder() {
		pos[2] = 14;
		pos[5] = 17;
		pos[8] = 21;
		pos[10] = 5;
		pos[20] = 7;
		pos[28] = 27;
	}
	
	public void play() {
		boolean finished = false;
		
		int position = 0;
		while(!finished) {
			System.out.println("Roll die by hiting enter...");
			Scanner scan = new Scanner(System.in);
			scan.nextLine();
			int dieOp = rollTheDie();
			System.out.println(dieOp + " came on die");
			if(lastPosition-position>6 || ((lastPosition-position<6) && (dieOp<(lastPosition-position)))) {
				position = pos[position+dieOp] == 0 ? (position+dieOp) : pos[position+dieOp];
			}
			System.out.println("New position: " + position);
			if(lastPosition - position != 0 && lastPosition-position<6) {
				continue;
			}
			if(lastPosition-position==0) {
				finished = true;
			}
		}
		
		System.out.println("Reached, final position: " + position);
	}
	
	private int rollTheDie() {
		int value = 0;
		Random random = new Random();
		boolean rollAgain = true;
		while(rollAgain) {
			value = random.nextInt(6);
			if(value == 0)
				continue;
			else if(value == 1 || value == 6) {
				value += 1;
				continue;
			}
			rollAgain = false;
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		SnakeAndLadder obj = new SnakeAndLadder();
		obj.play();
	}

}
