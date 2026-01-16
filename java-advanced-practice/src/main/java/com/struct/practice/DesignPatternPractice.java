package com.struct.practice;

/**
 * 设计模式练习
 * 练习内容：
 * 1. 创建型模式：单例、工厂、建造者、原型
 * 2. 结构型模式：适配器、装饰器、代理、外观、桥接、组合、享元
 * 3. 行为型模式：观察者、策略、责任链、命令、状态、模板方法、迭代器、中介者、备忘录、访问者
 * 
 * 重点练习常用模式：单例、工厂、代理、观察者、策略等
 */
public class DesignPatternPractice {

    /**
     * 练习1：单例模式（Singleton Pattern）
     * 任务：实现多种单例模式
     */
    public static void practice1_Singleton() {
        System.out.println("=== 练习1：单例模式 ===");
        
        // TODO: 实现1 - 饿汉式（线程安全，但可能浪费内存）
        // class EagerSingleton {
        //     private static final EagerSingleton instance = new EagerSingleton();
        //     
        //     private EagerSingleton() {}
        //     
        //     public static EagerSingleton getInstance() {
        //         return instance;
        //     }
        // }
        
        // TODO: 实现2 - 懒汉式（非线程安全）
        // class LazySingleton {
        //     private static LazySingleton instance;
        //     
        //     private LazySingleton() {}
        //     
        //     public static LazySingleton getInstance() {
        //         if (instance == null) {
        //             instance = new LazySingleton();
        //         }
        //         return instance;
        //     }
        // }
        
        // TODO: 实现3 - 双重检查锁定（Double-Check Locking）
        // class DoubleCheckSingleton {
        //     private volatile static DoubleCheckSingleton instance;
        //     
        //     private DoubleCheckSingleton() {}
        //     
        //     public static DoubleCheckSingleton getInstance() {
        //         if (instance == null) {
        //             synchronized (DoubleCheckSingleton.class) {
        //                 if (instance == null) {
        //                     instance = new DoubleCheckSingleton();
        //                 }
        //             }
        //         }
        //         return instance;
        //     }
        // }
        
        // TODO: 实现4 - 静态内部类（推荐）
        // class StaticInnerClassSingleton {
        //     private StaticInnerClassSingleton() {}
        //     
        //     private static class SingletonHolder {
        //         private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
        //     }
        //     
        //     public static StaticInnerClassSingleton getInstance() {
        //         return SingletonHolder.instance;
        //     }
        // }
        
        // TODO: 实现5 - 枚举单例（推荐，线程安全且防止反序列化）
        // enum EnumSingleton {
        //     INSTANCE;
        //     
        //     public void doSomething() {
        //         System.out.println("枚举单例");
        //     }
        // }
        
        System.out.println("请实现各种单例模式");
    }

    /**
     * 练习2：工厂模式（Factory Pattern）
     * 任务：实现简单工厂、工厂方法、抽象工厂
     */
    public static void practice2_Factory() {
        System.out.println("\n=== 练习2：工厂模式 ===");
        
        // TODO: 实现1 - 简单工厂模式（Simple Factory）
        // interface Product {
        //     void use();
        // }
        // 
        // class ConcreteProductA implements Product {
        //     @Override
        //     public void use() {
        //         System.out.println("使用产品A");
        //     }
        // }
        // 
        // class ConcreteProductB implements Product {
        //     @Override
        //     public void use() {
        //         System.out.println("使用产品B");
        //     }
        // }
        // 
        // class SimpleFactory {
        //     public static Product createProduct(String type) {
        //         if ("A".equals(type)) {
        //             return new ConcreteProductA();
        //         } else if ("B".equals(type)) {
        //             return new ConcreteProductB();
        //         }
        //         return null;
        //     }
        // }
        
        // TODO: 实现2 - 工厂方法模式（Factory Method）
        // interface Factory {
        //     Product createProduct();
        // }
        // 
        // class FactoryA implements Factory {
        //     @Override
        //     public Product createProduct() {
        //         return new ConcreteProductA();
        //     }
        // }
        // 
        // class FactoryB implements Factory {
        //     @Override
        //     public Product createProduct() {
        //         return new ConcreteProductB();
        //     }
        // }
        
        // TODO: 实现3 - 抽象工厂模式（Abstract Factory）
        // interface AbstractFactory {
        //     ProductA createProductA();
        //     ProductB createProductB();
        // }
        // 
        // class ConcreteFactory1 implements AbstractFactory {
        //     @Override
        //     public ProductA createProductA() {
        //         return new ConcreteProductA1();
        //     }
        //     
        //     @Override
      //     public ProductB createProductB() {
        //         return new ConcreteProductB1();
        //     }
        // }
        
        System.out.println("请实现工厂模式的各种变体");
    }

