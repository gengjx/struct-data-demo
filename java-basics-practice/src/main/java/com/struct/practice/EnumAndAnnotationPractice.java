package com.struct.practice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.nio.channels.Pipe.SourceChannel;

import org.junit.Assert;
import org.junit.runners.model.TestClass;

import com.struct.practice.EnumAndAnnotationPractice.Weekday;

/**
 * 枚举和注解练习
 * 练习内容：
 * 1. 枚举的定义和使用
 * 2. 枚举的方法和属性
 * 3. 枚举实现接口
 * 4. 注解的定义
 * 5. 内置注解的使用
 * 6. 自定义注解
 */
public class EnumAndAnnotationPractice {

    /**
     * 练习1：基础枚举
     * 任务：定义一个表示星期几的枚举
     */
    // TODO: 定义枚举
    // enum Weekday {
    //     MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    // }

    static enum Weekday{

        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    }

    /**
     * 练习2：带属性的枚举
     * 任务：创建一个带中文名称的星期枚举
     */
    // TODO: 定义带属性的枚举
    // enum Weekday {
    //     MONDAY("星期一"),
    //     TUESDAY("星期二"),
    //     WEDNESDAY("星期三"),
    //     THURSDAY("星期四"),
    //     FRIDAY("星期五"),
    //     SATURDAY("星期六"),
    //     SUNDAY("星期日");
    //     
    //     private final String chineseName;
    //     
    //     Weekday(String chineseName) {
    //         this.chineseName = chineseName;
    //     }
    //     
    //     public String getChineseName() {
    //         return chineseName;
    //     }
    // }


    static enum WeekDayWithChineseName{

        MONDAY("星期一"),
        TUESDAY("星期二"),
        WEDNESDAY("星期三"),
        THURSDAY("星期四"),
        FRIDAY("星期五"),
        SATURDAY("星期六"),
        SUNDAY("星期日");

        private String chineseName;

        WeekDayWithChineseName(String chineseName) {
            this.chineseName = chineseName;
        }

        public String getChineseName() {
            return chineseName;
        }



    }

        





    /**
     * 练习3：枚举的方法
     * 任务：在枚举中添加方法
     */
    // TODO: 在枚举中添加方法
    // enum Weekday {
    //     MONDAY {
    //         @Override
    //         public boolean isWeekend() {
    //             return false;
    //         }
    //     },
    //     // ... 其他枚举值
    //     SUNDAY {
    //         @Override
    //         public boolean isWeekend() {
    //             return true;
    //         }
    //     };
    //     
    //     public abstract boolean isWeekend();
    // }


    static enum  WeekdayWithMethod{

        MONDAY{
            @Override
            boolean isWeekend() {
                // TODO Auto-generated method stub
               return false;
            }
        },
        
        
        SUNDAY{

            @Override
            boolean isWeekend(){
                return true;            }
        };
        
        
        
        abstract boolean isWeekend();
    }

    /**
     * 练习4：枚举实现接口
     * 任务：让枚举实现接口
     */
    // TODO: 定义接口并让枚举实现
    // interface Printable {
    //     void print();
    // }
    // 
    // enum Color implements Printable {
    //     RED {
    //         @Override
    //         public void print() {
    //             System.out.println("红色");
    //         }
    //     },
    //     GREEN {
    //         @Override
    //         public void print() {
    //             System.out.println("绿色");
    //         }
    //     };
    // }

    public interface Printable {
        void print();
        
    }

    static enum Color implements Printable{

        RED{
            @Override
            public void print() {
                System.out.println("红色");
                
            }
        }


    }

