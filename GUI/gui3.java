import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;

class dad extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("It's closing time.");
		System.exit(0);
	}
}

class gui3 extends JFrame {

	public gui3() {
		setTitle("GUI3: Our new gooey program!");
		setSize(500,500);
		addWindowListener(new dad());

		//put stuff in the window
		Container glass = getContentPane();
		glass.add(new JLabel("Victims"));

		setVisible(true);
	}
	public static void main(String [] args) {

		gui3 gelatinousCube = new gui3(); 
		
	}
}