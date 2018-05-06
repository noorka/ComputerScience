package amk.java.roboticket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import amk.java.roboticket.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.input.MouseEvent;
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
	Button back2 = new Button ("Back");
	Button back3 = new Button ("Back");
	Button back1 = new Button ("Back");
	Button back4 = new Button ("Back");
	ObservableList<User> listoUsers = null;
	Font f1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);


	Pane pane1 = new Pane();
	Scene welcomeSn = new Scene(pane1, 600,500);
	Text line1 = new Text (70, 60, "Welcome to RoboTicket by Anna Kroon");
	Text line2 = new Text (70, 80, "Please enter your username and password.");
	HBox uNameBx = new HBox();
	Label l1 = new Label("Username: ");
	TextField logInName = new TextField();
	HBox uPassBx = new HBox();
	Label l2 = new Label("Password: ");
	PasswordField logInPass = new PasswordField();
	Button logInBut = new Button("Log In");
	VBox logInInfo = new VBox();

	Pane pane2 = new Pane();
	Scene addUser = new Scene (pane2, 600,500);
	VBox enterNameBx = new VBox();
	TextField name = new TextField();
	Label l3 = new Label("Last-name, Firstname: ");
	VBox enterLogBx = new VBox();
	TextField userName = new TextField();
	Label l5 = new Label("Username: "
			+ "(at least 6 characters)");
	VBox enterPassBx = new VBox();
	TextField secretPass = new TextField();
	Label l6 = new Label("Password: ");
	VBox enterBirthBx = new VBox();
	TextField birth = new TextField();
	Label l4 = new Label("Birthday MM-DD-YYYY: ");
	VBox addInfoBx = new VBox();
	HBox buttonBx = new HBox();
	Button addThis = new Button("Add User");
	HBox errBx = new HBox();
	Label userPromptL = new Label ("Please enter the new user's information:");
	Text invalidUsername = new Text(50,50, "Invalid username, too few characters. Please try again.");
	Text invalidName = new Text(50,50, "Please enter a valid name in the format Lastname, Firstname.");
	Text dateFormatErr = new Text (50, 50, "Incorrect format.");

	Pane pane3 = new Pane();
	Scene userMenu = new Scene(pane3, 600,500);
	VBox uMenuBx = new VBox();
	Label uMenuL = new Label("Welcome, User!");
	Button editProfile = new Button("Edit Profile");
	Button orderTickets = new Button("Buy Tickets");
	Button logOut = new Button ("Log Out");

	Pane pane4 = new Pane();
	VBox oMenuBx = new VBox();
	Label oMenuL = new Label("Welcome, Owner!");
	Scene ownerMenu = new Scene(pane4, 600,500);
	Button addMore = new Button("Add New User");
	Button listAll = new Button("List All Users");
	Button logOut2 = new Button ("Log Out");


	Pane pane5 = new Pane();
	Scene userEdit = new Scene(pane5, 600,500);
	String currentUName = new String();
	TextField newUName = new TextField();
	String currentLogIn = new String();
	TextField newLogIn = new TextField();
	String currentPassword = new String();
	TextField newPassword = new TextField();
	ComboBox<String> payType = new ComboBox<String>();
	VBox uEditingFields = new VBox();
	HBox uEditingBut = new HBox();
	Button userEdited = new Button("Save Edits");
	Button closeAccount = new Button("Close Account");
	//how do I even do payment info?


	Pane pane6 = new Pane();
	Scene ownerEdit = new Scene(pane6, 600,500);
	String currentName = new String();
	TextField newName = new TextField();
	String currentUsername = new String();
	TextField newUsername = new TextField();
	String currentTotPay = new String();
	TextField newTotPay = new TextField();
	String currentDateJoin = new String();
	TextField newDateJoin = new TextField();
	VBox editingFields = new VBox();
	HBox editingBut = new HBox();
	Button ownerEdited = new Button("Save Edits");
	Button backList = new Button ("Back");

	Pane pane7 = new Pane();
	Scene ticketMenu = new Scene(pane7, 600,500);
	ComboBox<String> eventPicker = new ComboBox<String>();
	Button finishPay = new Button("Finish Transaction");
	VBox vb1 = new VBox();
	VBox vb2 = new VBox();

	Pane pane8 = new Pane();
	Scene listMenu = new Scene(pane8, 600,500);
	ListView<User> listUs = new ListView<User>();


	Pane pane9 = new Pane();
	Scene errorPg = new Scene(pane9, 600,500);
	Text err = new Text(200, 200, "An error had occured.");

	public void userEditing (User thisUser){
		ArrayList<String> payOption = new ArrayList<String>();
		payOption.add("Apple Pay");
		payOption.add("Android Pay");
		payOption.add("Credit Card");
		ObservableList<String> payOpt = FXCollections.observableArrayList(payOption);
		payType.setItems(payOpt); 

		payType.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				if(payType.getValue() == "Apple Pay"){
					VBox paymentBx = new VBox();
					Label usernameL = new Label("Enter Apple Pay Username:");
					TextField username = new TextField();
					Label passwordL = new Label("Enter Apple Pay Password:");
					TextField password = new TextField();

					paymentBx.getChildren().addAll(usernameL, username, passwordL, password);
					paymentBx.setLayoutX(150);
					paymentBx.setLayoutY(250);
					pane5.getChildren().add(paymentBx);

					String theUser = username.getText();
					String thePass = password.getText();

					Payment myPay = new ApplePay(theUser,thePass);

					thisUser.setPaymentInfo(myPay);
				}
				else if(payType.getValue() == "Android Pay"){
					VBox paymentBx = new VBox();
					Label usernameL = new Label("Enter Android Pay Username:");
					TextField username = new TextField();
					Label passwordL = new Label("Enter Android Pay Password:");
					TextField password = new TextField();

					paymentBx.getChildren().addAll(usernameL, username, passwordL, password);
					paymentBx.setLayoutX(150);
					paymentBx.setLayoutY(250);
					pane5.getChildren().add(paymentBx);

					String theUser = username.getText();
					String thePass = password.getText();

					Payment myPay = new AndroidPay(theUser,thePass);

					thisUser.setPaymentInfo(myPay);
				}
				else{
					VBox paymentBx = new VBox();
					Label usernameL = new Label("Enter Username:");
					TextField username = new TextField();
					Label cardNumberL = new Label("Enter Credit Card Number:");
					TextField cardNumber = new TextField();
					Label cardSVNL = new Label("Enter SVN:");
					TextField cardSVN = new TextField();
					Label expireL = new Label("Enter Expiration Date MM/YY:");
					TextField expire = new TextField();


					paymentBx.getChildren().addAll(usernameL, username, cardNumberL, cardNumber, cardSVNL, cardSVN, expireL, expire);
					paymentBx.setLayoutX(150);
					paymentBx.setLayoutY(250);
					pane5.getChildren().add(paymentBx);

					String theUser = username.getText();

					Payment myPay = null; 
					//= new CreditCard(theUser);

					thisUser.setPaymentInfo(myPay);
				}
			}
		});

		currentUName = thisUser.getName();
		currentLogIn = thisUser.getUsername();
		currentPassword = thisUser.getPassword();

		newPassword.setPromptText(currentPassword);
		newLogIn.setPromptText(currentLogIn);
		newUName.setPromptText(currentUName);

		Label editTitle = new Label("Please enter new info:");
		editTitle.setFont(f1);

		Label nameUL = new Label("Name:");
		Label usernameUL = new Label("Username:");
		Label passwordUL = new Label("Password:");
		Label paymentL = new Label("Select Payment Type:");

		uEditingFields.getChildren().addAll(editTitle, nameUL, newUName, usernameUL, newLogIn, passwordUL, newPassword, paymentL, payType);
		uEditingFields.setLayoutX(150);
		uEditingFields.setLayoutY(50);
		pane5.getChildren().addAll(uEditingFields);

		userEdited.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userMenu);// it does the thing, but doesn't change the stage... 
				currentUName = newUName.getText();
				currentLogIn = newLogIn.getText();
				currentPassword = newPassword.getText();

				thisUser.setName(currentUName);
				thisUser.setUsername(currentLogIn);
				thisUser.setPassword(currentPassword);
			}
		});


	}

	public void ownerEditing (User thisUser){
		SimpleDateFormat fmt = new SimpleDateFormat("mm-dd-yyyy");
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		//cal.setTime();
		currentName = thisUser.getName();
		currentUsername = thisUser.getUsername();
		currentTotPay = thisUser.getPaidToDate().toString(); 
		currentDateJoin = fmt.format(thisUser.getDateJoined().getTime()); 

		newName.setPromptText(currentName);
		newUsername.setPromptText(currentUsername);
		newTotPay.setPromptText(currentTotPay);
		newDateJoin.setPromptText(currentDateJoin);

		Label nameL = new Label("Name:");
		Label usernameL = new Label("Username:");
		Label totPayL = new Label("Total Paid To Date:");
		Label dateJoinedL = new Label("Date Joined:");
		Label editPrompt = new Label("Edit this user's information:");
		editPrompt.setFont(f1);

		editingFields.setLayoutX(150);
		editingFields.setLayoutY(50);

		editingFields.getChildren().addAll(editPrompt, nameL, newName, usernameL, newUsername, totPayL, newTotPay, dateJoinedL, newDateJoin);
		pane6.getChildren().addAll(editingFields);

		ownerEdited.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				currentName = newName.getText();
				currentUsername = newUsername.getText();
				currentTotPay = newTotPay.getText();
				currentDateJoin = newDateJoin.getText();

				thisUser.setName(currentName);
				thisUser.setUsername(currentUsername);
				try {
					cal.setTime(fmt.parse(currentDateJoin));
					thisUser.setDateJoined(cal); 
					thisUser.setPaidToDate(Integer.parseInt(currentTotPay)); 
					st1.setScene(ownerMenu);
				} catch (ParseException e1) {
					dateJoinedL.setTextFill(Color.RED);
				}
			}
		});


	}

	//buying a ticket
	public void buyTicket(){
		Label eventLabel = new Label("Please select an event type:");
		VBox eventsBx = new VBox();
		ArrayList<String> optionList = new ArrayList<String>();
		optionList.add("concert");
		optionList.add("sport");
		optionList.add("theater");
		ObservableList<String> eventOpt = FXCollections.observableArrayList(optionList);
		eventPicker.setItems(eventOpt);
		eventsBx.getChildren().addAll(eventLabel, eventPicker);
		eventsBx.setLayoutX(150);
		eventsBx.setLayoutY(25);
		pane7.getChildren().add(eventsBx);
		eventPicker.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String chosenOne = (String) eventPicker.getValue();
				if(chosenOne == "concert"){
					Label concertPick = new Label("Please select an age group:");
					ToggleGroup concertAges = new ToggleGroup();
					RadioButton concertKid = new RadioButton("Child: $75");
					RadioButton concertAdult = new RadioButton("Adult: $150");
					RadioButton concertSr = new RadioButton("Senior: $112.50");
					concertKid.setToggleGroup(concertAges);
					concertAdult.setToggleGroup(concertAges);
					concertSr.setToggleGroup(concertAges);
					vb2.getChildren().addAll(concertPick, concertKid, concertAdult, concertSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					pane7.getChildren().add(vb2);
					concertKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of child tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 75;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertAdult.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of adult tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 150;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertSr.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of Senior tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 112;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});

				}
				else if(chosenOne == "sport"){
					Label sportPick = new Label("Please select an age group:");
					ToggleGroup sportAges = new ToggleGroup();
					RadioButton sportKid = new RadioButton("Child: $25");
					RadioButton sportAdult = new RadioButton("Adult: $50");
					RadioButton sportSr = new RadioButton("Senior: $37.5");
					sportKid.setToggleGroup(sportAges);
					sportAdult.setToggleGroup(sportAges);
					sportSr.setToggleGroup(sportAges);
					vb2.getChildren().addAll(sportPick, sportKid, sportAdult, sportSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					pane7.getChildren().add(vb2);
					sportKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of child tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);;
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 25;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					sportAdult.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of adult tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);;
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 50;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					sportSr.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of Senior tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);;
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 38;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});

				}
				else{
					Label theaterPick = new Label("Please select an age group:");
					ToggleGroup theaterAges = new ToggleGroup();
					RadioButton concertKid = new RadioButton("Child: $62.5");
					RadioButton concertAdult = new RadioButton("Adult: $125");
					RadioButton concertSr = new RadioButton("Senior: $93.75");
					concertKid.setToggleGroup(theaterAges);
					concertAdult.setToggleGroup(theaterAges);
					concertSr.setToggleGroup(theaterAges);
					vb2.getChildren().addAll(theaterPick, concertKid, concertAdult, concertSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					pane7.getChildren().add(vb2);
					concertKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of child tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);;
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 63;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertAdult.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of adult tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);;
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 125;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertSr.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							Label numTixL = new Label("Select the number of Senior tickets you would like.");
							ArrayList<Integer> amountOpt = new ArrayList<Integer>();
							amountOpt.add(1);
							amountOpt.add(2);
							amountOpt.add(3);
							amountOpt.add(4);
							amountOpt.add(5);
							amountOpt.add(6);
							amountOpt.add(7);
							amountOpt.add(8);
							amountOpt.add(9);
							ObservableList<Integer> amountList = FXCollections.observableArrayList(amountOpt);;
							ComboBox<Integer> numTix = new ComboBox<Integer>();
							numTix.setItems(amountList);
							vb1.getChildren().addAll(numTixL, numTix);
							vb2.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 94;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
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
		welcomeSn.setFill(Color.DEEPSKYBLUE);
		pane1.setBackground(null);
		addUser.setFill(Color.PINK);
		pane2.setBackground(null);
		userMenu.setFill(Color.DARKSEAGREEN);
		pane3.setBackground(null);
		ownerMenu.setFill(Color.MEDIUMPURPLE);
		pane4.setBackground(null);
		userEdit.setFill(Color.THISTLE);
		pane5.setBackground(null);
		ownerEdit.setFill(Color.LIGHTBLUE);
		pane6.setBackground(null);
		ticketMenu.setFill(Color.LIGHTSKYBLUE);
		pane7.setBackground(null);
		listMenu.setFill(Color.SALMON);
		pane8.setBackground(null);
		errorPg.setFill(Color.RED);
		pane9.setBackground(null);



		// Button Layouts

		finishPay.setLayoutX(150);
		finishPay.setLayoutY(260);

		back3.setLayoutX(175);
		back3.setLayoutY(300);

		back4.setLayoutX(175);
		back4.setLayoutY(300);

		//backUser.setLayoutX(70);
		//backUser.setLayoutY(170);

		//backOwner.setLayoutX(70);
		//backOwner.setLayoutY(170);

		//backList.setLayoutX(170);

		//addMore.setLayoutX(70);
		//addMore.setLayoutY(70);

		//listAll.setLayoutX(70);
		//listAll.setLayoutY(100);

		//ownerEdited.setLayoutX(70);
		//ownerEdited.setLayoutY(350);

		//closeAccount.setLayoutX(70);
		//closeAccount.setLayoutX(200);



		//Box Layouts
		addInfoBx.setLayoutX(150);
		addInfoBx.setLayoutY(100);

		logInInfo.setLayoutX(150);
		logInInfo.setLayoutY(100);

		uMenuBx.setLayoutX(150);
		uMenuBx.setLayoutY(100);

		oMenuBx.setLayoutX(150);
		oMenuBx.setLayoutY(100);

		uEditingBut.setLayoutX(150);
		uEditingBut.setLayoutY(430);

		editingBut.setLayoutX(150);
		editingBut.setLayoutY(350);


		//combobox
		eventPicker.setLayoutX(150);
		eventPicker.setLayoutY(20);

		//Box Spacing
		addInfoBx.setSpacing(10);
		buttonBx.setSpacing(30);
		editingFields.setSpacing(10);
		logInInfo.setSpacing(5);
		uMenuBx.setSpacing(20);
		oMenuBx.setSpacing(20);
		uEditingBut.setSpacing(30);
		editingBut.setSpacing(30);
		vb2.setSpacing(5);

		//labels
		uNameBx.getChildren().addAll(l1, logInName);
		uPassBx.getChildren().addAll(l2, logInPass);
		enterNameBx.getChildren().addAll(l3, name);
		enterLogBx.getChildren().addAll(l5, userName);
		enterPassBx.getChildren().addAll(l6, secretPass);
		enterBirthBx.getChildren().addAll(l4, birth);
		buttonBx.getChildren().addAll(addThis);
		addInfoBx.getChildren().addAll(userPromptL, enterNameBx, enterLogBx, enterPassBx, enterBirthBx, buttonBx);
		logInInfo.getChildren().addAll(line1, line2, uNameBx, uPassBx, logInBut);
		uMenuBx.getChildren().addAll(uMenuL, editProfile, orderTickets, logOut);
		oMenuBx.getChildren().addAll(oMenuL, addMore, listAll, logOut2);
		uEditingBut.getChildren().addAll(userEdited, closeAccount, back2);
		editingBut.getChildren().addAll(ownerEdited, backList);



		finishPay.setVisible(false);
		err.setFont(f1);
		err.setFill(Color.BLACK);


		//adding everything to the panes 
		pane1.getChildren().addAll(logInInfo);
		pane2.getChildren().add(addInfoBx);
		pane3.getChildren().addAll(uMenuBx);
		pane4.getChildren().addAll(oMenuBx);
		pane5.getChildren().addAll(uEditingBut);
		pane6.getChildren().addAll(editingBut);
		pane7.getChildren().addAll(eventPicker, finishPay, back3);
		//pane8.getChildren().addAll(back4);
		pane9.getChildren().add(err);
	}

	public void start (Stage st1){
		buildGUI();
		//Fix the back buttons. they are messed up
		//can i have a user vs owner back that shows up on multiple panes??

		finishPay.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userMenu);
				pane7.getChildren().removeAll(vb1,vb2);
				finishPay.setVisible(false);
				vb1.getChildren().clear();
				vb2.getChildren().clear();
				eventPicker.setValue(null);
			}
		});
		closeAccount.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(welcomeSn);
				currentUser.setIsUser(false);
				rt.persistUser(currentUser);
				currentUser = null;
				logInName.clear();
				logInPass.clear();
			}
		});
		backList.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(listMenu);
			}
		});
		back1.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(ownerMenu);
			}
		});
		back2.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userMenu);
			}
		});
		back3.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userMenu);
			}
		});
		back4.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(ownerMenu);
			}
		});
		orderTickets.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				buyTicket();
				st1.setScene(ticketMenu);
			}
		});
		editProfile.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				userEditing(currentUser);
				st1.setScene(userEdit);
			}
		});
		addMore.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				buttonBx.getChildren().addAll(back1);
				st1.setScene(addUser);
			}
		});
		listAll.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Label listL = new Label("ID Number\tUsername\tName\tUser Status\tYears Active\tAmount Paid");
				VBox listBx = new VBox();
				listBx.getChildren().addAll(listL, listUs, back4);
				listoUsers = FXCollections.observableArrayList(rt.userList);
				listUs.setItems(listoUsers);
				listUs.setPrefSize(400, 200);
				listBx.setLayoutX(50);
				listBx.setLayoutY(50);
				listBx.setSpacing(10);
				pane8.getChildren().add(listBx);
				st1.setScene(listMenu);
			}
		});
		listUs.setOnMousePressed(new EventHandler<MouseEvent>(){

			public void handle(MouseEvent m){
				User editingUser = listUs.getSelectionModel().getSelectedItem();
				ownerEditing(editingUser);
				st1.setScene(ownerEdit);
			}
		});

		logOut.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				rt.persistUser(currentUser);
				currentUser = null;
				logInName.clear();
				logInPass.clear();
				st1.setScene(welcomeSn);
			}
		});
		logOut2.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				rt.persistUser(currentUser);
				currentUser = null;
				logInName.clear();
				logInPass.clear();
				st1.setScene(welcomeSn);
			}
		});
		ownerEdited.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

			}
		});
		//USER VALIDATION ISN'T WORKING!!!
		addThis.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Date birthdate = null;

				String usersName = name.getText();
				String loginName = userName.getText();
				String myPass = secretPass.getText();
				String bDay = birth.getText();

				if(User.isValidName(usersName)!= true){
					errBx.getChildren().add(invalidName);
					errBx.setLayoutX(150);
					errBx.setLayoutY(50);
					pane2.getChildren().add(errBx);
					usersName = null;
					name.clear();
				}
				else{
					if(User.isValidUsername(loginName)!= true){
						errBx.getChildren().add(invalidUsername);
						errBx.setLayoutX(150);
						errBx.setLayoutY(50);
						pane2.getChildren().add(errBx);
						loginName = null;
						userName.clear();
					}
					else{
						SimpleDateFormat format = new SimpleDateFormat("mm-dd-yyyy");
						try{
							birthdate = format.parse(bDay);
						}
						catch(ParseException pe){
							errBx.getChildren().add(dateFormatErr);
							errBx.setLayoutX(150);
							errBx.setLayoutY(50);
							pane2.getChildren().add(errBx);
							bDay = null;
							birth.clear();
						}
					}
				}
				currentUser = rt.newUser(loginName, usersName, myPass, birthdate);
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
					currentUser = thisUser;
					Integer i = thisUser.getUserID();
					if(i==0){
						st1.setScene(ownerMenu);
					}
					else{
						st1.setScene(userMenu);
					}
				}
				else{
					Text redoMsg = new Text(150, 60, "Please try again.");
					Font f1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);

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
		rt.endGracefully(currentUser);
	}
	public static void main (String[] args){
		Application.launch(RoboGUI.class,args);
	}
}
