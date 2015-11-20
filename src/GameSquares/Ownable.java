package GameSquares;

import Main.Player;

public interface Ownable {
	public void sell();
	public int getPrice();
	public void setOwner(Player pl);
}
