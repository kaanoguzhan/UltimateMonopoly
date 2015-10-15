package gui.AdditionalWindows;

import javax.swing.JOptionPane;

public class GetTextInput {
	JOptionPane	pane;
	String		getAnswer;
	
	public GetTextInput(String question) {
		getAnswer = JOptionPane.showInputDialog(null, question);
	}
	
	public String getValue() {
		return getAnswer;
	}
}
