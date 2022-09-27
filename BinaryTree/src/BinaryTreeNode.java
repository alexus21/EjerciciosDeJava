public class BinaryTreeNode<T extends Comparable<T>>{

    private T element;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T element){
        this.element = element;
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> parent){
        this.element = element;
        this.parent = parent;
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> parent, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }

    //Setters
    public void setElement(T element){
        this.element = element;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    //Getters
    public T getElement() {
        return element;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }
}
