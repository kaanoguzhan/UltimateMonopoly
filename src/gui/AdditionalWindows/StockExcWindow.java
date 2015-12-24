package gui.AdditionalWindows;

import javax.swing.JPanel;
import javax.swing.JButton;

public class StockExcWindow extends JPanel {
    private static final long serialVersionUID = 1L;
    
    public StockExcWindow() {
        setLayout(null);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(44, 116, 89, 23);
        add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBounds(175, 116, 89, 23);
        add(btnNewButton_1);
        
    }
}
