package Main;

import gui.AdditionalWindows.InputReaders.GetTextInput;
import java.io.Serializable;
import java.util.ArrayList;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.Ownable;
import GameSquares.TransitStation;
import GameSquares.Utility;
import GameSquares.Cards.Card.CardType;

public class Player implements Serializable {

	private static final long   serialVersionUID = 1L;
	private int                 id, money, location, jailTime, doublesRolled;
	private int                 jailID           = Properties.JAIL_ID;
	private String              name;
	private GameSquare[]        gameSquares;
	private boolean             jailed           = false, bonusPassAvailable;
	private ArrayList<CardType> cardInventory    = new ArrayList<CardType>();
	private ArrayList<Land>     ownedLands       = new ArrayList<Land>();
	private ArrayList<Ownable>  ownedSquares     = new ArrayList<Ownable>();
	public boolean testing = false;

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
		int nextLocation = location + 1;
		bonusPassAvailable = true;
		if (location == 102) {
			bonusPassAvailable = false;
		}
		for (int i = 0; i < amount; i++) {

			if (amount % 2 == 0) {// transit locations
				boolean passed = true;
				if (nextLocation == 5)
					nextLocation = 47;
				else if (nextLocation == 15)
					nextLocation = 105;
				else if (nextLocation == 25)
					nextLocation = 75;
				else if (nextLocation == 35)
					nextLocation = 117;
				else if (nextLocation == 47)
					nextLocation = 5;
				else if (nextLocation == 105)
					nextLocation = 15;
				else if (nextLocation == 75)
					i = 25;
				else if (nextLocation == 117)
					nextLocation = 35;
				else
					passed = false;
				if (passed)
					System.out.println(name + " passed transit station");
			}

			if (nextLocation == 40)
				nextLocation = 0; // track endings
			else if (nextLocation == 120)
				nextLocation = 97;
			else if (nextLocation == 96)
				nextLocation = 40;

			if (nextLocation == 0) { // start square
				System.out.println(name + " passed Start Square.");
				addMoney(Properties.START_PASSING_MONEY);
			}

			if (nextLocation == 68) { // payday
				System.out.println(name + " passed Pay Day Square.");
				if (amount % 2 != 0) {
					addMoney(Properties.PAYDAY_ODD);
				} else {
					addMoney(Properties.PAYDAY_EVEN);
				}
			}
			if (nextLocation == 103 && bonusPassAvailable) { // bonus
				System.out.println(name + " passed Bonus Square.");
				addMoney(Properties.BONUS_PASSING_MONEY);
			}
			nextLocation++; // update location

		}
		location = nextLocation - 1;
		System.out.println(name + " moved " + amount + " squares and now is at " + gameSquares[location].toString()
				+ "\n You have: " + money);
		if(!testing)
			if (gameSquares[location] instanceof Utility)
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
			gui.AdditionalWindows.List.createAndShowGUI(ownedLands, ownedSquares);
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
		System.out.println("pool has " + Main.pool);
	}

	public void obtainPool() {
		addMoney(Main.pool * Properties.TAX_REFUND_PERCENT / 100);
		Main.pool = Main.pool * (100 - Properties.TAX_REFUND_PERCENT) / 100;
		System.out.println("pool has " + Main.pool);
	}

	public void pay(Player player, int amount) {
		System.out.println(name + " paid to " + player.getName());
		this.reduceMoney(amount);
		player.addMoney(amount);
	}

	public void addToCardInventory(CardType cardType) {
		cardInventory.add(cardType);
		System.out.println("Player " + name + " is given the card " + cardType);
	}

	public boolean haveCard(CardType cardType) {
		return cardInventory.contains(cardType);
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
			if (land instanceof TransitStation)
				addMoney(((Ownable) land).getPrice() / 2);
			else
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
		return cardInventory.contains(CardType.GetOutOfJail);
	}
	public boolean hasOnlinePricing() {
		return cardInventory.contains(CardType.OnlinePricing);
	}
	public boolean hasBargainBusiness() {
		return cardInventory.contains(CardType.BargainBusiness);
	}
	public boolean hasRenovationSuccess() {
		return cardInventory.contains(CardType.RenovationSuccess);
	}

	public void removeGetOutOfJailCard() {
		cardInventory.remove(CardType.GetOutOfJail);
	}
	public void removeOnlinePricingCard() {
		cardInventory.remove(CardType.OnlinePricing);
	}
	public void removeBargainBusinessCard() {
		cardInventory.remove(CardType.BargainBusiness);
	}
	public void removeRenovationSuccessCard() {
		cardInventory.remove(CardType.RenovationSuccess);
	}

	public ArrayList<CardType> getCardsInventory() {
		return cardInventory;
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
		return false;
	}

	public int getJailTime() {
		return jailTime;
	}

	public void reduceJailTime() {
		jailTime--;
	}

	public void resetDoublesRolled() {
		doublesRolled = 0;
	}

	public boolean isThirdDoubles() {
		if (doublesRolled == 3)
			return true;
		return false;
	}

	public int getDoublesRolled() {
		return doublesRolled;
	}

	public void doublesRolled() {
		doublesRolled++;
	}

	public int numOfOwnedUtilities() {
		int output = 0;

		for (Ownable nextOwn : ownedSquares) {
			if (nextOwn instanceof Utility)
				output++;
		}

		return output;
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
		+ cardInventory + "\n" + "Has Lands:" + Lands;
	}
 
    public boolean repOK(){
    	boolean sqOk = true;
    	for(int i=0;i<ownedSquares.size();i++){
    		if(ownedSquares.get(i) instanceof Land) sqOk = false;
    	}
    	
    	return (money>=0)&&(120>location)&&(location>=0)&&
    			(cardInventory!=null)&&(ownedLands!=null)&&(ownedSquares!=null)
    			&&sqOk&&(doublesRolled>=0)&&(doublesRolled<=3)&&(jailTime>=0)&&(jailTime<=3);
    }
    
}
