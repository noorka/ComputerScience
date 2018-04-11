
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
	private String name;
	private GregorianCalendar dateJoined; 
	private Boolean isUser = true;
	private static Integer nextID;
	private Integer userID;
	private Date birthday; //This was added to User because it was required for Owner
	private String paymentInfo = "None";
	private String paymentType = null;
	private Integer payAccount = 0;
	private Integer paidToDate = 0;

	/**
	 * This constructs the User class with all its required elements.
	 * @param name, paymentInfo, birthday, username
	 * @return none
	 */
	public User(String username, String name, String paymentInfo, Date birthday){
		this.setUsername(username);
		this.setName(name);
		this.setDateJoined(new GregorianCalendar());
		this.setBirthday(birthday);
		this.setIsUser(isUser);
		this.setPaymentInfo(paymentInfo);
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
	 * This function checks for a valid username of at least 6 characters.
	 * @param username String
	 * @return boolean
	 */
	public static Boolean isValidUsername(String username){
		if(username.length() < MIN_USERNAME){
			System.out.println("Invalid username, too few characters. Please try again.");
			return false;
		}
		return true;
	}
	/**
	 * This function allows the user to pick their payment method via scanned in keyboard data.
	 * @param none
	 * @return none
	 */
	public void pickPaymt(){
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Please Chose a payment type:");
		System.out.println("1) Credit\t2) Debit\t3) Apple Pay\t4) Android Pay");
		choice = sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Credit:");
			System.out.println("Enter Name:");
			String cardName = sc.nextLine();
			System.out.println("Enter Card Number:");
			int cardNum = sc.nextInt();
			break;
		case 2:
			System.out.println("Debit:");
			System.out.println("Enter Name:");
			String debitName = sc.nextLine();
			System.out.println("Enter Card Number:");
			int debitNum = sc.nextInt();
			break;
		case 3:
			System.out.println("Apple Pay:");
			System.out.println("Enter Name:");
			String appleName = sc.nextLine();
			System.out.println("Enter Account Number:");
			int appledNum = sc.nextInt();
			break;
		case 4:
			System.out.println("Android Pay:");
			System.out.println("Enter Name:");
			String droidName = sc.nextLine();
			System.out.println("Enter Account Number:");
			int droidNum = sc.nextInt();
			break;
		default:
			System.out.println("Invalid input, try again.");
		}
	 
	}
	/**
	 * This functions adds the amount spent in the current action to the account's total amount paid.
	 * @param int amount
	 * @return none
	 */
	public void paidAmount (int amount){
		int tempPay = amount +paidToDate;
		paidToDate = tempPay;
	}
	/**
	 * This function checks for a valid username with a hyphen in the lastname, a comma, and a firstname.
	 * @param String name
	 * @return boolean
	 */
	public static Boolean isValidName(String name){
		if(!name.matches(NAME_REGEX)){
			System.out.println("Invalid name, please try again. Format is Lastname, Firstname.");
			return false;
		}
		return true;
	}
	//This is done as the serialized User object are being read in from the file. 
	/*public void userFromFile(User myUser){
		//all the saved user data is supposed to be a parameter
		//this is supposed to create a user from a file then add it to an ArrayList
	}*/
	/**
	 * This function gets the number of years between the user's account creation and the current date. Any time less than a year is presented as 0.
	 * @param none
	 * @return long years
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
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
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
}
