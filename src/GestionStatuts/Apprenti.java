package GestionStatuts;
import DiplomeEtEntreprise.Diplome;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.DifferenteEntrepriseException;
import GestionExceptions.NoDeptException;


public class Apprenti extends CycleInge {
	
	private Entreprise entrep;
	
	
	public Apprenti(String n,Diplome d,Departement depar,Entreprise e) throws NoDeptException {
		super(n,d);
		this.entrep=e;
		if (this.EstContenu(depar)){
			this.depart=depar;
		}
	}
	
	
	//méthode qui vérifie que le stage est valide pour les apprentis//
	
	public boolean ValidationStage(Entreprise a) throws DifferenteEntrepriseException  {
		if (this.entrep.equals(a)){
			this.EntrepriseStage=a;
			return true;
		}
		
		else throw new DifferenteEntrepriseException();
	}

	
	
	@Override
	public String toString() {
		return "   Etudiant en Apprentissage  " +"  etablissement  " + Etablissement  +" Diplome  " + diplome + "   Departement   " + depart +"  Entreprise   " + entrep.getEntreprise();
	}
	
	
	//méthode qui vérifie que les apprentis ont le droit au département passé en parametre//
	public boolean EstContenu(Departement d){
		if (CycleInge.ListeDepApp.contains(d)){
			return true;
		}
		else {
			return false;
		}
	}


	public Entreprise getEntreprise(){
		return this.entrep;
	}

}
