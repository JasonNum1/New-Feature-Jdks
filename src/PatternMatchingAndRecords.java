public class PatternMatchingAndRecords {
    public static void main(String[] args) {
        //record和class功能类似,但不能单独定义,以内部类的形式存在,作用在instanceof或与switch结合使用
        method1(new Point(1, 2));
    }

    /**
     * 定义测试方法
     * @param obj 被验证的对象
     */
    static void method1(Object obj) {
        if (obj instanceof Point p) {
            int x = p.i();
            int y = p.j();
            System.out.println(x + y);
        }
    }

    /**
     * 定义Point记录
     * @param i
     * @param j
     */
    record Point(int i, int j) {
        public int i() {
            return i;
        }

        public int j() {
            return j;
        }
    }
}
