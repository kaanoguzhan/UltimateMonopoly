package gui;

public class Square {
	
	int X = 5;
	int Y = 5;
	int ID = 0;
	
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
