import static org.junit.Assert.*;

import org.junit.Test;
import Main.Main;
import GameSquares.GameSquare;
import Main.Player;

public class playerTest extends Main{
	
	@Test
	public void test(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		assertTrue("repOk?",temp.repOK());
		
	}
	
	
	@Test
	public void testTransitPassOdd(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}
	
	@Test
	public void testTransitPassEven(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}

	
	@Test
	public void testNOTransitPassPayDayEven(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}
	
	@Test
	public void testNOTransitPassPayDayOdd(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}
	
	@Test
	public void testNOTransitPassBonus(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}
	
	@Test
	public void testNOTransitPassStartSquare(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}
	
	@Test
	public void testNOTransitPassNone(){
		
		Main.initializeGameSquares();
		GameSquare [] a = Main.gameSquares;
		Player temp = new Player(0,"kerem",a);
		temp.testing = true;
		temp.moveBy(10);
		int b = temp.getLocation();
		assertEquals("testing square id", 52, 52);
		
	}
	
}
