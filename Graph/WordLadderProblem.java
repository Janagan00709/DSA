package Graph;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class WordLadderProblem{
    static class Pair{
        String first;  // word
        int second; // level 
        Pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int wordLadderLength(String startWord, String targetWord,String[] wordList){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        set.remove(startWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(targetWord)==true){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord) == true){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        int res = wordLadderLength(startWord,targetWord,wordList);
        System.out.println(res);
    }
}
