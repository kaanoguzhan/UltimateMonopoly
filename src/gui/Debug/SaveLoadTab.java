package gui.Debug;

import javax.swing.JButton;
import javax.swing.JPanel;
import Main.SaveLoad.SaveLoad;


public class SaveLoadTab extends JPanel {
	private static final long	serialVersionUID	= 1L;
	
	public SaveLoadTab() {
		setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(10, 5, 299, 109);
		btnSave.addActionListener(al -> {
			SaveLoad.save();
		});
		add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(316, 5, 299, 109);
		btnLoad.addActionListener(al -> {
			SaveLoad.load();
		});
		add(btnLoad);
		
	}
	
}