    /**
     * 练习3：建造者模式（Builder Pattern）
     * 任务：实现建造者模式
     */
    public static void practice3_Builder() {
        System.out.println("\n=== 练习3：建造者模式 ===");
        
        // TODO: 实现建造者模式
        // class Product {
        //     private String partA;
        //     private String partB;
        //     private String partC;
        //     
        //     // getter和setter
        // }
        // 
        // class Builder {
        //     private Product product = new Product();
        //     
        //     public Builder setPartA(String partA) {
        //         product.setPartA(partA);
        //         return this;
        //     }
        //     
        //     public Builder setPartB(String partB) {
        //         product.setPartB(partB);
        //         return this;
        //     }
        //     
        //     public Builder setPartC(String partC) {
        //         product.setPartC(partC);
        //         return this;
        //     }
        //     
        //     public Product build() {
        //         return product;
        //     }
        // }
        // 
        // 使用：
        // Product product = new Builder()
        //     .setPartA("A")
        //     .setPartB("B")
        //     .setPartC("C")
        //     .build();
        
        System.out.println("请实现建造者模式");
    }

    /**
     * 练习4：代理模式（Proxy Pattern）
     * 任务：实现静态代理和动态代理
     */
    public static void practice4_Proxy() {
        System.out.println("\n=== 练习4：代理模式 ===");
        
        // TODO: 实现1 - 静态代理
        // interface Subject {
        //     void request();
        // }
        // 
        // class RealSubject implements Subject {
        //     @Override
        //     public void request() {
        //         System.out.println("真实对象的请求");
        //     }
        // }
        // 
        // class Proxy implements Subject {
        //     private RealSubject realSubject;
        //     
        //     @Override
        //     public void request() {
        //         if (realSubject == null) {
        //             realSubject = new RealSubject();
        //         }
        //         preRequest();
        //         realSubject.request();
        //         postRequest();
        //     }
        //     
        //     private void preRequest() {
        //         System.out.println("代理前的操作");
        //     }
        //     
        //     private void postRequest() {
        //         System.out.println("代理后的操作");
        //     }
        // }
        
        // TODO: 实现2 - 动态代理（JDK动态代理）
        // class DynamicProxy implements InvocationHandler {
        //     private Object target;
        //     
        //     public DynamicProxy(Object target) {
        //         this.target = target;
        //     }
        //     
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         System.out.println("动态代理前");
        //         Object result = method.invoke(target, args);
        //         System.out.println("动态代理后");
        //         return result;
        //     }
        // }
        // 
        // 使用：
        // Subject realSubject = new RealSubject();
        // InvocationHandler handler = new DynamicProxy(realSubject);
        // Subject proxy = (Subject) Proxy.newProxyInstance(
        //     realSubject.getClass().getClassLoader(),
        //     realSubject.getClass().getInterfaces(),
        //     handler
        // );
        // proxy.request();
        
        System.out.println("请实现静态代理和动态代理");
    }

