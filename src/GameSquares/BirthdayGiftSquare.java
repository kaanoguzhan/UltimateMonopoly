package GameSquares;

import Main.Player;
import gui.AdditionalWindows.InputReaders.GetYesNoInput;

public class BirthdayGiftSquare extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	private final int giftMoney = 100;
	private final int nearestCabId = 46;
	
	public BirthdayGiftSquare(int id) {
		super(id, type.BirthdayGift);
	}
	
	@Override
	public void onArrive(Player pl) {
		boolean birthdayGiftChoice = new GetYesNoInput("You can get "+giftMoney+"$ or go to the nearest cab", 
        		"Do you want get the "+giftMoney+"$?").getValue();
		
		if(birthdayGiftChoice)
			pl.addMoney(giftMoney);
		else
			pl.moveTo(nearestCabId);
	}
	
	@Override
	public String toString() {
		return "Bithday Gift Square";
	}
	
}
