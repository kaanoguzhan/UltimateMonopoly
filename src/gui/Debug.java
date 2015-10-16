package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

import Main.Admin;
import Main.Main;
import Main.Player;

public class Debug extends JFrame implements ActionListener {
	
	private static final long	serialVersionUID	= 1L;
	private JTextField			moneyField1, locationField1, cardField1, moneyField2, locationField2, cardField2;
	private JTextField			moneyField3, locationField3, cardField3, moneyField4, locationField4, cardField4;
	private JButton				set, plus, minus, plus2, minus2, plus3, minus3, plus4, minus4;
	private JLabel				identifier, moneyLabel, locationLabel, cardLabel, identifier2, moneyLabel2,
								locationLabel2, cardLabel2;
	private JLabel				identifier3, moneyLabel3, locationLabel3, cardLabel3, identifier4, moneyLabel4,
								locationLabel4, cardLabel4;
	
	private Player[]			players				= Main.players;
	
	public Debug() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		plus = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 1;
		add(plus, c);
		
		minus = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 1;
		add(minus, c);
		
		moneyField1 = new JTextField(Integer.toString(players[0].getMoney()), 10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 3;
		add(moneyField1, c);
		
		locationField1 = new JTextField(Integer.toString(players[0].getLocation()), 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		add(locationField1, c);
		
		cardField1 = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		add(cardField1, c);
		
		identifier = new JLabel("   	-1st player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		add(identifier, c);
		
		moneyLabel = new JLabel("Money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		add(moneyLabel, c);
		
		locationLabel = new JLabel("Location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		add(locationLabel, c);
		
		cardLabel = new JLabel("Give Ownership: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		add(cardLabel, c);
		
		// 2nd player
		
		plus2 = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 5;
		add(plus2, c);
		
		minus2 = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 5;
		add(minus2, c);
		
		moneyField2 = new JTextField(Integer.toString(players[1].getMoney()), 10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 3;
		add(moneyField2, c);
		
		locationField2 = new JTextField(Integer.toString(players[1].getLocation()), 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		add(locationField2, c);
		
		cardField2 = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		add(cardField2, c);
		
		identifier2 = new JLabel("   	-2nd player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		add(identifier2, c);
		
		moneyLabel2 = new JLabel("Money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		add(moneyLabel2, c);
		
		locationLabel2 = new JLabel("Location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		add(locationLabel2, c);
		
		cardLabel2 = new JLabel("Give Ownership: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 7;
		add(cardLabel2, c);
		
		// 3rd player
		
		plus3 = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 9;
		add(plus3, c);
		
		minus3 = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 9;
		add(minus3, c);
		
		moneyField3 = new JTextField(Integer.toString(players[2].getMoney()), 10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 9;
		c.gridwidth = 3;
		add(moneyField3, c);
		
		locationField3 = new JTextField(Integer.toString(players[2].getLocation()), 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 10;
		add(locationField3, c);
		
		cardField3 = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 11;
		add(cardField3, c);
		
		identifier3 = new JLabel("   	-3rd player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 8;
		add(identifier3, c);
		
		moneyLabel3 = new JLabel("Money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 9;
		add(moneyLabel3, c);
		
		locationLabel3 = new JLabel("Location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 10;
		add(locationLabel3, c);
		
		cardLabel3 = new JLabel("Give Ownership: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 11;
		add(cardLabel3, c);
		
		// 4th player
		
		plus4 = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 13;
		add(plus4, c);
		
		minus4 = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6;
		c.gridy = 13;
		add(minus4, c);
		
		moneyField4 = new JTextField(Integer.toString(players[3].getMoney()), 10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 13;
		c.gridwidth = 3;
		add(moneyField4, c);
		
		locationField4 = new JTextField(Integer.toString(players[3].getLocation()), 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 14;
		add(locationField4, c);
		
		cardField4 = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 15;
		add(cardField4, c);
		
		identifier4 = new JLabel("   	-4th player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 12;
		add(identifier4, c);
		
		moneyLabel4 = new JLabel("Money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 13;
		add(moneyLabel4, c);
		
		locationLabel4 = new JLabel("Location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 14;
		add(locationLabel4, c);
		
		cardLabel4 = new JLabel("Give Ownership: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 15;
		add(cardLabel4, c);
		// set
		
		set = new JButton("SET");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 16;
		c.gridwidth = 6;
		add(set, c);
		
		plus.addActionListener(this);
		plus2.addActionListener(this);
		plus3.addActionListener(this);
		plus4.addActionListener(this);
		
		minus.addActionListener(this);
		minus2.addActionListener(this);
		minus3.addActionListener(this);
		minus4.addActionListener(this);
		
		set.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int money, money2, money3, money4;
		money = Integer.parseInt(moneyField1.getText());
		money2 = Integer.parseInt(moneyField2.getText());
		money3 = Integer.parseInt(moneyField3.getText());
		money4 = Integer.parseInt(moneyField4.getText());
		
		if (e.getSource() == plus) {
			money += 5000;
			moneyField1.setText("" + money);
		} else if (e.getSource() == plus2) {
			money2 += 5000;
			moneyField2.setText("" + money2);
		} else if (e.getSource() == plus3) {
			money3 += 5000;
			moneyField3.setText("" + money3);
		} else if (e.getSource() == plus4) {
			money4 += 5000;
			moneyField4.setText("" + money4);
		} else if (e.getSource() == minus) {
			if (money > 5000) money -= 5000;
			moneyField1.setText("" + money);
		} else if (e.getSource() == minus2) {
			if (money2 > 5000) money2 -= 5000;
			moneyField2.setText("" + money2);
		} else if (e.getSource() == minus3) {
			if (money3 > 5000) money3 -= 5000;
			moneyField3.setText("" + money3);
		} else if (e.getSource() == minus4) {
			if (money4 > 5000) money4 -= 5000;
			moneyField4.setText("" + money4);
		} else if (e.getSource() == set) {
			setAction();
			this.dispose();
		}
	}
	
	private void setAction() {  
		players[0].setMoney(Integer.parseInt(moneyField1.getText()));
		players[1].setMoney(Integer.parseInt(moneyField2.getText()));
		players[2].setMoney(Integer.parseInt(moneyField3.getText()));
		players[3].setMoney(Integer.parseInt(moneyField4.getText()));
		
		int x,y,location;
		
		location = Integer.parseInt(locationField1.getText());
		x = Board.squareHolder.getSquare(location).getX() - (players[0].getID() * 25);
		y = Board.squareHolder.getSquare(location).getY();
		Admin.movePlayerTo(players[0], location); //change me to movePlayerToforced
		Board.zero.setBounds(x, y, 50, 40);
		
		location = Integer.parseInt(locationField2.getText());
		x = Board.squareHolder.getSquare(location).getX() - (players[1].getID() * 25);
		y = Board.squareHolder.getSquare(location).getY();
		Admin.movePlayerTo(players[1], location); //change me to movePlayerToforced
		Board.one.setBounds(x, y, 50, 40);
		
		location = Integer.parseInt(locationField3.getText());
		x = Board.squareHolder.getSquare(location).getX() - (players[2].getID() * 25);
		y = Board.squareHolder.getSquare(location).getY();
		Admin.movePlayerTo(players[2], location); //change me to movePlayerToforced
		Board.two.setBounds(x, y, 50, 40);
		
		location = Integer.parseInt(locationField4.getText());
		x = Board.squareHolder.getSquare(location).getX() - (players[3].getID() * 25);
		y = Board.squareHolder.getSquare(location).getY();
		Admin.movePlayerTo(players[3], location); //change me to movePlayerToforced
		Board.three.setBounds(x, y, 50, 40);
		
		StringTokenizer st = new StringTokenizer(cardField1.getText()," ,-");
		while(st.hasMoreTokens()){
			int currentLand = Integer.parseInt((String) st.nextToken());
			Admin.giveOwnership(players[0], currentLand);
		}
		
		st = new StringTokenizer(cardField2.getText()," ,-");
		while(st.hasMoreTokens()){
			int currentLand = Integer.parseInt((String) st.nextToken());
			Admin.giveOwnership(players[1], currentLand);
		}
		
		st = new StringTokenizer(cardField3.getText()," ,-");
		while(st.hasMoreTokens()){
			int currentLand = Integer.parseInt((String) st.nextToken());
			Admin.giveOwnership(players[2], currentLand);
		}
		
		st = new StringTokenizer(cardField4.getText()," ,-");
		while(st.hasMoreTokens()){
			int currentLand = Integer.parseInt((String) st.nextToken());
			Admin.giveOwnership(players[3], currentLand);
		}
		
		Board.informationTable.refreshData();
		Board.informationTable.validate();
	}
	
}
