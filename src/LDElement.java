class LDElement {
    private int value;
    private LDElement prev;
    private LDElement next;

    LDElement(int value){
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    int getValue() {
        return value;
    }

    LDElement getPrev() {
        return prev;
    }

    void setPrev(LDElement prev) {
        this.prev = prev;
    }

    LDElement getNext() {
        return next;
    }

    void setNext(LDElement next) {
        this.next = next;
    }
}
