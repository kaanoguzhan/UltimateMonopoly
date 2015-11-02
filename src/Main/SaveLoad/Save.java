package Main.SaveLoad;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.CommunityChest.CommunityChest.CommunityChestCardType;
import Main.Admin;

public class Save {
	
	public Save() {
		// TODO Auto-generated constructor stub
	}
	
	public static void save() {
		try {
			PrintWriter writer = new PrintWriter(new File("Save.txt"));
			writer.println(getPlayerString());
			writer.println(getGameSquareString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String getPlayerString() {
		String output = "" + Admin.getPlayerCount() + ",";
		for (int i = 0; i < Admin.getPlayerCount(); i++) {
			output += Admin.getPlayerName(i) + "," + Admin.getPlayerMoney(i) + "," + Admin.getPlayerLocation(i) + ",";
			for (Land lnd : Admin.getPlayerLands(i))
				output += lnd.getName() + "-";
			output = output.substring(0, output.length()-1)+",";
			for (CommunityChestCardType cccType : Admin.getPlayerCommunityChestCards(i))
				output += cccType.name() + "-";
			output = output.substring(0, output.length()-1)+",";
		}
		
		return output;
	}
	private static String getGameSquareString() {
		String output = "" + Admin.getGameSquareCount() + ",";
		for (GameSquare gs : Admin.getGameSquares()) {
			output+=gs.
		}
		return output;
	}
	
}
