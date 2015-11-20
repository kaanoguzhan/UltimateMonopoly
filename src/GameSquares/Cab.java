package GameSquares;

import gui.AdditionalWindows.InputReaders.GetTextInput;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;
import Main.Player;
import Main.Properties;

public class Cab extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	private String				name;
	
	public Cab(int id, String name) {
		super(id, type.Cab);
		this.name = name;
	}
	
	@Override
	public void onArrive(Player pl) {
		if (new GetYesNoInput("Its the " + name + " cab !", "Do you want to pay 50$ and go anywhere you want ?")
			.getValue()) {
			pl.reduceMoney(Properties.CAB_MONEY);
			int moveTo = Integer.MAX_VALUE;
			while (!((0 <= moveTo) && (moveTo < Properties.TOTAL_SQUARES)))
				moveTo = new GetTextInput(
					"Enter the square you want to go, should be between 0 (GO) and 119(Lobard Street)")
					.getInt();
			pl.moveTo(moveTo);
		}
		
	}
	
	@Override
	public String toString() {
		return name + "Cab Co";
	}	
}
