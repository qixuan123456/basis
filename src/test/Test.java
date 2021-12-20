package test;

/**
 * @author Xuan
 * Date: 2021/11/12
 * Time: 10:08
 */
public class Test {
    public static final int a = 1<<10;
    public static void main(String[] args) {

        String s1 = new String("123")+new String("456");

        String s2 = "123456";


        System.out.println(s1==s2);
    }




    static class A{
        public int a ;
        public A(int a){
            this.a = a;
        }
    }
}
