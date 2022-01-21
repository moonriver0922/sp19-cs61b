public class IntList {
    public int first;
    public IntList rest;


    public static void main(String[] args) {
        IntList L = new IntList(5, null);
//        L = new IntList(10, L);
//        L = new IntList(5, L);
        L = addFirst(L, 4);
        L = addFirst(L, 3);
        L = addFirst(L, 2);
        L = addFirst(L, 1);
        System.out.println(L.size());
        System.out.println(L.get1(1));
    }



    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }
    //使用递归
    public int size(){
        if(rest == null)
            return 1;
        return 1 + rest.size();
    }
    //使用迭代
    public int iterativeSize(){
        IntList p = this;
        int length = 0;
        while(p != null) {
            length ++;
            p = p.rest;
        }
        return length;
    }
    //使用迭代
    public int get(int num) {
        IntList p = this;
        if(num > p.size() - 1) {
            num = p.size() - 1;
        }
        while(num > 0){
            p = p.rest;
            num --;
        }
        return p.first;
    }
    //使用递归
    public int get1(int num) {
        if(num == 0)
            return first;
        return rest.get1(--num);//注意，这里用num--虽然不对，但是异常是陷入无穷递归，和预期的右移一位不符
    }

    public static IntList addFirst(IntList l, int x) {
        l = new IntList(x, l);
        return l;
    }

}
