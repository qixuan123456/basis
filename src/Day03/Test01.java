package Day03;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {


        List<List<Integer>> b = generate(5);

        System.out.println(b);

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        b.add(1);
        a.add(b);
        if(numRows==1) {
            return a;
        }
        d.add(1);
        d.add(1);
        a.add(d);
        if(numRows==2) {
            return a;
        }
        List<Integer> e = d;
        for(int i = 2;i<numRows;i++)
        {
            List<Integer> c = new ArrayList<>();
            c.add(1);
            for(int j=1;j<i;j++)
            {
                c.add(e.get(j)+e.get((j-1)));
            }
            c.add(1);
            a.add(c);
            e=c;
        }
        return a;
    }
}
