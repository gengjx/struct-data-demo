package com.struct;

import java.util.Comparator;
import java.util.Objects;

/**
 * 排序算法工具类 - 高级版本示例
 * 
 * <p>本类提供了多种排序算法的实现，支持基本类型和对象类型的排序。
 * 所有排序方法都包含完整的参数校验、边界处理，并遵循统一的接口设计。
 * 
 * <p><strong>设计原则：</strong>
 * <ul>
 *   <li>防御性编程：所有方法都进行参数校验</li>
 *   <li>接口统一：提供一致的API设计</li>
 *   <li>可扩展性：支持自定义比较器</li>
 *   <li>文档完整：每个方法都有详细的JavaDoc</li>
 * </ul>
 * 
 * <p><strong>使用示例：</strong>
 * <pre>{@code
 * // 基本类型排序
 * int[] arr = {3, 1, 4, 1, 5};
 * SortImproved.bubbleSort(arr);
 * 
 * // 对象类型排序（使用Comparable）
 * Integer[] arr2 = {3, 1, 4, 1, 5};
 * SortImproved.bubbleSort(arr2);
 * 
 * // 自定义比较器排序
 * String[] arr3 = {"banana", "apple", "cherry"};
 * SortImproved.bubbleSort(arr3, Comparator.comparing(String::length));
 * }</pre>
 * 
 * @author Your Name
 * @version 1.0
 * @since 1.0
 */
public final class SortImproved {
    
    /**
     * 私有构造函数，防止实例化
     * 这是一个工具类，所有方法都是静态的
     */
    private SortImproved() {
        throw new AssertionError("工具类不允许实例化");
    }
    
    // ==================== 基本类型排序（int数组） ====================
    
    /**
     * 冒泡排序 - 基本类型版本
     * 
     * <p><strong>算法描述：</strong>
     * 比较相邻的元素，如果第一个比第二个大，就交换它们两个。
     * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。
     * 这步做完后，最后的元素会是最大的数。针对所有的元素重复以上的步骤，
     * 除了最后一个。持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * 
     * <p><strong>性能特征：</strong>
     * <ul>
     *   <li>时间复杂度：平均 O(n²)，最好 O(n)（已排序），最坏 O(n²)</li>
     *   <li>空间复杂度：O(1)</li>
     *   <li>稳定性：稳定</li>
     * </ul>
     * 
     * <p><strong>适用场景：</strong>
     * 适用于小规模数据（n < 50）或教学演示。对于大规模数据，建议使用更高效的排序算法。
     * 
     * <p><strong>优化点：</strong>
     * <ul>
     *   <li>使用标志位提前终止：如果某一轮没有发生交换，说明数组已有序</li>
     *   <li>减少不必要的比较：每轮后，最后 i 个元素已经有序</li>
     * </ul>
     * 
     * @param array 待排序的数组，不能为 null
     * @throws IllegalArgumentException 如果数组为 null
     * 
     * @see #bubbleSort(Object[])
     * @see #bubbleSort(Object[], Comparator)
     */
    public static void bubbleSort(int[] array) {
        validateArray(array);
        
        // 边界情况：空数组或单元素数组无需排序
        if (array.length <= 1) {
            return;
        }
        
        int n = array.length;
        boolean swapped;
        
        // 外层循环：控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // 内层循环：每轮将最大元素"冒泡"到末尾
            // 注意：j < n - i - 1，因为最后 i 个元素已经有序
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            
            // 优化：如果本轮没有发生交换，说明数组已有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 插入排序 - 基本类型版本
     * 
     * <p><strong>算法描述：</strong>
     * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     * 
     * <p><strong>性能特征：</strong>
     * <ul>
     *   <li>时间复杂度：平均 O(n²)，最好 O(n)（已排序），最坏 O(n²)</li>
     *   <li>空间复杂度：O(1)</li>
     *   <li>稳定性：稳定</li>
     * </ul>
     * 
     * <p><strong>适用场景：</strong>
     * 适用于小规模数据或部分有序的数据。对于已排序或接近排序的数据，性能接近 O(n)。
     * 
     * @param array 待排序的数组，不能为 null
     * @throws IllegalArgumentException 如果数组为 null
     */
    public static void insertSort(int[] array) {
        validateArray(array);
        
        // 边界情况：空数组或单元素数组无需排序
        if (array.length <= 1) {
            return;
        }
        
        // 从第二个元素开始，逐个插入到已排序序列中
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int j = i - 1;
            
            // 将大于当前值的元素向右移动
            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j];
                j--;
            }
            
