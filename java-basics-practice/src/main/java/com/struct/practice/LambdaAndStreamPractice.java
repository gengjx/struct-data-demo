package com.struct.practice;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lambda表达式和Stream API练习
 * 练习内容：
 * 1. Lambda表达式语法
 * 2. 函数式接口
 * 3. 方法引用
 * 4. Stream的创建
 * 5. Stream的中间操作（filter、map、sorted等）
 * 6. Stream的终止操作（collect、forEach、reduce等）
 */
public class LambdaAndStreamPractice {

    /**
     * 练习1：Lambda表达式基础
     * 任务：理解Lambda表达式的语法
     */
    public static void practice1_LambdaBasics() {
        System.out.println("=== 练习1：Lambda基础 ===");

        // 1. 无参数：() -> System.out.println("Hello")
        Runnable r2 = () -> System.out.println("Hello");
        r2.run();

        // 2. 单个参数：x -> x * 2
        Function<Integer, Integer> doubleFunc = x -> x * 2;
        System.out.println("doubleFunc.apply(10): " + doubleFunc.apply(10));

        // 3. 多个参数：(x, y) -> x + y
        BiFunction<Integer, Integer, Integer> addFunc = (x, y) -> x + y;
        System.out.println("addFunc.apply(3, 4): " + addFunc.apply(3, 4));

        // 4. 代码块：(x, y) -> { return x + y; }
        BiFunction<Integer, Integer, Integer> addFuncBlock = (x, y) -> {
            return x + y;
        };
        System.out.println("addFuncBlock.apply(5, 6): " + addFuncBlock.apply(5, 6));

        // Runnable接口的Lambda表达式
        Runnable r1 = () -> System.out.println("Hello Lambda");
        r1.run();

        // 5. Predicate示例：判断一个字符串是否为空
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("\"abc\" is empty? " + isEmpty.test("abc"));
        System.out.println("\"\" is empty? " + isEmpty.test(""));

        // 6. Consumer示例：打印一个整数
        Consumer<Integer> printInt = i -> System.out.println("value = " + i);
        printInt.accept(42);

        // 7. Supplier示例：返回固定字符串
        Supplier<String> stringSupplier = () -> "I am supplied";
        System.out.println("Supplier returns: " + stringSupplier.get());
    }

    /**
     * 练习2：函数式接口
     * 任务：使用Java内置的函数式接口
     */
    public static void practice2_FunctionalInterfaces() {
        System.out.println("\n=== 练习2：函数式接口 ===");
        
        // TODO: 使用内置函数式接口
        // 1. Predicate<T>: 断言，boolean test(T t)
        // 2. Function<T, R>: 函数，R apply(T t)
        // 3. Consumer<T>: 消费者，void accept(T t)
        // 4. Supplier<T>: 供应者，T get()
        // 5. BiFunction<T, U, R>: 二元函数，R apply(T t, U u)
        
        // Predicate示例：判断数字是否大于10
        Predicate<Integer> isGreaterThan10 = x -> x > 10;
        System.out.println("15 > 10? " + isGreaterThan10.test(15));
        
        // Function示例：将数字乘以2
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        System.out.println("5 * 2 = " + multiplyBy2.apply(5));
        
        // Consumer示例：打印字符串
        Consumer<String> printer = s -> System.out.println("输出: " + s);
        printer.accept("Hello");
        
        // Supplier示例：生成随机数
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println("随机数: " + randomSupplier.get());
    }

    /**
     * 练习3：方法引用
     * 任务：理解方法引用的四种形式
     */
    public static void practice3_MethodReference() {
        System.out.println("\n=== 练习3：方法引用 ===");
        
        List<String> list = Arrays.asList("apple", "banana", "orange");
        
        // TODO: 使用方法引用
        // 1. 静态方法引用：ClassName::staticMethod
        // 2. 实例方法引用：instance::instanceMethod
        // 3. 类的实例方法引用：ClassName::instanceMethod
        // 4. 构造方法引用：ClassName::new
        
        // 静态方法引用
        list.forEach(System.out::println);
        
        // 类的实例方法引用
        list.sort(String::compareToIgnoreCase);
        
        // 请在此处编写更多方法引用示例
    }

    /**
     * 练习4：Stream的创建
     * 任务：掌握创建Stream的方式
     */
    public static void practice4_CreateStream() {
        System.out.println("\n=== 练习4：创建Stream ===");
        
        // TODO: 创建Stream的各种方式
        // 1. 从集合创建：collection.stream()
        // 2. 从数组创建：Arrays.stream()
        // 3. 使用Stream.of()：Stream.of(1, 2, 3)
        // 4. 使用Stream.generate()：生成无限流
        // 5. 使用Stream.iterate()：迭代生成
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = list.stream();
        
        int[] array = {1, 2, 3, 4, 5};
        IntStream stream2 = Arrays.stream(array);
        
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        
        // 无限流
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        infiniteStream.limit(5).forEach(System.out::println);
    }

