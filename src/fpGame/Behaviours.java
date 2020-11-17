package fpGame;


//javafx imports
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.IOException;

import fpModel.Perspective;
import fpModel.Room;

/**
 * Container class for every EventHandler for every RoomObject 
 */
public class Behaviours {
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
				
				Pane pane = new Pane();
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				try  {
					Image catim = new Image(new FileInputStream("./graphics/game_graphics/rooms/annex/front/layer2/cat.png"), 
							1024 * GameUtil.scalingFactor(), 964*GameUtil.scalingFactor(), true,true);
					ImageView imageview = new ImageView(catim);		
				}
				catch (IOException ie) {
					System.err.println("cat.png not found");
				};
				
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
				//do stuff, fill in pane
				Scene scene;
				if (GameUtil.needsScaling()) {
					scene = new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							GameUtil.WINDOW_Y * GameUtil.scalingFactor(), Color.BLACK);
				} else {
					scene = new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y, Color.BLACK);
				}
				
				GameUtil.stage().setScene(scene);
				GameUtil.stage().show();
			}
		};
		
		return behaviour;
	}
		
	public static EventHandler<MouseEvent> annexComputer8Behaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>()  {
			@Override public void handle(MouseEvent event) {
				Pane pane = new Pane();
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				
				TextField text = new TextField("Assemble the clues together to unlock the computer: ");
				pane.getChildren().add(text);
				
				Text output = new Text();
				Button button = new Button("Submit");
				pane.getChildren().add(button);
				
				button.setOnAction(e-> {
					if (text.toString() == "Meow" || text.toString() =="meow") {
						output.setText("correct");
					} else {
						output.setText("wrong");
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
				
				Scene scene;
				if (GameUtil.needsScaling()) {
					scene = new Scene(pane, GameUtil.WINDOW_X * GameUtil.scalingFactor(), 
							GameUtil.WINDOW_Y * GameUtil.scalingFactor(), Color.BLACK);
				} else {
					scene = new Scene(pane, GameUtil.WINDOW_X, GameUtil.WINDOW_Y, Color.BLACK);
				}
				
				GameUtil.stage().setScene(scene);
				GameUtil.stage().show();
			}
		};
		
		return behaviour;
	}
}
