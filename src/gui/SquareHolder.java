package gui;

import java.util.ArrayList;

public class SquareHolder {
	ArrayList<Square> squares = new ArrayList<Square>();
	
	public void addSquare(int x, int y, int iD){
		squares.add(new Square(x,y,iD));
		System.out.println(x+" , "+ y);
	}
	
	public void generateSquares(){
		int sqLenght = 115;
		int boardLenght = 695;
		for(int i=0;i<20;i++){
			if(i<5) 
				addSquare(boardLenght-(i*sqLenght), boardLenght, i);
			else if(i<10) 
				addSquare(sqLenght+5, boardLenght-((i-5)*sqLenght),i);
			else if(i<15) 
				addSquare(sqLenght+5+((i-10)*sqLenght), sqLenght+5,i);
			else
				addSquare(boardLenght, sqLenght+5+((i-15)*sqLenght),i);
		}
	}
}
