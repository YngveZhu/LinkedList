package top.zyqer;

/**
 * 用单向链表实现的数组操作
 * @param <T> 数组的类型
 */
public class LinkedList <T> {
    private static class LinkNode <T> {
        private T val;
        private LinkNode<T> next;

        public LinkNode() {
            this(null, null);
        }

        public LinkNode(T val) {
            this(val, null);
        }

        public LinkNode(T val, LinkNode<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    private final LinkNode<T> virtualHead;

    public int length;

    public LinkedList() {
        this.virtualHead = new LinkNode<>(null, null);
        this.length = 0;
    }

    /**
     * 向数组尾部添加一个元素
     * @param val 需要向数组尾部添加的元素
     */
    public LinkedList<T> append(T val) {
        return append(length, val);
    }

    /**
     * 向数组指定位置添加元素
     * @param index 索引
     * @param val 需要添加的元素
     */
    public LinkedList<T> append(int index, T val) {
        if (index < 0 || index > length) throw new ArrayIndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, length));
        LinkNode<T> l = virtualHead;
        for (int i = 0; i < index; i++) l = l.next;
        l.next = new LinkNode<>(val, l.next);
        length++;
        return this;
    }

    /**
     * 数组指定位置修改元素
     * @param index 索引值
     * @param val 修改后的值
     */
    public LinkedList<T> alter(int index, T val) {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, length));
        LinkNode<T> l = virtualHead;
        for (int i = 0; i <= index; i++) l = l.next;
        l.val = val;
        return this;
    }

    /**
     * 数组指定位置删除元素
     * @param index 索引值
     * @return 删除的值
     */
    public T remove(int index) {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, length));
        LinkNode<T> l = virtualHead;
        for (int i = 0; i < index; i++) l = l.next;
        LinkNode<T> oldNode = l.next;
        l.next = l.next.next;
        oldNode.next = null;
        length--;
        return oldNode.val;
    }

    /**
     * 数组尾部删除元素
     * @return 删除的元素值
     */
    public T remove() {
        return remove(length - 1);
    }

    /**
     * 获取数组指定位置的元素
     * @param index 索引值
     * @return 元素值
     */
    public T element(int index) {
        if (index < 0 || index >= length) throw new ArrayIndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", index, length));
        LinkNode<T> l = virtualHead;
        for (int i = 0; i <= index; i++) l = l.next;
        return l.val;
    }

    /**
     * 检查数组是否为空
     * @return 数组若为空，则返回true，否则返回false
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * 比较两个链表是否相等
     * @param o 引用类型变量
     * @return 若相等，则返回true
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;
        LinkedList<?> l = (LinkedList<?>) o;
        if (this.length != l.length) return false;
        LinkNode<?> l3 = l.virtualHead;
        LinkNode<T> l2 = virtualHead;
        for (int i = 0; i < length; i++) {
            l3 = l3.next;
            l2 = l2.next;
            if (l2.val != l3.val) return false;
        }

        return true;
    }

    /**
     * 打印数组元素
     * @return 数组元素
     */
    @Override
    public String toString() {
        if (this.length == 0) return "[]";
        StringBuilder s = new StringBuilder("[");
        LinkNode<T> l = virtualHead;
        for (int i = 0; i < length; i++) {
            l = l.next;
            s.append(l.val).append(",");
        }
        s.replace(s.length() - 1, s.length(), "]");
        return s.toString();
    }
}
