package Lab8;

class Point {
    private int x, y;
    private String a, b;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.a = "test";
        this.b = "another";
    }

    public static void main(String[] args)  {
        Point point = new Point(3, 4);
        Debug.fields(point);
    }
}
