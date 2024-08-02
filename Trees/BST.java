package Trees;

public class BST {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums={5,2,7,1,4,6,9,8,3,10};
        tree.populate(nums);
        tree.display();
        int[] nums1={1,2,3,4,5,6,7,8,9,10};
        tree.populatedSorted(nums1);
        tree.display();
        System.out.println("Preorder traversal:");
        tree.preOrder();
        System.out.println("Inorder traversal:");
        tree.inOrder();
        System.out.println("Postorder traversal;");
        tree.postOrder();
        System.out.println(tree.height(null));
    }
    public class Node{
        private int value;
        private int height;
        private Node left, right;
        public Node(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;
    public BST() {

    }
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int value){
        root = insert(value,root);
    }
    public Node insert(int value,Node node){
        if(node == null){
            node = new Node(value); // create in and return it
            return node;
        }
        if(value < node.value){
            node.left=insert(value, node.left);
        }
        if(value > node.value){
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
           return true; 
        }
        return Math.abs(height(node.left)-height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }
    public void display(){
        display(this.root,"Root Node:");
    }
    private void display(Node node,String details){
        if(node==null){
            return;
        }
        // System.out.println(details+node.getValue());
        // display(node.left,details+"Left child of: "+node.getValue()+" : ");
        // display(node.right,details+"Right child of: "+node.getValue()+" : ");
        System.out.println(details+node.value);
        display(node.left,"Left child of: "+node.value+" : ");
        display(node.right,"Right child of: "+node.value+" : ");
    }
    public void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }
    public void populatedSorted(int[] nums){
        populatedSorted(nums,0,nums.length);
    }
    private void populatedSorted(int[] nums,int start,int end){
        if(start >=end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populatedSorted(nums,start,mid);
        populatedSorted(nums,mid+1,end);
    }
    public void preOrder(){
        preOrder(this.root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(){
        inOrder(this.root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value+" ");
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value+"");
    }
}
