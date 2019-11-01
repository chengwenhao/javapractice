package map;

import java.util.*;

/**
 * java8 map 新增方法练习
 */
public class MapTestJava8 {

    public static void main(String[] args) {
        //1.map.putIfAbsent();
        Map<String, ArrayList<Integer>> map1 = new HashMap<>();
        List<String> stringList1 = Arrays.asList("1", "2", "2", "3", "5", "6", "6");
        for (int i = 0;i < stringList1.size() ; i++) {
            map1.putIfAbsent(stringList1.get(i), new ArrayList<Integer>(1));
            map1.get(stringList1.get(i)).add(i);
        }
        System.out.println(map1);
        //2.map.compute();
        Map<String, ArrayList<Integer>> map2 = new HashMap<>();
        List<String> stringList2 = Arrays.asList("1", "2", "2", "3", "5", "6", "6");
        for (int i = 0; i < stringList2.size();i++){
            map2.compute(stringList2.get(i),(k,v) -> v==null?new ArrayList<>(1):v).add(i);
        }
        System.out.println(map2);
        //3.map.computeIfAbsent();
        Map<String, ArrayList<Integer>> map3 = new HashMap<>();
        List<String> stringList3 = Arrays.asList("1", "2", "2", "3", "5", "6", "6");
        for (int i = 0; i < stringList3.size();i++){
            map3.computeIfAbsent(stringList3.get(i),(k)->new ArrayList<>(1)).add(i);
        }
        System.out.println(map3);
        //4.map.computeIfPresent();

        //5.map.merge();




    }
}
