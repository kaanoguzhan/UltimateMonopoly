package Main;

import java.util.Scanner;

public class Player {
	
	private String	Name		= "";
	private int		Money		= 0;
	private int		Location	= 0;
	
	public Player(String name) {
		Money = Properties.StartGold;
		Name = name;
		System.out.println("Player " + Name + " with " + Money + " added.");
	}
	
	public void move(int roll) {
		Location += roll;
		if (Location > Properties.TotalSquares) {
			addMoney(Properties.PASSING_MONEY);
			Location = Location % Properties.TotalSquares;
		}
	}
	
	public void moveTo(int id) {
		Location = id;
	}
	
	public void addMoney(int amount) {
		Money += amount;
	}
	
	public void reduceMoney(int amount) {
		if (Money >= amount)
			Money -= amount;
		else {
			Location = Properties.Heaven;
			System.out.println(Name + " is bankrupt.");
		}
	}
	
	public String toString() {
		return "Player " + Name + " has " + Money + "\n" + "Square: " + Location;
		
	}
}
