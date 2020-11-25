package com.radha;


public class Application {
    public static void main(String[] args) {
        String[] strings = {"abcde","abcrt","abc","abd","acht"};
        String smallest = smallest(strings);
        StringBuilder result = new StringBuilder();
        for(int i=0;i<smallest.length();i++){
            int count = 0;
            char c1 = smallest.charAt(i);
           // System.out.println(c1);
            for(int j=0;j<strings.length;j++){
                if(smallest==strings[j]){
                    continue;
                }
               // System.out.println(strings[j]);
                if(c1==strings[j].charAt(i)){
                    char c = c1;
                    count ++;
                }
            }
            if(count==strings.length-1){
                result = result.append(c1);
            }

        }
        System.out.println("Longest Common prefix is :" +result);
    }

    public static String smallest(String words[]) {
        if (words == null || words.length < 1) {
            return "";
        }
        String smallest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < smallest.length()) {
                smallest = words[i];
            }
        }
        return smallest;
    }
}
