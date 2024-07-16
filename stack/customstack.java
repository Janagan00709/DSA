package stack;

public class customstack {
    public static void main(String[] args) throws Exception {
        // customstack stack=new customstack(5);
        customstack stack= new dynamicstack(5);
        stack.push(78);
        stack.push(52);
        stack.push(54);
        stack.push(45);
        stack.push(56);
        stack.push(70);
        System.out.println("The elements in the Stack are:");
        stack.display(); 
        stack.pop();
        stack.pop();
        System.out.println("\nThe elements available after pop:");
        stack.display();  

    }
    public int[] data;
    private static final int  defaultSize = 10;

    int ptr=-1;

    public customstack(){
        this(defaultSize);
    }
    public  customstack(int size) {
        this.data=new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full!!");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty stack!");
            // System.out.println("Stack is empty!!");
            // return false;
        }
        //int remove=data[ptr];
        // ptr--;
        //return removed;
        return data[ptr--];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("cannot peek from an empty stack");
            return -1;
        }
        return data[ptr];
    }
    public void display(){
        for (int i=0;i<=ptr;i++) {
            System.out.print(data[i]+" "); 
        }
    }

    public boolean isFull(){
        return ptr==data.length-1;
    }
    public boolean isEmpty(){
        return  ptr == -1;
    }
}
