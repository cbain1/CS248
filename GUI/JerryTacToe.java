import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Board extends JPanel {

	public static final int EMPTY= 0;
	public static final int USER= 1;
	public static final int COMP= 2;
	public static final int HOVER = 3;
	int compchoice, humanchoice, variable;
	int [] spaces=new int [9];

	public void resetColor () { 
		for(int i=0; i<9; i++) {spaces[i]=EMPTY;} 
	}

	Color c;
	String number;

	public void setColor(Color x) { c=x; }
	public void setFace(String x) { number=x; }

	public Board() {
		super();
		setPreferredSize(new Dimension(600,400));
		c = Color.white;
		number="";
	}

	public void humancolors(int Color,int player) { spaces[Color]=player; }

	public void compcolors(int Color, int player) { spaces[Color]=player; }

	public void paintComponent(Graphics g) //draws board
	{
		g.setColor(Color.white); //Set Color to White
		g.fillRect(50,30, 500,400); //Board Outer Rectangle

		//Lines (Drawn First So That They Are Under Button Spots and Numbers)
		g.setColor(Color.black); //Black Lines
		g.drawLine(125,100,475,100); //1 - 2 - 3
		g.drawLine(125,100,300,325); //1 - 4 - 8
		g.drawLine(125,100,475,325); //1 - 5 - 9
		g.drawLine(300,100,125,325); //2 - 4 - 7
		g.drawLine(300,100,475,325); //2 - 6 - 9
		g.drawLine(475,100,125,325); //3 - 5 - 7
		g.drawLine(475,100,300,325); //3 - 6 - 8
		g.drawLine(212,212,387,212); //4 - 5 - 6
		g.drawLine(125,325,475,325); //7 - 8 - 9

		//Button Spots
		//Button 1

		if(spaces[0]==EMPTY) { g.setColor(Color.blue); g.fillOval(100,75, 50,50); }
		if(spaces[0]==USER) { g.setColor(Color.green); g.fillOval(100,75, 50,50); }
		if(spaces[0]==COMP) { g.setColor(Color.red); g.fillOval(100,75, 50,50); }
		if(spaces[0]==HOVER) { g.setColor(Color.gray); g.fillOval(100,75, 50,50); }

		//Button 2

		if(spaces[1]==EMPTY) { g.setColor(Color.blue); g.fillOval(275,75, 50,50); }
		if(spaces[1]==USER) { g.setColor(Color.green); g.fillOval(275,75, 50,50); }
		if(spaces[1]==COMP) { g.setColor(Color.red); g.fillOval(275,75, 50,50); }
		if(spaces[1]==HOVER) { g.setColor(Color.gray); g.fillOval(275,75, 50,50); }

		//Button 3

		if(spaces[2]==EMPTY) { g.setColor(Color.blue); g.fillOval(450,75, 50,50); }
		if(spaces[2]==USER) { g.setColor(Color.green); g.fillOval(450,75, 50,50); }
		if(spaces[2]==COMP) { g.setColor(Color.red); g.fillOval(450,75, 50,50); }
		if(spaces[2]==HOVER) { g.setColor(Color.gray); g.fillOval(450,75, 50,50); }

		//Button 4

		if(spaces[3]==EMPTY) { g.setColor(Color.blue); g.fillOval(187,187, 50,50); }
		if(spaces[3]==USER) { g.setColor(Color.green); g.fillOval(187,187, 50,50); }
		if(spaces[3]==COMP) { g.setColor(Color.red); g.fillOval(187,187, 50,50); }
		if(spaces[3]==HOVER) { g.setColor(Color.gray); g.fillOval(187,187, 50,50); }

		//Button 5

		if(spaces[4]==EMPTY) { g.setColor(Color.blue); g.fillOval(275,187, 50,50); }
		if(spaces[4]==USER) { g.setColor(Color.green); g.fillOval(275,187, 50,50); }
		if(spaces[4]==COMP) { g.setColor(Color.red); g.fillOval(275,187, 50,50); }
		if(spaces[4]==HOVER) { g.setColor(Color.gray); g.fillOval(275,187, 50,50); }

		//Button 6

		if(spaces[5]==EMPTY) { g.setColor(Color.blue); g.fillOval(362,187, 50,50); }
		if(spaces[5]==USER) { g.setColor(Color.green); g.fillOval(362,187, 50,50); }
		if(spaces[5]==COMP) { g.setColor(Color.red); g.fillOval(362,187, 50,50); }
		if(spaces[5]==HOVER) { g.setColor(Color.gray); g.fillOval(362,187, 50,50); }

		//Button 7

		if(spaces[6]==EMPTY) { g.setColor(Color.blue); g.fillOval(100,300, 50,50); }
		if(spaces[6]==USER) { g.setColor(Color.green); g.fillOval(100,300, 50,50); }
		if(spaces[6]==COMP) { g.setColor(Color.red); g.fillOval(100,300, 50,50); }
		if(spaces[6]==HOVER) { g.setColor(Color.gray); g.fillOval(100,300, 50,50); }

		//Button 8

		if(spaces[7]==EMPTY) { g.setColor(Color.blue); g.fillOval(275,300, 50,50); }
		if(spaces[7]==USER) { g.setColor(Color.green); g.fillOval(275,300, 50,50); }
		if(spaces[7]==COMP) { g.setColor(Color.red); g.fillOval(275,300, 50,50); }
		if(spaces[7]==HOVER) { g.setColor(Color.gray); g.fillOval(275,300, 50,50); }

		//Button 9

		if(spaces[8]==EMPTY) { g.setColor(Color.blue); g.fillOval(450,300, 50,50); }
		if(spaces[8]==USER) { g.setColor(Color.green); g.fillOval(450,300, 50,50); }
		if(spaces[8]==COMP) { g.setColor(Color.red); g.fillOval(450,300, 50,50); }
		if(spaces[8]==HOVER) { g.setColor(Color.gray); g.fillOval(450,300, 50,50); }

	//Numbers
		g.setFont(new Font(g.getFont().getName(), Font.BOLD, 30));
		g.setColor(Color.white); //White Numbers
		number="1";
		g.drawString(number,125,100); //#1
		number="2";
		g.drawString(number,300,100); //#2
		number="3";
		g.drawString(number,475,100); //#3
		number="4";
		g.drawString(number,212,212); //#4
		number="5";
		g.drawString(number,300,212); //#5
		number="6";
		g.drawString(number,387,212); //#6
		number="7";
		g.drawString(number,125,325); //#7
		number="8";
		g.drawString(number,300,325); //#8
		number="9";
		g.drawString(number,475,325); //#9
	}
}

