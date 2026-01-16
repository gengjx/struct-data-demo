package com.struct.practice;

import java.util.*;
import java.util.Map.Entry;

import org.junit.Assert;

/**
 * 集合框架练习
 * 练习内容：
 * 1. List接口（ArrayList、LinkedList）
 * 2. Set接口（HashSet、TreeSet、LinkedHashSet）
 * 3. Map接口（HashMap、TreeMap、LinkedHashMap）
 * 4. Queue接口（PriorityQueue、Deque）
 * 5. Collections工具类
 * 6. 迭代器的使用
 */
public class CollectionFrameworkPractice {

    /**
     * 练习1：ArrayList的使用
     * 任务：掌握ArrayList的基本操作
     */
    public static void practice1_ArrayList() {
        System.out.println("=== 练习1：ArrayList ===");
        
        // TODO: 完成以下操作
        // 1. 创建ArrayList
        // 2. 添加元素：add()
        // 3. 获取元素：get()
        // 4. 修改元素：set()
        // 5. 删除元素：remove()
        // 6. 查找元素：indexOf(), contains()
        // 7. 获取大小：size()
        // 8. 清空集合：clear()
        
        List<String> list = new ArrayList<>();

        list.add("1");
        System.out.println("执行插入后："+list);
        Assert.assertEquals("1",list.get(0));
        list.set(0, "2");
        Assert.assertEquals("2", list.get(0));
        list.remove(0);
        System.out.println("数组执行删除后："+list);

        list.add("1");
        list.add("2");

        Assert.assertEquals(0, list.indexOf("1"));
        Assert.assertTrue(list.contains("1"));
        Assert.assertEquals(2, list.size());
        list.clear();
        Assert.assertEquals(0,list.size());
        // 请在此处编写代码
    }

    /**
     * 练习2：LinkedList的使用
     * 任务：比较ArrayList和LinkedList的区别
     */
    public static void practice2_LinkedList() {
        System.out.println("\n=== 练习2：LinkedList ===");
        
        // TODO: 
        // 1. 创建LinkedList
        // 2. 使用LinkedList特有的方法：
        //    - addFirst(), addLast()
        //    - removeFirst(), removeLast()
        //    - getFirst(), getLast()
        // 3. 思考：什么时候用ArrayList，什么时候用LinkedList？
        
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        Assert.assertEquals(new Integer(1), linkedList.getFirst());
        Assert.assertEquals(new Integer(2), linkedList.getLast());

        linkedList.addFirst(3);
        Assert.assertEquals(3,linkedList.getFirst().intValue());
         
        linkedList.addLast(4);
        Assert.assertEquals(4, linkedList.getLast().intValue());



        // 请在此处编写代码
    }

    /**
     * 练习3：HashSet的使用
     * 任务：理解Set集合的特点（无序、不重复）
     */
    public static void practice3_HashSet() {
        System.out.println("\n=== 练习3：HashSet ===");

        // 1. 创建HashSet
        Set<String> set = new HashSet<>();

        // 2. 添加元素，观察重复元素的情况
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // 重复元素

        // 3. 遍历Set集合（无序且不重复）
        System.out.println("HashSet遍历结果：");
        for (String s : set) {
            System.out.println(s);
        }

        // 4. 理解equals()和hashCode()在Set中的作用
        // 当添加元素到HashSet时，HashSet会先判断对象hashCode是否相同，
        // 若相同再进一步使用equals()判断是否“相等”，若相等则只保留一个
        System.out.println("HashSet的大小：" + set.size());
        System.out.println("包含'Python'吗？" + set.contains("Python"));

        // 打印每个元素的hashCode
        System.out.println("每个元素的hashCode：");
        for (String s : set) {
            System.out.println(s + " : " + s.hashCode());
        }
    }

    /**
     * 练习4：TreeSet的使用
     * 任务：理解TreeSet的排序特性
     */
    public static void practice4_TreeSet() {
        System.out.println("\n=== 练习4：TreeSet ===");

        // 1. 创建TreeSet（自然排序, 即升序）
        TreeSet<Integer> naturalOrderSet = new TreeSet<>();
        naturalOrderSet.add(4);
        naturalOrderSet.add(3);
        naturalOrderSet.add(1);
        naturalOrderSet.add(7);
        naturalOrderSet.add(3); // 重复元素不会被加入
        System.out.println("TreeSet（自然顺序）: " + naturalOrderSet);

        // 2. 创建TreeSet（自定义比较器，降序排列）
        TreeSet<Integer> customOrderSet = new TreeSet<>((a, b) -> b - a);
        customOrderSet.add(4);
        customOrderSet.add(3);
        customOrderSet.add(1);
        customOrderSet.add(7);
        customOrderSet.add(4); // 重复元素不会被加入
        System.out.println("TreeSet（自定义降序）: " + customOrderSet);

        // 3. 理解Comparable和Comparator接口
        System.out.println("说明：");
        System.out.println("- TreeSet 默认按元素的自然顺序（元素必须实现Comparable），比如Integer和String实现了Comparable接口。");
        System.out.println("- 可以通过构造TreeSet时提供Comparator自定义排序逻辑。");
        System.out.println("- Comparable是元素自身的比较规则，Comparator是外部比较器。");

        // 4. 思考：HashSet和TreeSet的区别
        System.out.println("HashSet和TreeSet的区别：");
        System.out.println("- HashSet 基于哈希表实现，元素无序。");
        System.out.println("- TreeSet 基于红黑树实现，元素有序（自然顺序或Comparator）。");
        System.out.println("- 添加null：HashSet可以加入一个null，TreeSet如果比较null会抛空指针异常（除非自定义比较器特殊处理）。");
        System.out.println("- TreeSet查找/添加/删除速度比HashSet慢一点，因为需要维护有序结构。");
    }

