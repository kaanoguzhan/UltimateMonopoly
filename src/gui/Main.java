package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame {
  public Main() {
    super("JLayeredPane Demo");

    setLayout(null);

    ImageIcon image0= new ImageIcon("0.gif");
    JLabel zero = new JLabel(image0);
    add(zero);
    zero.setBounds(650-115, 663, 50,40);
    
    ImageIcon image1= new ImageIcon("1.gif");
    JLabel one = new JLabel(image1);
    add(one);
    one.setBounds(625-115, 660, 50,40);
    
    ImageIcon image2= new ImageIcon("2.gif");
    JLabel two = new JLabel(image2);
    add(two);
    two.setBounds(606-115, 660, 50,40);
    
    ImageIcon image3= new ImageIcon("3.gif");
    JLabel three = new JLabel(image3);
    add(three);
    three.setBounds(50, 475, 50,40);
    
    ImageIcon image= new ImageIcon("board.jpg");
	JLabel labelForimage = new JLabel(image);
		
	add(labelForimage);
	labelForimage.setBounds(0, 0, 700, 700);
	
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(750, 750);
    
    setVisible(true);
  }

  public static void main(String[] args) {
    new Main();
  }
}