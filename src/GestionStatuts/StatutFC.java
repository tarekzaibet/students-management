package GestionStatuts;
import java.util.ArrayList;

import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.NoDeptException;




public abstract class StatutFC extends Statut {
	
	public static ArrayList<Departement> ListeDepFcont= new ArrayList<Departement>() ;
	
	public StatutFC(Departement d) throws NoDeptException{
		if (ChoixDepartementValide(d)){
			this.depart=d;
		}
		else throw new NoDeptException();
	}
	
	public boolean ChoixDepartementValide(Departement d){
		 if (StatutFC.ListeDepFcont.contains(d)){
			 return true;
		 }
		 return false;
	}
	
	
	
	public Entreprise getEntrepriseStage(){
		return null;
	}
	
	

		
		
	}
	
	

