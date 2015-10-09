package GameSquares.Chance.ChanceCards;

import GameSquares.Chance.ChanceCard;
import Main.Player;

public class AdvanceToSqueezePlay extends ChanceCard {
	
	public AdvanceToSqueezePlay() {
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		System.out.println(pl.getName() + " picked AdvanceToSqueezePlay Card.");
		pl.moveTo(15);
	}
}
