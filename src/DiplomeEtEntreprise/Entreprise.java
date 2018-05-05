package DiplomeEtEntreprise;

public class Entreprise {
	
	private String nom;
	public Entreprise(String n){
		this.nom=n;
	}
	
	public String getEntreprise(){
		return this.nom;
	}

	@Override
	public String toString() {
		return "Entreprise [nom=" + nom + "]";
	}
	
	

}
