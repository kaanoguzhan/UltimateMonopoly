package GameSquares.CommunityChest;

public class CommunityCard {
	
	public enum CommunityCardType {
		RecieveConsultancyFee, BargainBusiness, RenovationSuccess
	}
	
	CommunityCardType	type;
	
	public CommunityCard(CommunityCardType type) {
		this.type = type;
	}
	
	
}