    /**
     * 练习5：枚举的使用
     */
    public static void practice5_EnumUsage() {
        System.out.println("\n=== 练习5：枚举使用 ===");
        
        // TODO: 演示枚举的使用
        // 1. 枚举的遍历：values()
        System.out.println("枚举遍历：");
        for (Weekday values : Weekday.values()) {
            System.out.print(values+" ");
        }
        System.out.println();

        // 2. 字符串转枚举：valueOf()
        String monday = "MONDAY";

        System.out.println(monday +"is enum " + Weekday.valueOf(monday));
        // 3. 枚举的比较：== 和 equals()
        

        // 4. switch中使用枚举

        Weekday weekday = Weekday.MONDAY;

        switch (weekday) {
            case MONDAY:
                System.out.println("这是星期一");
                break;
        
            default:
                break;
        }
    }

    /**
     * 练习6：内置注解的使用
     * 任务：使用Java内置注解
     */
    // TODO: 使用内置注解
    // @Override: 表示方法重写
    // @Deprecated: 表示已过时
    // @SuppressWarnings: 抑制警告
    // @SafeVarargs: 安全可变参数
    // @FunctionalInterface: 函数式接口

    /**
     * 练习7：自定义注解
     * 任务：定义一个自定义注解
     */
    // TODO: 定义自定义注解
    // @Target(ElementType.METHOD)
    // @Retention(RetentionPolicy.RUNTIME)
    // @interface MyAnnotation {
    //     String value() default "";
    //     int count() default 1;
    // }


    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    static @interface MyAnnotation{
        String value() default "";
    }

    /**
     * 练习8：元注解
     * 任务：理解元注解的作用
     */
    // 元注解：
    // 1. @Target: 指定注解可以应用的位置
    //    - ElementType.TYPE: 类、接口、枚举
    //    - ElementType.METHOD: 方法
    //    - ElementType.FIELD: 字段
    //    - ElementType.PARAMETER: 参数
    // 2. @Retention: 指定注解的保留策略
    //    - RetentionPolicy.SOURCE: 只在源码中
    //    - RetentionPolicy.CLASS: 编译到class文件
    //    - RetentionPolicy.RUNTIME: 运行时可用
    // 3. @Documented: 文档化
    // 4. @Inherited: 可继承
    // 5. @Repeatable: 可重复

    /**
     * 练习9：注解的应用
     * 任务：使用自定义注解标记方法
     */
    // TODO: 使用注解
    // class TestClass {
    //     @MyAnnotation(value = "测试方法", count = 3)
    //     public void testMethod() {
    //         System.out.println("测试方法");
    //     }
    // }


    static class TestClass{

        @MyAnnotation(value = "测试方法")
        public void testMethod(){
            System.out.println("测试方法");
        }

    }

    /**
     * 练习10：通过反射获取注解信息
     * 任务：使用反射读取注解
     * @throws NoSuchMethodException 
     */
    public static void practice10_ReadAnnotation() throws NoSuchMethodException {
        // TODO: 使用反射读取注解信息
        // Class<?> clazz = TestClass.class;
        // Method method = clazz.getMethod("testMethod");
        // MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        // if (annotation != null) {
        //     System.out.println("注解值: " + annotation.value());
        //     System.out.println("计数: " + annotation.count());
        // }


        Class class1 = TestClass.class;

        Method method = class1.getMethod("testMethod");

        MyAnnotation myAnnotation =  method.getAnnotation(MyAnnotation.class);
        System.out.println("自定义注解value："+myAnnotation.value());


    }

    /**
     * 练习11：枚举和注解综合应用
     * 任务：创建一个状态机，使用枚举表示状态，注解标记状态转换
     * @throws NoSuchMethodException 
     */
    // TODO: 创建状态机示例
    // enum OrderStatus {
    //     PENDING, PAID, SHIPPED, DELIVERED, CANCELLED
    // }
    // 
    // @Target(ElementType.METHOD)
    // @Retention(RetentionPolicy.RUNTIME)
    // @interface StateTransition {
    //     OrderStatus from();
    //     OrderStatus to();
    // }

    enum OrderStatus{
        PENDING, PAID, SHIPPED, DELIVERED, CANCELLED
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface StateTransition{

        OrderStatus from();
        OrderStatus to();
    }

    static class InnerEnumAndAnnotationPractice {
        