    /**
     * 练习5：观察者模式（Observer Pattern）
     * 任务：实现观察者模式
     */
    public static void practice5_Observer() {
        System.out.println("\n=== 练习5：观察者模式 ===");
        
        // TODO: 实现观察者模式
        // interface Observer {
        //     void update(String message);
        // }
        // 
        // interface Subject {
        //     void attach(Observer observer);
        //     void detach(Observer observer);
        //     void notifyObservers(String message);
        // }
        // 
        // class ConcreteSubject implements Subject {
        //     private List<Observer> observers = new ArrayList<>();
        //     
        //     @Override
        //     public void attach(Observer observer) {
        //         observers.add(observer);
        //     }
        //     
        //     @Override
        //     public void detach(Observer observer) {
        //         observers.remove(observer);
        //     }
        //     
        //     @Override
        //     public void notifyObservers(String message) {
        //         for (Observer observer : observers) {
        //             observer.update(message);
        //         }
        //     }
        // }
        // 
        // class ConcreteObserver implements Observer {
        //     private String name;
        //     
        //     public ConcreteObserver(String name) {
        //         this.name = name;
        //     }
        //     
        //     @Override
        //     public void update(String message) {
        //         System.out.println(name + "收到消息: " + message);
        //     }
        // }
        // 
        // Java内置的观察者模式（已废弃，仅作了解）：
        // java.util.Observable 和 java.util.Observer
        
        System.out.println("请实现观察者模式");
    }

    /**
     * 练习6：策略模式（Strategy Pattern）
     * 任务：实现策略模式
     */
    public static void practice6_Strategy() {
        System.out.println("\n=== 练习6：策略模式 ===");
        
        // TODO: 实现策略模式
        // interface Strategy {
        //     int execute(int a, int b);
        // }
        // 
        // class AddStrategy implements Strategy {
        //     @Override
        //     public int execute(int a, int b) {
        //         return a + b;
        //     }
        // }
        // 
        // class SubtractStrategy implements Strategy {
        //     @Override
        //     public int execute(int a, int b) {
        //         return a - b;
        //     }
        // }
        // 
        // class MultiplyStrategy implements Strategy {
        //     @Override
        //     public int execute(int a, int b) {
        //         return a * b;
        //     }
        // }
        // 
        // class Context {
        //     private Strategy strategy;
        //     
        //     public Context(Strategy strategy) {
        //         this.strategy = strategy;
        //     }
        //     
        //     public void setStrategy(Strategy strategy) {
        //         this.strategy = strategy;
        //     }
        //     
        //     public int executeStrategy(int a, int b) {
        //         return strategy.execute(a, b);
        //     }
        // }
        // 
        // 使用：
        // Context context = new Context(new AddStrategy());
        // int result = context.executeStrategy(5, 3);  // 8
        
        System.out.println("请实现策略模式");
    }

    /**
     * 练习7：适配器模式（Adapter Pattern）
     * 任务：实现适配器模式
     */
    public static void practice7_Adapter() {
        System.out.println("\n=== 练习7：适配器模式 ===");
        
        // TODO: 实现适配器模式
        // 场景：将现有的接口适配到目标接口
        
        // 目标接口
        // interface Target {
        //     void request();
        // }
        // 
        // 被适配的类
        // class Adaptee {
        //     public void specificRequest() {
        //         System.out.println("被适配者的特殊请求");
        //     }
        // }
        // 
        // 适配器
        // class Adapter implements Target {
        //     private Adaptee adaptee;
        //     
        //     public Adapter(Adaptee adaptee) {
        //         this.adaptee = adaptee;
        //     }
        //     
        //     @Override
        //     public void request() {
        //         adaptee.specificRequest();
        //     }
        // }
        
        System.out.println("请实现适配器模式");
    }

