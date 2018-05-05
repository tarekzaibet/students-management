package GestionDepartements;

public abstract class Departement  {
	
	private String nom;

	
	public Departement(String n){
		
		this.nom=n;
		
	}
	
	public String GetNomDep(){
		return this.nom;
	}

	@Override
	public String toString() {
		return "[nom=  " + this.GetNomDep() + "]";
	}
	
	
	

}
