package com.ldav.clase4;

public abstract class Unit {

    protected int health;
    protected int damage;
    protected int maximunRange;
    protected Position position;

    public void attack(Unit other) {
        if (this.canAtack(other)) {
            other.reciveDamage(this.damage);
        }
    }

    private boolean canAtack(Unit other) {
        return this.isAlive() && this.isInRange(other);
    }

    private boolean isInRange(Unit other) {
        return this.position.distanceTo(other.position) <= this.maximunRange;
    }

    private boolean isAlive() {
        return this.health > 0;
    }

    private void reciveDamage(int damage) {
        this.health = Math.max(health - damage, 0);
    }

    public int getHealth() {
        return this.health;
    }

}
