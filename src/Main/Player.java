package Main;

import java.util.ArrayList;
import GameSquares.GameSquare;

public class Player {
	
	private String				name;
	private int					money, location;
	private GameSquare[]		gameSquares;
	private ArrayList<String>	Inventory	= new ArrayList<String>();
	
	public Player(String name, GameSquare[] gameSquares) {
		this.location = 0;
		this.money = Properties.StartGold;
		this.name = name;
		this.gameSquares = gameSquares;
		System.out.println("Player " + name + " with " + money + " added.");
	}
	
	public void moveBy(int roll) {
		location += roll;
		if (location >= Properties.TotalSquares) {
			addMoney(Properties.PASSING_MONEY);
			location = location % Properties.TotalSquares;
		}
		System.out.println(name + " moved " + roll + " squares and now is at " + gameSquares[location].toString());
		gameSquares[location].onArrive(this);
	}
	
	public void moveTo(int id) {
		location = id;
		System.out.println(name + " is at " + gameSquares[location].toString());
		gameSquares[location].onArrive(this);
	}
	
	public void addMoney(int amount) {
		money += amount;
		System.out.println(name + "'s money increased by " + money);
	}
	
	public void reduceMoney(int amount) {
		if (money >= amount) {
			money -= amount;
			System.out.println(name + "'s money decreased by " + money);
		} else {
			location = Properties.Heaven;
			System.out.println(name + " is bankrupt.");
		}
	}
	
	public void addToInventory(String cardName) {
		Inventory.add(cardName);
	}
	
	public boolean haveCard(String cardName) {
		return Inventory.contains(cardName);
	}
	
	public void removeCard(String cardName) {
		Inventory.remove(cardName);
	}
	
	public String toString() {
		return "Player " + name + " has " + money + "\n" + "Square: " + location;
		
	}
}
