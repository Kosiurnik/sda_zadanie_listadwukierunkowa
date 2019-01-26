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
            element.setNext(first);
            first.setPrev(element);
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
        if(isEmpty()) throw new NoSuchElementException();
        else
            return first.getValue();
    }

    int peekLast(){
        if(isEmpty()) throw new NoSuchElementException();
        else
            return last.getValue();
    }

    int pollFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        else{
            LDElement element = first;
            if(first.getNext() == null){
                first = last = null;
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
                first = last = null;
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
        LDElement element = first;
        while(element != null){
            System.out.print(element.getValue()+"\t");
            element = element.getNext();
        }
        System.out.println();
    }

    void showReverse(){
        if(size == 0) return;
        if(last.getPrev() == null){
            System.out.println(last.getValue());
            return;
        }
        LDElement element = last;
        while(element != null){
            System.out.print(element.getValue()+"\t");
            element = element.getPrev();
        }
        System.out.println();
    }

    boolean isElement(int value){
        LDElement element = first;
        while(element!=null){
            if(value==element.getValue()){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    void removeByValue(int value){
        LDElement element = first;
        while(element!=null){
            if(value==first.getValue()){
                pollFirst();
            }else if(value == last.getValue()){
                pollLast();
            }else if(value == element.getValue()){
                element.getPrev().setNext(element.getNext());
                element.getNext().setPrev(element.getPrev());
            }
            element = element.getNext();
        }
    }

    private boolean isEmpty(){
        return size == 0;
    }
}
