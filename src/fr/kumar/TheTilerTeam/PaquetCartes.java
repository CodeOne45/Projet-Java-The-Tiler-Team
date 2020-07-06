package fr.kumar.TheTilerTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author KUMAR Aman Et ROBALO RODRIGUES Flavio GP-106
 *
 */

public class PaquetCartes {
    private final int nbCartes = 33;
    private ArrayList<Character> carreauTireParCarte;
    private boolean écarté = false;

    /*Enum cartes*/

    private enum Cartes{
        R(5,9),
        B(4,9),
        T1(1,5),
        T2(2,5),
        T3(3,5),
        ;

        private int code;
        private int totalCartes;

        Cartes(int code, int totalCartes) {
            this.code = code;
            this.totalCartes = totalCartes;
        }

        public int getNom() {
            return this.code;
        }

        public int getNbRep() {
            return this.totalCartes;
        }

    }

    //Piles des cartes
    private LinkedList<Integer> paquet ;

    public PaquetCartes(){
        paquet = new LinkedList<>();
        carreauTireParCarte = new ArrayList<Character>();
        for (Cartes c : Cartes.values()) {
            for (int i = 0; i < c.totalCartes; i++)
                paquet.add(c.code);
        }
        Collections.shuffle(paquet);
    }

    /**
     * Methose permettant de tirer une carte du paquer
     * @return int retoune le code associé a chaque carte
     */
    public int cartesTiré(){

        //Vérification si la pile est bien rempli
        assert(!this.paquet.isEmpty());
        int carteTiré2 = paquet.getLast();
        paquet.removeLast();
        if(!paquetEstVide() )
            return carteTiré2;
        else{
            System.out.println("Il n'existe aucun carreau qui coorespond à la carte tiré, donc la carte a été écarté.");
            System.out.println("Voici la nouvelle carte:");
            carteTiré2 = paquet.getLast();
            paquet.removeLast();
            return carteTiré2;
        }

    }

    /**
     * Méthode permettant de vérifier si le paquet est vide
     * @return boolean retoune TRUE si paquet vide
     */
    public boolean paquetEstVide(){
        return this.paquet.isEmpty();
    }

    /**
     * Méthode permettant de comparer si le carreau sasie coorespond bien à la carte tiré
     * @param idCrreau lettre associé au carreau
     * @return boolean TRUE si le carreau vérifie la condition du carte
     */
    public boolean comparerCarreauEtCarte(char idCrreau){
        boolean bonSaisie = false;
        for(int i = 0; i < carreauTireParCarte.size();i++){
            if(carreauTireParCarte.get(i) == idCrreau)
                bonSaisie = true;
        }
        return bonSaisie;
    }

    public boolean écarterCarte(){
        return this.écarté;
    }

    /**
     *Méthode renvoie la carte tiré
     * @return String renvoie la carte tiré sous forme d'une chaine de caractère
     */
    public String getStringCartes(){
        String s = " ";
        int code = this.paquet.getLast();
        switch (code){
            case 5:
                s+= "La carte tiré est Rouge";
                break;
            case 4:
                s+= "La carte tiré est Blue";
                break;
            case 3:
                s+= "La carte tiré est de Taille 3";
                break;
            case 2:
                s+= "La carte tiré est de Taille 2";
                break;
            case 1:
                s+= "La carte tiré est de Taille 1";
                break;
            default:
                break;
        }
        return s;
    }

    /**
     * Méthode permettant d'afiicher toutes les carreaux  qui correspond à une carte
     * @param carte code de chaque carte (1 = taille 1, 2 = taille 2 ... 4 = blue...)
     * @param t TasDeCarreau contient toutes les carreuc non-posé
     */
    public String toString(int carte, TasDeCarreau t) {
        int maxHeight = -1;
        String s = "";

        for (Carreau p : t.tasCarreau) {
            if (p.getHauteurCarreau() > maxHeight) {
                maxHeight = p.getHauteurCarreau();
            }
        }

        for (int i = maxHeight; i > 0; i--) {
            for (Carreau p : t.tasCarreau) {
                if(p.getCouleur() == carte && !p.carreauEstDéjaPossé()){
                    this.carreauTireParCarte.add(p.getIdCarreau());
                    if (p.getHauteurCarreau() < i) {
                        s += "  ".repeat(p.getLargeurCarreau());
                    } else {
                        s += (" " + p.getIdCarreau()).repeat(p.getLargeurCarreau());
                    }
                    s += "  ";
                }
                else if((p.getLargeurCarreau() == carte || p.getHauteurCarreau() == carte) && !p.carreauEstDéjaPossé()){
                    this.carreauTireParCarte.add(p.getIdCarreau());
                    if (p.getHauteurCarreau() < i) {
                        s += "  ".repeat(p.getLargeurCarreau());
                    } else {
                        s += (" " + p.getIdCarreau()).repeat(p.getLargeurCarreau());
                    }
                    s += "  ";
                }
                else {
                    this.écarté = true;
                }
            }
            s += "\n";
        }



        return  s;
    }
}
