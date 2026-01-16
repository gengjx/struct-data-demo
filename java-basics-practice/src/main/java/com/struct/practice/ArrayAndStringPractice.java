package com.struct.practice;

import java.util.Arrays;

/**
 * 数组和字符串处理练习
 * 练习内容：
 * 1. 数组的声明、初始化、遍历
 * 2. 数组的常用操作（查找、排序、复制）
 * 3. 字符串的创建和常用方法
 * 4. 字符串的不可变性理解
 * 5. StringBuilder和StringBuffer的使用
 */
public class ArrayAndStringPractice {

    /**
     * 练习1：数组的声明和初始化
     * 任务：创建不同类型的数组并初始化
     */
    public static void practice1_ArrayDeclaration() {
        System.out.println("=== 练习1：数组声明和初始化 ===");
        
        // TODO: 创建以下数组
        // 1. int数组，大小为5，初始值为{1,2,3,4,5}
        // 2. String数组，大小为3，初始值为{"Java", "Python", "C++"}
        // 3. double数组，大小为4，初始值全部为0.0
        // 4. char数组，初始值为{'H','e','l','l','o'}
        
        // 请在此处编写代码
        int[] intArray = new int[]{1, 2, 3, 4, 5};
        String[] stringItems = new String[]{"Java", "Python", "C++"};
        double[] doubleItems = new double[4]; // 默认初始化为0.0
        char[] charItems = new char[]{'H', 'e', 'l', 'l', 'o'};
        
        // 打印数组内容
        System.out.println("打印所有数组...");
        System.out.println("int数组: " + Arrays.toString(intArray));
        System.out.println("String数组: " + Arrays.toString(stringItems));
        System.out.println("double数组: " + Arrays.toString(doubleItems));
        System.out.println("char数组: " + Arrays.toString(charItems));
    }

