package gobblets.ihm.javafx;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Fonts extends Text {
	  private String fontPath = "Momcake.otf";
	  
	  private int size;
	  
	  public Fonts(String title, int size) {
	    this.size = size;
	    setText(title);
	    setFill(Color.rgb(33, 33, 33));
	    setFont(Font.loadFont(getClass().getResourceAsStream(this.fontPath), size));
	  }
	  

	public String getFontPath() {
	    return this.fontPath;
	  }
	  
	  public void setFontPath(String fontPath) {
	    this.fontPath = fontPath;
	  }
	  
	  public int getSize() {
	    return this.size;
	  }
	  
	  public void setSize(int size) {
	    this.size = size;
	  }
	  
	  public void updateFont() {
	    setFont(Font.loadFont(this.fontPath, this.size));
	  }


	}

