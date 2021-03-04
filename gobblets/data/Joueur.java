package gobblets.data;

import gobblets.interaction.Action;
import gobblets.logic.PiecePasDisponibleException;

import java.util.ArrayList;

public abstract class Joueur {

	 String nom;
	 Couleur couleur;
	 public ArrayList<Piece> Piece;
	
	 Joueur(String n,Couleur c){
		 this.nom = n;
		 this.couleur = c;
	 }
	 
	 public String getNom() {
		 return this.nom;
	 }
	 
	public Couleur getCouleur() {
		 return this.couleur;
	 }
	
	public void setCouleur(Couleur c) {
		 this.couleur = c;
	 }
	
	public ArrayList<Piece> getPiece(){
		return Piece;
	}
	
	public void setPieces(ArrayList<Piece> pieces) {
		this.Piece = pieces;
	}

	public Piece enlevePiece(Taille taille) throws PiecePasDisponibleException{
	 	Piece p = null;
		for(int i = 0;i<Piece.size(); i++) {
			if (aPieceDeTaille(taille)) {
				p=Piece.get(i);
				return p;
			}
		}
		return p;
	}

	public void ajoutePiece(Piece p){
		Piece.add(p);
	}
	public boolean aPiece(Piece p){
		return p.getCouleur() == getCouleur();
	}

	public boolean aPieceDeTaille(Taille taille){
		boolean tamp = false;
		for(int i = 0;i<Piece.size(); i++){
			if(Piece.get(i).getTaille()== taille){
				tamp=true;
				break;
			}
		}
		return tamp;
	}
	public abstract Action choisirAction(Plateau plateau);

}
