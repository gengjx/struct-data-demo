package com.struct.practice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 面向对象编程练习
 * 练习内容：
 * 1. 类的定义和对象的创建
 * 2. 封装（private、getter、setter）
 * 3. 继承（extends、super、方法重写）
 * 4. 多态（方法重载、方法重写、向上转型、向下转型）
 * 5. 抽象类和抽象方法
 */
public class OOPPractice {

    /**
     * 练习1：类的定义和封装
     * 任务：创建一个学生类（Student），包含属性：姓名、年龄、学号
     * 要求：使用private封装属性，提供getter和setter方法
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    static class Student extends Person {
        private String studentId;
        // 练习9：static关键字 - 学生总数
        private static int studentCount = 0;
        // 练习10：final关键字 - 常量
        private static final String SCHOOL_NAME = "示例学校";

        // static代码块：初始化操作
        static {
            System.out.println("Student类被加载，执行static代码块");
        }

        public Student() {
            super();
            studentCount++;
        }

        public Student(int age, String name, String studentId) {
            super(age, name);
            this.studentId = studentId;
            studentCount++;
        }

        public Student(String name, String studentId) {
            super(0, name); // 修复：使用super调用父类构造方法，而不是直接访问私有字段
            this.studentId = studentId;
            studentCount++;
        }

        // 练习9：static方法：获取学生总数
        public static int getStudentCount() {
            return studentCount;
        }

        // 练习6：方法重写（Override）
        @Override
        public void introduce() {
            super.introduce();
            System.out.println("我是一个学生，我的学号是：" + this.studentId);
        }

        // 练习7：方法重载（Overload）
        public void study() {
            System.out.println("正在学习");
        }

        public void study(String subject) {
            System.out.println("正在学习" + subject);
        }

        public void study(String subject, int hours) {
            System.out.println("正在学习" + subject + "，已经学习了" + hours + "小时");
        }

        // 练习10：final方法：不能被子类重写
        public final void graduate() {
            System.out.println("学生" + getName() + "毕业了！");
        }
    }

    @Data
    static class Person {
        // 将字段改为protected，以便子类可以访问（虽然Lombok会生成getter/setter）
        protected int age;
        protected String name;

        public Person() {
            this.age = 0;
            this.name = "";
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        protected void introduce() {
            System.out.println("我是：" + name + "，年龄：" + age);
        }
    }

    /**
     * 练习2：构造方法
     * 任务：在Student类中添加多种构造方法
     * 1. 无参构造方法
     * 2. 有参构造方法（包含所有属性）
     * 3. 部分参数的构造方法（只有姓名和学号）
     */

    /**
     * 练习3：this关键字
     * 任务：在Student类中使用this关键字
     * 理解this的作用：指向当前对象
     */

    /**
     * 练习4：继承
     * 任务：创建一个Person类，然后让Student继承Person
     * Person类包含：姓名、年龄
     * Student类额外包含：学号、专业
     */
    // TODO: 创建Person基类
    // class Person {
    //     protected String name;
    //     protected int age;
    //     
    //     // 构造方法
    //     // getter和setter
    //     public void introduce() {
    //         System.out.println("我是" + name + "，今年" + age + "岁");
    //     }
    // }

    /**
     * 练习5：super关键字
     * 任务：在Student类中使用super调用父类的方法和构造方法
     */

    /**
     * 练习6：方法重写（Override）
     * 任务：在Student类中重写Person的introduce()方法
     * 输出更详细的信息（包括学号和专业）
     */

    /**
     * 练习7：方法重载（Overload）
     * 任务：在Student类中创建多个同名但参数不同的方法
     * 例如：study()方法
     * - study()：无参数，输出"正在学习"
     * - study(String subject)：有参数，输出"正在学习{subject}"
     * - study(String subject, int hours)：有参数，输出"正在学习{subject}，已经学习了{hours}小时"
     */

    /**
     * 练习8：多态
     * 任务：理解多态的概念
     */
    public static void practice8_Polymorphism() {
        System.out.println("\n=== 练习8：多态 ===");
        
        // 1. 向上转型：Person person = new Student(...)
        Person person = new Student(20, "张三", "2024001");
        System.out.println("向上转型：Person person = new Student(...)");
        
        // 2. 调用重写的方法，观察结果（多态：运行时调用子类重写的方法）
        System.out.println("调用person.introduce()：");
        person.introduce(); // 实际调用的是Student类重写的introduce方法
        
        // 3. 向下转型：Student student = (Student) person
        // 思考：为什么需要向下转型？
        // 答：因为向上转型后，只能调用父类中定义的方法，无法调用子类特有的方法
        // 如果需要调用子类特有的方法（如study()），就需要向下转型
        if (person instanceof Student) {
            Student student = (Student) person;
            System.out.println("向下转型后，可以调用子类特有的方法：");
            student.study("Java");
        }
        
        // 多态的应用：使用父类引用指向不同子类对象
        System.out.println("\n多态应用示例：");
        Person[] people = {
            new Student(18, "李四", "2024002"),
            new Student(19, "王五", "2024003")
        };
        
        for (Person p : people) {
            p.introduce(); // 多态：同一个方法调用，根据实际对象类型执行不同的实现
        }
    }

    /**
     * 练习9：static关键字
     * 任务：理解static修饰的属性和方法
     */
    // TODO: 在Student类中添加
    // 1. static属性：学生总数
    // 2. static方法：获取学生总数
    // 3. static代码块：初始化操作
    // 思考：static方法和普通方法的区别？

