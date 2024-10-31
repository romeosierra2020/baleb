package info.romeosierra.baleb.math;

public class Vec2f {
    public float x,y;
    public Vec2f() {
        x = 0;
        y = 0;
    }
    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vec2f(Vec2f v) {
        x = v.x;
        y = v.y;
    }
}
