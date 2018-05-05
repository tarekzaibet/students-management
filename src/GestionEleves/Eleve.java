package GestionEleves;
import java.util.Calendar;
import java.util.Date;

import GestionExceptions.ChangeImpException;
import GestionStatuts.Statut;



public abstract class Eleve {
	


	protected String nom;
	protected Date date;
	protected Promotion p;
	protected Integer annee;
	protected Statut s;

	
	public Eleve(String name,Date d,Promotion p){
		this.nom=name;
		this.date=d;
		this.p=p;
		p.AddToListEleve(this);
		Promotion.ToutEleve.add(this);
		Promotion.ListeEleve.put(this.p.getYear(),p.GetListEleve());
		
				
	}
	
	public void SetAnnee(Integer b){
		this.annee=b;
	
	}
	
	public void SetPromotion(Promotion p){
		
		this.getPromotion().GetListEleve().remove(this);
		this.p=p;
		p.GetListEleve().add(this);
		
	}
	
	
	public Integer getAnnee(){
		return this.annee;
	}
	
	public Integer getAnneeDiplome(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getDate());
		int year = cal.get(Calendar.YEAR);
		return year;
	}
	
	public Statut getStatut(){
		return this.s;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public Promotion getPromotion(){
		return this.p;
	}
	
public void SetStatut (Statut s) throws ChangeImpException {
		
		
	}
	
	
	

	

}
