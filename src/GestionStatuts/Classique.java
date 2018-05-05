package GestionStatuts;
import DiplomeEtEntreprise.Diplome;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.MemeEntrepriseException;
import GestionExceptions.NoDeptException;




public class Classique extends CycleInge  {
	
	public Classique(String etab, Diplome d, Departement depar) throws NoDeptException {
		super(etab, d);
		
		if (this.EstContenu(depar)== true ){
			this.depart=depar;
		}
		
		
		else throw new NoDeptException(); 
		

	}
	
	
	//méthode qui valide le stage pour un cycle ingé classique//
	public boolean ValidationStage(Entreprise a)  {
	
			this.EntrepriseStage=a;
		    return true;
	}
	
	
	
	

	


	@Override
	public String toString() {
		return "  voie classique   " +  "etablissement  " + "[" + Etablissement + "]"  +  	"    Diplome   " + "[" + diplome +  "]"  +   "Departement"  + "[" + depart + "]";
	}
	//méthode qui vérifie que les apprentis ont le droit au département passé en parametre//
	
	public boolean EstContenu(Departement d){
		if (CycleInge.ListeDepClassi.contains(d)){
			return true;
		}
		else {
			return false;
		}
	}
	
	

	


}
