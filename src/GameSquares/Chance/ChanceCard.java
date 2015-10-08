package GameSquares.Chance;

public class ChanceCard {
	
	public enum ChanceCardType {
		AdvanceToStCharlesPlace, AdvanceToSqueezePlay, ElectedAsChairPerson, AdvanceToStart
	}
	
	ChanceCardType	type;
	
	public ChanceCard(ChanceCardType type) {
		this.type = type;
	}
	
	
}
