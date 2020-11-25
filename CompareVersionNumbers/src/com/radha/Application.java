package com.radha;

/********
 *
 *  Compare two version numbers version1 and version2.
 *
 *  If version1 > version2 return 1,
 *  If version1 < version2 return -1,
 *  otherwise return 0.
 *  0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */

public class Application {
    public static void main(String[] args) {
        String v1 = "1.23.2";
        String v2 = "1.23.5";

        if (Integer.parseInt(v1.replace(".","")) > Integer.parseInt(v2.replace(".",""))){
            System.out.println(1);
        }else{
            System.out.println(-1);
        }

    }
}
