package GameSquares;

import gui.AdditionalWindows.InputReaders.GetTextInput;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class Cab extends GameSquare implements Ownable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int rent = 50;
	private int price = 300;
	// private int cabStandCost = 150;
	private boolean cabStand = false;

	public Cab(int id, String name) {
		super(id, type.Cab);
		this.name = name;
	}

	@Override
	public void onArrive(Player pl) {
		if (this.owner != null) {
			boolean useCab = false;
			int cabBill = 0;
			if (this.owner != pl) {
				if (cabStand)
					pl.pay(this.getOwner(), 2 * rent);
				else
					pl.pay(this.getOwner(), rent);

				useCab = new GetYesNoInput("Its the " + name + " cab !", "Do you want to pay 50$ to take the cab ?")
						.getValue();
				if (useCab) {
					playerUseCab(pl);
					cabBill = Properties.CAB_MONEY;
					pl.pay(this.getOwner(), cabBill);
				}
			} else {
				useCab = new GetYesNoInput("You own " + name + " cab !", "Do you want to pay 20$ to take the cab ?")
						.getValue();
				if (useCab) {
					cabBill = Properties.OWNED_CAB_MONEY;
					pl.payToPool(cabBill);
				}
			}
		} else {
			boolean buy = new GetYesNoInput("For " + price + " dollars", "Would you like to buy " + name
					+ " cab station?").getValue();

			if (buy) {
				if (pl.getMoney() >= price) {
					// pl.buyLand(this);

					System.out.println("Player bought " + this.name + " cab company.");
				} else
					System.out.println("You don't have enough money!");
			}
		}
	}

	@Override
	public String toString() {
		return name + "Cab Co";
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

	}

	@Override
	public int getPrice() {
		return price;
	}
}
