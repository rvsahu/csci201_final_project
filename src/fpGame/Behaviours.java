package fpGame;


//javafx imports
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.IOException;

import fpModel.Computer;
import fpModel.Perspective;
import fpModel.Projector;
import fpModel.ProjectorScreen;
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
		
	public static EventHandler<MouseEvent> annexComputer8Behaviour() {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>()  
		{
			@Override public void handle(MouseEvent event) 
			{
				//get a image border for the screen that looks like a display frame, needs to be 1920 x 1080
				//create text object
				BorderPane pane = new BorderPane();
				
				TextField text = new TextField("Assemble the clues from the computers to unlock: ");
				pane.setCenter(text);
				
				Text output = new Text();
				output.setFill(Color.WHITE);
				Button button = new Button("Submit");
				pane.setBottom(button);
				
				button.setOnAction(e-> {
					if (text.getText().compareTo("Meow") == 0 || text.getText().compareTo("meow") == 0) {
						output.setText("correct");
					} else {
						System.out.println("The output is set to: " + output);
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
	
	public static EventHandler<MouseEvent> projectorBehaviour(Projector p, Room annex)
	{
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>()  
		{
			@Override public void handle(MouseEvent event) 
			{
				System.out.println("entered projectorbehavior");
				p.startProjecting();
				
				//projector screen
				if (p.isProjecting())
				{
					ProjectorScreen ps = new ProjectorScreen("Projector Screen");
					ps.setFrontSpritePath("./graphics/game_graphics/rooms/annex/front/layer2/doggo.png");
					ps.loadSprites();
					annex.addToFront(ps);
					ps.setLayerFront(2);
				}
				
				
				System.out.println("Now regenerating to print the dog photo");
				GameUtil.displayPlayerView(); 
			}
		};
		
		
		return behaviour;
	}
}
