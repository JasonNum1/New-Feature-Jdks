public class NestedRecordPatterns {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(new ColoredPoint(new Point(1, 2), Color.RED),
                new ColoredPoint(new Point(3, 4), Color.BLUE));
        printColorOfUpperLeftPoint(r);
    }

    /**
     * Point记录
     * @param x
     * @param y
     */
    record Point(int x, int y) {
    }

    /**
     * Color枚举
     */
    enum Color {RED, GREEN, BLUE}

    /**
     * ColoredPoint记录
     * @param p
     * @param c
     */
    record ColoredPoint(Point p, Color c) {
    }

    /**
     * Rectangle记录
     * @param upperLeft
     * @param lowerRight
     */
    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {
    }

    /**
     * 无嵌套
     * @param r
     */
    static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.c());
        }
    }

    /**
     * record嵌套
     * @param r
     */
    static void printColorOfUpperLeftPoint(Rectangle r) {
        if (r instanceof Rectangle(
                ColoredPoint(Point p, Color c),
                ColoredPoint lr
        )) {
            System.out.println(c);
        }
    }

    /**
     * 优化record嵌套
     * @param r
     */
    static void printXColordOfUpperLeftPointWithPatterns(Rectangle r) {
        if (r instanceof Rectangle(
                ColoredPoint(Point(var x, var y), var c),
                var lr
        )) {
            System.out.println("Upper-left corner: " + x);
        }
    }
}
