package com.ldav.clase4;

public class Archer extends Unit {
    public Archer(Position position) {
        this.position = position;
        this.health = 35;
        this.damage = 5;
        this.maximunRange = 20;
    }
}
