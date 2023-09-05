package com.ldav.tareaclase3;

import static com.ldav.tareaclase3.IntervalUtil.isInfinity;

public class ClosedInterval extends AbstractInterval {

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
        return isAfterOrAtStart(other.getStart()) && isBeforeOrAtEnd(other.getEnd());
    }

    @Override
    public boolean contains(double number) {
        return isAfterOrAtStart(number) && isBeforeOrAtEnd(number);
    }

    @Override
    public boolean contains(Interval other) {
        return this.equals(other) || this.containsInternal(other);
    }

    @Override
    public boolean intersecs(Interval other) {
        return false;
    }

    @Override
    public ClosedInterval shift(double number) {
        if(isInfinity(number)) throw new IllegalArgumentException("Can't shift interval by infinite amount!");
        return ClosedInterval.createFrom(this.start + number, this.end + number);
    }

    @Override
    public int compareTo(Interval o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ClosedInterval)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
