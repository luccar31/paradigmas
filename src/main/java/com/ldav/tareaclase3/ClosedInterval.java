package com.ldav.tareaclase3;

import static com.ldav.tareaclase3.IntervalUtil.isInfinity;

public class ClosedInterval extends Interval {

    private ClosedInterval(double start, double end) {
        super(start, end);
    }

    public static ClosedInterval createFrom(double start, double end) {
        if (isInfinity(start) || isInfinity(end)) {
            throw new IllegalArgumentException("Closed intervals must have defined ends. Not infinity!");
        }
        return new ClosedInterval(start, end);
    }

    @Override
    protected boolean containsInternal(Interval other) {
        return isAfterOrAtStart(other.start) && isBeforeOrAtEnd(other.end);
    }

    @Override
    public boolean contains(double number) {
        return isAfterOrAtStart(number) && isBeforeOrAtEnd(number);
    }

    @Override
    public boolean intersecs(Interval other) {
        return false;
    }

    @Override
    protected Interval createConcreteInterval(double start, double end) {
        return ClosedInterval.createFrom(start, end);
    }

    @Override
    protected int resolveComparison() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ClosedInterval)) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "[" + start + ";" + end + "]";
    }

    private boolean isBeforeOrAtEnd(double otherEnd) {
        return Double.compare(otherEnd, this.end) <= 0;
    }

    private boolean isAfterOrAtStart(double otherStart) {
        return Double.compare(otherStart, this.start) >= 0;
    }
}
