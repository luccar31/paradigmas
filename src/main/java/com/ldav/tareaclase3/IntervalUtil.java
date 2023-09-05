package com.ldav.tareaclase3;

public final class IntervalUtil {
    public static boolean isInfinity(double number){
        return number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY;
    }

    public static Interval universalInterval(){
        return OpenedInterval.createFrom(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}
