package amk.java.roboticket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import amk.java.roboticket.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**@author Anna Kroon @date 04/20/2018 @version 1 */

public class RoboGUI extends Application{
	Stage st1 = new Stage();
	RoboTicket rt = new RoboTicket();
	User currentUser;
	Button logOut = new Button ("Log Out");
	Button back = new Button ("Back");
	ObservableList<User> listoUsers = null;

	Font f1 = Font.font ("Comic Sans", FontWeight.NORMAL, FontPosture.REGULAR, 20);


	Pane pane1 = new Pane();
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
	Text invalidUsername = new Text(50,50, "Invalid username, too few characters. Please try again.");
	Text invalidName = new Text(50,50, "Please enter a valid name in the format Lastname, Firstname.");
	Text dateFormatErr = new Text (50, 50, "Incorrect format.");

	Pane pane3 = new Pane();
	Scene userMenu = new Scene(pane3, 300,300);
	Button editProfile = new Button("Edit Profile");
	Button orderTickets = new Button("Buy Tickets");

	Pane pane4 = new Pane();
	Scene ownerMenu = new Scene(pane4, 300,300);
	Button addMore = new Button("Add New User");
	Button listAll = new Button("List All Users");


	Pane pane5 = new Pane();
	Scene userEdit = new Scene(pane5, 300,300);


	Pane pane6 = new Pane();
	Scene ownerEdit = new Scene(pane6, 300,300);
	Text currentName = new Text();
	TextField newName = new TextField();
	Text currentUsername = new Text();
	TextField newUsername = new TextField();
	Text currentTotPay = new Text();
	TextField newTotPay = new TextField();
	Text currentDateJoin = new Text();
	TextField newDateJoin = new TextField();
	Button ownerEdited = new Button("Save Edits");
	ComboBox<User> selectUser = new ComboBox<User>();
	Button selected = new Button ("Select");
	Button ownEdit = new Button("Edit User");

	Pane pane7 = new Pane();
	Scene ticketMenu = new Scene(pane7, 300,300);
	ComboBox<String> eventPicker = new ComboBox<String>();
	Button eventPick = new Button ("Select Event");

	Pane pane8 = new Pane();
	Scene listMenu = new Scene(pane8, 300,300);


	Pane pane9 = new Pane();
	Scene errorPg = new Scene(pane9,300,300);
	Text err = new Text("An error had occured.");

	//buying a ticket
	public void buyTicket(){
		//List<String> eventOpt = new ObservableList<String>();
		//eventOpt.addAll("concert","theatre","sport");

		//there should be a ComboBox of event types and when one is selected (without a button) this should happen
		//I think the ComboBox needs a listener, but I am honestly not sure
		eventPick.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String chosenOne = (String) eventPicker.getValue();
				if(chosenOne == "concert"){
					ToggleGroup concertAges = new ToggleGroup();
					VBox vb1 = new VBox();
					RadioButton concertKid = new RadioButton("Child: $75");
					RadioButton concertAdult = new RadioButton("Adult: $150");
					RadioButton concertSr = new RadioButton("Senior: $112.50");
					concertKid.setToggleGroup(concertAges);
					concertKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Enter the number of child tickets you would like.");
							HBox hb1 = new HBox();
							TextField numTix = new TextField();
							hb1.getChildren().addAll(numTixL, numTix);
							hb1.setLayoutX(150);
							hb1.setLayoutY(50);
							pane7.getChildren().add(hb1);
							//Maybe this should be another combo box of numbers of tickets they can buy
							//I can't figure out how to have a user input field that only allows for a number 
							//there is also supposed to be a charge fee thing here that I think should be a switch statement in the robo ticket class
							String tixNum = numTix.getText();
							//from here I should be calculating how much they bought and adding it to the total paid 
							//she never asked for an end transaction button or if they can buy more than one type of ticket at a time
							//I figure I can send them back to the user menu? Or should they have the option to buy more?
							//maybe I will just have a complete transaction button pop up when they select a number
						}
					});
					concertAdult.setToggleGroup(concertAges);
					concertSr.setToggleGroup(concertAges);
					vb1.getChildren().addAll(concertKid, concertAdult, concertSr);
					vb1.setLayoutX(100);
					vb1.setLayoutY(100);
					pane7.getChildren().add(vb1);
					//how do I get these buttons to show up nicely in a little pane and have them all do the right things when selected?
				}
				else if(chosenOne == "sport"){

				}
				else{

				}
			}
		});
	}
	// taking in an input file and changing the scene
	public Scene fileIn(){
		switch(rt.fileScan()){
		case 1:
			return addUser;

		case 2:
			return welcomeSn;

		default:
			return errorPg;
		}
	}
	//putting all the stuff together to look pretty
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
		logOut.setLayoutY(170);

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

		//ListView
		selectUser.setLayoutY(10);
		selected.setLayoutY(20);
		currentName.setLayoutY(40);
		newName.setLayoutY(50);
		currentUsername.setLayoutY(70);
		newUsername.setLayoutY(60);
		currentTotPay.setLayoutY(80);
		newTotPay.setLayoutY(90);
		currentDateJoin.setLayoutY(110);
		newDateJoin.setLayoutY(120);
		ownerEdited.setLayoutY(150);


		//adding everything to the panes 
		pane1.getChildren().addAll(line1, logInBut, line2, logInName, logInPass);
		pane2.getChildren().addAll(name, userName, secretPass, birth, addThis );
		pane3.getChildren().addAll(logOut, editProfile, orderTickets);
		pane4.getChildren().addAll(logOut, addMore, listAll);
		pane6.getChildren().addAll(currentName, newName, currentUsername, newUsername, currentTotPay, newTotPay, 
				currentDateJoin, newDateJoin, ownerEdited, selectUser, selected);
		pane7.getChildren().addAll(eventPicker, eventPick);
		pane8.getChildren().add(ownEdit);
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

				ListView<User> listUs = new ListView<User>(listoUsers);
				pane8.getChildren().add(listUs);
				st1.setScene(listMenu);
			}
		});
		ownEdit.setOnAction(new EventHandler<ActionEvent>(){
			//so I think this is actually a button on the list user scene. 
			//I need to register a listener on the ListView of all the users so that i can go in a edit the selected user
			//i need to some how capture where the user is in the ArrayList, get all the relevant data, and be able to make changes
			//then i need to be able to change all the things to their new things

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
		ownerEdited.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

			}
		});
		selected.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

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
					pane2.getChildren().add(invalidName);
					usersName = null;
					name.clear();
				}
				else{
					if(User.isValidUsername(loginName)!= true){
						pane2.getChildren().add(invalidUsername);
						loginName = null;
						userName.clear();
					}
					else{
						SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						try{
							birthdate = format.parse(bDay);
						}
						catch(ParseException pe){
							pane2.getChildren().add(dateFormatErr);
							bDay = null;
							birth.clear();
						}
					}
				}
				currentUser = rt.newUser(loginName, usersName, myPass, payInfo, birthdate);
				name.clear();
				userName.clear();
				secretPass.clear();
				birth.clear();

				st1.setScene(ownerMenu);
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
			}
		});
		st1.setScene(fileIn());
		listoUsers = FXCollections.observableArrayList(rt.userList);
		st1.show();
	}
	public void stop () {
		rt.endGracefully();
	}
	public static void main (String[] args){
		Application.launch(RoboGUI.class,args);
	}
}
