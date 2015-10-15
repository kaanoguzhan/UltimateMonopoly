package Main;

import gui.Board;
import gui.GetSimpleInput;
import java.util.Scanner;
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

public class Main {
	
	static ChanceDeck			chanceDeck		= null;
	static CommunityChestDeck	communityDeck	= null;
	static GameSquare[]			gameSquares		= null;
	static Player[]				players			= null;
	static Scanner				scanner;
	static Board				board;
	static Boolean				play			= true;
	static Boolean				pause			= true;
	
	public static void main(String[] args) {
		initializePlayers();
		initializeDecks();
		initializeGameSquares();
		initializePlayerNames();
		initializeBoard();
		
		runGame();
		// Test test = new Test(players);
		// test.playForRound(0);
		//
		// Admin admin = new Admin();
		// admin.movePlayerTo(players[0], 0);
		// admin.movePlayerToForced(players[0], 0);
		// admin.setMoney(players[0], 5000);
		// admin.increaseMoneyBy(players[0], 2000);
		// admin.decreaseMoneyBy(players[0], 1000);
		// admin.giveOwnership(players[0], gameSquares[1], gameSquares[3], gameSquares[4]);
		//
		// admin.movePlayerTo(players[1], 3);
		//
		// System.out.println(gameSquares[1]);
		// admin.setName(gameSquares[1], "DNEME");
		// System.out.println(gameSquares[1]);
		// admin.setColor(gameSquares[1], color.pink);
		// System.out.println(gameSquares[1]);
		// admin.setPrice(gameSquares[1], 5000);
		// System.out.println(gameSquares[1]);
	}
	
	private static void initializePlayers() {
		int numOfPlayers = Integer.parseInt(new GetSimpleInput("How many players?").getValue());
		players = new Player[numOfPlayers];
		
		System.out.println("Player initialization is complete...");
	}
	private static void initializeDecks() {
		chanceDeck = new ChanceDeck(players);
		communityDeck = new CommunityChestDeck();
		System.out.println("Deck initialization is complete...");
	}
	
	private static void initializeGameSquares() {
		gameSquares = new GameSquare[Properties.TotalSquares];
		
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
				name = new GetSimpleInput("Name of player " + (i + 1) + " : ").getValue();
			players[i] = new Player(i, name, gameSquares);
		}
		
		System.out.println("Player Name initialization is complete...");
	}
	
	private static void initializeBoard() {
		board = new Board(players, gameSquares);
	}
	
	private static void runGame() {
		int playerID = 0;
		while (play) {
			pause = true;
			board.setCurrentPlayer(playerID);
			
			while (pause) {
				for (int i = 0; i < 1000000; i++) {
					
				}
			}
			
			playerID = playerID++ % players.length;
		}
	}
	
	public static void unPause() {
		pause = false;
	}
	
	public static void endGame() {
		play = false;
	}
}
