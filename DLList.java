public class DLList {
    private class IntNode{
        int item;
        IntNode prev;
        IntNode next;

        public IntNode(int x, IntNode p, IntNode n){
            item = x;
            prev = p;
            next = n;
        }
    }
    private IntNode sentinel;
//    private IntNode first;
    private int size;

    public DLList() {
        sentinel = new IntNode(922, sentinel, sentinel);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public DLList(DLList d) {
        DLList d_copy = new DLList();
        int i = 0;
        while (i < d.size) {
            d_copy.addLast(d.get(i));
            i++;
        }
        this.sentinel = d_copy.sentinel;
        this.size = d_copy.size;
    }

//    public DLList(int x) {
//        sentinel = new IntNode(922, sentinel, sentinel);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        first = new IntNode(x, sentinel, sentinel.next);
//        size = 1;
//    }

    public void addFrist(int x) {
        sentinel.next = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    public void addLast(int x) {
        sentinel.prev = new IntNode(x, sentinel.prev, sentinel);

        sentinel.prev.prev.next = sentinel.prev;
        size ++;
    }

    public boolean isEmpty() {
        if(this.size() == 0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel.next;
        int n = size;
        while (n > 1){
            System.out.print(p.item + " ");
            p = p.next;
            n --;
        }
        System.out.println(p.item);
    }

    public int removeFirst() {
        int i = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size --;
        return i;
    }

    public int removeLast() {
        int i = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size --;
        return i;
    }

    public int get(int x) {
        int n = 0;
        IntNode p = sentinel.next;
        if(x >= size)
            return -1;
        while (x != n) {
            n ++;
            p = p.next;
        }
        return p.item;
    }

    /** 使用递归实现是需要考虑辅助方法，想了比较久。 */
    public int getRecursive(int x) {
        if(x > size - 1)
            return -999999;
        return getR(sentinel.next, x);
    }

    public int getR(IntNode i, int x) {
        if(x == 0)
            return i.item;
        return getR(i.next, -- x);
    }

    public static void main(String[] args) {
        DLList D = new DLList();
        D.addFrist(9);
        D.addFrist(1);
        D.addFrist(3);
        D.addLast(0);
        D.addLast(1);
        D.addLast(0);
        D.addLast(2);
        D.addLast(0);
        D.addLast(2);
        D.addLast(9);
        System.out.println(D.size);
        D.printDeque();
        System.out.println(D.removeFirst());
        D.printDeque();
        System.out.println(D.removeLast());
        D.printDeque();
        System.out.println(D.get(1));
        System.out.println(D.get(2));
        DLList D1 = new DLList(D);
        D1.printDeque();
        System.out.println(D1.size);
        D.addFrist(3);
        D.printDeque();
        D1.printDeque();
        System.out.println(D1.getRecursive(0));
        System.out.println(D1.getRecursive(1));
        System.out.println(D1.getRecursive(2));
        System.out.println(D1.getRecursive(3));
        System.out.println(D1.getRecursive(4));
        System.out.println(D1.getRecursive(5));
        System.out.println(D1.getRecursive(6));
        System.out.println(D1.getRecursive(7));






    }
}
