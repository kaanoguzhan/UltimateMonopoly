package Main;

import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Chance.ChanceDeck;
import GameSquares.CommunityChest.CommunityChestDeck;

public class Admin {
	
	static ChanceDeck			chanceDeck		= null;
	static CommunityChestDeck	communityDeck	= null;
	static GameSquare[]			gameSquares		= null;
	static Player[]				players			= null;
	
	// Player[] players, GameSquare[] gameSquares, ChanceDeck chanceDeck, CommunityChestDeck communityDeck
	public Admin() {
		this.players = Main.players;
		this.gameSquares = Main.gameSquares;
		this.chanceDeck = Main.chanceDeck;
		this.communityDeck = Main.communityDeck;
	}
	
	
	/** Player admin methods **/
	// Move PLAYER to given LOCATION and CALL onArrive()
	public void movePlayerTo(Player player, int location) {
		player.moveTo(location);
		System.out.println("ADMIN -> Player:" + player.getName() +
			" is moved to location with id " + player.getLocation());
	}
	
	// Move PLAYER to given LOCATION but WONT CALL location's onArrive()
	public void movePlayerToForced(Player player, int location) {
		player.setLocation(location);
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s Location is set to location with id " + player.getLocation());
	}
	
	// Sets PLAYER's MONEY to given AMOUNT
	public void setMoney(Player player, int amount) {
		player.setMoney(amount);
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s money is set to " + player.getMoney());
	}
	
	// Increase PLAYER's MONEY by AMOUNT
	public void increaseMoneyBy(Player player, int amount) {
		player.addMoney(amount);
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s money is increased by " + amount +
			" and is now " + player.getMoney());
	}
	
	// Decrease PLAYER's MONEY by AMOUNT
	public void decreaseMoneyBy(Player player, int amount) {
		player.reduceMoney(amount);
		System.out.println("ADMIN -> Player:" + player.getName() +
			"'s money is decreased by " + amount +
			" and is now " + player.getMoney());
	}
	
	// Give PLAYER the ownership of LAND
	public void giveOwnership(Player player, GameSquare... land) {
		for (GameSquare currentLand : land) {
			player.getOwnership((Land) currentLand);
			System.out.println("ADMIN -> Player:" + player.getName() +
				" is given the ownership of " + ((Land) currentLand).getName());
		}
	}
}
