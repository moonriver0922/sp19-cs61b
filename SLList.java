public class SLList<moonriver> {
    private  class StuffNode {
        public moonriver item;
        public StuffNode next;

        public StuffNode(moonriver i, StuffNode n){
            item = i;
            next = n;
        }
    }

    //创建一个哨兵节点
    private StuffNode sentinel;
//    private StuffNode first;
    private int size = 0;

    //空列表
//    public SLList() {
//        sentinel = new StuffNode(922, null);
//        size = 0;
//    }

    public SLList(moonriver x) {
        sentinel = new StuffNode(x, null);
        size = 0;
    }

    public void addFirst(moonriver x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size++;
    }

    public moonriver getFirst() {
        return sentinel.next.item;
    }

    public moonriver getLast() {
        StuffNode p = sentinel.next;
        while (p.next != null)
            p = p.next;
        return p.item;
    }

    public void addLast(moonriver x) {
        size++;
        StuffNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new StuffNode(x, null);
    }
    //使用迭代
    public int size() {
        int n = 1;
        StuffNode p = sentinel.next;
        while (p.next != null) {
            n++;
            p = p.next;
        }
        return n;
    }
    //使用递归
    private int size1(StuffNode p) {
        if (p.next == null)
            return 1;
        return 1 + size1(p.next);
    }
    public int size1() {
        //return size1(first);
        return size;
    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(5);
        L.addFirst(1);
        L.addLast(5);
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
        System.out.println(L.size());
        System.out.println(L.size1());
    }


}
