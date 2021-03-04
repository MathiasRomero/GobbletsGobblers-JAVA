package gobblets.ihm.texte;

import java.util.Arrays;

public class Case {
    protected gobblets.data.Case c;

    public Case(gobblets.data.Case p) {
        c=p;
    }

   public String[] getPresentationTextuelle(){


	   String[] TexteCase = new String[3];
	   

	   Piece p = new gobblets.ihm.texte.Piece(c.plusGrandePiece());
	   

	   
	//   TexteCase[0] = "[";
	   TexteCase[0] = "";
	   if(c.plusGrandePiece() == null) {
		   TexteCase[1] = " ";
	   }else {

	   TexteCase[1] = String.join("", p.getPresentationTextuelle());

	   }
	//   TexteCase[2] = "]";
	   TexteCase[2] = "";
	   
	   

	   
	  return TexteCase;
	   
   }
}
