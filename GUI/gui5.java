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

class gui5 extends JFrame implements ActionListener {
	JButton north;
	JButton east;
	JTextField south;
	int count;

	public void actionPerformed(ActionEvent e) {
		count++;
		if(e.getSource()==north)
			south.setText("North Button Pressed!!  Victory! count="+count);
		else
			south.setText("East Button Pressed!!  Even more Victory! count="+count);
	}

	public gui5() {
		count=0;

		setTitle("GUI5: Our new gooey program!");
		setSize(500,500);
		addWindowListener(new dad());

		// put stuff in the window
		Container glass=getContentPane();
		glass.setLayout( new BorderLayout() ); // layout manager

		//glass.add( new JButton("Center"), "Center" );

		north=new JButton("Center");
		east=new JButton("E");
		south=new JTextField("S");

		north.addActionListener(this);
		east.addActionListener(this);

		JPanel people=new JPanel();
		people.setLayout(new BorderLayout());
		people.add( north, "North" );
		people.add( new JLabel("Center"), "South" );

		glass.add( people, "Center" );

		glass.add( new JLabel("Victim"), "North" );
		glass.add( south, "South" );
		glass.add( east, "East" );
		glass.add( new JTextArea("W"), "West" );

		setVisible(true);
	}

  	public static void main(String [] args) {
   		gui5 gelatinousCube=new gui5();
	}
}