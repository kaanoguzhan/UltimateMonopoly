package Main;

import java.io.Serializable;
import java.util.ArrayList;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;

public class Player implements Serializable {
	private static final long					serialVersionUID	= 1L;
	private String								name;
	private int									id, money, location;
	private GameSquare[]						gameSquares;
	private ArrayList<CommunityChestCardType>	Inventory			= new ArrayList<CommunityChestCardType>();
	private ArrayList<Land>						ownedLands			= new ArrayList<Land>();
	
	
	public Player(int id, String name, GameSquare[] gameSquares) {
		this.id = id;
		this.location = 0;
		this.money = Properties.START_GOLD;
		this.name = name;
		this.gameSquares = gameSquares;
		System.out.println("Player " + name + " with " + money + " added.");
	}
	
	public void moveBy(int amount) {
		location += amount;
		if (location >= Properties.TOTAL_SQUARES) {
			System.out.println(name + " passed Start Square.");
			addMoney(Properties.START_PASSING_MONEY);
			location = location % Properties.TOTAL_SQUARES;
		}
		System.out.println(name + " moved " + amount + " squares and now is at " + gameSquares[location].toString()
			+ "\n You have: " + money);
		
		gameSquares[location].onArrive(this);
	}
	
	public void moveTo(int id) {
		System.out.println(name + " is at " + gameSquares[id].toString());
		if (location > id) {
			System.out.println(name + " passed Start Square.");
			addMoney(Properties.START_PASSING_MONEY);
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
		} else if (ownedLands.size() > 0) {
			gui.AdditionalWindows.List.createAndShowGUI(ownedLands);
			reduceMoney(0);
		} else {
			location = Properties.HEAVEN_LOCATION;
			System.out.println(name + " is bankrupt."); // create a new additional window
		}
	}
	
	public void pay(Player player, int amount) {
		System.out.println(name + " paid to " + player.getName());
		this.reduceMoney(amount);
		player.addMoney(amount);
	}
	
	public void addToInventory(CommunityChestCardType cardType) {
		Inventory.add(cardType);
	}
	
	public boolean haveCard(CommunityChestCardType cardType) {
		return Inventory.contains(cardType);
	}
	
	// public void removeCard(CommunityChestCardType cardType) {
	// Inventory.remove(cardType);
	// }
	
	public int getMoney() {
		return money;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLocation() {
		return location;
	}
	public void buyLand(Land land) {
		reduceMoney(land.getPrice());
		getOwnership(land);
	}
	
	public void sellLand(Land land) {
		if (ownedLands.contains(land)) {
			addMoney(land.getPrice());
			removeOwnership(land);
			System.out.println(name + " sold " + land + " for " + land.getPrice());
		}
		land.setOwner(null);
	}
	
	public void getOwnership(Land land) {
		ownedLands.add(land);
		land.setOwner(this);
	}
	
	public void removeOwnership(Land land) {
		ownedLands.remove(land);
		land.setOwner(null);
	}
	
	public int getID() {
		return id;
	}
	
	public int getNumberOfOwnedByColor(color color) {
		int counter = 0;
		for (Land land : ownedLands) {
			if (land.getColor() == color)
				counter++;
		}
		return counter;
	}
	
	public ArrayList<Land> getOwnedLands() {
		return ownedLands;
	}
	
	// ////////// DO NOT USE THESE METHODS - THESE ARE JUST FOR DEBUGGING ////////// //
	public void setLocation(int id) {
		this.location = id;
	}
	
	public void setMoney(int amount) {
		this.money = amount;
	}
	// ///////////////////////////////////////////////////////////////////////////// //
	
	public boolean hasBargainBusiness() {
		if (Inventory.contains(CommunityChestCardType.BargainBusiness))
			return true;
		else
			return false;
	}
	
	public void removeBargainBusinessCard() {
		Inventory.remove(CommunityChestCardType.BargainBusiness);
	}
	
	public boolean hasRenovationSuccess() {
		if (Inventory.contains(CommunityChestCardType.RenovationSuccess))
			return true;
		else
			return false;
	}
	
	public void removeRenovationSuccessCard() {
		Inventory.remove(CommunityChestCardType.RenovationSuccess);
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
			" is at " + gameSquares[location] +
			"\n" + "Has Cards:" + Inventory +
			"\n" + "Has Lands:" + Lands;
	}
	
	public ArrayList<CommunityChestCardType> getCommunityChestCards() {
		return Inventory;
	}
}
