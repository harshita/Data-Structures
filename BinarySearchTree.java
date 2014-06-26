

/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 */


public class BinarySearchTree<T> extends Tree<T>{
    public BinarySearchTree(T data) {
        super(data);
    }

    public BinarySearchTree(T data, Tree left, Tree right) {
        super(data, left, right);
    }

    public static <T extends Comparable<T>> Tree insert(Tree<T> root, T newData) {
        if (root == null)
            return new BinarySearchTree(newData, null, null);
        int compareResult = newData.compareTo(root.getData());
        if (compareResult < 0) {
            root.setLeft(insert(root.getLeft(), newData));
        }
        else if (compareResult >= 0) {
            root.setRight(insert(root.getRight(), newData));
        }

        return root;
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


    public static <T extends Comparable<T>> Tree delete(Tree<T> root, T dataToDel) {
        if (root == null)
            return null;
        int compareResult = dataToDel.compareTo(root.getData());
        if (compareResult < 0) {
            root.setLeft(delete(root.getLeft(), dataToDel));
        }
        else if (compareResult > 0) {
            root.setRight(delete(root.getRight(), dataToDel));
        }
        else if (root.getLeft() != null && root.getRight() != null) {
            Tree<T> tempDel = BinarySearchTree.findMin(root.getRight());
            root.setData(tempDel.getData());
            root.setRight(delete(root.getRight(), tempDel.getData()));
        }
        else {
            root = (root.getLeft() == null ? root.getRight() : root.getLeft());
        }
        return root;

    }

}

