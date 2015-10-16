package gui;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

import GameSquares.Land;

import java.awt.event.*;
import java.awt.*;

// ListDemo.java requires no other files.
public class List extends JPanel implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JList<Land> list;
	private DefaultListModel<Land> listModel;
	private JButton sellButton;
	private ArrayList<Land> lands;
	private JLabel label;
	
	public List(ArrayList<Land> lands) {
		super(new BorderLayout());
		
		this.lands = lands;
		
		list = new JList<Land>();
		listModel = new DefaultListModel<Land>();

		for(Land a : lands){
			listModel.addElement(a);		
		}
		label = new JLabel("yeaha ++ :: " + lands.get(0).toString());
		// Create the list and put it in a scroll pane.
		list = new JList<Land>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		JScrollPane listScrollPane = new JScrollPane(list);
		listScrollPane.setPreferredSize(new Dimension(100,50));
		
		sellButton = new JButton("SELL");
		sellButton.setActionCommand("SELL");
		sellButton.addActionListener(new FireListener());

		add(listScrollPane,BorderLayout.WEST);
		add(label);
		add(sellButton,BorderLayout.AFTER_LAST_LINE);
	}

	class FireListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			listModel.remove(index);

			int size = listModel.getSize();

			if (size == 0) { // Nobody's left, disable firing.
				sellButton.setEnabled(false);

			} else { // Select an index.
				if (index == listModel.getSize()) {
					// removed item in last position
					index--;
				}

				list.setSelectedIndex(index);
				list.ensureIndexIsVisible(index);
			}
		}
	}

	public void valueChanged(ListSelectionEvent e) {
			Land a = list.getSelectedValue();	
			label.setText(a.toString());
			if (list.getSelectedIndex() == -1) {
				// No selection, disable fire button.
				sellButton.setEnabled(false);
				
			} else {				
				// Selection, enable the fire button.
				sellButton.setEnabled(true);
			}
		}
	

	private static void createAndShowGUI(ArrayList<Land> lands) {
		// Create and set up the window.
		List a = new List(lands); // finna get lands
		JFrame frame = new JFrame("Lands to Sell");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(a);
		// Display the window.
		frame.setSize(400,400);
		frame.setVisible(true);
	}

}
