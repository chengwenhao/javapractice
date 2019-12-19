package concurrenthashmap;

import java.util.*;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());

        ArrayList<Object> list = new ArrayList<>();
        Iterator<Object> iterator = list.iterator();

    }
}
