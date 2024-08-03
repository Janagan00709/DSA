package Oops;

public class WrapperExample {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        //Integer num=45;

        swap(a,b);
        // System.out.println(a+" "+b);
        //Garbage collections
        /*  A obj=new A();
        for(int i=0;i<100000000;i++){
            obj=new A("random name");
        }
        */
        
    }
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a+" "+b);
    }
    //student janagan=new student(janagan);
}
class A{
    final int num=10;
    String name="janagan";
    public A(){
        System.out.println("object is created");
       // this.name=name;
    }
    public A(String name){
        this.name=name;
    }
    @Override
    protected void finalize() throws Throwable{
        // super.finalize();
        System.out.println("Object is destroyed");
    }
}
