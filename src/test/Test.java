package test;

/**
 * @author Xuan
 * Date: 2021/11/12
 * Time: 10:08
 */
public class Test {
    public static final int a = 1<<10;
    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(a<<2);
//        A t = new A(10);
//        for (int i = 0; (i < t.a); i+=2) {
//            System.out.println(i);
//            t.a++;
//        }
    }




    static class A{
        public int a ;
        public A(int a){
            this.a = a;
        }
    }
}
