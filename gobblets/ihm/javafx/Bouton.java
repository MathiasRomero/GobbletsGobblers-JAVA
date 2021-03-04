package gobblets.ihm.javafx;

import gobblets.Gobblets;



import gobblets.data.Piece;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

	public class Bouton extends StackPane {
		
		  private Rectangle hoverRec;
		  
		  private Rectangle bouton;
		  
		  private Color HighlightColor = Color.ORANGE;
		  
		  private boolean lock = false;
		  
		  public Bouton(int w, int h) {
		    this.bouton = new Rectangle();
		    this.bouton.setWidth(w);
		    this.bouton.setHeight(h);
		    this.bouton.setStroke(Color.BLACK);
		    this.bouton.setFill(Color.TRANSPARENT);
		    this.bouton.setStrokeWidth(6.0D);
		    this.hoverRec = new Rectangle();
		    this.hoverRec.setWidth((w - 20));
		    this.hoverRec.setHeight((h - 20));
		    this.hoverRec.setStrokeWidth(5.0D);
		    this.hoverRec.setFill(Color.TRANSPARENT);
		    this.hoverRec.setStroke(Color.TRANSPARENT);
		   
		    
		    
		    setMaxWidth(w);
		    getChildren().add(this.hoverRec);
		    getChildren().add(this.bouton);
		    setAlignment(Pos.CENTER);
		    setOnMouseEntered(evt -> setOnMouseEntered(evt));
		    setOnMouseExited(evt -> setOnMouseExited(evt));
		    setCursor(Cursor.HAND);
		  }
		  
		  public Bouton(int w, int h,Color c) {
			    this.bouton = new Rectangle();
			    this.bouton.setWidth(w);
			    this.bouton.setHeight(h);
			    this.bouton.setStroke(Color.BLACK);
			    this.bouton.setFill(c);
			    this.bouton.setStrokeWidth(6.0D);
			    this.hoverRec = new Rectangle();
			    this.hoverRec.setWidth((w - 20));
			    this.hoverRec.setHeight((h - 20));
			    this.hoverRec.setStrokeWidth(5.0D);
			    this.hoverRec.setFill(Color.TRANSPARENT);
			    this.hoverRec.setStroke(Color.TRANSPARENT);
			   
			    
			    
			    setMaxWidth(w);
			    getChildren().add(this.hoverRec);
			    getChildren().add(this.bouton);
			    setAlignment(Pos.CENTER);
			    setOnMouseEntered(evt -> setOnMouseEntered(evt));
			    setOnMouseExited(evt -> setOnMouseExited(evt));
			    setCursor(Cursor.HAND);
			  }
		  
		  
		  public Bouton(int w, int h,Color c,Piece p) {
			    this.bouton = new Rectangle();
			    
			    this.bouton.setWidth(w);
			    this.bouton.setHeight(h);
			    this.bouton.setStroke(Color.BLACK);
			    this.bouton.setFill(c);
			    this.bouton.setStrokeWidth(6.0D);
			    this.hoverRec = new Rectangle();
			    this.hoverRec.setWidth((w - 20));
			    this.hoverRec.setHeight((h - 20));
			    this.hoverRec.setStrokeWidth(5.0D);
			    this.hoverRec.setFill(Color.TRANSPARENT);
			    this.hoverRec.setStroke(Color.TRANSPARENT);
			   
			    
			    
			    setMaxWidth(w);
			    getChildren().add(this.hoverRec);
			    getChildren().add(this.bouton);
			    setAlignment(Pos.CENTER);
			    setOnMouseEntered(evt -> setOnMouseEntered(evt));
			   // setOnMouseExited(evt -> setOnMouseExited(evt));
			    setCursor(Cursor.HAND);
			  }
		  
		  public void setOnMouseEntered(MouseEvent evt) {
		    if (!this.lock)
		      this.hoverRec.setStroke(this.HighlightColor); 
		 //   playSound();
		  }
		  
		  public void setOnMouseExited(MouseEvent evt) {
		    this.hoverRec.setStroke(Color.TRANSPARENT);
		  }
		  
		  public void playSound() {
			  
			  AudioClip note = new AudioClip(this.getClass().getResource("button.mp3").toString());
			  
			  note.play();
		  }
		  
		  public Color getHighlightColor() {
		    return this.HighlightColor;
		  }
		  
		  public void setHighlightColor(Color highlightColor) {
		    this.HighlightColor = highlightColor;
		  }
		  
		  public boolean isLock() {
		    return this.lock;
		  }
		  
		  public void Lock() {
		    setCursor(Cursor.DEFAULT);
		    this.lock = true;
		  }
		  
		  public void unLock() {
		    setCursor(Cursor.HAND);
		    this.lock = false;
		  }
	
		  public Rectangle getCarre() {
			  return hoverRec;
		  }
}
