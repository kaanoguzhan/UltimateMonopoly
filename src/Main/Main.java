package Main;

import gui.AdditionalWindows.InputReaders.GetTextInput;
import gui.Board.Board;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import GameSquares.Auction;
import GameSquares.BirthdayGiftSquare;
import GameSquares.BonusSquare;
import GameSquares.BusTicketSquare;
import GameSquares.Cab;
import GameSquares.CableCompany;
import GameSquares.ElectricCompany;
import GameSquares.FreePark;
import GameSquares.GameSquare;
import GameSquares.GasCompany;
import GameSquares.GoToJail;
import GameSquares.HollandTunnel;
import GameSquares.InternetServiceProvider;
import GameSquares.Jail;
import GameSquares.Land;
import GameSquares.Land.color;
import GameSquares.PayDay;
import GameSquares.ReverseDirection;
import GameSquares.RollOnce;
import GameSquares.SewageSystem;
import GameSquares.SqueezePlay;
import GameSquares.StartSquare;
import GameSquares.StockExchange;
import GameSquares.Subway;
import GameSquares.TelephoneCompany;
import GameSquares.TransitStation;
import GameSquares.TrashCollector;
import GameSquares.WaterWorks;
import GameSquares.Chance.Chance;
import GameSquares.Chance.ChanceDeck;
import GameSquares.CommunityChest.CommunityChest;
import GameSquares.CommunityChest.CommunityChestDeck;
import GameSquares.Taxes.IncomeTax;
import GameSquares.Taxes.LuxuryTax;
import GameSquares.Taxes.TaxRefund;

public class Main {

	protected static ChanceDeck chanceDeck = null;
	protected static CommunityChestDeck communityDeck = null;
	public static GameSquare[] gameSquares = null;
	public static Player[] players = null;
	static Boolean play = true;
	volatile static Boolean roundEnded = false;
	private static GetTextInput temp;
	static Board board;
	public static int pool = 0;

