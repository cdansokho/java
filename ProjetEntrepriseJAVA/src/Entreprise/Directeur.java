package Entreprise;
public final class Directeur extends Cadre{
	
	private String qualification;
	
	public Directeur(){
		super();
		this.qualification = "";
	}
        
    public Directeur(String nom , String prenom , String responsabilite , String qualification , int id){
		super(nom, prenom, responsabilite, id);
		this.qualification = "";
	}
	
	public String getQualification(){ return this.qualification; }
	public void setQualification(String pPoste){ this.qualification = pPoste; }
	
	public void saisir(){
		super.saisir();
		System.out.print("Qualification du cadre : ");
		this.responsabilite = this.sc.nextLine();
	}
	
	public void afficher(){
		super.afficher();
		System.out.println("Qualification du cadre : " + this.qualification);
	}
}
