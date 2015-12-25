package unittesting;

import static org.junit.Assert.*;

import org.junit.Test;

import GameSquares.GameSquare;
import GameSquares.Land;
import GameSquares.Land.state;
import Main.Main;
import Main.Player;

public class LandTest {

	@Test
	public void testRepresentation() {
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Land temp = (Land) squares[1];
		assertTrue("representation check",temp.repOK());
	}
	
	@Test
	public void testBuildStructureWhenNothingIsBuild() {
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Land landTester1 = (Land) squares[1];
		Land landTester2 = (Land) squares[3];
		
		Player abdullah = new Player(0,"abdullah",squares);
		abdullah.buySquare(landTester1);
		abdullah.buySquare(landTester2);
		
		landTester1.buildStructure(abdullah);
		
		assertEquals("testing if building house works",landTester1.currentState,state.house);
		assertTrue("representation check",landTester1.repOK());
		
	}

	@Test
	public void testBuildStructureWhenFourHousesBuilt() {
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Land landTester1 = (Land) squares[1];
		Land landTester2 = (Land) squares[3];
		
		Player abdullah = new Player(0,"abdullah",squares);
		abdullah.buySquare(landTester1);
		abdullah.buySquare(landTester2);
		
		landTester1.testing=true;
		landTester1.setState(state.fourHouse);
		landTester2.setState(state.fourHouse);
		landTester1.buildStructure(abdullah);
		
		assertEquals("testing if building hotel works",landTester1.currentState,state.hotel);
		assertTrue("representation check",landTester1.repOK());
		
	}
	
	@Test
	public void testBuildStructureWhenHotelIsBuild() {
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Land landTester1 = (Land) squares[1];
		Land landTester2 = (Land) squares[3];
		
		Player abdullah = new Player(0,"abdullah",squares);
		abdullah.buySquare(landTester1);
		abdullah.buySquare(landTester2);
		
		landTester1.testing=true;
		landTester1.setState(state.hotel);
		landTester2.setState(state.hotel);
		landTester1.buildStructure(abdullah);
		
		assertEquals("testing if building skyscraper works",landTester1.currentState,state.skyscraper);
		assertTrue("representation check",landTester1.repOK());
		
	}
	
	@Test
	public void testBuildStructureWhenPlayerHasNoMoney() {
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Land landTester1 = (Land) squares[1];
		Land landTester2 = (Land) squares[3];
		
		Player abdullah = new Player(0,"abdullah",squares);
		abdullah.buySquare(landTester1);
		abdullah.buySquare(landTester2);
		
		abdullah.setMoney(0);
		landTester1.testing=true;
		landTester1.buildStructure(abdullah);
		
		assertEquals("testing to build structure when player does not have enough money",landTester1.currentState,state.unImproved);
		assertTrue("representation check",landTester1.repOK());

	}
	
	@Test
	public void testBuildStructureWhenSkyscraperIsBuild() {
		Main.initializeGameSquares();
		GameSquare [] squares = Main.gameSquares;
		Land landTester1 = (Land) squares[1];
		Land landTester2 = (Land) squares[3];
		
		Player abdullah = new Player(0,"abdullah",squares);
		abdullah.buySquare(landTester1);
		abdullah.buySquare(landTester2);
		
		landTester1.testing=true;
		landTester1.setState(state.skyscraper);
		landTester2.setState(state.skyscraper);
		landTester1.buildStructure(abdullah);

		assertEquals("testing if trying to build structure does anything when it has a skyscraper",landTester1.currentState,state.skyscraper);
		assertTrue("representation check",landTester1.repOK());
		
	}
	
}
