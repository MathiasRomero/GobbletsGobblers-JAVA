package gobblets.logic;

import gobblets.data.*;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.javafx.Main;
import gobblets.ihm.texte.SaisieConsole;
import javafx.scene.paint.Color;

import static gobblets.ihm.IHM.getLanguage;
import static gobblets.ihm.IHM.setLanguage;

public class Jeu{
	
	public static Joueur J1;
	public static Joueur J2;
	public static gobblets.data.Plateau plateau;
	public static Etat etat;
	public static Joueur JoueurActif;
	
	public Jeu() throws CaseBloqueeException, PiecePasDisponibleException {
		
	
		String[] arg = new String[0];
		Main m = new Main();
		m.main(arg);
	}
	
	
	
	public Etat play() {
		
		return Etat.JEUENCOURS;
	}
	
	public Etat getEtat() {
		return etat;
		
	}
	
	static public void initialiser() {
		
		Jeu.plateau = Plateau.initPlateau(Jeu.J1, Jeu.J2);
		
		
		J1.setPieces(plateau.getMaisonJoueur1());
		J2.setPieces(plateau.getMaisonJoueur2());
		JoueurActif=J1;
		etat=Etat.JEUENCOURS;
		
	}
	
	static public void setEtat() {
		int j1=0;
		int j2=0;
		for(int i=0;i<3;i++){
			if(plateau.verifierLigne(i)==J1.getCouleur()){
				j1++;
			}else if(plateau.verifierLigne(i)==J2.getCouleur()){
				j2++;
			}
		}

		for(int i=0;i<3;i++){
			if(plateau.verifierColonne(i)==J1.getCouleur()){
				j1++;
			}else if(plateau.verifierColonne(i)==J2.getCouleur()){
				j2++;
			}
		}

		if(plateau.verifierDiagonal('p')==J1.getCouleur()){
			j1++;
		}else if(plateau.verifierDiagonal('p')==J2.getCouleur()){
			j2++;
		}

		if(plateau.verifierDiagonal('s')==J1.getCouleur()){
			j1++;
		}else if(plateau.verifierDiagonal('s')==J2.getCouleur()){
			j2++;
		}

		if(j1>j2){
			etat=Etat.JOUEUR1GAGNE;
		}else if(j1<j2){
			etat=Etat.JOUEUR2GAGNE;
		}else{
			etat=Etat.JEUENCOURS;
		}
	}
		
		public gobblets.data.Plateau getPlateau() {
			return plateau;
		
		}
		
		public static Joueur getJ1() {	
			return J1;
		}
		
		public Joueur getj2() {
			return J2;
		}
		
		public Joueur getJoueurActif() {
			
			return JoueurActif;
		}
		
		public static Joueur changeJoueur() {
			
			if(JoueurActif == J1) {
				JoueurActif = J2;
				return JoueurActif;
			}
			else {
				JoueurActif = J1;
				return JoueurActif;
			}	
		}
		
		 public static Color checkCouleur(Couleur c) {
			 
			 if(c == Couleur.ROUGE) return Color.RED;
			 if(c == Couleur.BLEU) return Color.BLUE;
			 if(c == Couleur.JAUNE) return Color.YELLOW;
			 if(c == Couleur.VERT) return Color.GREEN;
			 
			 return Color.BLACK;
		 }
}