	public static void main(String[] args) {
		changeUITheme();
		initializePlayers();
		initializeDecks();
		initializeGameSquares();
		initializePlayerNames();
		initializeBoard();

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
		String numberOfPlayers = "";
		try {
			while (num0fPlayers == 0 || num0fPlayers < 0 || numberOfPlayers == null) {
				temp = new GetTextInput("How many players?");
				num0fPlayers = temp.getInt();
				numberOfPlayers = temp.getString();
			}
			players = new Player[num0fPlayers];
		} catch (Exception e) {
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
		gameSquares[1] = new Land(1, "Mediterranean Avenue", color.puple, 60, 2);
		gameSquares[2] = new CommunityChest(2, communityDeck);
		gameSquares[3] = new Land(3, "Baltic Avenue", color.puple, 60, 4);
		gameSquares[4] = new IncomeTax(4);
		gameSquares[5] = new TransitStation(5, 47);
		gameSquares[6] = new Land(6, "Oriental Avenue", color.lightBlue, 100, 6);
		gameSquares[7] = new Chance(7, chanceDeck, players);
		gameSquares[8] = new Land(8, "Vermont Avenue", color.lightBlue, 100, 6);
		gameSquares[9] = new Land(9, "Connecticut Avenue", color.lightBlue, 100, 8);
		gameSquares[10] = new Jail(10);
		gameSquares[11] = new Land(11, "St. Charles Place", color.pink, 140, 10);
		gameSquares[12] = new ElectricCompany(12);
		gameSquares[13] = new Land(13, "States Avenue", color.pink, 140, 10);
		gameSquares[14] = new Land(14, "Virginia Avenue", color.pink, 160, 12);
		gameSquares[15] = new TransitStation(15, 105);
		gameSquares[16] = new Land(11, "St. James Place", color.orange, 180, 14);
		gameSquares[17] = new CommunityChest(17, communityDeck);
		gameSquares[18] = new Land(18, "Tennessee Avenue", color.orange, 180, 14);
		gameSquares[19] = new Land(19, "New York Avenue", color.orange, 200, 16);
		gameSquares[20] = new FreePark(20);
		gameSquares[21] = new Land(21, "Kentucky Avenue", color.red, 220, 18);
		gameSquares[22] = new Chance(22, chanceDeck, players);
		gameSquares[23] = new Land(23, "Indiana Avenue", color.red, 220, 18);
		gameSquares[24] = new Land(24, "Illinois Avenue", color.red, 240, 20);
		gameSquares[25] = new TransitStation(25, 75);
		gameSquares[26] = new Land(26, "Atlantic Avenue", color.yellow, 260, 22);
		gameSquares[27] = new Land(27, "Ventnor Avenue", color.yellow, 260, 22);
		gameSquares[28] = new WaterWorks(28);
		gameSquares[29] = new Land(29, "Marvin Gardens", color.yellow, 280, 22);
		gameSquares[30] = new RollOnce(30);
		gameSquares[31] = new Land(31, "Pacific Avenue", color.green, 300, 26);
		gameSquares[32] = new Land(32, "North Carolina Avenue", color.green, 300, 26);
		gameSquares[33] = new CommunityChest(33, communityDeck);
		gameSquares[34] = new Land(34, "Pennsylvania Avenue", color.green, 320, 28);
		gameSquares[35] = new TransitStation(35, 117);
		gameSquares[36] = new Chance(36, chanceDeck, players);
		gameSquares[37] = new Land(37, "Park Place", color.blue, 350, 35);
		gameSquares[38] = new LuxuryTax(38);
		gameSquares[39] = new Land(39, "Boardwalk", color.blue, 400, 50);
		gameSquares[40] = new Subway(40);
		gameSquares[41] = new Land(41, "Lake Street", color.lightPink, 30, 1);
		gameSquares[42] = new CommunityChest(42, communityDeck);
		gameSquares[43] = new Land(43, "Nicollet Avenue", color.lightPink, 30, 1);
		gameSquares[44] = new Land(44, "Hennepin Avenue", color.lightPink, 60, 3);
		gameSquares[45] = new BusTicketSquare(45);
		gameSquares[46] = new Cab(46, "Checker");
		gameSquares[47] = new TransitStation(47, 5);
		gameSquares[48] = new Land(48, "Esplanade Avenue", color.lightGreen, 90, 5);
		gameSquares[49] = new Land(49, "Canal Street", color.lightGreen, 90, 5);
		gameSquares[50] = new Chance(50, chanceDeck, players);
		gameSquares[51] = new CableCompany(51);
		gameSquares[52] = new Land(52, "Magazine Street", color.lightGreen, 120, 8);
		gameSquares[53] = new Land(53, "Bourbon Street", color.lightGreen, 120, 8);
		gameSquares[54] = new HollandTunnel(54, 114);
		gameSquares[55] = new Auction(55);
		gameSquares[56] = new Land(56, "Katy Freeway", color.lightYellow, 150, 11);
		gameSquares[57] = new Land(57, "Westheimer Road", color.lightYellow, 150, 11);
		gameSquares[58] = new InternetServiceProvider(58);
		gameSquares[59] = new Land(59, "Kýrby Drive", color.lightYellow, 180, 14);
		gameSquares[60] = new Land(60, "Cullen Bouleward", color.lightYellow, 180, 14);
		gameSquares[61] = new Chance(61, chanceDeck, players);
		gameSquares[62] = new Cab(62, "Black and White");
		gameSquares[63] = new Land(63, "Deklab Avenue", color.oceanGreen, 210, 17);
		gameSquares[64] = new CommunityChest(64, communityDeck);
		gameSquares[65] = new Land(65, "Andrew Young Itnl Boulevard", color.oceanGreen, 210, 17);
		gameSquares[66] = new Land(66, "Decatur Street", color.oceanGreen, 240, 20);
		gameSquares[67] = new Land(67, "Peachtree Street", color.oceanGreen, 240, 20);
		gameSquares[68] = new PayDay(68);
		gameSquares[69] = new Land(69, "Randolph Street", color.magenta, 270, 23);
		gameSquares[70] = new Chance(70, chanceDeck, players);
		gameSquares[71] = new Land(71, "Randolph Street", color.magenta, 270, 23);
		gameSquares[72] = new Land(72, "Wacker Drive", color.magenta, 300, 26);
		gameSquares[73] = new Land(73, "Michigan Avenue", color.magenta, 300, 26);
		gameSquares[74] = new Cab(74, "Yellow");
		gameSquares[75] = new TransitStation(75, 25);
		gameSquares[76] = new CommunityChest(76, communityDeck);
		gameSquares[77] = new Land(77, "South Temple", color.gold, 330, 32);
		gameSquares[78] = new Land(78, "West Temple", color.gold, 330, 32);
		gameSquares[79] = new TrashCollector(79);
		gameSquares[80] = new Land(80, "North Temple", color.gold, 360, 38);
		gameSquares[81] = new Land(81, "Temple Square", color.gold, 360, 38);
		gameSquares[82] = new GoToJail(82);
		gameSquares[83] = new Land(83, "South Street", color.lightRed, 390, 45);
		gameSquares[84] = new Land(84, "Broad Street", color.lightRed, 390, 45);
		gameSquares[85] = new Land(85, "Walnut Street", color.lightRed, 420, 55);
		gameSquares[86] = new CommunityChest(86, communityDeck);
		gameSquares[87] = new Land(87, "Market Street", color.lightRed, 420, 55);
		gameSquares[88] = new BusTicketSquare(88);
		gameSquares[89] = new SewageSystem(89);
		gameSquares[90] = new Cab(90, "Ute");
		gameSquares[91] = new BirthdayGiftSquare(91);
		gameSquares[92] = new Land(92, "Mulholland Drive", color.darkRed, 450, 70);
		gameSquares[93] = new Land(93, "Ventura Boulevard", color.darkRed, 480, 80);
		gameSquares[94] = new Chance(94, chanceDeck, players);
		gameSquares[95] = new Land(95, "Rodeo Drive", color.darkRed, 510, 90);
		gameSquares[96] = new SqueezePlay(96, players);
		gameSquares[97] = new Land(97, "The Embarcadero", color.white, 210, 17);
		gameSquares[98] = new Land(98, "Fisherman's Wharf", color.white, 250, 21);
		gameSquares[99] = new TelephoneCompany(99);
		gameSquares[100] = new CommunityChest(100, communityDeck);
		gameSquares[101] = new Land(101, "Beacon Street", color.black, 330, 30);
		gameSquares[102] = new BonusSquare(102);
		gameSquares[103] = new Land(103, "Boylston Street", color.black, 330, 30);
		gameSquares[104] = new Land(104, "NewBurly Street", color.black, 380, 40);
		gameSquares[105] = new TransitStation(105, 15);
		gameSquares[106] = new Land(106, "Fift Avenue", color.grey, 430, 60);
		gameSquares[107] = new Land(107, "Madison Avenue", color.grey, 430, 60);
		gameSquares[108] = new StockExchange(108);
		gameSquares[109] = new Land(109, "Wall Street", color.grey, 500, 80);
		gameSquares[110] = new TaxRefund(110);
		gameSquares[111] = new GasCompany(111);
		gameSquares[112] = new Chance(112, chanceDeck, players);
		gameSquares[113] = new Land(113, "Florida Avenue", color.brown, 130, 9);
		gameSquares[114] = new HollandTunnel(114, 54);
		gameSquares[115] = new Land(115, "Miami Avenue", color.brown, 130, 9);
		gameSquares[116] = new Land(116, "Biscayne Avenue", color.brown, 150, 11);
		gameSquares[117] = new TransitStation(117, 35);
		gameSquares[118] = new ReverseDirection(118);
		gameSquares[119] = new Land(119, "Lobard Street", color.white, 210, 17);
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
				while (!roundEnded)
					;
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
