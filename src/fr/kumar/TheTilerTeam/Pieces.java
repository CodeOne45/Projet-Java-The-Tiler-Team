package fr.kumar.TheTilerTeam;

/**
 *
 * @author KUMAR Aman Et ROBALO RODRIGUES Flavio GP-106
 *
 */

public enum Pieces {
    /*
     * Code couleur 4 --> Blue et 5--> Rouge
     */
    x('x', 1, 3,0),
    x2('x', 3, 1,0),
    a('a', 1, 1,4),
    b('b', 1, 2,4),
    c('c', 2, 1,4),
    d('d', 2, 2,4),
    e('e', 1, 3,4),
    f('f', 3, 1,4),
    g('g', 2, 3,4),
    h('h', 3, 2,4),
    i('i', 3, 3,4),
    A('A', 1, 1,5),
    B('B', 1, 2,5),
    C('C', 2, 1,5),
    D('D', 2, 2,5),
    E('E', 1, 3,5),
    F('F', 3, 1,5),
    G('G', 2, 3,5),
    H('H', 3, 2,5),
    I('I', 3, 3,5);


    private char letter;
    private int width;
    private int height;
    private int couleur;

    Pieces(char letter, int width, int height, int couleur) {
        this.letter = letter;
        this.width = width;
        this.height = height;
        this.couleur = couleur;
    }

    public char getLetter() {
        return this.letter;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getColor() {
        return this.couleur;
    }

}
