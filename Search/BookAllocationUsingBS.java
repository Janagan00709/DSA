package Search;

// Book Allocation Problem
// we can also use this in painters partition problem / split array largest sum
// If in the question mentioned min of max , then we have to use binary search

class BookAllocationUsingBS {
    public static void main(String[] args) {
        int arr[] = {25,46,28,49,24};
        int Student = 4;
        int sum = 0;
        int max = 0;
        for(int i=0;i<arr.length;i++){
            sum =sum + arr[i];
            max = Math.max(arr[i],max);
        }
        System.out.println(BinarySearch(max,sum,arr,Student));
        
    }
    public static int countStudent(int[] arr,int pages){
        int students = 1;
        int studentpages = 0 ;
        for(int i=0;i<arr.length;i++){
            if(studentpages + arr[i] <= pages){
                studentpages =  studentpages + arr[i];
            }else{
                students++;
                studentpages = arr[i];
            }
        }
        return students;
    }
    public static int BinarySearch(int max,int sum,int[] weights,int students){
        int low = max, high = sum;
        while(low <= high){
            int mid = (low + high) / 2;
            int count = countStudent(weights,mid);
            if(count <= students){
                high = mid - 1;
            }
            else{
                low = mid + 1; 
            }
        }
        return low;
    }
    
}
