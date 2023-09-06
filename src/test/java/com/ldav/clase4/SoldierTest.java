package com.ldav.clase4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoldierTest {

    @Test
    public void test() {
        Soldier s1 = new Soldier(new Position(1,1));
        Soldier s2 = new Soldier(new Position(0,1));
        Archer a1 = new Archer(new Position(20, 0));

        a1.attack(s1);
        s1.attack(a1);

        s1.attack(s2);

        Assertions.assertEquals(90, s2.getHealth());
        Assertions.assertEquals(95, s1.getHealth());
        Assertions.assertEquals(35, a1.getHealth());
    }
}
