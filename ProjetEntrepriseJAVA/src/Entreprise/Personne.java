package Entreprise;
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
        this.id = pid;
		this.nom = pnom;
		this.prenom = pprenom;
	}
	
    public int getId(){ return this.id ; }
    public void setId(int pid){ this.id = pid ; }
    
	public String getNom(){ return this.nom; }
	public void setNom(String pnom){ this.nom = pnom; }
	
	
	public void setPrenom(String pnom){ this.nom = pnom; }
	public String getPrenom(){ return this.prenom; }
	
	public void saisir(){
        System.out.print("Saisir ID : ");
        this.id = this.sc.nextInt();
        this.sc.nextLine();
		System.out.print("Saisir le Nom : ");
		this.nom = this.sc.nextLine();
		System.out.print("Saisir le Prénom : ");
		this.prenom = this.sc.nextLine();
	}
	
	public void afficher(){
        System.out.println("ID de l'utilisateur : " + this.id);
		System.out.println("Prénom de l'utilisateur : " + this.prenom);
		System.out.println("Nom de l'utilisateur : " + this.nom);
	}
    
}