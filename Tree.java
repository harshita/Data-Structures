/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 * Date: 24/06/14
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tree<T> {
    private T data;
    private Tree left;
    private Tree right;
    private int height;

    public Tree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Tree(T data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
