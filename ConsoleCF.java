package hw4;

import java.util.Random;
import java.util.Scanner;

//ConsoleCF maintains the game
//ConsoleCF makes the move on behalf of the AI
//ConsoleCF is the game itself

public class ConsoleCF extends CFGame {
	
	int rowHeight;
	int redMove;
	int blackMove;
	CFPlayer redPlayer;
	CFPlayer blackPlayer;
	HumanPlayer player;
	CFGame game;

	public ConsoleCF ( CFPlayer ai ) {
		//sets up a human vs. AI game, where the red player (the player who goes first) is randomly decided		
		//initialize possible ai types
		if (ai instanceof RandomAI) {
			ai = new RandomAI();
		}
		else if (ai instanceof NoelleAI) {
			ai = new NoelleAI();
		}
		
		CFPlayer player = new HumanPlayer();
		
		//randomly pick a number between 1 and 2
		Random rand;
		long seed = System.currentTimeMillis();
		rand = new Random(seed);
		int firstTurn = rand.nextInt(2)+1;
		
		//assign who redPlayer and who is blackPlayer
		if(firstTurn == 1) {
			//set ai as red player
			redPlayer = ai;
			
			//set player as black player
			blackPlayer = player;
		}
		
		else if(firstTurn == 2) {
			//set player as red player
			redPlayer = player;
			
			//set ai as black player
			blackPlayer = ai;
		}
	
	}
	
	public ConsoleCF ( CFPlayer ai1 , CFPlayer ai2 ) {
		//sets up a AI vs. AI game, where the red player (the player who goes first) is randomly decided.		
		//initialize possible ai types for ai1
		if (ai1 instanceof RandomAI) {
			ai1 = new RandomAI();
		}
		else if (ai1 instanceof NoelleAI) {
			ai1 = new NoelleAI();
		}
		
		//initialize possible ai types for ai2
		else if (ai2 instanceof RandomAI) {
			ai2 = new RandomAI();
		}
		else if (ai2 instanceof NoelleAI) {
			ai2 = new NoelleAI();
		}
		
		//randomly pick a number between 1 and 2
		Random rand;
		long seed = System.currentTimeMillis();
		rand = new Random(seed);
		int firstTurn = rand.nextInt(2)+1;
		
		//assign who redPlayer and who is blackPlayer
		if(firstTurn == 1) {
			
			//ai1 is the red player
			
			redPlayer = ai1;
			
			//ai2 is the black player
			blackPlayer = ai2;
		}
		
		else if(firstTurn == 2) {
			
			//ai2 is the red player
			redPlayer = ai2;
			
			//ai1 is the black player
			blackPlayer = ai1;
		}
			
	}
	
	public void playOut () {
		
		//CFGame game = new CFGame();
		this.game = new CFGame();
		
		//comment out for Monte Carlo
		System.out.println("Let's play Connect Four!");
		
		//display game board
		
		//comment out for Monte Carlo
		game.numToColor();
		
		//comment out for Monte Carlo
		System.out.println("Red will go first");
		System.out.println("");
		
		//plays until game is over
		while(!game.isGameOver()) {
			
				//red player plays
				int move = redPlayer.nextMove(game);
				
				//comment out for Monte Carlo
				System.out.println("The red player is " + redPlayer.getName());
				
				while (game.play(move)==false) {
					//comment out for Monte Carlo
					System.out.println("The column: " + move + " is invalid. Pick another column");
					game.numToColor();
					
					move = redPlayer.nextMove(game);

				}
				
				for(int ro = 5; ro > -1; ro--) {
					if (game.getState()[ro][move] == 0) { //if the spot is not taken
						rowHeight = ro;
						break;
					}
					else
						continue;
				}
				
				//comment out for Monte Carlo
				System.out.println("Red player chose column: " + move);
				
				game.setState(rowHeight,move,1);
				
				//comment out for Monte Carlo
				//game.getBoard(); //prints board numerically
				game.numToColor(); //prints board by color
				System.out.println("");
				
				//black player plays
				
				//comment out for Monte Carlo
				System.out.println("The black player is " + blackPlayer.getName());
				
				int move2 = blackPlayer.nextMove(game);
				while (game.play(move2)==false) {
					//comment out for Monte Carlo
					System.out.println("The column: " + move2 + " is invalid. Pick another column");
					game.numToColor();
					
					move2 = blackPlayer.nextMove(game);

				}
				
				for(int ro = 5; ro > -1; ro--) {
					if (game.getState()[ro][move2] == 0) { //if the spot is not taken
						rowHeight = ro;
						break;
					}
					else
						continue;
				}
				
				//comment out for Monte Carlo
				System.out.println("Black player chose column: " + move2);
				
				game.setState(rowHeight,move2,-1);
				
				//comment out for Monte Carlo
				//game.getBoard(); //prints board numerically
				game.numToColor(); //prints board by color
				System.out.println(""); 

			
		}
		
		//comment out for Monte Carlo
		System.out.println("Game over. The winner is: " + getWinner());
			
	}
	
	public String getWinner() {
		//return either "draw", "Human Player", or the AI’s name given by CFPlayer’s getName method
		
		String theWinner = "draw";
		
		if (game.winner()==1) {
			theWinner = redPlayer.getName();
		}
		else if (game.winner()==-1) {
			theWinner = blackPlayer.getName();
		}
		else if (game.winner()==0)
			theWinner = "draw";
		
		return theWinner;
		
	}
	
	private class HumanPlayer implements CFPlayer {

		
		public int nextMove(CFGame g) {
			
			int move;
			int humanMove;
				
				System.out.println("Pick a column");
				
				Scanner reader = new Scanner (System.in);
				move = reader.nextInt(); //get HumanPlayer to input a move between 1-7
				humanMove = move-1;
			
			return humanMove;
		}
		
		public String getName() {
			return "Human Player";
		}
	}
	
 	
}