package GestionStatuts;
import DiplomeEtEntreprise.Entreprise;
import GestionDepartements.Departement;
import GestionExceptions.NoDeptException;


public class Individuel extends StatutFC {

	private Entreprise entr;
	public Individuel(Entreprise e, Departement d) throws NoDeptException {
	 
		super(d);
		this.entr=e;
		
	}
	@Override
	public String toString() {
		return "Individuel [entr=   " + entr + "]" + " Departement    "  + depart;
	}

}
