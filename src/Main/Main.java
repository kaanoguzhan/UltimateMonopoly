package Main;

import gui.Board;
import gui.AdditionalWindows.InputReaders.GetTextInput;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import GameSquares.FreePark;
import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.RollOnce;
import GameSquares.SqueezePlay;
import GameSquares.StartSquare;
import GameSquares.Chance.Chance;
import GameSquares.Chance.ChanceDeck;
import GameSquares.CommunityChest.CommunityChest;
import GameSquares.CommunityChest.CommunityChestDeck;
import Main.SaveLoad.Save;

public class Main {
	protected static ChanceDeck			chanceDeck		= null;
	protected static CommunityChestDeck	communityDeck	= null;
	public static GameSquare[]			gameSquares		= null;
	public static Player[]				players			= null;
	static Board						board;
	static Boolean						play			= true;
	volatile static Boolean				roundEnded		= false;
	public static GetTextInput					temp;
	public static void main(String[] args) {
		changeUITheme();
		initializePlayers();
		initializeDecks();
		initializeGameSquares();
		initializePlayerNames();
		initializeBoard();
		Save.save();
		
		runGame();
	}
	
	private static void changeUITheme() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
	}
	
	private static void initializePlayers() {
		int num0fPlayers = 0;
		String numberOfPlayers ="";
		try {
			while (num0fPlayers == 0 || num0fPlayers < 0 || numberOfPlayers == null){
				 temp = new GetTextInput("How many players?");
				 num0fPlayers = temp.getInt();
				 numberOfPlayers = temp.getString();
			}
				
			players = new Player[num0fPlayers];
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		System.out.println("Player initialization is complete...");
	}
	
	private static void initializeDecks() {
		chanceDeck = new ChanceDeck(players);
		communityDeck = new CommunityChestDeck();
		System.out.println("Deck initialization is complete...");
	}
	
	private static void initializeGameSquares() {
		gameSquares = new GameSquare[Properties.TOTAL_SQUARES];
		
		gameSquares[0] = new StartSquare(0);
		gameSquares[1] = new Land(1, "Oriental Ave", color.blue, 100, 6);
		gameSquares[2] = new CommunityChest(2, communityDeck);
		gameSquares[3] = new Land(3, "Vermont Ave", color.blue, 100, 6);
		gameSquares[4] = new Land(4, "Connecticut", color.blue, 120, 8);
		gameSquares[5] = new RollOnce(5);
		gameSquares[6] = new Land(6, "St. Charles Place", color.pink, 140, 10);
		gameSquares[7] = new Chance(7, chanceDeck, players);
		gameSquares[8] = new Land(8, "States Ave", color.pink, 140, 10);
		gameSquares[9] = new Land(9, "Virginia", color.pink, 160, 12);
		gameSquares[10] = new FreePark(10);
		gameSquares[11] = new Land(11, "St. James Place", color.orange, 180, 14);
		gameSquares[12] = new CommunityChest(12, communityDeck);
		gameSquares[13] = new Land(13, "Tennessee", color.orange, 180, 14);
		gameSquares[14] = new Land(14, "New York Ave", color.orange, 200, 16);
		gameSquares[15] = new SqueezePlay(15, players);
		gameSquares[16] = new Land(16, "Pacific", color.green, 300, 26);
		gameSquares[17] = new Land(17, "North Carolina", color.green, 300, 26);
		gameSquares[18] = new Chance(18, chanceDeck, players);
		gameSquares[19] = new Land(19, "Pennsylvania", color.green, 320, 28);
		
		System.out.println("Game Square initialization is complete...");
	}
	
	private static void initializePlayerNames() {
		System.out.println("Write names seperated with spaces.");
		for (int i = 0; i < players.length; i++) {
			String name = null;
			while (name == null || name.length() < 1)
				name = new GetTextInput("Name of player " + (i + 1) + " : ").getString();
			players[i] = new Player(i, name, gameSquares);
		}
		
		System.out.println("Player Name initialization is complete...");
	}
	
	private static void initializeBoard() {
		board = new Board(players, gameSquares);
	}
	
	private static void runGame() {
		while (play) {
			for (int playerID = 0; playerID < players.length; playerID++) {
				board.setCurrentPlayer(playerID);
				while (!roundEnded);
				roundEnded = false;
			}
		}
	}
	
	public static void endRound() {
		roundEnded = true;
	}
	
	public static void endGame() {
		play = false;
	}
}
