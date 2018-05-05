package GestionStatuts;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.MemeEntrepriseException;
import GestionExceptions.NoDeptException;


public class CIF extends StatutFC {
	
	private String Organisme;
	private Entreprise entrepriseOrigine;
	private Entreprise entrepriseStage;
	
	public CIF(String o,Entreprise e,Departement d) throws NoDeptException {
		
		super(d);
		this.entrepriseOrigine=e;
		this.Organisme=o;
		
	}
	
	
	//méthode qui vérifie que le stage est valide pour un cif//
	
	public boolean ValidationStage(Entreprise a) throws MemeEntrepriseException {
		if (!this.entrepriseOrigine.equals(a)){
			this.entrepriseStage=a;
			return true;
		}
		
		else throw new MemeEntrepriseException();
	}
	
	public Entreprise getEntrepriseStage(){
		return this.entrepriseStage;
	}

	@Override
	public String toString() {
		return "CIF [   Organisme=   " + Organisme + ", entrepriseOrigine=  "
				+ entrepriseOrigine.getEntreprise() 
				+ "  ]" + " Departement "   +  depart;
	}
}
