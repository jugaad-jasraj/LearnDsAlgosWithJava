package iteration;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    private static boolean isPermutationOfPalindrome(String input){
        /*
        If string has even number of characters, everything needs to be in multiples of two.
        If string has odd number of characters, everything needs to be in multiples of two EXCEPT one character - which needs to be single (count = 1).
         */

        Map<Character, Integer> countMap = new HashMap<>();
        for(char c: input.toCharArray()){
            if(countMap.containsKey(c)){
                int value = countMap.get(c);
                countMap.put(c,value+1);
            } else {
                countMap.put(c,1);
            }
        }

        // check values
        if(input.length()%2==0){
            // even
            for(int i: countMap.values()){
                if(i%2!=0){
                    return false;
                }
            }
            return true;
        } else {
            // odd
            boolean oneUnique = false;
            for(int i: countMap.values()){
                if(i%2!=0){
                    if(oneUnique == false) {
                        oneUnique = true;
                    } else {
                        return false;
                    }
                } else {
                    continue;
                }
            }

            if(oneUnique == true){
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args){
        System.out.println("a2bca1bc12 is " + isPermutationOfPalindrome("a2bca1bc12"));
        System.out.println("hello is " + isPermutationOfPalindrome("hello"));
        System.out.println("trerte is " + isPermutationOfPalindrome("trerte"));
    }

}
