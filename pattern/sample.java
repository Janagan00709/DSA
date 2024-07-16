package pattern;

public class sample {
    public static void main(String[] args) {
        System.out.println("Pattern 1 :");
        pattern1(7);
        System.out.println("Pattern 2 :");
        pattern2(7);
        System.out.println("Pattern 3");
        pattern3(7);
        System.out.println("Pattern 4:");
        pattern4(5);
        System.out.println("Pattern 5:");
        pattern5(7);
        System.out.println("Pattern 6:");
        pattern6(5);
        System.out.println("Pattern 17:");
        pattern17(5);
        System.out.println("Pattern 30:");
        pattern30(5);
        System.out.println("Pattern 31:");
        pattern31(5);
    }
    static void pattern1(int n){
        for(int i=0; i<n ; i++){
            //for every row, run the col
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ 
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern3(int n){
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
            // for(int j=0;j<n-i;j++){
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern4(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(j+1+" ");
            }
            System.out.println("");
        }
    }
    static void pattern5(int n){
        for(int i=0;i<2*n;i++){
            int totalcolsInRow =i > n ? 2*n-i:i; 
            for(int j=0;j<totalcolsInRow;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    static void pattern6(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;

            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern17(int n){
        for(int row=1;row<=2*(n);row++){
            int c = row > n ? 2 * n - row: row;
            for(int space=0;space<n-c;space++){
                System.out.print("  ");
            }
            for(int col=c;col>=1;col--){
                System.out.print(col+" ");
            }
            for(int col=2;col<=c;col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern30(int n){
        for(int row=1;row<=n;row++){
            for(int space=0;space<n-row;space++){
                System.out.print("  ");
            }
            for(int col=row;col>=1;col--){
                System.out.print(col+" ");
            }
            for(int col=2;col<=row;col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern31(int n){
        int orginalN=n;
        for(int row=0;row<=2*n;row++){
            for(int col=0;col<=2*n;col++){
               int atEveryIndex=orginalN-Math.min(Math.min(row,col),Math.min((2*n)-row,(2*n)-col));
               System.out.print(atEveryIndex+" "); 
            }
            System.out.println();
        }
    }
}
