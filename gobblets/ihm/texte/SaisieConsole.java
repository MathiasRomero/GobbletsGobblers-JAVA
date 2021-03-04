package gobblets.ihm.texte;

import java.util.Scanner;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;

public class SaisieConsole extends IHM {

	static Scanner scanner;

	public SaisieConsole(){
	scanner = new Scanner(System.in);
	}

	@Override
	public Joueur saisirjoueur(int i) {

		String nom;
		char choix;
		Couleur couleur;
		System.out.println(getLanguage().Avertissement(Avertissement.NOMJOUEUR)+" ?");
		nom = scanner.nextLine();
		System.out.println(getLanguage().Avertissement(Avertissement.CHOIXCOULEUR)+" : R = "+getLanguage().couleur(Couleur.ROUGE)+" / B = "+getLanguage().couleur(Couleur.BLEU)+" / J = "+getLanguage().couleur(Couleur.JAUNE)+" / V = "+getLanguage().couleur(Couleur.VERT)+" / W = "+getLanguage().couleur(Couleur.WHITE));
		choix = scanner.next().charAt(0);

		switch(choix) {
			case 'R':
				couleur = Couleur.ROUGE;
				break;
			case 'J':
				couleur = Couleur.JAUNE;
				break;
			case 'B':
				couleur = Couleur.BLEU;
				break;
			case 'V':
				couleur = Couleur.VERT;
				break;
			default:
				couleur = Couleur.WHITE;
		}

		System.out.println(scanner.nextLine());
		Joueur joueur = new JoueurHumain(nom,couleur);
		return joueur;
	}
	public ActionType saisirAction(Joueur j) {
		int choix;
		
		do {
			choix = scanner.nextInt();
			}while(choix > 3 || choix < 1);
		if(choix == 1) return ActionType.PLACER;
		if(choix == 2) return ActionType.DEPLACER;
		if(choix == 3) return ActionType.QUITTER;

		return null;	
	}
	
	public Taille saisirTaille() {
		int taille;
		
		do {
			taille = scanner.nextInt();
		}while(taille > 3 || taille < 1);
		
		if(taille == 1) {return Taille.PETITE;}
		if(taille == 2) {return Taille.MOYENNE;}
		if(taille == 3) {
			return Taille.GRANDE;
		}

		return null;
	}


	public String saisirLangue(){
		int choix;
			do {
				choix = scanner.nextInt();
				scanner.nextLine();
			}while(choix > 3 || choix < 1);
			if(choix== 1) {return "Français";}
			if(choix == 2) {return "English";}
			if(choix == 3) {
				return "Deutsche";
			}
			return null;
		}
	
	public int[] saisirCoordonnees(ActionType action) {
		int[] tab=new int[4];
		int x1=0;
		int y1=0;
		
		int x2=0;
		int y2=0;

		int test=0;
		
		if(action == ActionType.PLACER) {	
		do {
			if(test!=0){
				System.out.println(getLanguage().erreur(Erreur.ARGUMENTCORRECT)+", x ∈ [0;2]");
			}
			x1 = scanner.nextInt();
			test++;
			}while(x1 > 2 || x1 < 0);
		test=0;
		do {
			if(test!=0){
				System.out.println(getLanguage().erreur(Erreur.ARGUMENTCORRECT)+", x ∈ [0;2]");
			}
			y1 = scanner.nextInt();
			test++;
			}while(y1 > 2 || y1 < 0);
		test=0;
		}
		tab[0]=x1;
		tab[1]=y1;
		if(action == ActionType.DEPLACER) {
			System.out.println(getLanguage().Avertissement(Avertissement.CHOIXORIGIN)+" :");
		do {
			if(test!=0){
				System.out.println(getLanguage().erreur(Erreur.ARGUMENTCORRECT)+", x ∈ [0;2]");
			}
			x1 = scanner.nextInt();
			test++;
			}while(x1 > 2 || x1 < 0);
			test=0;
		do {
			if(test!=0){
				System.out.println(getLanguage().erreur(Erreur.ARGUMENTCORRECT)+", x ∈ [0;2]");
			}
			y1 = scanner.nextInt();
			test++;
			}while(y1 > 2 || y1 < 0);
			test=0;
			System.out.println(getLanguage().Avertissement(Avertissement.CHOIXDESTINATION)+" :");
		do {
			if(test!=0){
				System.out.println(getLanguage().erreur(Erreur.ARGUMENTCORRECT)+", x ∈ [0;2]");
			}
			x2 = scanner.nextInt();
			test++;
			}while(x2 > 2 || x2 < 0);
			test=0;
			do {
				if(test!=0){
					System.out.println(getLanguage().erreur(Erreur.ARGUMENTCORRECT)+", x ∈ [0;2]");
				}
				y2 = scanner.nextInt();
				test++;
			}while(y2 > 2 || y2 < 0);
			tab[0]=x1;
			tab[1]=y1;
			tab[2]=x2;
			tab[3]=y2;
		}
		return tab;
		
	}
	
	public void display(gobblets.data.Plateau plateau, Joueur joueur) {
		
		Plateau p = new gobblets.ihm.texte.Plateau(plateau);
		
		System.out.println(getLanguage().Avertissement(Avertissement.TONTOUR)+" "+ joueur.getNom() + "\n");
		
		System.out.println( getLanguage().Avertissement(Avertissement.PIECERESTANTE)+" : " + joueur.getPiece());
		
		System.out.println("\u001B[0m");
		
		int tour = 0;
		for(int i=0;i<3;i++) {
			System.out.println("");
			for(int j=0;j<3;j++) {
				System.out.print(p.getRepresentationTextuelle()[tour]);
				tour++;
			}
		}
		
		System.out.println("\n");
	}
		
	public void finalize() {
		scanner.close();
	}

}