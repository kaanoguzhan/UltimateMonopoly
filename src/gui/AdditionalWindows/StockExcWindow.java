package gui.AdditionalWindows;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import GameSquares.StockExchange.stockType;
import Main.Player;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;

public class StockExcWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    
    public StockExcWindow(Player crrtPlayer) {
        setResizable(false);
        getContentPane().setLayout(null);
        setBounds(480, 238, 364, 289);
        
        JLabel lblPlayerGreeting = new JLabel("Welcome " + crrtPlayer.getName() + " to the StockExchange Office.");
        lblPlayerGreeting.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayerGreeting.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPlayerGreeting.setBounds(10, 11, 338, 14);
        getContentPane().add(lblPlayerGreeting);
        JLabel lblMessage = new JLabel("Here are your current Stocks");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMessage.setBounds(10, 34, 338, 14);
        getContentPane().add(lblMessage);
        
        
        JLabel lblStock1 = new JLabel(crrtPlayer.getStockAmount(stockType.AcmeMotors) + "");
        lblStock1.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock1.setBounds(220, 63, 128, 14);
        getContentPane().add(lblStock1);
        
        JLabel lblStock2 = new JLabel(crrtPlayer.getStockAmount(stockType.UnitedRailways) + "");
        lblStock2.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock2.setBounds(220, 97, 128, 14);
        getContentPane().add(lblStock2);
        
        JLabel lblStock3 = new JLabel(crrtPlayer.getStockAmount(stockType.GeneralRadIO) + "");
        lblStock3.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock3.setBounds(220, 130, 128, 14);
        getContentPane().add(lblStock3);
        
        JLabel lblStock4 = new JLabel(crrtPlayer.getStockAmount(stockType.NationalUtilities) + "");
        lblStock4.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock4.setBounds(220, 164, 128, 14);
        getContentPane().add(lblStock4);
        
        JLabel lblStock5 = new JLabel(crrtPlayer.getStockAmount(stockType.AlliedSteamships) + "");
        lblStock5.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock5.setBounds(220, 198, 128, 14);
        getContentPane().add(lblStock5);
        
        JLabel lblStock6 = new JLabel(crrtPlayer.getStockAmount(stockType.MotionPictures) + "");
        lblStock6.setHorizontalAlignment(SwingConstants.CENTER);
        lblStock6.setBounds(220, 232, 128, 14);
        getContentPane().add(lblStock6);
        
        JButton btnStock1 = new JButton("Acme Motors");
        btnStock1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnStock1.setText("Click to Buy");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock1.setText("Acme Motors");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crrtPlayer.buyStock(stockType.AcmeMotors);
                lblStock1.setText((Integer.parseInt(lblStock1.getText()) + 1) + "");
            }
        });
        btnStock1.setBounds(10, 59, 200, 23);
        getContentPane().add(btnStock1);
        
        JButton btnStock2 = new JButton("United Railways");
        btnStock2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock2.setText("Click to Buy");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock2.setText("United Railways");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crrtPlayer.buyStock(stockType.UnitedRailways);
                lblStock2.setText((Integer.parseInt(lblStock2.getText()) + 1) + "");
            }
        });
        btnStock2.setBounds(10, 93, 200, 23);
        getContentPane().add(btnStock2);
        
        JButton btnStock3 = new JButton("General RadI/O");
        btnStock3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock3.setText("Click to Buy");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock3.setText("General RadI/O");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crrtPlayer.buyStock(stockType.GeneralRadIO);
                lblStock3.setText((Integer.parseInt(lblStock3.getText()) + 1) + "");
            }
        });
        btnStock3.setBounds(10, 126, 200, 23);
        getContentPane().add(btnStock3);
        
        JButton btnStock4 = new JButton("National Utilities");
        btnStock4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock4.setText("Click to Buy");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock4.setText("National Utilities");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crrtPlayer.buyStock(stockType.NationalUtilities);
                lblStock4.setText((Integer.parseInt(lblStock4.getText()) + 1) + "");
            }
        });
        btnStock4.setBounds(10, 160, 200, 23);
        getContentPane().add(btnStock4);
        
        JButton btnStock5 = new JButton("Allied Steamships");
        btnStock5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock5.setText("Click to Buy");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock5.setText("Allied Steamships");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crrtPlayer.buyStock(stockType.AlliedSteamships);
                lblStock5.setText((Integer.parseInt(lblStock5.getText()) + 1) + "");
            }
        });
        btnStock5.setBounds(10, 194, 200, 23);
        getContentPane().add(btnStock5);
        
        JButton btnStock6 = new JButton("Motion Pictures");
        btnStock6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock6.setText("Click to Buy");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock6.setText("Motion Pictures");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crrtPlayer.buyStock(stockType.MotionPictures);
                lblStock6.setText((Integer.parseInt(lblStock6.getText()) + 1) + "");
            }
        });
        btnStock6.setBounds(10, 228, 200, 23);
        getContentPane().add(btnStock6);
        
    }
}
