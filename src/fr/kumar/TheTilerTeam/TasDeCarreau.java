package fr.kumar.TheTilerTeam;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author KUMAR Aman Et ROBALO RODRIGUES Flavio GP-106
 *
 */

public class TasDeCarreau {
    public ArrayList<Carreau> tasCarreau;

    public TasDeCarreau(){

        tasCarreau = new ArrayList<>(Arrays.asList(
           new Carreau(Pieces.a.getLetter(),Pieces.a.getHeight(),Pieces.a.getWidth(),Pieces.a.getColor()),
                new Carreau(Pieces.x.getLetter(),Pieces.x.getHeight(),Pieces.x.getWidth(),Pieces.x.getColor()),
                new Carreau(Pieces.x2.getLetter(),Pieces.x2.getHeight(),Pieces.x2.getWidth(),Pieces.x2.getColor()),
                new Carreau(Pieces.b.getLetter(),Pieces.b.getHeight(),Pieces.b.getWidth(),Pieces.b.getColor()),
                new Carreau(Pieces.c.getLetter(),Pieces.c.getHeight(),Pieces.c.getWidth(),Pieces.d.getColor()),
                new Carreau(Pieces.d.getLetter(),Pieces.d.getHeight(),Pieces.d.getWidth(),Pieces.d.getColor()),
                new Carreau(Pieces.e.getLetter(),Pieces.e.getHeight(),Pieces.e.getWidth(),Pieces.e.getColor()),
                new Carreau(Pieces.f.getLetter(),Pieces.f.getHeight(),Pieces.f.getWidth(),Pieces.f.getColor()),
                new Carreau(Pieces.g.getLetter(),Pieces.g.getHeight(),Pieces.g.getWidth(),Pieces.g.getColor()),
                new Carreau(Pieces.h.getLetter(),Pieces.h.getHeight(),Pieces.h.getWidth(),Pieces.h.getColor()),
                new Carreau(Pieces.i.getLetter(),Pieces.i.getHeight(),Pieces.i.getWidth(),Pieces.i.getColor()),
                new Carreau(Pieces.A.getLetter(),Pieces.A.getHeight(),Pieces.A.getWidth(),Pieces.A.getColor()),
                new Carreau(Pieces.B.getLetter(),Pieces.B.getHeight(),Pieces.B.getWidth(),Pieces.B.getColor()),
                new Carreau(Pieces.C.getLetter(),Pieces.C.getHeight(),Pieces.C.getWidth(),Pieces.C.getColor()),
                new Carreau(Pieces.D.getLetter(),Pieces.D.getHeight(),Pieces.D.getWidth(),Pieces.D.getColor()),
                new Carreau(Pieces.E.getLetter(),Pieces.E.getHeight(),Pieces.E.getWidth(),Pieces.E.getColor()),
                new Carreau(Pieces.F.getLetter(),Pieces.F.getHeight(),Pieces.F.getWidth(),Pieces.F.getColor()),
                new Carreau(Pieces.G.getLetter(),Pieces.G.getHeight(),Pieces.G.getWidth(),Pieces.G.getColor()),
                new Carreau(Pieces.H.getLetter(),Pieces.H.getHeight(),Pieces.H.getWidth(),Pieces.H.getColor()),
                new Carreau(Pieces.I.getLetter(),Pieces.I.getHeight(),Pieces.I.getWidth(),Pieces.I.getColor())



                ));
    }

    /**
     * Mérhode permettant de savoir si tous les carreaux ont été possé.
     * @return bollean TRUE si tas de carreaux est vide.
     */
    public boolean estVide(){
        boolean vide = true;
        for (Carreau c:tasCarreau) {
            if(!c.carreauEstDéjaPossé()){
                vide = false;
                break;
            }
        }
        return vide;
    }

    /**
     * Methode permettant d'enlever un carreau du tasCarreau
     * @param c Carreau a supprimer
     */
    public void enleverCarreau(Carreau c){
        this.tasCarreau.remove(c);
    }

    /**
     * Méthode permettant de savoir le nombre de carreaux qui sont pas encore été possé
     * @return int nombre de carreau non possé
     */
    public int nbCarreauxNonPosés(){
        return this.tasCarreau.size();
    }

}
