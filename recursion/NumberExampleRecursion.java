public class NumberExampleRecursion {
    public static void main(String[] args) {
        print(1);
        System.out.println("\nIn reverse order:");
        print1(5);
        System.out.println(("\nIn order but by using above function: "));
        printrev(5);
        System.out.println("\nPrinting in both order");
        printboth(7);
        int n=7;
        System.out.println("\nThe factorial of "+n+" is "+factorial(n));
        System.out.println("The sum of "+n+" is "+sumOfNnumber(n));
        int num = 1342;
        System.out.println("The reverse of "+num+" is ");
        rev(num);

    }
    static void print(int n){
        if(n==6){ //if(n==5){ sout(5); return; }
            return;
        }
        System.out.print(n+" ");
        n++;
        print(n);          
    }
    static void print1(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        // n--;
        // print1(n);
        print1(n-1);
    }
    static void printrev(int n){
        if(n==0){
            return;
        }
        printrev(n-1);
        System.out.print(n+" ");
    }
    static void printboth(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printboth(--n);
        System.out.print(n+" ");
    }
    static int factorial(int n){
        if(n<=1){
            return 1;
        }
         return n*factorial(n-1);
    }
    static int sumOfNnumber(int n){
        if(n<=0){
            return n;
        }
        return n+sumOfNnumber(n-1);
    }
    static int sum = 0;
    static void rev(int n){
        if(n==0){
            System.out.println(sum);
            return;
        }
        int remainder = n%10;
        sum = sum*10+remainder;
        rev(n/10);
    }
}
