package Search;

public class SplitArray {
    public static void main(String[] args) {
        
    }
    public int splitArray(int[] nums, int m) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            start= Math.max(start,nums[i]);
            end=end+nums[i];
        }
        while(start < end){
            //try for the middle as potential ans
            int mid= start+(end-start)/2;
            int sum=0;
            int pieces=1;
            for(int num: nums){
                if(sum+num> mid){
                    // you cannot add this in this subarray , make new one
                    // say you add this num in new subarray, then sum =num
                    sum = num;
                    pieces++;
                }else{
                    sum = sum+num;
                }
            }
            if(pieces > m){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start; //or end both are equal
    }
}
