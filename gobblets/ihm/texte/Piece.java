package gobblets.ihm.texte;


import gobblets.data.Couleur;
import gobblets.data.Taille;
import gobblets.ihm.langues.Allemand;
import gobblets.ihm.langues.Anglais;
import gobblets.ihm.langues.Francais;

public class Piece {
	protected gobblets.data.Piece piece;

	public Piece(gobblets.data.Piece p) {
		piece=p;
	}

	public String[] getPresentationTextuelle(){
		
		String[] TextePiece = new String[3];
		
		TextePiece[0] = " ";
		TextePiece[1] = " ";
		TextePiece[2] = "\u001B[0m";
		
	
		if(piece.getCouleur() == Couleur.ROUGE) TextePiece[0] = "\u001B[31m";
		if(piece.getCouleur() == Couleur.BLEU) TextePiece[0] = "\u001B[34m";
		if(piece.getCouleur() == Couleur.JAUNE) TextePiece[0] = "\u001B[33m";
		if(piece.getCouleur() == Couleur.VERT) TextePiece[0] = "\u001B[32m";
		if(piece.getCouleur() == Couleur.WHITE) TextePiece[0] = "\u001B[37m";
		
		if(piece.getTaille() == Taille.PETITE) TextePiece[1] = "1";
		if(piece.getTaille() == Taille.MOYENNE) TextePiece[1] = "2";
		if(piece.getTaille() == Taille.GRANDE) TextePiece[1] = "3";
		
	return TextePiece;
	}
}
/*
		if(){													//TODO détecter la langue active
			Francais f=new Francais();
			pt[0]=f.Couleurs(piece.getCouleur().toString());
			pt[1]=f.Tailles(piece.getTaille().toString());
			pt[2]=piece.getJoueur().toString();
		}else if(){
			Anglais a=new Anglais();
			pt[0]=a.Couleurs(piece.getCouleur().toString());
			pt[1]=a.Tailles(piece.getTaille().toString());
			pt[2]=piece.getJoueur().toString();
		}else{
			Allemand al =new Allemand();
			pt[0]=al.Couleurs(piece.getCouleur().toString());
			pt[1]=al.Tailles(piece.getTaille().toString());
			pt[2]=piece.getJoueur().toString();
		}

		return pt;*/