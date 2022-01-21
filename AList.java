import org.knowm.xchart.style.colors.ColorBlindFriendlySeriesColors;

/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class AList {
    private int[] items;
    private int size;
    private int first;
    private int last;

    /** Creates an empty list. */
    public AList() {
        items = new int[3];
        size = 0;
        first = 0;
        last = 1;
    }

    public AList(AList a) {
        int[] p = new int[a.items.length];
        System.arraycopy(a.items, 0, p, 0, a.items.length);
        this.items = p;
        this.first = a.first;
        this.last = a.last;
        this.size = a.size;
    }

    /**resizing the length of array. */
    private void resize(int capcity) {
        int[] a = new int[capcity];
        if(first > last)
        System.arraycopy(items, last, a, items.length + last, size);
        else {
        System.arraycopy(items, 0, a, 0, last);
        System.arraycopy(items, last, a, last + items.length, size - last);
        first += items.length;}
        items = a;
    }

    /** 从列表前面插入x. */
    public void addFirst(int x) {
        if(size == items.length)
            resize(size * 2);
        items[first] = x;
        first --;
        if(first == -1) {
            first += items.length;
        }
        size ++;
    }
    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size == items.length)
            resize(size * 2);
        items[last] = x;
        last ++;
        if(last == items.length)
            last -= items.length;
        size ++;
    }

    /** 返回first. */
    public int getFirst() {
        if(first == items.length - 1)
            return items[first + 1 - items.length];
        return items[first + 1];
    }


    /** Returns the item from the back of the list. */
    public int getLast() {
        if(last == 0)
        return items[last - 1 + items.length];
        return items[last - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        if(!(i + first + 1 < items.length))
            return items[first + 1 + i - items.length];
        return items[i + first + 1];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** 是否为空列表. */
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    /** print the AList. */
    public void printAList() {
        int i = first + 1;
        int j = 0;
        if (i == size)
            i = first + 1 - size;
        while (j < size - 1) {
            System.out.print(this.get(j) + " ");
            i ++;
            j ++;
        }
        System.out.println(this.get(j));
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        last --;
        if(last == -1)
            last += items.length;
        size = size - 1;
        return x;
    }

    /** 移除并返回第一位. */
    public int removeFirst() {
        int x = getFirst();
        first ++;
        if(first == items.length)
            first -= items.length;
        size = size - 1;
        return x;
    }

    public static void main(String[] args) {
        AList a = new AList();
//        System.out.println(a.isEmpty());
        a.addFirst(0);
        a.addLast(1);
        a.addLast(2);
//        System.out.println(a.getLast());
//        System.out.println(a.getFirst());
//        System.out.println(a.size);
//        a.printAList();
        a.addLast(3);
//        System.out.println(a.getLast());
//        System.out.println(a.getFirst());
//        System.out.println(a.size);
//        System.out.println(a.items.length);
//        a.printAList();
        a.addLast(4);
        a.addLast(5);
        a.addFirst(-1);
        a.addFirst(-2);
//        a.printAList();
        a.addFirst(-3);
        a.addFirst(-4);
        a.addFirst(-5);
        a.addFirst(-6);
        a.addLast(6);
        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeLast());
//        a.printAList();
//        System.out.println(a.removeFirst());
//        a.printAList();
//        System.out.println(a.removeFirst());
//        a.printAList();
//        System.out.println(a.removeFirst());
//        a.printAList();
//        System.out.println(a.removeFirst());
//        a.printAList();
        System.out.println(a.removeFirst());
        a.printAList();
        System.out.println(a.removeLast());
        a.printAList();
        System.out.println(a.removeFirst());
        a.printAList();
        System.out.println(a.removeLast());
        a.printAList();
        System.out.println(a.removeFirst());
        a.printAList();
        System.out.println(a.removeLast());
        a.printAList();
        System.out.println(a.removeFirst());
        a.printAList();
        System.out.println(a.removeLast());
        a.printAList();
        System.out.println(a.removeFirst());
        a.printAList();
        System.out.println(a.removeLast());
        a.printAList();
        AList A = new AList(a);
        A.printAList();
    }
} 