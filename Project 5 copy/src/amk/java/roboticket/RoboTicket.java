package amk.java.roboticket;
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


//import javafx.application.Application;
/**@author Anna Kroon @date 04/01/2018 @version 1 */

public class RoboTicket {
	ArrayList<User> userList = new ArrayList<User>();
	ObjectOutputStream out = null;
	FileOutputStream fileOS = null;
	ObjectInputStream in = null;
	FileInputStream fileIS = null;
	Scanner sck = new Scanner(System.in);
	File file = new File("database.dat");
	//User currentUser;

	public Integer fileScan(){
		Integer newIDIn = null;
		Integer returnVal = -1;
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
			//newUser();
			returnVal = 1;
		}
		catch(EOFException eof){
			if(!userList.isEmpty()) returnVal= 2;
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
		return returnVal;
	}

	/**
	 * This function takes user input from the keyboard then uses a switch statement to produce the proper action.
	 * @param none
	 * @return none
	 */
	/*public void doMenu(){
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
	}*/
	
	/*private void listUsers(ArrayList <User> myList){
		String titles = "UserID\tUsername       Name                   Is User  Member Years    Paid to Date";
		//need to display id, login name, isUser, get years, paidToDate
		System.out.println("LIST THE USERS");
		System.out.println(titles);
		System.out.println("-----------------------------------------------------------------------------------------");
		for(User thisUser: myList){
			System.out.print(thisUser.toString());
		}
	}*/

	protected User newUser(String username, String name, String password, String paymentInfo, Date birthday){ 
		User myUser = new User(username, name, password,paymentInfo, birthday);
		userList.add(myUser);
		return myUser;
	}
	protected User login (String usersName, String passWord){
		for(User user: userList){
			if(usersName.equals(user.getUsername())){
				if(passWord.equals(user.getPassword())){
					return user;
				}
			}
		}
		return null;
	}
public void persistUser(User currentUser){
	Integer thisUserID = currentUser.getUserID();
	for(User user: userList){
		if(thisUserID == user.getUserID()){
			userList.remove(user);
			userList.add(currentUser);
		}
	}
}
	public void endGracefully(User currentUser){
		System.out.println("Thank you for using RoboTicket by Anna Kroon.");
		if(currentUser!= null){
			persistUser(currentUser);
		}
		try{
			fileOS = new FileOutputStream(file);             
			out = new ObjectOutputStream(fileOS);
		}
		catch(Exception e){
			System.out.println("Issue with file.");
		}
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
			//out.close();
			fileOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}             

	}
	
	public void chargeFee(Integer numTix, Integer price, User currentUser){
		Integer fee = numTix*price;
		currentUser.paidAmount(fee);
		
	}
	/**
	 * This is the main function. It launches the GUI window, welcomes the user, and proceeds with the doMenu and fileScan
	 * functions
	 * @param String args
	 * @return none
	 */
	//public static void main (String[] args){
	//Application.launch(RoboGUI.class,args);
	//RoboTicket rt = new RoboTicket();
	//System.out.println("Welcome to P4: RoboTicket by Anna Kroon.");
	//rt.fileScan();
	//rt.doMenu();
	//}
}

