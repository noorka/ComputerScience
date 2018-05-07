package amk.java.roboticket;
/**@author Anna Kroon @date 04/20/2018 @version 1 */

public class CreditCard extends Payment{
	String cardNumber;
	String cardSVN;
	String expire;
	/**
	 * This function constructs a credit card, a child of payment.
	 * @param String username, String password, String cardNumber, String cardSVN, String expire
	 * @return CreditCard
	 */
	public CreditCard(String username, String password, String cardNumber, String cardSVN, String expire) {
		super(username, null);
		this.setCardNumber(cardNumber);
		this.setCardSVN(cardSVN);
		this.setExpire(expire);
	}
	/**
	 * This method sets the card number.
	 * @param String card number
	 * @return none
	 */
	public void setCardNumber(String  cardNumber){

		this.cardNumber = cardNumber;
	}
	/**
	 * This function gets the card number.
	 * @param none
	 * @return String cardNumber
	 */
	public String getCardNumber(){

		return cardNumber;
	}
	/**
	 * This method sets the card's SVN number.
	 * @param String cardSVN
	 * @return none
	 */
	public void setCardSVN(String  cardSVN) {
		this.cardSVN = cardSVN;
	}
	/**
	 * This function gets the card's SVN number.
	 * @param none
	 * @return String CardSVN
	 */
	public String  getCardSVN(){
		return cardSVN;
	}
	/**
	 * This method sets the expiration date.
	 * @param String expire
	 * @return none
	 */
	public void setExpire(String expire){

		this.expire = expire;
	}
	/**
	 * This function gets the expiration date.
	 * @param none
	 * @return String expire
	 */
	public String getExpire(){
		return expire;
	}

}
