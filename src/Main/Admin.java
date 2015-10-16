package Main;

import gui.Board;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.Chance.ChanceDeck;
import GameSquares.CommunityChest.CommunityChestDeck;

public class Admin {
	
	ChanceDeck			chanceDeck		= null;
	CommunityChestDeck	communityDeck	= null;
	GameSquare[]		gameSquares		= null;
	Player[]			players			= null;
	
	public Admin() {
		this.players = Main.players;
		this.gameSquares = Main.gameSquares;
		this.chanceDeck = Main.chanceDeck;
		this.communityDeck = Main.communityDeck;
	}
	
	/**************************/
	/** Player admin methods **/
	/**************************/
	// Move PLAYER by AMOUNT and CALL onArrive()
	public static void movePlayerBy(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ " is moved by " + amount);
		player.moveBy(amount);
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION and CALL onArrive()
	public static void movePlayerTo(Player player, int location) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ " is moved to location with id " + location);
		player.moveTo(location);
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION and CALL onArrive()
	public static void movePlayerTo(int playerID, int location) {
		System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
			+ " is moved to location with id " + location);
		Main.players[playerID].moveTo(location);
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION but WONT CALL location's onArrive()
	public static void movePlayerToForced(Player player, int location) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ "'s Location is set to location with id " + location);
		player.setLocation(location);
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION but WONT CALL location's onArrive()
	public static void movePlayerToForced(int playerID, int location) {
		System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
			+ "'s Location is set to location with id " + location);
		Main.players[playerID].setLocation(location);
		refreshUI();
	}
	
	// Sets PLAYER's MONEY to given AMOUNT
	public static void setMoney(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ "'s money is set to " + amount);
		player.setMoney(amount);
		refreshUI();
	}
	
	// Sets PLAYER's MONEY to given AMOUNT
	public static void setMoney(int playerID, int amount) {
		System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
			+ "'s money is set to " + amount);
		Main.players[playerID].setMoney(amount);
		refreshUI();
	}
	
	// Increase PLAYER's MONEY by AMOUNT
	public static void increaseMoneyBy(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ "'s money is increased by " + amount + " and is now "
			+ (player.getMoney() + amount));
		player.addMoney(amount);
		refreshUI();
	}
	
	// Increase PLAYER's MONEY by AMOUNT
	public static void increaseMoneyBy(int playerID, int amount) {
		System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
			+ "'s money is increased by " + amount + " and is now "
			+ (Main.players[playerID].getMoney() + amount));
		Main.players[playerID].addMoney(amount);
		refreshUI();
	}
	
	// Decrease PLAYER's MONEY by AMOUNT
	public static void decreaseMoneyBy(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ "'s money is decreased by " + amount + " and is now "
			+ (player.getMoney() - amount));
		player.reduceMoney(amount);
		refreshUI();
	}
	
	// Decrease PLAYER's MONEY by AMOUNT
	public static void decreaseMoneyBy(int playerID, int amount) {
		System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
			+ "'s money is decreased by " + amount + " and is now "
			+ (Main.players[playerID].getMoney() - amount));
		Main.players[playerID].reduceMoney(amount);
		refreshUI();
	}
	
	// Give PLAYER the ownership of LAND
	public static void giveOwnership(Player player, GameSquare... land) {
		for (GameSquare currentLand : land) {
			if (currentLand instanceof Land) {
				System.out.println("ADMIN -> Player:" + player.getName()
					+ " is given the ownership of "
					+ ((Land) currentLand).getName());
				player.getOwnership((Land) currentLand);
			}
		}
		refreshUI();
	}
	
	// Give PLAYER the ownership of LAND
	public static void giveOwnership(Player player, int... landID) {
		for (int currentLandID : landID) {
			if (Main.gameSquares[currentLandID] instanceof Land) {
				System.out.println("ADMIN -> Player:" + player.getName()
					+ " is given the ownership of "
					+ ((Land) Main.gameSquares[currentLandID]).getName());
				player.getOwnership((Land) Main.gameSquares[currentLandID]);
			}
		}
		refreshUI();
	}
	
	// Give PLAYER the ownership of LAND
	public static void giveOwnership(int playerID, String... landName) {
		for (String currentLandName : landName) {
			for (GameSquare gameSquare : Main.gameSquares)
				if (gameSquare instanceof Land)
					if (((Land) gameSquare).getName().equals(currentLandName)) {
						System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
							+ " is given the ownership of " + currentLandName);
						Main.players[playerID].getOwnership((Land) gameSquare);
					}
		}
		refreshUI();
	}
	
	// Remove the ownership of LAND from PLAYER
	public static void removeOwnership(Player player, GameSquare... land) {
		for (GameSquare currentLand : land) {
			if (currentLand instanceof Land) {
				System.out.println("ADMIN -> Player:" + player.getName()
					+ "'s ownership is removed from "
					+ ((Land) currentLand).getName());
				player.removeOwnership((Land) currentLand);
			}
		}
		refreshUI();
	}
	
	// Remove the ownership of LAND from PLAYER
	public static void removeOwnership(Player player, int... landID) {
		for (int currentLandID : landID) {
			if (Main.gameSquares[currentLandID] instanceof Land) {
				System.out.println("ADMIN -> Player:" + player.getName()
					+ "'s ownership is removed from "
					+ ((Land) Main.gameSquares[currentLandID]).getName());
				player.removeOwnership((Land) Main.gameSquares[currentLandID]);
			}
		}
		refreshUI();
	}
	
	// Remove the ownership of LAND from PLAYER
	public static void removeOwnership(int playerID, String... landName) {
		for (String currentLandName : landName) {
			for (GameSquare gameSquare : Main.gameSquares)
				if (gameSquare instanceof Land)
					if (((Land) gameSquare).getName().equals(currentLandName)) {
						System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
							+ "'s ownership is removed from " + currentLandName);
						Main.players[playerID].removeOwnership((Land) gameSquare);
					}
		}
		refreshUI();
	}
	/************************/
	/** Land admin methods **/
	/************************/
	// Change LAND's name to NAME
	public void setName(GameSquare land, String name) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName()
			+ "'s name is changed to " + name);
		((Land) land).setName(name);
	}
	
	// Change LANDS's color to COLOR
	public void setColor(GameSquare land, color color) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName()
			+ "'s color is changed to " + color.toString());
		((Land) land).setColor(color);
	}
	
	// Change LAND's price to AMOUNT
	public void setPrice(GameSquare land, int amount) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName()
			+ "'s price is changed to " + amount);
		((Land) land).setPrice(amount);
	}
	
	// Change LAND's rent to AMOUNT
	public void setRent(GameSquare land, int amount) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName()
			+ "'s rent is changed to " + amount);
		((Land) land).setRent(amount);
	}
	
	/*********************/
	/** General methods **/
	/*********************/
	private static void refreshUI() {
		Board.informationTable.refreshData();
	}
	
}
