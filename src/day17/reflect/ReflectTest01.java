package day17.reflect;

public class ReflectTest01 {
    public static void main(String[] args) {
        try {
             Class.forName("day17.reflect.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

}
class MyClass{
    static {
        System.out.println("执行静态代码块");
    }
}