package gobblets.ihm.javafx;
	
import gobblets.ihm.IHM;
import gobblets.logic.Jeu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	public static Stage stage;
	public static Scene scene;
	public static Scene lastScene;
	
	@Override
	public void start(Stage primaryStage) {

		
		IHM.setLanguage("English");
		
		//Creation d'un "stage" et on place les sc�nes dessus
		
		Main.stage = new Stage();
		
		stage.setWidth(1080); //Definition de la taille de la sc�ne
		stage.setHeight(720); //Definition de la taille de la sc�ne

		//Creation d'un objet
	//	VBox vBox = new VBox(new Label("A JavaFX Label"));

		
		// On cr�e une sc�ne avec notre objet
	//	Scene  = new Scene(vBox);
		

		MenuLangue L = new MenuLangue(0);
		
		
		scene = new Scene(L);
		
		//On modifie le stage pour qu'il se focus sur la sc�ne donn�
		
		
		stage.setScene(scene);
		
		stage.setTitle("Gobblets Gobblers");
		stage.setX(50);
		stage.setY(50);
		IHM.setLanguage(MenuLangue.getLangue());
		stage.show();
		stage.setResizable(false);
		
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
