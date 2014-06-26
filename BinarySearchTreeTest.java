/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 */
public class BinarySearchTreeTest {
    public static void main(String args[]) {
        BinarySearchTree<BinaryNode> root = new BinarySearchTree<BinaryNode>(new BinaryNode(10));

        Tree bst = BinarySearchTree.<BinaryNode>insert(root,new BinaryNode(5));
        bst = BinarySearchTree.<BinaryNode>insert(root, new BinaryNode(15));
        bst = BinarySearchTree.<BinaryNode>insert(root, new BinaryNode(8));
        bst = BinarySearchTree.<BinaryNode>insert(root, new BinaryNode(18));
        bst = BinarySearchTree.<BinaryNode>insert(root, new BinaryNode(2));
        bst = BinarySearchTree.<BinaryNode>insert(root, new BinaryNode(1));

        System.out.println("Tree created");


        System.out.println("The minimum is: "+ BinarySearchTree.<BinaryNode>findMin(root).getData());
        System.out.println("The maximum is: "+ BinarySearchTree.<BinaryNode>findMax(root).getData());

        System.out.println("The node 2 is deleted: Root is at "+ BinarySearchTree.<BinaryNode>delete(root, new BinaryNode(2)).getData());

        boolean b = BinarySearchTree.<BinaryNode>contains(root, new BinaryNode(2));
        System.out.println("The tree contains 2: "+ b);


    }
}
