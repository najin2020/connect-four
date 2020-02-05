package hw4;

import java.util.Random;

public class RandomAI implements CFPlayer{

	private int column;
	
	public int nextMove(CFGame g) {

		//long seed = System.currentTimeMillis();
		Random rand = new Random();

		//pick a random column
		column = rand.nextInt(7);  //picking a column from 0-6
		
		return column;

	}
	
	public String getName() {
		return "Random Player";
	}
	
}