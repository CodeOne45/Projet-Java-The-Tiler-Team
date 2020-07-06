package fr.kumar.TheTilerTeam;

import org.junit.Test;
import static org.junit.Assert.*;
public class TasDeCarreauTest {
    @Test
    public void test(){
        TasDeCarreau tc = new TasDeCarreau();
        assert(tc.nbCarreauxNonPosés() == 20);
        assertTrue(tc.estVide());
    }
}