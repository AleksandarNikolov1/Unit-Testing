package rpg_test;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 20;

    private static final String HERO_NAME = "Gandalf";

    private Dummy dummy;
    private Hero hero;
    private Axe axe;

    @Before
    public void setUp(){
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        hero = new Hero(HERO_NAME, axe);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked(){
        dummy.takeAttack(1);
        assertEquals(DUMMY_HEALTH - 1, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked(){
        dummy = new Dummy(0, 10);
        dummy.takeAttack(1);
    }

    @Test
    public void testDeadDummyCanGiveXP(){
        hero.attack(dummy); // check attack implementation
        assertEquals(DUMMY_XP, hero.getExperience());
    }

    @Test
    public void testActiveDummyCantGiveXP(){
        dummy = new Dummy(20, 20);
        hero.attack(dummy);
        assertEquals(0, hero.getExperience());
    }
}