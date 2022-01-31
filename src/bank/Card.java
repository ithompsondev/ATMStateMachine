package bank;

public class Card {
	private String cardNr;
	private String cardPIN;
	
	public Card(String cardNr, String cardPIN) {
		this.cardNr = cardNr;
		this.cardPIN = cardPIN;
	}
	
	public String getCardNr() {
		return cardNr;
	}
	
	public String getCardPIN() {
		return cardPIN;
	}
	
	private boolean compareThisCardTo(Card otherCard) {
		return cardNr.equals(otherCard.getCardNr());
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || this.getClass() != object.getClass()) return false;
		
		Card comparableCard = (Card) object;
		return compareThisCardTo(comparableCard); 
	}
}
