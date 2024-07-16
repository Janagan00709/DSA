public class binarySearch {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,55,66,78};
        int target=4;
        System.out.println(search(arr, target, 0,arr.length));
    }
    static int search(int[] arr,int target,int s,int e){
        //int s=0; int e=arr.length-1; // To use the recursion, we can put into the parameter
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(target<arr[m]){
            search(arr,target,s,m-1);
        }
        return search(arr, target, m+1, e);
    }
}
