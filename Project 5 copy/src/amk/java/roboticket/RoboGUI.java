package amk.java.roboticket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
	VBox errBx = new VBox();
	Label userPromptL = new Label ("Please enter the new user's information:");
	Text invalidUsername = new Text("Invalid username, too few characters. Please try again.");
	Text invalidName = new Text("Please enter a valid name in the format Lastname, Firstname.");
	Text dateFormatErr = new Text ("Incorrect date format. mm-dd-yyyy");

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
	TextField username = new TextField();
	TextField password = new TextField();
	TextField cardNumber = new TextField();
	TextField cardSVN = new TextField();
	TextField expire = new TextField();
	Payment myPay;
	Label nameUL = new Label("Name:");
	Label usernameUL = new Label("Username:");
	Label passwordUL = new Label("Password:");
	Label paymentL = new Label("Select Payment Type:");
	Button userEdited = new Button("Save Edits");
	Label editTitle = new Label("Please enter new info:");
	Button closeAccount = new Button("Close Account");


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
	Label nameL = new Label("Name:");
	Label usernameL = new Label("Username:");
	Label totPayL = new Label("Total Paid To Date:");
	Label dateJoinedL = new Label("Date Joined:");
	Label editPrompt = new Label("Edit this user's information:");
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
	VBox listBx = new VBox();
	Label listL = new Label("ID Number\tUsername\tName\tUser Status\tYears Active\tAmount Paid");


	Pane pane9 = new Pane();
	Scene errorPg = new Scene(pane9, 600,500);
	Text err = new Text(200, 200, "An error had occured.");

	/**
	 * This creates all of the user editing options and functions.
	 * @param User thisUser
	 * @return none
	 */
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
					Label passwordL = new Label("Enter Apple Pay Password:");


					paymentBx.getChildren().addAll(usernameL, username, passwordL, password);
					paymentBx.setLayoutX(150);
					paymentBx.setLayoutY(250);
					pane5.getChildren().add(paymentBx);

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
				}
				else{
					VBox paymentBx = new VBox();
					Label usernameL = new Label("Enter Username:");
					Label cardNumberL = new Label("Enter Credit Card Number:");
					Label cardSVNL = new Label("Enter SVN:");
					Label expireL = new Label("Enter Expiration Date MM/YY:");


					paymentBx.getChildren().addAll(usernameL, username, cardNumberL, cardNumber, cardSVNL, cardSVN, expireL, expire);
					paymentBx.setLayoutX(150);
					paymentBx.setLayoutY(250);
					pane5.getChildren().add(paymentBx);
				}
			}
		});

		currentUName = thisUser.getName();
		currentLogIn = thisUser.getUsername();
		currentPassword = thisUser.getPassword();

		newPassword.setText(currentPassword);
		newLogIn.setText(currentLogIn);
		newUName.setText(currentUName);

		editTitle.setFont(f1);


		pane5.getChildren().addAll(uEditingFields);

		userEdited.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

				currentUName = newUName.getText();
				currentLogIn = newLogIn.getText();
				currentPassword = newPassword.getText();


				thisUser.setName(currentUName);
				thisUser.setUsername(currentLogIn);
				thisUser.setPassword(currentPassword);

				if(payType.getValue() =="Apple Pay"){
					String theUser = username.getText();
					String thePass = password.getText();

					myPay = new ApplePay(theUser,thePass);

					thisUser.setPaymentInfo(myPay);
				}
				else if(payType.getValue() == "Android Pay"){

					String theUser = username.getText();
					String thePass = password.getText();

					myPay = new AndroidPay(theUser,thePass);

					thisUser.setPaymentInfo(myPay);
				}
				else{
					String theUser = username.getText();
					String theCard = cardNumber.getText();
					String theSecret = cardSVN.getText();
					String theExpire = expire.getText();

					myPay = new CreditCard(theUser,null, theCard, theSecret, theExpire);

					thisUser.setPaymentInfo(myPay);

				}
				rt.persistUser(thisUser);
				back2.fire();
			}
		});


	}
	/**
	 * This creates all of the owner editing options and functionalities.
	 * @param User thisUser
	 * @return none
	 */
	public void ownerEditing (User thisUser){
		SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy");
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		currentName = thisUser.getName();
		currentUsername = thisUser.getUsername();
		currentTotPay = thisUser.getPaidToDate().toString(); 
		currentDateJoin = fmt.format(thisUser.getDateJoined().getTime()); 

		newName.setText(currentName);
		newUsername.setText(currentUsername);
		newTotPay.setText(currentTotPay);
		newDateJoin.setText(currentDateJoin);


		editPrompt.setFont(f1);

		editingFields.setLayoutX(150);
		editingFields.setLayoutY(50);


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
					thisUser.setPaidToDate((Double.parseDouble(currentTotPay))); 
					st1.setScene(ownerMenu);
				} catch (ParseException e1) {
					dateJoinedL.setTextFill(Color.RED);
				}
				rt.persistUser(thisUser);
				back1.fire();
			}
		});


	}

	/**
	 * This creates the look of an functionality for buying three different types of tickets for three different age
	 * groups creating nine different prices. 
	 * @param none
	 * @return none
	 */
	public void buyTicket(){
		pane7.getChildren().removeAll(vb2);
		Label eventLabel = new Label("Please select an event type:");
		VBox eventsBx = new VBox();
		eventsBx.getChildren().clear();
		ArrayList<String> optionList = new ArrayList<String>();
		optionList.add("concert");
		optionList.add("sport");
		optionList.add("theater");
		ObservableList<String> eventOpt = FXCollections.observableArrayList(optionList);
		eventPicker.setItems(eventOpt);
		eventsBx.getChildren().addAll(eventLabel, eventPicker);
		eventsBx.setLayoutX(150);
		eventsBx.setLayoutY(25);
		pane7.getChildren().addAll(eventsBx,vb2);
		eventPicker.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String chosenOne = (String) eventPicker.getValue();
				if(chosenOne == "concert"){
					vb2.getChildren().clear();
					vb1.getChildren().clear();
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
					concertKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 75.0;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertAdult.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 150.0;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertSr.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 112.5;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});

				}
				else if(chosenOne == "sport"){
					vb2.getChildren().clear();
					vb1.getChildren().clear();
					Label sportPick = new Label("Please select an age group:");
					ToggleGroup sportAges = new ToggleGroup();
					RadioButton sportKid = new RadioButton("Child: $25");
					RadioButton sportAdult = new RadioButton("Adult: $50");
					RadioButton sportSr = new RadioButton("Senior: $37.50");
					sportKid.setToggleGroup(sportAges);
					sportAdult.setToggleGroup(sportAges);
					sportSr.setToggleGroup(sportAges);
					vb2.getChildren().addAll(sportPick, sportKid, sportAdult, sportSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					sportKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 25.0;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					sportAdult.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 50.0;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					sportSr.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 37.5;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});

				}
				else{
					vb2.getChildren().clear();
					vb1.getChildren().clear();
					Label theaterPick = new Label("Please select an age group:");
					ToggleGroup theaterAges = new ToggleGroup();
					RadioButton concertKid = new RadioButton("Child: $62.50");
					RadioButton concertAdult = new RadioButton("Adult: $125");
					RadioButton concertSr = new RadioButton("Senior: $93.75");
					concertKid.setToggleGroup(theaterAges);
					concertAdult.setToggleGroup(theaterAges);
					concertSr.setToggleGroup(theaterAges);
					vb2.getChildren().addAll(theaterPick, concertKid, concertAdult, concertSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					concertKid.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 62.5;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertAdult.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 125.0;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
					concertSr.setOnAction(new EventHandler<ActionEvent>(){
						@Override public void handle(ActionEvent e){
							vb1.getChildren().clear();
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
									Double price = 93.75;
									rt.chargeFee(numTix.getValue(), price, currentUser);
								}
							});
						}
					});
				}
			}
		});
	}
	/**
	 * This takes in the object file and returns the proper scent to set depending on the return value of the RoboTicket
	 * fileScan function.
	 * @param none
	 * @return Scene
	 */
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
	/**
	 * This formats most of the boxes, labels, and panes in the program. 
	 * @param none
	 * @return none
	 */
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

		buttonBx.setLayoutX(150);
		buttonBx.setLayoutY(350);

		uEditingFields.setLayoutX(150);
		uEditingFields.setLayoutY(50);



		//ComboBox Layouts
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

		//Labels
		uNameBx.getChildren().addAll(l1, logInName);
		uPassBx.getChildren().addAll(l2, logInPass);
		enterNameBx.getChildren().addAll(l3, name);
		enterLogBx.getChildren().addAll(l5, userName);
		enterPassBx.getChildren().addAll(l6, secretPass);
		enterBirthBx.getChildren().addAll(l4, birth);
		buttonBx.getChildren().addAll(addThis, back1);
		addInfoBx.getChildren().addAll(userPromptL, enterNameBx, enterLogBx, enterPassBx, enterBirthBx, buttonBx);
		logInInfo.getChildren().addAll(line1, line2, uNameBx, uPassBx, logInBut);
		uMenuBx.getChildren().addAll(uMenuL, editProfile, orderTickets, logOut);
		oMenuBx.getChildren().addAll(oMenuL, addMore, listAll, logOut2);
		uEditingBut.getChildren().addAll(userEdited, closeAccount, back2);
		editingBut.getChildren().addAll(ownerEdited, backList);
		editingFields.getChildren().addAll(editPrompt, nameL, newName, usernameL, newUsername, totPayL, newTotPay, dateJoinedL, newDateJoin);
		uEditingFields.getChildren().addAll(editTitle, nameUL, newUName, usernameUL, newLogIn, passwordUL, newPassword, paymentL, payType);
		vb2.getChildren().add(vb1);




		//Misc Set Up
		finishPay.setVisible(false);
		err.setFont(f1);
		err.setFill(Color.BLACK);


		//Adding to the panes
		pane1.getChildren().addAll(logInInfo);
		pane2.getChildren().addAll(addInfoBx, buttonBx,errBx);
		pane3.getChildren().addAll(uMenuBx);
		pane4.getChildren().addAll(oMenuBx);
		pane5.getChildren().addAll(uEditingBut);
		pane6.getChildren().addAll(editingBut, editingFields);
		pane7.getChildren().addAll(eventPicker, finishPay, back3);
		pane8.getChildren().addAll(listBx);
		pane9.getChildren().add(err);
	}
	/**
	 * This runs the buildGUI function and starts the entire program. Inside is most of the handlers for the various 
	 * buttons in the program.
	 * @param Stage st1
	 * @return none
	 */
	public void start (Stage st1){
		buildGUI();

		finishPay.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userMenu);
				pane7.getChildren().removeAll(vb2);
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
				st1.setScene(addUser);
			}
		});
		listAll.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

				listoUsers = FXCollections.observableArrayList(rt.userList);
				listUs.refresh();
				listUs.setItems(listoUsers);
				listUs.setPrefSize(400, 200);
				listBx.getChildren().clear();
				listBx.getChildren().addAll(listL, listUs, back4);
				listBx.setLayoutX(50);
				listBx.setLayoutY(50);
				listBx.setSpacing(10);
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
		addThis.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				errBx.getChildren().clear();
				Date birthdate = null;
				SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
				errBx.setLayoutX(150);
				errBx.setLayoutY(50);
				Boolean validationErr = false;

				String usersName = name.getText();
				String loginName = userName.getText();
				String myPass = secretPass.getText();
				String bDay = birth.getText();

				if(User.isValidName(usersName)!= true){
					errBx.getChildren().add(invalidName);
					usersName = null;
					name.clear();
					validationErr = true;
				}
				if(User.isValidUsername(loginName)!= true){
					errBx.getChildren().add(invalidUsername);
					loginName = null;
					userName.clear();
					validationErr = true;
				}
				try{
					birthdate = format.parse(bDay);
				}
				catch(ParseException pe){
					errBx.getChildren().add(dateFormatErr);
					bDay = null;
					birth.clear();
					validationErr=true;
				}
				if(validationErr!= true){	
					currentUser = rt.newUser(loginName, usersName, myPass, birthdate);
					name.clear();
					userName.clear();
					secretPass.clear();
					birth.clear();

					st1.setScene(ownerMenu);
				}
			}
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
	/**
	 * This function runs when the user exits the program to ensure data is saved and that the program ends gracefully.
	 * @param none
	 * @return none
	 */
	public void stop () {
		rt.endGracefully(currentUser);
	}
	/**
	 * This is required for the program to run in Eclipse.
	 * @param String [] args
	 * @return none
	 */
	public static void main (String[] args){
		Application.launch(RoboGUI.class,args);
	}
}
