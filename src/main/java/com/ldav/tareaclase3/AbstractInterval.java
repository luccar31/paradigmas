package com.ldav.tareaclase3;

public abstract class AbstractInterval implements Interval, Comparable<Interval> {
    protected final double start;
    protected final double end;

    protected AbstractInterval(double start, double end) {
        if (start > end) {
            throw new IllegalArgumentException("Start can't be greater than end!");
        }
        this.start = start;
        this.end = end;
    }

    abstract protected boolean containsInternal(Interval other);

    @Override
    public double getStart() {
        return start;
    }

    @Override
    public double getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractInterval that = (AbstractInterval) o;

        return Double.compare(start, that.start) == 0 && Double.compare(end, that.end) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(start);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(end);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
