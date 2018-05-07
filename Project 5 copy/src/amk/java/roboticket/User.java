package amk.java.roboticket;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**@author Anna Kroon @date 04/20/2018 @version 1 */
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
	private Double paidToDate = 0.0;
	/**
	 * This constructs a user.
	 * @param String username, String name, String password, Date birthday
	 * @return User
	 */
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
	/**
	 * This checks the validity of the entered username.
	 * @param String username
	 * @return Boolean
	 */
	public static Boolean isValidUsername(String username){
		if(username.length() < MIN_USERNAME){
			return false;
		}
		return true;
	}
	/**
	 * This checks the validity of the entered name.
	 * @param String name
	 * @return Boolean
	 */
	public static Boolean isValidName(String name){
		if(!name.matches(NAME_REGEX)){
			//System.out.println("Invalid name, please try again. Format is Lastname, Firstname.");
			return false;
		}
		return true;
	}
	/**
	 * This calcualtes the number of years a user has been registered. 
	 * @param none
	 * @return long
	 */
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
		String printOut = String.format("%05d %20s %20s %20b %20d %20f", getUserID(), getUsername(), getName(), getIsUser(), years, getPaidToDate());
		return printOut;
	}
	/**
	 * This function adds the amount spent in the current action to the account's total amount paid.
	 * @param Double amount
	 * @return none
	 */
	public void paidAmount (Double amount){
		Double tempPay = amount + paidToDate;
		paidToDate = tempPay;
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
	 * This function gets the amount paid to date for the toString method.
	 * @param none
	 * @return Double paidToDate
	 */
	public Double getPaidToDate() {
		return paidToDate;
	}
	/**
	 * This function sets the paid to date to a default value. 
	 * @param Double paidToDate
	 * @return paidToDate
	 */
	public void setPaidToDate(Double paidToDate) {
		this.paidToDate = paidToDate;
	}
	/**
	 * This function gets the password.
	 * @param none
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * This function sets the password to a default value. 
	 * @param String password
	 * @return none
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * This function gets the payment information.
	 * @param none
	 * @return Payment paymentInfo
	 */
	public Payment getPaymentInfo() {
		return paymentInfo;
	}
	/**
	 * This function sets the payment info to a default value. 
	 * @param Payment paymentInfo
	 * @return none
	 */
	public void setPaymentInfo(Payment paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
