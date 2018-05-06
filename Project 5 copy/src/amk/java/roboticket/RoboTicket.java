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

	protected User newUser(String username, String name, String password, Date birthday){ 
		User myUser = new User(username, name, password, birthday);
		userList.add(myUser);
		return myUser;
	}
	protected User login (String usersName, String passWord){
		for(User user: userList){
			if(usersName.equals(user.getUsername()) && passWord.equals(user.getPassword()) && user.getIsUser() == true){
				return user;
			}
		}
		return null;
	}
	public void persistUser(User currentUser){
		Integer thisUserID = currentUser.getUserID();
		userList.set(currentUser.getUserID(), currentUser);

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
			fileOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}             

	}

	public void chargeFee(Integer numTix, Integer price, User currentUser){
		Integer fee = numTix*price;
		currentUser.paidAmount(fee);

	}

}

