package Strings;

public class alphabets {
    public static void main(String[] args) {
        String series = "";
        for(int i = 0 ; i<26;i++){
            char ch = (char)('a'+i);
            series +=ch + " ";  
            // for pattern
            // System.out.println(series);
        }
        System.out.println(series); 

        String capital ="";
        for(int i=0;i<26;i++){
            // System.out.println((int)('A'));
            char capch =(char)('A'+ i);
            capital+=capch+" ";
        }
        System.out.println(capital);
    }
}
