package iteration;

import java.util.Arrays;

/*
Objective of this program is to find a continuous subArray
of a given Array arr[N]
with non-negative randomly sorted numbers
having given sum.
 */
public class SubArrayWithGivenSumNonNegative {

    private static SubArrayWithGivenSumNonNegative obj = new SubArrayWithGivenSumNonNegative();

    private class InputForSubArrayWithGivenSumNonNegative{
        private int[] arr;
        private int sum;
        public InputForSubArrayWithGivenSumNonNegative(int[] arr, int sum){
            this.arr = arr;
            this.sum = sum;
        }

        public int[] getArray(){
            return this.arr;
        }

        public int getSum(){
            return this.sum;
        }
    }

    private InputForSubArrayWithGivenSumNonNegative test1Inputs(){
        return new InputForSubArrayWithGivenSumNonNegative(new int[]{5,2,7,5,0,3,2,9}, 10);
    }

    public static void main(String[] args){
        // TODO: write tests properly
        // TODO: write more tests
        subArrayWithGivenSum(obj.test1Inputs());
    }

    public static int[] subArrayWithGivenSum(InputForSubArrayWithGivenSumNonNegative input){
        /*
        iterate 1...N till total doesnt exceed expected sum of subArray.
        If it matches, then return the subarray from 1...N
        If it exceeds, then skip a number and start again. like 2...N
        However, from 1-N and from 2-N -> it doesnt make sense to iterate all and sum again.
        So, subtract ith number from the previous sum , increment i and continue.
         */

        int interimSum = 0;
        for(int start=0, i=0; i<input.arr.length; i++){
            if(interimSum < input.sum){
                System.out.println("Current subArray:" + Arrays.toString(Arrays.copyOfRange(input.arr,start,i)));
                interimSum = interimSum + input.arr[i];
            } else if (interimSum == input.sum){
                System.out.println("Current subArray:" + Arrays.toString(Arrays.copyOfRange(input.arr,start,i)));
                return Arrays.copyOfRange(input.arr,start,i);
            } else {
                interimSum = interimSum - input.arr[start];
                interimSum = interimSum + input.arr[i];
                start++;
                System.out.println("Current subArray:" + Arrays.toString(Arrays.copyOfRange(input.arr,start,i)));
            }
        }
        return new int[]{};
    }
}
