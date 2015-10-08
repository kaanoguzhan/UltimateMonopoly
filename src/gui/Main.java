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
    
    ((JPanel) getContentPane()).setOpaque(false);
    ImageIcon image2= new ImageIcon("dice.png");
    JLabel backlabel = new JLabel(image2);
    getLayeredPane().add(backlabel, new Integer(Integer.MIN_VALUE));
    backlabel.setBounds(20, 100, 50, 50);
    
    ImageIcon image= new ImageIcon("1.jpg");
	JLabel labelForimage = new JLabel(image);
		
	getLayeredPane().add(labelForimage,new Integer(Integer.MIN_VALUE));
	labelForimage.setBounds(0, 0, 700, 700);
	
   



    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(700, 700);
    
    setVisible(true);
  }

  public static void main(String[] args) {
    new Main();
  }
}