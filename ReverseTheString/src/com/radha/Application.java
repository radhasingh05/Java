package com.radha;


public class Application {
    public static void main(String[] args) {

        String string = "This is Radha ";
        int spacesCount = string.length() - string.replaceAll(" ", "").length();
        String result = "";
        String word = "";

        for (int i=0;i<spacesCount;i++){

            try {
                word = string.substring(0, string.indexOf(" "));
                string = string.replace(word, "").trim();
            }catch(StringIndexOutOfBoundsException e){
                word = string.substring(0, string.length());
                string = string.replace(word, "").trim();
            }

            result = word+" "+ result ;

        }
        System.out.println(result);


    }
}
