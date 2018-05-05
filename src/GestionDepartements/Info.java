package GestionDepartements;
import GestionExceptions.DepartementExistantException;


public class Info extends Departement {

	private static Info info = null;
	
	private Info(String nom){
		super(nom);
	}
	

	
	public static Info getInstance() throws DepartementExistantException{
		if (info==null){
			info = new Info("Info");
			return info;
		}
		else throw new DepartementExistantException();
	}
	

}
