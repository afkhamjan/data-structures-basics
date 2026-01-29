class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Binarytree {
    Node root;
    public Binarytree(){
        root  = null;
    }

    // Preorder traversal: root -> left -> right
    void preorder(Node node){
        if( node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder traversal: left -> root -> right
    void inorder(Node node){
        if (node ==null) return ;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder traversal: left -> right -> root
    void postorder(Node node){
        if(node == null) return ;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Binarytree tree = new Binarytree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.println("preorder");
        tree.preorder(tree.root);
        System.out.println();

        System.out.println("inorder");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("postorder");
        tree.postorder(tree.root);
        System.out.println();
    }
}
