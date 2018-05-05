package GestionDepartements;
import GestionExceptions.DepartementExistantException;


public class Optro extends Departement {
	
	
	
private static Optro optro = null;
	
public Optro(String n) {
	super(n);
	
}
	

	
	public static Optro getInstance() throws DepartementExistantException{
		if (optro==null){
			optro = new Optro("Optronique");
			return optro;
		}
		else throw new DepartementExistantException();
	}
	


	

}
