package GameSquares;

import Main.Player;

public class HollandTunnel extends GameSquare {
	private static final long	serialVersionUID	= 1L;
	private int					connectedTunnelID;
	
	public HollandTunnel(int id, int connectedTunnelID) {
		super(id, type.HollandTunnel);
		this.connectedTunnelID = connectedTunnelID;
	}
	
	@Override
	public void onArrive(Player pl) {
		pl.moveTo(connectedTunnelID);
	}
	
	@Override
	public String toString() {
		return "Holland Tunnel @" + id + " connected with @" + connectedTunnelID;
	}
}
