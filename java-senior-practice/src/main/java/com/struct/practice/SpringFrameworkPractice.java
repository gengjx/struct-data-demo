package com.struct.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring框架练习
 * 练习内容：
 * 1. IoC（控制反转）容器
 * 2. DI（依赖注入）
 * 3. AOP（面向切面编程）
 * 4. Spring MVC
 * 5. Bean的生命周期
 */
public class SpringFrameworkPractice {

    /**
     * 练习1：理解IoC容器
     * 任务：理解IoC的概念和作用
     */
    public static void practice1_IoCContainer() {
        System.out.println("=== 练习1：IoC容器 ===");
        
        // TODO: 理解IoC（Inversion of Control）控制反转
        // IoC是一种设计思想，将对象的创建和依赖关系的管理交给Spring容器
        // 传统方式：对象自己创建依赖的对象
        // IoC方式：对象由Spring容器创建，依赖由容器注入
        
        // 示例：使用XML配置创建IoC容器
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // UserService userService = context.getBean("userService", UserService.class);
        
        System.out.println("请理解IoC容器的概念和作用");
    }

    /**
     * 练习2：Bean的配置方式
     * 任务：了解Bean的多种配置方式
     */
    public static void practice2_BeanConfiguration() {
        System.out.println("\n=== 练习2：Bean配置 ===");
        
        // TODO: 了解Bean的配置方式
        // 1. XML配置（传统方式）
        //    <bean id="userService" class="com.example.UserService">
        //        <property name="userDao" ref="userDao"/>
        //    </bean>
        
        // 2. 注解配置（推荐）
        //    @Component, @Service, @Repository, @Controller
        //    @Autowired, @Resource, @Qualifier
        
        // 3. Java配置（Java Config）
        //    @Configuration
        //    @Bean
        //    public UserService userService() {
        //         return new UserService();
        //    }
        
        System.out.println("请了解Bean的配置方式");
    }

    /**
     * 练习3：依赖注入（DI）
     * 任务：理解依赖注入的方式
     */
    public static void practice3_DependencyInjection() {
        System.out.println("\n=== 练习3：依赖注入 ===");
        
        // TODO: 理解依赖注入的三种方式
        // 1. 构造器注入（Constructor Injection）
        //    public class UserService {
        //        private UserDao userDao;
        //        public UserService(UserDao userDao) {
        //            this.userDao = userDao;
        //        }
        //    }
        
        // 2. Setter注入（Setter Injection）
        //    public class UserService {
        //        private UserDao userDao;
        //        public void setUserDao(UserDao userDao) {
        //            this.userDao = userDao;
        //        }
        //    }
        
        // 3. 字段注入（Field Injection，不推荐）
        //    public class UserService {
        //        @Autowired
        //        private UserDao userDao;
        //    }
        
        System.out.println("请理解依赖注入的三种方式");
    }

    /**
     * 练习4：Bean的作用域
     * 任务：理解Bean的作用域
     */
    public static void practice4_BeanScope() {
        System.out.println("\n=== 练习4：Bean作用域 ===");
        
        // TODO: 理解Bean的作用域
        // 1. singleton（单例，默认）
        //    - 整个容器中只有一个Bean实例
        //    - @Scope("singleton")
        
        // 2. prototype（原型）
        //    - 每次获取Bean时都创建新实例
        //    - @Scope("prototype")
        
        // 3. request（请求）
        //    - 每个HTTP请求创建一个实例（仅Web环境）
        
        // 4. session（会话）
        //    - 每个HTTP Session创建一个实例（仅Web环境）
        
        // 5. application（应用）
        //    - 整个Web应用共享一个实例（仅Web环境）
        
        System.out.println("请理解Bean的作用域");
    }

    /**
     * 练习5：Bean的生命周期
     * 任务：理解Bean的生命周期回调
     */
    public static void practice5_BeanLifecycle() {
        System.out.println("\n=== 练习5：Bean生命周期 ===");
        
        // TODO: 理解Bean的生命周期
        // 1. 实例化（Instantiation）
        // 2. 属性赋值（Populate properties）
        // 3. 初始化（Initialization）
        //    - 实现InitializingBean接口的afterPropertiesSet()方法
        //    - 使用@PostConstruct注解
        //    - 配置init-method
        // 4. 使用（In use）
        // 5. 销毁（Destruction）
        //    - 实现DisposableBean接口的destroy()方法
        //    - 使用@PreDestroy注解
        //    - 配置destroy-method
        
        // 示例：
        // @Component
        // public class MyBean implements InitializingBean, DisposableBean {
        //     @PostConstruct
        //     public void init() {
        //         System.out.println("Bean初始化");
        //     }
        //     
        //     @Override
        //     public void afterPropertiesSet() {
        //         System.out.println("afterPropertiesSet");
        //     }
        //     
        //     @PreDestroy
        //     public void destroy() {
        //         System.out.println("Bean销毁");
        //     }
        // }
        
        System.out.println("请理解Bean的生命周期回调");
    }

