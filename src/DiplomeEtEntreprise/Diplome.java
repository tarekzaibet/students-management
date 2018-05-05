package DiplomeEtEntreprise;

public class Diplome {
	
	private String nom;
	
	public Diplome(String n){
		this.nom=n;
	}
	
	@Override
	public String toString() {
		return "[nom=    " + this.getNom() + "]";
	}

	public String getNom(){
		return this.nom;
	}

}
