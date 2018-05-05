package GestionStatuts;
import java.util.ArrayList;

import DiplomeEtEntreprise.Diplome;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;


public abstract class CycleInge extends StatutFI {
	


	protected Diplome diplome;
	protected Entreprise EntrepriseStage;
	
	//protected Departement depart;
	
	public static ArrayList<Departement> ListeDepClassi= new ArrayList<Departement>() ;
	public static ArrayList<Departement> ListeDepApp= new ArrayList<Departement>() ;

	public CycleInge(String etab,Diplome d) {
		super(etab);
		this.diplome=d;
		
		
	}
	
	public Departement getDepartement(){
		return this.depart;
	}
	
	public Diplome getDiplome(){
		return this.diplome;
	}
	
	public ArrayList<Departement> GetDepClassi(){
		
		return CycleInge.ListeDepClassi;
	}
	
	public ArrayList<Departement> GetDepApp(){
		
		return CycleInge.ListeDepApp;
	}



	public Entreprise getEntrepriseStage(){
		return this.EntrepriseStage;
	}

	public boolean EstContenu(Departement d){
			return false;
	}
	
	
	

}
