package L9;

public class TreeExample2 {

    class Tree<T> {
        TreeNode<T> root;
    }
    
    class TreeNode<T> {
        T data;
        TreeNode<T> firstChild;
        TreeNode<T> nextSibling;    
    }
    
}
