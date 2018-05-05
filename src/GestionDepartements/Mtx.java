package GestionDepartements;
import GestionExceptions.DepartementExistantException;


public class Mtx extends Departement {
	

	
private static Mtx mtx = null;
	
	private Mtx(String n){
		super(n);
	}
	

	
	public static Mtx getInstance() throws DepartementExistantException{
		if (mtx==null){
			mtx = new Mtx("Matériaux ");
			return mtx;
		}
		else throw new DepartementExistantException();
	}
	
	
	

	
	


}
