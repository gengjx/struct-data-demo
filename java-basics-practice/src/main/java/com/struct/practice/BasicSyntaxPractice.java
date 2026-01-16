package com.struct.practice;

import org.junit.Assert;

/**
 * Java基础语法练习
 * 练习内容：
 * 1. 变量和数据类型
 * 2. 运算符
 * 3. 流程控制（if/else, switch, for, while, do-while）
 */
public class BasicSyntaxPractice {

    /**
     * 练习1：变量和数据类型
     * 任务：声明不同类型的变量，理解各数据类型的取值范围
     */
    public static void practice1_VariablesAndDataTypes() {
        System.out.println("=== 练习1：变量和数据类型 ===");
        
        // TODO: 声明以下类型的变量并赋值
        // 1. byte类型变量，值为100
        // 2. short类型变量，值为1000
        // 3. int类型变量，值为100000
        // 4. long类型变量，值为10000000000L（注意L后缀）
        // 5. float类型变量，值为3.14f（注意f后缀）
        // 6. double类型变量，值为3.1415926535
        // 7. char类型变量，值为'A'
        // 8. boolean类型变量，值为true
        // 9. String类型变量，值为"Hello Java"
        
        // 请在此处编写代码
        byte b = 100;
        short s = 1000;
        int i = 100000;
        long l = 10000000000L;
        float f= 3.14f;
        double d = 3.1415926535;
        char c = 'A';
        boolean bool = true;
        String str = "hello java";

    
        
        
        // 打印所有变量的值
        System.out.println("打印所有变量的值...");

        System.out.println("byte: "+ b +"short: "+ s +"int: "+i +"long "+l+ "float:"+f +"double: "+d +"char:"+c +" boolean: "+ bool +"string: "+ str);



    }

    /**
     * 练习2：运算符
     * 任务：练习算术运算符、关系运算符、逻辑运算符、赋值运算符
     */
    public static void practice2_Operators() {
        System.out.println("\n=== 练习2：运算符 ===");
        
        int a = 10;
        int b = 3;
        
        // TODO: 完成以下运算并打印结果
        // 1. 算术运算符：+, -, *, /, %, ++, --
        // 2. 关系运算符：>, <, >=, <=, ==, !=
        // 3. 逻辑运算符：&&, ||, !
        // 4. 赋值运算符：=, +=, -=, *=, /=, %=
        // 5. 三元运算符：condition ? value1 : value2
        
        System.out.println("a = " + a + ", b = " + b);
        
        // 请在此处编写代码

        System.out.println("a+b: "+ (a+b));
        System.out.println("a-b: "+(a-b));
        System.out.println("a*b"+ (a*b));
        System.out.println("a/b: "+ (a/b));
        System.out.println("a++: "+(a++));
        System.out.println("a-- :"+a--);
        Assert.assertEquals(true, a>b);
        Assert.assertEquals(false,a<b);
        Assert.assertEquals(true, a>=b);
        Assert.assertEquals(false , a<=b);
        Assert.assertEquals(true, a != b);
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a|b: " + (a | b));
 
    }

    /**
     * 练习3：if/else语句
     * 任务：根据分数判断等级（优秀、良好、及格、不及格）
     */
    public static String practice3_IfElse(int score) {
        // TODO: 实现分数等级判断
        // 90-100: 优秀
        // 80-89:  良好
        // 60-79:  及格
        // 0-59:   不及格
        // 其他:   无效分数
        if (score >= 90 && score <=100 ) {
            return "优秀";
        }else if (score >= 80 && score <90) {
            return "良好";
        }else if (score >= 60 && score < 79) {
            return "及格";
        }else if (score >= 0 && score <= 59) {
            return "不及格";
            
        }
        return "无效分数";
    }

    /**
     * 练习4：switch语句
     * 任务：根据月份数字返回对应的季节
     */
    public static String practice4_Switch(int month) {
        // 实现月份到季节的转换
        String desc = "无效月份";
        switch (month) {
            case 12:
            case 1:
            case 2:
                desc = "冬季";
                break;
            case 3:
            case 4:
            case 5:
                desc = "春季";
                break;
            case 6:
            case 7:
            case 8:
                desc = "夏季";
                break;
            case 9:
            case 10:
            case 11:
                desc = "秋季";
                break;
            default:
                desc = "无效月份";
        }
        return desc;
    }