public class JerryTacToe extends JFrame {
	private static int x, y;
	public static final int EMPTY= 0;
	public static final int USER= 1;
	public static final int COMP= 2;
	public static final int DRAW= 3;
	int p = 0;

	MouseListener mouseListener = new MouseListener();
	JTextField t;
	Board JTTB;
	int [] places = new int [9];

	class MouseListener extends MouseInputAdapter {
		public void mouseReleased(MouseEvent mouseEvent) {
			JPanel thepanel= (JPanel)mouseEvent.getSource();
			x = mouseEvent.getX();
			y = mouseEvent.getY();
			if((x>100 && x<150) && (y>80 && y<125)) {HumanTurn(0);}
			if((x>270 && x<316) && (y>80 && y<125)) {HumanTurn(1);}
			if((x>440 && x<490) && (y>80 && y<125)) {HumanTurn(2);}
			if((x>180 && x<228) && (y>192 && y<238)) {HumanTurn(3);}
			if((x>268 && x<317) && (y>192 && y<238)) {HumanTurn(4);}
			if((x>355 && x<403) && (y>192 && y<238)) {HumanTurn(5);}
			if((x>93 && x<142) && (y>305 && y<354)) {HumanTurn(6);}
			if((x>270 && x<316) && (y>305 && y<354)) {HumanTurn(7);}
			if((x>440 && x<490) && (y>305 && y<354)) {HumanTurn(8);}
		}

		public void mouseMoved(MouseEvent mouseEvent) {
			JPanel thepanel= (JPanel)mouseEvent.getSource();
			x = mouseEvent.getX();
			y = mouseEvent.getY();
			
			for (int a = 0; a < 9; a++) {
				if (places[a] == EMPTY)
					JTTB.humancolors(a, 0);
			}

			if((x>100 && x<150) && (y>80 && y<125) && places[0] == EMPTY)
			JTTB.humancolors(0, 3);
			if((x>270 && x<316) && (y>80 && y<125) && places[1] == EMPTY)
			JTTB.humancolors(1, 3);
			if((x>440 && x<490) && (y>80 && y<125) && places[2] == EMPTY)
			JTTB.humancolors(2, 3);
			if((x>180 && x<228) && (y>192 && y<238) && places[3] == EMPTY)
			JTTB.humancolors(3, 3);
			if((x>268 && x<317) && (y>192 && y<238) && places[4] == EMPTY)
			JTTB.humancolors(4, 3);
			if((x>355 && x<403) && (y>192 && y<238) && places[5] == EMPTY)
			JTTB.humancolors(5, 3);
			if((x>93 && x<142) && (y>305 && y<354) && places[6] == EMPTY)
			JTTB.humancolors(6, 3);
			if((x>270 && x<316) && (y>305 && y<354) && places[7] == EMPTY)
			JTTB.humancolors(7, 3);
			if((x>440 && x<490) && (y>305 && y<354) && places[8] == EMPTY)
			JTTB.humancolors(8, 3);
			repaint();
		}
	}


