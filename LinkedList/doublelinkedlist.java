public class doublelinkedlist {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        System.out.println("Insert at front");
        list.display();
        System.out.println("Insert at last");
        list.insertLast(99);
        list.display();
        System.out.println("Insert at last");
        list.insertLast(89);
        list.display();
        System.out.println("Insert at position");
        list.insert(100, 3);
        list.display();
        // System.out.println("Delete at first");
        // System.out.println(list.deleteFirst());
        // list.display();
        // System.out.println("Delete at last:"+list.deleteLast());
        // list.display();
        // System.out.println(list.delete(2));
        // list.display();
        // System.out.println(list.find(3));
    }
    public static class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
    private static class DLL{
        private Node head;
        public void insertFirst(int val){
            Node node= new Node(val);
            node.next=head;
            node.prev=null;
            if(head!=null){
                head.prev= node;
            }
            head = node; 
        }
        public void insertLast(int val){
            Node node = new Node(val);
            if (head == null) {
                head = node;
                return ;    
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
            node.next=null;
            
        }
        public void insert(int val, int index){
            Node node = new Node(val);
            if(head==null){
                head=node;
                return;
            }
            Node temp=head;
            for(int i=0 ;i<index;i++){
                temp=temp.next;
            }
            node.next=temp.next;
            temp.next=node;
            node.prev=temp;
            if(node.next!=null){
                node.next.prev=node;
            } 
        }
        // public Node find(int value){
        //     Node node = head;
        //     while(node!=null){
        //         if(node.val==value){
        //             return node;
        //         }
        //         node=node.next;
        //     }
        //     return null;
        // }
        public void display(){
            Node node = head;
            Node last = null;
            while(node!=null){
                System.out.print(node.val + "->");
                last=node;
                node=node.next;
            }
            System.out.println("NULL");

            System.out.println("Print in reverse");
            while(last!=null){
                System.out.print(last.val+"->");
                last=last.prev;
            }
            System.out.println("NULL");
        }
    }
}
