package Main;

import gui.Board.PlayerInfo;
import java.util.ArrayList;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.Ownable;
import GameSquares.TransitStation;
import GameSquares.Cards.ChanceDeck;
import GameSquares.Cards.CommunityChest.CommunityChestCardType;
import GameSquares.Cards.CommunityChestDeck;

public class Admin extends Main {
	
	ChanceDeck			chanceDeck		= null;
	CommunityChestDeck	communityDeck	= null;
	static GameSquare[]	gameSquares		= null;
	Player[]			players			= null;
	
	
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
	
	// Move PLAYER by AMOUNT and CALL onArrive()
	public static void movePlayerBy(int playerID, int amount) {
		System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
			+ " is moved by " + amount);
		Main.players[playerID].moveBy(amount);
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION and CALL onArrive()
	public static void movePlayerTo(Player player, GameSquare gameSquare) {
		System.out.println("ADMIN -> Player:" + player.getName()
			+ " is moved to location with id " + gameSquare.getID());
		player.moveTo(gameSquare.getID());
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION and CALL onArrive()
	public static void movePlayerTo(Player player, int location) {
		if (Main.gameSquares.length - 1 >= location) {
			System.out.println("ADMIN -> Player:" + player.getName()
				+ " is moved to location with id " + location);
			player.moveTo(location);
		}
		refreshUI();
	}
	
	// Move PLAYER to given LOCATION and CALL onArrive()
	public static void movePlayerTo(int playerID, int location) {
		if (Main.players.length - 1 >= playerID && Main.gameSquares.length - 1 >= location) {
			System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
				+ " is moved to location with id " + location);
			Main.players[playerID].moveTo(location);
		}
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
		if (Main.players.length - 1 >= playerID) {
			System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
				+ "'s Location is set to location with id " + location);
			Main.players[playerID].setLocation(location);
		}
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
		if (Main.players.length - 1 >= playerID) {
			System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
				+ "'s money is set to " + amount);
			Main.players[playerID].setMoney(amount);
		}
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
		if (Main.players.length - 1 >= playerID) {
			System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
				+ "'s money is increased by " + amount + " and is now "
				+ (Main.players[playerID].getMoney() + amount));
			Main.players[playerID].addMoney(amount);
		}
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
		if (Main.players.length - 1 >= playerID) {
			System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
				+ "'s money is decreased by " + amount + " and is now "
				+ (Main.players[playerID].getMoney() - amount));
			Main.players[playerID].reduceMoney(amount);
		}
		refreshUI();
	}
	
	// Give PLAYER the ownership of OWNABLE
	public static void giveOwnership(Player player, GameSquare... ownable) {
		for (GameSquare currentOwnable : ownable) {
			if (currentOwnable instanceof Ownable) {
				System.out.println("ADMIN -> Player:" + player.getName()
					+ " is given the ownership of "
					+ ((Ownable) currentOwnable).getName());
				player.getOwnership(currentOwnable);
			}
		}
		refreshUI();
	}
	
	// Give PLAYER the ownership of OWNABLE
	public static void giveOwnership(Player player, int... OwnableID) {
		for (int currentOwnableID : OwnableID) {
			if (Main.gameSquares[currentOwnableID] instanceof Ownable
				&& Main.gameSquares.length - 1 >= currentOwnableID) {
				System.out.println("ADMIN -> Player:" + player.getName()
					+ " is given the ownership of "
					+ ((Ownable) Main.gameSquares[currentOwnableID]).getName());
				player.getOwnership(Main.gameSquares[currentOwnableID]);
			}
		}
		refreshUI();
	}
	
	// Give PLAYER the ownership of OWNABLE
	public static void giveOwnership(int playerID, String... ownableName) {
		for (String currentOwnableName : ownableName) {
			for (GameSquare gameSquare : Main.gameSquares)
				if (gameSquare instanceof Ownable && Main.players.length - 1 >= playerID &&
					((Ownable) gameSquare).getName().equals(currentOwnableName)) {
					System.out.println("ADMIN -> Player:" + Main.players[playerID].getName()
						+ " is given the ownership of " + currentOwnableName);
					Main.players[playerID].getOwnership(gameSquare);
					if (gameSquare instanceof TransitStation) {
						Main.players[playerID].getOwnership(Main.gameSquares[((TransitStation) gameSquare)
							.getConnectedTransit()]);
					}
					
					break;
				}
		}
		refreshUI();
	}
	
	// Remove the ownership of OWNABLE from PLAYER
	public static <T> void removeOwnership(T player, T ownable) {
		// Get Player
		Player pl = null;
		if (player instanceof Player)
			pl = (Player) player;
		else if (player instanceof Integer && Main.players.length - 1 >= (Integer) player)
			pl = Main.players[(int) player];
		
		// Get Ownable
		Ownable ownbl = null;
		if (ownable instanceof Ownable)
			ownbl = (Ownable) ownable;
		else if (ownable instanceof Integer && Main.gameSquares.length - 1 >= (Integer) ownable)
			ownbl = (Ownable) Main.gameSquares[(int) ownable];
		else if (ownable instanceof String) {
			for (GameSquare gameSquare : Main.gameSquares)
				if (gameSquare instanceof Ownable && ((Ownable) gameSquare).getName().equals(ownable)) {
					ownbl = (Ownable) gameSquare;
					removeOwnershipExec(pl, ownbl);
				}
			return;
			
		}
		
		removeOwnershipExec(pl, ownbl);
	}
	private static void removeOwnershipExec(Player pl, Ownable ownbl) {
		System.out.println("ADMIN -> Player:" + pl.getName() + "'s ownership is removed from " + ownbl.getName());
		pl.removeOwnership((GameSquare) ownbl);
		refreshUI();
	}
	
	// Upgrage Ownable if possible
	public static void upgradeOwnable(String... ownableName) {
		for (String currentOwnableName : ownableName) {
			for (GameSquare gameSquare : Main.gameSquares)
				if (gameSquare instanceof Ownable && ((Ownable) gameSquare).getName().equals(currentOwnableName)) {
					((Ownable) gameSquare).upgrade();
					System.out.println("ADMIN -> Ownable " + currentOwnableName + " is upgraded." + " "
						+ ((Ownable) gameSquare).getUpgradeState());
				}
		}
	}
	
	// Downgrade Ownable if possible
	public static void downgradeOwnable(String... ownableName) {
		for (String currentOwnableName : ownableName) {
			for (GameSquare gameSquare : Main.gameSquares)
				if (gameSquare instanceof Ownable && ((Ownable) gameSquare).getName().equals(currentOwnableName)) {
					((Ownable) gameSquare).downgrade();
					System.out.println("ADMIN -> Ownable " + currentOwnableName + " is upgraded." + " "
						+ ((Ownable) gameSquare).getUpgradeState());
				}
		}
	}
	
	// Return PLAYER's ID
	public static int getPlayerLocation(Player player) {
		return player.getLocation();
	}
	
	// Return PLAYER's ID
	public static int getPlayerLocation(int playerID) {
		if (Main.players != null)
			return Main.players.length - 1 >= playerID ? Main.players[playerID].getLocation() : 0;
		return 0;
	}
	// Return PLAYER's MONEY
	public static int getPlayerMoney(Player player) {
		return player.getMoney();
	}
	
	// Return PLAYER's MONEY
	public static int getPlayerMoney(int playerID) {
		if (Main.players != null)
			return Main.players.length - 1 >= playerID ? Main.players[playerID].getMoney() : 0;
		return 0;
	}
	
	// Return PLAYER's NAME
	public static String getPlayerName(int playerID) {
		return Main.players[playerID].getName();
	}
	
	// Return PLAYER's NAME
	public static String getPlayerName(Player player) {
		return player.getName();
	}
	
	// Return NEXT PLAYER's NAME
	public static String getNextPlayerName(int playerID) {
		return Main.players[(playerID + 1) % Main.players.length].getName();
	}
	
	// Return NEXT PLAYER's NAME
	public static String getNextPlayerName(Player player) {
		return Main.players[(player.getID() + 1) % Main.players.length].getName();
	}
	
	// Returns IF the PLAYER HAS any LAND
	public static boolean playerHasLand(int playerID) {
		return !Main.players[playerID].getOwnedLands().isEmpty();
	}
	
	// Return NEXT PLAYER's ID
	public static int getPlayerID(int playerID) {
		return Main.players[playerID].getID();
	}
	
	// Return NEXT PLAYER's ID
	public static int getPlayerID(Player player) {
		return player.getID();
	}
	
	// Returns PLAYER's OWNED LANDS
	public static ArrayList<Land> getPlayerLands(int playerID) {
		return Main.players[playerID].getOwnedLands();
	}
	
	// Returns PLAYER's OWNED LANDS
	public static ArrayList<Land> getPlayerLands(Player player) {
		return player.getOwnedLands();
	}
	
	// Moves PLAYER to NEXT NOT OWNED LAND
	public static void movePlayerToNextNeutralLand(Player player) {
		for (int i = 0; i < Main.gameSquares.length; i++) {
			GameSquare nextGameSquare = Main.gameSquares[(player.getLocation() + i) % Main.gameSquares.length];
			if (nextGameSquare instanceof Land && !((Land) nextGameSquare).isOwned()) {
				movePlayerTo(player, nextGameSquare);
				refreshUI();
				break;
			}
		}
	}
	
	// Moves PLAYER to NEXT NOT OWNED LAND
	public static void movePlayerToNextNeutralLand(int playerID, boolean even) {
		int start = Main.players[playerID].getLocation();
		int currentCheck = start + 1;
		while (currentCheck != start) {
			System.out.print("now at " + currentCheck);
			if (even) {
				if (currentCheck == 5)
					currentCheck = 47;
				else if (currentCheck == 15)
					currentCheck = 105;
				else if (currentCheck == 25)
					currentCheck = 75;
				else if (currentCheck == 35)
					currentCheck = 117;
				else if (currentCheck == 47)
					currentCheck = 5;
				else if (currentCheck == 105)
					currentCheck = 15;
				else if (currentCheck == 75)
					currentCheck = 25;
				else if (currentCheck == 117) currentCheck = 35;
				
			}
			if (currentCheck == 39)
				currentCheck = 0;
			else if (currentCheck == 120)
				currentCheck = 97;
			else if (currentCheck == 96) currentCheck = 40;
			
			GameSquare nextGameSquare = Main.gameSquares[currentCheck % Main.gameSquares.length];
			if (nextGameSquare instanceof Ownable && !((Ownable) nextGameSquare).isOwned()) {
				movePlayerTo(Main.players[playerID], nextGameSquare);
				refreshUI();
				break;
			}
			currentCheck++;
		}
	}
	
	// Moves PLAYER to NEXT LAND
	public static void movePlayerToNextLand(Player player) {
		for (int i = 1; i < Main.gameSquares.length; i++) {
			GameSquare nextGameSquare = Main.gameSquares[(player.getLocation() + i) % Main.gameSquares.length];
			if (nextGameSquare instanceof Land) {
				movePlayerTo(player, nextGameSquare);
				refreshUI();
				break;
			}
		}
	}
	
	// Moves PLAYER to NEXT LAND
	public static void movePlayerToNextLand(int playerID, boolean even) {
		
		int start = Main.players[playerID].getLocation();
		int currentCheck = start + 1;
		while (currentCheck != start) {
			System.out.print("now at " + currentCheck);
			if (even) {
				if (currentCheck == 5)
					currentCheck = 47;
				else if (currentCheck == 15)
					currentCheck = 105;
				else if (currentCheck == 25)
					currentCheck = 75;
				else if (currentCheck == 35)
					currentCheck = 117;
				else if (currentCheck == 47)
					currentCheck = 5;
				else if (currentCheck == 105)
					currentCheck = 15;
				else if (currentCheck == 75)
					currentCheck = 25;
				else if (currentCheck == 117) currentCheck = 35;
				
			}
			
			if (currentCheck == 39)
				currentCheck = 0;
			else if (currentCheck == 120)
				currentCheck = 97;
			else if (currentCheck == 96) currentCheck = 40;
			
			GameSquare nextGameSquare = Main.gameSquares[currentCheck % Main.gameSquares.length];
			if (nextGameSquare instanceof Ownable) {
				movePlayerTo(Main.players[playerID], nextGameSquare);
				refreshUI();
				break;
			}
			currentCheck++;
		}
		
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
	
	// Checks if all LAND's are OWNED
	
	public static boolean allLandsOwned() {
		for (GameSquare currentLand : Main.gameSquares) {
			if (currentLand instanceof Ownable && !((Ownable) currentLand).isOwned()) { return false; }
		}
		return true;
	}
	/*********************/
	/** General methods **/
	/*********************/
	private static void refreshUI() {
		PlayerInfo.refreshData();
	}
	
	public static int getPlayerCount() {
		return Main.players.length;
	}
	
	public static int getGameSquareCount() {
		return Main.gameSquares.length;
	}
	
	public static ArrayList<CommunityChestCardType> getPlayerCommunityChestCards(int playerID) {
		return Main.players[playerID].getCommunityChestCards();
	}
	
	public static GameSquare[] getGameSquares() {
		return Main.gameSquares;
	}
}
