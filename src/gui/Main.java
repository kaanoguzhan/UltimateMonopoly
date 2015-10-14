package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener{
	JLabel zero,one,two,three;
	
  public Main() {
    super("Monototype");  
    setLayout(null);

    ImageIcon image0= new ImageIcon("0.gif");
    zero = new JLabel(image0);
    add(zero);
    zero.setBounds(650-115, 663, 50,40);
    
    ImageIcon image1= new ImageIcon("1.gif");
    one = new JLabel(image1);
    add(one);
    one.setBounds(625-115, 660, 50,40);
    
    ImageIcon image2= new ImageIcon("2.gif");
    two = new JLabel(image2);
    add(two);
    two.setBounds(606-115, 660, 50,40);
    
    ImageIcon image3= new ImageIcon("3.gif");
    three = new JLabel(image3);
    add(three);
    three.setBounds(50, 475, 50,40);
    
    dice d = new dice(zero); // simdilik zero verdim, oynayana gore degis
    d.setBounds(720, 0, 200, 200);
    add(d);
    
    JButton debug = new JButton("Debug Window");
    debug.setBounds(950,630,120,70);
    add(debug);
    debug.addActionListener(this);
    
    ImageIcon image= new ImageIcon("board.jpg");
	JLabel labelForimage = new JLabel(image);
	
	PlayerInfo p = new PlayerInfo();
	p.setBounds(720,200,550,350);
	add(p);
	
	add(labelForimage);
	labelForimage.setBounds(0, 0, 700, 700);
	
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//  this.setUndecorated(true);

    setVisible(true);
  }

  public static void main(String[] args) {
    new Main();
    
    
    
  }


public void actionPerformed(ActionEvent e) {
	debug a = new debug();
	
	a.setSize(420,420);
	a.setVisible(true);
	a.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
}
}