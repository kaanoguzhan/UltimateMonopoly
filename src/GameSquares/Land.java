package GameSquares;

import gui.AdditionalWindows.MessageDisplayer;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;

import java.util.HashMap;

import Main.Player;
import Main.Properties;

public class Land extends GameSquare implements Ownable{
	private static final long	serialVersionUID	= 1L;
	private String	name;
	private color	color;
	private int		price;
	public boolean	buy;
	public state currentState = state.unImproved;
	private HashMap<state, Integer>		rentAndPriceMap = new HashMap<state, Integer>();
	
	public enum color {
		blue, pink, orange, green, puple, lightBlue, red, yellow, white, 
		black, grey, brown, lightPink, lightGreen, lightYellow, oceanGreen,
		magenta, gold, lightRed, darkRed
	}
	
	public enum state {
		unImproved, house, twoHouse, threeHouse, fourHouse, hotel, skyscraper, mortgage,
		price, buildingCost
	}

	public Land(int id, String name, color color, int price, int rent) {
		super(id,type.Land);
		this.name = name;
		this.color = color;
		this.price = price;
		rentAndPriceMap.put(state.price, price);
		rentAndPriceMap.put(state.unImproved, rent);
	}
	
	public Land addDeedInfo(int house, int two, int three, int four, int hotel, int sky
							, int mortgage, int buildingCost){
		rentAndPriceMap.put(state.house, house);
		rentAndPriceMap.put(state.twoHouse, two);
		rentAndPriceMap.put(state.threeHouse, three);
		rentAndPriceMap.put(state.fourHouse, four);
		rentAndPriceMap.put(state.hotel, hotel);
		rentAndPriceMap.put(state.skyscraper, sky);
		rentAndPriceMap.put(state.mortgage, mortgage);
		rentAndPriceMap.put(state.buildingCost, buildingCost);
		
		return this;
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
				int totalRent = getRent();
				System.out.println("This land is owned by " + owner.getName());
				
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
	
	public void buildHouse(Player pl){
		if(pl.getMoney()>=rentAndPriceMap.get(state.buildingCost)){
			if(pl.getNumberOfOwnedByColor(color)==landsOfThisColor()){ //all deeds
				boolean built = true;
				if(currentState==state.unImproved)currentState = state.house;
				else if(currentState==state.house)currentState = state.twoHouse;
				else if(currentState==state.twoHouse)currentState = state.threeHouse;
				else if(currentState==state.threeHouse)currentState = state.fourHouse;
				else {
					built = false;
					new MessageDisplayer("You already have 4 houses");
				}
				if(built)pl.reduceMoney(rentAndPriceMap.get(state.buildingCost));
			}else new MessageDisplayer("Player should have enought properties of this color");
		}else new MessageDisplayer("Player doesn't have enought money");
	}
	
	public void buildHotel(Player pl){
		if(pl.getMoney()>=rentAndPriceMap.get(state.buildingCost)){
			if(pl.getNumberOfOwnedByColor(color)==landsOfThisColor()){
				boolean built = true;//check every land of this color have 4 houses
				for(int i=0;i<Main.Main.gameSquares.length;i++){
					GameSquare a = Main.Main.gameSquares[i];
					if((a instanceof Land)) {
						if(((Land) a).getState()==state.fourHouse) built=false;
					}
				}
				if(built){
					pl.reduceMoney(rentAndPriceMap.get(state.buildingCost));
					currentState = state.hotel;
				}else new MessageDisplayer("Player should have 4 houses each of this color");
			}else new MessageDisplayer("Player should have enought properties of this color");
		}else new MessageDisplayer("Player doesn't have enought money");
	}
	
	public void buildSkycraper(Player pl){
		if(pl.getMoney()>=rentAndPriceMap.get(state.buildingCost)){
			if(pl.getNumberOfOwnedByColor(color)==landsOfThisColor()){
				boolean built = true;//check every land of this color have hotel
				for(int i=0;i<Main.Main.gameSquares.length;i++){
					GameSquare a = Main.Main.gameSquares[i];
					if((a instanceof Land)) {
						if(((Land) a).getState()==state.hotel) built=false;
					}
				}
				if(built){
					pl.reduceMoney(rentAndPriceMap.get(state.buildingCost));
					currentState = state.skyscraper;
				}else new MessageDisplayer("Player should have hotels each of this color");
			}else new MessageDisplayer("Player should have enought properties of this color");
		}else new MessageDisplayer("Player doesn't have enought money");
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
	public state getState(){
		return currentState;
	}
	public boolean isOwned()
	{
		if (this.owner != null)
			return true;
		else
			return false;
	}
	public int landOccupation(){ //returns that colors occupation
		int occupation = 0;
		for(int i=0;i<Main.Main.players.length;i++) 
			occupation += Main.Main.players[i].getNumberOfOwnedByColor(this.color);
		return occupation;
	}
	public int landsOfThisColor(){
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
		rentAndPriceMap.remove(currentState);
		rentAndPriceMap.put(currentState, rent);
	}
	
	public int getRent() {
		int totalRent = rentAndPriceMap.get(currentState);
		if (owner.getNumberOfOwnedByColor(this.color) == landsOfThisColor())
			totalRent *=3;	//Monopoly
		else if(owner.getNumberOfOwnedByColor(color)>landsOfThisColor()-1)
			totalRent *=2;	//majority ownership
		return totalRent;
	}
	
	// ///////////////////////////////////////////////////////////////////////////// //
	
	@Override
	public String toString() {
		return name;
	}
	
	public String toString2() {
		return name + "\n Color: " + color + "\n Price: " + price
				+ "\n Rent: " + getRent();
	}
}
