package iteration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfStringIsPermutationOfAnother {

    private static CheckIfStringIsPermutationOfAnother obj = new CheckIfStringIsPermutationOfAnother();

    private class Input{

        private String firstString;
        private String secondString;

        public Input(String firstString, String secondString){
            this.firstString = firstString;
            this.secondString = secondString;
        }
    }

    private void test1(){
        if(Boolean.TRUE.equals(checkIfPermutation(new Input("abcdef","deacbf")))){
            System.out.println("Test1 successful");
        } else {
            System.out.println("Go check again. Something is wrong with your code.");
        }
    }

    public static void main(String[] args){
        obj.test1();
        //TODO: add more tests
    }

    private boolean checkIfPermutation(Input input){
        Map<Character,Integer> countMap = new HashMap<>();
        for(char c: input.firstString.toCharArray()){
            if(countMap.containsKey(c)){
                countMap.put(c,countMap.get(c)+1);
            } else {
                countMap.put(c,1);
            }
        }
        System.out.println("First map:" + countMap.entrySet());

        for(char c: input.secondString.toCharArray()){
            if(countMap.containsKey(c)){
                countMap.put(c,countMap.get(c)-1);
            } else {
                return false;
            }
        }
        System.out.println("Second map:" + countMap.entrySet());

        Set<Integer> valueSet = new HashSet<>();
        valueSet.addAll(countMap.values());
        if((!valueSet.contains(0)) || valueSet.size()>1){
            return false;
        }
        return true;
    }

}
