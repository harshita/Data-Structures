/**
 * Created with IntelliJ IDEA.
 * User: Harshita Karande
 * Date: 27/06/14
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class AVLTreeTest {
    public static void main(String args[]) {
        AVLTree<BinaryNode> root = new AVLTree<BinaryNode>(new BinaryNode(3));

        Tree<BinaryNode> avl = AVLTree.<BinaryNode>insert(root,new BinaryNode(2));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(1));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(4));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(5));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(6));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(7));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(16));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(15));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(14));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(13));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(12));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(11));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(10));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(8));
        avl = AVLTree.<BinaryNode>insert(avl, new BinaryNode(9));


        System.out.println("Tree created");
        System.out.println("After deleting 9:" + AVLTree.<BinaryNode>delete(avl, new BinaryNode(9)).getData());



    }
}
