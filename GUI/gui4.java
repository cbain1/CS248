import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;

class dad extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("It's closing time.");
		System.exit(0);
	}
}

class gui4 extends JFrame {

	public gui4() {
		setTitle("GUI4: Our new gooey program!");
		setSize(500,500);
		addWindowListener(new dad());

		//put stuff in the window
		Container glass = getContentPane();
		glass.setLayout(new BorderLayout());

		//glass.add(new JButton("Center"), "Center");
		JPanel people = new JPanel();
		people.setLayout(new BorderLayout());
		people.add(new JButton("Center"),"North");
		people.add(new JLabel("Center"),"South");

		glass.add(people,"Center");
		glass.add(new JLabel("Victims"),"North");
		glass.add(new JTextField("south"),"South");
		glass.add(new JButton("east"),"East");
		glass.add(new JTextArea("west"),"West");

		setVisible(true);
	}
	public static void main(String [] args) {

		gui4 gelatinousCube = new gui4(); 
		
	}
}