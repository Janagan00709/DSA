import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("","abc");
        System.out.println(subSeq("","abcd"));
        subSeqAscii("", "abc");
        System.out.println(subSeqAsciiret("","abcd"));
    }
    static void subseq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        } 
        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }
    static ArrayList<String> subSeq(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left=subSeq(p+ch,up.substring(1));
        ArrayList<String> right=subSeq(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    static void subSeqAscii(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeqAscii(p+ch,up.substring(1));
        subSeqAscii(p,up.substring(1));
        subSeqAscii(p+(ch+0), up.substring(1));
    }
    static ArrayList<String> subSeqAsciiret(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first=subSeqAsciiret(p+ch,up.substring(1));
        ArrayList<String> second=subSeqAsciiret(p,up.substring(1));
        ArrayList<String> third=subSeqAsciiret(p+(ch+0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
} 