        @StateTransition(from = OrderStatus.PENDING, to = OrderStatus.PAID)
        public void paid(){ 

            System.out.println("这是一个付款动作");
        }
    }




    /**
     * 演示枚举的本质
     */
    public static void demonstrateEnumEssence() {
        System.out.println("\n=== 枚举本质演示 ===");
        
        // 1. 查看枚举的父类
        System.out.println("1. 枚举的父类: " + Weekday.class.getSuperclass());
        System.out.println("   父类名称: " + Weekday.class.getSuperclass().getName());
        
        // 2. 检查是否是枚举
        System.out.println("2. 是否是枚举: " + Weekday.class.isEnum());
        
        // 3. 查看枚举常量（实际上是静态final字段）
        System.out.println("3. 枚举常量（静态final字段）:");
        java.lang.reflect.Field[] fields = Weekday.class.getDeclaredFields();
        for (java.lang.reflect.Field field : fields) {
            if (field.isEnumConstant()) {
                System.out.println("   - " + field.getName() + " : " + field.getType().getSimpleName());
            }
        }
        
        // 4. 查看枚举值的类信息
        System.out.println("4. 枚举值的类信息:");
        System.out.println("   MONDAY的类: " + Weekday.MONDAY.getClass());
        System.out.println("   MONDAY的类名: " + Weekday.MONDAY.getClass().getName());
        
        // 5. 枚举的单例特性
        System.out.println("5. 枚举的单例特性:");
        Weekday day1 = Weekday.MONDAY;
        Weekday day2 = Weekday.MONDAY;
        System.out.println("   day1 == day2: " + (day1 == day2));
        System.out.println("   day1.equals(day2): " + day1.equals(day2));
        System.out.println("   day1的hashCode: " + day1.hashCode());
        System.out.println("   day2的hashCode: " + day2.hashCode());
        
        // 6. 枚举的name和ordinal
        System.out.println("6. 枚举的name和ordinal:");
        for (Weekday day : Weekday.values()) {
            System.out.println("   " + day.name() + " -> ordinal: " + day.ordinal());
        }
        
        // 7. 枚举的比较（基于ordinal）
        System.out.println("7. 枚举的比较（基于ordinal）:");
        System.out.println("   MONDAY.compareTo(TUESDAY): " + Weekday.MONDAY.compareTo(Weekday.TUESDAY));
        System.out.println("   SUNDAY.compareTo(MONDAY): " + Weekday.SUNDAY.compareTo(Weekday.MONDAY));
        
        // 8. 带属性的枚举
        System.out.println("8. 带属性的枚举:");
        System.out.println("   MONDAY的中文名: " + WeekDayWithChineseName.MONDAY.getChineseName());
        System.out.println("   MONDAY的类: " + WeekDayWithChineseName.MONDAY.getClass());
        
        // 9. 带抽象方法的枚举（匿名子类）
        System.out.println("9. 带抽象方法的枚举（匿名子类）:");
        System.out.println("   MONDAY的类: " + WeekdayWithMethod.MONDAY.getClass());
        System.out.println("   SUNDAY的类: " + WeekdayWithMethod.SUNDAY.getClass());
        System.out.println("   注意：每个枚举值可能是不同的匿名子类实例");
    }

    // 测试方法
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("=== 枚举和注解练习 ===");

        System.out.println("注解练习一：注解不带任何属性");
        System.out.println(Weekday.MONDAY);
        System.out.println("注解练习二：带描述属性的注解");
        System.out.println(WeekDayWithChineseName.MONDAY.getChineseName());
        System.out.println("注解练习三: "+Weekday.MONDAY+" isWeekend: "+WeekdayWithMethod.MONDAY.isWeekend());

        System.out.println("注解练习四，注解实现接口方法：");
        Color.RED.print();


        practice5_EnumUsage();
        
        // 演示枚举的本质
        demonstrateEnumEssence();
        
        practice10_ReadAnnotation();
    }
}

