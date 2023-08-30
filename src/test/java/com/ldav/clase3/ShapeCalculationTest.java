package com.ldav.clase3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCalculationTest {
    
    @Test
    void isInnerBiggerThatOuter(){
        Circle inner = new Circle(1.0);
        Circle outer = new Circle(2.0);

        assertFalse(inner.compareTo(outer) > 0);
    }

    @Test
    void canCreateInvalidCrown(){
        Circle inner = new Circle(1.0);
        Circle outer = new Circle(2.0);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Crown crown = new Crown(outer, inner);
        });

        assertEquals("Inner circle is bigger than outer", thrown.getMessage());
    }
}
