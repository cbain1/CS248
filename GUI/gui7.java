import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class gui7 extends JFrame implements ActionListener {
	class closer extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
		System.out.println("Bye buddy, hope you find your dad.");
		System.exit(0);
		}
	}
	class Fish {
		Color color;
		int size; 
		int x,y;

		public Fish(int x, int y, Color c, int s) { 
			color=c; 
			size=s;
			this.x=x;
			this.y=y;
		}

		public void setRandomColor() {
			color = new Color(
				(int)(256*Math.random()),
				(int)(256*Math.random()),
				(int)(256*Math.random())
			);
		}

		public void swim() {
			x= x-1-size/50;
			if(x+size<=0) x=1000;
		}

		public void draw(Graphics g) {
			g.setColor(color);
			g.fillOval(x,y,size, size/2);
			int [] xlist = {x+2*size/3, x+size, x+size};
			int [] ylist = {y+size/4,y,y+size/2};
			g.fillPolygon(xlist, ylist, 3);

			//eye attempt
			int eyesize = 10+size/15;
			g.setColor(Color.white);
			g.fillOval(x+size/5, y+size/8, eyesize,eyesize);
			g.setColor(Color.black);
			g.fillOval(x+size/5+3, y+size/8+3, eyesize-6, eyesize-6);
		}
	}

	class Ocean extends JPanel {

		Fish [] school;

		public Ocean() {
			school = new Fish[20];
			setSize(1000,600);
			for(int i=0; i<school.length; i++) {
				school[i] = new Fish (
					(int)(1000*Math.random()),
					(int)(500*Math.random()),
					Color.yellow,
					(int)(500*Math.random())
				);
				school[i].setRandomColor();
			}
		}

		public void paintComponent(Graphics g) {
			g.setColor(Color.blue);
			g.fillRect(0, 0, 1000, 600);
			for(int i=0; i<20; i++)
				school[i].draw(g);
		}
		public void swim() {
			for(int i=0; i<school.length; i++) school[i].swim();
		}
		public void setColor(int i ) {school[i].setRandomColor();}
	}

	JButton swim;
	JButton setColor;
	JTextField input;
	Ocean pacific;

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==swim) {
			pacific.swim();
		}
		else {
			String x = input.getText();
			int i = Integer.parseInt(x);
			pacific.setColor(i);
		}
		pacific.repaint();
	}

	public gui7() {

		setTitle("GUI7: The Pacific Ocean");
		setSize(1100,700);
		addWindowListener(new closer());

		swim = new JButton("Swim");
		setColor = new JButton("Set Color");
		input = new JTextField("                                                ");
		pacific = new Ocean();


		swim.addActionListener(this);
		setColor.addActionListener(this);

		// put stuff in the window
		Container glass=getContentPane();
		glass.setLayout(new BorderLayout()); // layout manager

		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		bottom.add(input,"West");
		bottom.add(setColor, "East");

		glass.add(swim,"North");
		glass.add(pacific,"Center");
		glass.add(bottom,"South");
		glass.add(new JPanel(),"East");
		glass.add(new JPanel(),"West");


		setVisible(true);
	}

	public static void main(String [] args) {
		gui7 submarine=new gui7();
	}
}