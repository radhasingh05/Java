package com.radha;

public class Application {
    public static void main(String[] args) {
      //  String string = "A man, a plan, a canal: Panama";
        String string = "race a car";
        String result = string.replaceAll("[^a-zA-Z]", "");
        StringBuilder stringBuilder = new StringBuilder(result);
//        System.out.println(result);
//        System.out.println(stringBuilder);
//        System.out.println(stringBuilder.reverse());
        if (stringBuilder.reverse().toString().equalsIgnoreCase(result)) {
            System.out.println("String : " + string + " is a Palindrome ");
        } else {
            System.out.println("String : " + string + " is not a Palindrome ");
        }
    }
}
