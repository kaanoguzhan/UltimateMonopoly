package gui;

import javax.swing.JOptionPane;

public class GetSimpleInput {
	JOptionPane	pane;
	String		getAnswer;
	
	public GetSimpleInput(String question) {
		getAnswer = JOptionPane.showInputDialog(null, question);
	}
	
	public String value() {
		return getAnswer;
	}
}
