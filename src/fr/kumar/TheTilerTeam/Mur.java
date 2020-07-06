package fr.kumar.TheTilerTeam;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author KUMAR Aman Et ROBALO RODRIGUES Flavio GP-106
 *
 */
public class Mur {
    private int nbLigneRemplis;
    private int score;
    private static final int LARGEUR = 5;
    private boolean ligneVide = true;

    private final String[] orient = new String[]{
            "Horiz - 1","Vertic - 1","Horiz - 5","Vertic - 5"
    };

    /*Grille de jeu*/
    private ArrayList<char []> grille = new ArrayList<char []>();

    public Mur(TasDeCarreau tc){
        grille.add(getLigneVide());
        int pN = this.positionCarreauNeutre();

        switch (pN){
            case 0:
                grille.add(getLigneVide());
                grille.get(1)[0] = 'x';
                grille.get(1)[1] = 'x';
                grille.get(1)[2] = 'x';
                for(Carreau c: tc.tasCarreau){
                    if(c.getIdCarreau() == 'x' && c.getLargeurCarreau() == 3){
                        c.pooserCarreau();
                        c.postionCarreau(1,0);
                    }
                }
                break;
            case 1:
                grille.add(getLigneVide());
                grille.add(getLigneVide());
                grille.add(getLigneVide());
                grille.get(1)[0] = 'x';
                grille.get(2)[0] = 'x';
                grille.get(3)[0] = 'x';
                for(Carreau c: tc.tasCarreau){
                    if(c.getIdCarreau() == 'x' && c.getLargeurCarreau() == 1){
                        c.pooserCarreau();
                        c.postionCarreau(1,0);
                    }
                }
                break;
            case 2:
                grille.add(getLigneVide());
                grille.get(1)[2] = 'x';
                grille.get(1)[3] = 'x';
                grille.get(1)[4] = 'x';
                for(Carreau c: tc.tasCarreau){
                    if(c.getIdCarreau() == 'x' && c.getLargeurCarreau() == 3){
                        c.pooserCarreau();
                        c.postionCarreau(1,2);
                    }
                }
                break;
            case 3:
                grille.add(getLigneVide());
                grille.add(getLigneVide());
                grille.add(getLigneVide());
                grille.get(1)[4] = 'x';
                grille.get(2)[4] = 'x';
                grille.get(3)[4] = 'x';
                for(Carreau c: tc.tasCarreau){
                    if(c.getIdCarreau() == 'x' && c.getLargeurCarreau() == 3){
                        c.pooserCarreau();
                        c.postionCarreau(1,4);
                    }
                }
                break;

        }
        for(Carreau c: tc.tasCarreau){
            if(c.getIdCarreau() == 'x' && !c.carreauEstDéjaPossé()){
                c.pooserCarreau();
                c.postionCarreau(10,10);
            }
        }
        this.nbLigneRemplis = this.grille.size();
        this.score = 0;

    }

    /**
     * Méthode prmettant d'obtenir la position du carreau neutre
     * @return int position du carreau
     */
    private int positionCarreauNeutre(){
        Random r = new Random();
        int indice = r.nextInt(orient.length );
        return indice;
    }

    /**
     * Méthode permettant de créer une ligne vide
     * @return char[] retoune un tableau de type char qui
     *          contient comme charactere " ".
     */
    private char[] getLigneVide() {
        char [] ligneVide = {' ',' ',' ',' ',' '};
        return ligneVide;
    }

    /**
     * Méthode permettant de compter nombre de lignes remplit
     * @return int ligne remplit du grille
     */
    public int compteNbLigneCompléte(){
        boolean ligneVide = false;
        for(int i = 0; i < LARGEUR; i++){
            if(this.grille.get(this.nbLigneRemplis - 1)[i] == ' '){
                ligneVide = true;
                break;
            }
        }
        if(!ligneVide)
            this.score++;

        return 5*this.score;
    }

    /**
     * Calculer le scoore en fonction du ligne du grille remplit
     * @return int score
     */
    public int getScore() {
        return score;
    }

