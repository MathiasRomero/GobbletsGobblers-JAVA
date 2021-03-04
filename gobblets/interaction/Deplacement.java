package gobblets.interaction;

import gobblets.data.ActionType;
import gobblets.data.Case;
import gobblets.data.Joueur;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Deplacement extends Action {

	Case depart;
	Case destination;
	

	public Deplacement(Case c, Case d) {
		this.depart = c;
		this.destination = d;
	}
	
	public Case getOrigin() {
		return depart;
	}
	
	public Case getDestination() {
		return destination;
	}
	
	public boolean verifier(Joueur j) throws PiecePasDisponibleException, CaseBloqueeException {
		
	
		if(destination.plusGrandePiece()==null || depart.plusGrandePiece().getCouleur() == j.getCouleur()){
	//	if(destination.plusGrandePiece()==null || depart.plusGrandePiece().getCouleur() == j.getCouleur() && depart.plusGrandePiece().getCouleur() != destination.plusGrandePiece().getCouleur()){
			
			if((destination.plusGrandePiece() == null &&depart.plusGrandePiece().getTaille()!=null) || depart.plusGrandePiece().getTaille().recouvre(destination.plusGrandePiece())) {//depart.plusGrandePiece().getTaille().recouvre(destination.plusGrandePiece())||destination.plusGrandePiece().getTaille()==null){
				
				return true;
			}
		}
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(IHM.getLanguage().action(ActionType.DEPLACER));
        alert.setHeaderText(IHM.getLanguage().erreur(Erreur.ERREUR));
        alert.setContentText(IHM.getLanguage().erreur(Erreur.IMPDEPLACE));
        alert.showAndWait();
		return false;
	}
	
	
	public boolean appliquer(Joueur j) throws CaseBloqueeException, PiecePasDisponibleException{
		if(verifier(j)) {
			destination.PlacePiece(depart.enlevePiece());
			return true;
		}else{
			return false;
		}
	}
	
	public String toString() {
		
		return "Dans la classe Deplacement du package gobblets.interaction";
	}
	
}
