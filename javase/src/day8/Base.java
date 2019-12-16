package day8;

/**
 * @author Bmo
 * @date 2019/12/4 14:49
 */
public class Base {
    int w, x, y, z;
    public Base(int a, int b) {
        this.x = a;
        this.y = b;
    }
    public Base(int a, int b, int c, int d) {
//        Base(a, b);
        this(a, b);
        x = a; z = b;
        this.w = c;
        this.z = d;
    }
}
