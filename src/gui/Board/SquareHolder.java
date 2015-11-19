package gui.Board;

import java.util.ArrayList;

import Main.Properties;

public class SquareHolder {
	private ArrayList<Square>	squares	= new ArrayList<Square>();
	
	SquareHolder() {
		generateSquares();
	}
	
	private void generateSquares() {
		int boardLength = 675;
		int squareLength  = (int) boardLength/17;

		
		int secondTrack = (int) ((boardLength*0.75) + (squareLength*2)); 
		int thirdTrack = (int) ((boardLength*0.508) + (squareLength*2) + (squareLength*2)); 
		
		System.out.println(secondTrack);
		System.out.println(thirdTrack);
		
		
//		private void generateSquares() {
//		int squareLength = 115;
//		int boardLength = 660;
//		for (int i = 0; i < 20; i++) {
//			if (i < 5)
//				squares.add(new Square(boardLength - (i * squareLength), boardLength, i));
//			else if (i < 10)
//				squares.add(new Square(squareLength - 35, boardLength - ((i - 5) * squareLength), i));
//			else if (i < 15)
//				squares.add(new Square(squareLength - 35 + ((i - 10) * squareLength), squareLength - 35, i));
//			else
//				squares.add(new Square(boardLength - 5, squareLength - 35 + ((i - 15) * squareLength), i));
//		}

		for (int i = 0; i < Properties.TOTAL_SQUARES; i++) {
			if(i == 0)
				squares.add(new Square(secondTrack,secondTrack,i));	
			else if (i <= 10)
				squares.add(new Square( (int) ((secondTrack-squareLength) - (i * squareLength)), secondTrack, i));
			
			else if (i <= 20)
				squares.add(new Square( ((squareLength*2) + squareLength),
						( (int) ((boardLength - (squareLength*2))) -((i-9)*squareLength) ) ,i));
			
			else if (i <= 30)
				squares.add(new Square( (int) ((2*squareLength + squareLength + 22) + ((i-20) * squareLength)), (4*squareLength), i));
			
			else if (i <= 40)
				squares.add(new Square( (int) ((2*squareLength + squareLength + 22) + ((i-20) * squareLength)), (4*squareLength), i));
			
			
		}
		
	}
	
	public void addSquare(int x, int y, int iD) {
	}
	
	public Square getSquare(int id) {
		if (id < squares.size() && id >= 0)
			return squares.get(id);
		if (id == -1)
			return new Square(360, 360, -1);
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

	

