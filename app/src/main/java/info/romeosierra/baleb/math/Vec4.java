package info.romeosierra.baleb.math;

public class Vec4 {
    private double x, y,z, w;
    public <T extends Number> Vec4(T x, T y, T z, T w) {
        this.x = (double) x;
        this.y = (double) y;
        this.z = (double) z;
        this.w = (double) w;
    }
    public Vec4() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
        this.w = 0.0d;
    }
    public Vec4(Vec4 v) {
        x = v.x;
        y = v.y;
        z = v.z;
        w = v.w;
    }

    public double getX() {
        return x;
    }

    public <T> void setX(T x) {
        this.x = (double) x;
    }

    public double getY() {
        return y;
    }

    public <T> void setY(T y) {
        this.y = (double) y;
    }

    public double getZ() {
        return z;
    }

    public <T> void setZ(T z) {
        this.z = (double) z;
    }

    public double getW() {
        return w;
    }

    public <T> void setW(T w) {
        this.w = (double) w;
    }
    public double getR() {
        return x;
    }

    public <T> void setR(T x) {
        this.x = (double) x;
    }

    public double getG() {
        return y;
    }

    public <T> void setG(T y) {
        this.y = (double) y;
    }

    public double getB() {
        return z;
    }

    public <T> void setB(T z) {
        this.z = (double) z;
    }

    public double getA() {
        return w;
    }

    public <T> void setA(T w) {
        this.w = (double) w;
    }

    public void reset() {
        x = 0.0d;
        y = 0.0d;
        z = 0.0d;
        w = 0.0d;
    }
}
