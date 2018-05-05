package GestionDepartements;

import GestionExceptions.DepartementExistantException;


public class Elec extends Departement {
	
	private static  Elec elec = null;

	private Elec(String n) {
		super(n);
		
	}
	
	public  static void  reset(){
		elec=null;
	}
	
	public static  Elec getInstance() throws DepartementExistantException{
		if (elec==null){
			elec = new Elec("E2S");
			return elec;
		}
		else throw new DepartementExistantException();
	}

	
	

}
