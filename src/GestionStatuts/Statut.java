package GestionStatuts;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.DifferenteEntrepriseException;
import GestionExceptions.MemeEntrepriseException;


public abstract class Statut {
	
	protected Departement depart;
	
	public Departement getDep(){
		return this.depart;
	}
	public  boolean ValidationStage(Entreprise a) throws MemeEntrepriseException, DifferenteEntrepriseException {
		
			return false;
	}
}
