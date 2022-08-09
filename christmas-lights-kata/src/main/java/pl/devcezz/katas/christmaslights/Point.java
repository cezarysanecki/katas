package pl.devcezz.katas.christmaslights;

import java.util.Objects;

record Point(int x, int y) {

    Point {
        if (x < 0) {
            throw new IllegalArgumentException("x cannot be negative");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y cannot be negative");
        }
    }

    static Point of(int x, int y) {
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
