package com.radha;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String string = "abcabcradha singh adarsh";
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i<string.length();i++){
            if(map.get(string.charAt(i)) != null){
                map.put(string.charAt(i),map.get(string.charAt(i))+1);
            }else{
                map.put(string.charAt(i),1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append(entry.getValue());
        }
        System.out.println(stringBuilder.toString());

    }
}
