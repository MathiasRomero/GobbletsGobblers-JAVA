package gobblets.data;

public enum Couleur {
		
	ROUGE(255,0,0,"#FF0000"),
	VERT(0,255,0,"#008000"),
	BLEU(0,0,255,"#0000FF"),
	JAUNE(255,255,0,"#efd807"),
	WHITE(255,255,255,"#FFFFFF");
	
	public int r;
	public int g;
	public int b;
	
	public String code;
	
	Couleur(int r,int g,int b,String code) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.code = code;
	}
	
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}
	
	public String getCode() {
		return code;
	}
	

	
	
	
	
	
}

