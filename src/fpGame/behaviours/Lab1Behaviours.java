package fpGame.behaviours;

//java imports
import java.util.List;

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
import fpGame.Inventory;
import fpModel.RoomObject;
import fpModel.GenericObject;
import fpModel.InfoObject;
import fpModel.Perspective;
import fpModel.Room;


public class Lab1Behaviours {
	public static EventHandler<MouseEvent> CPBehaviour(InfoObject cp) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				//if the cp is sleeping, check if can wake the cp up
				String cpState = cp.getInfo();
				if (cpState.equals("asleep")) {
					Inventory inv = GameUtil.player().getInventory();
					//wake if there is chocolate and coffee
					if (inv.checkNumberOfItem("Chocolate") > 0) {
						GameUtil.setMessage("You put the chocolate and the coffee in the CP's pocket");
						
						for (int j = 0; j < inv.size(); j += 1) {
							if (inv.getItem(j).name().equals("Chocolate") || inv.getItem(j).name().equals("Coffee")) {
								inv.removeItem(j);
								j -= 1;
							}
						}

						cp.setBackSpritePath("./graphics/game_graphics/rooms/lab1/back/layer0/CP_stand.png");
						cp.loadSprites();
						cpState = "awoken";
						GameUtil.displayPlayerView();
						GameUtil.setMessage("The CP has woken up!");
					} else {
						GameUtil.setMessage("The CP has fallen asleep after helping 60 students.\n"
									        + "They'll need some energy to wake up.");
					}
				} else {
					BorderPane pane = new BorderPane();
					Text text = new Text();
					text.setText(" What is this? Chocolate and coffee? Wow! Oh wait . . . \n "
							+ "Am I still in SAL? Did I fall asleep? Man, fixing all those bugs were hard. . . \n"
							+ "Oh hey there, thanks for the treats. What? We've been locked here? Oh god. . . \n"
							+ "I'm sure Professor Adamchik can come rescue, but I don't have his phone number with me. \n"
							+ "The phone number can be retrieved by solving the passcode using the objects in this room. Please help!");
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
				
				cp.setInfo(cpState);
				
			}
		};
			return behaviour;		
	}
	


	public static EventHandler<MouseEvent> CSCI103Behaviour(GenericObject book) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				BorderPane pane = new BorderPane();
				Text text = new Text();
				text.setText("This is my first year at USC and this is my first computer science course ever! \n"
						+ "Seems like all of my classmates have a lot of experience from CSCI 102 or from high school, \n"
						+ "so I'm a little worried. But it will be just fine! I will become the bestest programmer ever!");
				
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
	
	public static EventHandler<MouseEvent> CSCI104Behaviour(GenericObject book) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				BorderPane pane = new BorderPane();
				Text text = new Text();
				text.setText("This class sure is the weeder class for this major. \n"
						+ "It's so hard and there are so many data structures to learn: linked list, amortized array, and hash tables! \n"
						+ "I will sure be prepped for the technical interviews, I guess \n");
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
	
	public static EventHandler<MouseEvent> CSCI170Behaviour(GenericObject book) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				BorderPane pane = new BorderPane();
				Text text = new Text();
				text.setText("I suck at math and puzzles, so this class is super hard for me. \n"
						+ "I wonder why I have to learn all these algorithms and graphs. \n"
						+ " But it is kind of cool to learn how to count properly! 1, 2, 3, 4, 5! \n"
						+ "Time to start studying advanced counting! \n");
				text.setFill(Color.BLACK);
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
	
	public static EventHandler<MouseEvent> CSCI201Behaviour(GenericObject book) {
		EventHandler<MouseEvent> behaviour = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent event) {
				BorderPane pane = new BorderPane();
				Text text = new Text();
				text.setText("I started learning Java, which is super cool! \n"
						+ "It's not much different from C++, but there are cool features like the garbage collector. \n"
						+ "Java can be used for web development, and I'm so excited to do that stuff. \n"
						+ "Hopefully this class helps me become the best programmer ever!");
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
	
	
	
	
	public static void addBehaviours(List<RoomObject> objects) {
		for (RoomObject r : objects) {
			
		}
	}
}
