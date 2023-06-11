package 剑指50;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 一个hashmap记录次数
    // 一个数组记录数字出现的次数
    public char firstUniqChar(String s) {
        Character[] chars = new Character[26];
        int count =0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character tmp = s.charAt(i);
            if(!map.containsKey(tmp)){
                chars[count++] = tmp;
                map.put(tmp,1);
            }else{
                map.put(tmp,map.get(tmp)+1);
            }
        }
        for(int i=0;i< count;i++){
            if(map.get(chars[i]) == 1){
                return chars[i];
            }
        }
        return ' ';
    }
}
