import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**@author Anna Kroon @date 04/01/2018 @version 1 */

public class RoboGUI extends Application{
	Text line1 = new Text (70, 60, "Welcome to RoboTicket by Anna Kroon");
	Button exButton = new Button ("Start");
	Text line2 = new Text (130, 80, "Console Program Started.");
	Font f1 = Font.font ("Comic Sans", FontWeight.NORMAL, FontPosture.REGULAR, 20);
	Pane pane1 = new Pane();
	/**
	 * This is the main GUI function that creates and handles the text and button.
	 * @param Stage
	 * @return none
	 */
	public void start (Stage st1){
		Scene sn = new Scene (pane1, 500, 200);
		sn.setFill(Color.DARKGRAY);
		st1.setTitle("RoboTicket");
		line2.setFont(f1);
		line2.setFill(Color.LIMEGREEN);
		line2.setVisible(false);
		exButton.setLayoutX(230);
		exButton.setLayoutY(100);
		line1.setFill(Color.BLUE);
		line1.setFont(f1);
		pane1.getChildren().addAll(line1, exButton,line2);
		//I could not get the GUI and the console to appear at the same time do to thread issues, so I made the GUI 
		//enter into the console portion of the program.
		exButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent j){
				line2.setVisible(true);
				exButton.setText("Started");
				st1.close();
			}
		});

		st1.setScene(sn);
		st1.show();
	}
}
