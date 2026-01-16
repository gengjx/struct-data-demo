package com.struct.practice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/**
 * I/O流练习
 * 练习内容：
 * 1. 字节流（InputStream、OutputStream）
 * 2. 字符流（Reader、Writer）
 * 3. 缓冲流（BufferedInputStream、BufferedReader）
 * 4. 文件操作（File类）
 * 5. 序列化和反序列化
 * 6. NIO（New I/O）
 */
public class IOPractice {

    /**
     * 练习1：File类的使用
     * 任务：掌握File类的基本操作
     */
    public static void practice1_FileClass(String filePath) {
        System.out.println("=== 练习1：File类 ===");
        
        // TODO:
        // 1. 创建File对象
        // 2. 判断文件是否存在：exists()
        // 3. 判断是文件还是目录：isFile(), isDirectory()
        // 4. 获取文件大小：length()
        // 5. 获取文件名：getName()
        // 6. 创建文件：createNewFile()
        // 7. 创建目录：mkdir(), mkdirs()
        // 8. 删除文件或目录：delete()
        // 9. 列出目录内容：listFiles()
        System.out.println("filePath:"+filePath);
        File file = new File(filePath);
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件是否是文件："+file.isFile());
        System.out.println("文件是否是文件夹："+file.isDirectory());
        System.out.println("文件大小："+file.length());
        System.out.println("文件名字："+file.getName());
        
        // 创建文件：createNewFile()
        // 注意：1. 只能创建文件，不能创建目录
        //      2. 如果文件已存在，返回false，不会覆盖
        //      3. 如果父目录不存在，会抛出IOException
        //      4. 需要处理IOException异常
        try {
            if (file.exists()) {
                System.out.println("文件已存在，无需创建");
            } else {
                // 确保父目录存在
                File parentDir = file.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs(); // 创建父目录
                    System.out.println("已创建父目录：" + parentDir.getAbsolutePath());
                }
                
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("文件创建成功：" + file.getAbsolutePath());
                } else {
                    System.out.println("文件创建失败（可能已存在）");
                }
            }
        } catch (IOException e) {
            System.err.println("创建文件时发生异常：" + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * 练习2：字节流读取文件
     * 任务：使用FileInputStream读取文件内容
     */
    public static void practice2_FileInputStream(String filePath) {
        System.out.println("\n=== 练习2：字节流读取 ===");

        // 1. 使用try-with-resources创建FileInputStream对象
        try (FileInputStream fis = new FileInputStream(filePath)) {
            // 2. 使用read()方法逐字节读取
            System.out.println("单字节读取：");
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();

            // 3. 重置流（重新打开）进行批量读取
            try (FileInputStream fis2 = new FileInputStream(filePath)) {
                System.out.println("批量读取：");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis2.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, len));
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习3：字节流写入文件
     * 任务：使用FileOutputStream写入文件
     */
    public static void practice3_FileOutputStream(String filePath, byte[] data) {
        System.out.println("\n=== 练习3：字节流写入 ===");
        
        // TODO: 使用FileOutputStream写入文件
        // 1. 创建FileOutputStream对象
        // 2. 使用write()方法写入字节
        // 3. 使用flush()刷新缓冲区
        // 4. 关闭流
        
        try (FileOutputStream fos = new FileOutputStream(filePath)) {

            // 请在此处编写代码
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习4：字符流读取文件
     * 任务：使用FileReader读取文本文件
     */
    public static void practice4_FileReader(String filePath) {
        System.out.println("\n=== 练习4：字符流读取 ===");
        
        // TODO: 使用FileReader读取文本文件
        // 1. 创建FileReader对象
        // 2. 使用read()方法读取字符
        // 3. 使用read(char[] buffer)批量读取
        // 4. 思考：什么时候用字节流，什么时候用字符流？
        
        try (FileReader reader = new FileReader(filePath)) {
            // 请在此处编写代码
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习5：字符流写入文件
     * 任务：使用FileWriter写入文本文件
     */
    public static void practice5_FileWriter(String filePath, String content) {
        System.out.println("\n=== 练习5：字符流写入 ===");
        
        // TODO: 使用FileWriter写入文本文件
        // 1. 创建FileWriter对象
        // 2. 使用write()方法写入字符串
        // 3. 使用append()方法追加内容
        
        try (FileWriter writer = new FileWriter(filePath)) {
            // 请在此处编写代码
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习6：缓冲流的使用
     * 任务：使用BufferedReader和BufferedWriter提高效率
     */
    public static void practice6_BufferedStream(String inputFile, String outputFile) {
        System.out.println("\n=== 练习6：缓冲流 ===");
        
        // TODO: 使用缓冲流复制文件
        // 1. 使用BufferedReader读取文件
        // 2. 使用BufferedWriter写入文件
        // 3. 使用readLine()逐行读取
        // 4. 理解缓冲流为什么能提高效率？
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // 请在此处编写代码
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习7：字节缓冲流
     * 任务：使用BufferedInputStream和BufferedOutputStream
     */
    public static void practice7_BufferedByteStream(String inputFile, String outputFile) {
        System.out.println("\n=== 练习7：字节缓冲流 ===");
        
        // TODO: 使用字节缓冲流复制文件
        // 1. 使用BufferedInputStream读取
        // 2. 使用BufferedOutputStream写入
        // 3. 对比使用缓冲流和不使用缓冲流的性能差异
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile))) {
            // 请在此处编写代码
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习8：对象序列化和反序列化
     * 任务：实现对象的序列化和反序列化
     */
    // TODO: 创建一个可序列化的类
    // class Student implements Serializable {
    //     private static final long serialVersionUID = 1L;
    //     private String name;
    //     private int age;
    //     // getter, setter, constructor
    // }
    
    public static void practice8_Serialization(String filePath) {
        System.out.println("\n=== 练习8：序列化 ===");
        
        // TODO:
        // 1. 使用ObjectOutputStream序列化对象
        // 2. 使用ObjectInputStream反序列化对象
        // 3. 理解serialVersionUID的作用
        
        // 序列化
        // try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
        //     Student student = new Student("张三", 20);
        //     oos.writeObject(student);
        // }
        
        // 反序列化
        // try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
        //     Student student = (Student) ois.readObject();
        // }
    }

    /**
     * 练习9：文件复制工具
     * 任务：实现一个通用的文件复制方法
     */
    public static boolean practice9_CopyFile(String sourceFile, String destFile) {
        // TODO: 实现文件复制功能
        // 要求：能够处理文本文件和二进制文件
        // 返回：复制是否成功
        
        return false;
    }

    /**
     * 练习10：读取配置文件
     * 任务：读取properties配置文件
     */
    public static void practice10_Properties(String configFile) {
        System.out.println("\n=== 练习10：Properties ===");
        
        // TODO: 使用Properties类读取配置文件
        // 1. 创建Properties对象
        // 2. 使用load()方法加载配置文件
        // 3. 使用getProperty()获取属性值
        // 4. 使用store()方法保存配置文件
        
        Properties props = new Properties();
        // 请在此处编写代码
    }

    /**
     * 练习11：NIO文件操作
     * 任务：使用NIO读取和写入文件
     */
    public static void   practice11_NIO(String filePath) {
        System.out.println("\n=== 练习11：NIO ===");
        
        // TODO: 使用NIO操作文件
        // 1. 使用Files.readAllLines()读取所有行
        // 2. 使用Files.write()写入文件
        // 3. 使用Files.copy()复制文件
        // 4. 使用Path和Paths类
        
        try {
            // 读取文件所有行
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            System.out.println("NIO 读取到的内容：");
            for (String line : lines) {
                System.out.println(line);
            }

            // 使用 NIO 再写一行内容到文件（追加）
            String extra = System.lineSeparator() + "NIO append line";
            Files.write(Paths.get(filePath), extra.getBytes(), java.nio.file.StandardOpenOption.APPEND);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习12：综合练习
     * 任务：实现一个简单的日志记录工具
     */
    public static void practice12_Logger() {
        // TODO: 实现日志记录工具
        // 1. 支持不同级别的日志（INFO, WARNING, ERROR）
        // 2. 将日志写入文件
        // 3. 支持日志文件的轮转（按日期或大小）
        
        // class Logger {
        //     public void info(String message) { ... }
        //     public void warning(String message) { ... }
        //     public void error(String message) { ... }
        // }
    }

    // 测试方法
    public static void main(String[] args) {
        String testFile = "test.txt";
        
        // 创建测试文件
        // 报错了——添加必要的import以及main方法/静态上下文适配
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(testFile), "Hello Java I/O".getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        
        practice1_FileClass(testFile);
        practice2_FileInputStream(testFile);
        practice4_FileReader(testFile);
        practice11_NIO(testFile);
    }
}

