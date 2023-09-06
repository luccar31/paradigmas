package com.ldav.tareaclase3;

public class OpenedInterval extends Interval {
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

    @Override
    protected boolean containsInternal(Interval other) {
        return isAfterStart(other.end) && isBeforeEnd(other.end);
    }

    @Override
    public boolean intersecs(Interval other) {
        return false;
    }

    @Override
    protected Interval createConcreteInterval(double start, double end) {
        return OpenedInterval.createFrom(start, end);
    }

    @Override
    public int compareTo(Interval other) {
        return 0;
    }

    @Override
    protected int resolveComparison() {
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OpenedInterval)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "(" + start + ";" + end + ")";
    }

    private boolean isBeforeEnd(double otherEnd) {
        return Double.compare(otherEnd, this.end) < 0;
    }

    private boolean isAfterStart(double otherStart) {
        return Double.compare(otherStart, this.start) > 0;
    }
}
