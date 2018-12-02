package task1;

public class HashTable {

    private ListNode[] buckets;
    private int N = 2;

    public HashTable() {
        buckets = new ListNode[10];
    }

    public HashTable(int number) {
        this.N = number;
    }

    public HashTable(int number, int capacity) {
        this.N = number;
        this.buckets = new ListNode[capacity];
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public void insert(int value) {
        int hash = hashCode(value);
        if (hash >= buckets.length) {
            hash = hash % buckets.length;
        } else {
            if (buckets[hash] == null) {
                buckets[hash] = new ListNode(value);
            } else {
                ListNode endNode = goToEndBucket(buckets[hash]);
                ListNode addNode = new ListNode(value);
                endNode.setNextNode(addNode);
            }
        }
    }

    public void insert(int... values) {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }

    public void insert(String values) {
        String[] symbols = values.split(" ");
        int[] arrayArguments = new int[symbols.length];
        for (int i=0; i<symbols.length; i++) {
            arrayArguments[i] = Integer.parseInt(symbols[i]);
        }
        insert(arrayArguments);
    }

    public void output() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": ");
            if (buckets[i] != null) {
                outputBucket(buckets[i]);
            }
            System.out.println();
        }
    }

    private void outputBucket(ListNode currentNode) {
        if (currentNode.getNextNode() != null) {
            System.out.print(currentNode.getValue() + " ");
            outputBucket(currentNode.nextNode);
        } else {
            System.out.print(currentNode.getValue() + " ");
            return;
        }
    }

    private ListNode goToEndBucket(ListNode currentNode) {
        if (currentNode.getNextNode() == null) {
            return currentNode;
        } else {
            return goToEndBucket(currentNode.getNextNode());
        }
    }

    final int hashCode(int value) {
        return value % N;
    }


}
