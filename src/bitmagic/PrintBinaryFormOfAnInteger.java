package bitmagic;

/*
This class aims to print a given Integer in it's binary form without using Integer.toBinaryString() function.
 */
public class PrintBinaryFormOfAnInteger {

    /*
    Actual function which tries to mimic Integer.toBinaryString()
     */
    private static void printBinaryForm(int n){
        StringBuffer str = new StringBuffer("");
        for(int i=0;i<32;i++){
            // find whether a particular bit is set or not
            str.append((n & (1 << i)) !=0 ? "1" : "0");
        }
        // reverse because higher order bits always come first.
        str = str.reverse();

        //if a number starts with zero bits, those need not be shown. Below code attempts to remove leading zeros.
        int zeroIndex = str.indexOf("0");
        int oneIndex = str.indexOf("1");

        StringBuffer finalString;
        if(zeroIndex!=-1 && oneIndex!=-1){
            if(zeroIndex<oneIndex){
                finalString = new StringBuffer(str.substring(oneIndex,str.length()));
            } else {
                finalString = str;
            }
        } else {
            finalString = str;
        }

        //finally print the result.
        System.out.println(finalString);
    }

    private static void printBinaryFormCorrectly(int n){
        System.out.println(Integer.toBinaryString(n));
    }

    public static void main(String[] args){
        test();
        verify();
    }

    private static void verify(){
        printBinaryFormCorrectly(1);
        printBinaryFormCorrectly(2);
        printBinaryFormCorrectly(3);
        printBinaryFormCorrectly(10);
        printBinaryFormCorrectly(50);
        printBinaryFormCorrectly(100);
    }

    private static void test(){
        printBinaryForm(1);
        printBinaryForm(2);
        printBinaryForm(3);
        printBinaryForm(10);
        printBinaryForm(50);
        printBinaryForm(100);
    }

}