    /**
     * 练习8：装饰器模式（Decorator Pattern）
     * 任务：实现装饰器模式
     */
    public static void practice8_Decorator() {
        System.out.println("\n=== 练习8：装饰器模式 ===");
        
        // TODO: 实现装饰器模式
        // 组件接口
        // interface Component {
        //     void operation();
        // }
        // 
        // 具体组件
        // class ConcreteComponent implements Component {
        //     @Override
        //     public void operation() {
        //         System.out.println("具体组件的操作");
        //     }
        // }
        // 
        // 装饰器基类
        // abstract class Decorator implements Component {
        //     protected Component component;
        //     
        //     public Decorator(Component component) {
        //         this.component = component;
        //     }
        //     
        //     @Override
        //     public void operation() {
        //         component.operation();
        //     }
        // }
        // 
        // 具体装饰器
        // class ConcreteDecoratorA extends Decorator {
        //     public ConcreteDecoratorA(Component component) {
        //         super(component);
        //     }
        //     
        //     @Override
        //     public void operation() {
        //         super.operation();
        //         addedBehavior();
        //     }
        //     
        //     private void addedBehavior() {
        //         System.out.println("装饰器A添加的行为");
        //     }
        // }
        
        System.out.println("请实现装饰器模式");
    }

    /**
     * 练习9：责任链模式（Chain of Responsibility Pattern）
     * 任务：实现责任链模式
     */
    public static void practice9_ChainOfResponsibility() {
        System.out.println("\n=== 练习9：责任链模式 ===");
        
        // TODO: 实现责任链模式
        // abstract class Handler {
        //     protected Handler nextHandler;
        //     
        //     public void setNext(Handler handler) {
        //         this.nextHandler = handler;
        //     }
        //     
        //     public abstract void handleRequest(Request request);
        // }
        // 
        // class ConcreteHandler1 extends Handler {
        //     @Override
        //     public void handleRequest(Request request) {
        //         if (request.getType() == RequestType.TYPE1) {
        //             System.out.println("Handler1处理请求");
        //         } else if (nextHandler != null) {
        //             nextHandler.handleRequest(request);
        //         }
        //     }
        // }
        // 
        // class ConcreteHandler2 extends Handler {
        //     @Override
        //     public void handleRequest(Request request) {
        //         if (request.getType() == RequestType.TYPE2) {
        //             System.out.println("Handler2处理请求");
        //         } else if (nextHandler != null) {
        //             nextHandler.handleRequest(request);
        //         }
        //     }
        // }
        
        System.out.println("请实现责任链模式");
    }

    /**
     * 练习10：模板方法模式（Template Method Pattern）
     * 任务：实现模板方法模式
     */
    public static void practice10_TemplateMethod() {
        System.out.println("\n=== 练习10：模板方法模式 ===");
        
        // TODO: 实现模板方法模式
        // abstract class AbstractClass {
        //     // 模板方法
        //     public final void templateMethod() {
        //         step1();
        //         step2();
        //         step3();
        //     }
        //     
        //     // 具体步骤，子类必须实现
        //     protected abstract void step1();
        //     protected abstract void step2();
        //     
        //     // 钩子方法，子类可以选择性重写
        //     protected void step3() {
        //         System.out.println("默认步骤3");
        //     }
        // }
        // 
        // class ConcreteClass extends AbstractClass {
        //     @Override
        //     protected void step1() {
        //         System.out.println("具体步骤1");
        //     }
        //     
        //     @Override
        //     protected void step2() {
        //         System.out.println("具体步骤2");
        //     }
        // }
        
        System.out.println("请实现模板方法模式");
    }

