package gobblets.ihm.javafx;

import gobblets.data.Couleur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PieceFx extends StackPane {

	 private Circle piece;
	 
	 
	 public PieceFx(double rayon, Couleur c) {
		 
		 
		 this.piece = new Circle(rayon);
		 
		    this.piece.setStroke(Color.BLACK);
		    this.piece.setFill(checkCouleur(c));
		    this.piece.setStrokeWidth(6.0D);
		    getChildren().add(this.piece);
	 }
	 
	 public Color checkCouleur(Couleur c) {
		 
		 if(c == Couleur.ROUGE) return Color.RED;
		 if(c == Couleur.BLEU) return Color.BLUE;
		 if(c == Couleur.JAUNE) return Color.YELLOW;
		 if(c == Couleur.VERT) return Color.GREEN;
		 
		 return Color.BLACK;
	 }
}
