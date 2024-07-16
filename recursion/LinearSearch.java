import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={2,3,1,4,4,5};
        System.out.println(find(arr,4,0));
        System.out.println(findIndex(arr, 4, 0));
        System.out.println(findIndexLast(arr,4, arr.length-1));
        findAllIndex(arr, 4, 0);
        System.out.println(list);
        System.out.println(findAllIndexs(arr, 4, 0, new ArrayList<>()));
        System.out.println(findAllIndexwithoutlist(arr, 4, 0));
    }
    public static boolean find(int[] arr,int target, int index){
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || find(arr, target,index+1);
    }
    public static int findIndex(int[] arr,int target, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findIndex(arr,target,index+1);
    }
    public static int findIndexLast(int[] arr,int target, int index){
        if(index == -1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return findIndexLast(arr,target,index-1);
    }
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static void findAllIndex(int[] arr,int target, int index){
        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            list.add(index);
        }
        findAllIndex(arr,target,index+1);
    }
    //Array list type
    static ArrayList<Integer> findAllIndexs(int[] arr,int target, int index,ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index); 
        }
        return findAllIndexs(arr,target,index+1,list);
    }
    //Without using arg as list
    static ArrayList<Integer> findAllIndexwithoutlist(int[] arr,int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        //This will contain answer for that function call only
        if(arr[index] == target){
            list.add(index); 
        }
        
        ArrayList<Integer> ansFromBelowCalls=findAllIndexwithoutlist(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
