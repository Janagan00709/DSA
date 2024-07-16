package stack;

public class dynamicstack extends customstack{
    public dynamicstack(){
        super();// It will call customstack
    }
    public dynamicstack(int size){
        super(size);
    }
    @Override
    public boolean push(int item){
        //this takes care of it being full
        if(this.isFull()){
            int[] temp=new int[data.length*2]; // Doubling the array when it is full
            //copy all previous item in new data
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        // At this point we know that array is not full
        // insert item
        return super.push(item); 
    }

    // Additional methods or code
}
