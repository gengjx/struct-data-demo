package com.struct.practice;

import org.junit.Assert;
import org.junit.Test;

public class ArrayAndStringPracticeTest {

    @Test
    public void practice6_CopyArray(){
        int [] original = new int[]{1,2,3};
        int [] cp = ArrayAndStringPractice.practice6_CopyArray(original);
        
        Assert.assertArrayEquals(cp, original);
    }

    @Test
    public void practice10_StringBuilder() {
        // 测试StringBuilder方法
        String result = ArrayAndStringPractice.practice10_StringBuilder();
        
        // 验证返回值不为空
        Assert.assertNotNull(result);
        
        // 构建期望值：1000个"Hello"连接
        StringBuilder expectedBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            expectedBuilder.append("Hello");
        }
        String expected = expectedBuilder.toString();
        
        // 验证返回值应该是1000个"Hello"连接
        Assert.assertEquals(expected, result);
        
        // 验证长度应该是5000（1000 * 5）
        Assert.assertEquals(5000, result.length());
        
        // 验证每个子串都是"Hello"
        for (int i = 0; i < 1000; i++) {
            String substring = result.substring(i * 5, (i + 1) * 5);
            Assert.assertEquals("Hello", substring);
        }
    }

}
