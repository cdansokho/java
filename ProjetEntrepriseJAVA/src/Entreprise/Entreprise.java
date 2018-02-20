package Entreprise;
import java.util.Scanner;
import static Entreprise.Helper.verifInt;

public class Entreprise {

		private String nom;
		Directeur directeur = new Directeur();
		
		private Site tabSite[] = new Site[30];
		private int nombreSite;
		
		private Scanner sc = new Scanner(System.in);

		public Entreprise() {
			this.nom = "" ;
			this.nombreSite = 0;
		}
	    
		public String getId(){ return this.nom; }
		public void setId(String sId){ this.nom = sId; }
		
		public void saisir(){
			System.out.println("----------------------------------");
			System.out.print("Veuillez saisir le nom de l'entreprise : ");
			this.nom = this.sc.nextLine();
			System.out.print(" --- Directeur de l'entreprise --- ");
			directeur.saisir();
		}	

		public void afficher() {
			System.out.println("----------------------------------");
			System.out.println("Nom de l'entreprise : " + this.nom);
			System.out.print("Directeur de l'entreprise : ");
			directeur.afficher();
		}
		
		public void ajouter() {
			if(this.nombreSite < 30) {
	           char choix = 0 ;
	           do {
	        	   Site site = new Site();
	        	   site.saisir();
	        	   this.tabSite[this.nombreSite] = site;
	        	   this.nombreSite++;
	        	   System.out.println("----------------------------------");
	        	   System.out.println("Le site a bien été ajouté");
	               System.out.println("Continuez ? 1: Oui / 2: Non");
	               do{
	 		          System.out.print("> Choix : ");
	 		          choix = this.sc.nextLine().charAt(0);
	 	           }while(!verifInt(49, 50, choix));
	               
				}while(choix != '2');
			}else{ System.out.println("L'entreprise est pleine ! Aucun site ne peut etre ajouté !"); }
			System.out.flush();
		}
	     
		public void consulter() {
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("----------------------------------");
			System.out.print("Saisir l'id du site à trouver : ");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreSite && trouve == false) {
				if(id == this.tabSite[i].getId()){ trouve = true; }else{ i++; }
			}
			if(trouve == false){
				System.out.println("Personne ne correspond ! :(");
			}else{
				this.tabSite[i].menu();
			}
		}
	    
		public void supprimer() {
		  int id;
		  int i = 0;
		  boolean trouve = false;
		  System.out.println("----------------------------------");
		  System.out.print("Saisir l'id du site à supprimer : ");
		  id = this.sc.nextInt();
		  this.sc.nextLine();
		  
		  while(i < this.nombreSite && trouve == false){
			  if(id == this.tabSite[i].getId()){ trouve = true; }else{ i++; }
		  }
		  if(trouve==true) {
			  System.out.println("Le site a ete supprimé !");
			  this.tabSite[i] = this.tabSite[this.nombreSite-1];
			  this.nombreSite--;
		  }else{ System.out.println("Aucun site ne correspond ! :(");}
		}
		
		public void modifier() {
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("----------------------------------");
			System.out.print("Saisir l'id du site à modifier : ");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreSite && trouve == false) {
				if(id == this.tabSite[i].getId()){ trouve = true; }else{ i++; }
			}
			if(trouve == false){
				System.out.println("Aucun site ne correspond ! :(");
			}else{
				this.tabSite[i].afficher();
				System.out.println("  ---   ");
				this.tabSite[i].saisir();
			}
		}
		
	   public void menu() {
	       char select = 0; 
	       do{
	          System.out.println("****** MENU ENTREPRISE ********");
	          System.out.println("1: Afficher les informations de l'entreprise");
	          System.out.println("2: Modifier les informations de l'entreprise");
	          System.out.println("3: Ajouter un site dans l'entreprise");
	          System.out.println("4: Supprimer un site dans l'entreprise");
	          System.out.println("5: Modifier un site dans l'entreprise");
	          System.out.println("6: Consulter les informations d'un site");
	          System.out.println("0: Quitter");
	          do{
		          System.out.print("> Choix : ");
		          select = this.sc.nextLine().charAt(0);
	          }while(!verifInt(48, 54, select));
	          
	          switch (select) {
	            case '1' : this.afficher(); break;
	            case '2' : this.saisir(); break;
	            case '3' : this.ajouter(); break;
	            case '4' : this.supprimer(); break;
	            case '5' : this.modifier(); break;
	            case '6' : this.consulter(); break;
	         }
	       }while(select != 0);
	   }
}
