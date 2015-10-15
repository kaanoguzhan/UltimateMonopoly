package gui;

import java.util.ArrayList;

public class SquareHolder {
	private ArrayList<Square>	squares	= new ArrayList<Square>();
	
	SquareHolder() {
		generateSquares();
	}
	
	private void generateSquares() {
		int squareLength = 115;
		int boardLength = 660;
		for (int i = 0; i < 20; i++) {
			if (i < 5)
				squares.add(new Square(boardLength - (i * squareLength), boardLength, i));
			else if (i < 10)
				squares.add(new Square(squareLength - 35, boardLength - ((i - 5) * squareLength), i));
			else if (i < 15)
				squares.add(new Square(squareLength - 35 + ((i - 10) * squareLength), squareLength - 35, i));
			else
				squares.add(new Square(boardLength - 5, squareLength - 35 + ((i - 15) * squareLength), i));
		}
	}
	
	
	public void addSquare(int x, int y, int iD) {
		squares.add(new Square(x, y, iD));
	}
	
	public Square getSquare(int id) {
		if (id < squares.size())
			return squares.get(id);
		return null;
	}
}


class Square {
	
	private int	X	= 5;
	private int	Y	= 5;
	private int	ID	= 0;
	
	public Square(int x, int y, int iD) {
		X = x;
		Y = y;
		ID = iD;
	}
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
