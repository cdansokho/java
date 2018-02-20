package Entreprise;

public class Cadre extends Personne{

	protected String responsabilite;
	
	public Cadre(){
		super();
		this.responsabilite = "";
	}
        
    public Cadre(String nom , String prenom , String responsabilite , int id){
		super(nom, prenom, id);
		this.responsabilite = "";
	}
	
	public String getPoste(){ return this.responsabilite; }
	public void setPoste(String pPoste){ this.responsabilite = pPoste; }
	
	public void saisir(){
		super.saisir();
		System.out.print("Poste de l'employé : ");
		this.responsabilite = this.sc.nextLine();
	}
	
	public void afficher(){
		super.afficher();
		System.out.println("Poste de l'employé : " + this.responsabilite);
	}
}
