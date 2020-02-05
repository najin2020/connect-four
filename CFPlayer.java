package hw4;

//import hw4.GUICF.GameBoard;

public interface CFPlayer {

	int nextMove(CFGame g);
  //return value of getName cannot be "draw"
  String getName();

}