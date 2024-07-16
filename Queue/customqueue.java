package Queue;

public class customqueue {
    public static void main(String[] args) throws Exception{
        customqueue q= new customqueue(5);
        q.insert(3);
        q.insert(6);
        q.insert(5);
        q.insert(19);
        q.insert(1);
        q.display();
        System.out.println("The front  element is "+q.front());
        System.out.println("The remove  element is "+q.remove());
        q.display();

    }
    private int[] data;
    private static final int defaultSize=10;
    int end=0;
    public customqueue(){
        this(defaultSize);
    }
    public customqueue(int size){
        this.data=new int[size];
    }
    public boolean isFull(){
        return end==data.length;
    }
    public boolean isEmpty(){
        return end==0;
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]=item;
        return true;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }
    public int remove(){
        if(isEmpty()){
            System.out.println("items are empty");
        }
        int removed=data[0];
        //shift the elements to left
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    
    public void display(){
        for(int i=0;i<end;i++) {
            System.out.print(data[i]+"-");
        }
        System.out.println("End");
    }
}
