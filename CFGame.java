package hw4;

import javax.swing.JButton;

public class CFGame {
  //state[i][j]= 0 means the i,j slot is empty
  //state[i][j]= 1 means the i,j slot has red
  //state[i][j]=-1 means the i,j slot has black
  private final int[][] state;
  private boolean isRedTurn;
  
  {
    state = new int[6][7];
    for (int i=0; i<6; i++)
      for (int j=0; j<7; j++)
        state[i][j] = 0;
    isRedTurn = true; //red goes first
  }
  
  //places game piece, updates board
  void setState(int row, int column, int colorpiece) {
	  int[][] set_arr = new int[6][7];
	  set_arr[row][column] = colorpiece; 
	  state[row][column] = set_arr[row][column];
  }
    
  public int[][] getState() {
    int[][] ret_arr = new int[6][7];
    for (int i=0; i<6; i++)
      for (int j=0; j<7; j++)
        ret_arr[i][j] = state[i][j];
    return ret_arr;
  }
  
  public char[][] getStateColor() {
	  char[][] board = new char[6][7]; 
	    
	    for (int i=0; i<6; i++) {
	        for (int j=0; j<7; j++) {
	          if (state[i][j]==1)
	        	  board[i][j]='R';
	          else if(state[i][j]==-1)
	        	  board[i][j]='B';
	          else if (state[i][j]==0)
	        	  board[i][j]='-';
	        }
	    }
	    return board;
	}
  
	public void getBoard() {
		int[][] board;
		board = new int[6][7];
		
	    for (int i=0; i<6; i++)
	        for (int j=0; j<7; j++)
	          board[i][j] = state[i][j];

	    System.out.println("/---|---|---|---|---|---|---\\");
		System.out.println("| " + 1 + " | " + 2 + " | " + 3 + " | " + 4 + " | " + 5 + " | " + 6 + " | " + 7 + " |");
    	System.out.println("|---------------------------|");
		
    	System.out.println(" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+"columns");
    	System.out.println("|---------------------------|");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " |");
		System.out.println("/---|---|---|---|---|---|---\\");
		
	}
	
	//indicates whether the player is red or black
	public void numToColor() {
		char[][] board;
		int[][] num_board;
		board = new char[6][7];
		num_board = new int[6][7];
		
	    for (int i=0; i<6; i++) {
	        for (int j=0; j<7; j++) {
	          num_board[i][j] = state[i][j];
	          if (num_board[i][j]==1)
	        	  board[i][j]='R';
	          else if(num_board[i][j]==-1)
	        	  board[i][j]='B';
	          else if (num_board[i][j]==0)
	        	  board[i][j]='-';
	        	  
	        }
	    }

	    System.out.println("/---|---|---|---|---|---|---\\");
		System.out.println("| " + 1 + " | " + 2 + " | " + 3 + " | " + 4 + " | " + 5 + " | " + 6 + " | " + 7 + " |");
    	System.out.println("|---------------------------|");
		
    	System.out.println(" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+"columns");
    	System.out.println("|---------------------------|");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " |");
		System.out.println("|---------------------------|");
		System.out.println("| " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " |");
		System.out.println("/---|---|---|---|---|---|---\\");
		
	}
  
  public boolean isRedTurn() {
    return isRedTurn;
  }
  
  public boolean play(int column) {
	  //if all rows in a given column is taken OR if column is out of bounds, return false
	  if ((state[0][column]!=0 && state[1][column]!=0 && state[2][column]!=0 && state[3][column]!=0 &&
		  state[4][column]!=0 && state[5][column]!=0) || column < 0 || column > 6) 
		  return false;
	  else
		  return true;
	  
  }
  
