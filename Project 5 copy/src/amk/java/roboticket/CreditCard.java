package amk.java.roboticket;

import java.util.Date;

public class CreditCard extends Payment{
	Integer cardNumber;
	Integer cardSVN;
	Date expire;

	public CreditCard(String username, String password, Integer cardNumber, Integer cardSVN, Date expire) {
		super(username, null);
		this.setCardNumber(cardNumber);
		//this.setCardSVN(cardSVN);
		this.setExpire(expire);
	}
	public void setCardNumber(Integer cardNumber){

		this.cardNumber = cardNumber;
	}
	public Integer getCardNumber() throws Exception{
		
		return cardNumber;
	}
	public void setCardSVN(Integer cardSVN) throws Exception{
		if(cardSVN > 999 || cardSVN < 100) throw new Exception();
		this.cardSVN = cardSVN;
	}
	public Integer getCardSVN(){
		return cardSVN;
	}
	public void setExpire(Date expire){

		this.expire = expire;
	}
	public Date getExpire(){
		return expire;
	}

}
