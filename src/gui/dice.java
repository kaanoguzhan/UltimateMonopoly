package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dice extends JPanel implements ActionListener{
	
	private JLabel result;
	private JLabel dice;
	private JButton button;
    public dice() { 
    	setLayout(null);
    	
        button = new JButton();
        dice = new JLabel();
        result = new JLabel();     
        
        Image boardImage = new ImageIcon("dice.png").getImage();
    	dice = new JLabel(new ImageIcon(boardImage));
    	dice.setBounds(7, 10, ((int) dice.getPreferredSize().getWidth()),( (int)dice.getPreferredSize().getHeight()));
    	add(dice);
    	
        result.setText("result is: ");    
        result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize().getHeight()));
        add(result);
        
        button.addActionListener(this);
        button.setText("Roll");
        button.setBounds(7, 75, ((int) button.getPreferredSize().getWidth()), ((int) button.getPreferredSize().getHeight()));
        add(button);
    }  

    public static void main(String args[]){
    	JFrame b = new JFrame();
    	dice a = new dice();
    	
    	b.setSize(200, 200);
    	b.add(a);
    	b.setVisible(true);
    	b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	
    }

	
	public void actionPerformed(ActionEvent arg0) {
		// DICE AT BURDA ABIZI
		result.setText("dice rolled :");
		result.setBounds(7, 115, ((int) result.getPreferredSize().getWidth()), ((int) result.getPreferredSize().getHeight()));
		
	}
    
}
    
    
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//    	Dice d = new Dice();
//    	int a = d.roll();
//    	int b = d.roll();
//        jLabel2.setText("" + a + " - " + b);
//        
//        Firstgui gui = new Firstgui();
//    	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	gui.setSize(1000,1000);
//    	gui.setVisible(true);
//    	gui.setTitle("Learnin");
//        
//        jButton1.setEnabled(false);
//    }                                       

    
