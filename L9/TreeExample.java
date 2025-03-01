package L9;

public class TreeExample {

    class Tree<T> {
        TreeNode<T> root;
    }
    
    class TreeNode<T> {
        T data;
        List<TreeNode<T>> children;
    }
}
