package gui;

import javax.swing.JOptionPane;

public class GetSimpleInput {
	JOptionPane	pane;
	String		getAnswer;
	
	public GetSimpleInput(String question) {
		getAnswer = JOptionPane.showInputDialog(null, question);
		JOptionPane.showMessageDialog(null, ("bla bla " + getAnswer));
	}
	
	public static void main(String args[]) {
		new GetSimpleInput("what upp");
	}
}
