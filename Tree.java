public class Tree {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            left=right=null;

        }
    }
    static class BinaryTree{
        static int idx=-1;
        public Node buildTree(int arr[]){
            idx++;
            if(arr[idx]==-1){
                return null;
            }
            Node newNode=new Node(arr[idx]);
            newNode.left=buildTree(arr);    
            newNode.right=buildTree(arr);
            return newNode;
        }
        public static void preorder(Node root){
            if(root==null){
                return ;
            }
            System.out.print(root.data+" ");//root
            preorder(root.left);//left Subtree
            preorder(root.right);//Right Subtree
        }
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public int height(Node root){
            if(root==null){
                return 0;
            }
            int left_height=height(root.left);// find the height of left subtree
            int right_height=height(root.right);//find the height of right tree
            int myHeight=Math.max(left_height,right_height)+1;
            return myHeight;
        }
    }
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int leftCount=countNode(root.left);
        int rightCount=countNode(root.right);
        return leftCount+rightCount+1;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftaSum=sum(root.left);
        int rightSum=sum(root.right);
        return leftaSum+rightSum+root.data;
    }
      public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //          1
        //        /   \
        //       2     3
        //      / \     \
        //     4   5     6
        Node root=tree.buildTree(arr);
        // System.out.println(root.data);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        System.out.println("Height of tree is : "+tree.height(root));
        System.out.println("Number of nodes : "+countNode(root));
        System.out.println("Sum of all nodes : "+Tree.sum(root));
    }
   
}
