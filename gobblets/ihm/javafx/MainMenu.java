package gobblets.ihm.javafx;


import gobblets.ihm.IHM;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class MainMenu extends BorderPane{

	
	public MainMenu() {
		
		
		 setBackground(new Background(new BackgroundFill[] { new BackgroundFill(Color.WHITE, null, null) }));

		
		 MenuBar menuBar = new MenuBar();

		   Menu Partie = new Menu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_PARTIE));
	        Menu editMenu = new Menu("?");

		    MenuItem Nouveau = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_NOUVEAU));
		    MenuItem Ouvrir = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_OUVRIR));
		    MenuItem Enregistrer = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_ENREGISTRER));
		    MenuItem Quitter = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_QUITTER));
		    MenuItem propos = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_APROPOS));
		    MenuItem aide = new MenuItem(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_AIDE));
	        
	        menuBar.getMenus().addAll(Partie, editMenu);

	        Partie.getItems().addAll(Nouveau, Ouvrir, Enregistrer, Quitter, aide);
	        editMenu.getItems().addAll(propos);

	        setTop(menuBar);

	        propos.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                Alert dialog = new Alert(AlertType.INFORMATION);
	                dialog.setTitle("A propos");
	                dialog.setHeaderText("Gobblet Gobblers");
		            dialog.setContentText(" MACHARD Baptiste \n ROMERO Mathias \n");
	                dialog.showAndWait();
	            }
	        });
	        
	        aide.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                Alert dialog = new Alert(AlertType.INFORMATION);
	                dialog.setTitle(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_AIDE));
	                dialog.setHeaderText("");
	                dialog.setContentText(IHM.getLanguage().Avertissement(gobblets.ihm.Avertissement.REGLE));
	                dialog.showAndWait();
	            }
	        });

	        Nouveau.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	               
	            	Main.stage.setScene(new Scene(new MenuJoueur(1)));
	            	
	            }
	        });
	        
	        Quitter.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.exit(0);
	            }
	        });
	        
	        
	        
		 
		 VBox titre = new VBox();
		 Fonts Gobblets = new Fonts("Gobblet Gobblers",140);
		 Gobblets.setFill(Color.ORANGE);
		 titre.getChildren().add(menuBar);
		 titre.getChildren().add(Gobblets);
		 VBox.setMargin(Gobblets, new Insets(30,0,0,0));
		
	   
	   GridPane boutons = new GridPane();
	   
	   

	   BoutonMenu BPOuvrir = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_OUVRIR), 250, 350);
	   BoutonMenu BPJouer = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_NOUVEAU), 250, 350);
	   BoutonMenu BPQuitter = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_QUITTER), 250, 350);
	    
	   
	   BoutonMenu BPLangue = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_LANGUE),180,30);
	    
	    boutons.add(BPJouer,0,0);
	    boutons.add(BPOuvrir,1,0);
	    boutons.add(BPQuitter,2,0);
	 
	    boutons.add(BPLangue,0,0);
	    
	    
	    setBottom(BPLangue); 
	    
	   boutons.setAlignment(Pos.BOTTOM_CENTER);
	   titre.setAlignment(Pos.TOP_CENTER);
	   BPLangue.setOnMouseClicked(evt -> ChangementLangue());
	   
	   GridPane.setMargin(BPJouer, new Insets(0,50,100,50));
	   GridPane.setMargin(BPQuitter, new Insets(0,50,100,50));
	   GridPane.setMargin(BPOuvrir, new Insets(0,50,100,50));
	   
	   
	 //  titre.setPadding(new Insets(30));
	   
	   setCenter(boutons);
	   setTop(titre);
	   
	   BPQuitter.setOnMouseClicked(evt -> System.exit(0));
	   

	   BPJouer.setOnMouseClicked(evt -> LancementPartie());
	
	   
	   
	}
	
	public void ChangementLangue() {
		
		//Lors d'une partie en cours, faire revenir, a la partie et non au menu
		
		Main.stage.setScene(new Scene(new MenuLangue(1)));
	}
	
	public void LancementPartie() {
		
		Main.stage.setScene(new Scene(new MenuJoueur(1)));
		Main.stage.setTitle("Gobblet Gobblers");
	}
	
	  
	
}
