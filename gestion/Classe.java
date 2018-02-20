package gestion;

import java.util.Scanner;
import java.io.IOException;


public class Classe {
	private String nom;
	private int salle;
	private String niveau;
	private Enfant eleve[] = new Enfant[30];
	private Enseignant prof = new Enseignant();
	private int nombreEleve = 0;
	private Scanner sc = new Scanner(System.in);

	public Classe()
	{
		this.nom= "" ;
		this.salle= 0;
		this.niveau= "";
	}
	
        public Classe(String nom , int salle , String niveau )
	{
		this.nom=nom;
		this.salle= salle;
		this.niveau= niveau;
	}
	public String getnom(){
		 return this.nom;
	}
	public int getsalle(){
		 return this.salle ;
	}
	public String getniveau(){
		 return this.niveau ;
	}
	public void setnom(String nom){
		 this.nom = nom ;
	}
	public void setsalle(int salle){
		 this.salle = salle ;
	}
	public void setniveau(String pniveau){
		 this.niveau = pniveau ;
	}
	
	public void saisir(){
		System.out.println("Veuillez saisir le nom de la Classe :");
		this.nom = this.sc.nextLine();
		System.out.println("Veuillez saisir le numero de la salle pour cette classe :");
		this.salle = this.sc.nextInt();
		this.sc.nextLine();
		System.out.println("Veuillez saisir votre niveau :");
		this.niveau = this.sc.nextLine();
                System.out.println("Information sur le professeur de cette classe");
		this.prof.saisir();
                int choix =0;
                System.out.println("voulez vous saisir des éleves 1: Oui /2: Non");
                choix = sc.nextInt();
                this.sc.nextLine();
                if(choix==1)
                    this.ajouter();	
                }

	
	public void ajouter()
	{
		if (this.nombreEleve < 30)
		{
                    int choix = 0 ;
                    do
                    {
			Enfant eleve = new Enfant();
			eleve.saisir();
			this.eleve[this.nombreEleve] = eleve;
			this.nombreEleve++;
			System.out.println("L'enfant a bien été ajouté");
                        System.out.println("Continuez? 1: Oui /2: Non");
			choix = sc.nextInt();
                        this.sc.nextLine();
			}while(choix != 2);
		}
		else
		System.out.println("La classe est pleine");
		
		
		System.out.flush();
	}	
		
	public void afficher()
	{
		System.out.println("Nom de la classe :"+this.nom);
		System.out.println("La salle est :"+this.salle);
		System.out.println("Votre niveau :"+this.niveau);
		System.out.println("Le professeur est :");
		this.prof.afficher();
                this.afficherTout();
	}
	
	public void afficherTout(){
		System.out.println("La classe est composée de :");
		for (int i = 0 ; i < this.nombreEleve; i++){
			this.eleve[i].afficher();
		}
          

	}
        
       
	public void effacer()
	{
                        this.afficherTout();
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("Saisir l'id de l'enfant à supprimer :");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreEleve && trouve == false){
				if(id == this.eleve[i].getid())
					trouve = true; 
				else 
					i++;
			}
			if(trouve==true)
			{
				System.out.println("L'enfant a ete supprimé");
				this.eleve[i] = this.eleve[this.nombreEleve-1];
				this.nombreEleve--;
			}
			else
				System.out.println("Personne ne correspond");
		}
		public void trouver()
		{
                        this.afficherTout();
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("Saisir l'id de l'enfant à trouver :");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreEleve && trouve == false)
			{
				if(id == this.eleve[i].getid())
					trouve = true; 
				else
					i++;
			}
				if(trouve == false)
					System.out.println("Personne ne correspond");
				else{
					this.eleve[i].afficher();
				}
		}
                
                public void afficheTuteur()
                {
                    System.out.println("Les tuteurs de la classe sont :");
                    for (int i = 1 ; i < this.nombreEleve; i++){
                        System.out.println(this.eleve[i].getTuteur());
                    }
                }
                
                public void MoyenneAge()
                {
                    int totalAge = 0;
                    for (int i = 0 ; i < this.nombreEleve; i++)
                    {
                        totalAge += this.eleve[i].getAge();
                    }
                    System.out.println("La Moyenne d'age est" + totalAge/this.nombreEleve);
                }
              
                public void menu()
                {
                        int select = 0; 
                        do{
                                System.out.println("****** MENU CLASSE ********");
                                System.out.println("1: Ajouter un eleve");
                                System.out.println("2: Trouvez un eleve");
                                System.out.println("3: Saisir un eleve");
                                System.out.println("4: Supprimer un eleve");
                                System.out.println("5: La moyenne d'age de la classe");
                                System.out.println("6: Les tuteur de la classe ");
                                System.out.println("0: Quitter");
                                System.out.println("> :");
                                select = this.sc.nextInt();
                                this.sc.nextLine();


                                switch (select)
                                {
                                        case 1 : this.ajouter(); break;
                                        case 2 : this.trouver(); break;
                                        case 3 : this.saisir(); break;
                                        case 4 : this.effacer(); break;
                                        case 5 : this.MoyenneAge();break;
                                        case 6 : this.afficheTuteur();break;
                                        
                                }
                        }while(select!=0);	
                }
}


		
