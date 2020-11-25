package com.radha;

/******
 *
 * Given a string A consisting only of lowercase characters,
 * we need to check whether it is possible to make this string a palindrome after removing exactly one character from this.
 *
 * If it is possible then return 1 else return 0.
 *
 */

public class Application {
    public static void main(String[] args) {
        String s = "ABCDBA";
        int count = 0;
        for(int i=0;i<s.length();i++){
            StringBuilder subString = new StringBuilder(s);
            subString = subString.replace(i,i+1,"");
            System.out.println(subString);
            if (palindrome(subString.toString())){
                count = 1;
                break;
            }else {
                count = 0;
            }
        }
        System.out.println(count);
    }

    static boolean palindrome(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        if (stringBuilder.reverse().toString().equalsIgnoreCase(string)) {
            return true;
        } else {
            return false;
        }
    }
}
