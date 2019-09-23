package lambda;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * lambda表达式
 */
public class LambdaDemo {
    public static void main(String[] args) {

        //1.代替匿名类，比如:
        new Thread(() -> System.out.println("1232323")).start();

        new Thread(() -> System.out.println("hello")).start();

        //2.使用lambda表达式进行循环迭代
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.forEach(s -> System.out.println("first:-----" + s));
        strings.forEach(System.out::println);

        List<String> list = Arrays.asList("beckHam", "ronaldo", "rooney", "messi");
        list.forEach((s) -> System.out.println(s));

        //3.使用lambda表达式和函数式接口Predicate
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, s -> s.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);

        //4.在lambda表达式中使用流的and,or和xor
        List<String> cars =
                Arrays.asList("AstonMartin", "BMW", "AUDI", "BYD", "Benz","TOYOTA","HONDA");
        Predicate<String> predicate1 = param -> param.startsWith("A");
        Predicate<String> predicate2 = param -> param.endsWith("n");
        cars.stream().filter(predicate1.and(predicate2)).
                forEach(System.out::println);

        Predicate<String> predicate3 = param -> param.startsWith("B");
        cars.stream().filter(predicate1.or(predicate3)).
                forEach(n -> System.out.println("I like this "+ n + "Car"));

        Predicate<String> predicate4 = param -> param.startsWith("B");
        cars.stream().filter(predicate4.negate()).
                forEach(n -> System.out.println("I like this "+ n + "Car"));

        List<Object> objects = new ArrayList<>();
        Predicate<String> predicate5 = param -> param.startsWith("B");
        cars.stream().filter(predicate5.negate()).
                forEach(objects::add);
        System.out.println(objects);

        //8.Java 8中使用lambda表达式的Map和Reduce示例
        List<Integer> integers = Arrays.asList(100, 200, 300, 400, 500);
        integers.stream().map(money -> money + money*0.1).forEach(System.out::println);
        integers.stream().mapToInt(money -> (int)(money + money*0.1)).forEach(System.out::println);
        Double aDouble = integers.stream().map(money -> money + money * 0.1).reduce((sum, s) -> sum + s).get();
        System.out.println(aDouble);
        Double aDouble1 = integers.stream().map(money -> money + money * 0.1).reduce((a, b) -> a+b).get();
        System.out.println(aDouble1);

        //9.获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> integers1 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = integers1.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(statistics.getSum());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());

        //10.通过过滤创建一个Integer列表
        List<Integer> integers2 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        List<Integer> collect = integers2.stream().map(x -> x + 2).collect(Collectors.toList());



    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }


}
