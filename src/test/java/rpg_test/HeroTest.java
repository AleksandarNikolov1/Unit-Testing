package rpg_test;

import org.junit.Test;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class HeroTest {

    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "Gandalf";
    private Hero hero;


    @Test
    public void testAttackGainXPWhenTargetIsDead(){
        Target target = mock(Target.class);
        Weapon weapon = mock(Weapon.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(TARGET_XP);

        hero = new Hero(HERO_NAME, weapon);
        hero.attack(target);

        assertEquals(TARGET_XP, hero.getExperience());
    }
}
