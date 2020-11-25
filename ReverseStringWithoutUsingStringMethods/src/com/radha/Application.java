package com.radha;

public class Application {
    public static void main(String[] args) {
        String string = "java";
        System.out.println(reverse(string));
        System.out.println(reverse(string,true));
    }

    private static String reverse(String string) {
        if (!string.isEmpty() || string != null){
            StringBuilder stringBuilder = new StringBuilder(string);
            return stringBuilder.reverse().toString();
        }
        return null;
    }

    private static String reverse(String string , boolean withOutReverseMethod) {

        if (withOutReverseMethod && (!string.isEmpty() || string != null)){
            String reverseString = "";

            for(int i=string.length()-1;i>=0 ; i--){
                reverseString += string.charAt(i);
            }
            return reverseString;
        }
        return null;
    }

}
