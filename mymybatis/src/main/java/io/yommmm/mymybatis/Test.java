package io.yommmm.mymybatis;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class Test {

    public static void main(String[] args) {
        float a = 0.125f;
        double b = 0.125d;
        System.out.println((a - b) == 0.0);

        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        System.out.println((c - d) == (d - e));

        System.out.println(1.0 / 0);

        System.out.println(0.0 / 0.0); // NaN

//        Test test = new Test();
//        test.f(null);
//
//        test.d(1);

    }

    void f(String a) {
        System.out.println("String");
    }

    void f(Integer a) {
        System.out.println("Integer");
    }

    void d(int a) {
        System.out.println("Integer");
    }

    void d(double a) {
        System.out.println("double");
    }

    void d(Integer a) {
        System.out.println("integer");
    }

    <String, T, Alibaba> String get(String string, T t) {
        return string;
    }

}
