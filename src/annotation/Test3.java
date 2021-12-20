package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Xuan
 * Date: 2021/11/22
 * Time: 20:14
 */
@MyAnnotation4
public class Test3 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Test3 test3 = new Test3();
        Method[] methods = Test3.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation3.class)){
                System.out.println(method.getName());
                method.invoke(test3);
            }
        }
    }
    @MyAnnotation3
    public void hello(){
        System.out.println("Hello,world");
    }

}
