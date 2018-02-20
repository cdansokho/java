package gestion;

import java.util.Scanner;

public abstract class Personne {
        protected int id;
	protected String nom;
	protected String prenom;
	protected Scanner sc = new Scanner(System.in);
	
	public Personne(){
                this.id=0;
		this.nom = "";
		this.prenom = "";
	}
	
	public Personne(String pnom, String pprenom, int pid){
                this.id=pid;
		this.nom = pnom;
		this.prenom = pprenom;
	}
	
        public int getid(){
                return this.id ;
	}
                
	public String getNom(){
		return this.nom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
        public void setid(int pid){
            this.id = pid ;
        }

	
	public void setNom(String pnom){
		this.nom = pnom;
	}
	
	public void setPrenom(String pnom){
		this.nom = pnom;
	}
	
	public void saisir(){
                System.out.println("Saisir l'id ");
                this.id = this.sc.nextInt();
                 sc.nextLine();
		System.out.println("Veuillez saisir le nom  :");
		this.nom = this.sc.nextLine();
		System.out.println("Veuillez saisir le prénom  :");
		this.prenom = this.sc.nextLine();
	}
	
	public void afficher(){
                System.out.println("ID de l'utilisateur :" +this.id);
		System.out.println("Prenom de l'utilisateur :"+this.prenom);
		System.out.println("Nom de l'utilisateur :"+this.nom);
	}
	

    
}