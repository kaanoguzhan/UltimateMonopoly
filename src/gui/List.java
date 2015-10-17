package gui;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import GameSquares.Land;
import java.awt.event.*;
import java.awt.*;

// ListDemo.java requires no other files.
public class List extends JPanel implements ListSelectionListener {
	
	private static final long		serialVersionUID	= 1L;
	private JList<Land>				list;
	private DefaultListModel<Land>	listModel;
	private JButton					sellButton;
	ArrayList<Land>					lands;
	private JLabel					label;
	
	public List(ArrayList<Land> lands) {
		super(new BorderLayout());
		
		this.lands = lands;
		
		list = new JList<Land>();
		listModel = new DefaultListModel<Land>();
		
		for (Land a : lands) {
			listModel.addElement(a);
		}
		label = new JLabel(lands.get(0).toString2());
		// Create the list and put it in a scroll pane.
		list = new JList<Land>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(12);
		JScrollPane listScrollPane = new JScrollPane(list);
		listScrollPane.setPreferredSize(new Dimension(((int) listScrollPane.getPreferredSize().getWidth() + 20),
			((int) listScrollPane.getPreferredSize().getHeight())));
		
		sellButton = new JButton("SELL");
		sellButton.setActionCommand("SELL");
		sellButton.addActionListener(new SellListener());
		
		add(listScrollPane, BorderLayout.WEST);
		label.setPreferredSize(new Dimension(((int) label.getPreferredSize().getWidth()), ((int) label
			.getPreferredSize().getHeight())));
		add(label);
		add(sellButton, BorderLayout.AFTER_LAST_LINE);
	}
	
	class SellListener implements ActionListener {
		
		// BURDA SELL ISLERINI HALLET
		
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();
			Land a = list.getSelectedValue();
			if (!(a == null)) a.sell();
			listModel.remove(index);
			
			int size = listModel.getSize();
			
			if (size == 0) { // Nobody's left, disable firing.
				sellButton.setEnabled(false);
				label.setText(""); // kimse kalmadi bos don veya
				// this.dispose(); ekrani kapatir
				
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
		
		// BURAYA DOKUNMA LABEL DEGISIYR SADECE
		
		Land a = list.getSelectedValue();
		
		if (!(a == null)) {
			label.setText(a.toString2());
			label.setPreferredSize(new Dimension(((int) label.getPreferredSize().getWidth()) + 10, ((int) label
				.getPreferredSize().getHeight())));
		}
		
		if (list.getSelectedIndex() == -1) {
			// No selection, disable sell button.
			sellButton.setEnabled(false);
			
		} else {
			// Selection, enable the sell button.
			sellButton.setEnabled(true);
		}
	}
	
	
	public static void createAndShowGUI(ArrayList<Land> lands) {
		// Create and set up the window.
		List a = new List(lands);
		JFrame frame = new JFrame("Lands to Sell");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.add(a);
		frame.setSize(380, 280);
		frame.setVisible(true);
	}
	
}
