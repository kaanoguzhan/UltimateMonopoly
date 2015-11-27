package GameSquares.Cards.CommunityChestCards;

import gui.AdditionalWindows.MessageDisplayer;
import java.io.Serializable;
import GameSquares.Cards.CommunityChestCard;
import Main.Player;

public class RecieveConsultancyFee extends CommunityChestCard implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	public RecieveConsultancyFee() {
		super(CardType.RecieveConsultancyFee,false);
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		pl.addMoney(25);
	}
	
	@Override
	public String toString() {
		return "You picked RecieveConsultancyFee Card.";
	}
	
	@Override
	public String getName() {
		return "Recieve Consultancy Fee";
	}
}
