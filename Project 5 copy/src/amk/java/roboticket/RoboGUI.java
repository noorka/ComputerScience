package amk.java.roboticket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import amk.java.roboticket.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**@author Anna Kroon @date 04/20/2018 @version 1 */

public class RoboGUI extends Application{
	Stage st1 = new Stage();
	//User u = new User();
	RoboTicket rt = new RoboTicket();
	User currentUser;
	Button logOut = new Button ("Log Out");

	Font f1 = Font.font ("Comic Sans", FontWeight.NORMAL, FontPosture.REGULAR, 20);
	Pane pane1 = new Pane();

	//Button exButton = new Button ("Start");
	Text line22 = new Text (130, 80, "Console Program Started.");

	Scene welcomeSn = new Scene(pane1, 600,300);
	Text line1 = new Text (70, 60, "Welcome to RoboTicket by Anna Kroon");
	Text line2 = new Text (70, 80, "Please enter your username and password.");
	TextField logInName = new TextField("Username");//needs label
	PasswordField logInPass = new PasswordField();//needs label

	Button logInBut = new Button("Log In");

	Pane pane2 = new Pane();
	Scene addUser = new Scene(pane2, 600,300);
	TextField name = new TextField("Lastname, Firstname");
	TextField userName = new TextField("Username");
	TextField secretPass = new TextField("Password");
	TextField birth = new TextField("Birthday");
	Button addThis = new Button("Add User");

	//User(String username, String name, String password, String paymentInfo, Date birthday)

	Pane pane3 = new Pane();
	Scene userMenu = new Scene(pane3, 300,300);
	Button editProfile = new Button("Edit Profile");
	Button orderTickets = new Button("Buy Tickets");

	Pane pane4 = new Pane();
	Scene ownerMenu = new Scene(pane4, 300,300);
	Button addMore = new Button("Add New User");
	Button listAll = new Button("List All Users");
	Button ownEdit = new Button("Edit Users");

	Pane pane5 = new Pane();
	Scene userEdit = new Scene(pane5, 300,300);

	Pane pane6 = new Pane();
	Scene ownerEdit = new Scene(pane6, 300,300);

	Pane pane7 = new Pane();
	Scene ticketMenu = new Scene(pane7, 300,300);

	Pane pane8 = new Pane();
	Scene listMenu = new Scene(pane8, 300,300);

	Pane pane9 = new Pane();
	Scene errorPg = new Scene(pane9,300,300);
	Text err = new Text("An error had occured.");


	public Scene fileIn(){
		switch(rt.fileScan()){
		case 1:
			return addUser;
			//st1.setScene(addUser);
			//break;
		case 2:
			return welcomeSn;
			//st1.setScene(welcomeSn);
			//break;
		default:
			return errorPg;
			//st1.setScene(errorPg);
			//break;
		}
	}
	public void buildGUI (){
		st1.setTitle("RoboTicket");
		
		//Backgrounds
		welcomeSn.setFill(Color.PINK);
		pane1.setBackground(null);
		addUser.setFill(Color.PINK);
		pane2.setBackground(null);
		
		//Buttons
		logInPass.setLayoutX(70);
		logInPass.setLayoutY(120);
		
		logInName.setLayoutX(70);
		logInName.setLayoutY(90);
		
		logInBut.setLayoutX(70);
		logInBut.setLayoutY(150);
		
		logOut.setLayoutX(70);
		logOut.setLayoutY(270);
		
		addMore.setLayoutX(70);
		addMore.setLayoutY(70);
		
		listAll.setLayoutX(70);
		listAll.setLayoutY(100);
		
		ownEdit.setLayoutX(70);
		ownEdit.setLayoutY(120);
		
		editProfile.setLayoutX(70);
		editProfile.setLayoutY(70);
		
		orderTickets.setLayoutX(70);
		orderTickets.setLayoutY(100);
		
		//TextFields
		name.setLayoutY(20);
		userName.setLayoutY(50);
		secretPass.setLayoutY(80);
		birth.setLayoutY(110);
		addThis.setLayoutY(150);

		pane1.getChildren().addAll(line1, logInBut, line2, logInName, logInPass);
		pane2.getChildren().addAll(name, userName, secretPass, birth, addThis );
		pane3.getChildren().addAll(logOut,editProfile, orderTickets);
		pane4.getChildren().addAll(logOut, addMore, listAll, ownEdit);
		pane9.getChildren().add(err);
	}
	public void start (Stage st1){
		buildGUI();
		orderTickets.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(ticketMenu);
			}
		});
		editProfile.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userEdit);
			}
		});
		addMore.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(addUser);
			}
		});
		listAll.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(listMenu);
			}
		});
		ownEdit.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(ownerEdit);
			}
		});
		
		logOut.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				currentUser = null;
				st1.setScene(welcomeSn);
			}
		});

		addThis.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String payInfo = "none";
				Date birthdate = null;

				String usersName = name.getText();
				String loginName = userName.getText();
				String myPass = secretPass.getText();
				String bDay = birth.getText();

				if(User.isValidName(usersName)!= true){
					Text invalidName = new Text(50,50, "Please enter a valid name in the format Lastname, Firstname.");
					pane2.getChildren().add(invalidName);
					usersName = null;
					name.clear();
				}
				else{

					//String loginName = userName.getText();
					if(User.isValidUsername(loginName)!= true){
						Text invalidUsername = new Text(50,50, "Invalid username, too few characters. Please try again.");
						pane2.getChildren().add(invalidUsername);
						loginName = null;
						userName.clear();
					}
					else{
						//String myPass = secretPass.getText();
						
						//String bDay = birth.getText();
						//Date birthdate=null;
						SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						try{
							birthdate = format.parse(bDay);
						}
						catch(ParseException pe){
							Text dateFormatErr = new Text (50, 50, "Incorrect format.");
							pane2.getChildren().add(dateFormatErr);
							bDay = null;
							birth.clear();
						}
					}
				}
				//protected User newUser(String username, String name, String password, String paymentInfo, Date birthday){ 
				currentUser = rt.newUser(loginName, usersName, myPass, payInfo, birthdate);
				if(currentUser.getUserID() == 0){
					st1.setScene(ownerMenu);
				}
				else{
					st1.setScene(welcomeSn);
				}
			//event
				}
		
		//main
			});

		logInBut.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String usName = logInName.getText();
				String passWrd = logInPass.getText();
				User thisUser = rt.login(usName,passWrd);
				if(thisUser != null){

					Integer i = thisUser.getUserID();
					if(i==0){
						st1.setScene(ownerMenu);
					}
					else{
						st1.setScene(userMenu);
					}
				}
				else{
					Text redoMsg = new Text(70, 40, "Please try again.");
					redoMsg.setFont(f1);
					pane1.getChildren().add(redoMsg);
					logInName.clear();
					logInPass.clear();
				}
				//check if the username and password match a pair in the array list 
				//if there isn't a match show an error message and have them try again
				//if they match then check the userID
				//if the userID is 0 go to the owner menu
				//if the userID is anything else go to the user menu
			}
		});
		st1.setScene(fileIn());
		st1.show();
	}
	public static void main (String[] args){
		Application.launch(RoboGUI.class,args);
		RoboTicket rt = new RoboTicket();
		if(rt.fileScan() == 1){
			//add user pane
		}
		else if(rt.fileScan() == 2){
			//welcome screen
		}
		else{
			//alll the errorsssss
		}
		//rt.doMenu();
	}
}
