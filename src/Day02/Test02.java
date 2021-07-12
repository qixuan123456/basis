package Day02;

public class Test02 {
    public static void main(String[] args) {
        String path = Thread.currentThread().getContextClassLoader().getResource("Day02/fo1.properties").getPath();
        System.out.println(path);
    }
}
