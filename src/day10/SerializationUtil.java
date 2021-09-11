package day10;

import java.io.*;

public class SerializationUtil {

    //.bin后缀代表二进制文件
    private static String FILE_NAME = "./src/Day10/obj.txt";

    /**
     * 序列化
     */
    public static void writeObject(Serializable s) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(s);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static Object readObject() {
        Object obj = null;

        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}