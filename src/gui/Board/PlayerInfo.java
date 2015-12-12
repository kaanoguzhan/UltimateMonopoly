package gui.Board;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import GameSquares.Land;
import GameSquares.Ownable;
import Main.Main;
import Main.Player;

public class PlayerInfo extends JPanel {
    
    private static final long serialVersionUID = 1L;
    static JTable             table;
    JScrollPane               pane;
    static String[][]         data;
    
    public PlayerInfo(int size) {
        setLayout(new BorderLayout());
        
        String[] column = { "Player Name", "Location", "Money", "Properties" };
        data = new String[Main.players.length][4];
        
        table = new JTable(data, column);
        table.setFillsViewportHeight(true);
        refreshData();
        resizeColumnWidth(table);
        
        pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }
    
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int x = 0; x < table.getColumnCount(); x++) {
            int width = 50;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, x);
                Component comp = table.prepareRenderer(renderer, row, x);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(x).setPreferredWidth(width);
        }
    }
    
    public static void refreshData() {
        for (int i = 0; i < Main.players.length; i++) {
            Player current = Main.players[i];
            String lands = "";
            
            // TODO Should be changed after Ownable + OwnedLands merge
            ArrayList<Ownable> arry = new ArrayList<Ownable>();
            for (Land lnd : current.getOwnedLands())
                arry.add(lnd);
            for (Ownable ows : current.getOwnedSquares())
                arry.add(ows);
            
            for (int j = 0; j < arry.size(); j++)
                if (j > 0)
                    lands += " - " + arry.get(j).getID();
                else
                    lands += arry.get(j).getID();
            
            data[i][0] = ("" + current.getName());
            data[i][1] = ("" + current.getLocation());
            data[i][2] = ("" + current.getMoney());
            data[i][3] = (lands);
        }
        refreshTable();
        refreshPlayerLocations();
    }
    private static void refreshPlayerLocations() {
        for (int i = 0; i < Main.players.length; i++) {
            Player current = Main.players[i];
            JLabel Player = null;
            switch (current.getID()) {
                case 0:
                    Player = Board.zero;
                    break;
                case 1:
                    Player = Board.one;
                    break;
                case 2:
                    Player = Board.two;
                    break;
                case 3:
                    Player = Board.three;
                    break;
            }
            
            int id = current.getLocation();
            int playerID = current.getID();
            int x, y;
            switch (playerID) {
                case 0:
                    x = Board.squareHolder.getSquare(id).getX() - 28;
                    y = Board.squareHolder.getSquare(id).getY() - 40;
                    break;
                case 1:
                    x = Board.squareHolder.getSquare(id).getX() - 55;
                    y = Board.squareHolder.getSquare(id).getY() - 40;
                    break;
                case 2:
                    x = Board.squareHolder.getSquare(id).getX() - 55;
                    y = Board.squareHolder.getSquare(id).getY() - 13;
                    break;
                case 3:
                    x = Board.squareHolder.getSquare(id).getX() - 28;
                    y = Board.squareHolder.getSquare(id).getY() - 13;
                    break;
                default:
                    x = Board.squareHolder.getSquare(id).getX() - (current.getID() * 30);
                    y = Board.squareHolder.getSquare(id).getY();
                    break;
            }
            
            
            if (Player != null)
                Player.setBounds(x, y, 50, 40);
        }
    }
    
    private static void refreshTable() {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++)
                table.setValueAt(data[i][j], i, j);
        }
    }
    
    public void recreateTable() {
        String[] column = { "Player Name", "Location", "Money", "Properties" };
        data = new String[Main.players.length][4];
            
        DefaultTableModel dataModel = new DefaultTableModel(data, column);
        
        table.removeAll();
        table.setModel(dataModel);
        refreshData();
        
        // table = new JTable(data, column);
        // table.setFillsViewportHeight(true);
        // refreshData();
        // resizeColumnWidth(table);
        //
        // pane = new JScrollPane(table);
        // add(pane, BorderLayout.CENTER);
    }
}
