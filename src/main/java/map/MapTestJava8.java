package map;

import java.util.*;

/**
 * java8 map 新增方法练习
 */
public class MapTestJava8 {

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        List<String> stringList = Arrays.asList("1", "2", "2", "3", "5", "6", "6");
        //1.map.putIfAbsent();
        for (int i = 0;i < stringList.size() ; i++) {
            List<Integer> o = map.putIfAbsent(stringList.get(i), new ArrayList<Integer>(1));
            System.out.println(o);
            System.out.println(map);
        }


        //2.map.compute();

        //3.map.computeIfAbsent();

        //4.map.computeIfPresent();

        //5.map.merge();




    }
}
