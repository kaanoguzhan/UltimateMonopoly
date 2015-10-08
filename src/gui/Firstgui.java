package gui;

import javax.swing.*;
import java.awt.*;

public class Firstgui extends JFrame {

	private JLabel label;
	private JButton button;
	private JTextField textfield;
	
	private ImageIcon image;
	private ImageIcon image2;
	private JLabel labelForimage;
	private JLabel labelForimage2;
	static int a;
	public Firstgui(){
		
		setLayout(new FlowLayout());
		image= new ImageIcon("1.jpg");
		labelForimage = new JLabel(image);
		image2= new ImageIcon("dice.png");
		labelForimage2 = new JLabel(image2);
		add(labelForimage);
		
		add(labelForimage2);		
		label = new JLabel("hello");
		add(label);
		
		textfield = new JTextField(10);
		add(textfield);
		
		button = new JButton("ya");
		add(button);
		
		
		
	}
	
	
	public static void main(String [] args){
	System.out.println(a);
	Firstgui gui = new Firstgui();
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.pack();
	gui.setVisible(true);
	gui.setTitle("Learnin");
	
	
	}
}
