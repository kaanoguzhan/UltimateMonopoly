package GameSquares.Chance.ChanceCards;

import java.io.Serializable;
import GameSquares.Chance.ChanceCard;
import Main.Player;
import gui.AdditionalWindows.MessageDisplayer;

public class MardiGras extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public MardiGras(){
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		Player[] players = Main.Main.players;
		for(int i=0;i<players.length;i++){
			if(players[i].getLocation() != -1)
				players[i].moveTo(49);
		}
	}

	@Override
	public String toString() {
		return "You picked Margi Gras card. Every player advence to Canal Street.";
	}

}
