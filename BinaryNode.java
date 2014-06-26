/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 */
public class BinaryNode implements Comparable<BinaryNode>{
    private int data;

    public BinaryNode(int data) {
        this.data = data;
    }

    public int compareTo(BinaryNode newData) {
        if (data < newData.data)
            return -1;
        else if (data > newData.data)
            return 1;
        return 0;
    }

    public String toString() {
       return this.data+"";
    }
}


