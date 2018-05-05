package GestionEleves;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import GestionDepartements.Departement;
import GestionExceptions.AddImpossiblePeipException;
import GestionExceptions.AnneePromoImpException;
import GestionStatuts.*;
import GestionStatuts.*;


public class Promotion {
	
	private String nom;
	private Date date;
	public static ArrayList<Eleve> ToutEleve= new ArrayList<Eleve>() ;
	public static HashMap<Integer,ArrayList<Eleve>> ListeEleve = new HashMap<Integer,ArrayList<Eleve>>();
	
	
	
	
	@Override
	public String toString() {
		return "Promotion  nom=  " + nom;
	}





	private ArrayList<Eleve> ElevePromo = new ArrayList<Eleve>();
	
	public Promotion(String n,Date d){
		this.nom=n;
		this.date=d;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public void SetNom(String nom){
		this.nom=nom;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public Integer getYear(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getDate());
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	
	
	//méthode pour lister les étudiantsd'une promotion//
	public ArrayList<Eleve> GetListEleve(){
		return this.ElevePromo;
	}
	
	
	//méthode pour lister les étudiants d'une promotion selon un statut//
	public ArrayList<Eleve> GetListEleve(Statut s){
		ArrayList<Eleve> el = new ArrayList<Eleve> ();
 		for(Eleve e : ElevePromo){
			if (e.getStatut().equals(s)){
				el.add(e);
				
			}
		}
 		return el;
	}
	

	//méthode pour lister les étudiants//
	public static ArrayList<Eleve> GetListEleve(Promotion p,Statut s,Integer a,Departement dep){
		ArrayList<Eleve> el = new ArrayList<Eleve> ();
		if (s instanceof Classique){
 		for(Eleve e : p.GetListEleve()){
			if (e.getStatut() instanceof Classique ){
				if (e.getAnnee().equals(a)){
					if (e.getStatut().getDep().equals(dep)){
						el.add(e);
					}
				}
				
				
			}
		}
		}
		
		else if (s instanceof Apprenti){
	 		for(Eleve e : p.GetListEleve()){
				if (e.getStatut() instanceof Apprenti ){
					if (e.getAnnee().equals(a)){
						if (e.getStatut().getDep().equals(dep)){
							el.add(e);
						}
					}
					
					
				}
			}
			}
		
		
		else if (s instanceof StatutFC){
	 		for(Eleve e : p.GetListEleve()){
				if (e.getStatut() instanceof StatutFC ){
					if (e.getAnnee().equals(a)){
						if (e.getStatut().getDep().equals(dep)){
							el.add(e);
						}
					}
					
					
				}
			}
			}
 		return el;
	}
	

	

	
	
	
	public void AddToListEleve(Eleve e){
		this.ElevePromo.add(e);
	}
	
	
	
	//méthode qui renvoie la liste des éleves qui réusissent en modifiant leur année// 
	
	private ArrayList<Eleve> Changement(ArrayList<Eleve> a){
		ArrayList<Eleve> elev = new ArrayList<Eleve>();
	  Promotion p = a.get(0).getPromotion();
		for (Eleve t : p.GetListEleve()){
		  if (a.contains(t)){
			  t.SetAnnee(t.getAnnee()+1);
			  
			  elev.add(t);
			  
		  }
		
		
		}
	  
	  return elev;
	 
	}
	
	
	//méthode qui renvoie la liste des éleves qui redoublent//
	
	private ArrayList<Eleve> ChangementNeg(ArrayList<Eleve> a){
		ArrayList<Eleve> elev = new ArrayList<Eleve>();
	  Promotion p = a.get(0).getPromotion();
		for (Eleve t : p.GetListEleve()){
		  if (!a.contains(t)){
			  elev.add(t);	  
		  }
		}
	  
	  return elev;
	 
	}
	


	

	//méthode simulant le changement d'année universitaire//
	
	public static ArrayList<Eleve>[] ChangementAnnee3(ArrayList<Eleve>[] a) {
		ArrayList<Eleve> listeadmis[] = new ArrayList[4];
	
		
		ArrayList<Eleve> un = new ArrayList<Eleve>();
		ArrayList<Eleve> deux = new ArrayList<Eleve>();
		ArrayList<Eleve> trois = new ArrayList<Eleve>();
		Integer annee2 =a[1].get(0).getPromotion().getYear();
		Integer annee1 =a[0].get(0).getPromotion().getYear();
		Integer annee3 =a[2].get(0).getPromotion().getYear();
		Integer annee4 =a[3].get(0).getPromotion().getYear();
		
		ArrayList<Eleve> troisn = new ArrayList<Eleve>();
		ArrayList<Eleve> quatre = new ArrayList<Eleve>();
		ArrayList<Eleve> quatren = new ArrayList<Eleve>();
		ArrayList<Eleve> cinqn = new ArrayList<Eleve>();
	
		
		un =a[0].get(0).getPromotion().Changement(a[0]);
		deux =a[1].get(0).getPromotion().Changement(a[1]);
	
		
	
		
		trois = a[2].get(0).getPromotion().Changement(a[2]);
		troisn = a[2].get(0).getPromotion().ChangementNeg(a[2]);
		for (Eleve t : troisn){
			
				t.SetPromotion(a[1].get(0).getPromotion());
				deux.add(t);
				
			}
			
		quatre = a[3].get(0).getPromotion().Changement(a[3]);
		quatren = a[3].get(0).getPromotion().ChangementNeg(a[3]);
		for (Eleve t : quatren){
		
		t.SetPromotion(a[2].get(0).getPromotion());
		trois.add(t);
		}
		
		
		cinqn = a[4].get(0).getPromotion().ChangementNeg(a[4]);
		
		for (Eleve t : cinqn){
			
			t.SetPromotion(a[3].get(0).getPromotion());
			quatre.add(t);
		}
		
		
		listeadmis[0] = un;
		listeadmis[1]= deux;
		listeadmis[2]= trois;
		listeadmis[3]= quatre;
		

	
		
		
		
		return listeadmis;
		
		
		
		
		
	        	 
	        	 
	        	 
	 	 		           
	        	  
	  
	          
	          
	 	 		           
	
	 		       
	}
}
	
	




