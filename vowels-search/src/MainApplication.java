public class MainApplication {

    public static void main(String[] args) {

        System.out.println(firstVowelSearch("Radha Umraosingh"));
        System.out.println("allVowelsInString : "+allVowelsInString("Adarsh Kumar Singh"));

    }

    public static char firstVowelSearch(String s){  // Radha Umraosingh
        char[] chars = new char[]{'A','E','I','O','U'};
        char[] chars1 = s.toUpperCase().toCharArray();
        System.out.println("String :"+s);
        for(int i=0;i<s.length();i++){

            for (int j=0;j<chars.length;j++){
                if(chars[j] == chars1[i]) {
                    return chars1[i];
                }
            }
        }
        return ' ';
    }

    public static char[] allVowelsInString(String s){  // Adarsh Kumar Singh
        char[] chars = new char[]{'A','E','I','O','U'};
        char[] chars1 = s.toUpperCase().toCharArray();
        char[] result = new char[s.length()];
        System.out.println("String :"+s);
        for(int i=0;i<s.length();i++){
            int k=0;
            for (int j=0;j<chars.length;j++){
                if(chars[j] == chars1[i]) {
                    result[k] = chars1[i];
                    System.out.println(result[k]);
                    k++;
                }
            }
        }
        return result;
    }


}
