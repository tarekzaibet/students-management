package GestionStatuts;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.MemeEntrepriseException;
import GestionExceptions.NoDeptException;


public class PF extends StatutFC {
	
	private Entreprise entr;
	private Entreprise entrepriseStage;

	public PF(Entreprise e,Departement d) throws NoDeptException {
	
		super(d);
		this.entr=e;
		
		
	}
	
	
	//méthode qui valide le stage pour un plan de formation //
	
	
	public boolean ValidationStage(Entreprise a) throws MemeEntrepriseException {
		if (this.entr.equals(a)){
			this.entrepriseStage=a;
			return true;
		}
		
		else throw new MemeEntrepriseException();
	}
	
	public Entreprise getEntrepriseStage(){
		return this.entrepriseStage;
	}
	
	public String getEntreprise(){
		return this.entr.getEntreprise();
	}

	@Override
	public String toString() {
		return "PF [entr=   " + entr.getEntreprise() + "]"  + "Departement   " +depart;
	}

}