  private boolean redVertical() {
	  
	  boolean win = false;
	  
	  if ((state[0][0]==1 && state[1][0]==1 && state[2][0]==1 && state[3][0]==1) ||
		  (state[1][0]==1 && state[2][0]==1 && state[3][0]==1 && state[4][0]==1) ||
		  (state[2][0]==1 && state[3][0]==1 && state[4][0]==1 && state[5][0]==1) || 
		  
		  (state[0][1]==1 && state[1][1]==1 && state[2][1]==1 && state[3][1]==1) ||
		  (state[1][1]==1 && state[2][1]==1 && state[3][1]==1 && state[4][1]==1) ||
		  (state[2][1]==1 && state[3][1]==1 && state[4][1]==1 && state[5][1]==1) ||
		  
		  (state[0][2]==1 && state[1][2]==1 && state[2][2]==1 && state[3][2]==1) ||
		  (state[1][2]==1 && state[2][2]==1 && state[3][2]==1 && state[4][2]==1) ||
		  (state[2][2]==1 && state[3][2]==1 && state[4][2]==1 && state[5][2]==1) ||
		  
		  (state[0][3]==1 && state[1][3]==1 && state[2][3]==1 && state[3][3]==1) ||
		  (state[1][3]==1 && state[2][3]==1 && state[3][3]==1 && state[4][3]==1) ||
		  (state[2][3]==1 && state[3][3]==1 && state[4][3]==1 && state[5][3]==1) ||
		  
		  (state[0][4]==1 && state[1][4]==1 && state[2][4]==1 && state[3][4]==1) ||
		  (state[1][4]==1 && state[2][4]==1 && state[3][4]==1 && state[4][4]==1) ||
		  (state[2][4]==1 && state[3][4]==1 && state[4][4]==1 && state[5][4]==1) || 
		  
		  (state[0][5]==1 && state[1][5]==1 && state[2][5]==1 && state[3][5]==1) ||
		  (state[1][5]==1 && state[2][5]==1 && state[3][5]==1 && state[4][5]==1) ||
		  (state[2][5]==1 && state[3][5]==1 && state[4][5]==1 && state[5][5]==1) ||
		  
		  (state[0][6]==1 && state[1][6]==1 && state[2][6]==1 && state[3][6]==1) ||
		  (state[1][6]==1 && state[2][6]==1 && state[3][6]==1 && state[4][6]==1) ||
		  (state[2][6]==1 && state[3][6]==1 && state[4][6]==1 && state[5][6]==1) )
			
			  win = true;
		  else
			  win = false; 
	  
	  /*
		  
	  for (int column = 0; column<7; column++) {
		  if ((state[0][column]==1 && state[1][column]==1 && state[2][column]==1 && state[3][column]==1) ||
			  (state[1][column]==1 && state[2][column]==1 && state[3][column]==1 && state[4][column]==1) ||
			  (state[2][column]==1 && state[3][column]==1 && state[4][column]==1 && state[5][column]==1)) 
			  win = true;
		  else
			  win = false;
	  }
	  
	  */
	  
	  return win;
  }
  
