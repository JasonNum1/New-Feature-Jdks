import java.util.Arrays;

/**
 * 封闭类反射
 */
public class SealedRelection {
    /**
     * 定义封闭接口i,允许a,b,c继承
     */
    sealed interface I permits A,B,C{
    }

    /**
     * 定义记录类实现接口i
     */
    record A() implements I {}
    record B() implements I {}
    record C() implements I {}

    public static void main(String[] args) {
        /**
         * 判断接口是否是封闭
         */
        boolean sealed = I.class.isSealed();
        //若是,则获取所有子类,打印子类的名字
        if (sealed){
            Class<?>[] permittedSubclasses = I.class.getPermittedSubclasses();
            Arrays.stream(permittedSubclasses).forEach(clazz -> System.out.println(clazz.getSimpleName()));
        }
    }
}
