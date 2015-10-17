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
		if (Answer.length() > 0)
			return Integer.parseInt(Answer);
		else
			return 0;
	}
}
