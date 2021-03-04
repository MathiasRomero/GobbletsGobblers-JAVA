package gobblets.ihm.texte;

import java.util.Arrays;


public class Plateau {

	 protected gobblets.data.Plateau plateauJeu;
	
	public Plateau(gobblets.data.Plateau p) {
		
		plateauJeu = p;
	}
	
	public String[] getRepresentationTextuelle() {
			
		String[] textePlateau = new String[9];
		int tour = 0;
		

		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				Case tmp = new gobblets.ihm.texte.Case(plateauJeu.getPlateau()[i][j]);		
				
				textePlateau[tour] = Arrays.toString(tmp.getPresentationTextuelle()).replace(",", "")
					    .trim(); 
				
				tour++;
			}
		}
		return textePlateau;
	}
	
}
