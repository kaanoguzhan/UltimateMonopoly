package GameSquares;

import gui.AdditionalWindows.MessageDisplayer;
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
	private boolean				mortgaged			= false;
	
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
			if (cabStand && !isMortgaged())
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
					upgrade();
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
	
	public void mortgage() {
		if (cabStand) {
			this.owner.addMoney(price / 2);
			mortgaged = true;
		} else
			new MessageDisplayer("You need to have a cab stand in order to mortgage");
	}
	
	public void leaveMortgage(){
		int mortgageAmount = (int) (1.1*this.price);
		if(this.owner.getMoney() >= mortgageAmount){
			this.owner.reduceMoney(mortgageAmount);
			mortgaged = false;
		} else
			new MessageDisplayer("You do not have enough money to leave mortgage");
	}
	
	public boolean isMortgaged(){
		return mortgaged;
	}
	
	public void sell() {
		this.owner.sellSquare(this);
	}
	
	public boolean standed(){
		return cabStand;
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
	public void upgrade() {
		if (cabStand)
			System.out.println("No further upgrade possible");
		else
			cabStand = true;
	}
	
	@Override
	public void downgrade() {
		if (cabStand)
			cabStand = false;
		else
			System.out.println("No further downgrade possible");
	}
	
	@Override
	public String getUpgradeState() {
		return name + "Cab Co. has a Cab Stand.";
	}
	
	@Override
	public String toString() {
		return name + "Cab Co";
	}
}
