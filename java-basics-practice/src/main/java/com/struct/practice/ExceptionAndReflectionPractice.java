package com.struct.practice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import lombok.Data;
import lombok.ToString;

/**
 * 异常处理和反射练习
 * 练习内容：
 * 1. 异常的分类（Checked Exception、Unchecked Exception）
 * 2. try-catch-finally
 * 3. throw和throws
 * 4. 自定义异常
 * 5. 反射的基本使用（Class、Method、Field）
 * 6. 通过反射创建对象、调用方法、访问字段
 */
public class ExceptionAndReflectionPractice {

    /**
     * 练习1：try-catch-finally
     * 任务：理解异常处理的基本结构
     */
    public static void practice1_TryCatchFinally() {
        System.out.println("=== 练习1：try-catch-finally ===");
        
        // TODO: 编写异常处理代码
        // 1. 可能抛出异常的代码放在try块中
        // 2. 捕获异常使用catch块
        // 3. 无论是否异常都会执行finally块
        
        try {
            int result = 10 / 0; // 会抛出ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        } finally {
            System.out.println("finally块总是会执行");
        }
    }

    /**
     * 练习2：多个catch块
     * 任务：处理多种异常
     */
    public static void practice2_MultipleCatch() {
        System.out.println("\n=== 练习2：多个catch块 ===");
        
        // TODO: 使用多个catch块处理不同类型的异常
        // 注意：子类异常要在父类异常之前捕获
        
        try {
            // String str = null;
            // int length = str.length(); // 可能抛出NullPointerException
            int[] arr = new int[5];
            int value = arr[10]; // 可能抛出ArrayIndexOutOfBoundsException
        } catch (NullPointerException e) {
            System.out.println("空指针异常: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("其他异常: " + e.getMessage());
        }
    }

    /**
     * 练习3：try-with-resources
     * 任务：自动资源管理
     */
    public static void practice3_TryWithResources() {
        System.out.println("\n=== 练习3：try-with-resources ===");
        
        // TODO: 使用try-with-resources自动关闭资源
        // 要求：资源类必须实现AutoCloseable接口
        
        // try (FileInputStream fis = new FileInputStream("test.txt");
        //      FileOutputStream fos = new FileOutputStream("output.txt")) {
        //     // 使用资源
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // // 资源会自动关闭，不需要手动调用close()
    }

    /**
     * 练习4：throw关键字
     * 任务：手动抛出异常
     */
    public static void practice4_Throw() {
        System.out.println("\n=== 练习4：throw ===");
        
        // TODO: 使用throw手动抛出异常
        // 场景：验证年龄，如果年龄小于0或大于150，抛出异常
        
        int age = 100;
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("年龄必须在0-150之间: " + age);
        }
    }

    /**
     * 练习5：throws关键字
     * 任务：声明方法可能抛出的异常
     */
    public static void practice5_Throws() throws Exception {
        // TODO: 在方法签名中使用throws声明异常
        // 调用者必须处理这个异常或者继续向上抛出
        
        // public void method() throws IOException {
        //     // 方法体
        // }
    }

    /**
     * 练习6：自定义异常
     * 任务：创建自定义异常类
     */
    // TODO: 创建自定义异常类
    // class BusinessException extends Exception {
    //     private String errorCode;
    //     
    //     public BusinessException(String message, String errorCode) {
    //         super(message);
    //         this.errorCode = errorCode;
    //     }
    //     
    //     public String getErrorCode() {
    //         return errorCode;
    //     }
    // }


    
    // 使用：
    // throw new BusinessException("业务异常", "ERR001");

    /**
     * 练习7：获取Class对象
     * 任务：理解获取Class对象的三种方式
     * @throws ClassNotFoundException 
     */
    public static void practice7_GetClass() throws ClassNotFoundException {
        System.out.println("\n=== 练习7：获取Class对象 ===");
        
        // TODO: 演示获取Class对象的三种方式
        // 1. 类名.class
        // 2. 对象.getClass()
        // 3. Class.forName("完整类名")
        
        // Class<?> clazz1 = String.class;
        // Class<?> clazz2 = "hello".getClass();
        // Class<?> clazz3 = Class.forName("java.lang.String");


        Class clazz = String.class;

        Class clazz1 = "hello world".getClass();

        Class clazz2 = Class.forName("java.lang.String");

        System.out.println(clazz);

        System.out.println(clazz1);

        System.out.println(clazz2);
         
    }

