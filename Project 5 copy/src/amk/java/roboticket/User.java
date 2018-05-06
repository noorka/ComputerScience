package amk.java.roboticket;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**@author Anna Kroon @date 04/01/2018 @version 1 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final int MIN_USERNAME = 6;
	private static final String NAME_REGEX ="[A-Za-z\\-]*,.[A-Za-z]*";
	private String username;
	private String password;
	private String name;
	private GregorianCalendar dateJoined; 
	private Boolean isUser = true;
	private static Integer nextID;
	private Integer userID;
	private Date birthday; 
	private Payment paymentInfo = null;
	private Integer paidToDate = 0;

	public User(String username, String name, String password, Date birthday){
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setDateJoined(new GregorianCalendar());
		this.setBirthday(birthday);
		this.setIsUser(isUser);
		//this.setPaymentInfo(paymentInfo);
		this.setPaidToDate(paidToDate);
		if(nextID == null){
			this.setUserID(0);
			setNextID(1);
		}
		else{
			this.setUserID(nextID++);
		}
	}

	public static Boolean isValidUsername(String username){
		if(username.length() < MIN_USERNAME){
			return false;
		}
		return true;
	}

	public void paidAmount (int amount){
		int tempPay = amount + paidToDate;
		paidToDate = tempPay;
	}
	
	public static Boolean isValidName(String name){
		if(!name.matches(NAME_REGEX)){
			//System.out.println("Invalid name, please try again. Format is Lastname, Firstname.");
			return false;
		}
		return true;
	}

	public long getYears(){
		ZonedDateTime myZdt = dateJoined.toZonedDateTime();
		ZoneId z = ZoneId.of( "America/Montreal" );
		ZonedDateTime now = ZonedDateTime.now( z );
		long years = ChronoUnit.YEARS.between( myZdt , now );
		return years;
	}
	/**
	 * This formats some of the User data to be presented as a string for printing.
	 * @param none
	 * @return String
	 */
	public String toString(){
		long years = getYears();
		String printOut = String.format("%05d\t%-15s\t%-20s\t%-5b\t%-10d\t%-10d\n", getUserID(), getUsername(), getName(), getIsUser(), years, getPaidToDate());
		return printOut;
	}
	/**
	 * This is a static function that sets the nextID.
	 * @param nextID
	 * @return none
	 */
	public static void setNextID(Integer nextID) {
		User.nextID = nextID;
	}
	/**
	 * This is a static function that gets the nextID. 
	 */
	public static Integer getNextID(){
		return nextID;
	}
	/**
	 * This function sets the username.
	 * @param username
	 * @return none
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * This function get the username for the toString method. 
	 * @param none
	 * @return username
	 */
	public String getUsername(){
		return username;
	}
	/**
	 * This function sets the user's name. 
	 * @param String name
	 * @return none
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This function gets the user's name for the toString method.
	 * @param none
	 * @return String name
	 */
	public String getName(){
		return name;
	}
	/**
	 * This function sets the date the user joined to the date when the user was created.
	 * @param GregorianCalendar dateJoined
	 * @return none
	 */
	public void setDateJoined(GregorianCalendar dateJoined) {
		this.dateJoined = dateJoined;
	}
	public GregorianCalendar getDateJoined(){
		return dateJoined;
	}
	/**
	 * This function sets the user's ID number.
	 * @param Integer userID
	 * @return none
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	/**
	 * This function gets the user's ID number for the toString method. 
	 */
	public Integer getUserID(){
		return userID;
	}
	/**
	 * This method sets the user's birthday.
	 * @param Date birthday
	 * @return none
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * This function gets the boolean of is current user for the toString method.
	 * @param none
	 * @return Boolean isUser
	 */
	public Boolean getIsUser() {
		return isUser;
	}
	/**
	 * This functions sets the isUser to true.
	 * @param Boolean isUser
	 * @return none
	 */
	public void setIsUser(Boolean isUser) {
		this.isUser = isUser;
	}
	/**
	 * This function sets the paymentInfo to the default value.
	 * @param String paymentInfo
	 * @return none
	 */
	/*public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}*/
	/**
	 * This function gets the amount paid to date for the toString method.
	 * @param none
	 * @return Integer paidToDate
	 */
	public Integer getPaidToDate() {
		return paidToDate;
	}
	/**
	 * This function sets the paid to date to a default value. 
	 * @param Integer paidToDate
	 * @return paidToDate
	 */
	public void setPaidToDate(Integer paidToDate) {
		this.paidToDate = paidToDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Payment getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(Payment paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