    /**
     * 练习5：for循环
     * 任务：计算1到100的和
     */
    public static int practice5_ForLoop() {
        // 优化：直接使用数学公式求和，减少循环，提高效率
        return (1 + 100) * 100 / 2;
    }
    /**
     * 练习6：while循环
     * 任务：计算一个数的阶乘（使用while循环）
     */
    public static long practice6_WhileLoop(int n) {
        // 优化：只保留一个出口，减少重复判断和变量赋值
        if (n < 0) return -1;
        long result = 1;
        while (n > 1) {
            result *= n--;
        }
        return result;
    }

    /**
     * 练习7：do-while循环
     * 任务：模拟用户输入验证，直到输入有效值为止
     */
    public static int practice7_DoWhileLoop(int[] inputs) {
        // TODO: 使用do-while循环，找到第一个1到100之间的有效输入
        // 模拟从数组中依次读取输入，直到找到有效值
        // 如果没有有效值，返回-1
        int i = 0;
        int length = inputs.length -1;

        do{

            if (inputs[i]>=1 && inputs[i]<=100) {
                return inputs[i];
            }
            i++;

        }while(i<length);

        
        return -1;
    }

    /**
     * 练习8：嵌套循环
     * 任务：打印九九乘法表
     */
    public static void practice8_NestedLoop() {
        // TODO: 使用嵌套循环打印九九乘法表
        // 格式：1x1=1, 1x2=2, ..., 9x9=81
        
        System.out.println("=== 九九乘法表 ===");
        // 请在此处编写代码
        for(int i =1 ; i<=9;i++){
            for(int j = 1 ; j<=i ; j++){
                System.out.print(i+"*"+j+"="+(i*j)+" ");
            }
            System.out.println();

        }
    }

    /**
     * 练习9：break和continue
     * 任务：找出1-100中第一个能被7整除且能被3整除的数
     */
    public static int practice9_BreakContinue() {
        // 使用循环，当找到满足条件的数时使用break退出
        // 条件：能被7整除且能被3整除
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 && i % 3 == 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 练习10：综合练习
     * 任务：实现一个猜数字游戏的核心逻辑
     * 给定一个目标数字，判断猜测的数字是大了、小了还是正确
     */
    public static String practice10_GuessNumber(int target, int guess) {
        if (guess > target) {
            return "太大了";
        } else if (guess < target) {
            return "太小了";
        } else {
            return "猜对了！";
        }
    }

    // 测试方法
    public static void main(String[] args) {
        // 运行所有练习
        practice1_VariablesAndDataTypes();
        practice2_Operators();
        
        System.out.println("\n练习3 - 分数等级判断:");
        System.out.println("95分: " + practice3_IfElse(95));
        System.out.println("85分: " + practice3_IfElse(85));
        System.out.println("65分: " + practice3_IfElse(65));
        System.out.println("55分: " + practice3_IfElse(55));
        
        System.out.println("\n练习4 - 月份季节:");
        System.out.println("1月: " + practice4_Switch(1));
        System.out.println("6月: " + practice4_Switch(6));
        System.out.println("10月: " + practice4_Switch(10));
        
        System.out.println("\n练习5 - 1到100的和: " + practice5_ForLoop());
        System.out.println("练习6 - 5的阶乘: " + practice6_WhileLoop(5));
        
        practice8_NestedLoop();
        
        System.out.println("\n练习9 - 第一个满足条件的数: " + practice9_BreakContinue());
        
        System.out.println("\n练习10 - 猜数字:");
        System.out.println("目标50，猜测30: " + practice10_GuessNumber(50, 30));
        System.out.println("目标50，猜测70: " + practice10_GuessNumber(50, 70));
        System.out.println("目标50，猜测50: " + practice10_GuessNumber(50, 50));
    }
}

