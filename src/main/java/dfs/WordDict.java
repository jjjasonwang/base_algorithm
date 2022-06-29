package dfs;

import java.util.ArrayList;
import java.util.List;

public class WordDict {


    private static boolean dfs(String rightStr, List<String> words){
        if(rightStr.length() == 0){
            return true;
        }

        String temp = "";
        for(int i = 1; i <= rightStr.length(); i++){
            temp = rightStr.substring(0,i);
            if(words.contains(temp)){
                if (dfs(rightStr.substring(i,rightStr.length()),words)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("aaaa");
        words.add("aaa");
        System.out.println(dfs("aaaaaaa",words));
    }


}
