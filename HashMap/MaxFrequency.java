package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxFrequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(maxFreq(str));
        sc.close();
    }
    public static int maxFreq(String str){
        String string=str.toLowerCase();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<string.length();i++){
            if(!(Character.isWhitespace(string.charAt(i)))){
                map.put(string.charAt(i),map.getOrDefault(string.charAt(i),0)+1);
            }
        }
        int maxfreq=-1;
        //char maxchar='\0';
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue()>maxfreq){
                maxfreq=entry.getValue();
                //maxchar=entry.getKey();
            }
        }
        return maxfreq;
        
        
    }
}
