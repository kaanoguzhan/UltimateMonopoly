package Main;

import java.util.ArrayList;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import GameSquares.Land.color;

public class Player {
	
	private String								name;
	private int									money, location;
	private GameSquare[]						gameSquares;
	private ArrayList<CommunityChestCardType>	Inventory	= new ArrayList<CommunityChestCardType>();
	private ArrayList<Land>						ownedLands	= new ArrayList<Land>();
	
	
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
			System.out.println(name + " passed Start Square.");
			addMoney(Properties.PASSING_MONEY);
			location = location % Properties.TotalSquares;
		}
		System.out.println(name + " moved " + roll + " squares and now is at " + gameSquares[location].toString()
			+ "\n You have: " + money);
		
		gameSquares[location].onArrive(this);
	}
	
	public void moveTo(int id) {
		System.out.println(name + " is at " + gameSquares[id].toString());
		if (location > id) {
			System.out.println(name + " passed Start Square.");
			addMoney(Properties.PASSING_MONEY);
		}
		location = id;
		gameSquares[location].onArrive(this);
	}
	
	public void addMoney(int amount) {
		money += amount;
		System.out.println(name + "'s money increased by " + amount + " to " + money);
	}
	
	public void reduceMoney(int amount) {
		if (money >= amount) {
			money -= amount;
			System.out.println(name + "'s money decreased by " + amount + " to " + money);
		} else {
			location = Properties.Heaven;
			System.out.println(name + " is bankrupt.");
		}
	}
	
	public void addToInventory(CommunityChestCardType cardType) {
		Inventory.add(cardType);
	}
	
	public boolean haveCard(CommunityChestCardType cardType) {
		return Inventory.contains(cardType);
	}
	
	public void removeCard(CommunityChestCardType cardType) {
		Inventory.remove(cardType);
	}
	
	public int getMoney() {
		return money;
	}
	
	public String getName() {
		return name;
	}
	
	public void getOwnership(Land land) {
		ownedLands.add(land);
	}
	
	public int getNumberOfOwnedByColor(color color) {
		int counter = 0;
		for (Land land : ownedLands) {
			if (land.getColor() == color)
				counter++;
		}
		return counter;
	}
	public String toString() {
		String Lands = "[";
		for (Land land : ownedLands) {
			Lands += land.getName() + ", ";
		}
		if (Lands.length() > 2)
			Lands = Lands.substring(0, Lands.length() - 2);
		Lands += "]";
		
		
		return "Player " + name + " has " + money +
			"\n" + "Square: " + location +
			"\n" + "Has Cards:" + Inventory +
			"\n" + "Has Lands:" + Lands;
		
	}
}
