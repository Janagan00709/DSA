package Trees;

public class SegmentTree {
    public static void main(String[] args) {
        int[] arr={3,8,6,7,-2,-8,4,9};
        SegmentTree st=new SegmentTree(arr);
        st.display();
        System.out.println(st.query(1,6));
    }
    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int startInterval,int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }
    Node root;
    public SegmentTree(int[] arr){
        //create a tree using this arr
        this.root=constructTree(arr,0,arr.length-1);
    }
    public Node constructTree(int[] arr,int start,int end){
        if(start==end){
            Node leaf=new Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        //create new node with index you are at
        Node node=new Node(start,end);
        int mid=(start+end)/2;
        node.left=constructTree(arr,start,mid);
        node.right=constructTree(arr,mid+1, end);
        node.data=node.left.data+node.right.data;
        return node;        
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";
        if(node==null) return;
        if(node.left!=null){
            str=str+"Interval=["+node.left.startInterval+"-"+node.endInterval+"] and data : "+node.left.data+" -> ";
        }else{
            str=str+"No left child";
        }
         //current node
         if(node.right!=null){
            str=str+"Interval=["+node.startInterval+"-"+node.endInterval+"] and data : "+node.left.data+"->";
         }
         else{
            str=str+"No right child";
         }
         System.out.println(str);
         //call recursion
         if(node.left!=null){
            display(node.left);
         }
         if(node.right!=null){
            display(node.right);
         }
    }
    public int query(int qsi,int qei){
        return query(this.root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.startInterval>=qsi && node.endInterval <=qei){
            return node.data;
        }
        else if(node.startInterval>qei || node.endInterval <qei){
            return 0;
        }else{
            return this.query(node.left,qsi, qei)+this.query(node.right,qsi,qei);
        }
    }
    public void update(int index,int value){
        this.root.data=update(this.root,index,value);
    }
    private int update(Node node,int index,int value){
        if(index >=node.startInterval && index<=node.endInterval){
            if(index==node.startInterval&& index==node.endInterval){
                node.data=value;
                return node.data;
            }else{
                int leftAns=update(node.left,index,value);
                int rightAns=update(node.right,index,value);
                node.data=leftAns+rightAns;
                return node.data;
            }
        }
        return node.data;
    }


}
