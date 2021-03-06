import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
/**@author Anna Kroon @date 04/01/2018 @version 1 */

public class RoboTicket {
	ArrayList<User> userList = new ArrayList<User>();
	ObjectOutputStream out = null;
	FileOutputStream fileOS = null;
	ObjectInputStream in = null;
	FileInputStream fileIS = null;
	Scanner sck = new Scanner(System.in);
	File file = new File("database.txt");
	User currentUser;

	/**
	 * This function scans in data from the file. If there is data in the file, it takes the serialized information and 
	 * creates a new User object that is then added to the ArrayList of Users. If there is not a data file then the 
	 * function creates a new User as the owner of the program. When the file is done reading in, it closes the 
	 * FileInputStream before wiping the file and opening the FileOutputStream.
	 * @param none
	 * @return none
	 */
	public void fileScan(){
		Integer newIDIn = null;
		try{
			fileIS = new FileInputStream(file);             
			in = new ObjectInputStream(fileIS);
			newIDIn = (Integer)in.readObject();
			User.setNextID(newIDIn);
			for(;;){
				User myUser = (User)in.readObject();

				userList.add(myUser);
			}

		}
		catch(FileNotFoundException fnf){
			newUser();
		}
		catch(EOFException eof){
			if(!userList.isEmpty()) currentUser = userList.get(0);
		}
		catch(Exception d){
			//catching everything
			d.printStackTrace();
		}
		finally{
			try{
				if(in !=null) in.close();
				if(fileIS != null) fileIS.close();
			}
			catch(IOException ie){
				System.out.println("Cannot close input reader.");
			}
		}
		try{
			fileOS = new FileOutputStream(file);             
			out = new ObjectOutputStream(fileOS);
		}
		catch(Exception e){
			System.out.println("Issue with file.");
		}
	}

	/**
	 * This function takes user input from the keyboard then uses a switch statement to produce the proper action.
	 * @param none
	 * @return none
	 */
	public void doMenu(){
		try{
			while(true){
				printMenu();
				int userInput = sck.nextInt();
				switch(userInput){
				case 0:
					endGracefully();
					System.exit(0);
					break;
				case 1:
					//Log In
					login();
					break;
				case 2:
					//enter users
					if(currentUser.getUserID() == 0){
						newUser();
					}
					else{
						System.out.println("Only the Owner can create a new user. Please select another option.");
					}
					break;
				case 3:
					//list Users
					listUsers(userList);
					break;
				case 4:
					//Change user data
					System.out.println("Not available at this time.");
					break;
				case 5:
					//Close account
					System.out.println("Not available at this time.");
					break;
				case 6:
					//Buy Tickets
					System.out.println("Not available at this time.");
					break;
				default:
					System.out.println("Invalid input, try again.");
				}
			}
		}
		catch (Exception e){
			e.getMessage();
		}
		finally{
			endGracefully();
		}
	}
	/**
	 * This function prints all the menu options.
	 * @param none
	 * @return none
	 */
	public void printMenu(){
		System.out.println("0. Exit program\n1. Log In\n2. Enter Users\n3. List Users\n4. Change User Data\n5. Close Account\n6. Buy Tickets");
	}
	/**
	 * This function lists the users by ID number, username, name, isUser, years membership, and paid to date.
	 * @param ArrayList
	 * @return none
	 */
	private void listUsers(ArrayList <User> myList){
		String titles = "UserID\tUsername       Name                   Is User  Member Years    Paid to Date";
		//need to display id, login name, isUser, get years, paidToDate
		System.out.println("LIST THE USERS");
		System.out.println(titles);
		System.out.println("-----------------------------------------------------------------------------------------");
		for(User thisUser: myList){
			System.out.print(thisUser.toString());
		}
	}
	/**
	 * This function loops through the array of users to find a particular user by username.
	 * @param String username
	 * @return User
	 */
	private User findUser(String usersName){
		for(User user: userList){
			if(usersName.equals(user.getUsername())) return user;
		}
		return null;
	}
	/**
	 * This function creates a new User from user input. 
	 * @param none
	 * @return none
	 */
	private void newUser(){
		String username, name; 
		String payment = "none";
		String bDayStr;
		SimpleDateFormat format;
		Date birthdate = null;
		Scanner seek = new Scanner(System.in);

		System.out.println("CREATE A NEW USER:");
		do{
			System.out.println("Enter Username:");
			username = seek.nextLine();
		}
		while (!User.isValidUsername(username));
		do{
			System.out.println("Enter Name as Lastname, Firstname:");
			name = seek.nextLine();
		}
		while(!User.isValidName(name));

		while(birthdate == null){
			System.out.println("Enter birthday MM-DD-YYYY");
			bDayStr = seek.nextLine();
			format = new SimpleDateFormat("dd-MM-yyyy");
			try{
				birthdate = format.parse(bDayStr);
			}
			catch(ParseException pe){
				System.out.println("Incorrect format.");
			}
		}
		User myUser = new User(username, name, payment, birthdate);
		userList.add(myUser);
		currentUser = myUser;
	}
	/**
	 * This function searches for a particular User in the ArrayList. If it is found then it sets the current User to 
	 * that found user. If not, it returns an error message.
	 * @param none
	 * @return none
	 */
	private void login(){
		String usersName;
		Scanner sc = new Scanner(System.in);
		System.out.println("LOG IN:");
		System.out.println("Please enter your username:");
		usersName = sc.nextLine();

		User foundUser = findUser (usersName);
		if(foundUser == null){
			System.out.println("No user with this username, sorry.");
		}
		else{
			currentUser = foundUser;
			System.out.println("Log in sucessful.");
		}
	}
	/**
	 * This function prints an exit message, wites the arrayList and nextID to a txt file, and closes the file outputs.
	 * @param none
	 * @return none
	 */
	public void endGracefully(){
		System.out.println("Thank you for using RoboTicket by Anna Kroon.");
		try {
			out.writeObject((Integer)User.getNextID());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(User thisUser: userList){
			try {
				out.writeObject(thisUser);
			} catch (IOException e) {
				System.err.println("Cannot be written");
			}
		}
		try {
			out.close();
			fileOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}             

	}
	/**
	 * This is the main function. It launches the GUI window, welcomes the user, and proceeds with the doMenu and fileScan
	 * functions
	 * @param String args
	 * @return none
	 */
	public static void main (String[] args){
		Application.launch(RoboGUI.class,args);
		RoboTicket rt = new RoboTicket();
		System.out.println("Welcome to P4: RoboTicket by Anna Kroon.");
		rt.fileScan();
		rt.doMenu();
	}
}