            // 插入当前值到正确位置
            array[j + 1] = currentValue;
        }
    }
    
    /**
     * 选择排序 - 基本类型版本
     * 
     * <p><strong>算法描述：</strong>
     * 每次从未排序序列中选择最小（或最大）元素放到已排序序列的末尾。
     * 
     * <p><strong>性能特征：</strong>
     * <ul>
     *   <li>时间复杂度：O(n²)，无论最好、最坏、平均情况</li>
     *   <li>空间复杂度：O(1)</li>
     *   <li>稳定性：不稳定（相等元素可能交换）</li>
     * </ul>
     * 
     * <p><strong>适用场景：</strong>
     * 适合元素较少且对稳定性要求不高的场景。由于时间复杂度固定为 O(n²)，
     * 不推荐用于大规模数据。
     * 
     * @param array 待排序的数组，不能为 null
     * @throws IllegalArgumentException 如果数组为 null
     */
    public static void selectSort(int[] array) {
        validateArray(array);
        
        // 边界情况：空数组或单元素数组无需排序
        if (array.length <= 1) {
            return;
        }
        
        int n = array.length;
        
        // 外层循环：遍历未排序部分的每个位置
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // 内层循环：在未排序区间 [i+1, n) 中寻找最小元素的下标
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            // 只有当最小元素不是当前位置时才交换，减少不必要的交换操作
            if (i != minIndex) {
                swap(array, i, minIndex);
            }
        }
    }
    
    // ==================== 对象类型排序（支持Comparable） ====================
    
    /**
     * 冒泡排序 - 对象类型版本（使用Comparable接口）
     * 
     * <p>要求数组元素类型必须实现 {@link Comparable} 接口。
     * 
     * @param <T> 数组元素类型，必须实现 Comparable 接口
     * @param array 待排序的数组，不能为 null，数组元素不能为 null
     * @throws IllegalArgumentException 如果数组为 null 或包含 null 元素
     * @throws ClassCastException 如果元素类型不支持 Comparable
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
        bubbleSort(array, Comparator.naturalOrder());
    }
    
    /**
     * 插入排序 - 对象类型版本（使用Comparable接口）
     * 
     * @param <T> 数组元素类型，必须实现 Comparable 接口
     * @param array 待排序的数组，不能为 null，数组元素不能为 null
     * @throws IllegalArgumentException 如果数组为 null 或包含 null 元素
     */
    public static <T extends Comparable<? super T>> void insertSort(T[] array) {
        insertSort(array, Comparator.naturalOrder());
    }
    
    /**
     * 选择排序 - 对象类型版本（使用Comparable接口）
     * 
     * @param <T> 数组元素类型，必须实现 Comparable 接口
     * @param array 待排序的数组，不能为 null，数组元素不能为 null
     * @throws IllegalArgumentException 如果数组为 null 或包含 null 元素
     */
    public static <T extends Comparable<? super T>> void selectSort(T[] array) {
        selectSort(array, Comparator.naturalOrder());
    }
    
    // ==================== 对象类型排序（支持自定义Comparator） ====================
    
    /**
     * 冒泡排序 - 对象类型版本（使用自定义Comparator）
     * 
     * <p>允许使用自定义的比较器进行排序，提供了更大的灵活性。
     * 
     * @param <T> 数组元素类型
     * @param array 待排序的数组，不能为 null
     * @param comparator 比较器，不能为 null
     * @throws IllegalArgumentException 如果数组或比较器为 null
     */
    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {
        validateArrayAndComparator(array, comparator);
        
        if (array.length <= 1) {
            return;
        }
        
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * 插入排序 - 对象类型版本（使用自定义Comparator）
     * 
     * @param <T> 数组元素类型
     * @param array 待排序的数组，不能为 null
     * @param comparator 比较器，不能为 null
     * @throws IllegalArgumentException 如果数组或比较器为 null
     */
    public static <T> void insertSort(T[] array, Comparator<? super T> comparator) {
        validateArrayAndComparator(array, comparator);
        
        if (array.length <= 1) {
            return;
        }
        
        for (int i = 1; i < array.length; i++) {
            T currentValue = array[i];
            int j = i - 1;
            
            while (j >= 0 && comparator.compare(array[j], currentValue) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            
            array[j + 1] = currentValue;
        }
    }
    
    /**
     * 选择排序 - 对象类型版本（使用自定义Comparator）
     * 
     * @param <T> 数组元素类型
     * @param array 待排序的数组，不能为 null
     * @param comparator 比较器，不能为 null
     * @throws IllegalArgumentException 如果数组或比较器为 null
     */
    public static <T> void selectSort(T[] array, Comparator<? super T> comparator) {
        validateArrayAndComparator(array, comparator);
        
        if (array.length <= 1) {
            return;
        }
        
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            
            if (i != minIndex) {
                swap(array, i, minIndex);
            }
        }
    }
    
    // ==================== 私有辅助方法 ====================
    
    /**
     * 交换数组中两个元素的位置
     * 
     * @param array 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * 交换数组中两个元素的位置（泛型版本）
     * 
     * @param array 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * 验证基本类型数组参数
     * 
     * @param array 待验证的数组
     * @throws IllegalArgumentException 如果数组为 null
     */
    private static void validateArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("数组不能为 null");
        }
    }
    
    /**
     * 验证对象类型数组和比较器参数
     * 
     * @param array 待验证的数组
     * @param comparator 待验证的比较器
     * @param <T> 数组元素类型
     * @throws IllegalArgumentException 如果数组或比较器为 null
     */
    private static <T> void validateArrayAndComparator(T[] array, Comparator<? super T> comparator) {
        Objects.requireNonNull(array, "数组不能为 null");
        Objects.requireNonNull(comparator, "比较器不能为 null");
        
        // 检查数组中是否包含 null 元素（可选，根据业务需求决定）
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new IllegalArgumentException(
                    String.format("数组索引 %d 处的元素为 null，不支持排序", i));
            }
        }
    }
}

