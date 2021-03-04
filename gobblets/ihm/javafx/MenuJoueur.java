package gobblets.ihm.javafx;

import gobblets.data.ActionType;

import gobblets.data.Couleur;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.Plateau;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jdk.nashorn.internal.runtime.regexp.joni.Warnings;
import gobblets.ihm.javafx.MenuLangue;
import gobblets.logic.Jeu;

public class MenuJoueur extends BorderPane{

	public String nom = "MenuJoueur";
	public int code = 0;
	public Couleur coul=Couleur.ROUGE;
	TextField zdt = new TextField();
	BoutonMenu BPRouge = new BoutonMenu("", 75, 75, Color.RED);
 	BoutonMenu BPBleu = new BoutonMenu("", 75, 75, Color.BLUE);
 	BoutonMenu BPVert = new BoutonMenu("", 75, 75, Color.GREEN);
 	BoutonMenu BPJaune = new BoutonMenu("", 75, 75, Color.YELLOW);
 	

	
	public MenuJoueur(int i) {
	code =i;
	BPRouge.setStyle("-fx-border-color : #FFC03B; -fx-border-width : 5px ");
		
	setBackground(new Background(new BackgroundFill[] { new BackgroundFill(Color.WHITE, null, null) }));
	
	VBox titre = new VBox();
	
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
           
        	Main.stage.setScene(new Scene(new MainMenu()));
        	
        }
    });
    
    Quitter.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    });
	
	Fonts Gobblets;
	if(code==1) {
		Gobblets = new Fonts(IHM.getLanguage().Avertissement(Avertissement.NOMJOUEUR)+" 1 & "+IHM.getLanguage().Avertissement(Avertissement.CHOIXCOULEUR) ,65);
	}else {
		Gobblets = new Fonts(IHM.getLanguage().Avertissement(Avertissement.NOMJOUEUR)+" 2 & "+IHM.getLanguage().Avertissement(Avertissement.CHOIXCOULEUR) ,65);
	}
	 Gobblets.setFill(Color.ORANGE);
	 titre.getChildren().add(menuBar);
	 titre.getChildren().add(Gobblets);
	 
	 titre.setAlignment(Pos.TOP_CENTER);
	 setTop(titre);
	 VBox.setMargin(Gobblets, new Insets(30,0,0,0));
	 
	 	GridPane boutons = new GridPane();
	 	GridPane Couleur = new GridPane();
	 	
	 	BoutonMenu BPLangue = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_LANGUE),180,30);
	 	
	 	BoutonMenu BPValider = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_VALIDER), 400, 75);
	 	
	 	BoutonMenu quit = new BoutonMenu(IHM.getLanguage().action(ActionType.QUITTER),180,30);

	 	Couleur.add(zdt,1,0,2,1);
	 	Couleur.add(BPRouge, 0, 1);
	 	Couleur.add(BPBleu, 1, 1);
	 	Couleur.add(BPVert, 2, 1);
	 	Couleur.add(BPJaune, 3, 1);
	 	zdt.setMaxWidth(220);
	 	if(code==1) {
	 		zdt.setText(IHM.getLanguage().Avertissement(Avertissement.NOMJOUEUR)+" 1");
	 	}else {
	 		zdt.setText(IHM.getLanguage().Avertissement(Avertissement.NOMJOUEUR)+" 2");
	 	}
	 	
	 	  
		  GridPane.setMargin(BPRouge, new Insets(100,50,0,0));
		  GridPane.setMargin(BPJaune, new Insets(100,0,0,0));
		  GridPane.setMargin(BPBleu, new Insets(100,50,0,0));
		  GridPane.setMargin(BPVert, new Insets(100,50,0,0));
	 	setCenter(Couleur);
	 	
	 	
	
	 	boutons.add(BPLangue,0,0);
	 	boutons.add(BPValider,1,0);
	 	boutons.add(quit, 2, 0);
	 	GridPane.setMargin(BPLangue, new Insets(0,150,0,0));
	 	GridPane.setMargin(BPValider, new Insets(0,150,0,0));
	    setBottom(boutons); 
	    

	    
	    Couleur.setAlignment(Pos.CENTER);
	    
	    boutons.setAlignment(Pos.BOTTOM_LEFT);
	    
	    titre.setAlignment(Pos.TOP_CENTER);
	    
	    
	    BPLangue.setOnMouseClicked(evt -> ChangementLangue());
	    BPValider.setOnMouseClicked(evt -> Valider());
	    BPRouge.setOnMouseClicked(evt-> appRG());
	    BPBleu.setOnMouseClicked(evt-> appBL());
	    BPJaune.setOnMouseClicked(evt-> appJN());
	    BPVert.setOnMouseClicked(evt-> appVR());
	    quit.setOnMouseClicked(evt -> Quit());
	}
	
	
	public void ChangementLangue() {
		
		//Lors d'une partie en cours, faire revenir, a la partie et non au menu
		if(code==1) {
			Main.stage.setScene(new Scene(new MenuLangue(2)));
		}else {
			Main.stage.setScene(new Scene(new MenuLangue(3)));
		}
	}
	
	public void Valider() {
		if(code==1) {
			Jeu.J1 = new JoueurHumain(zdt.getText(),coul);
			Main.stage.setScene(new Scene(new MenuJoueur(2)));
			
		}else if (code ==2) {
			Jeu.J2 = new JoueurHumain(zdt.getText(),coul);
			if(Jeu.J1.getCouleur()==Jeu.J2.getCouleur()){
				Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Action interdite");
		        alert.setContentText("Veuillez choisir une couleur differente pour chaque joueur");
		        alert.showAndWait();
				Main.stage.setScene(new Scene(new MenuJoueur(1)));   //TODO rajouter un pop-up/message pour prévenir du pb(j'ai fait un avertissement en plus pour ça)
			}else {
			Jeu.initialiser();
			Main.stage.setScene(new Scene(new DisplayJeu()));
			}
		}
	}
	
	public void appRG() {
		coul=Couleur.ROUGE;//TODO ajouter un petit effet pour montrer la couleur selectionné
		BPRouge.setStyle("-fx-border-color : #FFC03B; -fx-border-width : 5px ");
		BPBleu.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPVert.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPJaune.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
	}
	
	public void appVR() {
		coul=Couleur.VERT;
		BPRouge.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPBleu.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPVert.setStyle("-fx-border-color : #FFC03B; -fx-border-width : 5px ");
		BPJaune.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
	}
	
	public void appJN() {
		coul=Couleur.JAUNE;
		BPRouge.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPBleu.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPVert.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPJaune.setStyle("-fx-border-color : #FFC03B; -fx-border-width : 5px ");
	}
	
	public void appBL() {
		coul=Couleur.BLEU;
		BPRouge.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPBleu.setStyle("-fx-border-color : #FFC03B; -fx-border-width : 5px ");
		BPVert.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
		BPJaune.setStyle("-fx-border-color : #FFFFFF; -fx-border-width : 0px ");
	}

	public void Quit() {
		Main.stage.setScene(new Scene(new MainMenu()));
	}
	
}
