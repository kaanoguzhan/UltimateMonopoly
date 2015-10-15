package gui.AdditionalWindows;

import javax.swing.JOptionPane;

public class GetYesNoInput {
	Boolean	getAnswer;
	
	public GetYesNoInput(String LandName, int LandCost) {
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
}
