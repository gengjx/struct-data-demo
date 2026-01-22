import lombok.ToString;
import org.junit.Assert;

@ToString
public class HashTable<K,V> {


    /**
     * 散列表
     */
    private Entry<K,V>[] table;

    /**
     * 键值对个数
     */
    private int size = 0;

    /**
     * table使用个数
     */
    private int use = 0;

    private final int DEFAULT_CAPACITY = 8;

    /**
     * 装载因子
     * @param <K>
     * @param <V>
     */
    private static final float LOAD_FACTOR = 0.75f;

    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
    }


    //键值对-使用链表法解决散列
    @ToString
    static class Entry<K,V> {


        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public void put(K key, V value) {

        int hash = hash(key);

        Entry<K,V> entry = table[hash];
        if (entry == null) {
            table[hash] = new Entry<>(null,null,null);
        }
        Entry<K,V> tmp = table[hash];
        if (tmp.next == null) {
            tmp.next = new Entry<>(key,value,null);
            size++;
            use++;
            if (use==table.length * LOAD_FACTOR) {
                resize();
            }
        }else {
            do {
                tmp = tmp.next;
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            }while (tmp.next != null);
            Entry<K,V> temp  = table[hash].next;
            table[hash].next = new Entry<>(key,value,temp);
            size++;
        }
    }

    public V get(K key){
        int hash = hash(key);
        Entry<K,V> entry = table[hash];
        if (entry == null || entry.next == null) {
            return null;
        }
        while (entry.next != null) {
            entry = entry.next;
            if (entry.key==key) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash = hash(key);
        Entry<K,V> entry = table[hash];
        //不存在数据
        if (entry == null || entry.next == null) {
            return;
        }
        Entry<K,V> pre;
        Entry<K,V> head = entry;

        do{
            pre = entry;
            entry = entry.next;
            if(entry.key == key) {
                pre.next = entry.next;
                size--;
                if(head.next == null) {
                    use--;
                }
                return;
            }
        }while (entry.next != null);
    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    /**
     * 扩容
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[table.length * 2];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if (table[index] == null) {
                    use++;
                    // 创建哨兵节点
                    table[index] = new Entry<>(null, null, null);
                }
                table[index].next = new Entry<>(e.key, e.value, table[index].next);
            }
        }
    }


    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("A", 1);
        hashTable.put("B", 2);
        hashTable.put("C", 3);
        Assert.assertEquals(1L, hashTable.get("A").longValue());
        hashTable.remove("A");
        Assert.assertEquals(null, hashTable.get("A"));
    }

}
