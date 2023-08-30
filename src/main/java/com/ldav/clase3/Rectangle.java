package com.ldav.clase3;

public class Rectangle implements TwoDimensionShape {

    private final double base;
    private final double height;

    public Rectangle(double base, double height) {
        if(base <= 0 || height <= 0){
            throw new IllegalArgumentException("Neither side must not be less than o equal to zero.");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return (base + height) * 2;
    }

    @Override
    public double getArea() {
        return base * height;
    }
}
