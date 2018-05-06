package amk.java.roboticket;

import java.io.Serializable;

public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username;
	String password;
	
	//Payment paymentType;
	
	public Payment (String username, String password){
		this.setPassword(password);
		this.setUsername(username);
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public String lastFour(String card){
		if (card.length() < 4) {
			return card;
		} 
		else {
			return card.substring(card.length() - 4);
		}
		
	}
	
}
