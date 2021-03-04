 package gobblets.data;

public class Case {

    protected Piece petite;
    protected Piece moyenne;
    protected Piece grande;
    
   

    public Case() {
        this.petite=null;
        this.moyenne=null;
        this.grande=null;
    }
    
    public Piece getGrande() {
        return grande;
    }

    public Piece getMoyenne() {
        return moyenne;
    }

    public Piece getPetite() {
        return petite;
    }
    
    public boolean acceptePiece(Taille t){
    	
    	if(this.plusGrandePiece() != null) {
        Piece tamp = this.plusGrandePiece();
        return !tamp.getTaille().recouvre(t);
    	}else {
   		return true;
    	}
    }
    public Piece enlevePiece(){
    Piece tamp = this.plusGrandePiece();
    	if(this.plusGrandePiece() == petite) petite = null;
    	if(this.plusGrandePiece() == moyenne) moyenne = null;
    	if(this.plusGrandePiece() == grande) grande = null;
        return tamp;
    }

    public void PlacePiece(Piece p){ 	
        if(this.acceptePiece(p.getTaille())){
            if (p.getTaille()==Taille.PETITE){
                petite=p;
            }else if(p.getTaille()==Taille.MOYENNE){
                moyenne=p;
            }else{
                grande=p;
            }
        }
    }
    
    public Piece plusGrandePiece(){
    	
    	if(grande == null){
    	    if(moyenne == null){
                if(petite == null){
                    return null;
                }else{
                    return petite;
                }
            }else{
    	        return moyenne;
            }
        }else{
    	    return grande;
        }
    }

    @Override
    public String toString() {
        return "Case{" +
                "grande=" + petite +
                ", moyenne=" + moyenne +
                ", petite=" + grande +
                '}';
    }

}