package hw4;

import java.util.Random;

public class NoelleAI implements CFPlayer{

	private int rowHeight;
	private int column;
	private boolean winningMove;
	private boolean columnFull;
	
	public int nextMove(CFGame g) {
		
		
	for (int col = 0; col<7; col++) {

		//get the first available rowHeight for each column
		for(int ro = 5; ro > -1; ro--) {
			if (g.getState()[ro][col] == 0) { //if the spot is not taken
				rowHeight = ro;
				columnFull = false;
				break; //break at the first instance of finding an available spot
			}
			else {
				columnFull = true; 
			}
		}
		
		if(columnFull==false) {
		
			//check to see if there are winning moves for black	
			g.setState(rowHeight, col, -1);
			
			if (g.winner()== -1) { //if winning piece is found, stop iterating through the columns
				winningMove = true;
				g.setState(rowHeight, col, 0); //take piece out of the game
				return col;
			}
			
			else {
				winningMove = false;
			}
			
			//check to see if there are winning moves for red
			g.setState(rowHeight, col, 1);
			
			if (g.winner()== 1) { //if winning piece is found, stop iterating through the columns
				winningMove = true;
				g.setState(rowHeight, col, 0); //take piece out of the game
				return col;
			}
			
			else {
				
				//no winning moves found
				winningMove = false;
				g.setState(rowHeight, col, 0); //take piece out of the game
				
			}
			
		}

	}
	
	//if no winning moves found, pick a random column
	if(winningMove == false) {
		
		Random rand = new Random();
		column = rand.nextInt(7); //picking a column from 0-6
		
	}
	
		return column;
		
	}
	
	public String getName() {
		return "Noelle's AI";
	}
	
}