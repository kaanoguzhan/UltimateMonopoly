package gui;

import java.util.ArrayList;

public class SquareHolder {
	ArrayList<Square> squares = new ArrayList<Square>();
	
	public SquareHolder(){
		
		generateSquares();
		
	}
	
	public void addSquare(int x, int y, int iD){
		squares.add(new Square(x,y,iD));		
	}
	
	public void generateSquares(){
		int squareLength = 115;
		int boardLength = 660;
		for(int i=0;i<20;i++){
			if(i<5) 
				addSquare(boardLength-(i*squareLength), boardLength, i);
			else if(i<10) 
				addSquare(squareLength-35, boardLength-((i-5)*squareLength),i);
			else if(i<15) 
				addSquare(squareLength-35+((i-10)*squareLength), squareLength-35,i);
			else
				addSquare(boardLength-5, squareLength-35+((i-15)*squareLength),i);
		}
	}
}
