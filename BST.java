public class BST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(56);
        bst.insert(30);
        bst.insert(70);
        bst.insert(22);
        bst.insert(40);
        bst.insert(60);
        bst.insert(95);
        bst.insert(11);
        bst.insert(65);
        bst.insert(3);
        bst.insert(16);
        bst.insert(63);
        bst.insert(67);
        bst.print();
    }
}
class BinarySearchTree<T extends Comparable<T>>{
    INode<T> root;
    BinarySearchTree(T val){
        root = new INode<>(val);
    }
    public void insert(T val){
        INode<T> ptr = root;
        insertNode(ptr,val);
    }
    public INode<T> insertNode(INode<T> root,T val){
        if(root == null){
            return new INode<T>(val);
        }
        if(root.val.compareTo(val) > 0){
            root.left = insertNode(root.left,val);
        }
        else {
            root.right = insertNode(root.right,val);
        }
        return root;
    }
    public void print(){
        INode<T> ptr=root;
        printNodes(ptr);
    }
    private void printNodes(INode<T> root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        printNodes(root.left);
        printNodes(root.right);
    }
}
class INode<T>{
    T val;
    INode<T> left;
    INode<T> right;
    INode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}