package GameSquares;

import Main.Player;

public class Cab extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	private String				name;
	
	public Cab(int id, String name) {
		super(id, type.Cab);
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return name + "Cab Co";
	}
	
}
