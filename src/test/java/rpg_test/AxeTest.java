package rpg_test;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 20;

    private static final int TARGET_HEALTH = 15;
    private static final int TARGET_XP = 18;

    private Axe axe;
    private Dummy target;
    private Axe brokenAxe;

    @Before
    public void setUp(){
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        target = new Dummy(TARGET_HEALTH, TARGET_XP);
        brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    public void testAxeLosesDurabilityWhenAttack(){
        axe.attack(target);
        assertEquals("<some error message if failed>", AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenAxeShouldFail(){
        brokenAxe.attack(target);
    }
}
