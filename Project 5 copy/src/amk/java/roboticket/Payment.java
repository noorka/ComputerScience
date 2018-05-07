package amk.java.roboticket;
import java.io.Serializable;

/**@author Anna Kroon @date 04/20/2018 @version 1 */

public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	/**
	 * This function constructs a basic payment.
	 * @param String username, String password
	 * @return Payment
	 */
	public Payment (String username, String password){
		this.setPassword(password);
		this.setUsername(username);
	}
	/**
	 * This function gets the username.
	 * @param none
	 * @return String username
	 */
	public String getUsername(){
		return username;
	}
	/**
	 * This method sets the username.
	 * @param String username
	 * @return none
	 */
	public void setUsername(String username){

		this.username = username;
	}
	/**
	 * This function gets the password.
	 * @param none
	 * @return String password
	 */
	public String getPassword(){
		return password;
	}
	/**
	 * This method sets the password.
	 * @param String password
	 * @return none
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * This function only returns the last four digits of a credit card number.
	 * @param String card
	 * @return String
	 */
	public String lastFour(String card){
		if (card.length() < 4) {
			return card;
		} 
		else {
			return card.substring(card.length() - 4);
		}

	}

}
