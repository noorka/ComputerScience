package amk.java.roboticket;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**@author Anna Kroon @date 04/20/2018 @version 1 */

public class RoboTicket {
	ArrayList<User> userList = new ArrayList<User>();
	ObjectOutputStream out = null;
	FileOutputStream fileOS = null;
	ObjectInputStream in = null;
	FileInputStream fileIS = null;
	Scanner sck = new Scanner(System.in);
	File file = new File("database.dat");

	/**
	 * This streams in data from the object file and returns a different value depending upon the case it hits (no file, 
	 * good file, or bad file) so that the GUI function can handle them properly.
	 * @param none
	 * @return Integer
	 */
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
			returnVal = 1;
		}
		catch(EOFException eof){
			if(!userList.isEmpty()) returnVal= 2;
		}
		catch(Exception d){
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
	 * This creates a new user, adds them to the array list, and returns the user so that it can be set as the current 
	 * user in the GUI.
	 * @param String username, String name, String password, Date birthday
	 * @return User
	 */
	protected User newUser(String username, String name, String password, Date birthday){ 
		User myUser = new User(username, name, password, birthday);
		userList.add(myUser);
		return myUser;
	}
	/**
	 * This compares a given username and password to those in the existing list. It also checks to ensure the user is 
	 * still a user in the system. If the user is matched and valid it will be passed back to the GUI.
	 * @param String usersName, String passWord
	 * @return User
	 */
	protected User login (String usersName, String passWord){
		for(User user: userList){
			if(usersName.equals(user.getUsername()) && passWord.equals(user.getPassword()) && user.getIsUser() == true){
				return user;
			}
		}
		return null;
	}
	/**
	 * This ensures that any changes made to a user will be reflected in the array list of users. 
	 * @param User currentUser
	 * @return none
	 */
	public void persistUser(User currentUser){
		Integer thisUserID = currentUser.getUserID();
		userList.set(currentUser.getUserID(), currentUser);

	}
	/**
	 * This reads data out to the file, closes everything, and prints a nice thank you message to the console.
	 * @param User currentUser
	 * @return none
	 */
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
			fileOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}             

	}
	/**
	 * This takes the amount of tickets selected and the price for the selected type to add the proper amount to the 
	 * user's paidToDate.
	 * @param Integer numTix, Double price, User currentUser
	 * @return none
	 */
	public void chargeFee(Integer numTix, Double price, User currentUser){
		Double fee = numTix*price;
		currentUser.paidAmount(fee);

	}

}

