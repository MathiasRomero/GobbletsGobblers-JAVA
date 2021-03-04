package gobblets.data;

public class Piece {
	
	private Taille taille;
	private Couleur couleur;
	
	public Piece(Taille t){
			
		this.taille = t;
	}
	
	 public Taille getTaille() {
		return taille;
	}
	 
	public  Couleur getCouleur() {
		 return couleur;
	 }

	public void setCouleur(Couleur c) {
		 couleur = c;
	 }

	public boolean AppartientA(Joueur j){
		return j.getCouleur()== getCouleur();
	}

	@Override
	public String toString() {
		gobblets.ihm.texte.Piece c = new gobblets.ihm.texte.Piece(this);
		String[] tamp = c.getPresentationTextuelle();
		return "     "+tamp[0]+"\n     "+tamp[1];
	}
}
