package GameSquares.Chance.ChanceCards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Chance.ChanceCard;
import GameSquares.Land.color;
import GameSquares.Land.state;
import Main.Player;
import gui.AdditionalWindows.MessageDisplayer;

public class Hurricane extends ChanceCard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Hurricane(){super();}

	@Override
	public void onDraw(Player pl) {
		new MessageDisplayer(toString());
		
		Player selected = null;
		boolean found = false;
		color selectedColor = null;
		
		ArrayList<Land.color> colors = new ArrayList<color>(Arrays.asList(color.values()));
		while(!colors.isEmpty() && !found){
			int j = new Random().nextInt(colors.size());
			int i = new Random().nextInt(Main.Main.players.length);
			int k = i;
			selectedColor = colors.get(j);
			
			while(selected==null){
				if(pl!=Main.Main.players[i])
					selected = Main.Main.players[i];
				
				if(selected.getNumberOfOwnedByColor(selectedColor) == landsOfThisColor(selectedColor))
					found = true;
				else{
					i = (i+1)%Main.Main.players.length;
					if (k!=i) selected=null;
				}
			}
			colors.remove(j);
		}
		
		if(found)
			for(int i=0; i<Main.Main.gameSquares.length;i++){
				GameSquare a = Main.Main.gameSquares[i];
				if(a instanceof Land) 
					if(((Land) a).getColor()==selectedColor) 
						downGrade((Land) a);
			}
		else new MessageDisplayer("No opponent have a color group");
	}
	
	private void downGrade(Land a){
		state s = a.getState();
		if(s==state.house)a.setState(state.unImproved);
		else if(s==state.twoHouse)a.setState(state.house);
		else if(s==state.threeHouse)a.setState(state.house);
		else if(s==state.fourHouse)a.setState(state.house);
		else if(s==state.hotel)a.setState(state.house);
		else if(s==state.skyscraper)a.setState(state.house);
	}
	
	public int landsOfThisColor(color c){
		int number = 0;
		for(int i=0;i<Main.Main.gameSquares.length;i++){
			GameSquare a = Main.Main.gameSquares[i];
			if((a instanceof Land)) {
				if(((Land) a).getColor() == c) number++;
			}
		}
		return number;
	}

	@Override
	public String toString() {
		return "You picked hurricane chance card, a players color grouping is downgraded";
	}

}