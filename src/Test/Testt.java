package Test;

import java.util.ArrayList;
import java.util.Date;

import DiplomeEtEntreprise.*;
import GestionDepartements.*;
import GestionEleves.*;
import GestionExceptions.*;
import GestionStatuts.*;


public class Testt {

	public static void main(String[] args) throws NoDeptException, MemeEntrepriseException, ChangeImpException, AddImpossibleIngeException, AddImpossiblePeipException, AddImpossibleFCexception, AnneePromoImpException, DifferenteEntrepriseException, DepartementExistantException {
		
		
		
		Elec lec = Elec.getInstance();
		Info info = Info.getInstance();
		Mtx mtx = Mtx.getInstance();
		
		//ajout des départements disponibles pour chaque type de formation//
		CycleInge.ListeDepClassi.add(info);
		CycleInge.ListeDepClassi.add(mtx);
		CycleInge.ListeDepClassi.add(lec);		
		CycleInge.ListeDepApp.add(info);
		StatutFC.ListeDepFcont.add(info);

		Diplome dut = new Diplome("dut");
		
		//création des status//
		Classique cl = new Classique("cachan",dut,info);
		Classique c2 = new Classique("cachan",dut,mtx);
		Classique c3 = new Classique("cachan",dut,info);
		Entreprise e = new Entreprise("Alten");
		Entreprise n = new Entreprise("Steria");
		Apprenti app = new Apprenti("cachan",dut,info,e);
		PeiP pp = new PeiP("lycée");
		CIF cif = new CIF("a",e, info);
		PF pf = new PF (e,info);
		
		
		Date d6 = new Date(116,9,0);
		Date d = new Date(118,9,0);
		Date d2 = new Date(119,9,0);
		Date d3 = new Date(120,9,0);
		Date d4 = new Date(121,9,0);
		Date d1 = new Date();
		
		//création des promotions//
		Promotion p = new Promotion("en4a",d);
		Promotion pr = new Promotion("en3a",d2);
		Promotion prr = new Promotion("peip1",d4);
		Promotion prrr = new Promotion("peip2",d3);
		Promotion prom = new Promotion("en5a",d6);
		
		//création des éleves//
		
		EleveFI prep = new EleveFI("ouaih",d1,pp,prr,1);
		EleveFI prepa = new EleveFI("zoo",d1,pp,prr,1);
		EleveFI prep2 = new EleveFI("oh",d1,pp,prr,1);
		EleveFI prepa2 = new EleveFI("zo",d1,pp,prr,1);
		
		EleveFI k = new EleveFI("tda",d1,cl,pr,3);
		EleveFI c = new EleveFI("br",d1,cl,pr,3);
		EleveFI op = new EleveFI("gm",d1,cl,pr,3);
		EleveFI rv = new EleveFI("rv",d1,app,pr,3);
		
		
		
		
		EleveFI a = new EleveFI("tarek",d1,cl,p,4);
		EleveFI l = new EleveFI("to",d1,c2,p,4);
		EleveFI jm = new EleveFI("jm",d1,c3,p,4);
		
		EleveFI b = new EleveFI("tod",d1,c2,p,4);
		EleveFI t = new EleveFI("feel",d1,app,p,4);
		
		EleveFC fc = new EleveFC("z",d1,cif,p,4);
		EleveFC fin = new EleveFC("z",d1,pf,p,4);
		
        b.SetAnnee(5);
		b.SetPromotion(prom);
		t.SetAnnee(5);
		t.SetPromotion(prom);
	
		//test pour imprimer l'ensemble des infos d'un éleve//
		System.out.println(rv.toString());
	
		
		
		
		
		
		prepa2.SetAnnee(2);
		prepa2.SetPromotion(prrr);
		
		
		
		prep2.SetAnnee(2);
		prep2.SetPromotion(prrr);
		
		
		ArrayList<Eleve> liste[] = new ArrayList[5]; 
		
		ArrayList<Eleve> prep1 = new ArrayList<Eleve>();
		prep1.add(prep);
		
		ArrayList<Eleve> pre2 = new ArrayList<Eleve>();
		pre2.add(prepa2);
		
		liste[0]=prep1;
		liste[1]=pre2;
		
		
	
	
		
		ArrayList<Eleve> trois = new ArrayList<Eleve>();
		trois.add(k);
		trois.add(c);
		liste[2]=trois;
		
		
	
		
		ArrayList<Eleve> quatre = new ArrayList<Eleve>();
		quatre.add(a);
		liste[3]=quatre;
		
		
		
		//test pour la validation de stage d'un CycleInge Classique//
		
		System.out.println(b.ValidationDeStage(e));
		System.out.println(b.getStatut().getEntrepriseStage());
		
		
		ArrayList<Eleve> cinq = new ArrayList<Eleve>();
		cinq.add(b);
		liste[4]=cinq;
		
		
		// test pour la validation de stage d'un apprenti//
		System.out.println(t.ValidationDeStage(e));
		System.out.println(t.getStatut().getEntrepriseStage().getEntreprise());
		
		
		
		fc.SetAnnee(5);
		// test pour la validation de stage d'un fc en cif//
		System.out.println(fc.ValidationDeStage(n));
		System.out.println(fc.getStatut().getEntrepriseStage().getEntreprise());
		
		
		//test pour la validation de stage d'un fc en pf//
		fin.SetAnnee(5);
		System.out.println(fin.ValidationDeStage(e));
		System.out.println(fin.getStatut().getEntrepriseStage().getEntreprise());
	
		
		
		
		//test pour lister les étudiants//
		
		System.out.println(p.GetListEleve());
		System.out.println(p.GetListEleve(c2));
		System.out.println(p.GetListEleve(cl));
		System.out.println(p.GetListEleve(cif));
		System.out.println(Promotion.GetListEleve(p,cl,4,info));
		
		//test pour le changement de statut//
		
		System.out.println(k.getStatut().toString());
		k.SetStatut(c2);
		System.out.println(k.getStatut().toString());
		
		
         // renvoie la liste des éleces classé par promo//
		 System.out.println(Promotion.ListeEleve);
		
		
		// test pour la simulation du passage à l'année supérieur//

		ArrayList<Eleve> listenew[] = new ArrayList[5];
		listenew=Promotion.ChangementAnnee3(liste);
		
		for (int i=0;i< listenew.length;i++){
		   System.out.println(listenew[i].get(0).getPromotion().getYear());
		   System.out.println(listenew[i])	;
		}
		
		
		
		
		
		
		
		
		

	}
}
