package Main;

import gui.Board.PlayerInfo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import GameSquares.GameSquare;

public class SaveLoad {
    
    public static void save() {
        try {
            Object[] objArry = { Main.players, Main.gameSquares, Main.CurrentPlayer,
                    Main.board.round.getButtonEnableds() };
            
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
            
            // Read Data
            Object[] obj = (Object[]) obj_in.readObject();
            
            // Load Game
            Main.stopTurnLoop();
            Main.players = (Player[]) obj[0];
            Main.gameSquares = (GameSquare[]) obj[1];
            Main.CurrentPlayer = (Player) obj[2];
            Main.board.round.setButtonEnableds((boolean[]) obj[3]);
            
            // Check for error
            if (Main.players == null || Main.gameSquares == null)
                System.out.println("!!! Error on loading objects !!!");
            
            // Save Protection
            PlayerInfo.refreshData();
            Main.board.initiateLoadProtection();
            
            // Close InputStreams
            f_in.close();
            obj_in.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }
}
