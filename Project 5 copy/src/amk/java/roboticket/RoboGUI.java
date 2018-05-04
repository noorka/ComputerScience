package amk.java.roboticket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	Button backUser = new Button ("Back");
	Button backOwner = new Button ("Back");
	Button backList = new Button ("Back");
	ObservableList<User> listoUsers = null;

	Font f1 = Font.font ("Comic Sans", FontWeight.NORMAL, FontPosture.REGULAR, 20);


	Pane pane1 = new Pane();
	Scene welcomeSn = new Scene(pane1, 400,300);
	Text line1 = new Text (70, 60, "Welcome to RoboTicket by Anna Kroon");
	Text line2 = new Text (70, 80, "Please enter your username and password.");
	HBox uNameBx = new HBox();
	Label l1 = new Label("Username: ");
	TextField logInName = new TextField();//needs label
	HBox uPassBx = new HBox();
	Label l2 = new Label("Password: ");
	PasswordField logInPass = new PasswordField();//needs label
	Button logInBut = new Button("Log In");

	Pane pane2 = new Pane();
	Scene addUser = new Scene (pane2, 400,300);
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
	//Button back4 = new Button ("Back");
	Text invalidUsername = new Text(50,50, "Invalid username, too few characters. Please try again.");
	Text invalidName = new Text(50,50, "Please enter a valid name in the format Lastname, Firstname.");
	Text dateFormatErr = new Text (50, 50, "Incorrect format.");

	Pane pane3 = new Pane();
	Scene userMenu = new Scene(pane3, 400,300);
	Button editProfile = new Button("Edit Profile");
	Button orderTickets = new Button("Buy Tickets");

	Pane pane4 = new Pane();
	Scene ownerMenu = new Scene(pane4, 400,300);
	Button addMore = new Button("Add New User");
	Button listAll = new Button("List All Users");
	//Button back5 = new Button("Back");


	Pane pane5 = new Pane();
	Scene userEdit = new Scene(pane5, 400,300);
	//Button back2 = new Button ("Back");


	Pane pane6 = new Pane();
	Scene ownerEdit = new Scene(pane6, 400,300);
	Text currentName = new Text();
	TextField newName = new TextField();
	Text currentUsername = new Text();
	TextField newUsername = new TextField();
	Text currentTotPay = new Text();
	TextField newTotPay = new TextField();
	Text currentDateJoin = new Text();
	TextField newDateJoin = new TextField();
	Button ownerEdited = new Button("Save Edits");
	//ComboBox<User> selectUser = new ComboBox<User>();
	//Button selected = new Button ("Select");
	Button ownEdit = new Button("Edit User");
	//Button back1 = new Button ("Back");

	Pane pane7 = new Pane();
	Scene ticketMenu = new Scene(pane7, 400,300);
	ComboBox<String> eventPicker = new ComboBox<String>();
	Button finishPay = new Button("Finish Transaction");
	VBox vb1 = new VBox();
	VBox vb2 = new VBox();

	Pane pane8 = new Pane();
	Scene listMenu = new Scene(pane8, 400,300);
	//Button back3 = new Button ("Back");


	Pane pane9 = new Pane();
	Scene errorPg = new Scene(pane9, 400,300);
	Text err = new Text("An error had occured.");

	//buying a ticket
	public void buyTicket(){
		ArrayList<String> optionList = new ArrayList<String>();
		optionList.add("concert");
		optionList.add("sport");
		optionList.add("theater");
		ObservableList<String> eventOpt = FXCollections.observableArrayList(optionList);
		eventPicker.setItems(eventOpt);
		eventPicker.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				String chosenOne = (String) eventPicker.getValue();
				if(chosenOne == "concert"){
					ToggleGroup concertAges = new ToggleGroup();
					RadioButton concertKid = new RadioButton("Child: $75");
					RadioButton concertAdult = new RadioButton("Adult: $150");
					RadioButton concertSr = new RadioButton("Senior: $112.50");
					concertKid.setToggleGroup(concertAges);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 75;
									rt.chargeFee(numTix.getValue(), price);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 150;
									rt.chargeFee(numTix.getValue(), price);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 112;
									rt.chargeFee(numTix.getValue(), price);
								}
							});
						}
					});
					concertAdult.setToggleGroup(concertAges);
					concertSr.setToggleGroup(concertAges);
					vb2.getChildren().addAll(concertKid, concertAdult, concertSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					pane7.getChildren().add(vb2);
				}
				else if(chosenOne == "sport"){
					ToggleGroup concertAges = new ToggleGroup();
					RadioButton concertKid = new RadioButton("Child: $75");
					RadioButton concertAdult = new RadioButton("Adult: $150");
					RadioButton concertSr = new RadioButton("Senior: $112.50");
					concertKid.setToggleGroup(concertAges);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 75;
									rt.chargeFee(numTix.getValue(), price);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 150;
									rt.chargeFee(numTix.getValue(), price);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 112;
									rt.chargeFee(numTix.getValue(), price);
								}
							});
						}
					});
					concertAdult.setToggleGroup(concertAges);
					concertSr.setToggleGroup(concertAges);
					vb2.getChildren().addAll(concertKid, concertAdult, concertSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					pane7.getChildren().add(vb2);

				}
				else{
					ToggleGroup concertAges = new ToggleGroup();
					RadioButton concertKid = new RadioButton("Child: $75");
					RadioButton concertAdult = new RadioButton("Adult: $150");
					RadioButton concertSr = new RadioButton("Senior: $112.50");
					concertKid.setToggleGroup(concertAges);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 75;
									rt.chargeFee(numTix.getValue(), price);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 150;
									rt.chargeFee(numTix.getValue(), price);
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
							vb1.setLayoutX(100);
							vb1.setLayoutY(50);
							pane7.getChildren().add(vb1);
							numTix.setOnAction(new EventHandler<ActionEvent>(){
								@Override public void handle(ActionEvent e){
									finishPay.setVisible(true);
									Integer price = 112;
									rt.chargeFee(numTix.getValue(), price);
								}
							});
						}
					});
					concertAdult.setToggleGroup(concertAges);
					concertSr.setToggleGroup(concertAges);
					vb2.getChildren().addAll(concertKid, concertAdult, concertSr);
					vb2.setLayoutX(100);
					vb2.setLayoutY(100);
					pane7.getChildren().add(vb2);
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
		userMenu.setFill(Color.PINK);
		pane3.setBackground(null);
		ownerMenu.setFill(Color.PINK);
		pane4.setBackground(null);
		userEdit.setFill(Color.PINK);
		pane5.setBackground(null);
		ownerEdit.setFill(Color.PINK);
		pane6.setBackground(null);
		ticketMenu.setFill(Color.PINK);
		pane7.setBackground(null);
		listMenu.setFill(Color.PINK);
		pane8.setBackground(null);
		errorPg.setFill(Color.RED);
		pane9.setBackground(null);



		// Button Layouts

		finishPay.setLayoutX(100);
		finishPay.setLayoutY(170);

		backUser.setLayoutX(70);
		backUser.setLayoutY(170);

		backOwner.setLayoutX(70);
		backOwner.setLayoutY(170);

		backList.setLayoutX(170);


		uNameBx.setLayoutX(70);
		uNameBx.setLayoutY(90);

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


		//Box Layouts
		addInfoBx.setLayoutX(70);
		addInfoBx.setLayoutY(20);

		uPassBx.setLayoutX(70);
		uPassBx.setLayoutY(120);

		//ListView

		currentName.setLayoutY(40);
		newName.setLayoutY(50);
		currentUsername.setLayoutY(70);
		newUsername.setLayoutY(60);
		currentTotPay.setLayoutY(80);
		newTotPay.setLayoutY(90);
		currentDateJoin.setLayoutY(110);
		newDateJoin.setLayoutY(120);
		ownerEdited.setLayoutY(150);

		//combobox
		eventPicker.setLayoutX(150);
		eventPicker.setLayoutY(20);

		//Box Spacing
		addInfoBx.setSpacing(10);
		buttonBx.setSpacing(30);

		//labels
		uNameBx.getChildren().addAll(l1, logInName);
		uPassBx.getChildren().addAll(l2, logInPass);
		enterNameBx.getChildren().addAll(l3, name);
		enterLogBx.getChildren().addAll(l5, userName);
		enterPassBx.getChildren().addAll(l6, secretPass);
		enterBirthBx.getChildren().addAll(l4, birth);
		buttonBx.getChildren().addAll(backOwner, addThis);
		addInfoBx.getChildren().addAll(enterNameBx, enterLogBx, enterPassBx, enterBirthBx, buttonBx);



		finishPay.setVisible(false);



		//adding everything to the panes 
		pane1.getChildren().addAll(line1, line2, uNameBx, uPassBx, logInBut);
		pane2.getChildren().add(addInfoBx);
		pane3.getChildren().addAll(logOut, editProfile, orderTickets);
		pane4.getChildren().addAll(logOut, addMore, listAll);
		pane5.getChildren().add(backUser);
		pane6.getChildren().addAll(currentName, newName, currentUsername, newUsername, currentTotPay, newTotPay, 
				currentDateJoin, newDateJoin, ownerEdited, backList);
		pane7.getChildren().addAll(eventPicker, finishPay);
		pane8.getChildren().addAll(ownEdit, backOwner);
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

		backList.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(listMenu);
			}
		});
		backOwner.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(ownerMenu);
			}
		});
		backUser.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				st1.setScene(userMenu);
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
				listUs.setPrefSize(250, 200);
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
				logInName.clear();
				logInPass.clear();
				st1.setScene(welcomeSn);
			}
		});
		ownerEdited.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

			}
		});
		/*selected.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){

			}
		});*/

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