    /**
     * 练习2：数组的遍历
     * 任务：使用不同方式遍历数组
     */
    public static void practice2_ArrayTraversal(int[] arr) {
        // TODO: 使用三种方式遍历数组
        // 1. 传统for循环
        // 2. 增强for循环（for-each）
        // 3. Arrays.toString()方法
        
        System.out.println("\n=== 练习2：数组遍历 ===");
        // 请在此处编写代码
        
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        
        // 1. 传统for循环
        System.out.print("传统for循环: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        // 2. 增强for循环（for-each）
        System.out.print("增强for循环: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // 3. Arrays.toString()方法
        System.out.println("Arrays.toString(): " + Arrays.toString(arr));


    }

    /**
     * 练习3：查找数组中的最大值和最小值
     */
    public static int[] practice3_FindMaxAndMin(int[] arr) {
        // TODO: 返回一个数组，第一个元素是最大值，第二个是最小值
        // 如果数组为空，返回null
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        int minValue = arr[0];
        int maxValue = arr[0];
        
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }
        
        return new int[]{maxValue, minValue};
    }

    /**
     * 练习4：数组元素的查找
     * 任务：在数组中查找指定元素，返回索引
     */
    public static int practice4_SearchInArray(int[] arr, int target) {
        // TODO: 在数组中查找target，返回第一个匹配的索引
        // 如果未找到，返回-1
        if (arr == null) {
            return -1;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 练习5：数组元素的排序
     * 任务：对数组进行排序（升序）
     */
    public static void practice5_SortArray(int[] arr) {
        // TODO: 使用冒泡排序或Arrays.sort()对数组排序
        // 注意：思考这两种方法的区别
        // Arrays.sort()使用优化的排序算法（TimSort），时间复杂度O(n log n)
        // 冒泡排序时间复杂度O(n²)，适合教学演示，实际开发不推荐
        
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法排序");
            return;
        }
        
        System.out.println("排序前: " + Arrays.toString(arr));
        // 请在此处编写代码
        Arrays.sort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    /**
     * 练习6：数组的复制
     * 任务：复制数组
     */
    public static int[] practice6_CopyArray(int[] original) {
        // TODO: 使用三种方式复制数组
        // 1. 使用循环手动复制
        // 2. 使用Arrays.copyOf()
        // 3. 使用System.arraycopy()
        // 返回复制的数组
        
        if (original == null) {
            return null;
        }
        
        System.out.println("原数组: " + Arrays.toString(original));
        
        // 方式1：使用循环手动复制
        // int[] copyArray = new int[original.length];
        // for (int i = 0; i < original.length; i++) {
        //     copyArray[i] = original[i];
        // }
        
        // 方式2：使用Arrays.copyOf()（推荐，简洁易读）
        int[] copyArray = Arrays.copyOf(original, original.length);
        
        // 方式3：使用System.arraycopy()（性能最优，适合大数据量）
        // int[] copyArray = new int[original.length];
        // System.arraycopy(original, 0, copyArray, 0, original.length);
        
        System.out.println("复制数组: " + Arrays.toString(copyArray));
        return copyArray;
    }


    /**
     * 练习7：二维数组
     * 任务：创建和操作二维数组
     */
    public static void practice7_TwoDimensionalArray() {
        System.out.println("\n=== 练习7：二维数组 ===");
        
        // 创建一个3x3的二维数组，存储1-9
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 打印二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 练习8：字符串的创建和基本操作
     */
    public static void practice8_StringBasics() {
        System.out.println("\n=== 练习8：字符串基础 ===");
        
        // TODO: 
        // 1. 创建字符串的几种方式（字面量、new String()）
        // 2. 获取字符串长度
        // 3. 字符串连接（+ 和 concat()）
        // 4. 字符串比较（== 和 equals()）
        // 思考：为什么 == 和 equals() 的结果可能不同？
        
        String str1 = "Hello";
        String str2 = new String("Hello");
        
        // 请在此处编写代码并打印结果
        System.out.println("str1长度: " + str1.length());
        System.out.println("str2长度: " + str2.length());
        
        // 字符串连接：使用 + 运算符
        String concat1 = str1 + " world";
        System.out.println("使用+连接: " + concat1);
        
        // 字符串连接：使用concat()方法
        String concat2 = str1.concat(" world");
        System.out.println("使用concat()连接: " + concat2);
        
        // 字符串比较：== 比较引用地址
        System.out.println("str1 == str2: " + (str1 == str2));
        // 字符串比较：equals()比较内容
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        
        // 说明：== 比较的是对象引用，str1在字符串常量池中，str2是新对象，所以==返回false
        // equals()比较的是字符串内容，所以返回true
    }

    /**
     * 练习9：字符串常用方法
     */
    public static void practice9_StringMethods(String str) {
        // TODO: 实现以下操作并打印结果
        // 1. 转大写：toUpperCase()
        // 2. 转小写：toLowerCase()
        // 3. 去除首尾空格：trim()
        // 4. 字符串替换：replace()
        // 5. 字符串分割：split()
        // 6. 字符串截取：substring()
        // 7. 查找字符位置：indexOf()
        // 8. 判断是否包含：contains()
        
        System.out.println("\n=== 练习9：字符串方法 ===");
        System.out.println("原始字符串: " + str);
        // 请在此处编写代码
        System.out.println("大写"+str.toUpperCase());
        System.out.println("小写"+str.toLowerCase());
        String strTrim = str.trim();
        System.out.println("去除空格："+strTrim);

        String[] arr = str.split(" ");

        System.out.println(Arrays.toString(arr));
        String string = str.substring(7);
        System.out.println(string);

        long index = str.indexOf("Hello");
        System.out.println(index);

        boolean hasStr =  str.contains("Hello");
        System.out.println(hasStr);

    }

    /**
     * 练习10：StringBuilder和StringBuffer
     * 任务：理解可变字符串的使用场景
     */
    public static String practice10_StringBuilder() {
        // 使用StringBuilder连接1000个"Hello"字符串
        StringBuilder sb = new StringBuilder();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            sb.append("Hello");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("StringBuilder耗时: " + (t2 - t1) + "ms");

        // String直接拼接对比
        String s = "";
        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            s += "Hello";
        }
        long t4 = System.currentTimeMillis();
        System.out.println("String耗时: " + (t4 - t3) + "ms");

        // StringBuffer拼接对比
        StringBuffer sbf = new StringBuffer();
        long t5 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            sbf.append("Hello");
        }
        long t6 = System.currentTimeMillis();
        System.out.println("StringBuffer耗时: " + (t6 - t5) + "ms");

        /**
         * 什么时候用StringBuilder，什么时候用StringBuffer？
         * 答：StringBuilder线程不安全，但速度快，适用于单线程环境；
         * StringBuffer线程安全（方法加了synchronized），但速度稍慢，适用于多线程环境。
         */

        return sb.toString();
    }

    /**
     * 练习11：字符串反转
     * 任务：实现字符串反转功能
     */
    public static String practice11_ReverseString(String str) {
        // 方法1：使用StringBuilder的reverse()
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();

        // 方法2：手动反转（可选）
        /*
        if (str == null) return null;
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
        */
    }

    /**
     * 练习12：字符串综合练习
     * 任务：判断一个字符串是否为回文（正反读都一样）
     */
    public static boolean practice12_IsPalindrome(String str) {
        // 判断字符串是否为回文
        // 例如："level"是回文，"hello"不是回文
        // 忽略大小写和空格
        
        // 处理 null 和空字符串
        if (str == null || str.length() == 0) {
            return false;
        }
        
        // 去除空格并转换为小写，便于比较
        String processed = str.replaceAll("\\s+", "").toLowerCase();
        
        // 如果处理后为空字符串，返回 false
        if (processed.length() == 0) {
            return false;
        }
        
        // 方法1：使用双指针从两端向中间比较（推荐，效率高）
        int left = 0;
        int right = processed.length() - 1;
        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
        // 方法2：反转字符串后比较（备选方案）
        // String reversed = new StringBuilder(processed).reverse().toString();
        // return processed.equals(reversed);
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_ArrayDeclaration();
        
        int[] arr = {5, 2, 8, 1, 9, 3};
        practice2_ArrayTraversal(arr);
        
        int[] maxMin = practice3_FindMaxAndMin(arr);
        if (maxMin != null) {
            System.out.println("最大值: " + maxMin[0] + ", 最小值: " + maxMin[1]);
        }
        
        System.out.println("查找8的索引: " + practice4_SearchInArray(arr, 8));
        
        int[] arrToSort = {5, 2, 8, 1, 9, 3};
        practice5_SortArray(arrToSort);
        
        practice7_TwoDimensionalArray();
        practice8_StringBasics();
        practice9_StringMethods("  Hello World Java  ");
        
        System.out.println("\n字符串反转: " + practice11_ReverseString("Hello"));
        
        System.out.println("\n回文判断:");
        System.out.println("level: " + practice12_IsPalindrome("level"));
        System.out.println("hello: " + practice12_IsPalindrome("hello"));
        System.out.println("A man a plan a canal Panama: " + 
            practice12_IsPalindrome("A man a plan a canal Panama"));
    }
}

