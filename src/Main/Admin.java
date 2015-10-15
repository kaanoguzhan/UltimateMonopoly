package Main;

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
		System.out.println("ADMIN -> Player:" + player.getName() +
			" is moved by " + amount);
		player.moveBy(amount);
	}
	
	// Move PLAYER to given LOCATION and CALL onArrive()
	public static void movePlayerTo(Player player, int location) {
		System.out.println("ADMIN -> Player:" + player.getName() +
			" is moved to location with id " + location);
		player.moveTo(location);
	}
	
	// Move PLAYER to given LOCATION but WONT CALL location's onArrive()
	public static void movePlayerToForced(Player player, int location) {
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s Location is set to location with id " + location);
		player.setLocation(location);
	}
	
	// Sets PLAYER's MONEY to given AMOUNT
	public static void setMoney(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s money is set to " + amount);
		player.setMoney(amount);
	}
	
	// Increase PLAYER's MONEY by AMOUNT
	public void increaseMoneyBy(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s money is increased by " + amount +
			" and is now " + (player.getMoney() + amount));
		player.addMoney(amount);
	}
	
	// Decrease PLAYER's MONEY by AMOUNT
	public void decreaseMoneyBy(Player player, int amount) {
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s money is decreased by " + amount +
			" and is now " + (player.getMoney() - amount));
		player.reduceMoney(amount);
	}
	
	// Give PLAYER the ownership of LAND
	public static void giveOwnership(Player player, GameSquare... land) {
		for (GameSquare currentLand : land) {
			System.out.println("ADMIN -> Player:" + player.getName() +
				" is given the ownership of " + ((Land) currentLand).getName());
			player.getOwnership((Land) currentLand);
		}
	}
	
	/************************/
	/** Land admin methods **/
	/************************/
	// Change LAND's name to NAME
	public void setName(GameSquare land, String name) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName() +
			"'s name is changed to " + name);
		((Land) land).setName(name);
	}
	
	// Change LANDS's color to COLOR
	public void setColor(GameSquare land, color color) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName() +
			"'s color is changed to " + color.toString());
		((Land) land).setColor(color);
	}
	
	// Change LAND's price to AMOUNT
	public void setPrice(GameSquare land, int amount) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName() +
			"'s price is changed to " + amount);
		((Land) land).setPrice(amount);
	}
	
	// Change LAND's rent to AMOUNT
	public void setRent(GameSquare land, int amount) {
		System.out.println("ADMIN -> LAND:" + ((Land) land).getName() +
			"'s rent is changed to " + amount);
		((Land) land).setRent(amount);
	}
}
