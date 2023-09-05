package com.ldav.tareaclase3;

import static com.ldav.tareaclase3.IntervalUtil.isInfinity;

public class OpenedInterval extends AbstractInterval {
    private OpenedInterval(double start, double end) {
        super(start, end);
    }

    public static OpenedInterval createFrom(double start, double end) {
        return new OpenedInterval(start, end);
    }

    @Override
    public boolean contains(double number) {
        return isAfterStart(number) && isBeforeEnd(number);
    }

    private boolean isBeforeEnd(double otherEnd) {
        return Double.compare(otherEnd, this.end) < 0;
    }

    private boolean isAfterStart(double otherStart) {
        return Double.compare(otherStart, this.start) > 0;
    }

    @Override // TODO: 5/9/23 repeticion de codigo 
    public boolean contains(Interval other) {
        return this.equals(other) || this.containsInternal(other);
    }

    @Override
    protected boolean containsInternal(Interval other) {
        return isAfterStart(other.getStart()) && isBeforeEnd(other.getEnd());
    }

    @Override
    public boolean intersecs(Interval other) {
        return false;
    }

    @Override // TODO: 5/9/23 repeticion de codigo
    public OpenedInterval shift(double number) {
        if(isInfinity(number)) throw new IllegalArgumentException("Can't shift interval by infinite amount!");
        return OpenedInterval.createFrom(this.start + number, this.end + end);
    }

    @Override
    public int compareTo(Interval o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OpenedInterval)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
