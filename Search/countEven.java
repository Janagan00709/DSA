package Search;
/*1295. Find Numbers with Even Number of Digits*/
//we can also use integer to string method(Integer.toString(nums))
public class countEven {
    public static void main(String[] args) {
        int[] nums={12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }
    static int findNumbers(int[] nums){
        int count=0;
        for(int num:nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    static boolean even(int num){
        int numberOfDigits=digits(num);
        if(numberOfDigits%2==0){
            return true;
        }
        return false;
    }
    static int digits(int num){
        int count=0;
        if(num<0){
            num=num*-1;
        }
        if(num==0){
            return 1;
        }
        while(num>0){
            count++;
            num=num/10;
        }
        return count;
    }
    
    //optimize the digit

    static int digits2(int num){
        return (int)(Math.log10(num))+1;
    }
}
