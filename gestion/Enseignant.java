package gestion;

public class Enseignant extends Personne {
    private String diplome;
private float salaire;

public Enseignant(){
	super ();
	this.diplome = "";
	this.salaire = 0;
}
    
    public Enseignant(String nom , String prenom , String diplome ,int salaire, int id){
	super ( nom , prenom , id);
	this.diplome = "";
	this.salaire = 0;
}

public String getDiplome(){
	return this.diplome;
}

public float getSalaire(){
	return this.salaire;
}

public void setDiplome(String pdiplome){
	this.diplome = pdiplome;
}

public void setsalaire(int salaire){
	this.salaire = salaire;
}

public void saisir(){
	super.saisir();
	System.out.println("Veuillez saisir son diplome :");
	this.diplome = this.sc.nextLine();
	System.out.println("Veuillez saisir son salaire :");
	this.salaire = this.sc.nextFloat();
}

public void afficher(){
	super.afficher();
	System.out.println("Diplome :"+this.diplome);
	System.out.println("Salaire:"+this.salaire);
}

}

