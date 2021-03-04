package gobblets.ihm.javafx;

import gobblets.ihm.Dictionnaire;
import gobblets.ihm.IHM;
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
import javafx.scene.paint.Color;

public class MenuLangue extends BorderPane{

	
	public String nom = "MenuLangue";
	public static String langue;
	
	public MenuLangue(int i) {
		
	MenuLangue.langue = IHM.getLanguage().toString();
	
	setBackground(new Background(new BackgroundFill[] { new BackgroundFill(Color.WHITE, null, null) }));
	
	GridPane boutons = new GridPane();
	
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

    propos.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("A propos");
            dialog.setHeaderText("Gobblet Gobblers");
            dialog.setContentText(" MACHARD Baptiste \n ROMERO Mathias \n");;
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
           
        	Main.stage.setScene(new Scene(new MainMenu()));
        	
        }
    });
    
    Quitter.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    });
    
    setTop(menuBar);
	
	
	BoutonMenu BPFrance = new BoutonMenu("Francais", 250, 350);
	BoutonMenu BPEnglish = new BoutonMenu("English", 250, 350);
	BoutonMenu BPDeutsche = new BoutonMenu("Deutsche", 250, 350);
	
    boutons.add(BPFrance,0,0);
    boutons.add(BPEnglish,1,0);
    boutons.add(BPDeutsche,2,0);
    
       GridPane.setMargin(BPFrance, new Insets(0,50,100,50));
	   GridPane.setMargin(BPEnglish, new Insets(0,50,100,50));
	   GridPane.setMargin(BPDeutsche, new Insets(0,50,100,50));
    
    boutons.setAlignment(Pos.CENTER);
    
    setCenter(boutons);
    
    BPFrance.setOnMouseClicked(evt -> choixLangue("Français",i));
    BPEnglish.setOnMouseClicked(evt -> choixLangue("English",i));
    BPDeutsche.setOnMouseClicked(evt -> choixLangue("Deutsche",i));
    
	}
	
	public void choixLangue(String Langue, int i) {
		
		IHM.setLanguage(Langue);
		
		if(Main.lastScene == null)
			Main.stage.setScene(new Scene(new MainMenu()));
		else {
			Main.scene = Main.lastScene;
			
			Main.stage.setScene(Main.scene);

			
		}
		
		IHM.setLanguage(Langue);

		if(i==1) {
			Main.stage.setScene(new Scene(new MainMenu()));
		}else if(i==2) {
			Main.stage.setScene(new Scene(new MenuJoueur(1)));
		}else if(i==3) {
			Main.stage.setScene(new Scene(new MenuJoueur(2)));
		}else if(i==4) {
			Main.stage.setScene(new Scene(new DisplayJeu()));
		}
}
	public static String getLangue() {
		return langue;
	}
	
}