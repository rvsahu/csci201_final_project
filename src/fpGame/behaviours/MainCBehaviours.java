package fpGame.behaviours;

//intraproject imports
import fpGame.GameUtil;
import fpModel.RoomObject;
import fpModel.DoorObject;
import fpModel.InfoObject;
import fpModel.Perspective;
import fpModel.Room;
import fpModel.GenericObject;
import javafx.event.ActionEvent;
//javafx imports
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//java imports
import java.util.List;

public class MainCBehaviours {
	public static EventHandler<MouseEvent> dustbinBehaviour(GenericObject dustbin)  {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the dustbin but found nothing.");
			};
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> frontDoorBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The front door is locked.");
				} else {
					BorderPane pane = new BorderPane();
					
					Text output = new Text();
					output.setFill(Color.WHITE);
					output.setFont(new Font(20));
					output.setText("You escaped!\n\n\nThanks for playing!");
					
					pane.setCenter(output);
					
					pane.setStyle("-fx-background-color: #990000;");
					
					Scene scene;
					if (GameUtil.needsScaling()) {
						scene = new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
								GameUtil.WINDOW_Y * GameUtil.scalingFactor());
					} else {
						scene = new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y);
					}
					
					GameUtil.stage().setScene(scene);
					GameUtil.stage().show();
				}
				
			}
		};
		
		return behaviour;
	}
	
	
	public static EventHandler<MouseEvent> frontDoorKeypad(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() { 
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The front door is locked.");
					GameUtil.setMessage("Seems that the keypad is broken . . . You need a key.");
				} else {
					
				}
				
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> couchBehavior(GenericObject couch) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You searched the couch but found nothing.");
			}
		};
		return behaviour;
	}
	
	
	
	public static EventHandler<MouseEvent> phoneBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				BorderPane pane = new BorderPane();
				TextField tField = new TextField("Enter a phone number to call somebody: ");
				tField.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
						
				Text output = new Text();
				output.setFill(Color.WHITE);
				output.setFont(new Font(20));
				Button button = new Button("Dial");
				button.setPrefSize(100, 50);
				button.setFont(new Font(20));
						
				VBox box = new VBox(10);
				box.getChildren().addAll(tField, button);
				box.setAlignment(Pos.CENTER);
				pane.setCenter(box);
						
				button.setOnAction(new EventHandler<ActionEvent>() { 
					@Override public void handle(ActionEvent event) {
						if (tField.getText().equals("3401")) {
							output.setText("Dialing . . . "
										   + "Who is calling me at 3 AM? \n"
										   + "Oh. You guys are locked in SAL right now? \n"
										   + "That's not good . . . give me one second. \n"
										   + "Ok. I unlocked the door. You guys are good to go! \n"
									       + "Code hard!");
							d.unlock();
						} else {
							output.setText("You dialed the number . . . but nobody answered");
						}
						pane.setTop(output);
					}
				});

				EventHandler<MouseEvent> exitBehaviour = new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent event) {
						//return to gameplay
						Room cR = GameUtil.player().currentRoom();
						Perspective cP = GameUtil.player().currentView();
						cR.setPerspective(cP);
						GameUtil.displayPlayerView();
					}
				};
						
				//exit when we click again
				pane.setOnMouseClicked(exitBehaviour);
				pane.setStyle("-fx-background-color: #990000;");
						
				Scene scene;
				if (GameUtil.needsScaling()) {
					scene = new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor(), GameUtil.WINDOW_Y * GameUtil.scalingFactor());
				} else {
					scene = new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y);
				}
						
				GameUtil.stage().setScene(scene);
				GameUtil.stage().show();
			}
		};
				
		return behaviour;	
	}

	
	public static EventHandler<MouseEvent> arrowBBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main B is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainB);
					GameUtil.player().setCurrentPerspective(1);
					GameUtil.displayPlayerView();
				}
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> arrowDBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Main D is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainD);
					GameUtil.player().setCurrentPerspective(2);
					GameUtil.displayPlayerView();
				}
			}
		};
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> notebookBehaviour(InfoObject notebook) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				String message = "\"I am so over this programming assignment.\n";
				message += "I'm getting a bit hungry!\n";
				message += "I will grab some of the coins I hid in the study rooms and grab some snacks.\n";
				message += "Hope I can pass this class!\"";
				if (notebook.hasInfo()) {
					message = "You read a message in the notebook:\n" + message;
					message += "You make a note that there is some money in the study rooms.";
					GameUtil.player().addToLogbook(notebook.getInfo());
				} else {
					message = "You reread the notebook message:\n" + message;
				}
				GameUtil.setMessage(message);
			}
		};
		
		return behaviour;
	}
	
	public static void addBehaviours(List<RoomObject> objects) {
		
		for (RoomObject r : objects) {
			
		}
	}
}