    /**
     * Méthode permettant de placer un carreau dans la grille.
     * @param ligne int ligne sur la quel il faut placer le carreau
     * @param col   int collone sur la quel il faut placer le carreau
     * @param c     char le carreau a placé, désignié par son lettre
     * @param tc    TasCarreau qui contient les carreaux non possé
     * @return boolean retoune TRUE si le carreau a bien été possé
     */
    public boolean placerCarreau(int ligne, int col, char c, TasDeCarreau tc){
        boolean carreauPossé = false;
        for (Carreau p : tc.tasCarreau) {
            if(p.getIdCarreau() == c && !p.carreauEstDéjaPossé()
                    && this.toucherUnCarreau(this.grille.size()
                    - ligne,col - 1,p.getLargeurCarreau()))
            {

                this.agrendirMur(p.getHauteurCarreau(),p.carreauEstDéjaPossé());
                if(this.vérifeBasseDuCarreau(p.getLargeurCarreau(),this.grille.size() - ligne,col,tc)
                        && !this.pasCloner(p,this.grille.size() - ligne ,col,tc)){


                    if(this.placePourCarreau(ligne,col,p.getHauteurCarreau(),p.getLargeurCarreau())){
                        p.postionCarreau(this.grille.size() - ligne,col -1);
                        for(int k = this.grille.size() - ligne; k > (this.grille.size() - ligne) - p.getHauteurCarreau() ;k--){
                            for(int y = col - 1; y < (p.getLargeurCarreau() + col) - 1;y++ ){

                                this.grille.get(k)[y] = p.getIdCarreau();
                                p.pooserCarreau();
                                carreauPossé = true;

                            }
                        }

                        break;

                    }
                }

            }

        }

        return carreauPossé;
    }

    /**
     * Méthode permetatnt de savoir si les longeurs de deux carreaux est identique ou non
     * @param c       Carreau a posser
     * @param x       int coordonnés du carreau a pooser (ligne)
     * @param y       int coordonnés du carreau a pooser (collone)
     * @return        boolean TRUE si les deux ont la meme longueur sur des bords
     */
    private boolean pasCloner(Carreau c,int x ,int y,TasDeCarreau tc){
        boolean clone = false;

        for(Carreau d:tc.tasCarreau){
            if((d.carreauEstDéjaPossé() && d.getCoodx() == x)
                    && (d.getCoordy() == (y+c.getLargeurCarreau()) - 1 || (d.getCoordy() + d.getLargeurCarreau()) + 1 == y)){
                if(d.getHauteurCarreau() == c.getHauteurCarreau()){
                    clone = true;
                    break;
                }

            }
        }

        if(clone)
            System.out.println("Le carreau colone un autre carreau");
        return clone;
    }

    /**
     *Méthode permettant de savoir si la basse du carreau
     *n'est pas identique au largeur d'un carreau deja possé
     * @param largeur int largeur du carreau a posser
     * @param x       int coordonnés du carreau a pooser (ligne)
     * @param y       int coordonnés du carreau a pooser (collone)
     * @return        boolean FALSE si les deux ont la meme basse
     */
    private boolean vérifeBasseDuCarreau(int largeur, int x , int y,TasDeCarreau tc){
        boolean baseValide = true;
        if(x != this.grille.size() - 1){
            for (Carreau c: tc.tasCarreau){
                if(c.getCoordy() == y && c.getLargeurCarreau() == largeur && c.carreauEstDéjaPossé()){
                    baseValide = true;
                }
            }
        }

        if(!baseValide)
            System.out.println("Le carreau est sur une meme base que sa largeur ");

        return baseValide;
    }

