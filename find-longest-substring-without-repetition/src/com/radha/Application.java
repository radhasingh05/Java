package com.radha;

public class Application {
    public static void main(String[] args) {
        String string = "RadhaSingh AdarshKumarSingh Adi";
        System.out.println(longest(string));
    }

    private static String longest(String string) {
        try {
            if (string.contains(" ")) {
                int maxLength = 1;
                String longest = null;
                String[] strings = string.split("[ ]");
                for (int i = 0; i < strings.length; i++) {
                    if (maxLength < strings[i].length()) {
                        longest = strings[i];
                    }
                    maxLength = strings[i].length();
                }
                return longest;
            } else {
                return string;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