    /**
     * 练习8：通过反射创建对象
     * 任务：使用反射创建类的实例
     */
    public static void practice8_CreateObjectByReflection() {
        System.out.println("\n=== 练习8：反射创建对象 ===");
        
        // TODO: 通过反射创建对象
        // 1. 使用无参构造方法
        // 2. 使用有参构造方法
        
        try {
            // 获取Class对象
            Class<?> clazz = Class.forName("java.lang.String");
            
            // 方式1：使用无参构造方法
            // Object obj1 = clazz.newInstance(); // 已废弃
            Constructor<?> constructor = clazz.getConstructor(String.class);
            Object obj = constructor.newInstance("Hello Reflection");
            System.out.println("创建的对象: " + obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习9：通过反射调用方法
     * 任务：使用反射调用对象的方法
     */
    public static void practice9_InvokeMethodByReflection() {
        System.out.println("\n=== 练习9：反射调用方法 ===");
        
        // TODO: 通过反射调用方法
        // 1. 获取Method对象
        // 2. 调用invoke()方法
        
        try {
            String str = "Hello";
            Class<?> clazz = str.getClass();
            
            // 获取方法
            Method method = clazz.getMethod("toUpperCase");
            
            // 调用方法
            Object result = method.invoke(str);
            System.out.println("方法调用结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Target({ElementType.TYPE,ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface TestAnnotation {
        String value();
    }

    @Data
    @ToString
    static class Student {
        @TestAnnotation("gengjiaixn")
        private String name;
        private int age;
        public Student(){
            this.age = 0;
            this.name = "";
        }
    }

    /**
     * 练习10：通过反射访问字段
     * 任务：使用反射访问和修改对象的字段
     * @throws Exception 
     * @throws NoSuchFieldException 
     */
    public static void practice10_AccessFieldByReflection() throws Exception {
        System.out.println("\n=== 练习10：反射访问字段 ===");

        // 获取Student类的Class对象
        Class<?> clazz = Student.class;
        System.out.println("Class对象: " + clazz);

        // 获取所有构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("所有构造方法: " + Arrays.toString(constructors));

        // 获取无参构造方法并实例化Student对象
        Constructor<?> constructor = clazz.getConstructor();
        Student student = (Student) constructor.newInstance();
        System.out.println("新建的student对象: " + student);

        // 访问和修改公有字段age
        Field ageField = clazz.getDeclaredField("age");
        System.out.println("age字段: " + ageField);
        System.out.println("初始age: " + ageField.get(student));
        ageField.set(student, 2);
        System.out.println("修改后的age: " + ageField.get(student));

        // 访问和修改私有字段name
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true); // 允许访问私有字段
        System.out.println("name字段(私有): " + nameField);
        System.out.println("初始name: " + nameField.get(student));
        nameField.set(student, "张三");
        String name = (String) nameField.get(student);
        System.out.println("修改后的name: " + name);

        System.out.println("最终student对象结果: " + student);
    }

    /**
     * 练习11：反射获取类的信息
     * 任务：获取类的所有信息
     */
    public static void practice11_GetClassInfo(Class<?> clazz) {
        System.out.println("\n=== 练习11：获取类信息 ===");
        
        // TODO: 获取类的各种信息
        // 1. 类名：getName(), getSimpleName()
        // 2. 包名：getPackage()
        // 3. 父类：getSuperclass()
        // 4. 实现的接口：getInterfaces()
        // 5. 所有方法：getMethods(), getDeclaredMethods()
        // 6. 所有字段：getFields(), getDeclaredFields()
        // 7. 所有构造方法：getConstructors(), getDeclaredConstructors()
        
        System.out.println("类名: " + clazz.getName());
        System.out.println("简单类名: " + clazz.getSimpleName());
        System.out.println("包路径："+ clazz.getPackageName());
        System.out.println("父类："+ clazz.getSuperclass());
        System.out.println("实现的接口"+ clazz.getInterfaces());
        // System.out.println("所有方法："+ Arrays. toString(clazz.getMethods()));
        // System.out.println("所有方法："+ Arrays. toString(clazz.getDeclaredMethods()));

        // 请在此处编写代码
    }

    /**
     * 练习12：注解和反射结合
     * 任务：通过反射读取注解信息
     */
    public static void practice12_AnnotationAndReflection() {
        System.out.println("\n=== 练习12：注解和反射 ===");
        
        // TODO: 结合使用注解和反射
        // 1. 定义注解
        // 2. 在类/方法/字段上使用注解
        // 3. 通过反射读取注解信息
        
        // @Target(ElementType.METHOD)
        // @Retention(RetentionPolicy.RUNTIME)
        // @interface TestAnnotation {
        //     String value();
        // }
        // 
        // class TestClass {
        //     @TestAnnotation("测试方法")
        //     public void testMethod() {}
        // }
        // 
        // 通过反射获取注解
        // Method method = TestClass.class.getMethod("testMethod");
        // TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        // System.out.println(annotation.value());


        class TestClass {
            @TestAnnotation(value = "测试方法注解")
            public void test(){
                System.out.println("测试方法");
            }            
        }
        TestClass testClass = new TestClass();
        Class clazz = testClass.getClass();

        try {
            Method method =  clazz.getMethod("test");
            TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
            System.out.printf("方法上的注解内容 %s", testAnnotation.value());
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 练习13：综合练习
     * 任务：实现一个简单的依赖注入框架
     */
    public static void practice13_SimpleDI() {
        // TODO: 实现简单的依赖注入
        // 1. 定义注解标记需要注入的字段
        Student student = new Student();
        System.out.println("依赖注入前：" + student);
        // 2. 通过反射扫描注解
        Class clazz = student.getClass();

        try{
            Field field = clazz.getDeclaredField("name");
            System.out.println(field);
            TestAnnotation testAnnotation = (TestAnnotation)field.getAnnotation(TestAnnotation.class);
            System.out.println(testAnnotation.value());
            field.set(student, testAnnotation.value());
            System.out.println("依赖注入后："+student);
        }catch(Exception e){
            System.out.println(e);
        }
      
        // 3. 创建对象并注入依赖
    }


    // 测试方法
    public static void main(String[] args) {
        practice1_TryCatchFinally();
        practice2_MultipleCatch();
        practice4_Throw();
        
        try {
            practice7_GetClass();
            practice8_CreateObjectByReflection();
            practice9_InvokeMethodByReflection();
            practice10_AccessFieldByReflection();
            practice11_GetClassInfo(String.class);
            practice12_AnnotationAndReflection();
            practice13_SimpleDI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

