import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class dad extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
	System.out.println("It's closing time.");
	System.exit(0);
	}
}

class gui6 extends JFrame implements ActionListener {

	class art extends JPanel {
		int suny; 

		public art() {
			setSize(1000,600);
			suny=50;
		}
		public void time() {suny++;}
		public void paintComponent(Graphics g) {
			//sky
			g.setColor(Color.blue);
			g.fillRect(0, 0, 1000, 600);

			//sun
			g.setColor(Color.yellow);
			g.fillOval(800,suny,100,100);

			//grass 
			g.setColor(Color.green);
			g.fillRect(0, 300, 1000, 300);

			//house 
			g.setColor(Color.red);
			g.fillRect(100, 150, 500, 300);
		}
	}
	JButton north;
	JButton east;
	JTextField south;
	int count;
	art picasso;

	public void actionPerformed(ActionEvent e) {
		count++;
		if(e.getSource()==north)
			south.setText("North Button Pressed!!  Victory! count="+count);
		else
			south.setText("East Button Pressed!!  Even more Victory! count="+count);
		picasso.time();
		picasso.repaint();
	}

	public gui6() {
		count=0;

		setTitle("GUI6: Our new gooey program!");
		setSize(1100,700);
		addWindowListener(new dad());

		// put stuff in the window
		Container glass=getContentPane();
		glass.setLayout( new BorderLayout() ); // layout manager


		north=new JButton("Center");
		east=new JButton("E");
		south=new JTextField("S");

		north.addActionListener(this);
		east.addActionListener(this);

		JPanel people=new JPanel();
		people.setLayout(new BorderLayout());
		people.add( north, "North" );

		picasso = new art();
		people.add(picasso, "Center");
		glass.add( people, "Center" );

		glass.add( new JLabel("Victim"), "North" );
		glass.add( south, "South" );
		glass.add( east, "East" );
		glass.add( new JTextArea("W"), "West" );


		setVisible(true);
	}

  	public static void main(String [] args) {
   		gui6 gelatinousCube=new gui6();
	}
}