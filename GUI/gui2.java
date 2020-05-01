import java.io.*;
import javax.swing.*; 
import java.awt.event.*;

class dad extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("It's closing time.");
		System.exit(0);
	}
}

class gui2 extends JFrame {

	public static void main(String [] args) {

		gui2 gelatinousCube = new gui2(); 
		gelatinousCube.setTitle("GUI2: Our new gooey program!");
		gelatinousCube.setSize(500,500);
		gelatinousCube.setVisible(true);
		gelatinousCube.addWindowListener(new dad());
	}
}