    /**
     * Méthode permettant de savoir si il y des casses vides pour un le carreau à placer
     * @param ligne     int coordonnés du carreau a pooser
     * @param col       int coordonnés du carreau a pooser
     * @param hauteur   int hauteur de carreau à posser
     * @param largeur   int largeur de carreau à posser
     * @return          boolean TRUE si les casses du grille sont vide
     */
    private boolean placePourCarreau(int ligne, int col, int hauteur, int largeur){
        boolean placeCarreau = true;
        for(int k = this.grille.size() - ligne; k > (this.grille.size() - ligne) - hauteur ;k--){
            for(int y = col - 1; y < (largeur + col) - 1;y++ ){
                if(y < LARGEUR){
                    if(this.grille.get(k)[y] != ' '){
                        placeCarreau = false;
                        break;
                    }
                }
                else
                    placeCarreau = false;
            }
        }

        if(!placeCarreau)
            System.out.println("Le careau ne peut pas être placé car il n'a pas de place!");
        return  placeCarreau;
    }

    /**
     * Méthode pour vérifier si le carreau a posser se situe bien à coté d'un carreu déja possé.
     * @param x         int coordonnés du carreau a pooser (lignes)
     * @param y         int coordonnés du carreau a pooser (collone)
     * @param largeur   int largeur de carreau a posser
     * @return          boolean TRUE si le carreau touche bien un autre carreau
     */
    private boolean toucherUnCarreau(int x, int y, int largeur ){
        boolean toucher = false;
        if((y > 0 && y < LARGEUR ) && x != this.grille.size() - 1){
            if(this.grille.get(x)[y-1] != ' ' ){
                toucher = true;
            }
            else if(this.grille.get(x)[y+1] != ' ')
                toucher = true;
            else if(this.grille.get(x + 1)[y] != ' ')
                toucher = true;
        }
        if(y == 0 && x != this.grille.size() - 1){
            if(this.grille.get(x)[y+1] != ' ')
                toucher = true;
            else if(this.grille.get(x + 1)[y] != ' ')
                toucher = true;
        }
        if(y == LARGEUR - 1 && x != this.grille.size() - 1){
            if(this.grille.get(x)[y-1] != ' ')
                toucher = true;
            else if(this.grille.get(x + 1)[y] != ' ')
                toucher = true;
        }
        if(x == this.grille.size() - 1){
            if (y == 0){
              if(this.grille.get(x)[y+1] != ' ' || this.grille.get(x)[(y + largeur)] != ' ')
                  toucher = true;
            }
            else if(y == LARGEUR - 1){
                if(this.grille.get(x)[y-1] != ' '){
                    toucher = true;
                }
            }
            else{
                if(this.grille.get(x)[y-1] != ' ')
                    toucher = true;
                else if(this.grille.get(x)[y+1] != ' ')
                    toucher = true;
            }

            if(!toucher)
                System.out.println("Le carreau touche un autre carreau !");
        }
        return toucher;
    }

    /**
     * Méthode permettant de ajouter des lignes à grille en fonction d'hauteur de carreau à placer
     * @param h         int hauteur de carreau à placer
     * @param possé     boolean TRUE si le carreau a déja été possé
     */
    private void agrendirMur(int h,boolean possé){
        if (h >= this.nbLigneVide() ){
            if (!possé)
                for(int i = this.nbLigneVide() ; i < h ; i++){
                    this.grille.add(0, getLigneVide());
                }
        }
    }

    /**
     * Méthode permetant de savoir le nombre de ligne vide du grille
     * @return  int retourne nombre de lignes vide
     */
    private int nbLigneVide(){
        int cmpt = 0;
        for(int i = 1;i<this.grille.size();i++){
            for(int j =0; j<LARGEUR;j++){
                if(this.grille.get(i)[j] == ' '){
                    cmpt++;
                    j = LARGEUR + 1;
                }
            }
        }
        return cmpt;
    }

    /**
     * Envoyer la chaine de caractere du mur
     * @return  String chaine de caractere
     */
    public String  toString(){
        String s = "";
        for (int i = 0; i <grille.size(); i++){
            s += (grille.size() - i) +" ";
            for(int j = 0; j<LARGEUR;j++){
                s += (grille.get(i)[j] + "  ");
            }
            s += "\n";
        }

        s += " ";

        for(int j = 0; j<LARGEUR;j++){
            s += (" "+ (j+1)+" ");
        }
        return s;
    }
}

