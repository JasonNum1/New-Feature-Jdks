/**
 * 记录匹配和全面的switch
 */
public class RecordPatternsAndExhaustiveSwitch {
    void method1(){
        Pair<A> p1 = new Pair<>(new A(), new B());
        Pair<I> p2 = new Pair<>(new C(), new D());
        switch (p2) {
            case Pair<I>(I i, C c) -> {}
            case Pair<I>(I i, D d) -> {}
        }

        switch (p2) {
            case Pair<I>(C c, I i) -> {}
            case Pair<I>(D d, C c) -> {}
            case Pair<I>(D d, I i) -> {}
        }
        //下面这种会报错,switch语句没有覆盖所有可能的输入值
        //switch (p2) {
        //    case Pair<I>(C fst, D snd) -> {}
        //    case Pair<I>(D fst, C snd) -> {}
        //    case Pair<I>(I fst, C snd) -> {}
        //}
        //p2的范型为I,修复后的语句如下
        switch (p2) {
            case Pair<I>(C c, I i) -> {}
            case Pair<I>(D d, I i) -> {}
            case Pair<I>(I fst, C snd) -> {}
            case Pair<I>(I fst, D snd) -> {}
        }
        //或者使用default语句覆盖所有剩余的情况
        switch (p2) {
            case Pair<I>(C c, I i) -> {}
            case Pair<I>(D d, I i) -> {}
            case Pair<I>(I fst, C snd) -> {}
            default -> {}
        }
    }

    class A {}
    class B extends A {}
    sealed interface I permits C, D {}
    final class C implements I {}
    final class D implements I {}
    record Pair<T>(T x, T y) {}
}
