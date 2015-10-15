package gui.AdditionalWindows.InputReaders;

import javax.swing.JOptionPane;

public class GetTextInput {
	JOptionPane	pane;
	String		Answer;
	
	public GetTextInput(String question) {
		Answer = JOptionPane.showInputDialog(null, question);
	}
	
	public String getString() {
		return Answer;
	}
	
	public int getInt() {
		return Integer.parseInt(Answer);
	}
}
