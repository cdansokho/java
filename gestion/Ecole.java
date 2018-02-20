package gestion;

import java.util.Scanner;


public class Ecole {
    
    private String nom ;
    private Classe classe[] = new Classe[20];
    private Directeur dirlo = new Directeur();
    private Enseignant prof = new Enseignant();
    private Classe cl = new Classe();
    public int nombreClasse = 0;
    private Scanner sc = new Scanner(System.in);
    
    
    public Ecole()
	{
		this.nom= "" ;

	}
	
        public Ecole(String nom)
	{
		this.nom=nom;
	}

    	public String getnom(){
		 return this.nom;
	}
        
        public void setnom(String nom){
		 this.nom = nom ;
	}
        
        public void saisir(){
		System.out.println("Veuillez saisir le nom de l'école :");
		this.nom = this.sc.nextLine();
                System.out.println("Saisir information du directeur : ");
                this.dirlo.saisir();
        }
        
        public void afficher()
	{
            
		System.out.println("Nom de l'école : "+this.nom);
                this.dirlo.afficher();
	}
          
         public void ajouter()
        {
            if (this.nombreClasse < 20)
            {
                    Classe classe = new Classe();
                    classe.saisir();
                    classe.menu();
                    this.classe[this.nombreClasse] = classe;
                    this.nombreClasse++;
                    System.out.println("La classe a bien été ajouté");
            }
            else
            {
                System.out.println("Il y a trop de classe dans l'école");
            }
        }
         
         public void effacer()
		{
				String nom = "";
				int i = 0;
				boolean trouve = false; 
				System.out.println("Saisir le nom de la classe à supprimer :");
				nom = this.sc.nextLine();
				this.sc.nextLine();
				while(i < this.nombreClasse && trouve == false){
					if(nom == this.classe[i].getnom())
						trouve = true; 
					else 
						i++;
				}
				if(trouve==true)
				{
					System.out.println("La classe a ete supprimé");
					this.classe[i] = this.classe[this.nombreClasse-1];
					this.nombreClasse--;
				}
				else
					System.out.println("Aucune classe ne correspond");
			}
         
         
		public void afficherTout()
                {
			this.afficher();
			System.out.println("La classe est composée de :");
			for (int i = 0 ; i < this.nombreClasse; i++){
				this.classe[i].afficher();
			}

                }
                
                public void trouver()
		{
                        this.afficherTout();
			int id;
			int i = 0;
			boolean trouve = false; 
			System.out.println("Saisir l'id de la classe à trouver :");
			id = this.sc.nextInt();
			this.sc.nextLine();
			while(i < this.nombreClasse && trouve == false)
			{
				if(nom == this.classe[i].getnom())
					trouve = true; 
				else
					i++;
			}
				if(trouve == false)
					System.out.println("Aucunne classe  ne correspond");
				else{
					this.classe[i].afficher();
				}
		}
                
                public void menu()
			{
					int select = 0; 
					do{
						System.out.println("****** MENU ECOLE ********");
						System.out.println("1: Saisir l'�cole");
                                                System.out.println("2: Afficher l'�cole");
						System.out.println("3: Ajouter une classe");
						System.out.println("4: Supprimer une classe");
						System.out.println("5: Afficher toutes les classes de l'ecole");
                                                System.out.println("Gerer les classe : ");
						System.out.println("0: Quitter");
						select = this.sc.nextInt();
						this.sc.nextLine();
						
						
						switch(select)
						{
                                                        case 1 : this.saisir();break;
							case 2 : this.afficher(); break;
							case 3 : this.ajouter(); break;
							case 4 : this.effacer(); break;
							case 5 : this.afficherTout(); break;
                                                        case 6 : this.cl.menu();break;
						}
					}while(select!=0);	
				}
}