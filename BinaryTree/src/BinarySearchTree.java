public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> root;

    public BinaryTreeNode<T> getRoot(){
        return root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean isRoot(BinaryTreeNode<T> node){
        return root == node;
    }

    public boolean isLeaf(BinaryTreeNode<T> node){
        return node.getLeft() == null && node.getRight() == null;
    }

    public boolean isInternal(BinaryTreeNode<T> node){
        return !isLeaf(node);
    }

    public BinaryTreeNode<T> add(BinaryTreeNode<T> origen, T element){

        BinaryTreeNode<T> node = null;

        if(root == null){
            root = new BinaryTreeNode<>(element);
        }
        else{
            if(origen.getElement().compareTo(element) <= 0){
                if(origen.getLeft() != null){
                    node = add(origen.getLeft(), element);
                }
                else{
                    node = new BinaryTreeNode<>(element);
                    node.setParent(origen);
                    origen.setLeft(node);
                }
            }
            else{
                if(origen.getRight() != null){
                    node = add(origen.getRight(), element);
                }
                else{
                    node = new BinaryTreeNode<>(element);
                    node.setParent(origen);
                    origen.setRight(node);
                }
            }
        }
        return node;
    }

    public BinaryTreeNode<T> add(T elemento) {

        BinaryTreeNode<T> nodo = null;
        //Si el root es nulo, lo añade el primero
        if (root == null) {
            nodo = new BinaryTreeNode<>(elemento);
            root = nodo;
        } else {

            //Creo un nodo auxuliar
            BinaryTreeNode<T> aux = root;
            boolean insertado = false;
            //No salgo hasta que este insertado
            while (!insertado) {

                //Comparamos los elementos
                //Si el nodo del origen es mayor que el elemento pasado, pasa a la izquierda
                if (aux.getElement().compareTo(elemento) > 0) {

                    //Si tiene nodo izquierdo, actualizo el aux
                    if (aux.getLeft() != null) {
                        aux = aux.getLeft();
                    } else {
                        //Creo el nodo
                        nodo = new BinaryTreeNode<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setLeft(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                } else {

                    if (aux.getRight() != null) {
                        aux = aux.getRight();
                    } else {
                        //Creo el nodo
                        nodo = new BinaryTreeNode<>(elemento);
                        //Indico que el padre del nodo creado
                        nodo.setParent(aux);
                        aux.setRight(nodo);
                        //indico que lo he insertado
                        insertado = true;
                    }

                }

            }

        }

        return nodo;

    }

    public void preOrder(BinaryTreeNode<T> node){

        System.out.println(node.getElement().toString());

        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if(node.getRight() != null){
            preOrder(node.getRight());
        }
    }

    public void inOrder(BinaryTreeNode<T> node){

        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }

        System.out.println(node.getElement().toString());

        if(node.getRight() != null){
            preOrder(node.getRight());
        }
    }

    public void postOrder(BinaryTreeNode<T> node){

        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }

        if(node.getRight() != null){
            preOrder(node.getRight());
        }

        System.out.println(node.getElement().toString());
    }

    public int height(BinaryTreeNode<T> node){

        int height = 0;

        if(isInternal(node)){
            if(node.getLeft() != null){
                height = Math.max(height, height(node.getLeft()));
            }

            if(node.getRight() != null){
                height = Math.max(height, height(node.getRight()));
            }
        }
        return height;
    }

    public int depth(BinaryTreeNode<T> node){

        int depth = 0;

        if(node != getRoot()){
            depth = 1 + depth(node.getParent());
        }
        return depth;
    }

    public void remove(BinaryTreeNode<T> node){
        if(root == null){
            System.out.println("Nothing to delete");
        }
        else if(isLeaf(node)){
            //
        }
        else if(node.getRight() != null && node.getLeft() == null){
            //
        }else if(node.getRight() == null && node.getLeft() != null){
            //
        }else{
            //
        }
    }

    private void removeLeaf(BinaryTreeNode<T> node){
        if(isRoot(node)){
            root = null;
        }else{
            BinaryTreeNode<T> parent = node.getParent();

            if(parent.getLeft() == node){
                parent.setLeft(null);
            }
            if(parent.getRight() == node){
                parent.setRight(null);
            }
            node = null;
        }
    }

    private void removeWithChild(BinaryTreeNode<T> node, int nodeType){
        BinaryTreeNode<T> next;

        switch(nodeType){
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;
        }
    }


    private BinaryTreeNode<T> minimum(BinaryTreeNode<T> node){

        if(node != null && node.getLeft() != null){
            while(!isLeaf(node)){
                node = minimum(node.getLeft());
            }
        }
        return null;
    }

}