  private boolean blackVertical() {
	  
	  boolean win = false;
	    
		  if ((state[0][0]==-1 && state[1][0]==-1 && state[2][0]==-1 && state[3][0]==-1) ||
			  (state[1][0]==-1 && state[2][0]==-1 && state[3][0]==-1 && state[4][0]==-1) ||
			  (state[2][0]==-1 && state[3][0]==-1 && state[4][0]==-1 && state[5][0]==-1) || 
			  
			  (state[0][1]==-1 && state[1][1]==-1 && state[2][1]==-1 && state[3][1]==-1) ||
			  (state[1][1]==-1 && state[2][1]==-1 && state[3][1]==-1 && state[4][1]==-1) ||
			  (state[2][1]==-1 && state[3][1]==-1 && state[4][1]==-1 && state[5][1]==-1) ||
			  
			  (state[0][2]==-1 && state[1][2]==-1 && state[2][2]==-1 && state[3][2]==-1) ||
			  (state[1][2]==-1 && state[2][2]==-1 && state[3][2]==-1 && state[4][2]==-1) ||
			  (state[2][2]==-1 && state[3][2]==-1 && state[4][2]==-1 && state[5][2]==-1) ||
			  
			  (state[0][3]==-1 && state[1][3]==-1 && state[2][3]==-1 && state[3][3]==-1) ||
			  (state[1][3]==-1 && state[2][3]==-1 && state[3][3]==-1 && state[4][3]==-1) ||
			  (state[2][3]==-1 && state[3][3]==-1 && state[4][3]==-1 && state[5][3]==-1) ||
			  
			  (state[0][4]==-1 && state[1][4]==-1 && state[2][4]==-1 && state[3][4]==-1) ||
			  (state[1][4]==-1 && state[2][4]==-1 && state[3][4]==-1 && state[4][4]==-1) ||
			  (state[2][4]==-1 && state[3][4]==-1 && state[4][4]==-1 && state[5][4]==-1) || 
			  
			  (state[0][5]==-1 && state[1][5]==-1 && state[2][5]==-1 && state[3][5]==-1) ||
			  (state[1][5]==-1 && state[2][5]==-1 && state[3][5]==-1 && state[4][5]==-1) ||
			  (state[2][5]==-1 && state[3][5]==-1 && state[4][5]==-1 && state[5][5]==-1) ||
			  
			  (state[0][6]==-1 && state[1][6]==-1 && state[2][6]==-1 && state[3][6]==-1) ||
			  (state[1][6]==-1 && state[2][6]==-1 && state[3][6]==-1 && state[4][6]==-1) ||
			  (state[2][6]==-1 && state[3][6]==-1 && state[4][6]==-1 && state[5][6]==-1) )
			
			  win = true;
		  else
			  win = false; 
			  
	  /*
	  
	  for (int column = 0; column<7; column++) {	  
		  if ((state[0][column]==-1 && state[1][column]==-1 && state[2][column]==-1 && state[3][column]==-1) ||
			  (state[1][column]==-1 && state[2][column]==-1 && state[3][column]==-1 && state[4][column]==-1) ||
			  (state[2][column]==-1 && state[3][column]==-1 && state[4][column]==-1 && state[5][column]==-1) ) 
			  win = true;
		  else
			  win = false; 
	  }
	  */
	  
	  
	  return win;
  }
  
  private boolean redHorizontal() {
	  
	  boolean win = false;
	  
	  if ((state[0][0]==1 && state[0][1]==1 && state[0][2]==1 && state[0][3]==1) ||
		  (state[0][1]==1 && state[0][2]==1 && state[0][3]==1 && state[0][4]==1) ||
		  (state[0][2]==1 && state[0][3]==1 && state[0][4]==1 && state[0][5]==1) ||
		  (state[0][3]==1 && state[0][4]==1 && state[0][5]==1 && state[0][6]==1) || 
		  
		  (state[1][0]==1 && state[1][1]==1 && state[1][2]==1 && state[1][3]==1) ||
		  (state[1][1]==1 && state[1][2]==1 && state[1][3]==1 && state[1][4]==1) ||
		  (state[1][2]==1 && state[1][3]==1 && state[1][4]==1 && state[1][5]==1) ||
		  (state[1][3]==1 && state[1][4]==1 && state[1][5]==1 && state[1][6]==1) ||
		  
		  (state[2][0]==1 && state[2][1]==1 && state[2][2]==1 && state[2][3]==1) ||
		  (state[2][1]==1 && state[2][2]==1 && state[2][3]==1 && state[2][4]==1) ||
		  (state[2][2]==1 && state[2][3]==1 && state[2][4]==1 && state[2][5]==1) ||
		  (state[2][3]==1 && state[2][4]==1 && state[2][5]==1 && state[2][6]==1) ||
		  
		  (state[3][0]==1 && state[3][1]==1 && state[3][2]==1 && state[3][3]==1) ||
		  (state[3][1]==1 && state[3][2]==1 && state[3][3]==1 && state[3][4]==1) ||
		  (state[3][2]==1 && state[3][3]==1 && state[3][4]==1 && state[3][5]==1) ||
		  (state[3][3]==1 && state[3][4]==1 && state[3][5]==1 && state[3][6]==1) ||
		  
		  (state[4][0]==1 && state[4][1]==1 && state[4][2]==1 && state[4][3]==1) ||
		  (state[4][1]==1 && state[4][2]==1 && state[4][3]==1 && state[4][4]==1) ||
		  (state[4][2]==1 && state[4][3]==1 && state[4][4]==1 && state[4][5]==1) ||
		  (state[4][3]==1 && state[4][4]==1 && state[4][5]==1 && state[4][6]==1) ||
		  
		  (state[5][0]==1 && state[5][1]==1 && state[5][2]==1 && state[5][3]==1) ||
		  (state[5][1]==1 && state[5][2]==1 && state[5][3]==1 && state[5][4]==1) ||
		  (state[5][2]==1 && state[5][3]==1 && state[5][4]==1 && state[5][5]==1) ||
		  (state[5][3]==1 && state[5][4]==1 && state[5][5]==1 && state[5][6]==1) ) 
			  win = true;
		  else
			  win = false;
	  
	  /*
	  
	  for(int row = 0; row<6; row++) {

		  if ((state[row][0]==1 && state[row][1]==1 && state[row][2]==1 && state[row][3]==1) ||
			  (state[row][1]==1 && state[row][2]==1 && state[row][3]==1 && state[row][4]==1) ||
			  (state[row][2]==1 && state[row][3]==1 && state[row][4]==1 && state[row][5]==1) ||
			  (state[row][3]==1 && state[row][4]==1 && state[row][5]==1 && state[row][6]==1)) 
			  win = true;
		  else
			  win = false;
	  }
	  
	  */
	  
	  return win;
  }
  
