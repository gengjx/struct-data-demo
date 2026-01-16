package com.struct.practice;

import org.junit.Assert;

/**
 * 接口、抽象类、内部类练习
 * 练习内容：
 * 1. 接口的定义和实现
 * 2. 接口的默认方法和静态方法
 * 3. 抽象类的定义
 * 4. 接口vs抽象类的区别
 * 5. 内部类（成员内部类、局部内部类、匿名内部类、静态内部类）
 */
public class InterfaceAndInnerClassPractice {

    /**
     * 练习1：接口的定义
     * 任务：定义一个Drawable接口，包含draw()方法
     */
    // TODO: 定义接口
    // interface Drawable {
    //     void draw();
    // }
        /**
     * 练习2：接口的实现
     * 任务：创建Circle和Rectangle类实现Drawable接口
     */
    // TODO: 实现接口
    // class Circle implements Drawable {
    //     private double radius;
    //     
    //     @Override
    //     public void draw() {
    //         System.out.println("画一个圆形，半径: " + radius);
    //     }
    // }

    /**
     * 练习3：接口的多实现
     * 任务：定义一个Colorable接口，让Circle类同时实现Drawable和Colorable
     */
    // TODO: 定义Colorable接口
    // interface Colorable {
    //     void setColor(String color);
    //     String getColor();
    // }

        /**
     * 练习4：接口的默认方法（Java 8+）
     * 任务：在接口中定义默认方法
     */
    // TODO: 在Drawable接口中添加默认方法
    // interface Drawable {
    //     void draw();
    //     
    //     // 默认方法
    //     default void printInfo() {
    //         System.out.println("这是一个可绘制的对象");
    //     }
    // }

    /**
     * 练习5：接口的静态方法（Java 8+）
     * 任务：在接口中定义静态方法
     */
    // TODO: 在Drawable接口中添加静态方法
    // interface Drawable {
    //     void draw();
    //     
    //     static void showVersion() {
    //         System.out.println("Drawable接口版本 1.0");
    //     }
    // }

    /**
     * 练习1-5：Drawable接口
     * 包含抽象方法、默认方法和静态方法
     */
    static interface Drawable {
        /**
         * 绘制方法
         */
        void draw();

        /**
         * 静态方法（Java 8+）
         */
        static void testStatic() {
            System.out.println("Java 8 新特性，接口静态方法");
        }

        /**
         * 默认方法（Java 8+）
         */
        default void printInfo() {
            System.out.println("这是一个可绘制的对象");
        }
    }

    /**
     * 练习2-3：Circle类
     * 实现Drawable和Colorable接口，演示接口的多实现
     */
    static class Circle implements Drawable, Colorable {
        private double radius;
        private String color;

        public Circle() {
            this(0.0);
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            if (radius < 0) {
                throw new IllegalArgumentException("半径不能为负数");
            }
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("绘制一个圆形，半径: " + radius);
        }

        @Override
        public String getColor() {
            return color;
        }

        @Override
        public void setColor(String color) {
            this.color = color;
        }
    }

    /**
     * 练习2：Rectangle类
     * 实现Drawable接口
     */
    static class Rectangle implements Drawable {
        @Override
        public void draw() {
            System.out.println("绘制一个矩形");
        }
    }

    /**
     * 练习3：Colorable接口
     * 定义颜色相关的行为
     */
    static interface Colorable {
        String getColor();
        void setColor(String color);
    }


        /**
     * 练习6：函数式接口和Lambda表达式
     * 任务：定义一个函数式接口并使用Lambda表达式
     */
    // TODO: 定义函数式接口
    // @FunctionalInterface
    // interface Calculator {
    //     int calculate(int a, int b);
    // }
    // 
    // 使用示例：
    // Calculator add = (a, b) -> a + b;
    // Calculator multiply = (a, b) -> a * b;

    /**
     * 练习6：函数式接口
     * 用于Lambda表达式
     */
    @FunctionalInterface
    static interface Calculator {
        int calculate(int a, int b);
    } 

