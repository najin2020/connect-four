package hw4;

import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUICF extends CFGame {
	
	private GameBoard this_board; //represents the graphic for 6 x 7 board, but not the buttons
	JButton b1; JButton b2; JButton b3; JButton b4; JButton b5; JButton b6; JButton b7; 
	CFGame game;
	int rowHeight;
	int move;
	int move2;
	int blackMove;
	private JLabel[][] jarr;
	CFPlayer redPlayer;
	CFPlayer blackPlayer;
	HumanPlayer player;

	class pickMove implements java.awt.event.ActionListener {
		public int col;
		public int row;
		public GameBoard board=this_board;
		public int state;
		
		public pickMove(GameBoard board, int row, int col) {
			this.row = row;
			this.col = col;
			this.board = board;
			this.state = 0;
			
		}

		public void actionPerformed(java.awt.event.ActionEvent e) {			
			//working code
			
			if (!game.isGameOver()) {
				int move = col;
				
				for(int ro = 5; ro > -1; ro--) {
					if (game.getState()[ro][move] == 0) { //if the spot is not taken
						rowHeight = ro;
						break;
					}
					else
						continue;
				}
				
				board.paint(rowHeight,move,1); //paint board
				game.setState(rowHeight,move,1); //update state of game 
				
				int move2 = blackPlayer.nextMove(game);
				
				while (playGUI(move2)==false) {
					
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
				
				//new newMove2(this_board, rowHeight, blackPlayer.nextMove(game)); //update GUI
	        	jarr[rowHeight][move2].setOpaque(true); //update GUI
	        	jarr[rowHeight][move2].setBackground(Color.BLACK); //update GUI
	        	
				game.setState(rowHeight,move2,-1); //update state of game 
			
			}
			
			if (game.isGameOver()) 
				System.out.println("The winner is: " + getWinner());
					
			}
		
	}
	
	class pickMove2 implements java.awt.event.ActionListener {
		public int col;
		public int row;
		public GameBoard board=this_board;
		public int state;
		
		public pickMove2(GameBoard board, int row, int col) {
			this.row = row;
			this.col = col;
			this.board = board;
			this.state = 0;
			
		}

		public void actionPerformed(java.awt.event.ActionEvent e) {			
			//working code
			
			if (!game.isGameOver()) {
				int move2 = redPlayer.nextMove(game);
				
				while (playGUI(move2)==false) {
					
					move2 = redPlayer.nextMove(game);
	
				}
				
				for(int ro = 5; ro > -1; ro--) {
					if (game.getState()[ro][move2] == 0) { //if the spot is not taken
						rowHeight = ro;
						break;
					}
					else
						continue;
				}
				
				//new newMove2(this_board, rowHeight, blackPlayer.nextMove(game)); //update GUI
	        	jarr[rowHeight][move2].setOpaque(true); //update GUI
	        	jarr[rowHeight][move2].setBackground(Color.RED); //update GUI
	        	
				game.setState(rowHeight,move2,1); //update state of game 
				
				//new newMove2(this_board, rowHeight, redPlayer.nextMove(game)); //update GUI
	        	//jarr[rowHeight][move].setOpaque(true); //update GUI
	        	//jarr[rowHeight][move].setBackground(Color.RED); //update GUI
				
				int move = col;
				
				for(int ro = 5; ro > -1; ro--) {
					if (game.getState()[ro][move] == 0) { //if the spot is not taken
						rowHeight = ro;
						break;
					}
					else
						continue;
				}
				
				board.paint(rowHeight,move,0); //paint board
				game.setState(rowHeight,move,-1); //update state of game 
			
			}
			
			if (game.isGameOver()) 
				System.out.println("The winner is: " + getWinner());
					
			}
		
	}
	
	
	class playGame implements java.awt.event.ActionListener {
		
		public playGame(GameBoard board) {
			this_board = board;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e) {
			while(!game.isGameOver()) {
				
				//red player turn
				
				int move = redPlayer.nextMove(game);
				
				while (playGUI(move)==false) {
					
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
				
				//new newMove2(this_board, rowHeight, redPlayer.nextMove(game)); //update GUI
	        	jarr[rowHeight][move].setOpaque(true); //update GUI
	        	jarr[rowHeight][move].setBackground(Color.RED); //update GUI
				
				game.setState(rowHeight,move,1); //update state of game 
				if (game.isGameOver())
					break;
				
				//black player turn
				
				int move2 = blackPlayer.nextMove(game);
				
				while (playGUI(move2)==false) {
					
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
				
				//new newMove2(this_board, rowHeight, blackPlayer.nextMove(game)); //update GUI
	        	jarr[rowHeight][move2].setOpaque(true); //update GUI
	        	jarr[rowHeight][move2].setBackground(Color.BLACK); //update GUI
	        	
				game.setState(rowHeight,move2,-1); //update state of game 
				if (game.isGameOver())
					break;
				
			}
			
			System.out.println("The red player is: " + redPlayer.getName());
			System.out.println("Game over. The winner is: " + getWinner());

			
		}
		
	}
		
	public GUICF(CFPlayer ai) {
		//sets up a human vs. AI game, where the red player (the player who goes first) is randomly decided		
		//most of gameplay is here
		
		//initialize possible ai types
		if (ai instanceof RandomAI) {
			ai = new RandomAI();
		}
		else if (ai instanceof NoelleAI) {
			ai = new NoelleAI();
		}
		
		CFPlayer player = new HumanPlayer();
		
		//randomly pick a number between 1 and 2
		//redPlayer = player;
		//blackPlayer = ai;
		
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
			
			GameBoard this_board = new GameBoard();
			this.game = new CFGame();
			
			//insert the 7 buttons here
			JButton b1 = new javax.swing.JButton("\u2191");
			b1.addActionListener(new pickMove2(this_board, rowHeight, 0));
			this_board.add(b1);
			
			JButton b2 = new javax.swing.JButton("\u2191");
			b2.addActionListener(new pickMove2(this_board, rowHeight, 1));
			this_board.add(b2);
			
			JButton b3 = new javax.swing.JButton("\u2191");
			b3.addActionListener(new pickMove2(this_board, rowHeight, 2));
			this_board.add(b3);
			
			JButton b4 = new javax.swing.JButton("\u2191");
			b4.addActionListener(new pickMove2(this_board, rowHeight, 3));
			this_board.add(b4);
			
			JButton b5 = new javax.swing.JButton("\u2191");	
			b5.addActionListener(new pickMove2(this_board, rowHeight, 4));
			this_board.add(b5);
			
			JButton b6 = new javax.swing.JButton("\u2191");
			b6.addActionListener(new pickMove2(this_board, rowHeight, 5));
			this_board.add(b6);
			
			JButton b7 = new javax.swing.JButton("\u2191");
			b7.addActionListener(new pickMove2(this_board, rowHeight, 6));
			this_board.add(b7);
			
			JFrame f= new JFrame("Connect Four");
			
			f.add(this_board);
			f.setSize(300,300); 
			f.setVisible(true);
			f.setLayout(null);
			f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
			
		}
		
		else if(firstTurn == 2) {
			//set player as red player
			redPlayer = player;
			
			//set ai as black player
			blackPlayer = ai;
			
			GameBoard this_board = new GameBoard();
			this.game = new CFGame();
			
			//insert the 7 buttons here
			JButton b1 = new javax.swing.JButton("\u2191");
			b1.addActionListener(new pickMove(this_board, rowHeight, 0));
			this_board.add(b1);
			
			JButton b2 = new javax.swing.JButton("\u2191");
			b2.addActionListener(new pickMove(this_board, rowHeight, 1));
			this_board.add(b2);
			
			JButton b3 = new javax.swing.JButton("\u2191");
			b3.addActionListener(new pickMove(this_board, rowHeight, 2));
			this_board.add(b3);
			
			JButton b4 = new javax.swing.JButton("\u2191");
			b4.addActionListener(new pickMove(this_board, rowHeight, 3));
			this_board.add(b4);
			
			JButton b5 = new javax.swing.JButton("\u2191");	
			b5.addActionListener(new pickMove(this_board, rowHeight, 4));
			this_board.add(b5);
			
			JButton b6 = new javax.swing.JButton("\u2191");
			b6.addActionListener(new pickMove(this_board, rowHeight, 5));
			this_board.add(b6);
			
			JButton b7 = new javax.swing.JButton("\u2191");
			b7.addActionListener(new pickMove(this_board, rowHeight, 6));
			this_board.add(b7);
			
			JFrame f= new JFrame("Connect Four");
			
			f.add(this_board);
			f.setSize(300,300); 
			f.setVisible(true);
			f.setLayout(null);
			f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		}
		


	}
	
	public GUICF(CFPlayer ai1, CFPlayer ai2) {
		//sets up a AI vs. AI game, where the red player (the player who goes first) is randomly decided.	
		//most of gameplay is here
		
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
		


		GameBoard this_board = new GameBoard(); //make this its own frame
		this.game = new CFGame();
		
		// JFrame
		// Buttons
		// Action listener
		
		JButton b1 = new javax.swing.JButton("Play");
		b1.addActionListener(new playGame(this_board));
		this_board.add(b1);
		
		JFrame f= new JFrame("Connect Four");
		
		f.add(this_board);
		f.setSize(300,300); 
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		

		
	}

	
	private boolean playGUI(int c) {
		//plays column c
		//if column c can be played, play the column --> return true
			//update game logic inherited from CFGame
			//update displayed board represented in this_board
		//if column c cannot be played --> return false
		
		if(game.play(c)==true) {
			
			//check for first available row
			for(int ro = 5; ro > -1; ro--) {
				if (game.getState()[ro][c] == 0) { //if the spot is not taken
					rowHeight = ro;
					break;
				}
				else
					continue;
			}
			
			//new newMove2(this_board, rowHeight, c); //update GUI
			//game.setState(rowHeight,c,1); //update state of game 
			
			return true;
		}
		
		else 
			return false;
		
	}

	
	private class GameBoard extends javax . swing . JPanel {
		//represents game board
		//square pieces done with 6 x 7 = 42 JLabels and a GridLayout
			//may want to use setOpaque(...) with the JLabels
		//DOES NOT INCLUDE THE BUTTONS
		
		private GameBoard () {
			//initialize empty board
			
			this.setLayout(new java.awt.GridLayout(0,7));
			
			jarr = new JLabel[6][7];
			
	    	int odd = 0;
	    	

	    	for (int i=0;i<6;i++) {
	    		for (int j=0;j<7;j++) {
			    	JLabel l1 = new JLabel();
			    	l1.setOpaque(true);
			    	if (odd==1){
			    		if (j%2==1) {
			    			l1.setBackground(Color.WHITE);
			    			l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    		} else {
			    			l1.setBackground(Color.WHITE);
			    			l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    		}
			    	}else {
			    		if (j%2==1) {
			    			l1.setBackground(Color.WHITE);
			    			l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    		} else {
			    			l1.setBackground(Color.WHITE);
			    			l1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			    		}
			    	}
					
			    	add(l1);
					l1.setOpaque(true);
					this.add(l1);
					jarr[i][j] = l1;
	    		}

	    		odd = 1 - odd;
	    	}
	    	
		
		}
 		
		
		
		private void paint (int x , int y , int color ) {
			//for ai
			// paints specified coordinate red or black
			System.out.println("Painting "+x +" "+y);
			if (color==1) {
				jarr[x][y].setBackground(Color.RED);
			} else if (color==0){
				jarr[x][y].setBackground(Color.BLACK);
			}
			else
				jarr[x][y].setBackground(Color.WHITE);
			
		}
		
		
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
			return 0;
		}

		
		public String getName() {
			return "Human Player";
		}
	}

}