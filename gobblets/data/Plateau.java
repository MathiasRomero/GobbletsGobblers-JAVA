package gobblets.data;

import java.util.ArrayList;

import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Plateau {
	
	Case[][] plateau;
	
	 ArrayList<Piece> MaisonJoueur1;
	 ArrayList<Piece> MaisonJoueur2;
	 Couleur CM1;
	 Couleur CM2;
	 static Joueur J1;
	 static Joueur J2;
	
		
	public Plateau(Joueur j1, Joueur j2){
		plateau = new Case[3][3];
		J1 = j1;
		J2 = j2;
		
		for(int i = 0; i<3;i++) {
			for(int j=0; j<3; j++) {
				plateau[i][j] = new Case();
			}
		}
		
		MaisonJoueur1 = new ArrayList<Piece>();
		MaisonJoueur2 = new ArrayList<Piece>();

	}
	
	public static Plateau initPlateau(Joueur j1, Joueur j2){
		
		Plateau p = new Plateau(j1,j2);
		
		
		Piece petite1 = new Piece(Taille.PETITE);
		Piece petite2 = new Piece(Taille.PETITE);
		Piece petite3 = new Piece(Taille.PETITE);
		Piece petite4 = new Piece(Taille.PETITE);


		Piece moyen1 = new Piece(Taille.MOYENNE);
		Piece moyen2 = new Piece(Taille.MOYENNE);
		Piece moyen3 = new Piece(Taille.MOYENNE);
		Piece moyen4 = new Piece(Taille.MOYENNE);


		Piece grand1 = new Piece(Taille.GRANDE);
		Piece grand2 = new Piece(Taille.GRANDE);
		Piece grand3 = new Piece(Taille.GRANDE);
		Piece grand4 = new Piece(Taille.GRANDE);


			
		p.MaisonJoueur1.add(petite1);
		petite1.setCouleur(J1.getCouleur());		
		p.MaisonJoueur1.add(petite2);
		petite2.setCouleur(J1.getCouleur());
		p.MaisonJoueur2.add(petite3);
		petite3.setCouleur(J2.getCouleur());
		p.MaisonJoueur2.add(petite4);
		petite4.setCouleur(J2.getCouleur());
		p.MaisonJoueur1.add(moyen1);
		moyen1.setCouleur(J1.getCouleur());
		p.MaisonJoueur1.add(moyen2);
		moyen2.setCouleur(J1.getCouleur());
		p.MaisonJoueur2.add(moyen3);
		moyen3.setCouleur(J2.getCouleur());
		p.MaisonJoueur2.add(moyen4);
		moyen4.setCouleur(J2.getCouleur());
		p.MaisonJoueur1.add(grand1);
		grand1.setCouleur(J1.getCouleur());
		p.MaisonJoueur1.add(grand2);
		grand2.setCouleur(J1.getCouleur());
		p.MaisonJoueur2.add(grand3);
		grand3.setCouleur(J2.getCouleur());	
		p.MaisonJoueur2.add(grand4);
		grand4.setCouleur(J2.getCouleur());	
		p.CM1=p.MaisonJoueur1.get(1).getCouleur();
		p.CM2=p.MaisonJoueur2.get(1).getCouleur();
	
		return p;
	}

	public Case[][] getPlateau() {
		return plateau;
	}
	
	public ArrayList<Piece> getMaisonJoueur1() {
		return MaisonJoueur1;
	}

	public ArrayList<Piece> getMaisonJoueur2() {
		return MaisonJoueur2;
	}

	public boolean placePiece(ActionType a,Piece p,int u,int v, int x, int y) throws CaseBloqueeException, PiecePasDisponibleException {
		
		
		Joueur jou = null;
		if(a==ActionType.PLACER) {
			Placement pla = new Placement(p.getTaille(), plateau[x][y]);

			
			if (p.getCouleur() == J1.getCouleur()) {
				
				
				jou = new JoueurHumain("n", CM1);
				jou.Piece = MaisonJoueur1;
			} else if (p.getCouleur() == J2.getCouleur()) {
				
				jou = new JoueurHumain("n", CM2);
				jou.Piece = MaisonJoueur2;
			}
			if (jou != null) {

				
				if (pla.appliquer(jou)) {
					return true;
				} else {
					
					
					return false;
				}
			}
		}else if(a==ActionType.DEPLACER){
			Deplacement depl = new Deplacement(plateau[u][v],plateau[x][y]);

			if (p.getCouleur() == MaisonJoueur1.get(1).getCouleur()) {
				jou = new JoueurHumain("n", MaisonJoueur1.get(1).getCouleur());
				jou.Piece = MaisonJoueur1;
				
			} else if (p.getCouleur() == MaisonJoueur2.get(1).getCouleur()) {
				jou = new JoueurHumain("n", MaisonJoueur2.get(1).getCouleur());
				jou.Piece = MaisonJoueur2;
			}
			if (jou != null) {
				if (depl.appliquer(jou)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public Piece enlevePiece(int x, int y) throws PiecePasDisponibleException {	
		return plateau[x][y].enlevePiece();
	}
	
	
	public int getPieceTaille(ArrayList<Piece> liste, Piece p) {
				
		for(int i = 0; i < 5;i++) {
			if(liste.get(i).getTaille() == p.getTaille()) return i;
		}
		return 0;
			
	}
	
	
	public Piece plusGrandPiece(int x, int y) {	
		return plateau[x][y].plusGrandePiece();
	}
	
	public Couleur verifierLigne( int l) {
		Couleur tmp;
		if(l == 0) {
			if(plateau[0][0].plusGrandePiece()==null||plateau[0][1].plusGrandePiece()==null||plateau[0][2].plusGrandePiece()==null)return null;
			tmp = plateau[0][0].plusGrandePiece().getCouleur();
			if(plateau[0][1].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[0][2].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;
		}
		
		if(l == 1) {
			if(plateau[1][0].plusGrandePiece()==null||plateau[1][1].plusGrandePiece()==null||plateau[1][2].plusGrandePiece()==null)return null;
			tmp = plateau[1][0].plusGrandePiece().getCouleur();
			if(plateau[1][1].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[1][2].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;
		}
		
		if(l == 2) {
			if(plateau[2][0].plusGrandePiece()==null||plateau[2][1].plusGrandePiece()==null||plateau[2][2].plusGrandePiece()==null)return null;
			tmp = plateau[2][0].plusGrandePiece().getCouleur();
			if(plateau[2][1].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[2][2].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;
		}
		return null;
		}
	
	public Couleur verifierColonne( int c) {
		Couleur tmp;
		if(c == 0) {
			if(plateau[0][0].plusGrandePiece()==null||plateau[1][0].plusGrandePiece()==null||plateau[2][0].plusGrandePiece()==null)return null;
			tmp = plateau[0][0].plusGrandePiece().getCouleur();
			if(plateau[1][0].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[2][0].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;
		}
		
		if(c == 1) {
			if(plateau[0][1].plusGrandePiece()==null||plateau[1][1].plusGrandePiece()==null||plateau[2][1].plusGrandePiece()==null)return null;
			tmp = plateau[0][1].plusGrandePiece().getCouleur();
			if(plateau[1][1].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[2][1].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;
		}
		
		if(c == 2) {
			if(plateau[0][2].plusGrandePiece()==null||plateau[1][2].plusGrandePiece()==null||plateau[2][2].plusGrandePiece()==null)return null;
			tmp = plateau[0][2].plusGrandePiece().getCouleur();
			if(plateau[1][2].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[2][2].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;
		}
		return null;
		}
	
	public Couleur verifierDiagonal(char d) {
			Couleur tmp;
		if(d == 'p') {
			if(plateau[0][0].plusGrandePiece()==null||plateau[1][1].plusGrandePiece()==null||plateau[2][2].plusGrandePiece()==null)return null;
			tmp = plateau[0][0].plusGrandePiece().getCouleur();
			if(plateau[1][1].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[2][2].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;	
		}
		
		if(d == 's') {
			if(plateau[2][0].plusGrandePiece()==null||plateau[1][1].plusGrandePiece()==null||plateau[0][2].plusGrandePiece()==null)return null;
			tmp = plateau[2][0].plusGrandePiece().getCouleur();
			if(plateau[1][1].plusGrandePiece().getCouleur() != tmp) return null;
			if(plateau[0][2].plusGrandePiece().getCouleur() != tmp) return null;
			return tmp;	
		}
		return null;
		}
		
	}

