package fr.kumar.TheTilerTeam;

import org.junit.Test;
import static org.junit.Assert.*;
public class CarreauTest {
    @Test
    public void test(){
        Carreau c = new Carreau('a',1,1,4);
        assertEquals(c.getHauteurCarreau(),1);
        assertEquals(c.getLargeurCarreau(),1);
        assertEquals(c.getIdCarreau(),'a');
    }
}