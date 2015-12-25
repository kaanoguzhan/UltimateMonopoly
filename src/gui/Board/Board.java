package gui.Board;

import gui.Debug.Debug;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import GameSquares.GameSquare;
import Main.Player;
import Main.Properties;

public class Board extends JFrame {
    
    private static final long serialVersionUID = 1L;
    Player[]                  players;
    GameSquare[]              gameSquares;
    public RollingTheDice     round            = new RollingTheDice();
    static SquareHolder       squareHolder     = new SquareHolder();
    public static PlayerInfo  informationTable = new PlayerInfo(Properties.DEFAULT_PLAYER_NUMBER);
    private static JLabel     lblBoard;
    static JLabel             zero, one, two, three;
    
    // private int boardlength;
    
    public Board(Player[] players, GameSquare[] gameSquares) {
        super("Monototype");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1640, 1090);
        setVisible(true);
        setLayout(null);
        // setUndecorated(true);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        
        this.players = players;
        this.gameSquares = gameSquares;
        
        zero = new playerIcon("playerIcon1.gif", 650, 660, 50, 40);
        add(zero);
        
        one = new playerIcon("playerIcon2.gif", 625, 660, 50, 40);
        add(one);
        
        two = new playerIcon("playerIcon3.gif", 600, 660, 50, 40);
        add(two);
        
        three = new playerIcon("playerIcon4.gif", 575, 660, 50, 40);
        add(three);
        
        Board.lblBoard = new JLabel(new ImageIcon("board1050.jpg"));
        getContentPane().add(getLblBoard());
        
        
        JButton debug = new JButton("Debug Window");
        getContentPane().add(debug);
        debug.addActionListener(al -> {
            Debug frame = new Debug();
            frame.setVisible(true);
        });
        
        if (height < 1000) {
            // boardlength = 700;
            lblBoard.setBounds(0, 0, 700, 700);
            round.setBounds(750, 11, 800, 250);
            informationTable.setBounds(760, 272, 550, 350);
            debug.setBounds(760, 630, 120, 70);
        } else {
            // boardlength = 1050;
            lblBoard.setBounds(0, 0, 1050, 1050);
            round.setBounds(1060, 11, 800, 250);
            informationTable.setBounds(1060, 272, 550, 350);
            debug.setBounds(1490, 630, 120, 70);
        }
        getContentPane().add(round);
        getContentPane().add(informationTable);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void setCurrentPlayer(Player player) {
        round.setCurrentPlayer(player);
    }
    public static JLabel getLblBoard() {
        return lblBoard;
    }
    public static void setLblBoard(JLabel lblBoard) {
        Board.lblBoard = lblBoard;
    }
    
    public void setPlayerTurnLabel(String string) {
        round.setPlayerTurnLabel(string);
    }
    
    public void initiateLoadProtection() {
        round.initiateLoadProtection();
    }
    
    public void reduceLoadProtection() {
        round.reduceLoadProtection();
    }
}


class playerIcon extends JLabel {
    private static final long serialVersionUID = 1L;
    
    playerIcon(String imageName, int x, int y, int height, int width) {
        super(new ImageIcon(imageName));
        super.setBounds(x, y, height, width);
    }
}
