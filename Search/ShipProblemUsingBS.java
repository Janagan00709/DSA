package Search;

// Capacity To Ship Packages Within D Days 

class ShipProblemUsingBS {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int day = 5;
        int sum = 0;
        int max = 0;
        for(int i=0;i<arr.length;i++){
            sum =sum + arr[i];
            max = Math.max(arr[i],max);
        }
        // System.out.println(sum);
        // System.out.println(max);
        System.out.println(BinarySearch(max,sum,arr,day));
        
    }
    public static int findDays(int[] weights,int cap){
        int days = 1;
        int load = 0 ;
        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > cap){
                days++;
                load = weights[i];
            }else{
                load = load + weights[i];
            }
        }
        return days;
    }
    public static int BinarySearch(int max,int sum,int[] weights,int d){
        int low = max, high = sum;
        while(low <= high){
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights,mid);
            if(numberOfDays <= d){
                high = mid - 1;
            }
            else{
                low = mid + 1; 
            }
        }
        return low;
    }
    
}
