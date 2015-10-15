package gui;

import javax.swing.JOptionPane;

public class BuyLocation {
	Boolean	getAnswer;
	
	public BuyLocation(String LandName, int LandCost) {
		int reply = JOptionPane.showConfirmDialog(null, "For " + LandCost + " dollars",
			("Would you like to buy " + LandName + " ?"),
			JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			getAnswer = true;
			JOptionPane.showMessageDialog(null, "You bought it.");
		}
		else {
			JOptionPane.showMessageDialog(null, "You didn't buy it.");
			getAnswer = false;
		}
	}
	
	public boolean getValue() {
		return getAnswer;
	}
	
	public static void main(String args[]) {
		new BuyLocation("asd", 2333);
		
	}
}