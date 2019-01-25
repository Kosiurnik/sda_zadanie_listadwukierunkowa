public class LDMain {
    public static void main(String[] args) {
        LDList lista = new LDList();
        lista.addFirst(1);
        lista.addFirst(2);
        lista.addFirst(3);
        System.out.println("pierwszy: "+lista.peekFirst());
        System.out.println("ostatni: "+lista.peekLast());
        lista.show();
        lista.showReverse();
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);
        lista.show();
        lista.showReverse();
        System.out.println("pierwszy: "+lista.peekFirst());
        System.out.println("ostatni: "+lista.peekLast());
        System.out.println("pollFirst: "+lista.pollFirst());
        lista.show();
        lista.showReverse();
        System.out.println("pollLast: "+lista.pollLast());
        lista.show();
        lista.showReverse();
        System.out.println("pollFirst: "+lista.pollFirst());
        lista.show();
        lista.showReverse();
        System.out.println("pollLast: "+lista.pollLast());
        lista.show();
        lista.showReverse();
    }
}
