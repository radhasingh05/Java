package com.radha;

import com.google.common.primitives.Chars;

import java.util.regex.Pattern;

/*****************************
 *
 *  You are given a string S, and you have to find all the amazing substrings of S.
 *
 *  Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *  Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 * 	Amazing substrings of given string are :
 * 	1. A
 * 	2. AB
 * 	3. ABE
 * 	4. ABEC
 * 	5. E
 * 	6. EC
 * 	here number of substrings are 6 and 6 % 10003 = 6.
 *
 * ***************************
 */
public class Application {
    public static void main(String[] args) {
        String string = "ABEC";
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        int count = 0;
        int result = 0;
        if(Pattern.compile("[aeiouAEIOU]").matcher(string).find()){
            System.out.println(string);
            for(int i=0;i<string.length();i++){

                System.out.println(string.charAt(i));
                // n-p (total number of char - position of vowels
                if(Chars.contains(vowels,string.charAt(i))){
                    count = string.length()-string.indexOf(string.charAt(i));
                    result = result+count;
                }

            }
        }else{
            System.out.println("String don't have vowels");
        }
        System.out.println("here number of substrings are : " + result);

    }
}
