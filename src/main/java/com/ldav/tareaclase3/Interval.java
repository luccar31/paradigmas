package com.ldav.tareaclase3;

public interface Interval {
    boolean contains(double number);

    boolean contains(Interval other);

    boolean intersecs(Interval other);
    /* // TODO: 4/9/23 consultar profes
    static Interval createFrom(double start, double end) {
        throw new IllegalStateException("Method implementation is MANDATORY!");
    }
     */

    Interval shift(double number);

    double getStart(); // TODO: 4/9/23 como evitar esto, me gustaria que dentro de las subclases se puedan acceder a otras implementaciones

    double getEnd();
}
