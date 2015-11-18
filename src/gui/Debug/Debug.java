package gui.Debug;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Main.Main;

public class Debug extends JFrame {
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	static PlayerTab			Player1, Player2, Player3, Player4;
	
	public Debug() {
		switch (Main.players.length) {
			case 1:
				setBounds(25, 25, 631, 192);
				break;
			case 2:
				setBounds(25, 25, 631, 343);
				break;
			case 3:
				setBounds(25, 25, 631, 492);
				break;
			default:
				setBounds(25, 25, 631, 655);
				break;
		}
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Consolas", Font.PLAIN, 15));
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 625, 739);
		contentPane.add(tabbedPane);
		
		JPanel Players = new JPanel();
		Players.setBorder(null);
		tabbedPane.addTab("Players", null, Players, null);
		Players.setLayout(null);
		
		
		
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Player 1
		
		JLabel lblPlayerName1 = new JLabel("Player 1");
		lblPlayerName1.setBounds(0, 0, 625, 22);
		lblPlayerName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Players.add(lblPlayerName1);
		
		Player1 = new PlayerTab(0);
		Player1.setBounds(0, 22, 625, 109);
		Players.add(Player1);
		
		
		
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Player 2
		
		JLabel lblPlayerName2 = new JLabel("Player 2");
		lblPlayerName2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName2.setBounds(0, 150, 625, 22);
		Players.add(lblPlayerName2);
		
		Player2 = new PlayerTab(1);
		Player2.setBounds(0, 172, 625, 109);
		Players.add(Player2);
		
		
		
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Player 3
		
		JLabel lblPlayerName3 = new JLabel("Player 3");
		lblPlayerName3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName3.setBounds(0, 300, 625, 22);
		Players.add(lblPlayerName3);
		
		Player3 = new PlayerTab(2);
		Player3.setBounds(0, 322, 625, 109);
		Players.add(Player3);
		
		
		
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Player 4
		
		JLabel lblPlayerName4 = new JLabel("Player 4");
		lblPlayerName4.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerName4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName4.setBounds(0, 450, 625, 22);
		Players.add(lblPlayerName4);
		
		Player4 = new PlayerTab(3);
		Player4.setBounds(0, 475, 625, 109);
		Players.add(Player4);
		
		
		
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		BoardTab panel = new BoardTab();
		tabbedPane.addTab("Board", null, panel, null);
		
		SaveLoadTab slt = new SaveLoadTab();
		tabbedPane.addTab("Save-Load", null, slt, null);
	}
	
	static void refreshLands() {
		Player1.refresh();
		Player2.refresh();
		Player3.refresh();
		Player4.refresh();
	}
}
