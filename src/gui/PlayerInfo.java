package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class PlayerInfo extends JPanel{

	private static final long serialVersionUID = 1L; 
	JTable table;
	JScrollPane pane;
	String a = "yoyo";
	String[][] data;
	
	public PlayerInfo(){	
		setLayout(new BorderLayout());
		
		String[]   column = {"Player Name", "Location", "Money","Properties"};
		data = new String[4][4];
		generateData(data);
		
		table = new JTable(data,column);		
		table.setFillsViewportHeight(true);
		resizeColumnWidth(table);
		
		pane = new JScrollPane(table);
		add(pane,BorderLayout.CENTER);
		
	}
	
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int x = 0; x < table.getColumnCount(); x++) {
			int width = 50; 
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, x);
				Component comp = table.prepareRenderer(renderer, row, x);
				width = Math.max(comp.getPreferredSize().width +1 , width);
			}
			columnModel.getColumn(x).setPreferredWidth(width);
		}
	}
	
	 public void generateData(String[][] data){
		 for(int i = 0;i<4;i++){
			 data[i][0] = ("name of "+ i); //player(i).getNAme			
			 data[i][1] = ("location of " + i);
			 data[i][2] = ("money of  " + i);
			 data[i][3] = ("properties of " + i);
		 }
		 
		 
	 }
}

	