    /**
     * 练习5：HashMap的使用
     * 任务：掌握Map的基本操作
     */
    public static void practice5_HashMap() {
        System.out.println("\n=== 练习5：HashMap ===");

        // 1. 创建HashMap
        Map<String, Integer> map = new HashMap<>();

        // 2. 添加键值对：put()
        map.put("java", 100);
        map.put("python", 98);
        map.put("c", 97);

        // 3. 获取值：get()
        System.out.println("java 分数: " + map.get("java"));
        System.out.println("python 分数: " + map.get("python"));
        System.out.println("go 分数: " + map.get("go")); // 不存在返回null

        // 4. 删除键值对：remove()
        map.remove("c"); // 删除"c"
        System.out.println("删除'c'后: " + map);

        // 5. 判断是否存在：containsKey(), containsValue()
        System.out.println("是否包含key 'java': " + map.containsKey("java"));
        System.out.println("是否包含key 'c++': " + map.containsKey("c++"));
        System.out.println("是否包含分数100: " + map.containsValue(100));

        // 6. 获取所有的key：keySet()
        System.out.println("所有的key: " + map.keySet());

        // 7. 获取所有的value：values()
        System.out.println("所有的value: " + map.values());

        // 8. 获取所有的键值对：entrySet()
        System.out.println("所有的键值对: " + map.entrySet());

        // 9. 遍历HashMap的几种方式

        // (1) 使用entrySet
        System.out.println("遍历方式1：entrySet");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        // (2) 使用keySet
        System.out.println("遍历方式2：keySet");
        for (String key : map.keySet()) {
            System.out.println("key=" + key + ", value=" + map.get(key));
        }

        // (3) 使用forEach (Java 8 Lambda)
        System.out.println("遍历方式3：forEach");
        map.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));
    }

    /**
     * 练习6：TreeMap的使用
     * 任务：理解TreeMap的排序特性
     */
    public static void practice6_TreeMap() {
        System.out.println("\n=== 练习6：TreeMap ===");

        // 1. 创建TreeMap（按键的自然顺序排序）
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("java", 100);
        treeMap.put("python", 98);
        treeMap.put("c++", 96);
        treeMap.put("go", 87);
        treeMap.put("ruby", 88);

        System.out.println("键的自然顺序排序：" + treeMap);

        // 遍历TreeMap（自然顺序）
        System.out.println("遍历 TreeMap （自然顺序）:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }

        // 2. 创建TreeMap（使用自定义比较器）：按字符串长度降序排序，长度相同则按字典序
        TreeMap<String, Integer> customTreeMap = new TreeMap<>(
                (a, b) -> {
                    int cmp = Integer.compare(b.length(), a.length());
                    if (cmp == 0) {
                        return a.compareTo(b); // 长度相同时按字典序
                    }
                    return cmp;
                }
        );
        customTreeMap.put("java", 100);
        customTreeMap.put("python", 98);
        customTreeMap.put("c++", 96);
        customTreeMap.put("go", 87);
        customTreeMap.put("ruby", 88);

        System.out.println("自定义比较器排序：" + customTreeMap);

        // 遍历TreeMap（自定义排序）
        System.out.println("遍历 TreeMap （自定义比较器）:");
        customTreeMap.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

        // 3. 思考：HashMap和TreeMap的区别
        // HashMap：存储元素无序，查找/插入/删除效率高，允许null键值，线程不安全。
        // TreeMap：元素根据key的排序规则自动有序（升序或自定义比较器），不允许null键，查找/插入/删除比HashMap慢，线程不安全。
    }

    /**
     * 练习7：PriorityQueue的使用
     * 任务：理解优先级队列
     */
    public static void practice7_PriorityQueue() {
        System.out.println("\n=== 练习7：PriorityQueue ===");

        // 1. 创建一个整数优先队列（默认小顶堆，数字越小优先级越高）
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 2. 添加元素：offer()
        queue.offer(5);
        queue.offer(2);
        queue.offer(8);
        queue.offer(1);
        queue.offer(6);

        System.out.println("初始队列（PriorityQueue内部结构不保证输出是排序的）：" + queue);

        // 3. 查看队首元素（peek），不会移除
        System.out.println("队首元素（peek）：" + queue.peek());

        // 4. 轮询队列（依次弹出）：poll()
        System.out.println("依次移除元素（按优先级，即从小到大弹出）：");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // 5. 理解优先级是如何工作的
        // 优先级队列每次取元素时（peek或poll），返回的总是队列中最小的元素（对整数来说）
        // 可以传入自定义比较器来实现大顶堆或其他优先级规则
        System.out.println("\n自定义比较器实现大顶堆（数字越大优先级越高）：");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(6);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

    /**
     * 练习8：迭代器的使用
     * 任务：掌握Iterator的使用
     */
    public static void practice8_Iterator() {
        System.out.println("\n=== 练习8：迭代器 ===");

        // 1. 使用Iterator遍历集合
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        System.out.println("使用Iterator遍历集合：");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        // 2. 使用增强for循环遍历集合
        System.out.println("使用增强for循环遍历集合：");
        for (String s : list) {
            System.out.println(s);
        }

        // 3. 使用forEach()方法遍历集合
        System.out.println("使用forEach()方法遍历集合：");
        list.forEach(System.out::println);

        // 4. 在遍历过程中删除元素
        System.out.println("使用Iterator在遍历过程中删除元素（移除'C'）：");
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            String val = it2.next();
            if ("C".equals(val)) {
                it2.remove(); // 使用Iterator的remove方法安全删除
            }
        }
        System.out.println("删除后的集合：" + list2);

        // 如果直接用增强for或forEach删除，会抛出ConcurrentModificationException
        // 示范（注释掉，避免实际异常）：
        /*
        for (String s : list2) {
            if ("D".equals(s)) list2.remove(s); // 这样会抛异常
        }
        */
    }


    /**
     * 练习9：Collections工具类
     * 任务：掌握Collections的常用方法
     */
    public static void practice9_Collections() {
        System.out.println("\n=== 练习9：Collections工具类 ===");

        // 1. 创建并输出原始列表
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        System.out.println("排序前：" + list);

        // 2. 排序
        Collections.sort(list);
        System.out.println("排序后：" + list);

        // 3. 反转
        Collections.reverse(list);
        System.out.println("数据翻转后：" + list);

        // 4. 随机打乱
        Collections.shuffle(list);
        System.out.println("打乱后：" + list);

        // 5. 查找：必须先排序
        Collections.sort(list); // 排序后才能二分查找
        int idx = Collections.binarySearch(list, 1);
        System.out.println("元素1的binarySearch结果索引：" + idx);

        // 6. 填充
        Collections.fill(list, 11);
        System.out.println("填充后：" + list);

        // 7. 复制
        List<Integer> listForCopy = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12, 13, 14));
        Collections.copy(listForCopy, list);
        System.out.println("复制后目标集合：" + listForCopy);

        // 8. 最大最小值
        List<Integer> maxMinList = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        int max = Collections.max(maxMinList);
        int min = Collections.min(maxMinList);
        System.out.println("最大值：" + max + " 最小值：" + min);

        // 9. 统计频率
        int freq = Collections.frequency(maxMinList, 1);
        System.out.println("元素1出现的频率：" + freq);

        // 10. 创建不可变集合
        List<Integer> unmodifiable = Collections.unmodifiableList(maxMinList);
        System.out.println("不可变集合：" + unmodifiable);

        // 验证不可变集合（以下注释，取消注释会抛异常）
        // unmodifiable.add(88); // UnsupportedOperationException
    }

    /**
     * 练习10：泛型的使用
     * 任务：理解泛型的作用
     */
    public static void practice10_Generics() {
        System.out.println("\n=== 练习10：泛型 ===");

        // 1. 创建泛型类
        class Box<T> {
            private T value;

            public void setValue(T value) {
                this.value = value;
            }

            public T getValue() {
                return value;
            }

            public void println() {
                System.out.println("value: " + value);
            }
        }

        Box<Integer> intBox = new Box<>();
        intBox.setValue(10);
        intBox.println(); // value: 10

        Box<String> strBox = new Box<>();
        strBox.setValue("Hello Generics");
        strBox.println(); // value: Hello Generics

        // 2. 创建泛型方法
        System.out.println("泛型方法例子:");
        printArray(new Integer[]{1,2,3});
        printArray(new String[]{"A","B","C"});

        // 3. 理解泛型通配符
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Number> numList = new ArrayList<>();
        addNumber(numList, 100);
        addNumber(numList, 3.14);

        System.out.println("使用 ? extends Number 输出List：");
        printNumbers(numList);
        printNumbers(intList);

        // 4. 泛型擦除的概念
        System.out.println("泛型类型在运行时相同吗？");
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        System.out.println("stringList.getClass() == integerList.getClass(): " + (stringList.getClass() == integerList.getClass()));

        // 思考：为什么 List<String> 不能赋值给 List<Object>？
        //
        // 因为Java的泛型是不可变的，List<String> 不是 List<Object> 的子类型。
        // 如果允许赋值，可能会出现类型安全问题，例如向 List<Object> 中添加Integer等非String类型。
        // Java通过这种机制确保了类型安全。
    }

    // 泛型方法：输出任何类型数组
    public static <T> void printArray(T[] arr) {
        for(T t : arr){
            System.out.print(t + " ");
        }
        System.out.println();
    }

    // 使用泛型通配符 ? extends Number ：只读
    public static void printNumbers(List<? extends Number> list) {
        for(Number n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // 使用泛型通配符 ? super Integer ：只写
    public static void addNumber(List<? super Number> list, Number n) {
        list.add(n);
    }





    /**
     * 练习11：综合练习
     * 任务：统计一段文本中每个单词出现的次数
     */
    public static Map<String, Integer> practice11_WordCount(String text) {
        // 实现单词统计功能
        // 1. 将文本按空格分割成单词数组
        // 2. 使用HashMap统计每个单词出现的次数
        // 3. 返回统计结果

        System.out.println("原文本：" + text);
        String[] words = text.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        
       for (String word : words) {
          wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
       }
        return wordCount;
    }

    /**
     * 练习12：综合练习
     * 任务：去除List中的重复元素，保留顺序
     */
    public static <T> List<T> practice12_RemoveDuplicates(List<T> list) {
        // 使用LinkedHashSet去重并保持顺序
        LinkedHashSet<T> linkedHashSet = new LinkedHashSet<>(list);
        return new ArrayList<>(linkedHashSet);
    }

    /**
     * 练习13：综合练习
     * 任务：实现一个简单的LRU缓存（最近最少使用）
     * 提示：可以使用LinkedHashMap
     */
    public static void practice13_LRUCache() {
        // TODO: 实现LRU缓存
        // 1. 使用LinkedHashMap
        // 2. 重写removeEldestEntry()方法
        // 3. 实现get()和put()方法
    }

    static class lPratice<T> {

        private LinkedHashMap<T,Integer> hashMap;

        private T [] array;

        private int size;

        public lPratice(){
            this(10);
        }

        public lPratice(int size){
            this.size = 0;
            array = (T[])new Object[size];
            hashMap = new LinkedHashMap(size);
        }


        public void offer(T value){

            Integer index =  hashMap.get(value);
            if (index == null) {
                if (isFull()) {
                    removeAndCache(value);
                }else {
                    rightMove(array,size);
                    cache(value,0);
                }
            }else{
                rightMove(array, index);
                hashMap.put(value, 0);
                array[0] = value;
            }
        }

        private void removeAndCache(T value) {
            T last = array[array.length -1];
            hashMap.remove(last);
            rightMove(array, size-1);
            cache(value, 0);
        }

        private void cache(T value, int i) {
                array[i] = value;
                hashMap.put(value, i);
                this.size++;
        }

        private void rightMove(T[] array, int size) {
            if (size ==  0) {
                return;
            }
            int i = size -1;
            for( ; i>=0;i--){
                array[i+1]  =array[i];
                this.hashMap.put(array[i+1], i+1);
            }
        }

        private boolean isFull(){
            return this.size >= this.array.length;
        }


        public void printArray(){
            if (array.length == 0) {
                return;
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+" ");
            }

            System.out.println(hashMap + " " +this.size );
        }



    }


    // 测试方法
    public static void main(String[] args) {
        practice1_ArrayList();
        practice2_LinkedList();
        practice3_HashSet();
        practice4_TreeSet();
        practice5_HashMap();
        practice6_TreeMap();
        practice7_PriorityQueue();
        practice8_Iterator();
        practice9_Collections();
        practice10_Generics();
        
        String text = "hello world hello java world java";
        System.out.println("\n单词统计:");
        Map<String, Integer> wordCount = practice11_WordCount(text);
        wordCount.forEach((word, count) -> 
            System.out.println(word + ": " + count));

            lPratice<Integer> practice1 = new lPratice();
            practice1.offer(1);
            practice1.printArray();
            practice1.offer(2);
            practice1.printArray();

            practice1.offer(1);
            practice1.printArray();
            int i = 3;
            for(;i<=10;i++){
                practice1.offer(i);
            }
            practice1.printArray();

            practice1.offer(11);
            practice1.printArray();
    }

   
    

    
}

