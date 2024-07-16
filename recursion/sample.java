public class sample{
    public static void main(String[] args){
        //write a function that prints hello world
        message(); // Call the message function here
    }
    static void message() {
        System.out.println("Hello world");
        message1();
    }
    static void message1(){
        System.out.println("Hello world");
        message2();
    }
    static void message2(){
        System.out.println("Hello world");
        message3();
    }
    static void message3(){
        System.out.println("Hello world");
        message4();
    }
    static void message4(){
        System.out.println("Hello world");
    }
}