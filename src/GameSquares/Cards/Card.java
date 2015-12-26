package GameSquares.Cards;

import Main.Player;

public interface Card {
	public void onDraw(Player pl);

	public String toString();

	public String getName();

	public enum CardType {
		// CommunityChest Cards
		BargainBusiness(CardFamily.CommunityChestCard), GeneralRepairs(CardFamily.CommunityChestCard), HouseCondemned(
				CardFamily.CommunityChestCard), OnlinePricing(CardFamily.CommunityChestCard), RecieveConsultancyFee(
				CardFamily.CommunityChestCard), RenovationSuccess(CardFamily.CommunityChestCard), StreetRepair(
				CardFamily.CommunityChestCard), VehicleImpounded(CardFamily.CommunityChestCard), InheritStock(
				CardFamily.CommunityChestCard),

		// Chance Cards
		AdvanceToSqueezePlay(CardFamily.ChanceCard), AdvanceToStart(CardFamily.ChanceCard), AdvanceToStCharlesPlace(
				CardFamily.ChanceCard), AdvanceToTheNearestRailroad(CardFamily.ChanceCard), AdvanceToTheNearestUtility(
				CardFamily.ChanceCard), BusTicket(CardFamily.ChanceCard), ElectedAsChairPerson(CardFamily.ChanceCard), GetOutOfJail(
				CardFamily.ChanceCard), GoToJail(CardFamily.ChanceCard), Hurricane(CardFamily.ChanceCard), MargiGras(
				CardFamily.ChanceCard), PropertyTaxes(CardFamily.ChanceCard), SchoolFees(CardFamily.ChanceCard), ThreeSpacesBack(
				CardFamily.ChanceCard), ChangingLanes(CardFamily.ChanceCard), EntertainmentRocks(CardFamily.ChanceCard);

		public enum CardFamily {
			CommunityChestCard, ChanceCard;
		}

		// ////////////////////////////////////////////////////// //

		private CardFamily cardFamily;

		CardType(CardFamily cardFamily) {
			this.cardFamily = cardFamily;
		}

		public boolean isCommunityChestCard() {
			return cardFamily == CardFamily.CommunityChestCard;
		}

		public boolean isChanceCard() {
			return cardFamily == CardFamily.ChanceCard;
		}
	}
}
