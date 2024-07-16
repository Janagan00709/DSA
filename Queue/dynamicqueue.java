package Queue;

public class dynamicqueue extends circularqueue{
    public static void main(String[] args) {
        dynamicqueue q=new dynamicqueue();
        q.insert(3);
        q.insert(6);
        q.insert(5);
        q.insert(19);
        q.insert(1);
    }
    private int[] data;

    protected int end=0;
    protected int front=0;

    public dynamicqueue(){
        super();
    }
    public dynamicqueue(int size){
        super(size);
    }
    @Override
    public boolean insert(int item){
        if(this.isFull()){
            int[] temp=new int[data.length*2]; // Doubling the array when it is full
            //copy all previous item in new data
            for(int i=0;i<data.length;i++){
                temp[i]=data[(front+i)%data.length];
            }
            front=0;
            end=data.length;
            data=temp;
        }
        return super.insert(item);
    }
        
}
