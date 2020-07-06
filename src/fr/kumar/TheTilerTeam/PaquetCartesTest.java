package fr.kumar.TheTilerTeam;

import org.junit.Test;
import static org.junit.Assert.*;
public class PaquetCartesTest {
    @Test
    public void test(){
        PaquetCartes pc = new PaquetCartes();
        assertTrue(pc.paquetEstVide());
    }
}