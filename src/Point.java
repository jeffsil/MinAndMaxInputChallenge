public class Point {

    private int x;
    private int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        Point zero = new Point(0,0);
        return distance(zero);
    }

    public double distance(int x, int y) {
        Point pt = new Point(x, y);
        return distance(pt);

    }

    public double distance(Point another) {
        return ( Math.sqrt( (another.x - this.x) * (another.x - this.x) + (another.y - this.y) * (another.y - this.y) ) );
    }

    public static void main(String[] args) {
        Point first = new Point(6,5);
        Point second = new Point(3,1);
        System.out.println("distance(0,0) = " +first.distance());
        System.out.println("distance(second) = " +first.distance(second));
    }
}
