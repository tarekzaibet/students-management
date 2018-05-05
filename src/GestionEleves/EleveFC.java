package GestionEleves;
import java.util.Date;

import DiplomeEtEntreprise.Entreprise;
import GestionExceptions.AddImpossibleFCexception;
import GestionExceptions.ChangeImpException;
import GestionExceptions.DifferenteEntrepriseException;
import GestionExceptions.MemeEntrepriseException;
import GestionStatuts.CIF;
import GestionStatuts.PF;
import GestionStatuts.StatutFC;


public class EleveFC extends Eleve {
	
	private StatutFC statut;
	
	public EleveFC(String nom,Date d,StatutFC stat,Promotion p,Integer a) throws AddImpossibleFCexception{
		
		super(nom,d,p);
		if (admissionFC(a)){
			this.statut=stat;
			this.annee=a;
			
		}
		else throw new AddImpossibleFCexception();
		
	}
	
	public StatutFC getStatut(){
		return this.statut;
	}
	
	
	//procédure de validation de stage pour les FC//
	public String ValidationDeStage(Entreprise a) throws MemeEntrepriseException, DifferenteEntrepriseException{
		if (this.getAnnee().equals(5)){
			if (this.getStatut().ValidationStage(a)){
					return "stage validé";
			}
		}
		return "stage non validé";
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Eleve [nom=  " + nom + "   date=  " +  date +"promo nom" + p.getNom()+ ", promo annee =   " + p.getYear() + "]"+ "    Annee     " +    annee + "  Statut  " +  statut.toString();
	}
	
	
	//procédure vérifiant l'année d'admissio d'un FC//
	public boolean admissionFC (Integer a){
		if (a != 4){
			return false;
		}
		return true;
	}
	
	//procédure modifiant le statut d'un FC tout en vérifiant la possibilié de changement//
	
	public void SetStatut (StatutFC s) throws ChangeImpException {
		
		if (this.ChangementValide(s)){
			
				this.statut=s;
			}
			
		
		
		else throw new ChangeImpException();
		
		
	}
	
	//procédure vérifiant que le changement de statut est valide//
	
	public boolean ChangementValide(StatutFC s){
		
		if (s instanceof CIF){
			if (this.getStatut() instanceof PF){
				return false;
			}
		}
		
		
			 return true;
		
		
	}

	

	
	

}
