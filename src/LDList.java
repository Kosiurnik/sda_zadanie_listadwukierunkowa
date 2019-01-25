import java.util.NoSuchElementException;

class LDList {
    private LDElement first;
    private LDElement last;
    private int size;

    LDList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    void addFirst(int val){
        LDElement element = new LDElement(val);
        if(first == null){
            first = element;
            last = first;
        }else{
            first.setPrev(element);
            element.setNext(first);
            first = element;
        }
        size++;
    }

    void addLast(int val){
        LDElement element = new LDElement(val);
        if(first == null){
            first = element;
            last = first;
        }else{
            element.setPrev(last);
            last.setNext(element);
            last = element;
        }
        size++;
    }

    int peekFirst(){
        if(isEmpty())
            return 0;
        else
            return first.getValue();
    }

    int peekLast(){
        if(isEmpty())
            return 0;
        else
            return last.getValue();
    }

    int pollFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        else{
            LDElement element = first;
            if(first.getNext() == null){
                first = null;
                last = null;
            }else{
                first = first.getNext();
                first.setPrev(null);
            }
            size--;
            return element.getValue();
        }
    }

    int pollLast(){
        if(isEmpty()) throw new NoSuchElementException();
        else{
            LDElement element = last;
            if(last.getPrev() == null){
                first = null;
                last = null;
            }else{
                last = last.getPrev();
                last.setNext(null);
            }
            size--;
            return element.getValue();
        }
    }

    void show(){
        if(size == 0) return;
        if(first.getNext() == null){
            System.out.println(first.getValue());
            return;
        }
        LDElement element;
        System.out.print(first.getValue()+"\t");
        element = first.getNext();
        while(element.getNext() != null){
            System.out.print(element.getValue()+"\t");
            element = element.getNext();
        }
        System.out.println(element.getValue());
    }


    void showReverse(){
        if(size == 0) return;
        if(last.getPrev() == null){
            System.out.println(last.getValue());
            return;
        }
        LDElement element;
        System.out.print(last.getValue()+"\t");
        element = last.getPrev();
        while(element.getPrev() != null){
            System.out.print(element.getValue()+"\t");
            element = element.getPrev();
        }
        System.out.println(element.getValue());
    }

    private boolean isEmpty(){
        return size == 0;
    }
}
