package gestion;

import java.util.Scanner;


public  final class Directeur extends Personne {
    
    private String directeur;
    private Scanner sc = new Scanner(System.in);
		
		public Directeur()
		{
			this.directeur= "" ;

		}
		public void saisir(){
                        super.saisir();
			System.out.println("Veuillez saisir le directeur de votre ecole  :");
			this.directeur = this.sc.nextLine();

                }
		public void afficher()
		{
			System.out.println("Votre directeur :"+this.directeur);
		}
                
	
	}