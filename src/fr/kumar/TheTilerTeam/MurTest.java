package fr.kumar.TheTilerTeam;


import org.junit.Test;

import static org.junit.Assert.*;

public class MurTest {
    @Test
    public void test(){
        TasDeCarreau t = new TasDeCarreau();
        Mur m = new Mur(t);
        assertTrue(m.getScore() == 0);
    }

}