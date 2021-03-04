package gobblets.interaction;

import gobblets.data.ActionType;
import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.data.Piece;
import gobblets.data.Taille;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.javafx.DisplayJeu;
import gobblets.ihm.javafx.Main;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Placement extends Action{

	Taille taille;
	Case destination;
	
	public Placement(Taille t, Case ca) {
		this.taille = t;
		this.destination = ca;

	}
	
	public Taille getTaille(){
		return this.taille;
	}
	
	public Case getDestination() {
		return destination;
	}
	
	public boolean verifier(Joueur j) throws PiecePasDisponibleException, CaseBloqueeException {
	//	if(destination.plusGrandePiece() != null || destination.plusGrandePiece() == null) {
		//if(destination.plusGrandePiece() != null && destination.plusGrandePiece().getCouleur() != j.getCouleur() || destination.plusGrandePiece() == null) {
			for(int i = 0;i<j.getPiece().size(); i++) {
			
			
				if (j.getPiece().get(i).getTaille() == taille) {		
							
				
				
					if((destination.plusGrandePiece() == null && taille != null ) || taille.recouvre(destination.plusGrandePiece().getTaille()) ){

						return true;
					}
				}
	//		}
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(IHM.getLanguage().action(ActionType.PLACER));
        alert.setHeaderText(IHM.getLanguage().erreur(Erreur.ERREUR));
        alert.setContentText(IHM.getLanguage().erreur(Erreur.IMPLACE));
        alert.showAndWait();
		return false;
	}
	
	public boolean appliquer(Joueur j) throws CaseBloqueeException, PiecePasDisponibleException {
		if(verifier(j)) {
			

			
			Piece p = new Piece(taille);
			p.setCouleur(j.getCouleur());
			destination.PlacePiece(p);
			j.enlevePiece(taille);
			return true;
		}else{
			Main.stage.setScene(new Scene(new DisplayJeu()));
			return false;
		}

	}
	
	public String toString() {
		
		return "Dans la classe Placement du package gobblets.interaction";
	}
	
	
}