    /**
     * 练习6：AOP基础
     * 任务：理解AOP的概念和使用
     */
    public static void practice6_AOPBasics() {
        System.out.println("\n=== 练习6：AOP基础 ===");
        
        // TODO: 理解AOP（Aspect-Oriented Programming）面向切面编程
        // AOP用于处理横切关注点（如日志、事务、安全等）
        
        // AOP的核心概念：
        // 1. 切面（Aspect）：横切关注点的模块化
        // 2. 连接点（Join Point）：方法执行点
        // 3. 切点（Pointcut）：匹配连接点的表达式
        // 4. 通知（Advice）：在切点执行的动作
        //    - 前置通知（Before）
        //    - 后置通知（After）
        //    - 返回通知（After Returning）
        //    - 异常通知（After Throwing）
        //    - 环绕通知（Around）
        // 5. 目标对象（Target）：被代理的对象
        // 6. 代理（Proxy）：AOP框架创建的对象
        
        // 示例：
        // @Aspect
        // @Component
        // public class LoggingAspect {
        //     @Before("execution(* com.example.service.*.*(..))")
        //     public void beforeAdvice(JoinPoint joinPoint) {
        //         System.out.println("方法执行前: " + joinPoint.getSignature().getName());
        //     }
        //     
        //     @Around("execution(* com.example.service.*.*(..))")
        //     public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //         long start = System.currentTimeMillis();
        //         Object result = joinPoint.proceed();
        //         long end = System.currentTimeMillis();
        //         System.out.println("方法执行时间: " + (end - start) + "ms");
        //         return result;
        //     }
        // }
        
        System.out.println("请理解AOP的概念和使用");
    }

    /**
     * 练习7：切点表达式
     * 任务：掌握切点表达式的写法
     */
    public static void practice7_PointcutExpression() {
        System.out.println("\n=== 练习7：切点表达式 ===");
        
        // TODO: 掌握切点表达式（Pointcut Expression）
        // execution表达式格式：
        // execution(修饰符? 返回类型 类名? 方法名(参数) 异常?)
        
        // 示例：
        // execution(public * com.example.service.*.*(..))
        // - public：修饰符
        // - *：返回类型（任意）
        // - com.example.service.*：类名（service包下所有类）
        // - *：方法名（所有方法）
        // - (..)：参数（任意参数）
        
        // 常用表达式：
        // execution(* com.example.service.UserService.*(..))  // UserService的所有方法
        // execution(* com.example.service.*.save*(..))        // service包下所有save开头的方法
        // within(com.example.service..*)                      // service包及其子包
        // @annotation(com.example.annotation.Log)             // 有@Log注解的方法
        
        System.out.println("请掌握切点表达式的写法");
    }

    /**
     * 练习8：Spring MVC基础
     * 任务：理解Spring MVC的工作原理
     */
    public static void practice8_SpringMVC() {
        System.out.println("\n=== 练习8：Spring MVC ===");
        
        // TODO: 理解Spring MVC的工作流程
        // 1. 用户发送请求到DispatcherServlet
        // 2. DispatcherServlet查询HandlerMapping，找到对应的Controller
        // 3. Controller执行业务逻辑，返回ModelAndView
        // 4. DispatcherServlet查询ViewResolver，找到对应的View
        // 5. View渲染后返回给用户
        
        // 示例Controller：
        // @Controller
        // @RequestMapping("/user")
        // public class UserController {
        //     @Autowired
        //     private UserService userService;
        //     
        //     @RequestMapping(value = "/list", method = RequestMethod.GET)
        //     public String listUsers(Model model) {
        //         List<User> users = userService.findAll();
        //         model.addAttribute("users", users);
        //         return "user/list";
        //     }
        //     
        //     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        //     @ResponseBody
        //     public User getUser(@PathVariable Long id) {
        //         return userService.findById(id);
        //     }
        //     
        //     @RequestMapping(value = "/save", method = RequestMethod.POST)
        //     @ResponseBody
        //     public ResponseEntity<?> saveUser(@RequestBody User user) {
        //         userService.save(user);
        //         return ResponseEntity.ok().build();
        //     }
        // }
        
        System.out.println("请理解Spring MVC的工作原理");
    }

    /**
     * 练习9：Spring事务管理
     * 任务：理解Spring事务的使用
     */
    public static void practice9_TransactionManagement() {
        System.out.println("\n=== 练习9：Spring事务管理 ===");
        
        // TODO: 理解Spring事务管理
        // 1. 编程式事务
        //    TransactionTemplate transactionTemplate;
        //    transactionTemplate.execute(status -> {
        //        // 事务代码
        //        return null;
        //    });
        
        // 2. 声明式事务（推荐）
        //    @Transactional
        //    public void transferMoney(Long fromId, Long toId, BigDecimal amount) {
        //        accountService.debit(fromId, amount);
        //        accountService.credit(toId, amount);
        //    }
        
        // @Transactional的属性：
        // - propagation：事务传播行为（REQUIRED, REQUIRES_NEW, NESTED等）
        // - isolation：事务隔离级别（READ_UNCOMMITTED, READ_COMMITTED等）
        // - timeout：事务超时时间
        // - readOnly：是否只读
        // - rollbackFor：哪些异常需要回滚
        // - noRollbackFor：哪些异常不需要回滚
        
        System.out.println("请理解Spring事务管理");
    }

    /**
     * 练习10：综合练习
     * 任务：创建一个完整的Spring应用示例
     */
    public static void practice10_CompleteExample() {
        System.out.println("\n=== 练习10：综合练习 ===");
        
        // TODO: 创建一个完整的Spring应用
        // 1. 创建实体类（Entity）
        // 2. 创建DAO层（Repository）
        // 3. 创建Service层，使用@Transactional
        // 4. 创建Controller层，使用Spring MVC
        // 5. 创建AOP切面，记录日志
        // 6. 配置Spring配置文件或使用注解配置
        
        System.out.println("请创建一个完整的Spring应用示例");
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_IoCContainer();
        practice2_BeanConfiguration();
        practice3_DependencyInjection();
        practice4_BeanScope();
        practice5_BeanLifecycle();
        practice6_AOPBasics();
        practice7_PointcutExpression();
        practice8_SpringMVC();
        practice9_TransactionManagement();
        practice10_CompleteExample();
    }
}