	public JerryTacToe() { //Constructor 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,640);
		setTitle("Jerry-Tac-Toe");

		JTTB=new Board();

		JPanel panel=new JPanel();
		panel.setLayout( new BorderLayout() );
		JPanel panel1=new JPanel();
		panel1.setLayout( new BorderLayout() );

		JPanel button1panel=new JPanel();
		JPanel button2panel=new JPanel();
		JPanel button3panel=new JPanel();
		button1panel.add(new JLabel("User is Green &"));
		button1panel.add(new JLabel("Computer is Red"));
		button3panel.add(JTTB);

		panel1.add(button1panel, "Center");
		panel1.add(button2panel, "South");
		panel.add(button3panel, "North");
		panel.add(panel1, "South");

		panel.addMouseMotionListener(panel);
		panel.addMouseListener(panel);

		Container c = getContentPane();

		for(int i = 0; i<9; i++){places[i] = EMPTY;}
		c.add(panel);
		setSize(600,550);
		ResetBoard();
	}

//Only call this function if there is a move to be made.
	public void CompTurn() { // plays comp turn.
		int n;

		while (places[n]!= EMPTY) {
			n=(int)(9*Math.random());
		}

		places[n]= COMP;
		JTTB.compcolors(n, COMP);
		repaint();

		if((BoardFull()==true) ||(Wins(USER)==true)||(Wins(COMP)==true)) {
			WhoWins();
			PlayAgain();
		}
	}

	//Only call this function if there is a move to be made.
	public void HumanTurn(int c) { // plays User turn.
		if(places[c] != EMPTY)
			repaint();
		else if(places [c] == EMPTY) {
			places[c] = USER;
			JTTB.humancolors(c, USER);
			repaint();

			if(BoardFull() || Wins(USER) || Wins(COMP)) {
				WhoWins();
				PlayAgain();
			}
			else
				CompTurn();
		}
	}

	public void WhoWins() { // determines and prints out who wins, whether player wins, comp wins, or draw.
		if (Wins(USER))
		System.out.println("You Win!");
		else if (Wins(COMP))
		System.out.println("Computer Wins!");
		else if (BoardFull())
		System.out.println("Draw Game.");
	}

	public boolean Wins(int player) { //checks winning combonations.
		if(places[0]==player && places[3]==player && places[7]==player)
		return true;
		if(places[0]==player && places[1]==player && places[2]==player)
		return true;
		if(places[0]==player && places[4]==player && places[8]==player)
		return true;
		if(places[3]==player && places[4]==player && places[5]==player)
		return true;
		if(places[2]==player && places[5]==player && places[7]==player)
		return true;
		if(places[1]==player && places[3]==player && places[6]==player)
		return true;
		if(places[1]==player && places[5]==player && places[8]==player)
		return true;
		if(places[2]==player && places[4]==player && places[6]==player)
		return true;
		if(places[6]==player && places[7]==player && places[8]==player)
		return true;

		return false;
	}

	public void PlayAgain() { // asks to play again and resets board if yes.
		int result;

		do {
			result = JOptionPane.showConfirmDialog(null, "Play Again?", "Play Again?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		} while (result < 0);

		if (result == 0) {
			JTTB.resetColor();
			repaint();
			ResetBoard();
			p = 1;
			WhoFirst();
		}
		else if (result == 1) {
			if (p==1)
				System.out.print("Good Games!");
			else
				System.out.print("Good Game!");
			System.exit(0);
		}
		else
			throw new RuntimeException("How the hell did you get here?!");
	}

	public void WhoFirst() {
		int result;

		do {
			result = JOptionPane.showConfirmDialog(null, "Do You Want to go First?", "Do You Want to go First?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		} while (result < 0);

		if (result==0) {
			JTTB.resetColor();
			repaint();
			ResetBoard();
		}
		else{
			JTTB.resetColor();
			repaint();
			ResetBoard();
			CompTurn();
		}

	}

	public boolean BoardFull() { // checks to see if board is full.
		for(int i=0; i<9; i++) {
			if(places[i]==EMPTY)
			return false;
		}
		return true;
	}

	public void ResetBoard() {
		for(int i = 0; i<9; i++){places[i] = EMPTY;}
	}

	public static void main(String [] args) {
		JerryTacToe Game = new JerryTacToe();
		Game.pack();
		Game.setVisible(true);
		Game.setLocationRelativeTo(null);
		Game.WhoFirst();
	}
}