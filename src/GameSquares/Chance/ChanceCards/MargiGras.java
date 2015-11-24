package GameSquares.Chance.ChanceCards;

import java.io.Serializable;
import GameSquares.Chance.ChanceCard;
import Main.Player;
import Main.Properties;
import gui.AdditionalWindows.MessageDisplayer;

public class MargiGras extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;

	public MargiGras(){
		super();
	}
	
	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		Player[] players = Main.Main.players;
		for(int i=0;i<players.length;i++){
			if((players[i].getLocation() != Properties.HEAVEN_LOCATION)
					|| !players[i].isJailed())
				players[i].moveTo(49);
		}
	}

	@Override
	public String toString() {
		return "You picked Margi Gras card. Every player advance to Canal Street.";
	}

}
