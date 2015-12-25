package unittesting;
import static org.junit.Assert.*;

import org.junit.Test;
import Main.Main;
import GameSquares.GameSquare;
import Main.Player;

public class PlayerTest{
	
	@Test
	public void testTransitPassOdd(){	
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Player temp = new Player(0,"kerem",squares);
		temp.setLocation(1);
		temp.testing = true;
		temp.moveBy(5);
		int locationOfPlayer = temp.getLocation();
		assertTrue("repOk?",temp.repOK());
		assertEquals("testing of passing from railroad with rolled dice with odd value", 6, locationOfPlayer);
		
	}
	
	@Test
	public void testTransitPassEven(){
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Player temp = new Player(0,"kerem",squares);
		temp.setLocation(1);
		temp.testing = true;
		temp.moveBy(5);
		int locationOfPlayer = temp.getLocation();
		
		assertTrue("repOk?",temp.repOK());
		assertEquals("testing of passing from railroad with rolled dice with odd value", 52, 52);
		
	}
//
//	
//	@Test
//	public void testNOTransitPassPayDayEven(){
//		
//		Main.initializeGameSquares();
//		GameSquare [] a = Main.gameSquares;
//		Player temp = new Player(0,"kerem",a);
//		temp.testing = true;
//		temp.moveBy(10);
//		int b = temp.getLocation();
//		assertEquals("testing square id", 52, 52);
//		
//	}
//	
//	@Test
//	public void testNOTransitPassPayDayOdd(){
//		
//		Main.initializeGameSquares();
//		GameSquare [] a = Main.gameSquares;
//		Player temp = new Player(0,"kerem",a);
//		temp.testing = true;
//		temp.moveBy(10);
//		int b = temp.getLocation();
//		assertEquals("testing square id", 52, 52);
//		
//	}
//	
//	@Test
//	public void testNOTransitPassBonus(){
//		
//		Main.initializeGameSquares();
//		GameSquare [] a = Main.gameSquares;
//		Player temp = new Player(0,"kerem",a);
//		temp.testing = true;
//		temp.moveBy(10);
//		int b = temp.getLocation();
//		assertEquals("testing square id", 52, 52);
//		
//	}
//	
//	@Test
//	public void testNOTransitPassStartSquare(){
//		
//		Main.initializeGameSquares();
//		GameSquare [] a = Main.gameSquares;
//		Player temp = new Player(0,"kerem",a);
//		temp.testing = true;
//		temp.moveBy(10);
//		int b = temp.getLocation();
//		assertEquals("testing square id", 52, 52);
//		
//	}
//	
//	@Test
//	public void testNOTransitPassNone(){
//		
//		Main.initializeGameSquares();
//		GameSquare [] a = Main.gameSquares;
//		Player temp = new Player(0,"kerem",a);
//		temp.testing = true;
//		temp.moveBy(10);
//		int b = temp.getLocation();
//		assertEquals("testing square id", 52, 52);
//		
//	}
	
}
