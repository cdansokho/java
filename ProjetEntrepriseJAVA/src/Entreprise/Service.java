package Entreprise;
import static Entreprise.Helper.verifInt;

import java.util.Scanner;

public class Service {

		private String nom;
		private int id;
		private int etage;
		private Employe tabEmploye[] = new Employe[30];
		private Cadre tabCadre[] = new Cadre[30];
		
		private Directeur directeur = new Directeur();
		private int nombreEmploye;
		private int nombreCadre;
		
		private Scanner sc = new Scanner(System.in);

		public Service() {
			this.nom = "" ;
			this.id = 0;
			this.etage = 0;
			this.nombreEmploye = 0;
			this.nombreCadre = 0;
		}
	    
		public String getnom(){ return this.nom; }
		public void setnom(String sNom){ this.nom = sNom ; }
		
		public int getId(){ return this.id ; }
		public void setId(int sId){ this.id = sId ; }
		
		public int getEtage(){ return this.etage ; }
		public void setEtage(int sEtage){ this.etage = sEtage ; }
		
		public void saisir(){
			System.out.println("----------------------------------");
			System.out.print("Veuillez saisir l'id du Service : ");
			this.id = this.sc.nextInt();
			this.sc.nextLine();
			System.out.print("Veuillez saisir le nom du Service : ");
			this.nom = this.sc.nextLine();
			System.out.print("Veuillez saisir l'étage du Service : ");
			this.etage = this.sc.nextInt();
			this.sc.nextLine();
	        System.out.println("---- Information sur le Directeur du Service ----");
			this.directeur.saisir();
			
	        int choix = 0;
	        System.out.println("Ajouter des Employé ou des Cadres au service ? 1: Oui /2: Non");
	        System.out.print("> Choix : ");
	        choix = sc.nextInt();
	        this.sc.nextLine();
	        if(choix == 1){ this.ajouter(); }
		}

		
		public void ajouter() {
			char choix = '0';
			do{	
				System.out.println("----------------------------------");
				System.out.println("Qui voulez-vous ajouter ?");
				System.out.println("1: Ajouter un employé");
				System.out.println("2: Ajouter un cadre");
				System.out.println("3: Annuler");
				do{
			      System.out.print("> Choix : ");
			      choix = this.sc.nextLine().charAt(0);
		        }while(!verifInt(49, 50, choix));
				
	            if(choix == '1'){
	            	if(nombreEmploye < 30){
		            	Employe employe = new Employe();
			        	employe.saisir();
			        	this.tabEmploye[this.nombreEmploye] = employe;
			        	this.nombreEmploye++;
			        	System.out.println("L'employé / Cadre a bien été ajouté");
	            	}else{ System.out.println("Il y'a trop d'employé pour ce Service !"); }
	            }else if(choix == '2'){
	            	if(nombreCadre < 30){
		            	Cadre cadre = new Cadre();
			        	cadre.saisir();
			        	this.tabCadre[this.nombreCadre] = cadre;
			        	this.nombreCadre++;
			        	System.out.println("L'employé / Cadre a bien été ajouté");
	            	}else{ System.out.println("Il y'a trop de cadre pour ce Service !"); }
	            }
	            choix = '0';
	            System.out.println("Continuez ? 1: Oui / 2: Non");
	            do{
				  System.out.print("> Choix : ");
				  choix = this.sc.nextLine().charAt(0);
			    }while(!verifInt(49, 50, choix));
			}while(choix != 2);
			this.menu();	
		}	

		public void afficher() {
			System.out.println("----------------------------------");
			System.out.println("Nom du service : " + this.nom);
			System.out.println("Id du service : " + this.id);
			System.out.println("Etage du service : " + this.etage);
			this.directeur.afficher();
	        //this.afficherTout();
		}
		
		public void afficherTout(){
			System.out.println("----------------------------------");
			System.out.println("Le service est composée de : ");
			System.out.println(" ---- Cadre ---- ");
			for (int i = 0 ; i < this.nombreCadre; i++){
				System.out.println("-> Cadre #" + this.tabCadre[i].getId());
				this.tabCadre[i].afficher();
			}
			System.out.println(" ---- Employé ---- ");
			for (int i = 0 ; i < this.nombreEmploye; i++){
				System.out.println("-> Employé #" + this.tabEmploye[i].getId());
				this.tabEmploye[i].afficher();
			}
		}
		
		public void modifier() {
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("----------------------------------");
			System.out.print("Saisir l'id de l'employé à modifier : ");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreEmploye && trouve == false) {
				if(id == this.tabEmploye[i].getId()){ trouve = true; }else{ i++; }
			}
			if(trouve == false){
				System.out.println("Aucun employé ne correspond ! :(");
			}else{
				this.tabEmploye[i].afficher();
				System.out.println("  ---   ");
				this.tabEmploye[i].saisir();
			}
		}
	     
	              
	   public void menu() {
	       char select = 0; 
	       do{
	          System.out.println("****** MENU SERVICE ********");
	          System.out.println("1: Afficher la description du service");
	          System.out.println("2: Modifier les informations du services");
	          System.out.println("3: Ajouter un cadre/employé dans le service");
	          System.out.println("4: Afficher les employés et cadre du service");
	          System.out.println("5: Modifier un service du site");
	          System.out.println("0: Quitter");
	          do{
		          System.out.print("> Choix : ");
		          select = this.sc.nextLine().charAt(0);
	          }while(!verifInt(48, 54, select));
	          switch (select) {
	            case '1' : this.afficher(); break;
	            case '2' : this.saisir(); break;
	            case '3' : this.ajouter(); break;
	            case '4' : this.afficherTout(); break;
	            case '5' : this.modifier(); break;
	         }
	       }while(select != 0);
	   }
}
