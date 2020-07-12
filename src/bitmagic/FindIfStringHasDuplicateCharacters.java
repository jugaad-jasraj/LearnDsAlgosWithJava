package bitmagic;

public class FindIfStringHasDuplicateCharacters {

    /*
    This program will teach you how to set a bit in an integer,
    how to check if a bit is already set in an integer.
     */
    public static boolean findIfStringHasDuplicationCharacters(String str) {
        /*
        We are not going to use any additional data structures for this.
        Instead, we will try to use the 32 bits of the integer.
        For each character, a bit will be set in 'integerBit' variable when it is encountered in the string.
        Before adding any new character, we will check if the bit is already set. if yes, then return true for showing it as a duplicate character.
        Else set the bit in 'integerBit'
        */
        int integerBit = 0;

        for(int i=0; i<str.length(); i++){
            char characterAtPositionI = str.charAt(i);
            int bitIShouldCheckAndSet = characterAtPositionI - 'a';
            /*
            Shift 1 by 'bitIShouldCheckAndSet' by [ 'bitIShouldCheckAndSet' - 1 ] positions so we have only 1 in the first position and rest is all zeros.
            Then & it with integerBit. Since no other bit was set in the second integer we created above, & will result in 0 for all other places.
            Except the place where we are checking.
            If the & with integerBit results in non-zero, then the bit was originally set. Means a duplicate.
            Else not - so continue setting bits and checking while iterating the string characters.
            */
            boolean wasBitAlreadySet = (integerBit & (1 << bitIShouldCheckAndSet)) != 0 ? true : false;
            if(wasBitAlreadySet){
                return true;
            }
            integerBit = (1 << bitIShouldCheckAndSet) | integerBit;
        }
        return false;
    }

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests(){
        System.out.println(" 'abcdefgzsdg' contains duplicates?" +  findIfStringHasDuplicationCharacters("abcdefgzsdg"));
        System.out.println(" 'abcdefgzs' contains duplicates?" +  findIfStringHasDuplicationCharacters("abcdefgzs"));
        System.out.println(" 'aab' contains duplicates?" +  findIfStringHasDuplicationCharacters("aab"));
        System.out.println(" 'dcab' contains duplicates?" +  findIfStringHasDuplicationCharacters("dcab"));
        System.out.println(" 'helloworld' contains duplicates?" +  findIfStringHasDuplicationCharacters("helloworld"));
        System.out.println(" 'thisissomuchfun' contains duplicates?" +  findIfStringHasDuplicationCharacters("thisissomuchfun"));
    }

}
