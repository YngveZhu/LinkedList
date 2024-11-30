package top.zyqer;

/**
 * 用单向链表实现的数组操作
 * @param <T> 数组的类型
 */
public class LinkedList <T> {
    private LinkNode<T> head = new LinkNode<>();

    public LinkedList() {
    }

    public LinkedList(T val) {
        this.head.setVal(val);
    }

    /**
     * 向数组尾部添加一个或者多个元素
     * @param val 需要向数组尾部添加的元素
     */
    public void append(T ...val) {
        boolean a = false;
        LinkNode<T> l = new LinkNode<T>(val[0]);
        if (head.getVal() == null) {
            this.head = l;
            a = true;
        }

        LinkNode<T> l2 = head;
        while (l2.getNext() != null) l2 = l2.getNext();
        for (int i = 0;i < val.length;i++) {
            if (a && i == 0) continue;
            LinkNode<T> l3 = new LinkNode<>();
            l3.setVal(val[i]);
            l2.setNext(l3);
            l2 = l2.getNext();
        }
        l2.setNext(null);
    }

    /**
     * 向数组指定位置添加元素
     * @param index 索引
     * @param val 需要添加的元素
     */
    public void append(int index, T val) {
        LinkNode<T> l = head;
        if (index == 0) {
            l = new LinkNode<>(val);
            l.setNext(head);
            head = l;
            return;
        }
        for (int i = 0; i < index - 1; i++) l = l.getNext();
        LinkNode<T> l2 = new LinkNode<>(val);
        l2.setNext(l.getNext());
        l.setNext(l2);
    }

    /**
     * 数组指定位置修改元素
     * @param index 索引值
     * @param val 修改后的值
     */
    public void alter(int index, T val) {
        LinkNode<T> l = head;
        for (int i = 0; i < index; i++) l = l.getNext();
        l.setVal(val);
    }

    /**
     * 数组指定位置删除元素
     * @param index 索引值
     * @return 删除的值
     */
    public T remove(int index) {
        T a;
        if (index == 0) {
            a = head.getVal();
            head = head.getNext();
            return a;
        }
        LinkNode<T> l = head;
        for (int i = 0; i < index - 1; i++) l = l.getNext();
        a = l.getNext().getVal();
        l.setNext(l.getNext().getNext());

        return a;
    }

    /**
     * 数组尾部删除元素
     * @return 删除的元素值
     */
    public T remove() {
        T a;
        LinkNode<T> l = head;
        for (int i = 0; i < size() - 2; i++) l = l.getNext();
        a = l.getNext().getVal();
        l.setNext(null);
        return a;
    }

    /**
     * 获取数组指定位置的元素
     * @param index 索引值
     * @return 元素值
     */
    public T element(int index) {
        if (index == 0) return head.getVal();
        LinkNode<T> l = head;
        for (int i = 0; i < index; i++) l = l.getNext();
        return l.getVal();
    }

    /**
     * 获取数组长度
     * @return 数组长度
     */
    public int size() {
        if (head.getVal() == null) return 0;

        int sum = 0;
        LinkNode<T> l = head;
        for (;l != null;l = l.getNext()) sum++;

        return sum;
    }

    /**
     * 检查数组是否为空
     * @return 数组若为空，则返回true，否则返回false
     */
    public boolean isEmpty() {
        return head.getVal() == null;
    }

    /**
     * 打印数组元素
     * @return 数组元素
     */
    @Override
    public String toString() {
        if (head.getVal() == null) return "[]";
        StringBuilder s = new StringBuilder("[");
        LinkNode<T> l = head;
        for (;l != null;l = l.getNext()) s.append(l.getVal()).append(",");
        s.replace(s.length() - 1, s.length(), "]");
        return s.toString();
    }
}