  private boolean blackHorizontal() {
	  
	  boolean win = false;
	  
	  if ((state[0][0]==-1 && state[0][1]==-1 && state[0][2]==-1 && state[0][3]==-1) ||
		  (state[0][1]==-1 && state[0][2]==-1 && state[0][3]==-1 && state[0][4]==-1) ||
		  (state[0][2]==-1 && state[0][3]==-1 && state[0][4]==-1 && state[0][5]==-1) ||
		  (state[0][3]==-1 && state[0][4]==-1 && state[0][5]==-1 && state[0][6]==-1) || 
		  
		  (state[1][0]==-1 && state[1][1]==-1 && state[1][2]==-1 && state[1][3]==-1) ||
		  (state[1][1]==-1 && state[1][2]==-1 && state[1][3]==-1 && state[1][4]==-1) ||
		  (state[1][2]==-1 && state[1][3]==-1 && state[1][4]==-1 && state[1][5]==-1) ||
		  (state[1][3]==-1 && state[1][4]==-1 && state[1][5]==-1 && state[1][6]==-1) ||
		  
		  (state[2][0]==-1 && state[2][1]==-1 && state[2][2]==-1 && state[2][3]==-1) ||
		  (state[2][1]==-1 && state[2][2]==-1 && state[2][3]==-1 && state[2][4]==-1) ||
		  (state[2][2]==-1 && state[2][3]==-1 && state[2][4]==-1 && state[2][5]==-1) ||
		  (state[2][3]==-1 && state[2][4]==-1 && state[2][5]==-1 && state[2][6]==-1) ||
		  
		  (state[3][0]==-1 && state[3][1]==-1 && state[3][2]==-1 && state[3][3]==-1) ||
		  (state[3][1]==-1 && state[3][2]==-1 && state[3][3]==-1 && state[3][4]==-1) ||
		  (state[3][2]==-1 && state[3][3]==-1 && state[3][4]==-1 && state[3][5]==-1) ||
		  (state[3][3]==-1 && state[3][4]==-1 && state[3][5]==-1 && state[3][6]==-1) ||
		  
		  (state[4][0]==-1 && state[4][1]==-1 && state[4][2]==-1 && state[4][3]==-1) ||
		  (state[4][1]==-1 && state[4][2]==-1 && state[4][3]==-1 && state[4][4]==-1) ||
		  (state[4][2]==-1 && state[4][3]==-1 && state[4][4]==-1 && state[4][5]==-1) ||
		  (state[4][3]==-1 && state[4][4]==-1 && state[4][5]==-1 && state[4][6]==-1) ||
		  
		  (state[5][0]==-1 && state[5][1]==-1 && state[5][2]==-1 && state[5][3]==-1) ||
		  (state[5][1]==-1 && state[5][2]==-1 && state[5][3]==-1 && state[5][4]==-1) ||
		  (state[5][2]==-1 && state[5][3]==-1 && state[5][4]==-1 && state[5][5]==-1) ||
		  (state[5][3]==-1 && state[5][4]==-1 && state[5][5]==-1 && state[5][6]==-1) ) 
				  win = true;
			  else
				  win = false;
	  
	  /*
	  for(int row = 0; row<6; row++) {
		  
		  if ((state[row][0]==-1 && state[row][1]==-1 && state[row][2]==-1 && state[row][3]==-1) ||
			  (state[row][1]==-1 && state[row][2]==-1 && state[row][3]==-1 && state[row][4]==-1) ||
			  (state[row][2]==-1 && state[row][3]==-1 && state[row][4]==-1 && state[row][5]==-1) ||
			  (state[row][3]==-1 && state[row][4]==-1 && state[row][5]==-1 && state[row][6]==-1)) 
			  win = true;
		  else
			  win = false;   
	  }
	  */
	  
	  return win;
	  
	  
  }
  
