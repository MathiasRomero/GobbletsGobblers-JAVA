package gobblets.data;

public enum Taille {

	PETITE('1') {
		@Override
		public boolean recouvre(Taille p) {
			return false;		
		}
	},
	MOYENNE('2') {
		@Override
		public boolean recouvre(Taille p) {
			if (p.getSymbole()=='1') {
				return true;
			}else {
				return false;
			}
		}
	},
	GRANDE('3') {
		@Override
		public boolean recouvre(Taille p) {
			if(p.getSymbole() == '1' || p.getSymbole() == '2') return true;
			return false;
		}
	};
	
	public char Symbole;
	
	Taille(char c){
		this.Symbole = c;
	}
	
	
	public char getSymbole() {
		return Symbole;
	}
	
	public boolean recouvre(Piece p) {
		return this.recouvre(p.getTaille());
	}
	
	public abstract boolean recouvre(Taille p);


}
