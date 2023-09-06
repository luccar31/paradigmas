package com.ldav.clase4;

public class Position {
    private final double x;
    private final double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Position other){
        return Math.hypot(other.x - this.x, other.y - this.y);
    }

}
