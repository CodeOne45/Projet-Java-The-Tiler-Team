package fr.kumar.TheTilerTeam;
import java.util.Scanner;

/**
 *
 * @author KUMAR Aman Et ROBALO RODRIGUES Flavio GP-106
 *
 */

public class Appli {

    public static void main(String[] arg) {
        boolean gameOver = false;
        boolean carreauPlacé = false;
        int nbCarteEcarté = 0;
        PaquetCartes c = new PaquetCartes();
        TasDeCarreau p = new TasDeCarreau();
        Mur m = new Mur(p);


        Scanner sc = new Scanner(System.in);
        char Careau = ' ';
        String choix = " ";
        int ligne = 0;
        int colonne = 0;
        do {
            System.out.println();
            System.out.println("| Vous pouvez soit stoper la partie en saisissant 'stop' |");
            System.out.println( "| Soit écarter la carte si vous ne trouvez pas de solurion: 'next' |");
            System.out.println("| Soit placer un carreau en saisissant: Lettre Ligne Colonne |");
            System.out.println();

            System.out.println(m);
            System.out.println();
            System.out.println(c.getStringCartes());
            int carte = c.cartesTiré();
            System.out.println();
            System.out.println(" Voici les carreaux corespondant au carte tiré:");
            System.out.print(c.toString(carte,p));

            System.out.print("Votre choix:");

            /*do{

            }while(choix != "stop" || choix != "next" || !sasieCorrecte());*/
            choix = sc.next();

            if(choix.equals("stop")){
                gameOver = true;
            }

            if(choix.equals("next") ){
                c.cartesTiré();
                nbCarteEcarté++;

            }

            if(sasieCorrecte(choix)){
                Careau = choix.charAt(0);
                ligne = sc.nextInt();
                colonne = sc.nextInt();
                if(c.comparerCarreauEtCarte(Careau)){
                    carreauPlacé = m.placerCarreau( ligne, colonne, Careau,p);

                    if(!carreauPlacé){
                        System.out.println("Le carreau sasie n'a pas été palcé car il ne respecte pas les régle de jeu, veuillez sasir un autrre carreau ou choisri next ou stop!");
                        do {
                            choix = sc.next();
                            if(choix.equals("stop")){
                                gameOver = true;
                            }

                            if(choix.equals("next")){
                                c.cartesTiré();
                                nbCarteEcarté++;
                            }
                            if(sasieCorrecte(choix)){
                                Careau = choix.charAt(0);
                                ligne = sc.nextInt();
                                colonne = sc.nextInt();
                                carreauPlacé = m.placerCarreau( ligne, colonne, Careau,p);
                            }

                        }while(!carreauPlacé);

                        carreauPlacé = false;
                    }
                }
                else{
                    do{
                        System.out.println("Le carreau sasie ne correspond à la carte tiré, Sasiez a nouveau le carreau a placé et ses coordonnées:");
                        Careau = choix.charAt(0);
                        ligne = sc.nextInt();
                        colonne = sc.nextInt();
                        m.placerCarreau( ligne, colonne, Careau,p);
                    }while (!c.comparerCarreauEtCarte(Careau));

                }
            }

            if(p.estVide() || c.paquetEstVide())
                gameOver = true;

            System.out.println();
            System.out.println(( m.compteNbLigneCompléte() - (p.nbCarreauxNonPosés() + nbCarteEcarté) )+ " points ("+ m.getScore()
                    + " niveaux complets, " + " " + p.nbCarreauxNonPosés() + " carreaux non posés, " +  nbCarteEcarté + " cartes écaartées");


        } while (!gameOver);


    }

    public static boolean sasieCorrecte(String s){
        boolean bonSasie = false;
        if(s.length() <=6 ){
            char ch = s.charAt(0);
            for(Pieces p:Pieces.values()){
                if(ch == p.getLetter())
                    bonSasie = true;
            }
        }
        return bonSasie;
    }


}