    /**
     * 练习10：final关键字
     * 任务：理解final的用法
     * 1. final修饰变量：常量（已在Student类中演示：SCHOOL_NAME）
     * 2. final修饰方法：不能被子类重写（已在Student类中演示：graduate()）
     * 3. final修饰类：不能被继承
     */
    // final类示例：不能被继承
    final static class FinalClass {
        public void show() {
            System.out.println("这是一个final类，不能被继承");
        }
    }
    
    // 如果尝试继承final类，会编译错误
    // class SubClass extends FinalClass { } // 编译错误！

    /**
     * 练习11：访问修饰符
     * 任务：理解四种访问修饰符
     */
    // TODO: 创建示例说明访问修饰符
    // public: 公开的，所有类都可以访问
    // protected: 受保护的，同一包或子类可以访问
    // default（无修饰符）: 包访问权限，同一包可以访问
    // private: 私有的，只有本类可以访问

    /**
     * 练习12：综合练习
     * 任务：创建一个完整的类层次结构
     * 动物(Animal) -> 哺乳动物(Mammal) -> 狗(Dog)、猫(Cat)
     * 要求：
     * 1. 使用继承
     * 2. 使用方法重写
     * 3. 使用多态
     * 4. 使用封装
     */
    // 抽象类：动物
    abstract static class Animal {
        protected String name;
        
        public Animal(String name) {
            this.name = name;
        }
        
        // 抽象方法：必须由子类实现
        public abstract void makeSound();
        
        // 普通方法：所有动物都可以吃东西
        public void eat() {
            System.out.println(name + "正在吃东西");
        }
        
        public String getName() {
            return name;
        }
    }
    
    // 哺乳动物类：继承Animal（抽象类，因为包含抽象方法）
    abstract static class Mammal extends Animal {
        protected boolean hasFur;
        
        public Mammal(String name, boolean hasFur) {
            super(name);
            this.hasFur = hasFur;
        }
        
        // 哺乳动物特有的方法
        public void giveBirth() {
            System.out.println(name + "是胎生动物");
        }
        
        // 实现抽象方法（但仍然是抽象的，由子类具体实现）
        @Override
        public abstract void makeSound();
    }
    
    // 狗类：继承Mammal
    static class Dog extends Mammal {
        private String breed; // 品种
        
        public Dog(String name, String breed) {
            super(name, true);
            this.breed = breed;
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + "（" + breed + "）在叫：汪汪汪！");
        }
        
        // 狗特有的方法
        public void wagTail() {
            System.out.println(name + "在摇尾巴");
        }
    }
    
    // 猫类：继承Mammal
    static class Cat extends Mammal {
        private String color; // 颜色
        
        public Cat(String name, String color) {
            super(name, true);
            this.color = color;
        }
        
        @Override
        public void makeSound() {
            System.out.println(name + "（" + color + "色）在叫：喵喵喵！");
        }
        
        // 猫特有的方法
        public void climbTree() {
            System.out.println(name + "在爬树");
        }
    }
    
    /**
     * 测试综合练习
     */
    public static void practice12_Comprehensive() {
        System.out.println("\n=== 练习12：综合练习 ===");
        
        // 使用多态：父类引用指向子类对象
        Animal[] animals = {
            new Dog("旺财", "金毛"),
            new Cat("小花", "橘")
        };
        
        System.out.println("多态演示：");
        for (Animal animal : animals) {
            animal.eat();        // 调用继承的方法
            animal.makeSound();  // 多态：根据实际对象类型调用不同的实现
            
            // 向下转型以调用子类特有方法
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.wagTail();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.climbTree();
            }
            System.out.println();
        }
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 面向对象编程练习 ===\n");
        
        // 1. 创建Student对象
        System.out.println("--- 练习1-3：类的定义、封装和构造方法 ---");
        Student student1 = new Student(18, "张三", "2024001");
        System.out.println("创建学生对象：" + student1);
        System.out.println("年龄：" + student1.getAge());
        System.out.println("姓名：" + student1.getName());
        System.out.println("学号：" + student1.getStudentId());
        
        // 2. 测试封装（getter/setter）
        System.out.println("\n--- 测试封装（getter/setter） ---");
        student1.setAge(19);
        student1.setName("张三（已改名）");
        System.out.println("修改后：" + student1);
        
        // 3. 测试继承和方法重写
        System.out.println("\n--- 练习4-6：继承和方法重写 ---");
        student1.introduce();
        
        // 4. 测试方法重载
        System.out.println("\n--- 练习7：方法重载 ---");
        student1.study();
        student1.study("数学");
        student1.study("Java编程", 3);
        
        // 5. 测试多态
        System.out.println("\n--- 测试多态 ---");
        Person person = new Student(20, "李四", "2024002");
        person.introduce(); // 多态：调用子类重写的方法
        
        // 向下转型以调用子类特有方法
        if (person instanceof Student) {
            Student student2 = (Student) person;
            student2.study("英语");
        }
        
        // 6. 测试static关键字
        System.out.println("\n--- 练习9：static关键字 ---");
        System.out.println("当前学生总数：" + Student.getStudentCount());
        System.out.println("学校名称（final常量）：" + Student.SCHOOL_NAME);
        
        // 7. 测试final方法
        System.out.println("\n--- 练习10：final关键字 ---");
        student1.graduate();
        
        // 8. 测试多态（完整演示）
        practice8_Polymorphism();
        
        // 9. 综合练习
        practice12_Comprehensive();
    }
}

