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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Board extends JFrame {
    
    private static final long serialVersionUID = 1L;
    Player[]                  players;
    GameSquare[]              gameSquares;
    public RollingTheDice     round            = new RollingTheDice();
    static SquareHolder       squareHolder     = new SquareHolder();
    public static PlayerInfo  informationTable = new PlayerInfo(Properties.DEFAULT_PLAYER_NUMBER);
    private static JLabel     lblBoard;
    static JLabel             zero, one, two, three, lblPool;
    
    // private int boardlength;
    
    public Board(Player[] players, GameSquare[] gameSquares) {
        super("Monototype");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1640, 1090);
        setVisible(true);
        getContentPane().setLayout(null);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        
        this.players = players;
        this.gameSquares = gameSquares;
        
        zero = new playerIcon("playerIcon1.gif", 480, 475, 50, 40);
        getContentPane().add(zero);
        
        one = new playerIcon("playerIcon2.gif", 520, 475, 50, 40);
        getContentPane().add(one);
        
        two = new playerIcon("playerIcon3.gif", 480, 525, 50, 40);
        getContentPane().add(two);
        
        three = new playerIcon("playerIcon4.gif", 520, 525, 50, 40);
        getContentPane().add(three);
        
        lblPool = new JLabel("Pool: 0");
        lblPool.setForeground(new Color(128, 0, 128));
        lblPool.setHorizontalAlignment(SwingConstants.CENTER);
        lblPool.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblPool.setBounds(450, 345, 159, 89);
        getContentPane().add(lblPool);
        
        lblBoard = new JLabel(new ImageIcon("board1050.jpg"));
        getContentPane().add(lblBoard);
        
        JButton debug = new JButton("Debug Window");
        getContentPane().add(debug);
        debug.addActionListener(al -> {
            Debug frame = new Debug();
            frame.setVisible(true);
        });
        debug.setBounds(1728, 972, 120, 70);
        
        round.setBounds(1050, 0, 798, 250);
        informationTable.setBounds(1060, 261, 788, 900);
        lblBoard.setBounds(0, 0, 1050, 1050);
        
        if (height < 1000) {
            // boardlength = 700-;
            lblBoard.setBounds(0, 0, 700, 700);
            round.setBounds(750, 11, 800, 250);
            informationTable.setBounds(760, 272, 550, 350);
            debug.setBounds(760, 630, 120, 70);
        }
        
        JButton button = new JButton("Debug Window");
        button.setBounds(1060, 972, 120, 70);
        getContentPane().add(button);
        getContentPane().add(round);
        getContentPane().add(informationTable);
        
        // Full Screnn
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public void setCurrentPlayer(Player player) {
        round.setCurrentPlayer(player);
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
    
    public static void refreshPoolMoney() {
        lblPool.setText("Pool:" + Main.Main.pool);
    }
}


class playerIcon extends JLabel {
    private static final long serialVersionUID = 1L;
    
    playerIcon(String imageName, int x, int y, int height, int width) {
        super(new ImageIcon(imageName));
        super.setBounds(x, y, height, width);
    }
}
