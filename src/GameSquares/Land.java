package GameSquares;

import gui.AdditionalWindows.MessageDisplayer;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class Land extends GameSquare implements Ownable{
	private static final long	serialVersionUID	= 1L;
	private String	name;
	private color	color;
	private int		price, rent;
	private boolean	doubleRent;
	public boolean	buy;
	
	public enum color {
		blue, pink, orange, green, puple, lightBlue, red, yellow, white, 
		black, grey, brown, lightPink, lightGreen, lightYellow, oceanGreen,
		magenta, gold, lightRed, darkRed
	}


	public Land(int id, String name, color color, int price, int rent) {
		super(id,type.Land);
		this.name = name;
		this.color = color;
		this.price = price;
		this.rent = rent;
	}
	
	@Override
	public void onArrive(Player pl) {
		if (this.owner == null) {
			boolean buy = new GetYesNoInput("For " + price + " dollars", "Would you like to buy " + name + " ?")
				.getValue();
			
			boolean bargain = false;
			if (pl.hasBargainBusiness())
				bargain = new GetYesNoInput("You can use BargainBusiness", "Do you want to use it ?")
					.getValue();
			
			if (buy) {
				if (pl.getMoney() >= price) {
					int tempPrice = this.price;
					if (bargain) {
						this.price = Properties.BARGAINBUSINESS_PRICE;
						pl.removeBargainBusinessCard();
					}
					pl.buySquare(this);
					this.price = tempPrice;
					
					System.out.println("Player bought " + this.name + ". Player has "
						+ pl.getNumberOfOwnedByColor(this.color) + " of this color");
					if (pl.getNumberOfOwnedByColor(this.color) == 3)
						System.out.println("Now player will get double rents!!!");
				} else
					System.out.println("You don't have enough money!");
			}
		} else {
			if (this.owner != pl) {
				int totalRent = rent;
				System.out.println("This land is owned by " + owner.getName());
								
				if (owner.getNumberOfOwnedByColor(this.color) == landsOfThisColor())
					totalRent *=3;	//Monopoly
				else if(owner.getNumberOfOwnedByColor(this.color)>landsOfThisColor()/2)
					totalRent *=2;
				
				if (owner.hasRenovationSuccess()){
				new MessageDisplayer("This land's owner has renovation success card, rent is now $50 more");
				totalRent +=50;
				owner.removeRenovationSuccessCard();
				}
				
				pl.pay(owner, totalRent);
				
			}
			else
				System.out.println("Player already owns this land!");
		}
	}
	public color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void setOwner(Player player) {
		this.owner = player;
	}
	
	public void sell() {
		this.owner.sellSquare(this);
	}
	
	@Override
	public Player getOwner() {
		return this.owner;
	}
	
	public boolean isOwned()
	{
		if (this.owner != null)
			return true;
		else
			return false;
	}
	private int landOccupation(){ //returns that colors occupation
		int occupation = 0;
		for(int i=0;i<Main.Main.players.length;i++) 
			occupation += Main.Main.players[i].getNumberOfOwnedByColor(this.color);
		return occupation;
	}
	private int landsOfThisColor(){
		int number = 0;
		for(int i=0;i<Main.Main.gameSquares.length;i++){
			GameSquare a = Main.Main.gameSquares[i];
			if((a instanceof Land)) {
				if(((Land) a).getColor() == this.color) number++;
			}
		}
		return number;
	}
	// ////////// DO NOT USE THESE METHODS - THESE ARE JUST FOR DEBUGGING ////////// //
	public void setName(String name) {
		this.name = name;
	}
	
	public void setColor(color color) {
		this.color = color;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public int getRent() {
		return rent;
	}
	
	// ///////////////////////////////////////////////////////////////////////////// //
	
	@Override
	public String toString() {
		return name;
	}
	
	public String toString2() {
		if (doubleRent)
			return name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + rent * 2 + " (Doubled since a player owns all three of these colour.)";
		else
			return name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + rent;
	}
}
