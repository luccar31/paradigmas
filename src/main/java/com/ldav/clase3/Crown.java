package com.ldav.clase3;

public class Crown implements TwoDimensionShape{
    private final Circle inner;
    private final Circle outer;

    public Crown(Circle inner, Circle outer) {
        if(inner.compareTo(outer) > 0){
            throw new IllegalArgumentException("Inner circle is bigger than outer");
        }
        this.inner = inner;
        this.outer = outer;
    }

    @Override
    public double getPerimeter() {
        return inner.getPerimeter() + outer.getPerimeter();
    }

    @Override
    public double getArea() {
        return outer.getArea() - inner.getArea();
    }
}