  private boolean redDiagonal() {
	  
	  	  //right diagonals
	  if (
		  (state[0][0]==1 && state[1][1]==1 && state[2][2]==1 && state[3][3]==1) ||
		  (state[0][1]==1 && state[1][2]==1 && state[2][3]==1 && state[3][4]==1) ||
		  (state[0][2]==1 && state[1][3]==1 && state[2][4]==1 && state[3][5]==1) ||
		  (state[0][3]==1 && state[1][4]==1 && state[2][5]==1 && state[3][6]==1) ||

		  (state[1][0]==1 && state[2][1]==1 && state[3][2]==1 && state[4][3]==1) ||
		  (state[1][1]==1 && state[2][2]==1 && state[3][3]==1 && state[4][4]==1) ||
		  (state[1][2]==1 && state[2][3]==1 && state[3][4]==1 && state[4][5]==1) ||
		  (state[1][3]==1 && state[2][4]==1 && state[3][5]==1 && state[4][6]==1) ||
		  
		  (state[2][0]==1 && state[3][1]==1 && state[4][2]==1 && state[5][3]==1) ||
		  (state[2][1]==1 && state[3][2]==1 && state[4][3]==1 && state[5][4]==1) ||
		  (state[2][2]==1 && state[3][3]==1 && state[4][4]==1 && state[5][5]==1) ||
		  (state[2][3]==1 && state[3][4]==1 && state[4][5]==1 && state[5][6]==1) ||
			  
		  //left diagonals
		  (state[0][6]==1 && state[1][5]==1 && state[2][4]==1 && state[3][3]==1) ||
		  (state[0][5]==1 && state[1][4]==1 && state[2][3]==1 && state[3][2]==1) ||
		  (state[0][4]==1 && state[1][3]==1 && state[2][2]==1 && state[3][1]==1) ||
		  (state[0][3]==1 && state[1][2]==1 && state[2][1]==1 && state[3][0]==1) ||
		  
		  (state[1][6]==1 && state[2][5]==1 && state[3][4]==1 && state[4][3]==1) ||
		  (state[1][5]==1 && state[2][4]==1 && state[3][3]==1 && state[4][2]==1) ||
		  (state[1][4]==1 && state[2][3]==1 && state[3][2]==1 && state[4][1]==1) ||
		  (state[1][3]==1 && state[2][2]==1 && state[3][1]==1 && state[4][0]==1) ||
			  
		  (state[2][6]==1 && state[3][5]==1 && state[4][4]==1 && state[5][3]==1) ||
		  (state[2][5]==1 && state[3][4]==1 && state[4][3]==1 && state[5][2]==1) ||
		  (state[2][4]==1 && state[3][3]==1 && state[4][2]==1 && state[5][1]==1) ||
		  (state[2][3]==1 && state[3][2]==1 && state[4][1]==1 && state[5][0]==1) 
		  )
		  
		  return true;
	  else 
		  return false;
	  
  }
  
