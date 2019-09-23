package stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 新建流
 */
public class NewStream {

    public static void main(String[] args) throws FileNotFoundException {
        //1.使用集合的方法
        /*List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        Stream<String> stream = arrayList.stream();
        Stream<String> pStream = arrayList.parallelStream();
        System.out.println(stream.count());
        System.out.println(pStream.count());*/

        //2.使用Arrays中的stream()方法，将数组转成流
        /*Stream<String> stream1 = Arrays.stream(new String[]{"1", "2", "3", "4"});
        stream1.forEach(System.out::println);
        System.out.println(stream1.count());*/

        //3.使用Stream中的静态方法：of()、iterate()、generate()
        /*Stream<String> stream2 = Stream.of("1", "2", "3", "4");
        System.out.println(stream2.count());*/

        /*Stream<Integer> stream3 = Stream.iterate(0,(x) -> x + 2).limit(6);//0,2,4,6,8,10
        stream3.forEach(System.out::println);*/

//        Stream.generate(Math::random).mapToInt(x -> (int)(x*100)).limit(2).forEach(System.out::println);

        //4.使用 BufferedReader.lines() 方法，将每行内容转成流
        /*BufferedReader reader = new BufferedReader(new FileReader("D:\\info.txt"));
        Stream<String> lines = reader.lines();
        lines.forEach(System.out::println);*/

        //1.5 使用 Pattern.splitAsStream() 方法，将字符串分隔成流
        /*Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,d,s,b,g,h");
        stringStream.forEach(System.out::println);*/

        /*2.1 筛选与切片
        filter：过滤流中的某些元素
        limit(n)：获取n个元素
        skip(n)：跳过n元素，配合limit(n)可实现分页
        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素*/
        /*Stream<String> stream = Stream.of("hello", "world", "make", "america", "add","again",
                "xi","xidada","add");*/
//        stream.filter(x -> x.startsWith("a")).limit(6).skip(2)/*.distinct()*/.forEach(System.out::println);

        /*2.2 映射
        map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。*/
//      stream.map(x -> x.replaceAll("a","bb")).forEach(System.out::println);
        /*stream.flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split("a");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).forEach(System.out::println);*/

        /*2.3 排序
        sorted()：自然排序，流中元素需实现Comparable接口
        sorted(Comparator com)：定制排序，自定义Comparator排序器*/
        /*String[] numbers = {"12","2","36","97","3","444","21"};
        Integer[] number = {12,2,36,97,3,444,21};
        Stream<String> numberStream = Arrays.stream(numbers);
        Stream<Integer> number1 = Arrays.stream(number);
        numberStream.sorted().forEach(System.out::println);
        number1.sorted().forEach(System.out::println);*/
        /*Stream<User> userStream = Stream.of(new User(1, "yaoming"), new User(34, "cheng"), new User(0, "wusuo"));
//        userStream.sorted((o1,o2) -> {return o1.age - o2.age;}).map(s -> s.name).forEach(System.out::println);
        userStream.sorted(Comparator.comparing(o1 -> o1.age)).map(s -> s.name).forEach(System.out::println);*/

        /*2.4 消费
        peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。
        */
        /*List<User> users = Arrays.asList(new User(12, "chengwh"), new User(13, "lj"));
        Stream<User> stream = users.stream();
        Stream<String> stringStream = stream.peek(x -> x.name = "lilianjie").map(x -> x.name);
        List<String> userList = stringStream.collect(Collectors.toList());
        System.out.println(userList);*/

        /*3.1 匹配、聚合操作
        allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
        noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
        anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
        findFirst：返回流中第一个元素
        findAny：返回流中的任意元素
        count：返回流中元素的总个数
        max：返回流中元素最大值
        min：返回流中元素最小值*/
        /*List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean b = list.stream().allMatch(s -> s > 10);
        boolean b1 = list.stream().anyMatch(s -> s == 5);
        boolean b2 = list.stream().noneMatch(s -> s == 6);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().min(Integer::compareTo).get());*/

        /*3.2 规约操作
        Optional<T> reduce(BinaryOperator<T> accumulator)：第一次执行时，accumulator函数的第一个
        参数为流中的第一个元素，第二个参数为流中元素的第二个元素；第二次执行时，第一个参数为第一次函数执行的结
        果，第二个参数为流中的第三个元素；依次类推。
        T reduce(T identity, BinaryOperator<T> accumulator)：流程跟上面一样，只是第一次执行时，
        accumulator函数的第一个参数为identity，而第二个参数为流中的第一个元素。
        <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,
        BinaryOperator<U> combiner)：在串行流(stream)中，该方法跟第二个方法一样，即第三个
        参数combiner不会起作用。在并行流(parallelStream)中,我们知道流被fork join出多个线程进行
        执行，此时每个线程的执行流程就跟第二个方法reduce(identity,accumulator)一样，而第三个参数
        combiner函数，则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。*/

        /*List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        Stream<Integer> stream = integers.stream();
        Integer integer = stream.reduce((s1, s2) -> s1 + s2).get();
        System.out.println(integer);

        Stream<Integer> stream1 = integers.stream();
        Integer reduce = stream1.reduce(10, (s1, s2) -> s1 + s2);
        System.out.println(reduce);*/

        /*3.3 收集操作: Collector 工具库：Collectors*/
        User user1 = new User(10, "a");
        User user2 = new User(11, "b");
        User user3 = new User(12, "a");
        User user4 = new User(13, "d");
        User user5 = new User(14, "e");
        User user6 = new User(15, "f");

        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6);
        userList.stream().map(User::getName).collect(Collectors.toList()).forEach(System.out::println);
        Double collect2 = userList.stream().collect(Collectors.averagingDouble(User::getAge));
        System.out.println(collect2);
        System.out.println(userList.stream().collect(Collectors.counting()));
        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(collect);
        Map<Boolean, List<User>> collect1 = userList.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 13));
        System.out.println(collect1);

        userList.stream().sorted((s1,s2) -> s2.getAge() - s1.getAge()).map(User::getName).forEach(System.out::println);
    }
}


class User{
    public int age;
    public String name;
    public String sex;

    public User(int age,String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}