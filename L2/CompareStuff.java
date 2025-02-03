import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class CompareStuff {

    public static void main(String[] args) {

        String a = "giraffe";
        String b = "platypus";
        String c = "cat";
        String d = "giraffe";

        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(d));
        System.out.println(b.compareTo(c));

        String[] strings = new String[4];
        strings[0] = a;
        strings[1] = b;
        strings[2] = c;
        strings[3] = d;

        for(String x : strings) {
            System.out.println(x);
        }
        System.out.println("-----");
        Arrays.sort(strings);
        for(String x : strings) {
            System.out.println(x);
        }
        System.out.println("-----");

        ArrayList<String> stuff = new ArrayList<>();
        stuff.add(a);
        stuff.add(b);
        stuff.add(c);
        stuff.add(d);
        for(String x : stuff) {
            System.out.println(x);
        }
        Collections.sort(stuff);
        System.out.println("-----");
        for(String x : stuff) {
            System.out.println(x);
        }

    }


}