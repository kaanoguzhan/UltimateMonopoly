package Main;

import gui.AdditionalWindows.InputReaders.GetTextInput;
import java.io.Serializable;
import java.util.ArrayList;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.Ownable;
import GameSquares.PayDay;
import GameSquares.Utility;
import GameSquares.Cards.Chance.ChanceCardType;
import GameSquares.Cards.CommunityChest.CommunityChestCardType;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id, money, location, jailTime;
	private int jailID = Properties.JailID;
	private String name;
	private GameSquare[] gameSquares;
	private boolean jailed = false;
	private ArrayList<CommunityChestCardType> InventoryCC = new ArrayList<CommunityChestCardType>();
	private ArrayList<ChanceCardType> InventoryC = new ArrayList<ChanceCardType>();
	private ArrayList<Land> ownedLands = new ArrayList<Land>();
	private ArrayList<Ownable> ownedSquares = new ArrayList<Ownable>();

	// Default Constructor
	public Player(int id, String name, GameSquare[] gameSquares) {
		this.id = id;
		this.location = 0;
		this.money = Properties.START_GOLD;
		this.name = name;
		this.gameSquares = gameSquares;
		System.out.println("Player " + name + " with " + money + " added.");
	}

	// Constructor for dummy player
	public Player(GameSquare[] gameSquares) {
		this.id = -1;
		this.location = -1;
		this.money = Properties.START_GOLD;
		this.name = ".";
		this.gameSquares = gameSquares;
	}

	public void moveBy(int amount) {
		int projectedLocation = location + amount;
		if (projectedLocation > 119)
			projectedLocation -= 24;
		if (location < 68) {
			if (projectedLocation > 68) {
				System.out.println(name + " passed Pay Day Square.");
				if (amount % 2 != 0)
					addMoney(Properties.PAYDAY_ODD);
				addMoney(Properties.PAYDAY_EVEN);
			}
		}

		if (location < 102 || location >= 111) {

			if (projectedLocation > 102) {
				System.out.println(name + " passed Bonus Square.");
				addMoney(Properties.BONUS_PASSING_MONEY);
			}
		}

		if (location < 40) {
			if (projectedLocation > 40) {
				location = projectedLocation - 40;
				System.out.println(name + " passed Start Square.");
				addMoney(Properties.START_PASSING_MONEY);
			}

			if (projectedLocation > 35) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location += (117 - 35);
					System.out.println(name + " passed transit station");
				}
			} else if (projectedLocation > 25) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location += (75 - 25);
					System.out.println(name + " passed transit station");
				}
			} else if (projectedLocation > 15) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location += (105 - 15);
					System.out.println(name + " passed transit station");
				}
			} else if (projectedLocation > 5) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location += (47 - 5);
					System.out.println(name + " passed transit station");
				}
			} else
				location = projectedLocation;
		} else if (location < 98) {
			if (projectedLocation < 75) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location -= (75 - 25);
					System.out.println(name + " passed transit station");
				}
			} else if (projectedLocation < 47) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location -= (47 - 5);
					System.out.println(name + " passed transit station");
				}
			} else
				location = projectedLocation;
		} else if (location < 120) {
			if (projectedLocation < 117) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location -= (117 - 35);
					if (location > 40) {
						location = projectedLocation - 40;
						System.out.println(name + " passed Start Square.");
						addMoney(Properties.START_PASSING_MONEY);
					}
					System.out.println(name + " passed transit station");
				}
			} else if (projectedLocation < 105) {
				location = projectedLocation;
				if (amount % 2 == 0) {
					location -= (105 - 15);
					System.out.println(name + " passed transit station");
				}
			} else
				location = projectedLocation;
		}
		System.out.println(name + " moved " + amount + " squares and now is at " + gameSquares[location].toString()
				+ "\n You have: " + money);
		if (gameSquares[location] instanceof PayDay)
			((PayDay) gameSquares[location]).onArrive(this, amount);
		else if (gameSquares[location] instanceof Utility)
			// amount = new GetTextInput("sdsd").getInt();
			((Utility) gameSquares[location]).onArrive(this, amount);
		else
			gameSquares[location].onArrive(this);
	}

	public void moveTo(int id) {
		System.out.println(name + " is at " + gameSquares[id].toString());
		if (id < 40 && location > id) {
			System.out.println(name + " passed Start Square.");
			addMoney(Properties.START_PASSING_MONEY);
		}
		location = id;

		if (gameSquares[location] instanceof Utility) {
			int amount = new GetTextInput("Total dice ?").getInt();
			((Utility) gameSquares[location]).onArrive(this, amount);
		} else
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
			gui.AdditionalWindows.List.createAndShowGUI(ownedLands,ownedSquares);
			reduceMoney(amount);
		} else {
			location = Properties.HEAVEN_ID;
			System.out.println(name + " is bankrupt."); // create a new
														// additional window
		}
	}

	public void payToPool(int amount) {
		reduceMoney(amount);
		Main.pool += amount;
		System.out.println("pool has "+Main.pool);
	}

	public void obtainPool() {
		addMoney(Main.pool * Properties.TAX_REFUND_PERCENT / 100);
		Main.pool = Main.pool*(100 - Properties.TAX_REFUND_PERCENT) / 100;
		System.out.println("pool has "+Main.pool);
	}

	public void pay(Player player, int amount) {
		System.out.println(name + " paid to " + player.getName());
		this.reduceMoney(amount);
		player.addMoney(amount);
	}

	public void addToInventoryCC(CommunityChestCardType cardType) {
		InventoryCC.add(cardType);
	}

	public boolean haveCardCC(CommunityChestCardType cardType) {
		return InventoryCC.contains(cardType);
	}

	public void addToInventoryC(ChanceCardType cardType) {
		InventoryC.add(cardType);
	}

	public boolean haveCardC(ChanceCardType cardType) {
		return InventoryC.contains(cardType);
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

	public void buySquare(GameSquare land) {
		if (land instanceof Ownable) {
			reduceMoney(((Ownable) land).getPrice());
			getOwnership(land);
		}
	}

	public void sellSquare(GameSquare land) {
		if (land instanceof Ownable && !(land instanceof Land)) {
			addMoney(((Ownable) land).getPrice());
			removeOwnership(land);
			System.out.println(name + " sold " + land + " for " + ((Ownable) land).getPrice());
		}

		if (ownedLands.contains(land)) {
			addMoney(((Ownable) land).getPrice());
			removeOwnership(land);
			System.out.println(name + " sold " + land + " for " + ((Ownable) land).getPrice());
		}
	}

	public void getOwnership(GameSquare square) {
		if (square instanceof Land)
			ownedLands.add((Land) square);
		else
			ownedSquares.add((Ownable) square);

		square.setOwner(this);
	}

	public void removeOwnership(GameSquare square) {
		if (square instanceof Land)
			ownedLands.remove((Land) square);
		else
			ownedSquares.remove((Ownable) square);

		square.setOwner(null);
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

	public ArrayList<Ownable> getOwnedSquares() {
		return ownedSquares;
	}

	// ////////// DO NOT USE THESE METHODS - THESE ARE JUST FOR DEBUGGING
	// ////////// //
	public void setLocation(int id) {
		this.location = id;
	}

	public void setMoney(int amount) {
		this.money = amount;
	}

	// /////////////////////////////////////////////////////////////////////////////
	// //

	public boolean hasGetOutOfJail() {
		if (InventoryC.contains(ChanceCardType.GetOutOfJail))
			return true;
		else
			return false;
	}

	public void removeGetOutOfJailCard() {
		InventoryC.remove(ChanceCardType.GetOutOfJail);
	}

	public boolean hasOnlinePricing() {
		if (InventoryCC.contains(CommunityChestCardType.OnlinePricing))
			return true;
		else
			return false;
	}

	public void removeOnlinePricingCard() {
		InventoryCC.remove(CommunityChestCardType.OnlinePricing);
	}

	public boolean hasBargainBusiness() {
		if (InventoryCC.contains(CommunityChestCardType.BargainBusiness))
			return true;
		else
			return false;
	}

	public void removeBargainBusinessCard() {
		InventoryCC.remove(CommunityChestCardType.BargainBusiness);
	}

	public boolean hasRenovationSuccess() {
		if (InventoryCC.contains(CommunityChestCardType.RenovationSuccess))
			return true;
		else
			return false;
	}

	public void removeRenovationSuccessCard() {
		InventoryCC.remove(CommunityChestCardType.RenovationSuccess);
	}

	public String toString() {
		String Lands = "[";
		for (Land land : ownedLands) {
			Lands += land.getName() + ", ";
		}
		if (Lands.length() > 2)
			Lands = Lands.substring(0, Lands.length() - 2);
		Lands += "]";

		return "Player " + name + " has " + money + " is at " + gameSquares[location] + "\n" + "Has Cards:"
				+ InventoryCC + "\n" + "Has Lands:" + Lands;
	}

	public ArrayList<CommunityChestCardType> getCommunityChestCards() {
		return InventoryCC;
	}

	public ArrayList<ChanceCardType> getChanceCards() {
		return InventoryC;
	}

	public boolean isJailed() {
		return jailed;
	}

	public void goToJail() {
		this.jailed = true;
		jailTime = 3;
		this.moveTo(jailID);
	}

	public void getOutOfJail() {
		this.jailed = false;
		jailTime = 0;
	}

	public boolean isReleaseTime() {
		if (jailTime == 0)
			return true;
		else
			return false;
	}

	public int getJailTime() {
		return jailTime;
	}

	public void reduceJailTime() {
		jailTime--;

	}

	public int numOfOwnedUtilities() {
		int output = 0;

		for (Ownable nextOwn : ownedSquares) {
			if (nextOwn instanceof Utility)
				output++;
		}

		return output;
	}
}
