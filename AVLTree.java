/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 * Date: 26/06/14
 * Time: 9:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class AVLTree<T> extends Tree<T> {
    private static final int ALLOWED_MAX = 1;


    public AVLTree(T data) {
        super(data);
    }

    public AVLTree(T data, Tree left, Tree right) {
        super(data, left, right);
    }

    public static <T extends Comparable<T>> Tree<T> insert(Tree<T> root, T newData) {
        if (root == null)
            return new AVLTree(newData, null, null);
        int compareResult = newData.compareTo(root.getData());
        if (compareResult < 0) {
            root.setLeft(insert(root.getLeft(), newData));
        }
        else if (compareResult > 0) {
            root.setRight(insert(root.getRight(), newData));
        }
        return balance(root);

    }

    public static <T> Tree<T> balance(Tree<T> root) {
        if (root == null)
            return root;
        if ((getAVLHeight(root.getLeft()) - getAVLHeight(root.getRight())) > ALLOWED_MAX) {
            if (getAVLHeight(root.getLeft().getLeft()) >= getAVLHeight(root.getLeft().getRight()))
                root = rotateWithLeftChild(root);
            else
                root = doubleWithLeftChild(root);

        }
        else if ((getAVLHeight(root.getRight()) - getAVLHeight(root.getLeft())) > ALLOWED_MAX) {
            if (getAVLHeight(root.getRight().getRight()) >= getAVLHeight(root.getRight().getLeft()))
                root = rotateWithRightChild(root);
            else
                root = doubleWithRightChild(root);

        }
        root.setHeight(Math.max(getAVLHeight(root.getLeft()), getAVLHeight(root.getRight())) + 1);

        return root;

    }

    public static <T> int getAVLHeight(Tree<T> root) {
          return (root == null ? -1 : root.getHeight());
    }

    public static <T> Tree<T> rotateWithLeftChild(Tree<T> root) {
        Tree<T> t1 = root.getLeft();
        root.setLeft(t1.getRight());
        t1.setRight(root);
        root.setHeight(Math.max(getAVLHeight(root.getLeft()), getAVLHeight(root.getRight())) + 1);
        t1.setHeight(Math.max(getAVLHeight(t1.getLeft()), getAVLHeight(root)) + 1);
        return t1;

    }

    private static <T> Tree<T> rotateWithRightChild(Tree<T> root) {
        Tree<T> t1 = root.getRight();
        root.setRight(t1.getLeft());
        t1.setLeft(root);
        root.setHeight(Math.max(getAVLHeight(root.getLeft()), getAVLHeight(root.getRight())) + 1);
        t1.setHeight(Math.max(getAVLHeight(root), getAVLHeight(t1.getRight())));
        return t1;
    }

    private static <T> Tree<T> doubleWithLeftChild(Tree<T> root) {
        root.setLeft(rotateWithRightChild(root.getLeft()));
        return rotateWithLeftChild(root);
    }

    private static <T> Tree<T> doubleWithRightChild(Tree<T> root) {
        root.setRight(rotateWithLeftChild(root.getRight()));
        return rotateWithRightChild(root);
    }

    public static <T extends Comparable<T>> Tree<T> delete(Tree<T> root, T dataToRemove) {
        if (root == null)
            return root;
        int compareResult =  dataToRemove.compareTo(root.getData());
        if (compareResult < 0) {
            root.setLeft(delete(root.getLeft(), dataToRemove));
        }
        else if (compareResult > 0) {
            root.setRight(delete(root.getRight(), dataToRemove));
        }
        else if (root.getLeft() != null && root.getRight() != null) {
            Tree<T> tempDel = AVLTree.findMin(root.getRight());
            root.setData(tempDel.getData());
            root.setRight(delete(root.getRight(), tempDel.getData()));
        }
        else {
            root = root.getLeft() != null? root.getLeft() : root.getRight();
        }
        return balance(root);
    }

    public static <T> Tree findMin(Tree<T> root) {
        if (root == null)
            return null;
        while (root.getLeft() != null) {
            return findMin(root.getLeft());
        }
        return root;
    }

    public static <T> Tree findMax(Tree<T> root) {
        if (root == null)
            return null;
        while (root.getRight()!=null) {
            return findMin(root.getRight());
        }
        return root;
    }

    public static <T extends Comparable<T>> boolean contains(Tree<T> root, T dataToFind) {
        if (root == null)
            return false;
        int compareResult = dataToFind.compareTo(root.getData());
        if (compareResult < 0) {
            return contains(root.getLeft(), dataToFind);
        }
        else if (compareResult > 0) {
            return contains(root.getRight(), dataToFind);
        }
        return true;
    }

}
