package GestionStatuts;
import DiplomeEtEntreprise.Entreprise;


public abstract class StatutFI extends Statut {
	
	protected String Etablissement ;
	
	public StatutFI(String etab){
		this.Etablissement=etab;
	}
	
	public String getEtab(){
		return this.Etablissement;
	}
	
	
	
	public Entreprise getEntrepriseStage(){
		return null;
	}
	

}
