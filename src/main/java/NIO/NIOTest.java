package NIO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NIOTest {

    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        for (int i = 0;i<1000000;i++){
            objects.add(i);
        }
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        List<Object> objects1 = new ArrayList<>();
//        for (Integer i : objects) {
//            if (i==10 || i == 100 || i == 111){
//                objects1.add(i);
//            }
//        }
//        System.out.println(objects1);
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1);
//        System.out.println(l1-l);

        long l = System.currentTimeMillis();
        System.out.println(l);
        List<Integer> collect = objects.parallelStream().filter(i -> i == 10 || i == 100 || i == 111).collect(Collectors.toList());
        System.out.println(collect);
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println(l1 -l);

    }




}
