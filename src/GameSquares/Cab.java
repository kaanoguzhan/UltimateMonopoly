package GameSquares;

import gui.AdditionalWindows.InputReaders.GetTextInput;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class Cab extends GameSquare implements Ownable {
	private static final long	serialVersionUID	= 1L;
	private String				name;
	private int					rideCost			= Properties.CAB_RIDE_COST;
	private int					ownedRideCost		= Properties.CAB_OWNED_RIDE_COST;
	private int					price				= Properties.CAB_PRICE;
	private int					cabStandCost		= Properties.CAB_STAND_COST;
	private boolean				cabStand			= false;
	
	public Cab(int id, String name) {
		super(id, type.Cab);
		this.name = name;
	}
	
	@Override
	public void onArrive(Player pl) {
		if (this.owner == null) {
			boolean buy = new GetYesNoInput("For " + price + " dollars", "Would you like to buy " + name + " ?")
				.getValue();
			if (buy) {
				if (pl.getMoney() >= price)
					pl.buySquare(this);
				else
					System.out.println("You don't have enough money!");
			}
		} else if (this.owner != pl) {
			if (cabStand)
				pl.pay(this.getOwner(), 2 * rideCost);
			else
				pl.pay(this.getOwner(), rideCost);
			if (new GetYesNoInput("Its the " + name + " cab !", "Do you want to pay 50$ to take the cab ?")
				.getValue()) {
				playerUseCab(pl);
				pl.pay(this.getOwner(), rideCost);
			}
		} else {
			boolean useCab = new GetYesNoInput("You own " + name + " cab !",
				"Do you want to pay 20$ to take the cab ?")
				.getValue();
			if (useCab) {
				pl.reduceMoney(ownedRideCost);
				Main.Main.pool += ownedRideCost;
				playerUseCab(pl);
			} else if (!cabStand) {
				if (new GetYesNoInput("Build Cab Stand", "Do you want to pay 150$ to build Cab Stand ?")
					.getValue()) {
					pl.reduceMoney(cabStandCost);
					this.cabStand = true;
				}
			}
		}
	}
	
	private boolean checkMove(int i) {
		return (i == 20) || (i == 46) || (i == 62) || (i == 74) || (i == 90) || (i == 5) || (i == 25) || (i == 105)
			|| (i == 117);
	}
	
	private void playerUseCab(Player pl) {
		int moveTo = 0;
		while (!checkMove(moveTo)) {
			moveTo = new GetTextInput("For free parking press 20; the cab companies 46, 62, 74, 90;"
				+ " transit stations 5 ,25, 105, 117").getInt();
			if (checkMove(moveTo))
				pl.moveTo(moveTo);
		}
	}
	
	public void sell() {
		this.owner.sellSquare(this);
	}
	
	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public String getName() {
		return name + "Cab Co";
	}
	
	@Override
	public String toString() {
		return name + "Cab Co";
	}
}