  private boolean blackDiagonal() {

	  	  //right diagonals
	  if (
		  (state[0][0]==-1 && state[1][1]==-1 && state[2][2]==-1 && state[3][3]==-1) ||
		  (state[0][1]==-1 && state[1][2]==-1 && state[2][3]==-1 && state[3][4]==-1) ||
		  (state[0][2]==-1 && state[1][3]==-1 && state[2][4]==-1 && state[3][5]==-1) ||
		  (state[0][3]==-1 && state[1][4]==-1 && state[2][5]==-1 && state[3][6]==-1) ||

		  (state[1][0]==-1 && state[2][1]==-1 && state[3][2]==-1 && state[4][3]==-1) ||
		  (state[1][1]==-1 && state[2][2]==-1 && state[3][3]==-1 && state[4][4]==-1) ||
		  (state[1][2]==-1 && state[2][3]==-1 && state[3][4]==-1 && state[4][5]==-1) ||
		  (state[1][3]==-1 && state[2][4]==-1 && state[3][5]==-1 && state[4][6]==-1) ||
		  
		  (state[2][0]==-1 && state[3][1]==-1 && state[4][2]==-1 && state[5][3]==-1) ||
		  (state[2][1]==-1 && state[3][2]==-1 && state[4][3]==-1 && state[5][4]==-1) ||
		  (state[2][2]==-1 && state[3][3]==-1 && state[4][4]==-1 && state[5][5]==-1) ||
		  (state[2][3]==-1 && state[3][4]==-1 && state[4][5]==-1 && state[5][6]==-1) ||
			  
		  //left diagonals
		  (state[0][6]==-1 && state[1][5]==-1 && state[2][4]==-1 && state[3][3]==-1) ||
		  (state[0][5]==-1 && state[1][4]==-1 && state[2][3]==-1 && state[3][2]==-1) ||
		  (state[0][4]==-1 && state[1][3]==-1 && state[2][2]==-1 && state[3][1]==-1) ||
		  (state[0][3]==-1 && state[1][2]==-1 && state[2][1]==-1 && state[3][0]==-1) ||
		  
		  (state[1][6]==-1 && state[2][5]==-1 && state[3][4]==-1 && state[4][3]==-1) ||
		  (state[1][5]==-1 && state[2][4]==-1 && state[3][3]==-1 && state[4][2]==-1) ||
		  (state[1][4]==-1 && state[2][3]==-1 && state[3][2]==-1 && state[4][1]==-1) ||
		  (state[1][3]==-1 && state[2][2]==-1 && state[3][1]==-1 && state[4][0]==-1) ||
			  
		  (state[2][6]==-1 && state[3][5]==-1 && state[4][4]==-1 && state[5][3]==-1) ||
		  (state[2][5]==-1 && state[3][4]==-1 && state[4][3]==-1 && state[5][2]==-1) ||
		  (state[2][4]==-1 && state[3][3]==-1 && state[4][2]==-1 && state[5][1]==-1) ||
		  (state[2][3]==-1 && state[3][2]==-1 && state[4][1]==-1 && state[5][0]==-1) 
		  )
		  
		  return true;
	  else 
		  return false;
	  
  }
  
  private boolean boardFull() {
	  
	  boolean full = false;
	  
	  outerloop:
	  for (int column = 0; column < 7; column++) {
		  for (int row = 0; row < 6; row++) {
			  if (state[row][column]==0) { //if there's any 0's on the board, the board is not full
				  full = false;
				  break outerloop;
			  }
			  else
				  full = true;
		  }
	  }
	  
	  return full;
  }
  
  public boolean isGameOver() {
	if (redVertical() == true || redHorizontal() == true || redDiagonal() == true || 
		blackVertical() == true || blackHorizontal() == true || blackDiagonal() == true	||
		boardFull()==true)
		return true;
	else
		return false;
  }
  
  public int winner() {
    if (redVertical() == true || redHorizontal() == true || redDiagonal() == true)
    	return 1;
    else if (blackVertical() == true || blackHorizontal() == true || blackDiagonal() == true)
    	return -1;
    else 
    	return 0;
    
  }
  
  public boolean getRVertical() {
	  return redVertical();
  }
  
  public boolean getBVertical() {
	  return blackVertical();
  }
  
  public boolean getRHorizontal() {
	  return redHorizontal();
  }
  
  public boolean getBHorizontal() {
	  return blackHorizontal();
  }
  
  public boolean getRDiagonal() {
	  return redDiagonal();
  }
  
  public boolean getBDiagonal() {
	  return blackDiagonal();
  }

public void add(JButton b1) {
	// TODO Auto-generated method stub
	
}
  
}
