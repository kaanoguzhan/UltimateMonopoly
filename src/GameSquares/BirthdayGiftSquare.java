package GameSquares;

import Main.Player;

public class BirthdayGiftSquare extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	
	public BirthdayGiftSquare(int id) {
		super(id, type.BirthdayGift);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Bithday Gift Square";
	}
	
}
