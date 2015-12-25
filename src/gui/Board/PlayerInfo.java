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
import GameSquares.Cards.Card.CardType;
import Main.Main;
import Main.Player;

public class PlayerInfo extends JPanel {
    
    private static final long serialVersionUID = 1L;
    static JTable             table;
    JScrollPane               pane;
    static String[][]         data;
    
    public PlayerInfo(int size) {
        setLayout(new BorderLayout());
        
        String[] column = { "Player Name", "Location", "Money", "Properties", "Cards", "Stocks" };
        data = new String[Main.players.length][6];
        
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
            String lands = "", cards = "", stocks = "";
            Player crrtPlayer = Main.players[i];
            
            // TODO Should be changed after Ownable + OwnedLands merge
            ArrayList<Ownable> arry = new ArrayList<Ownable>();
            for (Land lnd : crrtPlayer.getOwnedLands())
                arry.add(lnd);
            for (Ownable ows : crrtPlayer.getOwnedSquares())
                arry.add(ows);
            for (int j = 0; j < arry.size(); j++)
                if (j > 0)
                    lands += " - " + arry.get(j).getID();
                else
                    lands += arry.get(j).getID();
            
            ArrayList<CardType> arrys = crrtPlayer.getCardsInventory();
            int goj = 0, op = 0;
            for (CardType crdty : arrys) {
                switch (crdty) {
                    case GetOutOfJail:
                        goj++;
                        break;
                    case OnlinePricing:
                        op++;
                        break;
                    default:
                        break;
                }
            }
            cards = "Jail:" + goj + " - Online:" + op;
            
            int[] stocksArry = crrtPlayer.getStocks();
            stocks = stocksArry[0] + " - " + stocksArry[1] + " - " + stocksArry[2] + " - "
                + stocksArry[3] + " - " + stocksArry[4] + " - " + stocksArry[5];
            
            data[i][0] = ("" + crrtPlayer.getName());
            data[i][1] = ("" + crrtPlayer.getLocation());
            data[i][2] = ("" + crrtPlayer.getMoney());
            data[i][3] = (lands);
            data[i][4] = (cards);
            data[i][5] = (stocks);
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
        String[] column = { "Player Name", "Location", "Money", "Properties", "Cards", "Stocks" };
        data = new String[Main.players.length][6];
        
        DefaultTableModel dataModel = new DefaultTableModel(data, column);
        
        table.removeAll();
        table.setModel(dataModel);
        refreshData();
    }
}
