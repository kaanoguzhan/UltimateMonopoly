package GameSquares;

import Main.Player;

public class HollandTunnel extends GameSquare {
<<<<<<< HEAD

	private static final long serialVersionUID = 1L;
	private final int firstHollandTunnel = 54;
	private final int secondHollandTunnel = 114;

	public HollandTunnel(int id) {
		super(id, type.HollandTunnel);
	}

	@Override
	public void onArrive(Player pl) {
		new gui.AdditionalWindows.MessageDisplayer("You are directly moving to the other Holland Tunnel.");
		if (id == firstHollandTunnel)
			pl.moveTo(secondHollandTunnel);
		else
			pl.moveTo(firstHollandTunnel);
	}

	@Override
	public String toString() {
		return "Holland Tunnel. Location: " + id;
	}

=======
	private static final long	serialVersionUID	= 1L;
	private int					connectedTunnelID;
	
	public HollandTunnel(int id, int connectedTunnelID) {
		super(id, type.HollandTunnel);
		this.connectedTunnelID = connectedTunnelID;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArrive(Player pl) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Holland Tunnel @" + id + " connected with @" + connectedTunnelID;
	}
>>>>>>> f45b6e438191095691d653e177464c8d0ad3c130
}
