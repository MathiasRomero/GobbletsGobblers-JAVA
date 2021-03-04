package gobblets.ihm.javafx;

import gobblets.data.ActionType;

import gobblets.data.Joueur;
import gobblets.ihm.IHM;
import gobblets.logic.Jeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Victoire extends BorderPane{

	
	public Victoire(Joueur gagnant){
		
	setBackground(new Background(new BackgroundFill[] { new BackgroundFill(Color.WHITE, null, null) }));
	
	GridPane boutons = new GridPane();
	 VBox titre = new VBox();
	 
	 MenuBar menuBar = new MenuBar();

	   Menu Partie = new Menu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_PARTIE));
	    Menu editMenu = new Menu("?");

	    MenuItem Nouveau = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_NOUVEAU));
	    MenuItem Ouvrir = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_OUVRIR));
	    MenuItem Enregistrer = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_ENREGISTRER));
	    MenuItem Quitter = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_QUITTER));
	    MenuItem propos = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_APROPOS));
	    
	    menuBar.getMenus().addAll(Partie, editMenu);

	    Partie.getItems().addAll(Nouveau, Ouvrir, Enregistrer, Quitter);
	    editMenu.getItems().addAll(propos);

	    propos.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            Alert dialog = new Alert(AlertType.INFORMATION);
	            dialog.setTitle("A propos");
	            dialog.setHeaderText("Gobblet Gobblers");
	            dialog.setContentText( "MACHARD Baptiste \n ROMERO Mathias \n");
	            dialog.showAndWait();
	        }
	    });

	    Nouveau.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	           
	        	Main.stage.setScene(new Scene(new MainMenu()));
	        	
	        }
	    });
	    
	    Quitter.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            System.exit(0);
	        }
	    });
	 
	 Fonts Gobblets = new Fonts("Victoire de " + gagnant.getNom(),65);
	 Gobblets.setFill(Jeu.checkCouleur(gagnant.getCouleur()));
	 
	 
	 BoutonMenu quit = new BoutonMenu(IHM.getLanguage().action(ActionType.QUITTER),400,150);
	 
	 titre.getChildren().add(menuBar);
	 setCenter(Gobblets);
	 boutons.getChildren().add(quit);
	 
	 setBottom(boutons);
	 boutons.setAlignment(Pos.BOTTOM_CENTER);
	 GridPane.setMargin(quit, new Insets(0,0,200,0));

	 
	 setTop(titre);
	 titre.setAlignment(Pos.CENTER);
	 
//	 GridPane.setMargin(Gobblets, new Insets(200,0,0,0));
	 quit.setOnMouseClicked(evt -> Quit());
	 
	}
	
	public void Quit() {
		Main.stage.setScene(new Scene(new MainMenu()));
	}
}
