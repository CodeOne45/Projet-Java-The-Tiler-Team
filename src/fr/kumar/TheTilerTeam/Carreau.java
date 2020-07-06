package fr.kumar.TheTilerTeam;

/**
 *
 * @author KUMAR Aman Et ROBALO RODRIGUES Flavio GP-106
 *
 */

public class Carreau {

    private char idCarreau;
    private int coodx,coordy;
    private int hauteurCarreau;
    private int largeurCarreau;
    private int couleur;
    private boolean possé = false;

    public Carreau(char idCarreau, int hauteurCarreau, int largeurCarreau, int couleur){
        this.idCarreau = idCarreau;
        this.hauteurCarreau = hauteurCarreau;
        this.largeurCarreau = largeurCarreau;
        this.couleur = couleur;
        this.coodx = this.coordy = -1;
    }

    /**
     * Methode permetant de initialiser les coordonnés d'un carreau
     * @param x int : la ligne
     * @param y int : la collone
     */
    public void postionCarreau(int x, int y){
        if(this.coodx != 0 && this.coordy !=0){
            this.coodx = x;
            this.coordy = y;
        }
    }

    /**
     * Geter
     * @return int : retoune la ligne
     */
    public int getCoodx(){
        return this.coodx;
    }

    /**
     * Geter
     * @return int : retoune la collone
     */
    public int getCoordy(){
        return this.coordy;
    }

    /**
     * Geter
     * @return retourne la lettre qui correspond à carreau
     */
    public char getIdCarreau() {
        return this.idCarreau;
    }

    /**
     * Getter
     * @return retourne l'hauteur qui correspond à carreau
     */
    public int getHauteurCarreau() {
        return this.hauteurCarreau;
    }

    /**
     * Getter
     * @return int retourne la largeur qui correspond à carreau
     */
    public int getLargeurCarreau() {
        return this.largeurCarreau;
    }

    /**
     * Getter
     * @return int retourne la couleur qui correspond à carreau
     */
    public int getCouleur() {
        return this.couleur;
    }

    /**
     * Méthode pemettant de savoir si le carreau a déja été possé da sle mour
     * @return boolean TRUE si carreau est deja possé
     */
    public boolean carreauEstDéjaPossé(){
        return this.possé;
    }

    /**
     * Méthode permet de posser le carreau. ²
     */
    public void pooserCarreau(){
        this.possé = true;
    }

}