    /**
     * 练习5：Stream的中间操作 - filter
     * 任务：使用filter过滤元素
     */
    public static void practice5_Filter() {
        System.out.println("\n=== 练习5：filter操作 ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // TODO: 使用filter过滤
        // 1. 过滤出偶数
        // 2. 过滤出大于5的数
        // 3. 组合多个条件
        
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("偶数: " + evens);
    }

    /**
     * 练习6：Stream的中间操作 - map
     * 任务：使用map转换元素
     */
    public static void practice6_Map() {
        System.out.println("\n=== 练习6：map操作 ===");
        
        List<String> words = Arrays.asList("hello", "world", "java");
        
        // TODO: 使用map转换
        // 1. 将字符串转换为大写
        // 2. 获取字符串长度
        // 3. 将字符串转换为整数
        
        List<String> upperWords = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("大写: " + upperWords);
        
        List<Integer> lengths = words.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("长度: " + lengths);
    }

    /**
     * 练习7：Stream的中间操作 - sorted
     * 任务：使用sorted排序
     */
    public static void practice7_Sorted() {
        System.out.println("\n=== 练习7：sorted操作 ===");
        
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
        
        // TODO: 使用sorted排序
        // 1. 自然排序
        // 2. 自定义排序（倒序）
        
        List<Integer> sorted = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("排序: " + sorted);
        
        List<Integer> reversed = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println("倒序: " + reversed);
    }

    /**
     * 练习8：Stream的中间操作 - distinct
     * 任务：使用distinct去重
     */
    public static void practice8_Distinct() {
        System.out.println("\n=== 练习8：distinct操作 ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5);
        
        // TODO: 使用distinct去重
        List<Integer> distinct = numbers.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("去重: " + distinct);
    }

    /**
     * 练习9：Stream的中间操作 - flatMap
     * 任务：使用flatMap扁平化
     */
    public static void practice9_FlatMap() {
        System.out.println("\n=== 练习9：flatMap操作 ===");
        
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8)
        );
        
        // TODO: 使用flatMap扁平化
        List<Integer> flatList = nestedList.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("扁平化: " + flatList);
    }

    /**
     * 练习10：Stream的终止操作 - collect
     * 任务：使用collect收集结果
     */
    public static void practice10_Collect() {
        System.out.println("\n=== 练习10：collect操作 ===");
        
        List<String> words = Arrays.asList("apple", "banana", "orange", "apple");
        
        // TODO: 使用collect收集
        // 1. 收集到List
        // 2. 收集到Set（自动去重）
        // 3. 收集到Map
        // 4. 字符串连接：joining()
        // 5. 分组：groupingBy()
        // 6. 分区：partitioningBy()
        
        Set<String> set = words.stream()
            .collect(Collectors.toSet());
        System.out.println("Set: " + set);
        
        Map<String, Long> countMap = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("计数: " + countMap);
        
        String joined = words.stream()
            .collect(Collectors.joining(", "));
        System.out.println("连接: " + joined);
    }

    /**
     * 练习11：Stream的终止操作 - reduce
     * 任务：使用reduce归约
     */
    public static void practice11_Reduce() {
        System.out.println("\n=== 练习11：reduce操作 ===");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // TODO: 使用reduce归约
        // 1. 求和
        // 2. 求最大值
        // 3. 求最小值
        // 4. 字符串连接
        
        Integer sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("求和: " + sum);
        
        Optional<Integer> max = numbers.stream()
            .reduce(Integer::max);
        System.out.println("最大值: " + max.orElse(0));
    }

    /**
     * 练习12：Stream的终止操作 - forEach
     * 任务：使用forEach遍历
     */
    public static void practice12_ForEach() {
        System.out.println("\n=== 练习12：forEach操作 ===");
        
        List<String> words = Arrays.asList("hello", "world", "java");
        
        // TODO: 使用forEach遍历
        words.stream()
            .forEach(System.out::println);
    }

    /**
     * 练习13：综合练习
     * 任务：使用Stream处理复杂数据
     */
    public static void practice13_ComplexStream() {
        System.out.println("\n=== 练习13：综合练习 ===");
        
        // TODO: 创建一个Person类列表，完成以下操作
        // 1. 过滤出年龄大于18的人
        // 2. 按年龄排序
        // 3. 提取姓名列表
        // 4. 按城市分组
        // 5. 计算每个城市的平均年龄
        
        // class Person {
        //     String name;
        //     int age;
        //     String city;
        // }
        
        // List<Person> persons = ...;
        // 
        // List<String> names = persons.stream()
        //     .filter(p -> p.age > 18)
        //     .sorted(Comparator.comparing(Person::getAge))
        //     .map(Person::getName)
        //     .collect(Collectors.toList());
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_LambdaBasics();
        practice2_FunctionalInterfaces();
        practice3_MethodReference();
        practice4_CreateStream();
        practice5_Filter();
        practice6_Map();
        practice7_Sorted();
        practice8_Distinct();
        practice9_FlatMap();
        practice10_Collect();
        practice11_Reduce();
        practice12_ForEach();
        practice13_ComplexStream();
    }
}