        /**
     * 练习7：抽象类的定义
     * 任务：定义一个Shape抽象类
     */
    // TODO: 定义抽象类
    // abstract class Shape {
    //     protected String name;
    //     
    //     // 抽象方法
    //     public abstract double calculateArea();
    //     
    //     // 普通方法
    //     public void printName() {
    //         System.out.println("形状名称: " + name);
    //     }
    // }

        /**
     * 练习8：抽象类的实现
     * 任务：创建Triangle类继承Shape抽象类
     */
    // TODO: 实现抽象类
    // class Triangle extends Shape {
    //     private double base;
    //     private double height;
    //     
    //     @Override
    //     public double calculateArea() {
    //         return 0.5 * base * height;
    //     }
    // }


    /**
     * 练习7：Shape抽象类
     * 定义图形的共同属性和行为
     */
    static abstract class Shape {
        protected String name;

        /**
         * 抽象方法：计算面积
         */
        public abstract double calculateArea();

        /**
         * 普通方法：打印名称
         */
        public void printName() {
            System.out.println("形状名称: " + name);
        }
    }

    /**
     * 练习8：Triangle类
     * 继承Shape抽象类，实现面积计算
     */
    static class Triangle extends Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            if (base <= 0 || height <= 0) {
                throw new IllegalArgumentException("底边和高必须大于0");
            }
            this.name = "三角形";
            this.base = base;
            this.height = height;
        }

        public double getBase() {
            return base;
        }

        public void setBase(double base) {
            if (base <= 0) {
                throw new IllegalArgumentException("底边必须大于0");
            }
            this.base = base;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            if (height <= 0) {
                throw new IllegalArgumentException("高必须大于0");
            }
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }



    /**
     * 练习9：接口vs抽象类
     * 任务：理解两者的区别和使用场景
     */
    // 区别：
    // 1. 接口：多继承，只能有抽象方法（Java 8之前），默认public
    // 2. 抽象类：单继承，可以有抽象方法和普通方法，可以有构造方法
    // 3. 使用场景：
    //    - 接口：定义行为契约，多个类可能有相同行为
    //    - 抽象类：有部分共同实现的类层次结构

    /**
     * 练习10：成员内部类
     * 任务：创建外部类和内部类
     */
    // TODO: 创建成员内部类示例
    // class Outer {
    //     private String outerField = "外部类字段";
    //     
    //     class Inner {
    //         private String innerField = "内部类字段";
    //         
    //         public void accessOuter() {
    //             System.out.println("访问外部类字段: " + outerField);
    //         }
    //     }
    //     
    //     public void createInner() {
    //         Inner inner = new Inner();
    //         inner.accessOuter();
    //     }
    // }

    /**
     * 练习11：静态内部类
     * 任务：创建静态内部类
     */
    // TODO: 创建静态内部类示例
    // class Outer {
    //     private static String outerField = "外部类静态字段";
    //     
    //     static class StaticInner {
    //         public void accessOuter() {
    //             System.out.println("访问外部类静态字段: " + outerField);
    //         }
    //     }
    // }

    /**
     * 练习12：局部内部类
     * 任务：在方法内部创建类
     */
    // TODO: 创建局部内部类示例
    // class Outer {
    //     public void method() {
    //         class LocalInner {
    //             public void print() {
    //                 System.out.println("局部内部类");
    //             }
    //         }
    //         
    //         LocalInner local = new LocalInner();
    //         local.print();
    //     }
    // }

    /**
     * 练习10-12：Outer类
     * 演示成员内部类、静态内部类和局部内部类
     */
    static class Outer {
        private String outerField = "外部类实例字段";
        private static final String OUTER_STATIC_FIELD = "外部类静态字段";

        /**
         * 练习10：创建成员内部类
         */
        public void createInner() {
            Inner inner = new Inner();
            inner.accessOuter();
        }

        /**
         * 练习12：局部内部类
         */
        public void method() {
            class LocalInner {
                public void print() {
                    System.out.println("局部内部类方法实现");
                    System.out.println("可以访问外部类字段: " + outerField);
                }
            }

            LocalInner local = new LocalInner();
            local.print();
        }

        /**
         * 练习10：成员内部类
         * 可以访问外部类的所有成员（包括私有成员）
         */
        class Inner {
            private String innerField = "内部类字段";

            public void accessOuter() {
                System.out.println("成员内部类访问外部类实例字段: " + outerField);
                System.out.println("成员内部类访问外部类静态字段: " + OUTER_STATIC_FIELD);
                System.out.println("成员内部类自己的字段: " + innerField);
            }
        }

        /**
         * 练习11：静态内部类
         * 只能访问外部类的静态成员
         */
        static class InnerStatic {
            public static void method() {
                System.out.println("静态内部类，访问外部类静态字段: " + OUTER_STATIC_FIELD);
            }
        }
    }

    /**
     * 练习13：匿名内部类
     * 使用匿名内部类实现接口
     */
    public static void practice13_AnonymousInnerClass() {
        System.out.println("\n=== 练习13：匿名内部类 ===");
        
        // 使用匿名内部类实现Drawable接口
        Drawable drawable = new Drawable() {
            @Override
            public void draw() {
                System.out.println("使用匿名内部类绘制");
            }
        };
        drawable.draw();
        
        // 使用匿名内部类实现抽象类
        Shape shape = new Shape() {
            @Override
            public double calculateArea() {
                return 100.0;
            }
        };
        System.out.println("匿名内部类实现的形状面积: " + shape.calculateArea());
    }

    /**
     * 练习14：内部类的使用场景
     * 任务：理解内部类的实际应用
     */
    // 使用场景：
    // 1. 成员内部类：当内部类需要访问外部类的所有成员时
    // 2. 静态内部类：当内部类不需要访问外部类的实例成员时
    // 3. 局部内部类：只在某个方法内使用的类
    // 4. 匿名内部类：一次性使用的类，常用于事件监听器

    /**
     * 练习15：综合练习
     * 任务：创建一个完整的示例，包含接口、抽象类和内部类
     */
    // TODO: 创建完整的示例
    // 例如：图形绘制系统
    // 1. Drawable接口（定义绘制行为）
    // 2. Shape抽象类（定义图形的共同属性）
    // 3. Circle类（实现接口和继承抽象类）
    // 4. ShapeManager类（包含内部类用于管理形状）

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        System.out.println("=== 接口、抽象类、内部类练习 ===\n");
        
        // 练习1-3：接口的定义和实现
        System.out.println("【练习1-3】接口的定义和实现：");
        Circle circle = new Circle(5.0);
        circle.draw();
        circle.setColor("紫色");
        Assert.assertEquals("紫色", circle.getColor());
        System.out.println();

        // 练习4-5：接口的默认方法和静态方法
        System.out.println("【练习4-5】接口的默认方法和静态方法：");
        Drawable drawable = new Circle(3.0);
        drawable.printInfo();
        Drawable.testStatic();
        System.out.println();

        // 练习6：函数式接口和Lambda表达式
        System.out.println("【练习6】函数式接口和Lambda表达式：");
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Assert.assertEquals(3, add.calculate(1, 2));
        Assert.assertEquals(6, multiply.calculate(2, 3));
        System.out.println("加法: " + add.calculate(1, 2));
        System.out.println("乘法: " + multiply.calculate(2, 3));
        System.out.println();

        // 练习7-8：抽象类的使用
        System.out.println("【练习7-8】抽象类和继承：");
        Shape shape = new Triangle(4.0, 3.0);
        shape.printName();
        System.out.println("三角形面积: " + shape.calculateArea());
        System.out.println();

        // 练习9：接口vs抽象类
        System.out.println("【练习9】接口vs抽象类的区别：");
        System.out.println("接口可以多实现，类和类之间只能单继承");
        System.out.println();

        // 练习10-12：内部类
        System.out.println("【练习10-12】内部类：");
        Outer outer = new Outer();
        System.out.println("--- 局部内部类 ---");
        outer.method();
        System.out.println("--- 成员内部类 ---");
        outer.createInner();
        System.out.println("--- 静态内部类 ---");
        Outer.InnerStatic.method();
        System.out.println();

        // 练习13：匿名内部类
        practice13_AnonymousInnerClass();
    }
}

