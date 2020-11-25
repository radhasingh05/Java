package com.radha;

public class Application {
    public static void main(String[] args) {
        // Using 3rd variable
        Integer x = 123;
        Integer y = 456;
        System.out.println("Before Swap X : "+ x +" Y :"+ y);
        Integer temp;
        temp = x;
        x = y;
        y= temp;
        System.out.println("After Swap X : "+ x +" Y :"+ y);
        // without using 3rd variable
        x = 123;
        y = 456;

        x = x + y ;
        y = x - y ;
        x = x - y ;

        System.out.println("After Swap with out temp variable X : "+x +" Y : "+y);

    }


}
