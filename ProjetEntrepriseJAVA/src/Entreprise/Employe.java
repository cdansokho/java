package Entreprise;
public class Employe extends Personne{
	
	protected String poste;
	
	public Employe(){
		super();
		this.poste = "";
	}
        
    public Employe(String nom , String prenom , String poste , int id){
		super(nom, prenom, id);
		this.poste = "";
	}
	
	public String getPoste(){ return this.poste; }
	public void setPoste(String pPoste){ this.poste = pPoste; }
	
	
	public void saisir(){
		super.saisir();
		System.out.print("Poste de l'employé : ");
		this.poste = this.sc.nextLine();
	}
	
	public void afficher(){
		super.afficher();
		System.out.println("Poste de l'employé : " + this.poste);
	}
	
}
