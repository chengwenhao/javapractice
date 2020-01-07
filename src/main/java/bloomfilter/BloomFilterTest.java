package bloomfilter;


import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;
import java.util.List;

/**
 * 布隆过滤器
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        int max_size = 1000000;
//        https://juejin.im/post/5c5251b1518825469414ef4a
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 1000000L, 0.00003);

        for (int i=0;i<max_size;i++){
            bloomFilter.put("hello World" + i);
        }


        for (int i=0;i<max_size;i++){
            if(!bloomFilter.mightContain("hello World" + i)){
                System.out.println("有坏人逃脱了");
            }
        }

        List<String> list = new ArrayList<>();
        for (int i=1000000;i<max_size + 10000;i++){
            if (bloomFilter.mightContain("hello World" + i)) {
                list.add("hello World" + i);
            }
        }
        System.out.println(list);
        System.out.println("有误伤的数量：" + list.size());
        System.out.println("有误伤的数量：" + list.size());
    }

}
