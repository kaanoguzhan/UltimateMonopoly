package Main.SaveLoad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import GameSquares.GameSquare;
import Main.Player;

public class SaveLoad {
	
	public static void save() {
		try {
			Object[] objArry = { Main.Main.players, Main.Main.gameSquares };
			
			FileOutputStream f_out = new FileOutputStream("savegame.data");
			ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
			
			// Write object to disk
			obj_out.writeObject(objArry);
			
			// Close OutputStreams
			f_out.close();
			obj_out.close();
			
		} catch (IOException e) {}
	}
	
	
	public static void load() {
		try {
			FileInputStream f_in = new FileInputStream("savegame.data");
			ObjectInputStream obj_in = new ObjectInputStream(f_in);
			
			// Read Players
			Object[] obj = (Object[]) obj_in.readObject();
			
			// Load objects
			Main.Main.players = obj[0] instanceof Player[] ? (Player[]) obj[0] : null;
			Main.Main.gameSquares = obj[1] instanceof GameSquare[] ? (GameSquare[]) obj[1] : null;
			
			// Check for error
			if (Main.Main.players == null || Main.Main.gameSquares == null)
				System.out.println("!!! Error on loading objects !!!");
			
			// Close InputStreams
			f_in.close();
			obj_in.close();
			
		} catch (IOException | ClassNotFoundException e) {}
	}
}
