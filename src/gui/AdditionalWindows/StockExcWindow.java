package gui.AdditionalWindows;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import GameSquares.StockExchange.stockType;
import Main.Player;
import Main.Properties;

public class StockExcWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel            pnlStocks;
    JLabel                    lblCloseTimer, lblCya;
    
    public StockExcWindow(Player crrtPlayer) {
        setResizable(false);
        getContentPane().setLayout(null);
        setBounds(480, 238, 364, 289);
        
        JLabel lblPlayerGreeting = new JLabel("Welcome " + crrtPlayer.getName() + " to the StockExchange Office.");
        lblPlayerGreeting.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPlayerGreeting.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayerGreeting.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPlayerGreeting.setBounds(10, 8, 338, 20);
        getContentPane().add(lblPlayerGreeting);
        
        lblCya = new JLabel("Thank you for your purchease");
        lblCya.setBounds(10, 36, 338, 14);
        lblCya.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblCya.setHorizontalAlignment(SwingConstants.CENTER);
        lblCya.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblCya.setVisible(false);
        getContentPane().add(lblCya);
        lblCloseTimer = new JLabel("New label");
        lblCloseTimer.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblCloseTimer.setHorizontalAlignment(SwingConstants.TRAILING);
        lblCloseTimer.setBounds(10, 62, 342, 14);
        lblCloseTimer.setVisible(false);
        getContentPane().add(lblCloseTimer);
        
        pnlStocks = new JPanel();
        pnlStocks.setBounds(0, 0, 358, 260);
        getContentPane().add(pnlStocks);
        pnlStocks.setLayout(null);
        JLabel lblMessage = new JLabel("Here are your current Stocks");
        lblMessage.setBounds(10, 35, 338, 14);
        pnlStocks.add(lblMessage);
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel lblStock1 = new JLabel(crrtPlayer.getStockAmount(stockType.AcmeMotors) + "");
        lblStock1.setBounds(220, 63, 128, 14);
        pnlStocks.add(lblStock1);
        lblStock1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblStock2 = new JLabel(crrtPlayer.getStockAmount(stockType.UnitedRailways) + "");
        lblStock2.setBounds(220, 97, 128, 14);
        pnlStocks.add(lblStock2);
        lblStock2.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblStock3 = new JLabel(crrtPlayer.getStockAmount(stockType.GeneralRadIO) + "");
        lblStock3.setBounds(220, 131, 128, 14);
        pnlStocks.add(lblStock3);
        lblStock3.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblStock4 = new JLabel(crrtPlayer.getStockAmount(stockType.NationalUtilities) + "");
        lblStock4.setBounds(220, 165, 128, 14);
        pnlStocks.add(lblStock4);
        lblStock4.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblStock5 = new JLabel(crrtPlayer.getStockAmount(stockType.AlliedSteamships) + "");
        lblStock5.setBounds(220, 199, 128, 14);
        pnlStocks.add(lblStock5);
        lblStock5.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblStock6 = new JLabel(crrtPlayer.getStockAmount(stockType.MotionPictures) + "");
        lblStock6.setBounds(220, 233, 128, 14);
        pnlStocks.add(lblStock6);
        lblStock6.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton btnStock1 = new JButton("Acme Motors");
        btnStock1.setBounds(10, 59, 200, 23);
        btnStock1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                btnStock1.setText("Click to buy Acme Motors");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock1.setText("Acme Motors");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                disableBuying("Acme Motors");
                crrtPlayer.buyStock(stockType.AcmeMotors);
                lblStock1.setText((Integer.parseInt(lblStock1.getText()) + 1) + "");
            }
        });
        pnlStocks.add(btnStock1);
        
        JButton btnStock2 = new JButton("United Railways");
        btnStock2.setBounds(10, 93, 200, 23);
        btnStock2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock2.setText("Click to buy United Railways");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock2.setText("United Railways");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                disableBuying("United Railways");
                crrtPlayer.buyStock(stockType.UnitedRailways);
                lblStock2.setText((Integer.parseInt(lblStock2.getText()) + 1) + "");
            }
        });
        pnlStocks.add(btnStock2);
        
        JButton btnStock3 = new JButton("General RadI/O");
        btnStock3.setBounds(10, 127, 200, 23);
        btnStock3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock3.setText("Click to buy General RadI/O");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock3.setText("General RadI/O");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                disableBuying("General RadI/O");
                crrtPlayer.buyStock(stockType.GeneralRadIO);
                lblStock3.setText((Integer.parseInt(lblStock3.getText()) + 1) + "");
            }
        });
        pnlStocks.add(btnStock3);
        
        JButton btnStock4 = new JButton("National Utilities");
        btnStock4.setBounds(10, 161, 200, 23);
        btnStock4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock4.setText("Click to buy National Utilities");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock4.setText("National Utilities");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                disableBuying("National Utilities");
                crrtPlayer.buyStock(stockType.NationalUtilities);
                lblStock4.setText((Integer.parseInt(lblStock4.getText()) + 1) + "");
            }
        });
        pnlStocks.add(btnStock4);
        
        JButton btnStock5 = new JButton("Allied Steamships");
        btnStock5.setBounds(10, 195, 200, 23);
        btnStock5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock5.setText("Click to buy Allied Steamships");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock5.setText("Allied Steamships");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                disableBuying("Allied Steamships");
                crrtPlayer.buyStock(stockType.AlliedSteamships);
                lblStock5.setText((Integer.parseInt(lblStock5.getText()) + 1) + "");
            }
        });
        pnlStocks.add(btnStock5);
        
        JButton btnStock6 = new JButton("Motion Pictures");
        btnStock6.setBounds(10, 229, 200, 23);
        btnStock6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnStock6.setText("Click to buy Motion Pictures");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnStock6.setText("Motion Pictures");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                disableBuying("Motion Pictures");
                crrtPlayer.buyStock(stockType.AlliedSteamships);
                lblStock6.setText((Integer.parseInt(lblStock6.getText()) + 1) + "");
            }
        });
        pnlStocks.add(btnStock6);
    }
    
    private void disableBuying(String stockName) {
        pnlStocks.setVisible(false);
        lblCloseTimer.setVisible(true);
        lblCya.setVisible(true);
        lblCya.setText(stockName + "Thanks you for your purchease.");
        
        Runnable windowSrink = () -> {
            for (int i = 260; i > 106; i--) {
                this.setBounds(this.getBounds().x, this.getBounds().y, this.getBounds().width, i);
                try {
                    Thread.sleep(5 - i / (50));
                } catch (InterruptedException e) {}
            }
        };
        Runnable windowCloseTimer = () -> {
            for (int i = Properties.AUTOCLOSE_TIMEOUT; i > 0; i--) {
                lblCloseTimer.setText("Screen will autoclose in " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
            this.dispose();
        };
        new Thread(windowCloseTimer).start();
        new Thread(windowSrink).start();
    }
}
