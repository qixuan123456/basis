package Test;

import com.sun.xml.internal.xsom.impl.scd.Step;
import sun.tools.jar.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class CommandTest {
    public static void main(String[] args) {
        String[] ss = {"1","2","3"};
        List<String> argsList = new ArrayList<>();
        for (String arg : ss) {
            if ("1".compareTo(arg)!=0)
                argsList.add(arg);
        }
        String[] newArgs = argsList.toArray(new String[0]);
        System.out.println();
        CommandLine cmd = null;
    }
}
