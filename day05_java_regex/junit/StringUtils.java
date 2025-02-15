package day05_java_regex.junit;

public class StringUtils {
    //Method to reverse the string
    public static String reverse(String str){
        String reStr = "";
        for(int i=str.length()-1; i>=0; i--){
            reStr += str.charAt(i);
        }
        return reStr;
    }

    //Method to check string are palidrome
    public static boolean isPalindrome(String str){
        String reStr = "";
        for(int i=str.length()-1; i>=0; i--){
            reStr += str.charAt(i);
        }
        return reStr.equals(str);
    }

    //Method to convert in small to upper case
    public static String toUpperCase(String str){
        return str.toUpperCase();
    }
}
