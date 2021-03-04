package gobblets.ihm.javafx;

import gobblets.data.ActionType;
import gobblets.data.Etat;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;

import gobblets.logic.CaseBloqueeException;
import gobblets.logic.Jeu;
import gobblets.logic.PiecePasDisponibleException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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

public class DisplayJeu extends BorderPane{

	protected BoutonMenu[][] tabPlat= new BoutonMenu[3][3];
	protected BoutonMenu[][] tabM1 = new BoutonMenu[3][2];
	protected BoutonMenu[][] tabM2 = new BoutonMenu[3][2];
	protected BoutonMenu selection1 = null;
	protected BoutonMenu selection2 = null;
	private Label Joueur;
	
	public DisplayJeu() {
		
	setBackground(new Background(new BackgroundFill[] { new BackgroundFill(Color.WHITE, null, null) }));
	
	
	 VBox titre = new VBox();
	 
	 MenuBar menuBar = new MenuBar();
	 Joueur = new Label(IHM.getLanguage().Avertissement(Avertissement.JOUEUR)+" : " + Jeu.JoueurActif.getNom());

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
	 
	 
	 Fonts Gobblets = new Fonts(IHM.getLanguage().Avertissement(Avertissement.TONTOUR)+" : "+Jeu.JoueurActif.getNom(),70);
	 Gobblets.setFill(Jeu.checkCouleur((Jeu.JoueurActif.getCouleur())));
	 titre.getChildren().add(menuBar);

	 titre.getChildren().add(Gobblets);
	 
	 VBox.setMargin(Gobblets, new Insets(30,0,0,0));

	 BoutonMenu BPLangue = new BoutonMenu(IHM.getLanguage().Menu(gobblets.ihm.Menu.MENU_LANGUE),180,30);
	 BoutonMenu BPCancel = new BoutonMenu(IHM.getLanguage().action(gobblets.data.ActionType.ANNULER),300,70);
	
	
	 		GridPane boutons = new GridPane();
	        GridPane plateauJeu = new GridPane();
	        GridPane Maison1 = new GridPane();
	        GridPane Maison2 = new GridPane();
	        
	        int i = 0; //Variable pour recup l'index des pièces des maisons
	        
	        for (int row = 0; row < 3; row++) {
	            for (int column = 0 ; column < 2; column++) {
	            	BoutonMenu maisonj1;
	            	try {
	            	maisonj1 = new BoutonMenu("", 110, 110,Jeu.J1.getPiece().get(i));
	            	}catch(Exception e) {
	            		maisonj1 = new BoutonMenu("", 110, 110);
	            		maisonj1.Lock();
	            	}
	            	
	            	
	            	tabM1[row][column]=maisonj1;
	            	 GridPane.setConstraints(maisonj1, column, row);
	            	 Maison1.getChildren().add(maisonj1);
	            	 if(Jeu.JoueurActif == Jeu.J2) maisonj1.Lock();
	            	 
	            	 if(row == 0) GridPane.setMargin(maisonj1, new Insets(70,0,0,0));
	            	 if(column == 0)  GridPane.setMargin(maisonj1, new Insets(0,0,0,25));
	            	 if(row == 0 && column == 0) GridPane.setMargin(maisonj1, new Insets(70,0,0,25));
	            	 i++;
	            	}
	            }
	        
	        i = 0;
	        
	        for (int row = 0; row < 3; row++) {
	            for (int column = 0 ; column < 2; column++) {
	            	
	            	BoutonMenu maisonj2;
	            	try {
	            		maisonj2= new BoutonMenu("", 110, 110,Jeu.J2.getPiece().get(i));
	            	}catch(Exception e) {
	            		maisonj2= new BoutonMenu("", 110, 110);
	            		maisonj2.Lock();
	            	}
	            	
	            	 GridPane.setConstraints(maisonj2, column, row);
	            	 Maison2.getChildren().add(maisonj2);
	            	 if(Jeu.JoueurActif == Jeu.J1) maisonj2.Lock();
	            	 tabM2[row][column]=maisonj2;
	            	 if(column == 1) GridPane.setMargin(maisonj2, new Insets(0,25,0,0));
	            	 if(row == 0)  GridPane.setMargin(maisonj2, new Insets(70,0,0,0));
	            	 if(row == 0 && column == 2) GridPane.setMargin(maisonj2, new Insets(70,25,0,0));
	            	 i++;
	            	}
	            }
	        
	        
	        for (int column = 0; column < 3; column++) {
	            for (int row = 0 ; row < 3; row++) {
	            	
	            	
	            	if(Jeu.plateau.getPlateau()[column][row].plusGrandePiece() != null) {
	            		
	            	
	            	
	            		BoutonMenu cases = new BoutonMenu("", 150, 150, Jeu.plateau.getPlateau()[column][row].plusGrandePiece()); 
		               GridPane.setConstraints(cases, column, row);
		                plateauJeu.getChildren().add(cases);
		                tabPlat[column][row]=cases;
		                
		                if(Jeu.plateau.getPlateau()[column][row].plusGrandePiece().getCouleur() != Jeu.JoueurActif.getCouleur()) {
		                	cases.Lock();
		                }
		                
	            	}else {
	            		BoutonMenu cases = new BoutonMenu("", 150, 150);
		                GridPane.setConstraints(cases, column, row);
		                plateauJeu.getChildren().add(cases);
		                tabPlat[column][row]=cases;
		                
		                if(selection1 == null) {
		                	cases.Lock();
		                }
		                
	            	}
	                

	    	        GridPane.setConstraints(plateauJeu, column, row);
	            }
	        }

	       

	        setCenter(plateauJeu);
	        plateauJeu.setAlignment(Pos.CENTER);
	        titre.setAlignment(Pos.CENTER);
	        setTop(titre);
	        setLeft(Maison1);
	        setRight(Maison2);
	        
	        Maison1.setAlignment(Pos.CENTER_LEFT);
	        Maison2.setAlignment(Pos.CENTER_RIGHT);
	       
	        boutons.add(Joueur, 0, 0);
		 	boutons.add(BPLangue,0,0);
		 	boutons.add(BPCancel,0,0);
		 	
		    setBottom(boutons);  
		    boutons.setAlignment(Pos.BOTTOM_CENTER);
		    
		    Joueur.setAlignment(Pos.BOTTOM_CENTER);
		    GridPane.setMargin(Joueur, new Insets(80,0,0,440));
		    GridPane.setMargin(BPLangue, new Insets(40,890,20,0));
		    GridPane.setMargin(BPCancel, new Insets(0,0,20,380));

		    
		    BPLangue.setOnMouseClicked(evt -> ChangementLangue());
		    BPCancel.setOnMouseClicked(evt -> Cancel());
		    tabM1[0][0].setOnMouseClicked(evt -> {
				try {
					Selection(tabM1[0][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException  e20) {
					// TODO Auto-generated catch block
				//	e20.printStackTrace();
				}
			});
		    tabM1[0][1].setOnMouseClicked(evt -> {
				try {
					Selection(tabM1[0][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e19) {
					// TODO Auto-generated catch block
				//	e19.printStackTrace();
				}
			});
		    tabM1[1][0].setOnMouseClicked(evt -> {
				try {
					Selection(tabM1[1][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e18) {
					// TODO Auto-generated catch block
				//	e18.printStackTrace();
				}
			});
		    tabM1[1][1].setOnMouseClicked(evt -> {
				try {
					Selection(tabM1[1][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e17) {
					// TODO Auto-generated catch block
				//	e17.printStackTrace();
				}
			});
		    tabM1[2][0].setOnMouseClicked(evt -> {
				try {
					Selection(tabM1[2][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e16) {
					// TODO Auto-generated catch block
				//	e16.printStackTrace();
				}
			});
		    tabM1[2][1].setOnMouseClicked(evt -> {
				try {
					Selection(tabM1[2][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException  | NullPointerException e15) {
					// TODO Auto-generated catch block
				//	e15.printStackTrace();
				}
			});
		    tabM2[0][0].setOnMouseClicked(evt -> {
				try {
					Selection(tabM2[0][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException  | NullPointerException e14) {
					// TODO Auto-generated catch block
				//	e14.printStackTrace();
				}
			});
		    tabM2[0][1].setOnMouseClicked(evt -> {
				try {
					Selection(tabM2[0][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e13) {
					// TODO Auto-generated catch block
				//	e13.printStackTrace();
				}
			});
		    tabM2[1][0].setOnMouseClicked(evt -> {
				try {
					Selection(tabM2[1][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e12) {
					// TODO Auto-generated catch block
				//	e12.printStackTrace();
				}
			});
		    tabM2[1][1].setOnMouseClicked(evt -> {
				try {
					Selection(tabM2[1][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e11) {
					// TODO Auto-generated catch block
				//	e11.printStackTrace();
				}
			});
		    tabM2[2][0].setOnMouseClicked(evt -> {
				try {
					
					Selection(tabM2[2][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e10) {
					// TODO Auto-generated catch block
				//	e10.printStackTrace();
				}
			});
		    tabM2[2][1].setOnMouseClicked(evt -> {
				try {
					Selection(tabM2[2][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException | NullPointerException e9) {
					// TODO Auto-generated catch block
				//	e9.printStackTrace();
				}
			});
		    tabPlat[0][0].setOnMouseClicked(evt -> {
		    	
		    	
		    	if(!tabPlat[0][0].isLock()) {
				try {
					Selection(tabPlat[0][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e8) {
					// TODO Auto-generated catch block
					e8.printStackTrace();
				}
		    	}
			});
		    tabPlat[0][1].setOnMouseClicked(evt -> {
		    	if(!tabPlat[0][1].isLock()) {
				try {
					Selection(tabPlat[0][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e7) {
					// TODO Auto-generated catch block
					e7.printStackTrace();
				}
		    	}
			});
		    tabPlat[0][2].setOnMouseClicked(evt -> {
		    	if(!tabPlat[0][2].isLock()) {
				try {
					Selection(tabPlat[0][2]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}
		    	}
			});
		    tabPlat[1][0].setOnMouseClicked(evt -> {
		    	if(!tabPlat[1][0].isLock()) {
				try {
					Selection(tabPlat[1][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
		    	}
			});
		    tabPlat[1][1].setOnMouseClicked(evt -> {
		    	if(!tabPlat[1][1].isLock()) {
				try {
					Selection(tabPlat[1][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
		    	}
			});
		    tabPlat[1][2].setOnMouseClicked(evt -> {
		    	if(!tabPlat[1][2].isLock()) {
				try {
					Selection(tabPlat[1][2]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		    	}
			});
		    tabPlat[2][0].setOnMouseClicked(evt -> {
		    	if(!tabPlat[2][0].isLock()) {
				try {
					Selection(tabPlat[2][0]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		    	}
			});
		    tabPlat[2][1].setOnMouseClicked(evt -> {
		    	if(!tabPlat[2][1].isLock()) {
				try {
					Selection(tabPlat[2][1]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	}
			});
		    tabPlat[2][2].setOnMouseClicked(evt -> {
		    	if(!tabPlat[2][2].isLock()) {
				try {
					Selection(tabPlat[2][2]);
				} catch (CaseBloqueeException | PiecePasDisponibleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	}
			});
	}
	
	public void ChangementLangue() {
		Main.stage.setScene(new Scene(new MenuLangue(4)));
		
	}
	public void Quit() {
		Main.stage.setScene(new Scene(new MainMenu()));
	}
	
	public void Selection(BoutonMenu b) throws CaseBloqueeException, PiecePasDisponibleException {
		if(selection1==null&& b.p.getCouleur()==Jeu.JoueurActif.getCouleur()) {
			selection1=b;
	        for (int column = 0; column < 3; column++) {
	            for (int row = 0 ; row < 3; row++) {
	            	
	            	tabPlat[column][row].unLock();
	            	}
	            }
	        
			b.getCarre().setStroke(Color.GREEN);
		}else if(selection2==null && isInPlat(selection1)) {
			selection2=b;
			b.getCarre().setStroke(Color.RED);
			deplace();
		}else if(selection2==null && isInPlat(b) && !isInPlat(selection1)) {
			selection2=b;
			b.getCarre().setStroke(Color.RED);
			place();
		}else if(selection2==null && selection1.p.getCouleur()==Jeu.JoueurActif.getCouleur() && b.p!= null) {
			selection1=b;
			b.getCarre().setStroke(Color.GREEN);
		}
		
		
		
		Jeu.setEtat();
		if(Jeu.etat==Etat.JOUEUR1GAGNE){
			Main.stage.setScene(new Scene(new Victoire(Jeu.J1)));
		}
		
		if(Jeu.etat==Etat.JOUEUR2GAGNE){
			Main.stage.setScene(new Scene(new Victoire(Jeu.J2)));
		}

	}
	
	public void Cancel() {
		
		
        Main.stage.setScene(new Scene(new DisplayJeu()));
	}
	
	public void place() throws CaseBloqueeException, PiecePasDisponibleException {
		
		
		if(Jeu.plateau.placePiece(ActionType.PLACER, selection1.p , 0, 0, getSelectionX(selection2), getSelectionY(selection2))) {
			if(Jeu.JoueurActif == Jeu.J1) {
				Jeu.plateau.getMaisonJoueur1().remove(Jeu.plateau.getPieceTaille(Jeu.plateau.getMaisonJoueur1(), selection1.p));
			}else if(Jeu.JoueurActif == Jeu.J2) {
				Jeu.plateau.getMaisonJoueur2().remove(Jeu.plateau.getPieceTaille(Jeu.plateau.getMaisonJoueur2(), selection1.p));
			}
			Jeu.changeJoueur();
		}
		
		Main.stage.setScene(new Scene(new DisplayJeu()));
	}
	
	public void deplace() throws CaseBloqueeException, PiecePasDisponibleException {
		if(Jeu.plateau.placePiece(ActionType.DEPLACER, selection1.p ,getSelectionX(selection1), getSelectionY(selection1), getSelectionX(selection2), getSelectionY(selection2))) {
			Jeu.changeJoueur();
		}
		Main.stage.setScene(new Scene(new DisplayJeu()));
	}
	
	
	public int getSelectionX(BoutonMenu b) {
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if(tabPlat[i][j]==b) {
					return i;
				}
			}
		}
		return 0;
	}
	public int getSelectionY(BoutonMenu b) {
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if(tabPlat[i][j]==b) {
					return j;
				}
			}
		}
		return 0;
	}
	
	
	public boolean isInM1(BoutonMenu b) {
		for(int i=0;i<2;i++) {
			for (int j=0;j<1;j++) {
				if(tabM1[i][j]==b) {
					return true;
				}
			}
		}
		return false;	
	}
	
	public boolean isInM2(BoutonMenu b) {
		for(int i=0;i<2;i++) {
			for (int j=0;j<1;j++) {
				if(tabM2[i][j]==b) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isInPlat(BoutonMenu b) {
		for(int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				if(tabPlat[i][j]==b) {
					return true;
				}
			}
		}
		return false;
	}
	
}
