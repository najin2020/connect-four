package hw4;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

class newMove implements java.awt.event.ActionListener {
	public int col;
	public int row;
	public GameBoard board;
	public int state;
	public newMove(GameBoard board, int row, int col) {
		this.row = row;
		this.col = col;
		this.board = board;
		this.state = 0;
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {
		board.paint(row, col, state);
		state = 1 - state;

	}
}

public class GameBoard extends javax.swing.JPanel {
	public JLabel[][] jarr;
	
	public GameBoard () {
		// initialize empty board
			
			
			this.setLayout(new java.awt.GridLayout(0,7));
			
			/*
			
			JButton b1 = new javax.swing.JButton("\u2193");
			JButton b2 = new javax.swing.JButton("\u2193");
			JButton b3 = new javax.swing.JButton("\u2193");
			JButton b4 = new javax.swing.JButton("\u2193");
			JButton b5 = new javax.swing.JButton("\u2193");		
			JButton b6 = new javax.swing.JButton("\u2193");
			JButton b7 = new javax.swing.JButton("\u2193");
			
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(b6);
			add(b7);
			
			*/
			
			
			/*
			 
			JButton b1 = new javax.swing.JButton("\u2193");
			b1.addActionListener(new newMove(g, 0));
			g.add(b1);
			
			JButton b2 = new javax.swing.JButton("\u2193");
			b2.addActionListener(new newMove(g, 0));
			g.add(b2);
			
			JButton b3 = new javax.swing.JButton("\u2193");
			b3.addActionListener(new newMove(g, 0));
			g.add(b3);
			
			JButton b4 = new javax.swing.JButton("\u2193");
			b4.addActionListener(new newMove(g, 0));
			g.add(b4);
			
			JButton b5 = new javax.swing.JButton("\u2193");
			b5.addActionListener(new newMove(g, 0));
			g.add(b5);
			
			JButton b6 = new javax.swing.JButton("\u2193");
			b6.addActionListener(new newMove(g, 0));
			g.add(b6);
			
			JButton b7 = new javax.swing.JButton("\u2193");
			b7.addActionListener(new newMove(g, 0));
			g.add(b7);
			
			*/
			
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
	
		public void paint (int x , int y , int color ) {
		// paints specified coordinate red or black
			System.out.println("Painting "+x +" "+y);
			if (color==0) {
				jarr[x][y].setBackground(Color.RED);
			} else {
				jarr[x][y].setBackground(Color.GREEN);
			}
		
		}
		
		public static void main(String[] args) {
			
			GameBoard g = new GameBoard();
			
			JFrame f= new JFrame("Connect Four");
			
			JButton b1 = new javax.swing.JButton("\u2193");
			b1.addActionListener(new newMove(g, 5, 0));
			g.add(b1);
			
			JButton b2 = new javax.swing.JButton("\u2193");
			b2.addActionListener(new newMove(g, 5, 1));
			g.add(b2);
			
			JButton b3 = new javax.swing.JButton("\u2193");
			b3.addActionListener(new newMove(g, 5, 2));
			g.add(b3);
			
			JButton b4 = new javax.swing.JButton("\u2193");
			b4.addActionListener(new newMove(g, 5, 3));
			g.add(b4);
			
			JButton b5 = new javax.swing.JButton("\u2193");
			b5.addActionListener(new newMove(g, 5, 4));
			g.add(b5);
			
			JButton b6 = new javax.swing.JButton("\u2193");
			b6.addActionListener(new newMove(g, 5, 5));
			g.add(b6);
			
			JButton b7 = new javax.swing.JButton("\u2193");
			b7.addActionListener(new newMove(g, 5, 6));
			g.add(b7);
			
			f.add(g);
			f.setSize(300,300); 
			f.setVisible(true);
			f.setLayout(null);
			f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
			
			/*
			 
			 GameBoard g = new GameBoard();
			
			JFrame f= new JFrame("Connect Four");
			
			f.add(g);
			f.setSize(300,300); 
			f.setVisible(true);
			f.setLayout(null);
			f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
			  
			 */
			
		}
}
