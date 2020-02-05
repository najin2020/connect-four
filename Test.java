package hw4;
import java.util.Scanner;
import hw4.CFPlayer;
import hw4.RandomAI;
import hw4.NoelleAI;
import hw4.ConsoleCF;
import hw4.GUICF;



public class Test {
  public static void main(String[] args) {

	  //this is for human vs. ai (GUICF version)
	  
	  	System.out.println("Press 1 for hard mode. Press 2 for easy mode. Press 3 to play on the console");
	  
	    Scanner reader = new Scanner (System.in);
	    int gameMode = reader.nextInt();
	    
	    //this is for the GUI
	    if (gameMode==1) {
	      new GUICF(new NoelleAI());
	    } 
	    
	    //this is for Monte Carlo 
	    else if (gameMode==2) {
	      CFPlayer ai1 = new NoelleAI();
	      CFPlayer ai2 = new RandomAI();
	      int n = 10000;
	      int winCount = 0;
	      for (int i =0; i < n ; i++) {
	        ConsoleCF game = new ConsoleCF(ai1, ai2);
	        game.playOut();
	        if(game.getWinner() == ai1.getName())
	          winCount++;
	      }
	      System.out.println(((double) winCount)/n);
	    }
	    
	    //this is for human vs. ai (console version)
	      else {
		      ConsoleCF game = new ConsoleCF(new NoelleAI());
		      game.playOut();
		      System.out.println(game.getWinner() + " has won.");
	    } 
	    
	    reader.close();
  }
}


