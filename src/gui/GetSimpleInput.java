package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GetSimpleInput {
	JOptionPane pane;
	String getAnswer;
	
	public GetSimpleInput(String question){
		pane = new JOptionPane();
		getAnswer = pane.showInputDialog(null,question);
		pane.showMessageDialog(null, ("bla bla " + getAnswer));
	
	}
	
	public static void main(String args[]){
		new GetSimpleInput("what upp");
		
		
	}
	
}
