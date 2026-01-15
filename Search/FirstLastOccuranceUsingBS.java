package Search;


class FirstLastOccuranceUsingBS {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,8,8,8,10};
        int target = 8;
        System.out.println("First Occurance: " +BinarySearchFirst(arr,target));
        System.out.println("Last Occurance: " +BinarySearchLast(arr,target));
        System.out.println("Using Lower bound and Upper Bound");
        int lb = LowerBound(arr,target);
        if(lb == arr.length || arr[lb] != target){
            System.out.println("Element not found");
        }else{
            System.out.println("First Occurance: " + lb);
            System.out.println("Last Occurance: " + (UpperBound(arr,target)-1));
        }

    }
    public static int BinarySearchFirst(int[] arr,int target){
        int low = 0 ;
        int high = arr.length - 1;
        int first = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                first = mid;
                high = mid - 1;
            }else if(arr[mid] < target){
                low = mid + 1;    
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }
    public static int BinarySearchLast(int[] arr,int target){
        int low = 0 ;
        int high = arr.length - 1;
        int last = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
    public static int LowerBound(int[] arr,int target){
        int low = 0 ;
        int high = arr.length - 1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int UpperBound(int[] arr,int target){
        int low = 0 ;
        int high = arr.length - 1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid]>target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
