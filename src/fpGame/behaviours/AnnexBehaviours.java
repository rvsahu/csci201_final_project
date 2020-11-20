package fpGame.behaviours;

//java imports
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

//javafx imports
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

//intraproject imports
import fpGame.GameUtil;
import fpModel.Perspective;
import fpModel.Room;
import fpModel.RoomObject;
import fpModel.GenericObject;
import fpModel.WrapperObject;
import fpModel.InfoObject;
import fpModel.ContainerObject;
import fpModel.DoorObject;

/**
 * Container class for every EventHandler for every RoomObject in Annex
 */
public class AnnexBehaviours {
	public static EventHandler<MouseEvent> annexComputer2Behaviour(InfoObject c) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				BorderPane pane = new BorderPane();
				addPCBackground(pane);
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				Text text = new Text();
				text.setText("The animal says: ");
				text.setFill(Color.WHITE);
				text.setFont(new Font(30));
				text.setTextAlignment(TextAlignment.CENTER);
				pane.setCenter(text);
				
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
	
	public static EventHandler<MouseEvent> annexComputer5Behaviour(InfoObject c) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event)  {
				BorderPane pane = new BorderPane();
				addPCBackground(pane);
				
				ImageView catView = null;
				try  {
					Image catim = new Image(new FileInputStream("./graphics/game_graphics/rooms/annex/cat.png"), 
							1024 * GameUtil.scalingFactor(), 964*GameUtil.scalingFactor(), true,true);
					catView = new ImageView(catim);		
					
				} catch (IOException ie) {
					System.err.println("cat.png could not be added!");
				};
				
				
				pane.setCenter(catView);
				
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
		
	public static EventHandler<MouseEvent> annexComputer7Behaviour(InfoObject c7) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				final BooleanProperty gotPasscode = new SimpleBooleanProperty(); //flag for if the user obtains passcode
				gotPasscode.set(false);
				final BooleanProperty alreadyGotPasscode = new SimpleBooleanProperty(); //flag for if user already obtained passcode
				alreadyGotPasscode.set(!(c7.hasInfo()));
				
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				BorderPane pane = new BorderPane();
				addPCBackground(pane);
				
				
				Text output = new Text();
				output.setFont(new Font(20));
				output.setFill(Color.WHITE);
				pane.setTop(output);
				
				
				TextField text = new TextField();
				text.setText("Assemble the computer clues and provide the answer here to open the way");
				text.setOnAction(e -> {
					handleSubmission(gotPasscode, text, output, pane);
				});
				text.setMaxWidth((GameUtil.WINDOW_X* GameUtil.scalingFactor()*2)/5);
				//pane.setCenter(text);
				
				Button button = new Button("Submit");
				button.setPrefSize(100, 50);
				button.setFont(new Font(20));
				button.setOnAction(e-> {
					handleSubmission(gotPasscode, text, output, pane);
				});
				//button.setTranslateY(100);
				//pane.setCenter(button);
				
				VBox box = new VBox(10);
				box.getChildren().addAll(text, button);
				box.setAlignment(Pos.CENTER);
				pane.setCenter(box);
				
				/*
				if (GameUtil.needsScaling()) { 
					backIMG = new Image(new FileInputStream(layerPaths[layer]), GameUtil.WINDOW_X * GameUtil.scalingFactor(),
							            GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
				} else {
					backIMG = new Image(new FileInputStream(layerPaths[layer]));
				}
				*/
				
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
	
	public static EventHandler<MouseEvent> projectorBehaviour(GenericObject p) {
		
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {				
				GenericObject ps = new GenericObject("Annex Projection");
				ps.setFrontSpritePath("./graphics/game_graphics/rooms/annex/front/layer0/projMess.png");
				ps.loadSprites();
				GameUtil.map().annex.addGenericFront(ps);
				ps.setLayerFront(0);
				
				GameUtil.displayPlayerView(); 
			}
		};
		return behaviour;
	}
	
	
	public static EventHandler<MouseEvent> keypadBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>()  
		{
			@Override public void handle(MouseEvent event) 
			{
				BorderPane pane = new BorderPane();
				
				TextField text = new TextField("Enter the passcode to escape this room.");
				pane.setCenter(text);
				
				Text output = new Text();
				output.setFill(Color.WHITE);
				output.setFont(new Font(20));
				Button button = new Button("Submit");
				button.setPrefSize(100, 50);
				button.setFont(new Font(20));
				pane.setBottom(button);
				
				button.setOnAction(new EventHandler<ActionEvent>() { 
					@Override public void handle(ActionEvent event) {
						if (text.getText().compareTo("5417") == 0) {
							output.setText("Correct Passcode -- Door unlocked!");
							d.unlock();
						} else {
							output.setText("Incorrect Passcode!");
						}
						pane.setTop(output);
					}
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
	
	public static EventHandler<MouseEvent> doorMainBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to the main room is locked. Beside it is a small black keypad.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().mainA);
					GameUtil.player().setCurrentPerspective(3);
					GameUtil.displayPlayerView();
				}
				
				
			}
		};
		
		return behaviour;
	}	
	
	public static EventHandler<MouseEvent> doorStudy1Behaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Study 1 is locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().study1);
					GameUtil.player().setCurrentPerspective(1);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorStudy2Behaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Study 2 is locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().study2);
					GameUtil.player().setCurrentPerspective(1);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}

	public static EventHandler<MouseEvent> doorStudy3Behaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Study 3 is locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().study3);
					GameUtil.player().setCurrentPerspective(2);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorStudy4Behaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to Study 4 is locked.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().study4);
					GameUtil.player().setCurrentPerspective(2);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> doorCoveBehaviour(DoorObject d) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				if(d.isLocked()) {
					GameUtil.setMessage("The door to the cove is locked. This shouldn't be possible.");
				} else {
					GameUtil.player().setCurrentRoom(GameUtil.map().cove);
					GameUtil.player().setCurrentPerspective(1);
					GameUtil.displayPlayerView();
				}
				
			}
		};
		
		return behaviour;
	}
	
	public static EventHandler<MouseEvent> annexWrongComputerBehaviour(InfoObject c) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent> () {
			@Override public void handle(MouseEvent event) {
				GameUtil.setMessage("You used " + c.name() + " but couldn't find any useful information on it.");
			}
		};
		return behaviour;
	}
	
	private static void addPCBackground(Pane pane) {
		ImageView background = null;
		
		try {
			
			Image backIMG;
			
			if (GameUtil.needsScaling()) { 
				backIMG = new Image(new FileInputStream("./graphics/game_graphics/subscreens/pc_background.jpg"), GameUtil.WINDOW_X * GameUtil.scalingFactor(),
						            GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
			} else {
				backIMG = new Image(new FileInputStream("./graphics/game_graphics/subscreens/pc_background.jpg"));
			}
			
			background = new ImageView(backIMG);
			pane.getChildren().add(background);
			
			
			
			
		} catch (Exception e) {
			System.err.println("Error loading PC background!");
		}
		
		ImageView border = null;
		try {
			Image borderIMG;
			
			if (GameUtil.needsScaling()) { 
				borderIMG = new Image(new FileInputStream("./graphics/game_graphics/subscreens/pc_border.png"), GameUtil.WINDOW_X * GameUtil.scalingFactor(),
						            GameUtil.WINDOW_Y * GameUtil.scalingFactor(), true, true);
			} else {
				borderIMG = new Image(new FileInputStream("./graphics/game_graphics/subscreens/pc_border.png"));
			}
			
			border = new ImageView(borderIMG);
			pane.getChildren().add(border);
			
		} catch (Exception e) {
			System.err.println("Error loading PC border!");
		}
	}
	
	public static void addBehaviours(List<RoomObject> objects) {
		DoorObject annexToMain = null;
		
		for (RoomObject r : objects) {
			if (r.name().equals("Annex Computer 1")) {
				r.setBehaviour(annexWrongComputerBehaviour((InfoObject)r));
				continue;
			}
			if (r.name().equals("Annex To Main")) {
				annexToMain = (DoorObject)r;
				r.setBehaviour(doorMainBehaviour((DoorObject)r));
				continue;
			}
			if (r.name().equals("Annex to Main Keypad")) {
				
			}
		}
	}
}
	

