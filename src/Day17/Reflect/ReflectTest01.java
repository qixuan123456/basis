package Day17.Reflect;

public class ReflectTest01 {
    public static void main(String[] args) {
        try {
             Class.forName("Day17.Reflect.MyClass");
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