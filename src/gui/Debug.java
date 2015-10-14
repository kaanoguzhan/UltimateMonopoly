package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Debug extends JFrame implements ActionListener {
	
	private JTextField moneyField,locationField,cardField,moneyField2,locationField2,cardField2;
	private JTextField moneyField3,locationField3,cardField3,moneyField4,locationField4,cardField4;
	private JButton set,plus,minus,plus2,minus2,plus3,minus3,plus4,minus4;
	private JLabel identifier,moneyLabel,locationLabel,cardLabel,identifier2,moneyLabel2,locationLabel2,cardLabel2;
	private JLabel identifier3,moneyLabel3,locationLabel3,cardLabel3,identifier4,moneyLabel4,locationLabel4,cardLabel4;
	
	public Debug(){	
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		plus = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=5;
		c.gridy=1;
		add(plus,c);
		
		minus = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=1;
		add(minus,c);
				
		moneyField=new JTextField("123",10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=1;
		c.gridwidth=3;
		add(moneyField,c);
		
		locationField=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=2;		
		add(locationField,c);
		
		cardField=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=3;	
		add(cardField,c);
		
		identifier = new JLabel("   	-1st player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth=1;
		c.gridx= 0;
		c.gridy = 0;
		add(identifier,c);
		
        moneyLabel = new JLabel("money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 1;
		add(moneyLabel,c);
		
		locationLabel = new JLabel("location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 2;
		add(locationLabel,c);
		
		cardLabel = new JLabel("cards: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 3;
		add(cardLabel,c);
		
		// 2nd player
		
		plus2 = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=5;
		c.gridy=5;
		add(plus2,c);
		
		minus2 = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=5;
		add(minus2,c);
				
		moneyField2=new JTextField("123",10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=5;
		c.gridwidth=3;
		add(moneyField2,c);
		
		locationField2=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=6;		
		add(locationField2,c);
		
		cardField2=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=7;	
		add(cardField2,c);
		
		identifier2 = new JLabel("   	-2nd player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth=1;
		c.gridx= 0;
		c.gridy = 4;
		add(identifier2,c);
		
        moneyLabel2 = new JLabel("money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 5;
		add(moneyLabel2,c);
		
		locationLabel2 = new JLabel("location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 6;
		add(locationLabel2,c);
		
		cardLabel2 = new JLabel("cards: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 7;
		add(cardLabel2,c);
		
		// 3rd player
		
		plus3 = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=5;
		c.gridy=9;
		add(plus3,c);
		
		minus3 = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=9;
		add(minus3,c);
				
		moneyField3=new JTextField("123",10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=9;
		c.gridwidth=3;
		add(moneyField3,c);
		
		locationField3=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=10;		
		add(locationField3,c);
		
		cardField3=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=11;	
		add(cardField3,c);
		
		identifier3 = new JLabel("   	-3rd player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth=1;
		c.gridx= 0;
		c.gridy = 8;
		add(identifier3,c);
		
        moneyLabel3 = new JLabel("money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 9;
		add(moneyLabel3,c);
		
		locationLabel3 = new JLabel("location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 10;
		add(locationLabel3,c);
		
		cardLabel3 = new JLabel("cards: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 11;
		add(cardLabel3,c);
		
		// 4th player
		
		plus4 = new JButton("+");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=5;
		c.gridy=13;
		add(plus4,c);
		
		minus4 = new JButton("-");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=13;
		add(minus4,c);
				
		moneyField4=new JTextField("123",10); // instead of 123- player.getMoney();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=13;
		c.gridwidth=3;
		add(moneyField4,c);
		
		locationField4=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=14;		
		add(locationField4,c);
		
		cardField4=new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy=15;	
		add(cardField4,c);
		
		identifier4 = new JLabel("   	-4th player-  ");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridwidth=1;
		c.gridx= 0;
		c.gridy = 12;
		add(identifier4,c);
		
        moneyLabel4 = new JLabel("money: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 13;
		add(moneyLabel4,c);
		
		locationLabel4 = new JLabel("location: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 14;
		add(locationLabel4,c);
		
		cardLabel4 = new JLabel("cards: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx= 1;
		c.gridy = 15;
		add(cardLabel4,c);
		// set
		
		set = new JButton("SET");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=16;
		c.gridwidth = 6;
		add(set,c);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		int money,money2,money3,money4;
		money  = Integer.parseInt(moneyField.getText());
		money2 = Integer.parseInt(moneyField2.getText());
		money3 = Integer.parseInt(moneyField3.getText());
		money4 = Integer.parseInt(moneyField4.getText());
		
		if(e.getSource() == plus ) {
			money+= 5000;
			moneyField.setText(""+money);
		} else if(e.getSource() == plus2){
			money2+= 5000;
			moneyField2.setText(""+money2);
		} else if(e.getSource() == plus3){
			money3+= 5000;
			moneyField3.setText(""+money3);
		} else if(e.getSource() == plus4){
			money4+= 5000;
			moneyField4.setText(""+money4);
		} else if(e.getSource() == minus){
			if(money >5000) money-= 5000;
			moneyField.setText(""+money);
		} else if(e.getSource() == minus2){
			if(money2 >5000) money2-= 5000;
			moneyField2.setText(""+money2);
		} else if(e.getSource() == minus3){
			if(money3 >5000) money3-= 5000;
			moneyField3.setText(""+money3);
		} else if(e.getSource() == minus4){
			if(money4 >5000) money4-= 5000;
			moneyField4.setText(""+money4);
		} else {
			// SET is pressed do everything.
			
		}
		 
		
	}
	
	
}
