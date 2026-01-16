package com.struct;

import org.junit.Test;

import java.util.Arrays;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP 按 <shortcut actionId="Debug"/> 开始调试代码。我们已经设置了一个 <icon src="AllIcons.Debugger.Db_set_breakpoint"/> 断点
            // 但您始终可以通过按 <shortcut actionId="ToggleLineBreakpoint"/> 添加更多断点。
            System.out.println("i = " + i);
        }
    }


    @Test
    public void test() {

        int []a = new int[5];

        insert(a,1,0);
        insert(a,2,1);

        System.out.println(Arrays.toString(a));

        insert(a,3,0);

        System.out.println(Arrays.toString(a));

        remove(a,1);

    }

    public void insert(int []a ,int n,int index){

        int maxSize = a.length-1;
        if (index > maxSize) {
            return;
        }

        for (int i = maxSize; i > index; i--) {
            a[i] = a[i-1];
        }
        a[index] = n;

    }


    public int remove(int []a,int index){
        int result = a[index];
        System.out.println("数据删除前："+Arrays.toString(a) + "删除的数据是第:"+(index+1));
        System.out.println("删除的数据是"+result);
        for (int i = index; i <a.length-1; i++) {
            a[i] = a[i+1];
        }
        System.out.println("删除数据后："+Arrays.toString(a));
        return result;
    }


}