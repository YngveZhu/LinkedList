package top.zyqer;

class LinkNode <T> {
    private T val;
    private LinkNode<T> next;

    LinkNode(T val) {
        this.val = val;
    }

    LinkNode() {
    }

    T getVal() {
        return val;
    }

    void setVal(T val) {
        this.val = val;
    }

    LinkNode<T> getNext() {
        return next;
    }

    void setNext(LinkNode<T> next) {
        this.next = next;
    }
}
