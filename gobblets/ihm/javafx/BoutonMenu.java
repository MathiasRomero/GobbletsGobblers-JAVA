package gobblets.ihm.javafx;

import gobblets.Gobblets;
import javafx.scene.shape.Rectangle;
import gobblets.data.Couleur;
import gobblets.data.Piece;
import gobblets.data.Taille;
import javafx.scene.paint.Color;

public class BoutonMenu extends Bouton {

	
	private Fonts font;
	protected Piece p;
	
	public BoutonMenu(String string, int w, int h) {
	    super(w, h);
	    this.font = new Fonts(string, 40);
	    setMaxWidth(w);
	    setMaxHeight(h);
	    getChildren().add(this.font);
	  }
	
	
	public BoutonMenu(String string, int w, int h,Color c) {
	    super(w, h,c);
	    this.font = new Fonts(string, 40);
	    setMaxWidth(w);
	    setMaxHeight(h);

	    getChildren().add(this.font);
	  }
	
	
	public BoutonMenu(String string, int w, int h,Piece c) {
		super(w, h);
		
		Couleur couleur;
		p = c;
		
		couleur = c.getCouleur();
		
		if(couleur == Couleur.ROUGE) System.out.println();
		

	    this.font = new Fonts(string, 40);
	    setMaxWidth(w);
	    setMaxHeight(h);
	    
	    if(c.getTaille() == Taille.PETITE)  getChildren().add(new PieceFx(10.0D,couleur));
	    if(c.getTaille() == Taille.MOYENNE)  getChildren().add(new PieceFx(20.0D,couleur));
	    if(c.getTaille() == Taille.GRANDE)  getChildren().add(new PieceFx(30.0D,couleur));
	  
	    
	    
;	    getChildren().add(this.font);
	  }
	
	  
	  public Fonts getTitle() {
	    return this.font;
	  }
	  
	  public void setTitle(Fonts title) {
	    this.font = title;
	  }
	
}
