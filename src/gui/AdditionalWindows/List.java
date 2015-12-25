package gui.AdditionalWindows;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import GameSquares.Cab;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Ownable;
import GameSquares.Land.state;
import GameSquares.Utility;
import java.awt.event.*;
import java.awt.*;

// ListDemo.java requires no other files.
public class List extends JPanel implements ListSelectionListener, ActionListener {
    
    private static final long            serialVersionUID = 1L;
    private JList<GameSquare>            list;
    private DefaultListModel<GameSquare> listModel;
    private JButton                      sellButton, mortgageButton;
    ArrayList<GameSquare>                squares;
    private JLabel                       label;
    
    public List(ArrayList<GameSquare> squares) {
        super(new BorderLayout());
        
        this.squares = squares;
        
        list = new JList<GameSquare>();
        listModel = new DefaultListModel<GameSquare>();
        
        for (GameSquare a : squares) {
            listModel.addElement(a);
        }
        
        if (!(squares.isEmpty())) {
            label = new JLabel(squares.get(0).toString());
        } else
            label = new JLabel();
        
        
        
        // Create the list and put it in a scroll pane.
        list = new JList<GameSquare>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(12);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(((int) listScrollPane.getPreferredSize().getWidth() + 20),
            ((int) listScrollPane.getPreferredSize().getHeight())));
        
        sellButton = new JButton("SELL");
        sellButton.setActionCommand("SELL");
        sellButton.addActionListener(this);
        
        mortgageButton = new JButton("MORTGAGE");
        mortgageButton.setActionCommand("MORTGAGE");
        mortgageButton.addActionListener(this);
        
        add(listScrollPane, BorderLayout.WEST);
        label.setPreferredSize(new Dimension(((int) label.getPreferredSize().getWidth()), ((int) label
            .getPreferredSize().getHeight())));
        add(label);
        add(sellButton, BorderLayout.AFTER_LAST_LINE);
        add(mortgageButton, BorderLayout.NORTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sellButton) {
            int index = list.getSelectedIndex();
            GameSquare a = list.getSelectedValue();
            
            if (a instanceof Ownable) {
                if (!(a == null))
                    if (a instanceof Land) {
                        if (((Land) a).getState() == state.unImproved) {
                            ((Land) a).sell();
                            if (index != -1) listModel.remove(index);
                        } else {
                            ((Land) a).downgrade();
                            
                        }
                    } else {
                        ((Ownable) a).sell();
                        if (index != -1) listModel.remove(index);
                    }
                
                
                
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
        } else if (e.getSource() == mortgageButton) {
            int index = list.getSelectedIndex();
            GameSquare a = list.getSelectedValue();
            
            if (a instanceof Land) {
                
                if (((Land) a).getState() == state.mortgage) {
                    if (!(a == null)) ((Land) a).leaveMortgage();
                    
                } else {
                    
                    if (!(a == null)) ((Land) a).mortgage();
                    
                    if (index == listModel.getSize()) {
                        // removed item in last position
                        index--;
                    }
                    
                    list.setSelectedIndex(index);
                    list.ensureIndexIsVisible(index);
                }
            } else if (a instanceof Cab) {
                if (((Cab) a).isMortgaged()) {
                    if (!(a == null)) ((Cab) a).leaveMortgage();
                } else {
                    if (!(a == null)) ((Cab) a).mortgage();
                    
                    if (index == listModel.getSize()) {
                        index--;
                    }
                }
            } else if (a instanceof Utility) {
                if (((Utility) a).isMortgaged()) {
                    if (!(a == null)) ((Utility) a).leaveMortgage();
                } else {
                    if (!(a == null)) ((Utility) a).mortgage();
                    
                    if (index == listModel.getSize()) {
                        index--;
                    }
                }
            }
        }
        
    }
    
    public void valueChanged(ListSelectionEvent e) {
        
        // BURAYA DOKUNMA LABEL DEGISIYR SADECE
        
        GameSquare a = list.getSelectedValue();
        
        if (!(a == null)) {
            if (a instanceof Land)
                label.setText(((Land) a).toString2());
            else
                label.setText(a.toString());
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
    
    
    @SuppressWarnings("unchecked")
    public static void createAndShowGUI(ArrayList<?> ownables) {
        // Create and set up the window.
        if (ownables != null) {
            JFrame frame = null;
            frame = new JFrame("Owned properties to Sell");
            List a = new List((ArrayList<GameSquare>) ownables);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.add(a);
            frame.setSize(380, 280);
            frame.setVisible(true);
        }
        
    }
}
