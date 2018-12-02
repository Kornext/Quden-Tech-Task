package task1;

public class ListNode {

    protected int value;
    protected ListNode nextNode;

    public ListNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", nextNode=" + nextNode +
                '}';
    }
}