    /**
     * 练习11：状态模式（State Pattern）
     * 任务：实现状态模式
     */
    public static void practice11_State() {
        System.out.println("\n=== 练习11：状态模式 ===");
        
        // TODO: 实现状态模式
        // interface State {
        //     void handle(Context context);
        // }
        // 
        // class ConcreteStateA implements State {
        //     @Override
        //     public void handle(Context context) {
        //         System.out.println("状态A的处理");
        //         context.setState(new ConcreteStateB());
        //     }
        // }
        // 
        // class ConcreteStateB implements State {
        //     @Override
        //     public void handle(Context context) {
        //         System.out.println("状态B的处理");
        //         context.setState(new ConcreteStateA());
        //     }
        // }
        // 
        // class Context {
        //     private State state;
        //     
        //     public Context(State state) {
        //         this.state = state;
        //     }
        //     
        //     public void setState(State state) {
        //         this.state = state;
        //     }
        //     
        //     public void request() {
        //         state.handle(this);
        //     }
        // }
        
        System.out.println("请实现状态模式");
    }

    /**
     * 练习12：命令模式（Command Pattern）
     * 任务：实现命令模式
     */
    public static void practice12_Command() {
        System.out.println("\n=== 练习12：命令模式 ===");
        
        // TODO: 实现命令模式
        // interface Command {
        //     void execute();
        //     void undo();
        // }
        // 
        // class Receiver {
        //     public void action() {
        //         System.out.println("接收者执行操作");
        //     }
        // }
        // 
        // class ConcreteCommand implements Command {
        //     private Receiver receiver;
        //     
        //     public ConcreteCommand(Receiver receiver) {
        //         this.receiver = receiver;
        //     }
        //     
        //     @Override
        //     public void execute() {
        //         receiver.action();
        //     }
        //     
        //     @Override
        //     public void undo() {
        //         System.out.println("撤销操作");
        //     }
        // }
        // 
        // class Invoker {
        //     private Command command;
        //     
        //     public void setCommand(Command command) {
        //         this.command = command;
        //     }
        //     
        //     public void call() {
        //         command.execute();
        //     }
        // }
        
        System.out.println("请实现命令模式");
    }

    /**
     * 练习13：组合模式（Composite Pattern）
     * 任务：实现组合模式
     */
    public static void practice13_Composite() {
        System.out.println("\n=== 练习13：组合模式 ===");
        
        // TODO: 实现组合模式
        // interface Component {
        //     void operation();
        //     void add(Component component);
        //     void remove(Component component);
        //     Component getChild(int index);
        // }
        // 
        // class Leaf implements Component {
        //     private String name;
        //     
        //     public Leaf(String name) {
        //         this.name = name;
        //     }
        //     
        //     @Override
        //     public void operation() {
        //         System.out.println("叶子节点: " + name);
        //     }
        //     
        //     @Override
        //     public void add(Component component) {
        //         throw new UnsupportedOperationException();
        //     }
        //     
        //     @Override
        //     public void remove(Component component) {
        //         throw new UnsupportedOperationException();
        //     }
        //     
        //     @Override
        //     public Component getChild(int index) {
        //         throw new UnsupportedOperationException();
        //     }
        // }
        // 
        // class Composite implements Component {
        //     private List<Component> children = new ArrayList<>();
        //     private String name;
        //     
        //     public Composite(String name) {
        //         this.name = name;
        //     }
        //     
        //     @Override
        //     public void operation() {
        //         System.out.println("组合节点: " + name);
        //         for (Component child : children) {
        //             child.operation();
        //         }
        //     }
        //     
        //     @Override
        //     public void add(Component component) {
        //         children.add(component);
        //     }
        //     
        //     @Override
        //     public void remove(Component component) {
        //         children.remove(component);
        //     }
        //     
        //     @Override
        //     public Component getChild(int index) {
        //         return children.get(index);
        //     }
        // }
        
        System.out.println("请实现组合模式");
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_Singleton();
        practice2_Factory();
        practice3_Builder();
        practice4_Proxy();
        practice5_Observer();
        practice6_Strategy();
        practice7_Adapter();
        practice8_Decorator();
        practice9_ChainOfResponsibility();
        practice10_TemplateMethod();
        practice11_State();
        practice12_Command();
        practice13_Composite();
    }
}

