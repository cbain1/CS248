import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class JTT extends JFrame implements MouseListener {

	class closer extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
		System.out.println("Bye, thanks for playing.");
		System.exit(0);
		}
	}

	Container paper;
	Moves [] moves;  
	Board board;
	int [] xlist = {150, 500, 850, 320, 500, 680, 150, 500, 850};
	int [] ylist = {100, 100, 100, 300, 300, 300, 500, 500, 500};
	int player;
	int playAgain;

	//listens for player 1 to click on a space 
	public void mouseClicked(MouseEvent e) {
		int x,y;
		JPanel thispanel = (JPanel)e.getSource();
		x = e.getX();
		y = e.getY(); 
		for(int i=0; i<moves.length; i++) {
			if ((x >=xlist[i]-25 && x <= xlist[i]+25) && (y >=ylist[i]-25 && y <= ylist[i]+25)) {
				if(moves[i].color == Color.black) {
					moves[i].color = Color.blue;
					player=2;
				}
				board.repaint();
			}
		}
	}

	//builds each circle object 
	class Moves {
		Color color;
		int label;
		int x,y;

		public Moves(int x, int y, Color c, int l) {
			color = c;
			label = l;
			this.x=x-25;
			this.y=y-25;
		}

		public void draw(Graphics g) {
			g.fillOval(x,y,50,50);
		}
	}

	//builds the actual board 
	class Board extends JPanel {

		public Board() {
			moves = new Moves[9];
			setSize(1000,600);
			for (int i=0;i<9;i++) {
				moves[i] = new Moves(xlist[i],ylist[i],Color.black, i+1);
			}
		}

		public void paintComponent(Graphics g) {
			g.setColor(Color.black);
			// lines from 1 
			g.drawLine(xlist[0], ylist[0], xlist[1], ylist[1]);
			g.drawLine(xlist[0], ylist[0], xlist[3], ylist[3]);
			g.drawLine(xlist[0], ylist[0], xlist[4], ylist[4]);

			// lines from 2 
			g.drawLine(xlist[1], ylist[1], xlist[2], ylist[2]);
			g.drawLine(xlist[1], ylist[1], xlist[3], ylist[3]);
			g.drawLine(xlist[1], ylist[1], xlist[5], ylist[5]);

			//lines from 3
			g.drawLine(xlist[2], ylist[2], xlist[5], ylist[5]);
			g.drawLine(xlist[2], ylist[2], xlist[4], ylist[4]);

			//lines from 4
			g.drawLine(xlist[3], ylist[3], xlist[4], ylist[4]);
			g.drawLine(xlist[3], ylist[3], xlist[6], ylist[6]);
			g.drawLine(xlist[3], ylist[3], xlist[7], ylist[7]);

			//lines from 5 
			g.drawLine(xlist[4], ylist[4], xlist[5], ylist[5]);
			g.drawLine(xlist[4], ylist[4], xlist[6], ylist[6]);
			g.drawLine(xlist[4], ylist[4], xlist[8], ylist[8]);

			//lines from 6
			g.drawLine(xlist[5], ylist[5], xlist[7], ylist[7]);
			g.drawLine(xlist[5], ylist[5], xlist[8], ylist[8]);

			// lines from 7
			g.drawLine(xlist[6], ylist[6], xlist[7], ylist[7]);

			// lines from 8 
			g.drawLine(xlist[7], ylist[7], xlist[8], ylist[8]);
		
			for(int i=0;i<moves.length;i++) {
				g.setColor(moves[i].color);
				moves[i].draw(g);
			}
			g.setColor(Color.white);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			for (int i=0;i<moves.length;i++)
				g.drawString(String.valueOf(i+1),xlist[i]-5,ylist[i]+5);
		}
	}

	//creates the pane 
	public JTT() {

		setTitle("Catherine's Jerry Tac Toe Program.");
		setSize(1000, 800);
		addWindowListener(new closer());

		paper = getContentPane();
		paper.setLayout(new BorderLayout());

		board = new Board();

		paper.add(board, "Center");

		board.addMouseListener(this);



		setVisible(true);

	}

	//asks player 1 if they wantt to start and responds accordingly 
	public void begin() {
		int result;

		do {
			result = JOptionPane.showConfirmDialog(null, "Player 1, do you want to begin?" ,"Select Player", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		} while (result < 0);

		if (result==0) {
			player=1;
			resetBoard();
			board.repaint();
			
		}
		else{
			player=2;
			resetBoard();
			board.repaint();
			computerTurn();
		}
	}

	//resets the board to everything being empty 
	public void resetBoard() {
		for(int i=0; i<moves.length;i++) {
			moves[i].color = Color.black;
		}
	}

	//computer turn 
	// if there are 2 in the row of the same color, the computer will play in the third space, assuming it's open. If this condition does not occur, it plays randomly 
	public void computerTurn() {
		if(moves[0].color== moves[1].color && moves[0].color == Color.blue && moves[2].color == Color.black) 
			moves[2].color = Color.red;
		else if (moves[0].color == moves[2].color && moves[0].color != Color.black && moves[1].color == Color.black)
			moves[1].color = Color.red;
		else if (moves[1].color==moves[2].color && moves[1].color != Color.black && moves[0].color == Color.black)
			moves[0].color = Color.red;
		else if (moves[0].color == moves[4].color && moves[0].color != Color.black && moves[8].color == Color.black)
			moves[8].color = Color.red;
		else if (moves[0].color == moves[8].color && moves[0].color != Color.black && moves[4].color == Color.black)
			moves[4].color = Color.red;
		else if (moves[4].color == moves[8].color && moves[4].color != Color.black && moves[0].color == Color.black)
			moves[0].color = Color.red;
		else if (moves[0].color == moves[3].color && moves[0].color != Color.black && moves[7].color == Color.black)
			moves[7].color = Color.red;
		else if (moves[0].color == moves[7].color && moves[0].color != Color.black && moves[3].color == Color.black)
			moves[3].color = Color.red;
		else if (moves[3].color == moves[7].color && moves[3].color != Color.black && moves[0].color == Color.black)
			moves[0].color = Color.red;
		else if (moves[1].color == moves[3].color && moves[1].color != Color.black && moves[6].color == Color.black)
			moves[6].color = Color.red;
		else if (moves[1].color == moves[6].color && moves[1].color != Color.black && moves[3].color == Color.black)
			moves[3].color = Color.red;
		else if (moves[3].color == moves[6].color && moves[3].color != Color.black && moves[1].color == Color.black)
			moves[1].color = Color.red;
		else if (moves[1].color == moves[5].color && moves[1].color != Color.black && moves[8].color == Color.black)
			moves[8].color = Color.red;
		else if(moves[1].color == moves[8].color && moves[1].color != Color.black && moves[5].color == Color.black)
			moves[5].color = Color.red;
		else if (moves[5].color == moves[8].color && moves[5].color != Color.black && moves[1].color == Color.black)
			moves[1].color = Color.red;
		else if (moves[2].color == moves[4].color && moves[2].color != Color.black && moves[6].color == Color.black)
			moves[6].color = Color.red;
		else if (moves[2].color == moves[6].color && moves[2].color != Color.black && moves[4].color == Color.black)
			moves[4].color = Color.red;
		else if (moves[4].color == moves[6].color && moves[4].color != Color.black && moves[2].color == Color.black)
			moves[2].color = Color.red;
		else if (moves[2].color == moves[5].color && moves[2].color != Color.black && moves[7].color == Color.black)
			moves[7].color = Color.red;
		else if (moves[2].color == moves[7].color && moves[2].color != Color.black && moves[5].color == Color.black)
			moves[5].color = Color.red;
		else if (moves[5].color == moves[7].color && moves[5].color != Color.black && moves[2].color == Color.black)
			moves[2].color = Color.red;
		else if (moves[3].color == moves[4].color && moves[3].color != Color.black && moves[5].color == Color.black)
			moves[5].color = Color.red;
		else if (moves[3].color == moves[5].color && moves[3].color != Color.black && moves[4].color == Color.black)
			moves[4].color = Color.red;
		else if (moves[4].color == moves[5].color && moves[4].color != Color.black && moves[3].color == Color.black)
			moves[3].color = Color.red;
		else if (moves[6].color == moves[7].color && moves[6].color != Color.black && moves[8].color == Color.black)
			moves[8].color = Color.red;
		else if (moves[6].color == moves[8].color && moves[6].color != Color.black && moves[7].color == Color.black)
			moves[7].color = Color.red;
		else if (moves[7].color == moves[8].color && moves[7].color != Color.black && moves[6].color == Color.black)
			moves[6].color = Color.red;
		//playing randomly 
		else {
			Random random = new Random();
			int move;
			for (int i=0;i<1; i++) {
				move = random.nextInt(9);
				System.out.println(move);
				if(moves[move].color!=Color.black)
					i--;
				else
					moves[move].color = Color.red; 
			}
		}
		//repaints the board 
		board.repaint();
		player=1;
	}
	//chekcs for winner conditions 
	public Boolean hasWinner() { 
			return ((moves[0].color==moves[1].color && moves[0].color==moves[2].color && moves[0].color!=Color.black) ||
			(moves[0].color==moves[4].color && moves[0].color==moves[8].color && moves[0].color!=Color.black) ||
			(moves[0].color==moves[3].color && moves[0].color==moves[7].color && moves[0].color!=Color.black) ||
			(moves[1].color==moves[3].color && moves[1].color==moves[6].color && moves[1].color!=Color.black) ||
			(moves[1].color==moves[5].color && moves[1].color==moves[8].color && moves[1].color!=Color.black) ||
			(moves[2].color==moves[4].color && moves[2].color==moves[6].color && moves[2].color!=Color.black) ||
			(moves[3].color==moves[5].color && moves[3].color==moves[8].color && moves[3].color!=Color.black) ||
			(moves[3].color==moves[4].color && moves[3].color==moves[5].color && moves[3].color!=Color.black) ||
			(moves[6].color==moves[7].color && moves[6].color==moves[8].color && moves[6].color!=Color.black));
	}
	//checks to see if the game is over, could happen if there is a winner or if the board is simply full 
	public Boolean isOver() { 
		return (hasWinner() || (
		moves[0].color!=Color.black && 
		moves[1].color!=Color.black && 
		moves[2].color!=Color.black &&
		moves[3].color!=Color.black &&
		moves[4].color!=Color.black &&
		moves[5].color!=Color.black &&
		moves[6].color!=Color.black &&
		moves[7].color!=Color.black &&
		moves[8].color!=Color.black));

	}
	//this runst the actual game 
	public void playGame() {
		begin();
		// loop through as long as the game is not over 
		while (!isOver()) {
			if (player==2) {
				computerTurn();
			}
		}
		// outputs conditoins based on who has won/lost and asks if the user wants to play again
		if(hasWinner()) {
			if((moves[0].color==moves[1].color && moves[0].color==moves[2].color) || (moves[0].color==moves[4].color && moves[0].color==moves[8].color) || (moves[0].color==moves[3].color && moves[0].color==moves[7].color)) {
				if(moves[0].color == Color.blue) 
					playAgain = JOptionPane.showConfirmDialog(null, "Congrats Player 1, you win! Do you want to play again?" ,"Congrats!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				else
					playAgain = JOptionPane.showConfirmDialog(null, "Sorry Player 1, you lost! Do you want to play again?" ,"Sorry!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
			else if((moves[1].color==moves[3].color && moves[1].color==moves[6].color) ||	(moves[1].color==moves[5].color && moves[1].color==moves[8].color)) {
				if(moves[1].color == Color.blue) 
					playAgain = JOptionPane.showConfirmDialog(null, "Congrats Player 1, you win! Do you want to play again?" ,"Congrats!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				else
					playAgain = JOptionPane.showConfirmDialog(null, "Sorry Player 1, you lost! Do you want to play again?" ,"Sorry!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
			else if(moves[2].color==moves[4].color && moves[2].color==moves[6].color) {
				if(moves[2].color == Color.blue) 
					playAgain = JOptionPane.showConfirmDialog(null, "Congrats Player 1, you win! Do you want to play again?" ,"Congrats!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				else
					playAgain = JOptionPane.showConfirmDialog(null, "Sorry Player 1, you lost! Do you want to play again?" ,"Sorry!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
			else if((moves[3].color==moves[5].color && moves[2].color==moves[8].color) || (moves[3].color==moves[4].color && moves[3].color==moves[5].color)) {
				if(moves[3].color == Color.blue) 
					playAgain = JOptionPane.showConfirmDialog(null, "Congrats Player 1, you win! Do you want to play again?" ,"Congrats!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				else
					playAgain = JOptionPane.showConfirmDialog(null, "Sorry Player 1, you lost! Do you want to play again?" ,"Sorry!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
			else if(moves[6].color==moves[7].color && moves[6].color==moves[8].color) {
				if(moves[6].color == Color.blue) 
					playAgain = JOptionPane.showConfirmDialog(null, "Congrats Player 1, you win! Do you want to play again?" ,"Congrats!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				else
					playAgain = JOptionPane.showConfirmDialog(null, "Sorry Player 1, you lost! Do you want to play again?" ,"Sorry!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
		}
		// prints if the game is over and there is no winner and asks if user wants to play again 
		else if(isOver())
			playAgain = JOptionPane.showConfirmDialog(null, "Looks like you tied. Do you want to play again?" ,"Tied.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		//called if the player wants to play again 
		if (playAgain == 0)
			playGame();
		else {
			System.out.println("Bye, thanks for playing.");
			System.exit(0);
		}
	}
	public static void main(String [] args) {
		JTT game=new JTT();
		game.playGame();

	}

	//these functions aren't actually used, but they must exist because I implemented the MouseListener interface 
	public void mousePressed(MouseEvent e) {}
 
	public void mouseReleased(MouseEvent e) {}
 
	public void mouseEntered(MouseEvent e) {}
 
	public void mouseExited(MouseEvent e) {}
 

}