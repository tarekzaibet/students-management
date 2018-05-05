package GestionEleves;
import java.util.Date;

import DiplomeEtEntreprise.Entreprise;
import GestionExceptions.AddImpossibleIngeException;
import GestionExceptions.AddImpossiblePeipException;
import GestionExceptions.AnneePromoImpException;
import GestionExceptions.ChangeImpException;
import GestionExceptions.DifferenteEntrepriseException;
import GestionExceptions.MemeEntrepriseException;
import GestionStatuts.Apprenti;
import GestionStatuts.Classique;
import GestionStatuts.CycleInge;
import GestionStatuts.PeiP;
import GestionStatuts.StatutFI;


public class EleveFI extends Eleve {
	
	private StatutFI statut;
	
	@Override
	public String toString() {
		return "Eleve nom=" + nom + "  , date=  " + date + "   promo nom=   " + p.getNom()+ "  promo annee " + p.getYear() +   "  " + "  Annee   " + annee +   "   statut " + statut.toString();
	}
	
	


    public EleveFI(String n,Date d,CycleInge stat,Promotion p,Integer a) throws AddImpossibleIngeException, AnneePromoImpException{
		super(n,d,p);
		if (AdmissionCycleIngeValide(a)){
			if (AnneePromoValideCycleInge(a,p)){
			this.annee=a;
			this.statut=stat;
		}
			else throw new AnneePromoImpException();
		}
		else throw new AddImpossibleIngeException();
		
		   
		}
    
    public EleveFI(String n,Date d,PeiP stat,Promotion p,Integer a) throws AddImpossiblePeipException, AnneePromoImpException{
		super(n,d,p);
		if (AdmissionPeiPvalide(a)){
			if (AnneePromoValidePeiP(a,p)){
				this.annee=a;
				this.statut=stat;
			}
			
			else throw new AnneePromoImpException();
		}
		else throw new AddImpossiblePeipException();
		    
		
		   
		}
    
   
    
			
	public StatutFI getStatut(){
		return this.statut;
	}
	
	
	
	public String ValidationDeStage(Entreprise a) throws MemeEntrepriseException, DifferenteEntrepriseException{
		if (this.getAnnee().equals(5)){
			if (this.getStatut().ValidationStage(a)){
					return "stage validé";
			}
		}
		return "stage non validé";
	}
	
	//méthode qui change le statut de l'eleve en verifiant que le changement est valide//
	
	public void SetStatut(StatutFI s) throws ChangeImpException  {
		if (this.ChangementValide(s)){
			if (this.getStatut() instanceof PeiP){
				this.annee=3;
				this.statut=s;
			}
			else this.statut=s;
		}
		
		
		else throw new ChangeImpException();
		
		
	}
	
	//méthode qui indique si le changement de statut est valide//
	
	public boolean ChangementValide(StatutFI s){
		
		if (s instanceof PeiP){
			if (this.getStatut() instanceof CycleInge){
				return false;
			}
		}
		
		else if (s instanceof Classique){
			if (!this.getAnnee().equals(3)){
				return false;
			}
			if (this.getStatut() instanceof Apprenti){
				return false;
			}
			if (this.getStatut() instanceof PeiP){
				if (!this.getAnnee().equals(2)){
					return false;
				}
				
			}
			else return true;
		}
		
			
		
		
		else if (s instanceof Apprenti){
			if (!this.getAnnee().equals(3)){
				return false;
			}
			if (this.getStatut() instanceof Classique){
				return false;
			}
			
		}
		
		
		return true;
		
	}
	
	//méthode qui vérifie que l'admission d'un peip//
	
	public boolean AdmissionPeiPvalide (Integer a ){
		if (a!=1){
			return false;
		}
	
		return true;
	}
	
	
	//méthode qui vérifie que l'admission d'un cycle ingé est valide//
	
	public boolean AdmissionCycleIngeValide(Integer a){
		if ((a.compareTo(4)>0)){
			return false;
		}
		else if ((a.compareTo(2)<0)){
			return false;
		}
		return true;
	}
	
	
	//méthode qui vérifie que l'année et la promotion sont cohérent pour un cycle inge// 
	public boolean AnneePromoValideCycleInge(Integer a,Promotion b) {
		if (a==3){
			int y = this.getAnneeDiplome();
			int x = b.getYear();
			int z = x-y;
			if (z!=3){
				return false;
			}
		}
		else if (a==4){
			int y = this.getAnneeDiplome();
			int x = b.getYear();
			int z = x-y;
			if (z!=2){
				return false;
			}
		}
		return true;
		
	}
	
	
	//méthode qui vérifie que l'année et la promotion sont cohérent pour un PeiP// 
	public boolean AnneePromoValidePeiP(Integer a,Promotion b) {
		if (a==1){
			int y = this.getAnneeDiplome();
			int x = b.getYear();
			int z = x-y;
			if (z!=5){
				return false;
			}
		}
		else if (a==2){
			int y = this.getAnneeDiplome();
			int x = b.getYear();
			int z = x-y;
			if (z!=4){
				return false;
			}
		}
		return true;
		
	}
	
	
	

	

	
	

}
