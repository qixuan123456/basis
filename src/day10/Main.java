package day10;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("张三",20);
        SerializationUtil.writeObject(person);
        Person p = (Person) SerializationUtil.readObject();
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}
