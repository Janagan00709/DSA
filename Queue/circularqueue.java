package Queue;

public class circularqueue {
    public static void main(String[] args) throws Exception {
        circularqueue q=new circularqueue(5);
        q.insert(3);
        q.insert(6);
        q.insert(5);
        q.insert(19);
        q.insert(1);
        q.display();
        System.out.println("The front  element is "+q.Front());
        System.out.println("The remove  element is "+q.remove());
        q.display();
        System.out.println("one element is inserted :");
        q.insert(133);
        System.out.println("One element is inserted:");
        q.insert(99);
        q.display();
    }
    private int[] data;
    private static final int defaultSize=10;
    protected int end=0;
    protected int front=0;
    private int size=0;
    public circularqueue(){
        this(defaultSize);
    }
    public circularqueue(int size){
        this.data=new int[size];
    }
    public boolean isFull(){
        return size==data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]=item;
        end=end%data.length;
        size++;
        return true;
    }
    public int remove(){
        if(isEmpty()){
            System.out.println("items are empty");
        }
        int removed=data[front++];
        front=front%data.length;
        size--;
        return removed;
    }
    public int Front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i]+"-");
            i++;
            i%=data.length;
        }while(i!=end);
        System.out.println("End");
        // for(int i=front;i<end;i++) {
        //     System.out.print(data[i]+"-");
        //     i=i%data.length;
        // }
        // System.out.println("End");
    }
    
}
