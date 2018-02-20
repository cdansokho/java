package Entreprise;
import static Entreprise.Helper.verifInt;

import java.util.Scanner;

public class Site {

		private String nom;
		private int id;
		private String adresse;
		private int cp;
		String nomDirecteur;
		
		private Service tabService[] = new Service[30];
		private int nombreService;
		
		Directeur directeur = new Directeur();
		
		private Scanner sc = new Scanner(System.in);

		public Site() {
			this.nom = "" ;
			this.id = 0;
			this.adresse = "";
			this.nomDirecteur = "";
			this.cp = 0;
			this.nombreService = 0;
		}
	    
		public int getId(){ return this.id; }
		public void setId(int sId){ this.id = sId; }
		
		
		public void saisir(){
			System.out.println("----------------------------------");
			System.out.print("Saisir ID du Site : ");
			this.id = this.sc.nextInt();
			this.sc.nextLine();
			System.out.print("Saisir le nom du Site : ");
			this.nom = this.sc.nextLine();
			System.out.print("Saisir l'adresse du Site : ");
			this.adresse = this.sc.nextLine();
			System.out.print("Saisir le code postale du Site : ");
			this.cp = this.sc.nextInt();
			this.sc.nextLine();
			System.out.println(" --- Informations concernant le Directeur du Site --- ");
			directeur.saisir();
		}	

		public void afficher() {
			System.out.println("----------------------------------");
			System.out.println("Nom du site : " + this.nom);
			System.out.println("Id du site : " + this.id);
			System.out.println("Adresse du site : " + this.adresse);
			System.out.println("Code Postale du site : " + this.cp);
			System.out.println(" --- Directeur du site --- ");
			directeur.afficher();
		}
		
		public void ajouter() {
			if(this.nombreService < 30) {
	           char choix = 0 ;
	           do {
	        	   Service service = new Service();
	        	   service.saisir();
	        	   this.tabService[this.nombreService] = service;
	        	   this.nombreService++;
	        	   System.out.println("----------------------------------");
	        	   System.out.println("Le service à bien été ajouté");
	               System.out.println("Continuez ? 1: Oui / 2: Non");
	               do{
		 		      System.out.print("> Choix : ");
		 		      choix = this.sc.nextLine().charAt(0);
		 	       }while(!verifInt(49, 50, choix));
				}while(choix != '2');
			}else{ System.out.println("Le site est plein ! Aucun service ne peut etre ajouté !"); }
			System.out.flush();
		}
	     
		public void consulter() {
			int id;
			int i = 0;
			boolean trouve = false;
			System.out.println("----------------------------------");
			System.out.print("Saisir l'id du service à trouver : ");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreService && trouve == false) {
				if(id == this.tabService[i].getId()){ trouve = true; }else{ i++; }
			}
			if(trouve == false){
				System.out.println("Aucun service ne correspond ! :(");
			}else{
				this.tabService[i].menu();
			}
		}
	    
		public void supprimer() {
		  int id;
		  int i = 0;
		  boolean trouve = false; 
		  System.out.println("----------------------------------");
		  System.out.print("Saisir l'id du service à supprimer : ");
		  id = this.sc.nextInt();
		  this.sc.nextLine();
		  
		  while(i < this.nombreService && trouve == false){
			  if(id == this.tabService[i].getId()){ trouve = true; }else{ i++; }
		  }
		  if(trouve==true) {
			  System.out.println("Le service a ete supprimé !");
			  this.tabService[i] = this.tabService[this.nombreService-1];
			  this.nombreService--;
		  }else{ System.out.println("Aucun service ne correspond ! :(");}
		}
		
		public void modifier() {
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("----------------------------------");
			System.out.print("Saisir l'id du service à trouver : ");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreService && trouve == false) {
				if(id == this.tabService[i].getId()){ trouve = true; }else{ i++; }
			}
			if(trouve == false){
				System.out.println("Aucun service ne correspond ! :(");
			}else{
				this.tabService[i].afficher();
				System.out.println("  ---   ");
				this.tabService[i].saisir();
			}
		}
		
	   public void menu() {
	       char select = 0; 
	       do{
	          System.out.println("****** MENU SITE #" + this.getId() + " ********");
	          System.out.println("1: Afficher les informations du site");
	          System.out.println("2: Modifier les informations du site");
	          System.out.println("3: Ajouter un service dans le site");
	          System.out.println("4: Supprimer un service du site");
	          System.out.println("5: Modifier un service du site");
	          System.out.println("6: Consulter les informations d'un service");
	          System.out.println("0: Quitter");
	          do{
		          System.out.print("> Choix : ");
		          select = this.sc.nextLine().charAt(0);
	          }while(!verifInt(48, 54, select));
	          switch (select) {
	            case '1' : this.afficher(); break;
	            case '2' : this.saisir(); break;
	            case '3' : this.ajouter(); break;
	            case '4' : this.supprimer();break;
	            case '5' : this.modifier();break;
	            case '6' : this.consulter();break;
	         }
	       }while(select != 0);
	   }
}
