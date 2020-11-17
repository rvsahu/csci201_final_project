package fpGame.behaviours;

//java imports
import java.io.FileInputStream;
import java.io.IOException;

//javafx imports
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

//intraproject imports
import fpGame.GameUtil;
import fpModel.Computer;
import fpModel.DoorObject;
import fpModel.Perspective;
import fpModel.Projector;
import fpModel.ProjectorScreen;
import fpModel.Room;

/**
 * Container class for every EventHandler for every RoomObject in Annex
 */
public class AnnexBehaviours {
	public static EventHandler<MouseEvent> annexComputer2Behaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				Pane pane = new Pane();
				
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				Text text = new Text();
				text.setText("The animal says: ");
				text.setX((GameUtil.WINDOW_X * GameUtil.scalingFactor()) / 2);
				text.setY((GameUtil.WINDOW_Y * GameUtil.scalingFactor()) / 2);
				text.setFill(Color.WHITE);
				text.setFont(new Font(30));
				text.setTextAlignment(TextAlignment.CENTER);
				pane.getChildren().add(text);
				
				EventHandler<MouseEvent> exitBehaviour = new EventHandler<MouseEvent>() {
					@Override public void handle(MouseEvent event) {
						//return to gameplay
						Room cR = GameUtil.player().currentRoom();
						Perspective cP = GameUtil.player().currentView();
						cR.setPerspective(cP);
						GameUtil.displayPlayerView();
					}
				};
				
				pane.setOnMouseClicked(exitBehaviour);
				pane.setStyle("-fx-background-color: #000000;");
				//do stuff, fill in pane
				Scene scene;
				if (GameUtil.needsScaling()) {
					scene = new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							          GameUtil.WINDOW_Y * GameUtil.scalingFactor());
					//scene.setFill(Color.BLACK);
				} else {
					scene = new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y);
					//scene.setFill(Color.BLACK);
				}
				GameUtil.stage().setScene(scene);
				GameUtil.stage().show();
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> annexComputer5Behaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event)  {
				
				
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				
				ImageView imageview = null;
				try  {
					Image catim = new Image(new FileInputStream("./graphics/game_graphics/rooms/annex/front/layer2/cat.png"), 
							1024 * GameUtil.scalingFactor(), 964*GameUtil.scalingFactor(), true,true);
					imageview = new ImageView(catim);		
					
					
					//pane.getChildren().add(imageview);
					
				}
				catch (IOException ie) {
					System.err.println("cat.png not found");
				};
				BorderPane pane = new BorderPane(imageview);
				
				EventHandler<MouseEvent> exitBehaviour = new EventHandler<MouseEvent>()  {
					@Override public void handle(MouseEvent event) {
						//return to gameplay
						Room cR = GameUtil.player().currentRoom();
						Perspective cP = GameUtil.player().currentView();
						cR.setPerspective(cP);
						GameUtil.displayPlayerView();
					}
				};
				
				pane.setOnMouseClicked(exitBehaviour);
				pane.setStyle("-fx-background-color: #000000;");
				//do stuff, fill in pane
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
		};
		
		return behaviour;
	}
		
	public static EventHandler<MouseEvent> annexComputer7Behaviour(Computer c7) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				final BooleanProperty gotPasscode = new SimpleBooleanProperty(); //flag for if the user obtains passcode
				gotPasscode.set(false);
				final BooleanProperty alreadyGotPasscode = new SimpleBooleanProperty(); //flag for if user already obtained passcode
				alreadyGotPasscode.set(!(c7.hasInfo()));
				
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				BorderPane pane = new BorderPane();
				
				Text output = new Text();
				output.setFont(new Font(20));
				output.setFill(Color.WHITE);
				pane.setTop(output);
				
				TextField text = new TextField();
				text.setPromptText("Assemble the computer clues and provide the answer here to open the way: ");
				text.setOnAction(e -> {
					handleSubmission(gotPasscode, text, output, pane);
				});
				pane.setCenter(text);
				
				Button button = new Button("Submit");
				button.setOnAction(e-> {
					handleSubmission(gotPasscode, text, output, pane);
				});
				pane.setBottom(button);

				EventHandler<MouseEvent> exitBehaviour = new EventHandler<MouseEvent>() 
				{
					@Override public void handle(MouseEvent event) {
						//return to gameplay
						Room cR = GameUtil.player().currentRoom();
						Perspective cP = GameUtil.player().currentView();
						cR.setPerspective(cP);
						GameUtil.displayPlayerView();
						if (gotPasscode.getValue() && !(alreadyGotPasscode.getValue())) {
							GameUtil.setMessage("You wrote the passcode down in your logbook.");
						}
					}
				};
				
		        //exit when we click again
				pane.setOnMouseClicked(exitBehaviour);
				
				pane.setStyle("-fx-background-color: #000000;");
				
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
			
			public void handleSubmission(BooleanProperty gotPasscode, TextField text, Text output, BorderPane pane) {
				if (text.getText().equals("Meow") || text.getText().equals("meow")) {
					output.setText("The passcode to the door is 5417.");
					gotPasscode.set(true);
					if (c7.hasInfo()) {
						GameUtil.player().addToLogbook(c7.getInfo());
					}
				} else {
					output.setText("Wrong!");
				}
				pane.setTop(output);
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> projectorBehaviour(Projector p) {
		
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				p.startProjecting();
				
				//projector screen
				if (p.isProjecting()) {
					ProjectorScreen ps = new ProjectorScreen("Projector Screen");
					ps.setFrontSpritePath("./graphics/game_graphics/rooms/annex/front/layer2/doggo.png");
					ps.loadSprites();
					GameUtil.map().annex.addToFront(ps);
					ps.setLayerFront(2);
				}
				
				
				GameUtil.displayPlayerView(); 
			}
		};
		return behaviour;
	}
	
	
	public static EventHandler<MouseEvent> KeypadBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>()  
		{
			@Override public void handle(MouseEvent event) 
			{
				BorderPane pane = new BorderPane();
				
				TextField text = new TextField("Enter the passcode to escape this room: ");
				pane.setCenter(text);
				
				Text output = new Text();
				output.setFill(Color.WHITE);
				Button button = new Button("Submit");
				pane.setBottom(button);
				
				button.setOnAction(e-> 
				{
					if (text.getText().compareTo("5417") == 0) 
					{
						output.setText("Correct--Door unlocked");
						d.unlock();
					} 
					else 
					{
						output.setText("wrong");
					}
					pane.setTop(output);
				});

				EventHandler<MouseEvent> exitBehaviour = new EventHandler<MouseEvent>() 
				{
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
				
				pane.setStyle("-fx-background-color: #000000;");
				
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
		};
		
		return behaviour;
	}	
	
	public static EventHandler<MouseEvent> DoorMainBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				System.out.println("DoorEvent");
				if(d.isLocked()) {
					System.out.println("Locked");
					GameUtil.setMessage("The Door is locked. Beside it is a small black keypad.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainA);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
				
				
			}
		};
		
		return behaviour;
	}	
	
}
	

