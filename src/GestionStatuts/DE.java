package GestionStatuts;
import GestionDepartements.Departement;
import GestionExceptions.NoDeptException;


public class DE extends StatutFC {

	
	public DE(Departement d) throws NoDeptException{
		super(d);
		
	}
	

	@Override
	public String toString() {
		return "DE     " + " Departement   "  +depart;
	}


}
