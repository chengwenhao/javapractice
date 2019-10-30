package demo;

import java.util.Comparator;

public class Demo {

    public static void main(String[] args) {
        String s = "Java";
        boolean b = s.startsWith("J");
        System.out.println(b);


        Comparator c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };


    }

}

@FunctionalInterface
interface Test{

    void test1();

    default void test2(){
        System.out.println("123321");
    }

    boolean equals(Object obj);
}
