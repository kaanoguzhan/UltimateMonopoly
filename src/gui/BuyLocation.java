package gui;

import javax.swing.JOptionPane;

public class BuyLocation {

	public BuyLocation(String location){
		
		 int reply = JOptionPane.showConfirmDialog(null, "For blabla dollars", ("Would you like to buy " + location), JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	          JOptionPane.showMessageDialog(null, "HELLO");
	          System.out.println("money --");
	        }
	        else {
	           JOptionPane.showMessageDialog(null, "GOODBYE");
	           System.out.println("nope");
	           System.exit(0);
	        }
		
	}
	
	public static void main(String args[]){
		new BuyLocation("yaprak");
		
	}
	
}
