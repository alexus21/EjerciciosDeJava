public class BinaryTree {

    public static void main(String[] args){
        BinarySearchTree<Integer> arbol = new BinarySearchTree<>();

        arbol.add(8);
        arbol.add(4);
        arbol.add(arbol.getRoot(), 10);
        BinaryTreeNode<Integer> t = arbol.add(arbol.getRoot(), 12);
        arbol.add(arbol.getRoot(), 15);
        arbol.add(1);
        //arbol.preOrder(arbol.getRoot());

        System.out.println(arbol.depth(t));

    }
}
