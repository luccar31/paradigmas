package com.ldav.tareaclase3;

import static com.ldav.tareaclase3.IntervalUtil.isInfinity;

public abstract class Interval implements Comparable<Interval> {
    protected final double start;
    protected final double end;

    protected Interval(double start, double end) {
        if (start > end) {
            throw new IllegalArgumentException("Start can't be greater than end!");
        }
        this.start = start;
        this.end = end;
    }

    public boolean contains(Interval other) {
        return this.equals(other) || this.containsInternal(other);
    }

    abstract protected boolean containsInternal(Interval other);

    abstract public boolean contains(double number);

    abstract public boolean intersecs(Interval other);

    public Interval shift(double number){
        if(isInfinity(number)) throw new IllegalArgumentException("Can't shift interval by infinite amount!");
        return createConcreteInterval(this.start + number, this.end + number);
    };

    abstract protected Interval createConcreteInterval(double start, double end);

    @Override
    public int compareTo(Interval other) {
        if(this.equals(other)) return 0;
        //si el inicio de este es menor que del otro (return -1)
        if (this.start < other.start) return -1;

        //si el inicio de este es mayor que el del otro (return 1)
        if (this.start > other.start) return 1;

        //a esta altura, se compara por final porque el inicio el igual
        //si el final de este es menor que del otro (return -1)
        if(this.end < other.end) return -1;
        //si el final de este es mayor que el del otro (return 1)
        if(this.end > other.end) return 1;

        return resolveComparison();
    }

    abstract protected int resolveComparison();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Interval that = (Interval) o;

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
