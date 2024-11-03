package info.romeosierra.baleb.math;

public class Vec2 {
    private double x, y;
    public <T extends Number> Vec2(T x, T y) {
        this.x = (double) x;
        this.y = (double) y;
    }
    public Vec2() {
        this.x = 0.0d;
        this.y = 0.0d;
    }
    public Vec2(Vec2 v) {
        x = v.x;
        y = v.y;
    }
    public <T> void  setX(T x) {
        this.x = (double) x;
    }
    public <T> void  setY(T y) {
        this.y = (double) y;
    }
    public <T> void  setW(T x) {
        this.x = (double) x;
    }
    public <T> void  setH(T y) {
        this.y = (double) y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double getW() {
        return x;
    }
    public double getH() {
        return y;
    }
    public <T> void add(T x, T y ) {
        this.x += (double) x;
        this.y += (double) y;
    }
    public void add(Vec2 v) {
        x += this.x;
        y += this.y;
    }
    public static Vec2 Add(Vec2 v1, Vec2 v2) {
        return new Vec2(v1.x+v2.x, v1.y+v2.y);
    }
}
