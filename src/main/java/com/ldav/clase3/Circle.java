package com.ldav.clase3;

public class Circle implements TwoDimensionShape, Comparable<Circle> {
    private final double radius;
    public Circle(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("Radius must not be less than o equal to zero.");
        }
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public int compareTo(Circle circle){
        return this.radius > circle.radius ? 1 : this.radius < circle.radius ? -1 : 0;
    }
}
